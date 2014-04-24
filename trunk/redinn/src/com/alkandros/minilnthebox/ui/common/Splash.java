package com.alkandros.minilnthebox.ui.common;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.R.layout;
import com.alkandros.minilnthebox.R.menu;
import com.alkandros.minilnthebox.baseclass.BaseActivity;
import com.alkandros.minilnthebox.constants.IJsonConstants;
import com.alkandros.minilnthebox.constants.IUrlConstants;
import com.alkandros.minilnthebox.manager.ApiManager;
import com.alkandros.minilnthebox.manager.ApiManager.ApiResponseListner;
import com.alkandros.minilnthebox.manager.AppPreferenceManager;
import com.alkandros.minilnthebox.manager.NotifyManager;
import com.alkandros.minilnthebox.manager.Utils;
import com.alkandros.minilnthebox.model.CategoriesModel;
import com.alkandros.minilnthebox.model.ConfigModel;
import com.alkandros.minilnthebox.model.CurrencyModel;
import com.alkandros.minilnthebox.model.FeaturedModel;
import com.alkandros.minilnthebox.model.ImagePrefixModel;
import com.alkandros.minilnthebox.model.PriceModel;
import com.alkandros.minilnthebox.model.SlideNavigationModel;
import com.alkandros.minilnthebox.model.SlideShowModel;
import com.alkandros.minilnthebox.ui.home.MainPageFragment;

import com.google.gson.Gson;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;

public class Splash extends BaseActivity {

	private Context context;
	private Intent i;

	private final int SPLASH_DISPLAY_LENGTH = 1000;

	ApiManager apiManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		context = this;

		// AdView adView = (AdView)this.findViewById(R.id.adView);

