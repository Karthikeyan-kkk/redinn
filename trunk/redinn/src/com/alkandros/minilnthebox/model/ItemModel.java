package com.alkandros.minilnthebox.model;

import java.io.Serializable;
//Get Item.. Component
public class ItemModel implements Serializable {

	
	private String id="";
	private String name="";
	private String description="";
	private String short_description="";
	private String totalstock="";
	private String bar_code="";
	private String weight="";
	private String collection_id="";
	private String category_id="";
	private boolean isfeatured;
	private boolean isnew;
	private String date="";
	private boolean onsale;
	private String rating="";
	private String sold_count="";
	private String meta_description="";
	private String meta_tags="";
	private String page_title="";
	private String label_id="";
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public String getTotalstock() {
		return totalstock;
	}
	public void setTotalstock(String totalstock) {
		this.totalstock = totalstock;
	}
	public String getBar_code() {
		return bar_code;
	}
	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getCollection_id() {
		return collection_id;
	}
	public void setCollection_id(String collection_id) {
		this.collection_id = collection_id;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public boolean isIsfeatured() {
		return isfeatured;
	}
	public void setIsfeatured(boolean isfeatured) {
		this.isfeatured = isfeatured;
	}
	public boolean isIsnew() {
		return isnew;
	}
	public void setIsnew(boolean isnew) {
		this.isnew = isnew;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isOnsale() {
		return onsale;
	}
	public void setOnsale(boolean onsale) {
		this.onsale = onsale;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSold_count() {
		return sold_count;
	}
	public void setSold_count(String sold_count) {
		this.sold_count = sold_count;
	}
	public String getMeta_description() {
		return meta_description;
	}
	public void setMeta_description(String meta_description) {
		this.meta_description = meta_description;
	}
	public String getMeta_tags() {
		return meta_tags;
	}
	public void setMeta_tags(String meta_tags) {
		this.meta_tags = meta_tags;
	}
	public String getPage_title() {
		return page_title;
	}
	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}
	public String getLabel_id() {
		return label_id;
	}
	public void setLabel_id(String label_id) {
		this.label_id = label_id;
	}
	
	
	
	
	
	
}
