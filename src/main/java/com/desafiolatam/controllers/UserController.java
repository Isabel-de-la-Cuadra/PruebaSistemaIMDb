package com.desafiolatam.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafiolatam.models.UserIMDb;
import com.desafiolatam.services.UserIMDbService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	UserIMDbService userIMDbService;
	
	@RequestMapping("/register")
	public String register(Model model, @ModelAttribute("userIMDb") UserIMDb userIMDb) {
		//model.addAttribute("titulo", "Mi pagina");
		return "/views/registration.jsp";
	}
	
	@PostMapping("/register")
	public String form(@Valid @ModelAttribute("userIMDb") UserIMDb userIMDb,
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("msgError", "You must fill all the fields");
			return "/views/registration.jsp";
		}else {
			boolean resultado = userIMDbService.saveUserIMDb(userIMDb);
			if(resultado) {
				return "redirect:/userIMDb/login";
			}else {
				model.addAttribute("msgError", "The email already exists");
				return "/views/registration.jsp";
			}
		}
	}
	
	 // 1
    @RequestMapping("/userIMDb/login")
    public String login(@RequestParam(value="error", required=false) String error, 
    		@RequestParam(value="logout", required=false) String logout, 
    		Model model) {
 
        if(error != null) {
            model.addAttribute("msgError", "Invalid credentials, please try again");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout done!");   
        }
        return "/views/login.jsp";
    }
    
    @RequestMapping(value = {"/","/homes"})
    public String home(Principal principal, HttpSession session) {
        // 1
        String userIMDbEmail = principal.getName();
        session.setAttribute("userIMDbEmail", userIMDbEmail);
        return "/views/home.jsp";
    }
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/userIMDb/login";
	}
	
}