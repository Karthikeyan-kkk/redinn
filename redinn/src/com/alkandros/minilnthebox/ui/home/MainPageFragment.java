package com.alkandros.minilnthebox.ui.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.baseclass.BaseFragmentActivity;


public class MainPageFragment extends BaseFragmentActivity implements
		OnClickListener {

	private Button tab1;
	private Button tab2;
	private Button tab3;
	private Button tab4;
	private Button tab5;
	
	
	private HomeFragment homeFragment=null;
	private DealsFragment dealsFragment=null;
	private SettingsFragment settingFragment=null;
	private MeFragment meFragment=null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		initialiseUI();
		clickListeners();

	}

	private void initialiseUI() {

		tab1 = (Button) findViewById(R.id.btnTab1);
		tab2 = (Button) findViewById(R.id.btnTab2);
		tab3 = (Button) findViewById(R.id.btnTab3);
		tab4 = (Button) findViewById(R.id.btnTab4);
		tab5 = (Button) findViewById(R.id.btnTab5);

		setHeaderIntialize();
		setLeftSelector(R.drawable.button_1_hover, R.drawable.button_1_hover);
		setRightSelector(R.drawable.button_2_hover, R.drawable.button_2_hover);
		setHeaderImg(R.drawable.header_logo);
		
		setIntializeSlider(getBtnLeft());
		
		setTabSelector(tab1);
		homeFragment=new HomeFragment();
		getSupportFragmentManager().beginTransaction().add(R.id.frgContainer, homeFragment).commit();

	}

	private void clickListeners() {

		tab1.setOnClickListener(this);
		tab2.setOnClickListener(this);
		tab3.setOnClickListener(this);
		tab4.setOnClickListener(this);
		tab5.setOnClickListener(this);
		
		getBtnLeft().setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		setTabSelector(v);

		if (v == tab1) {
			if(homeFragment==null){
				homeFragment=new HomeFragment();
			}
			setHeaderImg(R.drawable.header_logo);
			changeFragment(homeFragment);

		} else if (v == tab2) {
			
			if(dealsFragment==null){
				dealsFragment=new DealsFragment();
			}
			setTitle("History");
			changeFragment(dealsFragment);

		} else if (v == tab3) {
			if(dealsFragment==null){
				dealsFragment=new DealsFragment();
			}
			setTitle("Deals");
			changeFragment(dealsFragment);

		} else if (v == tab4) {
			if(meFragment==null){
				meFragment=new MeFragment();
			}
			setTitle("Me");
			changeFragment(meFragment);

		} else if (v == tab5) {
			if(settingFragment==null){
				settingFragment=new SettingsFragment();
			}
			setTitle("Setting");
			changeFragment(settingFragment);

		}
		
		
		else if(v==getBtnLeft()){
			slidingMenu.toggle();
		}

	}

	private void setTabSelector(View v) {

		if (v == tab1) {

			tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab1_h,
					0, 0);

			tab2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab2, 0,
					0);
			tab3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab3, 0,
					0);
			tab4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab4, 0,
					0);
			tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab5, 0,
					0);

			tab1.setTextColor(getResources().getColor(R.color.blue));

			tab2.setTextColor(getResources().getColor(R.color.grey));
			tab3.setTextColor(getResources().getColor(R.color.grey));
			tab4.setTextColor(getResources().getColor(R.color.grey));
			tab5.setTextColor(getResources().getColor(R.color.grey));
		} else if (v == tab2) {

			tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab1, 0,
					0);

			tab2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab2_h,
					0, 0);
			tab3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab3, 0,
					0);
			tab4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab4, 0,
					0);
			tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab5, 0,
					0);

			tab1.setTextColor(getResources().getColor(R.color.grey));

			tab2.setTextColor(getResources().getColor(R.color.blue));
			tab3.setTextColor(getResources().getColor(R.color.grey));
			tab4.setTextColor(getResources().getColor(R.color.grey));
			tab5.setTextColor(getResources().getColor(R.color.grey));

		} else if (v == tab3) {
			tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab1, 0,
					0);

			tab2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab2, 0,
					0);
			tab3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab3_h,
					0, 0);
			tab4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab4, 0,
					0);
			tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab5, 0,
					0);

			tab1.setTextColor(getResources().getColor(R.color.grey));

			tab2.setTextColor(getResources().getColor(R.color.grey));
			tab3.setTextColor(getResources().getColor(R.color.blue));
			tab4.setTextColor(getResources().getColor(R.color.grey));
			tab5.setTextColor(getResources().getColor(R.color.grey));
		} else if (v == tab4) {
			tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab1, 0,
					0);

			tab2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab2, 0,
					0);
			tab3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab3, 0,
					0);
			tab4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab4_h,
					0, 0);
			tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab5, 0,
					0);

			tab1.setTextColor(getResources().getColor(R.color.grey));

			tab2.setTextColor(getResources().getColor(R.color.grey));
			tab3.setTextColor(getResources().getColor(R.color.grey));
			tab4.setTextColor(getResources().getColor(R.color.blue));
			tab5.setTextColor(getResources().getColor(R.color.grey));
		} else if (v == tab5) {
			tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab1, 0,
					0);

			tab2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab2, 0,
					0);
			tab3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab3, 0,
					0);
			tab4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab4, 0,
					0);
			tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab5_h,
					0, 0);

			tab1.setTextColor(getResources().getColor(R.color.grey));

			tab2.setTextColor(getResources().getColor(R.color.grey));
			tab3.setTextColor(getResources().getColor(R.color.grey));
			tab4.setTextColor(getResources().getColor(R.color.grey));
			tab5.setTextColor(getResources().getColor(R.color.blue));
		}

	}

	private void changeFragment(Fragment newFragment) {

		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.frgContainer, newFragment);
		transaction.commitAllowingStateLoss();

	}

}
