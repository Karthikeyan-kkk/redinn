package com.alkandros.minilnthebox.baseclass;



import com.alkandros.minilnthebox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



public class BaseActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		

	}
	
	public void startBaseActivity(Intent i){
		
		
		this.startActivity(i);
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
