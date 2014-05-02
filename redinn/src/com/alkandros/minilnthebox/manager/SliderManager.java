package com.alkandros.minilnthebox.manager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.adapter.SearchListAdapter;
import com.alkandros.minilnthebox.adapter.SearchListAdapter.ItemClickListner;
import com.alkandros.minilnthebox.adapter.SearchSubListAdapter;
import com.alkandros.minilnthebox.custom.slidinglib.SlidingMenu;
import com.alkandros.minilnthebox.model.CategoriesModel;
import com.alkandros.minilnthebox.model.ImagePrefixModel;
import com.alkandros.minilnthebox.model.SlideNavigationModel;
import com.alkandros.minilnthebox.ui.detail.DetailPageList;
import com.alkandros.minilnthebox.utils.Utils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;



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
	
	
	private SearchListAdapter searchListAdapter;
	private LayoutInflater mInflater;
	 private View header ;
	 private SearchSubListAdapter searchSubListAdapter;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	 
	 protected DisplayImageOptions options;
	 String imgHeader;
	public SliderManager(Context ctx)
	{
		context=ctx;
	
		instance = this;
		
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
		
		 mInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		 
		 
		 
			options = new DisplayImageOptions.Builder()
			.showImageOnLoading(R.drawable.cateloading)
			.showImageForEmptyUri(R.drawable.errorimg)
			.showImageOnFail(R.drawable.errorimg)
			.cacheInMemory(true)
			.cacheOnDisc(true)
			.considerExifParams(true)
			.bitmapConfig(Bitmap.Config.RGB_565)
			.build();
			
			ImagePrefixModel tempImagePrefixModel=AppPreferenceManager.getConfigModel(context).getImagePrefixModel();
			
			imgHeader=tempImagePrefixModel.getItem_image_path()+tempImagePrefixModel.getImage_thumb_sm();
			
	}
	@SuppressWarnings({ "unused", "deprecation" })
	private void clickManager()
	{
		
	}
	
	
	private void clickListeners()
	{
		btnSearch.setOnClickListener(this);
		
		
		
	}
	
	public SlidingMenu initializeSlidingMenu(View slideButton) 
	{
		
		
		slidingMenu = new SlidingMenu(context);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
		
		slidingMenu.setBehindWidth((Utils.getDeviceWidth(context))-(slideButton.getWidth()+70));
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
			NotifyManager.showLongToast(context, "");
		}
		
	}
	
	private void setData() {
		
		//ArrayList<SlideNavigationModel> slideNavigationModels=AppPreferenceManager.getConfigModel(context).getSlideNavigationModels();
		
		
		
		final ArrayList<CategoriesModel> categoriesModels=AppPreferenceManager.getConfigModel(context).getCategoriesModels();
		
		
		
		
		
	
		
		
		searchListAdapter=new SearchListAdapter(context,  categoriesModels);
		
		lstSlideItems.setAdapter(null);
		
		lstSlideItems.setAdapter(searchListAdapter);
		
		searchListAdapter.setItemClickListener(new ItemClickListner() {
			
			@Override
			public void ItemClickListner(final int pos) {
				
				

				
				
				 header = mInflater.inflate(R.layout.search_item, null);
				ImageView imgleft=(ImageView)header.findViewById(R.id.imgleft);
				
				imgleft.setVisibility(View.VISIBLE);
				
				TextView txtName = (TextView) header.findViewById(R.id.txtName);
				
				TextView txtCount = (TextView) header.findViewById(R.id.txtcount);
				
				ImageView img=(ImageView)header.findViewById(R.id.img);
				
				imageLoader.displayImage(imgHeader+categoriesModels.get(pos).getImage(), img,options);
				txtName.setText(categoriesModels.get(pos).getName());
				
				header.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						
						lstSlideItems.removeHeaderView(header);
						
						setData();
						
					}
				});
				
				
				  searchSubListAdapter=new SearchSubListAdapter(context, categoriesModels.get(pos).getSubCategoriesModels());
				
				
				lstSlideItems.setAdapter(null);
				lstSlideItems.addHeaderView(header);
				
				lstSlideItems.setAdapter(searchSubListAdapter);
				
				searchSubListAdapter.setItemClickListener(new ItemClickListner() {
					
					@Override
					public void ItemClickListner(int position) {
						
						intent =new Intent(context,DetailPageList.class);
						intent.putExtra("CAT_ID", categoriesModels.get(pos).getId());
						intent.putExtra("SUBCAT_ID", categoriesModels.get(pos).getSubCategoriesModels().get(position).getId());
						context.startActivity(intent);
						((Activity) context).overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
						
						
					}
				});
				
			}
		});
		
		
	}
	
	
}