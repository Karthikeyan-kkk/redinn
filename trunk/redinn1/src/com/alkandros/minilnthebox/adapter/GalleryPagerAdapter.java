/*
 * Copyright 2014 trinea.cn All right reserved. This software is the
 * confidential and proprietary information of trinea.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with trinea.cn.
 */
package com.alkandros.minilnthebox.adapter;

import java.util.ArrayList;
import java.util.List;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.baseclass.MyApplication;
import com.alkandros.minilnthebox.manager.AppPreferenceManager;
import com.alkandros.minilnthebox.model.ConfigModel;
import com.alkandros.minilnthebox.model.ItemImageModel;
import com.alkandros.minilnthebox.model.SlideShowModel;
import com.alkandros.minilnthebox.utils.ListUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/**
 * ImagePagerAdapter
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2014-2-23
 */
public class GalleryPagerAdapter extends PagerAdapter {

	
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	protected DisplayImageOptions options;
	
    private Context       context;
    ArrayList<ItemImageModel> listItemImageModels;
    
    String header;

    public GalleryPagerAdapter(Context context, ArrayList<ItemImageModel> listItemImageModels){
        this.context = context;
        this.listItemImageModels = listItemImageModels;
        
        options = new DisplayImageOptions.Builder()
		.showImageOnLoading(R.drawable.cateloading)
		.showImageForEmptyUri(R.drawable.errorimg)
		.showImageOnFail(R.drawable.errorimg)
		.cacheInMemory(true)
		.cacheOnDisc(true)
		.considerExifParams(true)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.build();
        
        final MyApplication myApplication=(MyApplication)context.getApplicationContext();
        ConfigModel model=myApplication.getConfigModel();
        
        header=model.getImagePrefixModel().getItem_image_path()+model.getImagePrefixModel().getImage_thumb_md();
    }

    @Override
    public int getCount() {
        return ListUtils.getSize(listItemImageModels);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
      //  imageView.setImageResource(imageIdList.get(position));
        
        imageLoader.displayImage(header+listItemImageModels.get(position).getItem_image(), imageView,options);
        
        ((ViewPager)container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((ImageView)object);
    }
}
