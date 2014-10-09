package com.alkandros.minilnthebox.manager;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;



import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class InternetManager.
 */
public class InternetManager  {
	
	/** The httpclient. */
	HttpClient httpclient;
	
	/** The httpget. */
	HttpGet httpget;
	
	/** The httpresponse. */
	HttpResponse httpresponse;
	
	/** The httpentity. */
	HttpEntity httpentity;
	
	/** The url. */
	String url;
	
	/** The response. */
	String response = null;
	
	/** The data. */
	byte[] data = null;
	
	/** The Is server conn. */
	public boolean IsServerConn = true;

	
	/**
	 * Instantiates a new internet manager.
	 */
	public InternetManager() {

	}
	public InternetManager(String Url) {
this.url=Url;
	}
	/**
	 * URL request.
	 * 
	 * @return the string
	 */
	public String URLRequest() {

		httpclient = new DefaultHttpClient();

		try {
			httpget = new HttpGet(url);
			httpresponse = httpclient.execute(httpget);
			httpentity = httpresponse.getEntity();
			response = EntityUtils.toString(httpentity);
			response = response.trim();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			IsServerConn = false;
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			IsServerConn = false;
		}
		return response;

	}

	/**
	 * Check internet connection.
	 * 
	 * @param context
	 *            the context
	 * @return the boolean
	 */
	public static Boolean checkInternetConnection(Context context) {
		ConnectivityManager connec = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
		
		/*if (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting()|| 
				connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting()) 
		{
			return true;
		} */
		
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

	/**
	 * Url post json.
	 *
	 * @param url the url
	 * @param jsonreq the jsonreq
	 * @return the string
	 * @throws ClientProtocolException the client protocol exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the jSON exception
	 * @throws ClientWebException the client web exception
	 */
	public String urlPostJson(String url, String jsonreq)throws ClientProtocolException, IOException,JSONException  {
		HttpClient client = new DefaultHttpClient();
		HttpResponse response;
		try {
			HttpPost post = new HttpPost(url);
			System.out.println("jsonreq " + jsonreq);
			StringEntity se = new StringEntity(jsonreq.toString());
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json"));
			post.setEntity(se);
			post.setHeader("Accept", "application/json");
			post.setHeader("Content-type", "application/json");
			response = client.execute(post);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println("result " + result);
			return result;
		} 
		
		catch (IOException e) {
			System.out.println("IO EXCEPTION");
			return "";
		}
		catch (IllegalArgumentException e) {
		System.out.println("Illegal Argument");
		}
		

		return "";
	}
	public String commonPostData(String url ,String [] name,String[] value) throws Exception {
		/** Create a new HttpClient and Post Header */
		String text = "";
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		/** Add your data */
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		for (int i = 0; i < value.length; i++) {
			System.out.println("values  " + value[i]);
			nameValuePairs.add(new BasicNameValuePair(name[i], value[i]));
		}
		httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		/** Execute HTTP Post Request */
		HttpResponse response = httpclient.execute(httppost);
		InputStream is = response.getEntity().getContent();
		BufferedInputStream bis = new BufferedInputStream(is);
		ByteArrayBuffer baf = new ByteArrayBuffer(20);
		int current = 0;
		while ((current = bis.read()) != -1) {
			baf.append((byte) current);
		}
		/** Convert the Bytes read to a String. */
		text = new String(baf.toByteArray());
		
		return text;
	}
	
}
