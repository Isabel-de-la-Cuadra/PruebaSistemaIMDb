package com.desafiolatam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="roles")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=4, max=50, message = "El mínimo de caracteres es 4 y el máximo, de 50")
	private String name;
	
	@ManyToMany(mappedBy ="roles",fetch=FetchType.LAZY)
	private List<UserIMDb> userIMDbs;

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
	public Rol() {
		super();
	}
	public Rol(
			@NotNull @Size(min = 4, max = 50, message = "El mínimo de caracteres es 4 y el máximo, de 50") String name,
			List<UserIMDb> userIMDbs) {
		super();
		this.name = name;
		this.userIMDbs = userIMDbs;
	}
	public Rol(Long id,
			@NotNull @Size(min = 4, max = 50, message = "El mínimo de caracteres es 4 y el máximo, de 50") String name,
			List<UserIMDb> userIMDbs, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.userIMDbs = userIMDbs;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserIMDb> getUsersIMDb() {
		return userIMDbs;
	}
	public void setUsersIMDb(List<UserIMDb> userIMDbs) {
		this.userIMDbs = userIMDbs;
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
		return "Rol [id=" + id + ", name=" + name + ", usersIMDb=" + userIMDbs + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
       
}
