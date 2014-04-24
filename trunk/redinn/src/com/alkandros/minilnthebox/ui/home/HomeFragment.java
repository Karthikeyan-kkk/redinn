package com.alkandros.minilnthebox.ui.home;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.adapter.SlideShowPagerAdapter;
import com.alkandros.minilnthebox.baseclass.BaseFragment;
import com.alkandros.minilnthebox.custom.autoscrollviewadapter.AutoScrollViewPager;
import com.alkandros.minilnthebox.custom.slidinglib.SlidingMenu;
import com.alkandros.minilnthebox.custom.viewpagerindicator.CirclePageIndicator;
import com.alkandros.minilnthebox.manager.AppPreferenceManager;
import com.alkandros.minilnthebox.manager.SliderManager;
import com.alkandros.minilnthebox.model.CategoriesModel;
import com.alkandros.minilnthebox.model.ConfigModel;
import com.alkandros.minilnthebox.model.FeaturedModel;
import com.alkandros.minilnthebox.model.ImagePrefixModel;
import com.alkandros.minilnthebox.model.SlideShowModel;
import com.alkandros.minilnthebox.ui.detail.DetailPageList;
import com.alkandros.minilnthebox.utils.Utils;
import com.alkandros.minilnthebox.utils.ViewUtils;



public class HomeFragment extends BaseFragment implements OnClickListener{
	
	
	private View view;
	private LayoutInflater mInflater;
	private Context context;
	
	private CirclePageIndicator circlePageIndicator;
	private AutoScrollViewPager autoScrollViewPager;
	
	private List<Integer>       imageIdList;
	
	private SlideShowPagerAdapter imagePagerAdapter;
	private LinearLayout linGrid1;
	private LinearLayout linGrid2;
	private LinearLayout linGrid3;
	int width=0;
	
	private LinearLayout linCategories;
	LayoutInflater inflaterCategories;
	//private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
	
	//private TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9;
	private ImageView img[]=new ImageView[9];
	private TextView txt[]=new TextView[9];
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		mInflater	= inflater;
		view	= inflater.inflate(R.layout.frgment_home, container, false);
		context=getActivity();
		
		
		
		intialazeUI();
		ClickListner();
		setData();
		
		ConfigModel configModel=AppPreferenceManager.getConfigModel(context);
		System.out.println("DATA = "+configModel.getSlideShowModels().get(0).getImage());
		
