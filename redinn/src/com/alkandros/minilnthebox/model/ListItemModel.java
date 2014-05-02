package com.alkandros.minilnthebox.model;

import java.io.Serializable;
import java.util.Comparator;

//Get Item.. Component
public class ListItemModel implements Serializable, Comparator<ListItemModel> {
	
	
	 public enum SortOrder {ASCENDING, DESCENDING}
	 
	 private SortOrder sortOrder;

	private String id = "";
	private String name = "";
	private String totalstock = "";
	private String rating = "";

	private boolean isfeatured;
	private boolean isnew;
	private String item_image = "";

	private PriceModel model = new PriceModel();
	
	 public ListItemModel(SortOrder sortOrder) {
		    this.sortOrder = sortOrder;
		  }

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

	public String getTotalstock() {
		return totalstock;
	}

	public void setTotalstock(String totalstock) {
		this.totalstock = totalstock;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
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

	public String getItem_image() {
		return item_image;
	}

	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}

	public PriceModel getPriceModel() {
		return model;
	}

	public void setPriceModel(PriceModel model) {
		this.model = model;
	}

	

	@Override
	public int compare(ListItemModel arg0, ListItemModel arg1) {
		
		 Integer model1 = Integer.parseInt(arg0.getPriceModel().getPrice());
		    Integer model2 = Integer.parseInt(arg1.getPriceModel().getPrice());
		    int compare = (int) Math.signum(model1.compareTo(model2));

		    if (sortOrder == SortOrder.ASCENDING) {
		      return compare;
		    } else {
		      return compare * (-1);
		    }
	}

}
