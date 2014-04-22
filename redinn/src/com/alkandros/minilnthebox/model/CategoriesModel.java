package com.alkandros.minilnthebox.model;

import java.io.Serializable;

public class CategoriesModel implements Serializable {
	
	
	private String  id="";
	private String  image="";
	private String  name="";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
