package com.desafiolatam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="usersIMDb")
public class UserIMDb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=4, max=20, message = "El mínimo de caracteres es 4 y el máximo, de 20")
	private String username;
	
	@NotNull
	@Size(min=6, max=20, message = "El mínimo de caracteres es 6")
	private String email;
	
	@NotNull
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	@ManyToMany(fetch = FetchType.EAGER) // join
	@JoinTable(name = "roles_usersIMDb", joinColumns = @JoinColumn(name = "userIMDb_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private List<Rol> roles;

	@JsonBackReference //Se coloca donde no está la FK
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name="usersIMDb_shows",
	joinColumns = @JoinColumn(name = "userIMDb_id"),
	inverseJoinColumns = @JoinColumn(name="show_id")
	)
	private List<Show> listShows;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt; 
	
	@PrePersist
	protected void onCreate(){
	this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	this.updatedAt = new Date();
	}
	public UserIMDb() {
		super();
	}
	public UserIMDb(
			@NotNull @Size(min = 4, max = 20, message = "El mínimo de caracteres es 4 y el máximo, de 20") String username,
			@NotNull @Size(min = 6, max = 20, message = "El mínimo de caracteres es 6") String email,
			@NotNull String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public UserIMDb(Long id,
			@NotNull @Size(min = 4, max = 20, message = "El mínimo de caracteres es 4 y el máximo, de 20") String username,
			@NotNull @Size(min = 6, max = 20, message = "El mínimo de caracteres es 6") String email,
			@NotNull String password, String passwordConfirmation, List<Rol> roles, List<Show> listShows,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.roles = roles;
		this.listShows = listShows;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	public List<Show> getListShows() {
		return listShows;
	}
	public void setListShows(List<Show> listShows) {
		this.listShows = listShows;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
		
}
