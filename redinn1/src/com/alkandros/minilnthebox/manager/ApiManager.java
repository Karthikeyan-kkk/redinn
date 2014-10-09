package com.alkandros.minilnthebox.manager;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.constants.IUrlConstants;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import android.content.Context;

public class ApiManager {

	RequestQueue queue;
	
	private CustomProgressDialog progress;
	
	private Context context;
	
	private boolean isProgress;
	
	private ApiJsonObjectResponseListner apiJsonObjectResponseListner;
	private ApiJsonArrayResponseListner apiJsonArrayResponseListner;
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
	
	public void setApiJsonObjectResponseListener(ApiJsonObjectResponseListner apiJsonObjectResponseListner){
	
		this.apiJsonObjectResponseListner=apiJsonObjectResponseListner;
		
		 if(Utils.checkInternetConnection(context)){
			 callGetApiJson(url);
			 }else{
				 NotifyManager.showLongToast(context, context.getResources().getString(R.string.connection_error_message));
			 }
	}
	
	public void setApiJsonArrayResponseListener(ApiJsonArrayResponseListner apiJsonArrayResponseListner){
		
		this.apiJsonArrayResponseListner=apiJsonArrayResponseListner;
		
		 if(Utils.checkInternetConnection(context)){
			 callGetApiJsonArray(url);
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
				apiJsonObjectResponseListner.dataDownloadedSuccessfully(response);
				
				
				
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				
				if(isProgress){
					
					progress.dismiss();
					
				}
				Utils.longInfo("Error"+error.toString());
				
				apiJsonObjectResponseListner.dataDownloadedFailed(error.getMessage());
				
			}
		});
		
		queue.add(jsObjRequest);
		
		}catch(Exception exception){
			if(isProgress){
				
				progress.dismiss();
				
			}
			 NotifyManager.showLongToast(context, context.getResources().getString(R.string.common_error_message));
			 apiJsonObjectResponseListner.dataDownloadedFailed(exception.getMessage());
		}
	}
	
	
	private void callGetApiJsonArray(String url) {
		
//		Response.Listener<JSONArray> listener = new Response.Listener<JSONArray>() {public void onResponse(JSONArray response) {};
		
		
		
		
		if(isProgress)
			
			progress.show();
			
		
		System.out.println("URL == "+url);
		try{
		
			
			JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Listener<JSONArray>() {

				@Override
				public void onResponse(JSONArray arg0) {
					
					
				}
			}, new Response.ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError error) {
					
					if(isProgress){
						
						progress.dismiss();
						
					}
					Utils.longInfo("Error"+error.toString());
					
					apiJsonArrayResponseListner.dataDownloadedFailed(error.getMessage());
					
				}
			} );
			queue.add(jsonArrayRequest);
		
		}catch(Exception exception){
			if(isProgress){
				
				progress.dismiss();
				
			}
			 NotifyManager.showLongToast(context, context.getResources().getString(R.string.common_error_message));
			 apiJsonArrayResponseListner.dataDownloadedFailed(exception.getMessage());
		}
	}
	
	
	
	public static interface ApiJsonObjectResponseListner {

		void dataDownloadedSuccessfully(JSONObject response) ;
		
		

		void dataDownloadedFailed(String error);

	}
	
	public static interface ApiJsonArrayResponseListner {

		void dataDownloadedSuccessfully(JSONArray response) ;
		
		

		void dataDownloadedFailed(String error);

	}

	
	
	


}
