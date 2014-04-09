package com.alkandros.minilnthebox.manager;

import java.util.ArrayList;
import java.util.List;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.custom.slidinglib.SlidingMenu;
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
	private Button btnNext;
	private Button btnFinish;
	
	
	private static SliderManager instance;
	private Cursor contactCursor;
	
	public SliderManager(Context ctx)
	{
		context=ctx;
	
		instance = this;
		init();
		
	
	}
	public SliderManager() 
	{
			instance = this;
	}
	public void init()
	{
		layoutInflater  		= LayoutInflater.from(context);
		view 					= layoutInflater.inflate(R.layout.slide_search_page, null);
		
	
	}
	@SuppressWarnings({ "unused", "deprecation" })
	private void clickManager()
	{
		
	}
	
	
	private void clickListeners()
	{
		
	}
	
	public SlidingMenu initializeSlidingMenu(View slideButton) 
	{
		
		
		slidingMenu = new SlidingMenu(context);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		slidingMenu.setBehindWidth((Utils.getDeviceWidth(context)/2)-(slideButton.getWidth()+20));
		slidingMenu.attachToActivity((Activity) context, SlidingMenu.SLIDING_CONTENT);
		slidingMenu.setMenu(view);
		
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
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}