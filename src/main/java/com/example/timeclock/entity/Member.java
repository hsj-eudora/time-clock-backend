package com.example.timeclock.entity;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "member")   
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, unique = true) 
	private String email;
	
	@OneToMany(mappedBy = "member")
	private List<ProjectType>projectTypes;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ProjectType> getProjectTypes() {
		return projectTypes;
	}

	public void setProjectTypes(List<ProjectType> projectTypes) {
		this.projectTypes = projectTypes;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", projectTypes=" + projectTypes + "]";
	}

}
