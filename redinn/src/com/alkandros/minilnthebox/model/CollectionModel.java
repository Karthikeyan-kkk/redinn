package com.alkandros.minilnthebox.model;

import java.io.Serializable;


//Get Item.. Component
public class CollectionModel implements Serializable{
	
	

	
	private String id="";
	private String name="";
	private String collection_image="";
	private String one_liner="";
	private String sale_status="";
	private boolean enable;
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
	public String getCollection_image() {
		return collection_image;
	}
	public void setCollection_image(String collection_image) {
		this.collection_image = collection_image;
	}
	public String getOne_liner() {
		return one_liner;
	}
	public void setOne_liner(String one_liner) {
		this.one_liner = one_liner;
	}
	public String getSale_status() {
		return sale_status;
	}
	public void setSale_status(String sale_status) {
		this.sale_status = sale_status;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	
	

}
