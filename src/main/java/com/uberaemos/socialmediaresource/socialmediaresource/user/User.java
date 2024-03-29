package com.uberaemos.socialmediaresource.socialmediaresource.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id	@GeneratedValue
	private long id;

	@Size(min=2, message="Name should be 2 characters minimum")
	private String name;

	@Past(message = "Birth date should be a past date")
	private Date birthDate;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;

	protected User() {}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Long getId() {return id;}
	public void setId(Long id) {	this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Date getBirthDate() {return birthDate;}
	public void setBirthDate(Date birthDate) {this.birthDate = birthDate;}
	public List<Post> getPosts() {return posts;	}
	public void setPosts(List<Post> posts) {this.posts = posts;	}
	
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}
}