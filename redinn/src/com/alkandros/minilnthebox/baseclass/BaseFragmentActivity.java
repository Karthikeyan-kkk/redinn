package com.alkandros.minilnthebox.baseclass;

import com.alkandros.minilnthebox.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;



public class BaseFragmentActivity extends FragmentActivity {


	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		
		setContentView(R.layout.common_header);
		
		setHeader();
	}

	private void setHeader() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
