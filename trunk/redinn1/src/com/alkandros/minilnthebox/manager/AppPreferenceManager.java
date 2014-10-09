/**
 * 
 */
package com.alkandros.minilnthebox.manager;

import java.io.IOException;
import java.util.ArrayList;

import com.alkandros.minilnthebox.model.ConfigModel;



import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;


/**
 * @author Kishore
 *
 */
public class AppPreferenceManager {
	
	
	private static String PREFERENCE_VALUE="MINILNTHEBOX";

	public static void saveIp(String ip,Context context) 
	{
		SharedPreferences preferences;
		preferences = context.getSharedPreferences(PREFERENCE_VALUE,Context.MODE_PRIVATE);
		preferences.edit().putString("ip", ip).commit();
	}
	
	public static String getIp(Context context) 
	{
		SharedPreferences preferences;
		preferences = context.getSharedPreferences(PREFERENCE_VALUE,Context.MODE_PRIVATE);
		String  ip = preferences.getString("ip", "192.168.1.31");
		return ip;
	}
	
	
	
	
	
	
	public static void saveConfigModel(Context ctx, ConfigModel configModel) {
		SharedPreferences prefs = ctx.getSharedPreferences(PREFERENCE_VALUE,Context.MODE_PRIVATE);
		Editor editor = prefs.edit();
	
		editor.putString("ConfigModel", ObjectSerializer.serialize(configModel));
		Log.e("", "Total serialize"+ObjectSerializer.serialize(configModel));
		
		editor.commit();
	}

	public static ConfigModel  getConfigModel(Context ctx) {
		ConfigModel listItems = new ConfigModel();
		SharedPreferences prefs =  ctx.getSharedPreferences(PREFERENCE_VALUE,Context.MODE_PRIVATE);

		try {
			listItems = (ConfigModel) ObjectSerializer.deserialize(prefs.getString("ConfigModel", ObjectSerializer.serialize(new ConfigModel())));
			
			
			Log.e("", "Total serialize GEt"+prefs.getString("ConfigModel", ObjectSerializer.serialize(new ConfigModel())));
			
		} catch (IOException e) {
			Log.e("", "Error" + e.getMessage());
			e.printStackTrace();
		}
		return listItems;
	}
	
	
}
