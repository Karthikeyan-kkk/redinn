package com.alkandros.minilnthebox.baseclass;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.custom.slidinglib.SlidingMenu;
import com.alkandros.minilnthebox.manager.SelectorManager;
import com.alkandros.minilnthebox.manager.SliderManager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;




public abstract  class BaseFragment extends Fragment {


	public Intent intent;
	
	public ImageView btnLeft;
	public ImageView btnRight;
	public TextView title;
	
	public SliderManager slider;
	public SlidingMenu slidingMenu;
	

	 protected ImageLoader imageLoader = ImageLoader.getInstance();
	 
	 protected DisplayImageOptions options;
	 
	 
	 @Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			 
			
			return super.onCreateView(inflater, container, savedInstanceState);
		}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		options = new DisplayImageOptions.Builder()
		.showImageOnLoading(R.drawable.cateloading)
		.showImageForEmptyUri(R.drawable.errorimg)
		.showImageOnFail(R.drawable.errorimg)
		.cacheInMemory(true)
		.cacheOnDisc(true)
		.considerExifParams(true)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.build();
		
		
		super.onCreate(savedInstanceState);
		
	}

	

/*
	public void setIntializeSlider(View  v) {
		
		slider   		= new SliderManager(getActivity());
		slidingMenu		=slider.initializeSlidingMenu(v);
		
		
	}*/
	


	public void setHeaderIntialize(View  v) {
		
		btnLeft=(ImageView)v.findViewById(R.id.leftIcon);
		btnRight=(ImageView)v.findViewById(R.id.rightIcon);
		title=(TextView)v.findViewById(R.id.title);
		
		
	}
	
	
	public void setTitle(String titleContent) {
		
		title.setText(titleContent);
		
	}
	

	public void setHeaderImg(int imgContent) {
		
		title.setBackgroundResource(imgContent);
		
	}



	public void setLeftSelector(int normal,int press) {
			
		SelectorManager.setBackground(btnLeft, SelectorManager.getButtonDrawableImage(getActivity(), normal, press));
		
	}
	
	public void setRightSelector(int normal,int press) {
			
		SelectorManager.setBackground(btnRight, SelectorManager.getButtonDrawableImage(getActivity(), normal, press));
	}

	
	public ImageView getBtnLeft() {
		
		
		return btnLeft;
	}
	
	
	public ImageView getBtnRight() {
		return btnRight;
	}
	
	public TextView getTitle() {
		return title;
	}
	
	
	public void startBaseActivity(Intent i){
		
		
		this.startActivity(i);
		getActivity().overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
	}
	
    
	
	
    
    
	

}
