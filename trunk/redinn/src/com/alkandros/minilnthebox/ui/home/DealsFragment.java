package com.alkandros.minilnthebox.ui.home;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.adapter.ImagePagerAdapter;
import com.alkandros.minilnthebox.baseclass.BaseFragment;
import com.alkandros.minilnthebox.custom.autoscrollviewadapter.AutoScrollViewPager;
import com.alkandros.minilnthebox.custom.viewpagerindicator.CirclePageIndicator;
import com.alkandros.minilnthebox.utils.Utils;
import com.alkandros.minilnthebox.utils.ViewUtils;


public class DealsFragment extends BaseFragment implements OnClickListener{
	
	
	private View view;
	private LayoutInflater mInflater;
	private Context context;
	
	private CirclePageIndicator circlePageIndicator;
	private AutoScrollViewPager autoScrollViewPager;
	
	private List<Integer>       imageIdList;
	
	private ImagePagerAdapter imagePagerAdapter;
	private LinearLayout linGrid1;
	private LinearLayout linGrid2;
	private LinearLayout linGrid3;
	int width=0;
	
	
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		mInflater	= inflater;
		view	= inflater.inflate(R.layout.fragment_deals, container, false);
		context=getActivity();
		
		
		intialazeUI();
		ClickListner();
		
		
		return view;
	}



	private void ClickListner() {
		getBtnLeft().setOnClickListener(this);
		getBtnRight().setOnClickListener(this);
		
	}



	private void intialazeUI() {
		
		setHeaderIntialize(view);
		setLeftSelector(R.drawable.button_1_hover, R.drawable.button_1_hover);
		setRightSelector(R.drawable.button_2_hover, R.drawable.button_2_hover);
		setHeaderImg(R.drawable.header_logo);
		
		setIntializeSlider(getBtnLeft());
		
	}



	@Override
	public void onClick(View v) {
		
		if(v==getBtnLeft()){
			slidingMenu.toggle();
		}
		else if(v==getBtnRight()){
			
		}
		
	}

}
