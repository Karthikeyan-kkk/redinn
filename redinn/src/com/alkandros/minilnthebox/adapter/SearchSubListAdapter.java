package com.alkandros.minilnthebox.adapter;

import java.util.ArrayList;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.manager.AppPreferenceManager;
import com.alkandros.minilnthebox.model.CategoriesModel;
import com.alkandros.minilnthebox.model.ImagePrefixModel;
import com.alkandros.minilnthebox.model.SlideNavigationModel;
import com.alkandros.minilnthebox.model.SubCategoriesModel;
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

public class SearchSubListAdapter extends ArrayAdapter<SubCategoriesModel> {

	Context context;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	 
	 protected DisplayImageOptions options;
	 
	 String imgHeader;
	
	public SearchSubListAdapter(Context context, ArrayList<SubCategoriesModel> objects) {
		super(context, 0, objects);

		this.context = context;
		
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
	
	
	public void setSubCategories(boolean isSub){
		
	}


	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		final SubCategoriesModel rowItem = getItem(position);

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			
			convertView = mInflater.inflate(R.layout.search_item, null);
			holder = new ViewHolder();

			

			holder.img = (ImageView) convertView
					.findViewById(R.id.img);

			holder.txtName = (TextView) convertView
					.findViewById(R.id.txtName);
			
			holder.txtCount = (TextView) convertView
					.findViewById(R.id.txtcount);

			

			
			convertView.setTag(holder);
		} else

			holder = (ViewHolder) convertView.getTag();

		
		holder.img.setVisibility(View.INVISIBLE);
	//	imageLoader.displayImage(imgHeader+rowItem.getImage(), holder.img,options);
		holder.txtName.setText(rowItem.getName());
		
	//	holder.txtCount.setText("("+rowItem.getCount()+")");
		
		
		
	


		return convertView;
	}

	/* private view holder class */
	private class ViewHolder {

		ImageView img;

		TextView txtCount;

		TextView txtName;

	}

	

}
