package com.alkandros.minilnthebox.model;

import java.io.Serializable;


//Get Item.. Component
public class CategoryModel implements Serializable{
	
	
	private String id="";
	private String name="";
	private String image_path="";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	
	
	
	
	

}
