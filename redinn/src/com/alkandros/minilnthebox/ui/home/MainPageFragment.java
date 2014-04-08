package com.alkandros.minilnthebox.ui.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.baseclass.BaseActivity;
import com.alkandros.minilnthebox.baseclass.BaseFragmentActivity;

public class MainPageFragment extends BaseFragmentActivity implements
		OnClickListener {

	private Button tab1;
	private Button tab2;
	private Button tab3;
	private Button tab4;
	private Button tab5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_home);

		initialiseUI();
		clickListeners();

	}

	private void initialiseUI() {

		tab1 = (Button) findViewById(R.id.btnTab1);
		tab2 = (Button) findViewById(R.id.btnTab2);
		tab3 = (Button) findViewById(R.id.btnTab3);
		tab4 = (Button) findViewById(R.id.btnTab4);
		tab5 = (Button) findViewById(R.id.btnTab5);
		
		
		setTabSelector(tab1);
		
		
	}

	private void clickListeners() {

		tab1.setOnClickListener(this);
		tab2.setOnClickListener(this);
		tab3.setOnClickListener(this);
		tab4.setOnClickListener(this);
		tab5.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		setTabSelector(v);

		if (v == tab1) {

			
			
		} else if (v == tab2) {

		} else if (v == tab3) {

		} else if (v == tab4) {

		} else if (v == tab5) {

		}

	}

	
	private void setTabSelector(View v) {
		
		if(v==tab1){
			
			
			tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab1_h, 0, 0);
			
			
			tab2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab2, 0, 0);
			tab3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab3, 0, 0);
			tab4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab4, 0, 0);
			tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab5, 0, 0);
			
			
			
			tab1.setTextColor(getResources().getColor(R.color.blue));
			
			tab2.setTextColor(getResources().getColor(R.color.grey));
			tab3.setTextColor(getResources().getColor(R.color.grey));
			tab4.setTextColor(getResources().getColor(R.color.grey));
			tab5.setTextColor(getResources().getColor(R.color.grey));
		}
		else if(v==tab2){
			
			
			tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab1, 0, 0);
			
			
			tab2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab2_h, 0, 0);
			tab3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab3, 0, 0);
			tab4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab4, 0, 0);
			tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab5, 0, 0);
			
			
			
			tab1.setTextColor(getResources().getColor(R.color.grey));
			
			tab2.setTextColor(getResources().getColor(R.color.blue));
			tab3.setTextColor(getResources().getColor(R.color.grey));
			tab4.setTextColor(getResources().getColor(R.color.grey));
			tab5.setTextColor(getResources().getColor(R.color.grey));
			
		}
		else if(v==tab3){
			tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab1, 0, 0);
			
			
			tab2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab2, 0, 0);
			tab3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab3_h, 0, 0);
			tab4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab4, 0, 0);
			tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab5, 0, 0);
			
			
			
			tab1.setTextColor(getResources().getColor(R.color.grey));
			
			tab2.setTextColor(getResources().getColor(R.color.grey));
			tab3.setTextColor(getResources().getColor(R.color.blue));
			tab4.setTextColor(getResources().getColor(R.color.grey));
			tab5.setTextColor(getResources().getColor(R.color.grey));
		}
		else if(v==tab4){
			tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab1, 0, 0);
			
			
			tab2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab2, 0, 0);
			tab3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab3, 0, 0);
			tab4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab4_h, 0, 0);
			tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab5, 0, 0);
			
			
			
			tab1.setTextColor(getResources().getColor(R.color.grey));
			
			tab2.setTextColor(getResources().getColor(R.color.grey));
			tab3.setTextColor(getResources().getColor(R.color.grey));
			tab4.setTextColor(getResources().getColor(R.color.blue));
			tab5.setTextColor(getResources().getColor(R.color.grey));
		}
		else if(v==tab5){
			tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab1, 0, 0);
					
					
					tab2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab2, 0, 0);
					tab3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab3, 0, 0);
					tab4.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.tab4,0, 0);
					tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab5_h, 0, 0);
					
					
					
					tab1.setTextColor(getResources().getColor(R.color.grey));
					
					tab2.setTextColor(getResources().getColor(R.color.grey));
					tab3.setTextColor(getResources().getColor(R.color.grey));
					tab4.setTextColor(getResources().getColor(R.color.grey));
					tab5.setTextColor(getResources().getColor(R.color.blue));
				}
			
			
		
		
		
	}
	
	

}
