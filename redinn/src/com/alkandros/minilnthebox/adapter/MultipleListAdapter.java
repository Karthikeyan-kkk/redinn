package com.alkandros.minilnthebox.adapter;

import java.util.ArrayList;

import com.alkandros.asyncimage.AsyncImageView;
import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.manager.AppPreferenceManager;
import com.alkandros.minilnthebox.model.ImagePrefixModel;
import com.alkandros.minilnthebox.model.SlideNavigationModel;
import com.alkandros.minilnthebox.model.TestModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MultipleListAdapter extends ArrayAdapter<TestModel> {

	Context context;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	 
	 protected DisplayImageOptions options;
	 
	 String imgHeader;
	 
	 private int VIEW_TYPE=0;
	
	public MultipleListAdapter(Context context, 
			ArrayList<TestModel> objects) {
		super(context, 0, objects);

		this.context = context;
		
		ImagePrefixModel tempImagePrefixModel=AppPreferenceManager.getConfigModel(context).getImagePrefixModel();
		
		imgHeader=tempImagePrefixModel.getItem_image_path()+tempImagePrefixModel.getImage_thumb_sm();

	}


	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		final TestModel rowItem = getItem(position);

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			
			if(VIEW_TYPE==0){
			convertView = mInflater.inflate(R.layout.itemlist_small, null);
			}else {
			convertView = mInflater.inflate(R.layout.itemlist_large, null);
			}
			holder = new ViewHolder();

			

			holder.baby_list_image = (AsyncImageView) convertView
					.findViewById(R.id.baby_list_image);

			
			
			holder.baby_list_currency = (TextView) convertView
					.findViewById(R.id.baby_list_currency);

			

			
			convertView.setTag(holder);
		} else

			holder = (ViewHolder) convertView.getTag();

		
		
		holder.baby_list_image.setUrl(rowItem.getImage());
	
		holder.baby_list_currency.setText("("+rowItem.getName()+")");
		
		
		
	


		return convertView;
	}
	
	public int getViewType(){
		
		return VIEW_TYPE;
	}
	
	public  void setViewType(int viewType){
		VIEW_TYPE =viewType;
		
	}

	/* private view holder class */
	private class ViewHolder {

		AsyncImageView baby_list_image;

		TextView baby_list_currency;

	

	}

	

}
