package com.alkandros.minilnthebox.model;

import java.io.Serializable;

public class ItemSizeColorModel implements Serializable{
	
	
	
	 
    private String id="";
	private String color_id="";
	private String size_id="";
	private String item_id="";
	private String total="";
	private String instock="";
	
	private SizeModel sizeModel=new SizeModel();
	
	private ColorModel colorModel=new ColorModel();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColor_id() {
		return color_id;
	}

	public void setColor_id(String color_id) {
		this.color_id = color_id;
	}

	public String getSize_id() {
		return size_id;
	}

	public void setSize_id(String size_id) {
		this.size_id = size_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getInstock() {
		return instock;
	}

	public void setInstock(String instock) {
		this.instock = instock;
	}

	public SizeModel getSizeModel() {
		return sizeModel;
	}

	public void setSizeModel(SizeModel sizeModel) {
		this.sizeModel = sizeModel;
	}

	public ColorModel getColorModel() {
		return colorModel;
	}

	public void setColorModel(ColorModel colorModel) {
		this.colorModel = colorModel;
	}
	
	
	

}
