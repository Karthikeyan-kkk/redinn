package com.alkandros.minilnthebox.model;

import java.io.Serializable;

public class CurrencyModel implements Serializable{
	

	private String curr_id="";
	private String symbol="";
	private String short_code="";
	public String getCurr_id() {
		return curr_id;
	}
	public void setCurr_id(String curr_id) {
		this.curr_id = curr_id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getShort_code() {
		return short_code;
	}
	public void setShort_code(String short_code) {
		this.short_code = short_code;
	}
	
	
	
	
	
	

}
