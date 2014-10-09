package com.alkandros.minilnthebox.model;

import java.io.Serializable;

public class SlideNavigationModel implements Serializable {
	
	
	private String id="";
	private int count;
	private String image="";
	private String name="";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
