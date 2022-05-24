package com.desafiolatam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="usersIMDb_shows")
public class UsersIMDbShows {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//ManyToMany = 2 ManyToOne
	//1 ManyToOne FK
	@JsonBackReference
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "userIMDb_id")
	private UserIMDb userIMDb;
	
	//2 ManyToOne FK
	@JsonBackReference //Se coloca donde está la FK
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "show_id")
	private Show show;
	
	private Rating rating;
	
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
	public UsersIMDbShows() {
		super();
	}
	public UsersIMDbShows(UserIMDb userIMDb, Show show, Rating rating) {
		super();
		this.userIMDb = userIMDb;
		this.show = show;
		this.rating = rating;
	}
	public UsersIMDbShows(Long id, UserIMDb userIMDb, Show show, Rating rating, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.userIMDb = userIMDb;
		this.show = show;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserIMDb getUserIMDb() {
		return userIMDb;
	}
	public void setUserIMDb(UserIMDb userIMDb) {
		this.userIMDb = userIMDb;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
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
		return "UsersIMDbShows [id=" + id + ", userIMDb=" + userIMDb + ", show=" + show + ", rating=" + rating + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
		
}
