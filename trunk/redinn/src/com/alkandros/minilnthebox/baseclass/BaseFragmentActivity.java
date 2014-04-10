package com.alkandros.minilnthebox.baseclass;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.custom.slidinglib.SlidingMenu;
import com.alkandros.minilnthebox.manager.SelectorManager;
import com.alkandros.minilnthebox.manager.SliderManager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public abstract  class BaseFragmentActivity extends FragmentActivity {



	public ImageView btnLeft;
	public ImageView btnRight;
	public TextView title;
	
	public SliderManager slider;
	public SlidingMenu slidingMenu;
	
	private Activity activity;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      activity=this;
        
      
    }
	

	public void setIntializeSlider(View  v) {
		
		slider   		= new SliderManager(activity);
		slidingMenu		=slider.initializeSlidingMenu(v);
		
		
	}
	


	public void setHeaderIntialize() {
		
		btnLeft=(ImageView)findViewById(R.id.leftIcon);
		btnRight=(ImageView)findViewById(R.id.rightIcon);
		title=(TextView)findViewById(R.id.title);
		
		
	}
	
	
	public void setTitle(String titleContent) {
		
		title.setBackgroundResource(0);
		title.setText(titleContent);
		
	}
	

	public void setHeaderImg(int imgContent) {
		
		title.setBackgroundResource(imgContent);
		title.setText("");
	}



	public void setLeftSelector(int normal,int press) {
			
		SelectorManager.setBackground(btnLeft, SelectorManager.getButtonDrawableByScreenCathegory(activity, normal, press));
		
	}
	
	public void setRightSelector(int normal,int press) {
			
		SelectorManager.setBackground(btnRight, SelectorManager.getButtonDrawableByScreenCathegory(activity, normal, press));
	}

	
	public ImageView getBtnLeft() {
		
		
		return btnLeft;
	}
	
	
	public ImageView getBtnRight() {
		return btnRight;
	}
	
	public TextView getTitleView() {
		return title;
	}
	
    
    
	

}
