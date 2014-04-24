package com.alkandros.minilnthebox.baseclass;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.manager.NotifyManager;
import com.alkandros.minilnthebox.manager.SelectorManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseActivity extends Activity {

	public Intent intent;

	public Activity activity;
	private ImageView leftIcon;
	private ImageView rightIcon;
	private TextView title;
	private TextView txtcartCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		activity = this;

	}

	public void setHeaderIntialize() {

		leftIcon = (ImageView) findViewById(R.id.leftIcon);
		rightIcon = (ImageView) findViewById(R.id.rightIcon);
		title = (TextView) findViewById(R.id.title);
		txtcartCount = (TextView) findViewById(R.id.txtcartCount);
		
		

	}
	
	

	public void setHeaderTitle(String titleContent) {

		title.setBackgroundResource(0);
		title.setText(titleContent);

	}

	public void setHeaderImg(int imgContent) {

		title.setBackgroundResource(imgContent);
		title.setText("");
	}

	public void setLeftSelector(int normal, int press) {

		SelectorManager.setBackground(leftIcon, SelectorManager
				.getButtonDrawableByScreenCathegory(activity, normal, press));

	}

	public void setRightSelector(int normal, int press) {

		SelectorManager.setBackground(rightIcon, SelectorManager
				.getButtonDrawableByScreenCathegory(activity, normal, press));
	}

	public ImageView getBtnLeft() {

		return leftIcon;
	}

	public ImageView getBtnRight() {
		return rightIcon;
	}

	public TextView getTitleView() {
		return title;
	}

	public void startBaseActivity(Intent i) {

		this.startActivity(i);
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		this.overridePendingTransition(R.anim.push_right_in,
				R.anim.push_right_out);

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();

		this.overridePendingTransition(R.anim.push_right_in,
				R.anim.push_right_out);
	}
	
	public void finishActivity(){
		
		finish();
		this.overridePendingTransition(R.anim.push_right_in,
				R.anim.push_right_out);
	}

	

	

}
