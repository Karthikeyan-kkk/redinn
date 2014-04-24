package com.alkandros.minilnthebox.baseclass;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.custom.slidinglib.SlidingMenu;
import com.alkandros.minilnthebox.manager.AppPreferenceManager;
import com.alkandros.minilnthebox.manager.SelectorManager;
import com.alkandros.minilnthebox.manager.SliderManager;

import android.app.Activity;
import android.content.Intent;
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
		
		slider   		= new SliderManager(activity,AppPreferenceManager.getConfigModel(activity).getSlideNavigationModels());
		slidingMenu		=slider.initializeSlidingMenu(v);
		
		//System.out.println("CHK V= "+AppPreferenceManager.getConfigModel(activity).getFeaturedModels().get(0).getPriceModel().getPrice());
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
	
	

	public void startBaseActivityForResult(Intent i, int requestCode){
		
		
		this.startActivityForResult(i, requestCode);
		overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		this.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
		
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		this.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
	}
    
    
	

}
