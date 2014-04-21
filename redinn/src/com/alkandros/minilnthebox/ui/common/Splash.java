package com.alkandros.minilnthebox.ui.common;

import org.json.JSONObject;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.R.layout;
import com.alkandros.minilnthebox.R.menu;
import com.alkandros.minilnthebox.constants.IUrlConstants;
import com.alkandros.minilnthebox.manager.ApiManager;
import com.alkandros.minilnthebox.manager.ApiManager.ApiResponseListner;
import com.alkandros.minilnthebox.manager.Utils;
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
	
	
	ApiManager apiManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		context=this;
		
	//	 AdView adView = (AdView)this.findViewById(R.id.adView);
		 
		//    adView.loadAd(new AdRequest());
		
		apiManager=new ApiManager(IUrlConstants.GET_HOME_SETING, context, true);
		
		
		
		apiManager.setApiResponseListener(new ApiResponseListner() {
			
			@Override
			public void dataDownloadedSuccessfully(JSONObject response) {
				// TODO Auto-generated method stub
				
				Utils.longInfo(response.toString());
				
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
				
				 i= new Intent(context,MainPageFragment.class);
				startActivity(i);
				finish();
			}
		}, SPLASH_DISPLAY_LENGTH);
		
	}

	
}
