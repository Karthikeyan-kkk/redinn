package com.alkandros.minilnthebox.manager;

import android.content.Context;
import android.os.AsyncTask;

public class ApiManager2 extends AsyncTask<Void, Integer, String> {
	DataDownloadListener dataDownloadListener;
	InternetManager manager;
	String response, url;
	String[] name, value;
	Context context;
	CustomProgressDialog progress;

	public ApiManager2(String url, String[] name, String[] value,Context context) {
		this.url = url;
		this.name = name;
		this.value = value;
		this.context=context;
		 
			 progress = CustomProgressDialog.show(context, false);
	}

	public void setDataDownloadListener(
			DataDownloadListener dataDownloadListener) {
		this.dataDownloadListener = dataDownloadListener;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		progress.show();
	}

	@Override
	protected String doInBackground(Void... params) {

		manager = new InternetManager();
		try {
			response = manager.commonPostData(url, name, value);
			System.out.println("Api Class Response" + response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		progress.dismiss();
		dataDownloadListener.dataDownloadedSuccessfully(result);
	}

	public static interface DataDownloadListener {
		void dataDownloadedSuccessfully(String response);

	}

}
