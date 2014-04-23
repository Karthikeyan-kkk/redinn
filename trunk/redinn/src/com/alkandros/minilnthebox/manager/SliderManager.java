package com.alkandros.minilnthebox.manager;

import java.util.ArrayList;
import java.util.List;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.adapter.SearchListAdapter;
import com.alkandros.minilnthebox.adapter.SlideShowPagerAdapter;
import com.alkandros.minilnthebox.custom.slidinglib.SlidingMenu;
import com.alkandros.minilnthebox.model.SlideNavigationModel;
import com.alkandros.minilnthebox.model.SlideShowModel;
import com.alkandros.minilnthebox.utils.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;


public class SliderManager implements OnClickListener {

	private LayoutInflater layoutInflater;
	private Context context;
	private View view;
	private SlidingMenu slidingMenu;
	private ImageView imgGreetings;
	private Intent intent;
	
	ArrayList<View> image= new ArrayList<View>();
	ArrayList<View> oldimage= new ArrayList<View>();
	private ViewFlipper vf;  
    GestureDetector detector;
    private static final int SWIPE_MIN_DISTANCE = 80;
	private static final int SWIPE_THRESHOLD_VELOCITY = 150;
	private Button btnSearch;
	private ListView lstSlideItems;
	
	
	private static SliderManager instance;
	private Cursor contactCursor;
	private ArrayList<SlideNavigationModel> slideNavigationModels;
	
	private SearchListAdapter searchListAdapter;
	
	public SliderManager(Context ctx,ArrayList<SlideNavigationModel> slideNavigationModels)
	{
		context=ctx;
	
		instance = this;
		this.slideNavigationModels=slideNavigationModels;
		init();
		clickListeners();
		
		setData();
		
		
	
	}
	
	public SliderManager() 
	{
			instance = this;
	}
	public void init()
	{
		layoutInflater  		= LayoutInflater.from(context);
		view 					= layoutInflater.inflate(R.layout.slide_search_page, null);
		btnSearch=(Button)view.findViewById(R.id.btnSearch);
		lstSlideItems=(ListView)view.findViewById(R.id.lstSlideItems);
	}
	@SuppressWarnings({ "unused", "deprecation" })
	private void clickManager()
	{
		
	}
	
	
	private void clickListeners()
	{
		btnSearch.setOnClickListener(this);
		
		
		lstSlideItems.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				
				
			}
		});
	}
	
	public SlidingMenu initializeSlidingMenu(View slideButton) 
	{
		
		
		slidingMenu = new SlidingMenu(context);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		slidingMenu.setBehindWidth((Utils.getDeviceWidth(context)/2)-(slideButton.getWidth()+20));
		slidingMenu.attachToActivity((Activity) context, SlidingMenu.SLIDING_CONTENT);
		slidingMenu.setMenu(view);
		slidingMenu.setShadowDrawable(R.drawable.slidingmenu_shadow);
		slidingMenu.setShadowWidth(25);
		
		return slidingMenu;
	}

	public static final SliderManager instance() {
		if (instance != null)
		{
			return instance;
		}
		else
		{
			instance  = new SliderManager();
		}
		return instance;	
		
		//throw new RuntimeException("SliderManager not instantiated yet");
	}
	@Override
	public void onClick(View v) {
		if(v==btnSearch){
			//NotifyManager.showLongToast(context, ""+slideNavigationModels.size());
		}
		
	}
	
	private void setData() {
		ArrayList<SlideNavigationModel> slideNavigationModels=AppPreferenceManager.getConfigModel(context).getSlideNavigationModels();
		
		searchListAdapter=new SearchListAdapter(context,  slideNavigationModels);
		
		lstSlideItems.setAdapter(searchListAdapter);
		
		
		
	}
	
	
}