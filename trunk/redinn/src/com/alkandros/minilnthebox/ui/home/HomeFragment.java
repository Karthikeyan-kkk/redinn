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


public class HomeFragment extends BaseFragment implements OnClickListener{
	
	
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
		view	= inflater.inflate(R.layout.frgment_home, container, false);
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
		
		
		linGrid1=(LinearLayout)view.findViewById(R.id.linGrid1);
		linGrid2=(LinearLayout)view.findViewById(R.id.linGrid2);
		linGrid3=(LinearLayout)view.findViewById(R.id.linGrid3);
		
		width=Utils.getDeviceWidth(context)/3;
		
		ViewUtils.setViewHeight(linGrid1, width);
		ViewUtils.setViewHeight(linGrid2, width);
		ViewUtils.setViewHeight(linGrid3, width);
		
		autoScrollViewPager=(AutoScrollViewPager)view.findViewById(R.id.view_pager);
		  imageIdList = new ArrayList<Integer>();
	        imageIdList.add(R.drawable.banner1);
	        imageIdList.add(R.drawable.banner2);
	        imageIdList.add(R.drawable.banner3);
	        imageIdList.add(R.drawable.banner4);
	        
	        imagePagerAdapter=new ImagePagerAdapter(context, imageIdList);
	        autoScrollViewPager.setAdapter(imagePagerAdapter);
	        
	        autoScrollViewPager.setInterval(2000);
	        autoScrollViewPager.startAutoScroll();
	        
	        
		circlePageIndicator=(CirclePageIndicator)view.findViewById(R.id.indicator);
		circlePageIndicator.setViewPager(autoScrollViewPager);
		
	}



	@Override
	public void onClick(View v) {
		
		if(v==getBtnLeft()){
			
		}
		else if(v==getBtnRight()){
			
		}
		
	}

}
