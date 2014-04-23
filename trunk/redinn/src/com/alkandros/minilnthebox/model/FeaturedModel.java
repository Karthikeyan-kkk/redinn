package com.alkandros.minilnthebox.model;

import java.io.Serializable;

public class FeaturedModel implements Serializable{
	
	private String id="";
	private String image="";
	private String description="";
	private String name="";
	

  // private PriceModel priceModel=new PriceModel();
    	 
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public PriceModel getPriceModel() {
		return priceModel;
	}
	public void setPriceModel(PriceModel priceModel) {
		this.priceModel = priceModel;
	}*/
	
	
	
	
	
	
	
	
}
