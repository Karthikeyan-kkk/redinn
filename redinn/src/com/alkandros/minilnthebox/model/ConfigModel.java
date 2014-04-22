package com.alkandros.minilnthebox.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ConfigModel implements Serializable {

	
	
	private CurrencyModel currencyModel;
	
	private ImagePrefixModel imagePrefixModel;
	
	private ArrayList<SlideShowModel> slideShowModels=new ArrayList<SlideShowModel>();
	private ArrayList<FeaturedModel> featuredModels=new ArrayList<FeaturedModel>();
	private ArrayList<CategoriesModel> categoriesModels=new ArrayList<CategoriesModel>();
	

	public CurrencyModel getCurrencyModel() {
		return currencyModel;
	}

	public void setCurrencyModel(CurrencyModel currencyModel) {
		this.currencyModel = currencyModel;
	}

	public ImagePrefixModel getImagePrefixModel() {
		return imagePrefixModel;
	}

	public void setImagePrefixModel(ImagePrefixModel imagePrefixModel) {
		this.imagePrefixModel = imagePrefixModel;
	}

	public ArrayList<SlideShowModel> getSlideShowModels() {
		return slideShowModels;
	}

	public void setSlideShowModels(ArrayList<SlideShowModel> slideShowModels) {
		this.slideShowModels = slideShowModels;
	}

	public ArrayList<FeaturedModel> getFeaturedModels() {
		return featuredModels;
	}

	public void setFeaturedModels(ArrayList<FeaturedModel> featuredModels) {
		this.featuredModels = featuredModels;
	}

	public ArrayList<CategoriesModel> getCategoriesModels() {
		return categoriesModels;
	}

	public void setCategoriesModels(ArrayList<CategoriesModel> categoriesModels) {
		this.categoriesModels = categoriesModels;
	}
	
	
	
	
	
	
	
	
	
	
}
