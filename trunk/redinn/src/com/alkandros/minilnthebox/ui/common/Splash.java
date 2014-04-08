package com.alkandros.minilnthebox.ui.common;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.R.layout;
import com.alkandros.minilnthebox.R.menu;
import com.alkandros.minilnthebox.ui.home.MainPageFragment;



import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {

	private Context context;
	private Intent i;
	
	private final int SPLASH_DISPLAY_LENGTH = 1000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		context=this;
		
	//	 AdView adView = (AdView)this.findViewById(R.id.adView);
		 
		//    adView.loadAd(new AdRequest());
		
		
		intializeUI();
	}

	private void intializeUI() {
		
		
		new Handler().postDelayed(new Runnable() {
			
			public void run() {
				
				 i= new Intent(context,MainPageFragment.class);
				startActivity(i);
				finish();
			}
		}, SPLASH_DISPLAY_LENGTH);
		
	}

	
}
