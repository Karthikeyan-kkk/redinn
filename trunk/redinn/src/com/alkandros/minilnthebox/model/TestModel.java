package com.alkandros.minilnthebox.model;

import java.io.Serializable;

public class TestModel implements Serializable{
	
	
	private String name="";
	
	private String image="";
	
	private String count="";
	
	private String rating="";
	
	private String desc="";
	
	
	public TestModel(String name,String image) {
		this.name=name;
		this.image=image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	

}
