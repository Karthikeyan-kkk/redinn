package com.alkandros.minilnthebox.baseclass;


import java.io.File;

import com.alkandros.minilnthebox.model.ConfigModel;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap.CompressFormat;

public class MyApplication extends Application{
	
	
	
	
	private ConfigModel configModel;
	
	@Override
	public void onCreate() {
	
		

      super.onCreate();

      initImageLoader(getApplicationContext());
      
      
		
	}
	

	 public static void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
       /* ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                        .threadPriority(Thread.NORM_PRIORITY - 2)
                        .denyCacheImageMultipleSizesInMemory()
                        .discCacheFileNameGenerator(new Md5FileNameGenerator())
                        .tasksProcessingOrder(QueueProcessingType.LIFO)
                      //  .writeDebugLogs() // Remove for release app
                        .build();*/

		 File cacheDir = StorageUtils.getCacheDirectory(context);
		 ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
		         .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
		         .discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75, null)
		         //.taskExecutor(...)
		         //.taskExecutorForCachedImages(...)
		         .threadPoolSize(3) // default
		         .threadPriority(Thread.NORM_PRIORITY - 1) // default
		         .tasksProcessingOrder(QueueProcessingType.FIFO) // default
		         .denyCacheImageMultipleSizesInMemory()
		         .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
		         .memoryCacheSize(2 * 1024 * 1024)
		         .memoryCacheSizePercentage(13) // default
		         .discCache(new UnlimitedDiscCache(cacheDir)) // default
		         .discCacheSize(50 * 1024 * 1024)
		         .discCacheFileCount(100)
		         .discCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
		         .imageDownloader(new BaseImageDownloader(context)) // default
		         .imageDecoder(new BaseImageDecoder(true)) // default
		         .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
		         .writeDebugLogs()
		         .build();
		 
		 // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
}


	public ConfigModel getConfigModel() {
		return configModel;
	}


	public void setConfigModel(ConfigModel configModel) {
		this.configModel = configModel;
	}
	
	 
	 
	 
 

}