		// adView.loadAd(new AdRequest());

		
		callApi();

	}

	private void callApi() {
		apiManager = new ApiManager(IUrlConstants.GET_HOME_SETING, context,
				false);

		apiManager.setApiResponseListener(new ApiResponseListner() {

			@Override
			public void dataDownloadedSuccessfully(JSONObject response) {
				// TODO Auto-generated method stub

				ConfigModel configModel = new ConfigModel();

				// Set Currency Model Value
				CurrencyModel currencyModel = new CurrencyModel();
				;

				try {
					JSONArray j_Currencies = response
							.getJSONArray(IJsonConstants.J_Currencies);

					for (int i = 0; i < j_Currencies.length(); i++) {

						JSONObject jitem = j_Currencies.getJSONObject(i);

						if (jitem.getBoolean(IJsonConstants.J_default)) {

							currencyModel = new Gson().fromJson(
									jitem.toString(), CurrencyModel.class);
							break;
						}

					}

					configModel.setCurrencyModel(currencyModel);

					// Set ImagePrefix..

					JSONObject imgPrefi = response
							.getJSONObject(IJsonConstants.J_Image_Prefixes);

					ImagePrefixModel imagePrefixModel = new Gson().fromJson(
							imgPrefi.toString(), ImagePrefixModel.class);

					configModel.setImagePrefixModel(imagePrefixModel);

					// Set SlideShow Values
					ArrayList<SlideShowModel> slideShowModels = new ArrayList<SlideShowModel>();
					JSONObject j_slideShows = response.getJSONObject(IJsonConstants.J_SlideShows);
					JSONArray j_slideShow = j_slideShows.getJSONArray(IJsonConstants.J_SlideShow);

					for (int i = 0; i < j_slideShow.length(); i++) {

						JSONObject jitem = j_slideShow.getJSONObject(i);
						SlideShowModel showModel = new Gson().fromJson(
								jitem.toString(), SlideShowModel.class);

						slideShowModels.add(showModel);
					}

					configModel.setSlideShowModels(slideShowModels);
					
					

					// Set Featured Value..
					ArrayList<FeaturedModel> featuredModels = new ArrayList<FeaturedModel>();
					JSONArray j_Featured = response
							.getJSONArray(IJsonConstants.J_Featured);
					for (int i = 0; i < j_Featured.length(); i++) {
						JSONObject jitem = j_Featured.getJSONObject(i);

						JSONObject jitemObject = jitem.getJSONObject(IJsonConstants.J_Item);
						FeaturedModel featuredModel = new Gson().fromJson(jitemObject.toString(), FeaturedModel.class);
						
						/*
						
						JSONArray jpriceArray = jitem.getJSONArray(IJsonConstants.J_ItemPrice);
						for (int j = 0; j < jpriceArray.length(); j++) {
							
							JSONObject jprice = jpriceArray.getJSONObject(i);
							
							if(currencyModel.getCurr_id()==jprice.getString(IJsonConstants.J_currency_id)){
								
								//PriceModel priceModel=new Gson().fromJson(jprice.toString(), PriceModel.class);
								
								//featuredModel.setPriceModel(priceModel);
								break;
								
							}
							
						}*/
						
						

						featuredModels.add(featuredModel);

					}

					configModel.setFeaturedModels(featuredModels);

					// Set Category Value..
					ArrayList<CategoriesModel> categoriesModels = new ArrayList<CategoriesModel>();
					JSONArray j_Categories = response
							.getJSONArray(IJsonConstants.J_Categories);
					for (int i = 0; i < j_Categories.length(); i++) {
						JSONObject jitem = j_Categories.getJSONObject(i);

						CategoriesModel categoriesModel = new Gson().fromJson(
								jitem.toString(), CategoriesModel.class);

						categoriesModels.add(categoriesModel);

					}
					configModel.setCategoriesModels(categoriesModels);
					
					
					
					//Set Slide Navigation Value..
					
					ArrayList<SlideNavigationModel> slideNavigationModels=new ArrayList<SlideNavigationModel>();
					
					JSONArray j_slideNavigation = response
							.getJSONArray(IJsonConstants.J_SideNavigationTags);
					
					for (int i = 0; i < j_slideNavigation.length(); i++) 
					{
						JSONObject SideNavigationTags = j_slideNavigation.getJSONObject(i);
					
						SlideNavigationModel slide = new Gson().fromJson(SideNavigationTags.toString(), SlideNavigationModel.class);
						slideNavigationModels.add(slide);
						
					}
					
					/*
					JSONObject SideNavigationTags = response.getJSONObject(IJsonConstants.J_SideNavigationTags);
					
					JSONObject Slide2 = SideNavigationTags.getJSONObject("2");
					SlideNavigationModel slideM2 = new Gson().fromJson(Slide2.toString(), SlideNavigationModel.class);
					slideNavigationModels.add(slideM2);
					
					JSONObject Slide3 = SideNavigationTags.getJSONObject("3");
					SlideNavigationModel slideM3 = new Gson().fromJson(Slide3.toString(), SlideNavigationModel.class);
					slideNavigationModels.add(slideM3);
					
					JSONObject Slide4 = SideNavigationTags.getJSONObject("4");
					SlideNavigationModel slideM4 = new Gson().fromJson(Slide4.toString(), SlideNavigationModel.class);
					slideNavigationModels.add(slideM4);
					
					JSONObject Slide5 = SideNavigationTags.getJSONObject("5");
					SlideNavigationModel slideM5 = new Gson().fromJson(Slide5.toString(), SlideNavigationModel.class);
					slideNavigationModels.add(slideM5);*/
					
					
					configModel.setSlideNavigationModels(slideNavigationModels);
					
					
					
					
					

					AppPreferenceManager.saveConfigModel(context, configModel);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				intializeUI();

			}

			@Override
			public void dataDownloadedFailed(String error) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void intializeUI() {

		new Handler().postDelayed(new Runnable() {

			public void run() {

				i = new Intent(context, MainPageFragment.class);
				startBaseActivity(i);
				finish();
			}
		}, SPLASH_DISPLAY_LENGTH);

	}

}
