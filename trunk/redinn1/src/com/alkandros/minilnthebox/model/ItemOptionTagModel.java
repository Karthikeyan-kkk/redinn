package com.alkandros.minilnthebox.model;

import java.io.Serializable;

public class ItemOptionTagModel implements Serializable{
	
	
	   private String id="";
		private String item_id="";
		private String tag_id="";
		private String option_id="";
		
		private OptionModel optionModel=new OptionModel();
		
		private TagModel tagModel=new TagModel();

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getItem_id() {
			return item_id;
		}

		public void setItem_id(String item_id) {
			this.item_id = item_id;
		}

		public String getTag_id() {
			return tag_id;
		}

		public void setTag_id(String tag_id) {
			this.tag_id = tag_id;
		}

		public String getOption_id() {
			return option_id;
		}

		public void setOption_id(String option_id) {
			this.option_id = option_id;
		}

		public OptionModel getOptionModel() {
			return optionModel;
		}

		public void setOptionModel(OptionModel optionModel) {
			this.optionModel = optionModel;
		}

		public TagModel getTagModel() {
			return tagModel;
		}

		public void setTagModel(TagModel tagModel) {
			this.tagModel = tagModel;
		}
		
		
	
	
		

}
