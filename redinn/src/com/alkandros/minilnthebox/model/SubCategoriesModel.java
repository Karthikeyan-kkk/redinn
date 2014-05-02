package com.alkandros.minilnthebox.model;

import java.io.Serializable;

public class SubCategoriesModel implements Serializable {
	
	
	private String  id="";
	private String  image="";
	private String  name="";
	
	private boolean isCategory=false;
	
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
	public boolean isCategory() {
		return isCategory;
	}
	public void setCategory(boolean isCategory) {
		this.isCategory = isCategory;
	}
	
	
	
	
}
