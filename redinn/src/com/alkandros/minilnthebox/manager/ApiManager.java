package com.alkandros.minilnthebox.manager;

import java.util.ArrayList;

import org.json.JSONObject;


import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.constants.IUrlConstants;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import android.content.Context;

public class ApiManager {

	RequestQueue queue;
	
	private CustomProgressDialog progress;
	
	private Context context;
	
	private boolean isProgress;
	
	private ApiResponseListner apiResponseListner;
	private String url;
	
	public ApiManager(String url,Context context,boolean isProgress) {
		// TODO Auto-generated constructor stub
		
		
		 queue = Volley.newRequestQueue(context);
		 
		this.context=context;
		 this.isProgress=isProgress;
		 
		 this.url=url;
		 
		 if(isProgress)
		 progress = CustomProgressDialog.show(context, false);
		 
		
		 
		 
	}
	
	public void setApiResponseListener(ApiResponseListner apiResponseListner){
	
		this.apiResponseListner=apiResponseListner;
		
		 if(Utils.checkInternetConnection(context)){
			 callGetApiJson(url);
			 }else{
				 NotifyManager.showLongToast(context, context.getResources().getString(R.string.connection_error_message));
			 }
	}

	private void callGetApiJson(String url) {
		
		if(isProgress)
			
			progress.show();
			
		
		System.out.println("URL == "+url);
		try{
		JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				if(isProgress){
					
					progress.dismiss();
					
				}
				
				Utils.longInfo(response.toString());
				apiResponseListner.dataDownloadedSuccessfully(response);
				
				
				
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				
				if(isProgress){
					
					progress.dismiss();
					
				}
				Utils.longInfo("Error"+error.toString());
				
				apiResponseListner.dataDownloadedFailed(error.getMessage());
				
			}
		});
		
		queue.add(jsObjRequest);
		
		}catch(Exception exception){
			if(isProgress){
				
				progress.dismiss();
				
			}
			 NotifyManager.showLongToast(context, context.getResources().getString(R.string.common_error_message));
			apiResponseListner.dataDownloadedFailed(exception.getMessage());
		}
	}
	
	
	
	
	public static interface ApiResponseListner {

		void dataDownloadedSuccessfully(JSONObject response) ;

		void dataDownloadedFailed(String error);

	}

	
	
	


}
