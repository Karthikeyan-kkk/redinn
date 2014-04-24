package com.alkandros.minilnthebox.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.baseclass.BaseActivity;
import com.alkandros.minilnthebox.manager.NotifyManager;

public class DetailPageList extends BaseActivity implements OnClickListener {

	private ImageView imgViewChange;

	private TextView txtSort;
	private TextView txtRefine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_list);

		intializeUI();

		clickListner();

	}

	private void intializeUI() {

		setHeaderIntialize();
		setLeftSelector(R.drawable.left_arrow, R.drawable.left_arrow);
		setRightSelector(R.drawable.button_2_hover, R.drawable.button_2_hover);
		//setHeaderImg(R.drawable.header_logo);
		setHeaderTitle("Sample");

		imgViewChange = (ImageView) findViewById(R.id.imgViewChange);
		txtSort = (TextView) findViewById(R.id.txtSort);
		txtRefine = (TextView) findViewById(R.id.txtRefine);

	}

	private void clickListner() {
		imgViewChange.setOnClickListener(this);
		txtSort.setOnClickListener(this);
		txtRefine.setOnClickListener(this);

		getBtnLeft().setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		if (v == imgViewChange) {

		} else if (v == txtSort) {
			NotifyManager.showLongToast(activity, "SORT");
		} else if (v == txtRefine) {

		}
		 else if (v == getBtnLeft()) {
				
				finishActivity();
			} 
			

	}

}
