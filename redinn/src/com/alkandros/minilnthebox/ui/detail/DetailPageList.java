package com.alkandros.minilnthebox.ui.detail;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.adapter.MultipleListAdapter;
import com.alkandros.minilnthebox.baseclass.BaseActivity;
import com.alkandros.minilnthebox.baseclass.MyApplication;
import com.alkandros.minilnthebox.constants.IJsonConstants;
import com.alkandros.minilnthebox.constants.IUrlConstants;
import com.alkandros.minilnthebox.manager.ApiManager;
import com.alkandros.minilnthebox.manager.ApiManager.ApiJsonArrayResponseListner;
import com.alkandros.minilnthebox.manager.ApiManager.ApiJsonObjectResponseListner;
import com.alkandros.minilnthebox.manager.ApiManager2;
import com.alkandros.minilnthebox.manager.ApiManager2.DataDownloadListener;
import com.alkandros.minilnthebox.manager.NotifyManager;
import com.alkandros.minilnthebox.model.ConfigModel;
import com.alkandros.minilnthebox.model.CurrencyModel;
import com.alkandros.minilnthebox.model.ItemModel;
import com.alkandros.minilnthebox.model.ListItemModel;
import com.alkandros.minilnthebox.model.PriceModel;
import com.alkandros.minilnthebox.model.TestModel;
import com.google.gson.Gson;

public class DetailPageList extends BaseActivity implements OnClickListener {

	private ImageView imgViewChange;

	private TextView txtSort;
	private TextView txtRefine;

	private GridView gridList;

	private Bundle extras;
	private MultipleListAdapter multipleListAdapter;
	private ApiManager apiManager;
	private ArrayList<ListItemModel> arrayListItemModels;
	private ArrayList<ListItemModel> arrayListItemModelsFilter;
	private ApiManager2 apiManager2;
	String catID, subCatID;

