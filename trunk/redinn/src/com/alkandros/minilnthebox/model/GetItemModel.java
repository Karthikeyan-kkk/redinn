package com.alkandros.minilnthebox.model;

import java.io.Serializable;
import java.util.ArrayList;

public class GetItemModel implements Serializable{
	
	
	private ItemModel itemModel=new ItemModel();
	
	private CollectionModel collectionModel=new CollectionModel();
	
	private CategoryModel categoryModel=new CategoryModel();
	
	private LabelModel labelModel=new LabelModel();
	
	
	//get price if currency id= config price id
	private PriceModel priceModel=new PriceModel();
			
	private ArrayList<ItemImageModel> itemImageModels=new ArrayList<ItemImageModel>();
	
	private ArrayList<ItemSizeColorModel> itemSizeColorModels=new ArrayList<ItemSizeColorModel>();
	
	private ArrayList<ItemOptionTagModel> tagModels=new ArrayList<ItemOptionTagModel>();

	public ItemModel getItemModel() {
		return itemModel;
	}

	public void setItemModel(ItemModel itemModel) {
		this.itemModel = itemModel;
	}

	public CollectionModel getCollectionModel() {
		return collectionModel;
	}

	public void setCollectionModel(CollectionModel collectionModel) {
		this.collectionModel = collectionModel;
	}

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public LabelModel getLabelModel() {
		return labelModel;
	}

	public void setLabelModel(LabelModel labelModel) {
		this.labelModel = labelModel;
	}

	public PriceModel getPriceModel() {
		return priceModel;
	}

	public void setPriceModel(PriceModel priceModel) {
		this.priceModel = priceModel;
	}

	public ArrayList<ItemImageModel> getItemImageModels() {
		return itemImageModels;
	}

	public void setItemImageModels(ArrayList<ItemImageModel> itemImageModels) {
		this.itemImageModels = itemImageModels;
	}

	public ArrayList<ItemSizeColorModel> getItemSizeColorModels() {
		return itemSizeColorModels;
	}

	public void setItemSizeColorModels(
			ArrayList<ItemSizeColorModel> itemSizeColorModels) {
		this.itemSizeColorModels = itemSizeColorModels;
	}

	public ArrayList<ItemOptionTagModel> getTagModels() {
		return tagModels;
	}

	public void setTagModels(ArrayList<ItemOptionTagModel> tagModels) {
		this.tagModels = tagModels;
	}
	
	
	

}
