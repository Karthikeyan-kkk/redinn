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



	public ImageView leftIcon;
	public ImageView rightIcon;
	public TextView title;
	private TextView txtcartCount;
	
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
		
		//System.out.println("CHK V= "+AppPreferenceManager.getConfigModel(activity).getFeaturedModels().get(0).getPriceModel().getPrice());
	}
	


	public void setHeaderIntialize() {
		
		leftIcon=(ImageView)findViewById(R.id.leftIcon);
		rightIcon=(ImageView)findViewById(R.id.rightIcon);
		title=(TextView)findViewById(R.id.title);
		txtcartCount=(TextView)findViewById(R.id.txtcartCount);
		
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
			
		SelectorManager.setBackground(leftIcon, SelectorManager.getButtonDrawableImage(activity, normal, press));
		
	}
	
	public void setRightSelector(int normal,int press) {
			
		SelectorManager.setBackground(rightIcon, SelectorManager.getButtonDrawableImage(activity, normal, press));
	}

	
	public ImageView getBtnLeft() {
		
		
		return leftIcon;
	}
	
	
	public ImageView getBtnRight() {
		return rightIcon;
	}
	
	public TextView getTitleView() {
		return title;
	}
	
	

	public void startBaseActivityForResult(Intent i, int requestCode){
		
		
		this.startActivityForResult(i, requestCode);
		overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
	}
	
	
	
	
    
	

}
