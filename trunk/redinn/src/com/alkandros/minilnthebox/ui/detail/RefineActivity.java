package com.alkandros.minilnthebox.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.baseclass.BaseActivity;
import com.alkandros.minilnthebox.constants.IRequestConstants;

public class RefineActivity extends BaseActivity implements OnClickListener {

	private RelativeLayout relPrice1, relPrice2, relPrice3, relPrice4,
			relPrice5;
	private TextView txt[]=new TextView[5];

	float minPrice, maxPrice;
	
	float diff=0,currentPrice=0;
	String currencySymbol;
	
	float[][] price=new float[5][2];
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_refine);

		if (extras != null) {

			minPrice = extras.getFloat("MIN_PRICE");
			maxPrice = extras.getFloat("MAX_PRICE");
			
			currencySymbol=extras.getString("SYMBOL");

		}
		
		
		
		
		diff=(maxPrice-minPrice)/5;

		intializeUI();

		clickListner();
		
		setData();
	}

	private void setData() {
		currentPrice=minPrice;
		for (int i = 0; i < txt.length; i++) {
			
			price[i][0]=currentPrice;
			price[i][1]=(currentPrice+diff);
			
			txt[i].setText(currencySymbol+" "+currentPrice +"  -  "+currencySymbol+" " +(currentPrice+diff));
			currentPrice+=diff;
			
		}
		
	}

	private void intializeUI() {
		
		setHeaderIntialize();
		setLeftSelector(R.drawable.left_arrow, R.drawable.left_arrow);
		setRightSelector(R.drawable.button_2_hover, R.drawable.button_2_hover);
		// setHeaderImg(R.drawable.header_logo);
		setHeaderTitle(getString(R.string.Refine));

		relPrice1 = (RelativeLayout) findViewById(R.id.relPrice1);
		relPrice2 = (RelativeLayout) findViewById(R.id.relPrice2);
		relPrice3 = (RelativeLayout) findViewById(R.id.relPrice3);
		relPrice4 = (RelativeLayout) findViewById(R.id.relPrice4);
		relPrice5 = (RelativeLayout) findViewById(R.id.relPrice5);

		txt[0] = (TextView) findViewById(R.id.txt1);
		txt[1] = (TextView) findViewById(R.id.txt2);
		txt[2]= (TextView) findViewById(R.id.txt3);
		txt[3] = (TextView) findViewById(R.id.txt4);
		txt[4] = (TextView) findViewById(R.id.txt5);

	}

	private void clickListner() {

		relPrice1.setOnClickListener(this);
		relPrice2.setOnClickListener(this);
		relPrice3.setOnClickListener(this);
		relPrice4.setOnClickListener(this);
		relPrice5.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		
		Intent output;

		if (v == relPrice1) {
		
			
			
			 output = new Intent();
			output.putExtra("MIN_PRICE", price[0][0]);
			output.putExtra("MAX_PRICE", price[0][1]);
			
			setResult(IRequestConstants.REFINE_CODE, output);
			finishActivity();
			
			

		} else if (v == relPrice2) {

		
			
			 output = new Intent();
				output.putExtra("MIN_PRICE", price[1][0]);
				output.putExtra("MAX_PRICE", price[1][1]);
				
				setResult(IRequestConstants.REFINE_CODE, output);
				finishActivity();

		} else if (v == relPrice3) {

		
			
			 output = new Intent();
				output.putExtra("MIN_PRICE", price[2][0]);
				output.putExtra("MAX_PRICE", price[2][1]);
				
				setResult(IRequestConstants.REFINE_CODE, output);
				finishActivity();

		} else if (v == relPrice4) {

			
			
			 output = new Intent();
				output.putExtra("MIN_PRICE", price[3][0]);
				output.putExtra("MAX_PRICE", price[3][1]);
				
				setResult(IRequestConstants.REFINE_CODE, output);
				finishActivity();

		} else if (v == relPrice5) {

		
			
			 output = new Intent();
				output.putExtra("MIN_PRICE", price[4][0]);
				output.putExtra("MAX_PRICE", price[4][1]);
				
				setResult(IRequestConstants.REFINE_CODE, output);
				finishActivity();

		}
	}

}
