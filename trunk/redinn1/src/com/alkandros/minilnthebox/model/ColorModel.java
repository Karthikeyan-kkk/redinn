package com.alkandros.minilnthebox.model;

import java.io.Serializable;

public class ColorModel implements Serializable{
	

	   private String id="";
		private String color="";
		private String color_code="";
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getColor_code() {
			return color_code;
		}
		public void setColor_code(String color_code) {
			this.color_code = color_code;
		}
	
	

}