		return view;
	}



	



	private void ClickListner() {
		//getBtnLeft().setOnClickListener(this);
		//getBtnRight().setOnClickListener(this);
		
		
		
		
	}

	
	private void setData() {
		
		ConfigModel configModel=new ConfigModel();
		configModel=AppPreferenceManager.getConfigModel(context);
		
		
		
		
		ImagePrefixModel imagePrefixModel=new ImagePrefixModel();
		imagePrefixModel=configModel.getImagePrefixModel();
		
		
		//set Featured data
		ArrayList<FeaturedModel> featuredModels=new ArrayList<FeaturedModel>();
		featuredModels=configModel.getFeaturedModels();
		for (int i = 0; i < featuredModels.size(); i++) {
			
			
			System.out.println(""+imagePrefixModel.getImage_thumb_sm()+featuredModels.get(i).getImage());
			imageLoader.displayImage(imagePrefixModel.getItem_image_path()+imagePrefixModel.getImage_thumb_sm()+featuredModels.get(i).getImage(),img[i],options);
			
			txt[i].setText(featuredModels.get(i).getName());
			
		}
		
		//set Slideshow data
		ArrayList<SlideShowModel> slideShowModels=new ArrayList<SlideShowModel>();
		slideShowModels=configModel.getSlideShowModels();
		
		imagePagerAdapter=new SlideShowPagerAdapter(context, slideShowModels);
        autoScrollViewPager.setAdapter(imagePagerAdapter);
        
        autoScrollViewPager.setInterval(2000);
        autoScrollViewPager.startAutoScroll();
        circlePageIndicator.setViewPager(autoScrollViewPager);
        
        
        
        
        //set Categories data..
        
        ArrayList<CategoriesModel> categoriesModels=configModel.getCategoriesModels();
        
        for (int i = 0; i < categoriesModels.size(); i++) {
        	
        	View convertView= mInflater.inflate(R.layout.layout_category_item, null);
        	FrameLayout frmClick =(FrameLayout)convertView.findViewById(R.id.frmClick);
        	LinearLayout linearLayoutItem=(LinearLayout)convertView.findViewById(R.id.linItem);
        	TextView txtItemName=(TextView)convertView.findViewById(R.id.txtItemName);
        	ImageView imgItem=(ImageView)convertView.findViewById(R.id.imgItem);
        	
        	txtItemName.setText(categoriesModels.get(i).getName());
        	imageLoader.displayImage(imagePrefixModel.getItem_image_path()+imagePrefixModel.getImage_thumb_md(), imgItem,options);
        	
        	frmClick.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				intent =new Intent(context,DetailPageList.class);
				startBaseActivity(intent);
					
				}
			});
        	
        	linCategories.addView(convertView);
			
		}
		
	}
	

	private void intialazeUI() {
		
		//setHeaderIntialize(view);
		//setLeftSelector(R.drawable.button_1_hover, R.drawable.button_1_hover);
		//setRightSelector(R.drawable.button_2_hover, R.drawable.button_2_hover);
		//setHeaderImg(R.drawable.header_logo);
		
		//setIntializeSlider(getBtnLeft());
		
		
		
		img[0]=(ImageView)view.findViewById(R.id.img1);
		img[1]=(ImageView)view.findViewById(R.id.img2);
		img[2]=(ImageView)view.findViewById(R.id.img3);
		img[3]=(ImageView)view.findViewById(R.id.img4);
		img[4]=(ImageView)view.findViewById(R.id.img5);
		img[5]=(ImageView)view.findViewById(R.id.img6);
		img[6]=(ImageView)view.findViewById(R.id.img7);
		img[7]=(ImageView)view.findViewById(R.id.img8);
		img[8]=(ImageView)view.findViewById(R.id.img9);
		
		txt[0]=(TextView)view.findViewById(R.id.txt1);
		txt[1]=(TextView)view.findViewById(R.id.txt2);
		txt[2]=(TextView)view.findViewById(R.id.txt3);
		txt[3]=(TextView)view.findViewById(R.id.txt4);
		txt[4]=(TextView)view.findViewById(R.id.txt5);
		txt[5]=(TextView)view.findViewById(R.id.txt6);
		txt[6]=(TextView)view.findViewById(R.id.txt7);
		txt[7]=(TextView)view.findViewById(R.id.txt8);
		txt[8]=(TextView)view.findViewById(R.id.txt9);
		
		
		linGrid1=(LinearLayout)view.findViewById(R.id.linGrid1);
		linGrid2=(LinearLayout)view.findViewById(R.id.linGrid2);
		linGrid3=(LinearLayout)view.findViewById(R.id.linGrid3);
		
		width=Utils.getDeviceWidth(context)/3;
		
		ViewUtils.setViewHeight(linGrid1, width);
		ViewUtils.setViewHeight(linGrid2, width);
		ViewUtils.setViewHeight(linGrid3, width);
		
		autoScrollViewPager=(AutoScrollViewPager)view.findViewById(R.id.view_pager);
		circlePageIndicator=(CirclePageIndicator)view.findViewById(R.id.indicator);
		
		
		
		linCategories=(LinearLayout)view.findViewById(R.id.linCategories);
		
		inflaterCategories = (LayoutInflater) getActivity()	.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		
		
		/*imageIdList = new ArrayList<Integer>();
	        imageIdList.add(R.drawable.banner1);
	        imageIdList.add(R.drawable.banner2);
	        imageIdList.add(R.drawable.banner3);
	        imageIdList.add(R.drawable.banner4);
	        
	        imagePagerAdapter=new ImagePagerAdapter(context, imageIdList);
	        autoScrollViewPager.setAdapter(imagePagerAdapter);
	        
	        autoScrollViewPager.setInterval(2000);
	        autoScrollViewPager.startAutoScroll();
	        
	        
	
		circlePageIndicator.setViewPager(autoScrollViewPager);*/
		
	}



	@Override
	public void onClick(View v) {
		
		if(v==getBtnLeft()){
			
			//slidingMenu.toggle();
		}
		else if(v==getBtnRight()){
			
		}
		
	}

}
