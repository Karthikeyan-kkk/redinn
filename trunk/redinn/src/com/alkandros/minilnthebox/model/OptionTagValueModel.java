package com.alkandros.minilnthebox.model;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionTagValueModel implements Serializable{
	
	

	
	
	
	private String  option_id="";
	private String option_Name="";


	private ArrayList<String> tagIds=new ArrayList<String>();
	private ArrayList<String>  tag_Names=new ArrayList<String>();
	public String getOption_id() {
		return option_id;
	}
	public void setOption_id(String option_id) {
		this.option_id = option_id;
	}
	public String getOption_Name() {
		return option_Name;
	}
	public void setOption_Name(String option_Name) {
		this.option_Name = option_Name;
	}
	public ArrayList<String> getTagIds() {
		return tagIds;
	}
	public void setTagIds(String tagIds) {
		this.tagIds.add(tagIds);
	}
	public ArrayList<String> getTag_Names() {
		return tag_Names;
	}
	public void setTag_Names(String tag_Names) {
		this.tag_Names.add(tag_Names);
	}
	
	
	
	

}
