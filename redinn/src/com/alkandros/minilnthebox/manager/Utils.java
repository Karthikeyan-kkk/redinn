/**
 * 
 */
package com.alkandros.minilnthebox.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


public class Utils  {

	
	static String TAG = "LONG MSG";

	public static void longInfo(String str) {
		if (str.length() > 4000) {
			Log.i(TAG, str.substring(0, 4000));

			longInfo(str.substring(4000));
		} else
			Log.i(TAG, str);
	}
	
	
	
	public static boolean checkInternetConnection(Context context)
	{
		ConnectivityManager connec = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = connec.getActiveNetworkInfo();
		 if (netInfo != null && netInfo.isConnectedOrConnecting())
		 {
		        return true;
		 }
		else
		{
			return false;
		}
	}
	
}
