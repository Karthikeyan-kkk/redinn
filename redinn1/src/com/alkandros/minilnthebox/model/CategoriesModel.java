package com.alkandros.minilnthebox.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoriesModel implements Serializable {
	
	
	private String  id="";
	private String  image="";
	private String  name="";
	
	private boolean isCategory=true;
	
	private ArrayList<SubCategoriesModel> subCategoriesModels=new ArrayList<SubCategoriesModel>();
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
	public ArrayList<SubCategoriesModel> getSubCategoriesModels() {
		return subCategoriesModels;
	}
	public void setSubCategoriesModels(
			ArrayList<SubCategoriesModel> subCategoriesModels) {
		this.subCategoriesModels = subCategoriesModels;
	}
	public boolean isCategory() {
		return isCategory;
	}
	public void setCategory(boolean isCategory) {
		this.isCategory = isCategory;
	}
	
	
	
	
}
