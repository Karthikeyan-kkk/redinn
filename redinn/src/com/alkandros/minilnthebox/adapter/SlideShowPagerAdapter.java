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
import com.alkandros.minilnthebox.manager.AppPreferenceManager;
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
public class SlideShowPagerAdapter extends PagerAdapter {

	
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	protected DisplayImageOptions options;
	
    private Context       context;
    ArrayList<SlideShowModel> imageIdList;
    
    String header;

    public SlideShowPagerAdapter(Context context, ArrayList<SlideShowModel> imageIdList){
        this.context = context;
        this.imageIdList = imageIdList;
        
        options = new DisplayImageOptions.Builder()
		.showImageOnLoading(R.drawable.cateloading)
		.showImageForEmptyUri(R.drawable.errorimg)
		.showImageOnFail(R.drawable.errorimg)
		.cacheInMemory(true)
		.cacheOnDisc(true)
		.considerExifParams(true)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.build();
        
        header=AppPreferenceManager.getConfigModel(context).getImagePrefixModel().getSlide_show_path();
    }

    @Override
    public int getCount() {
        return ListUtils.getSize(imageIdList);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ScaleType.FIT_XY);
      //  imageView.setImageResource(imageIdList.get(position));
        
        imageLoader.displayImage(header+imageIdList.get(position).getImage(), imageView,options);
        
        ((ViewPager)container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((ImageView)object);
    }
}
