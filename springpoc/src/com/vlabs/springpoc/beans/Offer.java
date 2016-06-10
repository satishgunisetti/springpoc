package com.vlabs.springpoc.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Offer {
	private int id;
	
	@NotNull
	@Size(min=5, max=20, message="Name must be between 5 and 20 characters")
	private String name;
	
	@NotNull
	@Pattern(regexp=".*\\@.*\\..*", message="Invalid email")
	private String email;
	
	@Size(min=5, max=100, message="Offer must be between 5 and 20 characters")
	private String text;

	public Offer(){
		
	}
	public Offer(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}

}
