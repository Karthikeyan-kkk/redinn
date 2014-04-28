package com.alkandros.minilnthebox.ui.detail;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.adapter.GalleryPagerAdapter;
import com.alkandros.minilnthebox.adapter.SlideShowPagerAdapter;
import com.alkandros.minilnthebox.baseclass.BaseActivity;
import com.alkandros.minilnthebox.baseclass.MyApplication;
import com.alkandros.minilnthebox.constants.IJsonConstants;
import com.alkandros.minilnthebox.constants.IUrlConstants;
import com.alkandros.minilnthebox.custom.autoscrollviewadapter.AutoScrollViewPager;
import com.alkandros.minilnthebox.manager.ApiManager;
import com.alkandros.minilnthebox.manager.ApiServicesManager;
import com.alkandros.minilnthebox.manager.AppPreferenceManager;
import com.alkandros.minilnthebox.manager.ApiManager.ApiResponseListner;
import com.alkandros.minilnthebox.model.CategoryModel;
import com.alkandros.minilnthebox.model.CollectionModel;
import com.alkandros.minilnthebox.model.ColorModel;
import com.alkandros.minilnthebox.model.ConfigModel;
import com.alkandros.minilnthebox.model.GetItemModel;
import com.alkandros.minilnthebox.model.ItemImageModel;
import com.alkandros.minilnthebox.model.ItemModel;
import com.alkandros.minilnthebox.model.ItemOptionTagModel;
import com.alkandros.minilnthebox.model.ItemSizeColorModel;
import com.alkandros.minilnthebox.model.LabelModel;
import com.alkandros.minilnthebox.model.OptionModel;
import com.alkandros.minilnthebox.model.PriceModel;
import com.alkandros.minilnthebox.model.SizeModel;
import com.alkandros.minilnthebox.model.SlideShowModel;
import com.alkandros.minilnthebox.model.TagModel;
import com.alkandros.minilnthebox.utils.Utils;
import com.alkandros.minilnthebox.utils.ViewUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class DetailPage extends BaseActivity implements IUrlConstants ,OnClickListener{
	
	
	private ApiManager apiManager;
	
	private Bundle extras;
	String id;
	
	
	private AutoScrollViewPager autoScrollViewPager;
	
	private GalleryPagerAdapter galleryPagerAdapter;
	
	 private GetItemModel getItemModel=new GetItemModel();
	 
	 
	 
	 //..
	 private RelativeLayout relSpecification;
	 private TextView txtName;
	 
	 private RelativeLayout relPriceReview;
	 private TextView txtPriceNormal;
	 private TextView txtPriceOff;
	 private RatingBar ratingreview;
	 private TextView txtrating_count;
	  
	  
	 private LinearLayout layout_favorite_count;
	 private TextView txt_detail_favorite_count;
	 private LinearLayout  layout_detail_share;
	 private ImageView img_detail_share;
	 private TextView txtAddtoCart;
	  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_detailpage);
		
		extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("ID");
			
			System.out.println("ID = "+id);
		}
		
		intializeUI();
		clickListner();
		callGetItemApi(id);
		
	}

	private void clickListner() {
	
		
		relSpecification.setOnClickListener(this);
		getBtnLeft().setOnClickListener(this);
	}

	private void intializeUI() {
		setHeaderIntialize();
		setLeftSelector(R.drawable.left_arrow, R.drawable.left_arrow);
		setRightSelector(R.drawable.button_2_hover, R.drawable.button_2_hover);
		//setHeaderImg(R.drawable.header_logo);
		
		
	
		autoScrollViewPager=(AutoScrollViewPager)findViewById(R.id.view_pager);
		
		ViewUtils.setViewHeight(autoScrollViewPager, (Utils.getDeviceHeight(activity)/2)-50);
		
		 relSpecification =(RelativeLayout)findViewById(R.id.relSpecification);
		 txtName=(TextView)findViewById(R.id.txtName);
		 
		 relPriceReview =(RelativeLayout)findViewById(R.id.relPriceReview);
		 txtPriceNormal=(TextView)findViewById(R.id.txtPriceNormal);
		 txtPriceOff=(TextView)findViewById(R.id.txtPriceOff);
		 ratingreview=(RatingBar)findViewById(R.id.ratingreview);
		 txtrating_count=(TextView)findViewById(R.id.txtrating_count);
		 
		 layout_favorite_count=(LinearLayout)findViewById(R.id.layout_favorite_count);
		 txt_detail_favorite_count=(TextView)findViewById(R.id.txt_detail_favorite_count);
		 layout_detail_share=(LinearLayout)findViewById(R.id.layout_detail_share);
		 img_detail_share=(ImageView)findViewById(R.id.img_detail_share);
		 txtAddtoCart=(TextView)findViewById(R.id.txtAddtoCart);
		
	}

	private void setData() {
		
		final MyApplication myApplication=(MyApplication)getApplicationContext();
		ConfigModel configModel=myApplication.getConfigModel();
		
		
		ItemModel itemModel=getItemModel.getItemModel();
		
		
		if(itemModel!=null){
		//set Title..
		setHeaderTitle(itemModel.getPage_title());
		
		
		//set Data values
		txtName.setText(itemModel.getName());    
		
		
		
		}
		
		
		//set Price..
		PriceModel priceModel=getItemModel.getPriceModel();
		
		
		if(priceModel!=null){
			txtPriceNormal.setText(configModel.getCurrencyModel().getSymbol()+" "+priceModel.getPrice());
		}
		
		
		
		
		//Set Gallery Image.
		galleryPagerAdapter=new GalleryPagerAdapter(activity, getItemModel.getItemImageModels());
		autoScrollViewPager.setAdapter(galleryPagerAdapter);
		
		
		
		
		
		
	}
	
	private void callGetItemApi(String id) {
		
		
			
			apiManager = new ApiManager(IUrlConstants.GET_ITEM+id, activity,
					true);
			
			apiManager.setApiResponseListener(new ApiResponseListner() {
				
				@Override
				public void dataDownloadedSuccessfully(JSONObject response) {
					
					ItemModel itemModel=new ItemModel();
					
					try {
						
						//set Items
						itemModel = new Gson().fromJson(response.getString(IJsonConstants.J_Item).toString(), ItemModel.class);
						
						getItemModel.setItemModel(itemModel);
						
						
						//Set Collection..
						CollectionModel collectionModel=new CollectionModel();
						collectionModel=new Gson().fromJson(response.getString(IJsonConstants.J_Collection).toString(), CollectionModel.class);
						getItemModel.setCollectionModel(collectionModel);
						
						
						//Set Category..
						CategoryModel categoryModel=new CategoryModel();
						categoryModel=new Gson().fromJson(response.getString(IJsonConstants.J_Category).toString(), CategoryModel.class);
						getItemModel.setCategoryModel(categoryModel);
						
						//Set Label..
						LabelModel labelModel=new LabelModel();
						labelModel=new Gson().fromJson(response.getString(IJsonConstants.J_Label).toString(), LabelModel.class);
						getItemModel.setLabelModel(labelModel);
						
						
						//Set Item Image
						ArrayList<ItemImageModel> arrayListImageModels=new ArrayList<ItemImageModel>();
						JSONArray J_arrayImage = response.getJSONArray(IJsonConstants.J_ItemImage);
						for (int i = 0; i < J_arrayImage.length(); i++) {
							
							JSONObject jitemImage = J_arrayImage.getJSONObject(i);
							
							ItemImageModel imageModel=new Gson().fromJson(jitemImage.toString(), ItemImageModel.class);
							
							arrayListImageModels.add(imageModel);
							
						}
						
						
						getItemModel.setItemImageModels(arrayListImageModels);
						
						
						//Set ItemSizeColorModel 
						
						ArrayList<ItemSizeColorModel> listSizeColorModels=new  ArrayList<ItemSizeColorModel>();
						
						JSONArray J_SizeColorArray = response.getJSONArray(IJsonConstants.J_ItemSizeColor);
						
						for (int i = 0; i < J_SizeColorArray.length(); i++) {
							

							
							JSONObject jitemSizeColorModels = J_SizeColorArray.getJSONObject(i);
							
							ItemSizeColorModel itemSizeColorModel=new Gson().fromJson(jitemSizeColorModels.toString(), ItemSizeColorModel.class);
							
							
							JSONObject jSize=jitemSizeColorModels.getJSONObject(IJsonConstants.J_Size);
							
							SizeModel sizeModel=new Gson().fromJson(jSize.toString(), SizeModel.class);
							
							itemSizeColorModel.setSizeModel(sizeModel);
							
							JSONObject jcolor=jitemSizeColorModels.getJSONObject(IJsonConstants.J_Color);
							
							ColorModel colorModel=new Gson().fromJson(jcolor.toString(), ColorModel.class);
							
							itemSizeColorModel.setColorModel(colorModel);
							
							
							listSizeColorModels.add(itemSizeColorModel);
							
						}
						
						getItemModel.setItemSizeColorModels(listSizeColorModels);
						
						
						//set Item Price....
						
						PriceModel priceModel=new PriceModel();
						JSONArray J_PriceArray = response.getJSONArray(IJsonConstants.J_ItemPrice);
						
						for (int i = 0; i < J_PriceArray.length(); i++) {
							
							JSONObject J_ItemPrice = J_PriceArray.getJSONObject(i);
							
							
							JSONObject J_ItemCurrency = J_ItemPrice.getJSONObject(IJsonConstants.J_Currency);
							
							if (J_ItemCurrency.getBoolean(IJsonConstants.J_default)) {
								
								priceModel=new Gson().fromJson(J_ItemPrice.toString(), PriceModel.class);
								
								break;
							}
						
						}
						
						getItemModel.setPriceModel(priceModel);
						
						
						
						//Set Item OPtion Tag..
						
						ArrayList<ItemOptionTagModel> listItemOptionTagModels=new  ArrayList<ItemOptionTagModel>();
						
						JSONArray J_OptionTag = response.getJSONArray(IJsonConstants.J_ItemOptionTag);
						
						for (int i = 0; i < J_OptionTag.length(); i++) {
													
							JSONObject J_ItemOptionTag = J_OptionTag.getJSONObject(i);
							
							ItemOptionTagModel itemOptionTagModel=new ItemOptionTagModel();
							itemOptionTagModel=new Gson().fromJson(J_ItemOptionTag.toString(), ItemOptionTagModel.class);
							
							
							JSONObject J_option=J_ItemOptionTag.getJSONObject(IJsonConstants.J_Option);
							OptionModel optionModel=new Gson().fromJson(J_option.toString(), OptionModel.class);
							itemOptionTagModel.setOptionModel(optionModel);
							
							
							JSONObject J_tag=J_ItemOptionTag.getJSONObject(IJsonConstants.J_Tag);
							TagModel tagModel=new Gson().fromJson(J_tag.toString(), TagModel.class);
							itemOptionTagModel.setTagModel(tagModel);
							
							
							
							listItemOptionTagModels.add(itemOptionTagModel);
							
						}
						
						
						getItemModel.setTagModels(listItemOptionTagModels);
						
					
					} catch (JsonSyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
					
					setData();
					
				}
				
				@Override
				public void dataDownloadedFailed(String error) {
				
					
				}
			});
			
		
	}

	@Override
	public void onClick(View v) {
		if(v==relSpecification){
			intent =new Intent(activity,SpecificationPage.class);
			intent.putExtra("DATA", getItemModel);
			
			startBaseActivity(intent);
		}
		else if(getBtnLeft()==v){
			finishActivity();
		}
		
	}

	
	
	
	
	

}
