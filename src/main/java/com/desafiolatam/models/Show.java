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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="shows")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=4, max=50, message = "El mínimo de caracteres es 4 y el máximo, de 50")
	private String showTittle;
	
	@NotNull
	@Size(min=1, max=20, message = "El mínimo de caracteres es 1")
	private String showNetwork;
	
	@JsonIgnore 
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name="usersIMDb_shows",
		joinColumns = @JoinColumn(name = "show_id"),
		inverseJoinColumns = @JoinColumn(name="userIMDb_id")
		) 
	private List<UserIMDb> listUsersIMDb;
		
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate(){
	this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
	this.updatedAt = new Date();
	}

	public Show() {
		super();
	}

	public Show(
			@NotNull @Size(min = 4, max = 50, message = "El mínimo de caracteres es 4 y el máximo, de 50") String showTittle,
			@NotNull @Size(min = 1, max = 20, message = "El mínimo de caracteres es 1") String showNetwork,
			List<UserIMDb> listUsersIMDb) {
		super();
		this.showTittle = showTittle;
		this.showNetwork = showNetwork;
		this.listUsersIMDb = listUsersIMDb;
	}

	public Show(Long id,
			@NotNull @Size(min = 4, max = 50, message = "El mínimo de caracteres es 4 y el máximo, de 50") String showTittle,
			@NotNull @Size(min = 1, max = 20, message = "El mínimo de caracteres es 1") String showNetwork,
			List<UserIMDb> listUsersIMDb, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.showTittle = showTittle;
		this.showNetwork = showNetwork;
		this.listUsersIMDb = listUsersIMDb;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShowTittle() {
		return showTittle;
	}

	public void setShowTittle(String showTittle) {
		this.showTittle = showTittle;
	}

	public String getShowNetwork() {
		return showNetwork;
	}

	public void setShowNetwork(String showNetwork) {
		this.showNetwork = showNetwork;
	}

	public List<UserIMDb> getListUsersIMDb() {
		return listUsersIMDb;
	}

	public void setListUsersIMDb(List<UserIMDb> listUsersIMDb) {
		this.listUsersIMDb = listUsersIMDb;
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

	@Override
	public String toString() {
		return "Show [id=" + id + ", showTittle=" + showTittle + ", showNetwork=" + showNetwork + ", listUsersIMDb="
				+ listUsersIMDb + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