	RelativeLayout relSort;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_list);

		extras = getIntent().getExtras();
		if (extras != null) {
			catID = extras.getString("CAT_ID");
			subCatID = extras.getString("SUBCAT_ID");

		}

		intializeUI();

		clickListner();

		// setData();

		callGetSublistApi(catID, subCatID);

	}

	private void callGetSublistApi(String catID, String subCatID) {

		final MyApplication myApplication = (MyApplication) getApplicationContext();
		ConfigModel configModel = myApplication.getConfigModel();

		final CurrencyModel currencyModel = configModel.getCurrencyModel();

		arrayListItemModels = new ArrayList<ListItemModel>();
		apiManager2 = new ApiManager2(IUrlConstants.GET_ITEMS_BY_SUB_CATEGORY
				+ subCatID + "/" + catID, new String[] { "" },
				new String[] { "" }, activity);

		apiManager2.setDataDownloadListener(new DataDownloadListener() {

			@Override
			public void dataDownloadedSuccessfully(String response) {
				try {
					JSONArray jsonArray = new JSONArray(response);

					System.out.println("Size==ARRAY" + jsonArray.length());

					for (int i = 0; i < jsonArray.length(); i++) {

						JSONObject jsonObject = jsonArray.getJSONObject(i);

						ListItemModel listItemModel = new Gson().fromJson(
								jsonObject.getJSONObject(IJsonConstants.J_Item)
										.toString(), ListItemModel.class);
						PriceModel priceModel = new PriceModel();
						JSONArray J_PriceArray = jsonObject
								.getJSONArray(IJsonConstants.J_ItemPrice);

						for (int j = 0; j < J_PriceArray.length(); j++) {

							JSONObject J_ItemPrice = J_PriceArray
									.getJSONObject(j);

							if (J_ItemPrice.getString(
									IJsonConstants.J_currency_id).equals(
									currencyModel.getCurr_id())) {

								priceModel = new Gson().fromJson(
										J_ItemPrice.toString(),
										PriceModel.class);

								break;
							}

						}

						listItemModel.setPriceModel(priceModel);

						System.out.println("**********" + i
								+ "**********************");

						System.out.println("ID " + listItemModel.getId());
						System.out.println("IMG "
								+ listItemModel.getItem_image());
						System.out.println("NAme " + listItemModel.getName());
						System.out.println("Rat " + listItemModel.getRating());
						System.out.println("Stock "
								+ listItemModel.getTotalstock());
						System.out.println("Price "
								+ listItemModel.getPriceModel().getPrice());

						System.out
								.println("*************************************");
						arrayListItemModels.add(listItemModel);
					}

					setData(arrayListItemModels);
					

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		apiManager2.execute();

	}

	private void setData(ArrayList<ListItemModel> listItemModels) {

		

		multipleListAdapter = new MultipleListAdapter(activity,
				listItemModels);

		gridList.setAdapter(multipleListAdapter);
	}

	private void intializeUI() {

		setHeaderIntialize();
		setLeftSelector(R.drawable.left_arrow, R.drawable.left_arrow);
		setRightSelector(R.drawable.button_2_hover, R.drawable.button_2_hover);
		// setHeaderImg(R.drawable.header_logo);
		setHeaderTitle("Sample");

		imgViewChange = (ImageView) findViewById(R.id.imgViewChange);
		txtSort = (TextView) findViewById(R.id.txtSort);
		txtRefine = (TextView) findViewById(R.id.txtRefine);
		gridList = (GridView) findViewById(R.id.gridList);
		relSort = (RelativeLayout) findViewById(R.id.relSort);

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
			if (multipleListAdapter != null) {

				if (multipleListAdapter.getViewType() == 0) {
					gridList.setNumColumns(1);
					multipleListAdapter.setViewType(1);

					imgViewChange
							.setBackgroundResource(R.drawable.baby_list_indicatind_1_normal);

				} else if (multipleListAdapter.getViewType() == 1) {
					multipleListAdapter.setViewType(2);
					gridList.setNumColumns(2);
					imgViewChange
							.setBackgroundResource(R.drawable.baby_list_indicatind_2_normal);
				} else if (multipleListAdapter.getViewType() == 2) {
					multipleListAdapter.setViewType(0);
					gridList.setNumColumns(1);
					imgViewChange
							.setBackgroundResource(R.drawable.baby_list_indicatind_3_normal);

				}

				gridList.setAdapter(multipleListAdapter);

			}

		} else if (v == txtSort) {

			
			//arrayListItemModels
			View view = LayoutInflater.from(this).inflate(R.layout.sort_popup,null);

			final Dialog sortDialog=NotifyManager.showBottomAnimatedAlert(view, activity);
			
			RelativeLayout bls_1_vg=(RelativeLayout)view.findViewById(R.id.bls_1_vg);
			RelativeLayout bls_2_vg=(RelativeLayout)view.findViewById(R.id.bls_2_vg);
			RelativeLayout bls_3_vg=(RelativeLayout)view.findViewById(R.id.bls_3_vg);
			RelativeLayout bls_4_vg=(RelativeLayout)view.findViewById(R.id.bls_4_vg);
			
			
			
			
			bls_1_vg.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					sortDialog.dismiss();
					
					setData(arrayListItemModels);
					
				}
			});

			bls_2_vg.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					sortDialog.dismiss();
					
				}
			});

			bls_3_vg.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					sortDialog.dismiss();
					
					
					
				}
			});

			bls_4_vg.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					sortDialog.dismiss();
					
					arrayListItemModelsFilter=new ArrayList<ListItemModel>();
					for (ListItemModel item : arrayListItemModels) {
						
						if(item.isIsnew()){
							arrayListItemModelsFilter.add(item);
						}
						
					}
					
					setData(arrayListItemModelsFilter);
					
				}
			});
			
		

		} else if (v == txtRefine) {

		} else if (v == getBtnLeft()) {

			finishActivity();
		}

	}

}
