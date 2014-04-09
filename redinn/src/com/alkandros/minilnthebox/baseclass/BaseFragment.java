package com.alkandros.minilnthebox.baseclass;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.custom.slidinglib.SlidingMenu;
import com.alkandros.minilnthebox.manager.SelectorManager;
import com.alkandros.minilnthebox.manager.SliderManager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;




public abstract  class BaseFragment extends Fragment {


	public ImageView btnLeft;
	public ImageView btnRight;
	public TextView title;
	
	public SliderManager slider;
	public SlidingMenu slidingMenu;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
	}

	


	public void setIntializeSlider(View  v) {
		
		slider   		= new SliderManager(getActivity());
		slidingMenu		=slider.initializeSlidingMenu(v);
		
		
	}
	


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
			
		SelectorManager.setBackground(btnLeft, SelectorManager.getButtonDrawableByScreenCathegory(getActivity(), normal, press));
		
	}
	
	public void setRightSelector(int normal,int press) {
			
		SelectorManager.setBackground(btnRight, SelectorManager.getButtonDrawableByScreenCathegory(getActivity(), normal, press));
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
	
	
	
	
    
	
	
    
    
	

}
