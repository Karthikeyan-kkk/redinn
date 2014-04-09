package com.alkandros.minilnthebox.manager;



import com.alkandros.minilnthebox.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class Headermanager {

	private LayoutInflater inflator;
	public View headerView;
	private TextView title;
	private Context context;
	private String titleTxt;
	private RelativeLayout.LayoutParams relativeParams;
	private ImageView rightIcon;
	private ImageView leftIcon;
	private RelativeLayout mainLayout;

	public Headermanager(Context context, String titleTxt) {
		this.context = context;
		this.titleTxt = titleTxt;
	}

	public void getHeader(RelativeLayout headerHolder) {
		initializeUI();
		relativeParams = new RelativeLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		relativeParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		headerHolder.addView(headerView, relativeParams);
	}

	private void initializeUI()
	{
		inflator 		= LayoutInflater.from(context);
		headerView 		= inflator.inflate(R.layout.common_header, null);
		mainLayout		=(RelativeLayout)headerView.findViewById(R.id.relativeMain);
		title 			= (TextView) headerView.findViewById(R.id.title);
		rightIcon 		= (ImageView) headerView.findViewById(R.id.rightIcon);
		leftIcon 		= (ImageView) headerView.findViewById(R.id.leftIcon);
		title.setText(titleTxt);
	}

	public RelativeLayout getHeader() {
		return mainLayout;
	}
	
	public ImageView getRightIcon() {
		return rightIcon;
	}

	public ImageView getleftIcon() {
		return leftIcon;
	}

}
