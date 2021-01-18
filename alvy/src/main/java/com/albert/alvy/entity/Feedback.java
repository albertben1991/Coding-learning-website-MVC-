package com.albert.alvy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback

{

	private String name;
	@Id
	private String email;
	private String message;
	private int regarding;
	private String code;
	private int rating;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRegarding() {
		return regarding;
	}

	public void setRegarding(int regarding) {
		this.regarding = regarding;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [name=" + name + ", email=" + email + ", message=" + message + ", regarding=" + regarding
				+ ", code=" + code + ", rating=" + rating + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getMessage()=" + getMessage() + ", getRegarding()=" + getRegarding() + ", getCode()=" + getCode()
				+ ", getRating()=" + getRating() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
