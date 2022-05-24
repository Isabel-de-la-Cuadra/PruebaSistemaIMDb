package com.desafiolatam.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Show;
import com.desafiolatam.services.ShowService;

@Controller
@RequestMapping("/show")
public class ShowController {

	@Autowired
	ShowService showService;
	
	@RequestMapping("/add")
	public String showCreateNew(@ModelAttribute("show") Show show) {
		return "views/new.jsp";
	}
	
	@PostMapping("/add")
	public String createNewShow(@Valid @ModelAttribute("show")Show show, BindingResult result, 
			Model model, RedirectAttributes redirectAttributes) {
		if(!result.hasErrors()) {
			Show showFound = showService.findByShowTittle(show.getShowTittle());
			if(showFound == null) {
				showService.saveShow(show);
				redirectAttributes.addFlashAttribute("msgOk","Show created");
				return "redirect:/homes";
			}else {
				redirectAttributes.addFlashAttribute("msgOk","The show already exists");
				return "redirect:/homes";
			}
		}else {
			redirectAttributes.addFlashAttribute("msgError","Sorry, missing information");
			return "views/new.jsp";
		}
	}
	
	@RequestMapping("/list")
	public String listShow(@ModelAttribute("show") Show show, Model model, Pageable pageable,
			@RequestParam Map<String, Object>params) {
		
		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) -1) : 0;
		PageRequest pageRequest = PageRequest.of(page, 3);
		Page<Show> pages = showService.getPage(pageRequest);
		System.out.println("pages " + pages);
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		model.addAttribute("listShows", pages.getContent());
		
		return "views/show.jsp";
	}
	
	
	@RequestMapping("/delete/{id}")
	public String deleteShow(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		showService.deleteByIdShow(id);
		redirectAttributes.addFlashAttribute("msgOk","The show was deleted");
		return "views/home.jsp";
	}
	
	@RequestMapping("/edit/{id}")
	public String editShow(@PathVariable("id") Long id, Model model) {
		Show show = showService.findByIdShow(id);
		model.addAttribute("show", show);
		return "views/edit.jsp";
	}
	
	@PostMapping("/update")
	public String updateShow(@Valid @ModelAttribute("show") Show show, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
		if(!result.hasErrors()) {
			showService.saveShow(show);
			redirectAttributes.addFlashAttribute("msgOk","The show was modified");
			return "views/home.jsp";
		}else {
			redirectAttributes.addFlashAttribute("msgError","Sorry, missing information");
			return "views/edit.jsp";
		}
	}
	
}
