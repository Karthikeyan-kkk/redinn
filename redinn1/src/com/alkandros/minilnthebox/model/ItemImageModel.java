package com.alkandros.minilnthebox.model;

import java.io.Serializable;


//Get Item.. Component
public class ItemImageModel implements Serializable {
	
	
	
	private String id="";
	private String item_image="";
	private String item_id="";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItem_image() {
		return item_image;
	}
	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	
	 
	
	
	

}
