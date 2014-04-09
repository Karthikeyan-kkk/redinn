package com.alkandros.minilnthebox.ui.home;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.adapter.ImagePagerAdapter;
import com.alkandros.minilnthebox.baseclass.BaseFragment;
import com.alkandros.minilnthebox.custom.autoscrollviewadapter.AutoScrollViewPager;
import com.alkandros.minilnthebox.custom.viewpagerindicator.CirclePageIndicator;


public class HomeFragment extends BaseFragment{
	
	
	private View view;
	private LayoutInflater mInflater;
	private Context context;
	
	private CirclePageIndicator circlePageIndicator;
	private AutoScrollViewPager autoScrollViewPager;
	
	private List<Integer>       imageIdList;
	
	private ImagePagerAdapter imagePagerAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		mInflater	= inflater;
		view	= inflater.inflate(R.layout.frgment_home, container, false);
		context=getActivity();
		
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
		return view;
	}

}
