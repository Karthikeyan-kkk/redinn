package com.alkandros.minilnthebox.ui.detail;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	private ApiManager2 apiManager2;
	String catID, subCatID;

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

					setData();
					System.out.println("Size==List"
							+ arrayListItemModels.size());

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		apiManager2.execute();

	}

	private void setData() {

		ArrayList<TestModel> testModels = new ArrayList<TestModel>();

		testModels
				.add(new TestModel("ONE",
						"http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		testModels
				.add(new TestModel("ONE1",
						"http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"));
		testModels
				.add(new TestModel(
						"ONE2",
						"http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"));
		testModels
				.add(new TestModel("ONE3",
						"http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"));
		testModels
				.add(new TestModel(
						"ONE4",
						"http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"));
		testModels
				.add(new TestModel(
						"ONE5",
						"http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"));
		testModels
				.add(new TestModel(
						"ONE6",
						"http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"));
		testModels
				.add(new TestModel(
						"ONE7",
						"http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"));
		testModels
				.add(new TestModel(
						"ONE8",
						"http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"));
		testModels
				.add(new TestModel(
						"ONE9",
						"http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"));
		testModels
				.add(new TestModel(
						"ONE10",
						"http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"));
		testModels
				.add(new TestModel("ONE11",
						"http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"));
		testModels
				.add(new TestModel(
						"ONE12",
						"http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"));
		testModels
				.add(new TestModel("ONE13",
						"http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		/*
		 * testModels.add(new TestModel("ONE",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"
		 * )); testModels.add(new TestModel("ONE1",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"
		 * )); testModels.add(new TestModel("ONE2",
		 * "http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"
		 * )); testModels.add(new TestModel("ONE3",
		 * "http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"
		 * )); testModels.add(new TestModel("ONE4",
		 * "http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"
		 * )); testModels.add(new TestModel("ONE5",
		 * "http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"
		 * )); testModels.add(new TestModel("ONE6",
		 * "http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"
		 * )); testModels.add(new TestModel("ONE7",
		 * "http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"
		 * )); testModels.add(new TestModel("ONE8",
		 * "http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"
		 * )); testModels.add(new TestModel("ONE9",
		 * "http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"
		 * )); testModels.add(new TestModel("ONE10",
		 * "http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"
		 * )); testModels.add(new TestModel("ONE11",
		 * "http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"
		 * )); testModels.add(new TestModel("ONE12",
		 * "http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"
		 * )); testModels.add(new TestModel("ONE13",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"
		 * ));
		 * 
		 * testModels.add(new TestModel("ONE",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"
		 * )); testModels.add(new TestModel("ONE1",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"
		 * )); testModels.add(new TestModel("ONE2",
		 * "http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"
		 * )); testModels.add(new TestModel("ONE3",
		 * "http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"
		 * )); testModels.add(new TestModel("ONE4",
		 * "http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"
		 * )); testModels.add(new TestModel("ONE5",
		 * "http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"
		 * )); testModels.add(new TestModel("ONE6",
		 * "http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"
		 * )); testModels.add(new TestModel("ONE7",
		 * "http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"
		 * )); testModels.add(new TestModel("ONE8",
		 * "http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"
		 * )); testModels.add(new TestModel("ONE9",
		 * "http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"
		 * )); testModels.add(new TestModel("ONE10",
		 * "http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"
		 * )); testModels.add(new TestModel("ONE11",
		 * "http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"
		 * )); testModels.add(new TestModel("ONE12",
		 * "http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"
		 * )); testModels.add(new TestModel("ONE13",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"
		 * ));
		 * 
		 * testModels.add(new TestModel("ONE",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"
		 * )); testModels.add(new TestModel("ONE1",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"
		 * )); testModels.add(new TestModel("ONE2",
		 * "http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"
		 * )); testModels.add(new TestModel("ONE3",
		 * "http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"
		 * )); testModels.add(new TestModel("ONE4",
		 * "http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"
		 * )); testModels.add(new TestModel("ONE5",
		 * "http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"
		 * )); testModels.add(new TestModel("ONE6",
		 * "http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"
		 * )); testModels.add(new TestModel("ONE7",
		 * "http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"
		 * )); testModels.add(new TestModel("ONE8",
		 * "http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"
		 * )); testModels.add(new TestModel("ONE9",
		 * "http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"
		 * )); testModels.add(new TestModel("ONE10",
		 * "http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"
		 * )); testModels.add(new TestModel("ONE11",
		 * "http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"
		 * )); testModels.add(new TestModel("ONE12",
		 * "http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"
		 * )); testModels.add(new TestModel("ONE13",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"
		 * ));
		 * 
		 * testModels.add(new TestModel("ONE",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"
		 * )); testModels.add(new TestModel("ONE1",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"
		 * )); testModels.add(new TestModel("ONE2",
		 * "http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"
		 * )); testModels.add(new TestModel("ONE3",
		 * "http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"
		 * )); testModels.add(new TestModel("ONE4",
		 * "http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"
		 * )); testModels.add(new TestModel("ONE5",
		 * "http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"
		 * )); testModels.add(new TestModel("ONE6",
		 * "http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"
		 * )); testModels.add(new TestModel("ONE7",
		 * "http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"
		 * )); testModels.add(new TestModel("ONE8",
		 * "http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"
		 * )); testModels.add(new TestModel("ONE9",
		 * "http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"
		 * )); testModels.add(new TestModel("ONE10",
		 * "http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"
		 * )); testModels.add(new TestModel("ONE11",
		 * "http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"
		 * )); testModels.add(new TestModel("ONE12",
		 * "http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"
		 * )); testModels.add(new TestModel("ONE13",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"
		 * ));
		 * 
		 * testModels.add(new TestModel("ONE",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"
		 * )); testModels.add(new TestModel("ONE1",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"
		 * )); testModels.add(new TestModel("ONE2",
		 * "http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"
		 * )); testModels.add(new TestModel("ONE3",
		 * "http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"
		 * )); testModels.add(new TestModel("ONE4",
		 * "http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"
		 * )); testModels.add(new TestModel("ONE5",
		 * "http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"
		 * )); testModels.add(new TestModel("ONE6",
		 * "http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"
		 * )); testModels.add(new TestModel("ONE7",
		 * "http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"
		 * )); testModels.add(new TestModel("ONE8",
		 * "http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"
		 * )); testModels.add(new TestModel("ONE9",
		 * "http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"
		 * )); testModels.add(new TestModel("ONE10",
		 * "http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"
		 * )); testModels.add(new TestModel("ONE11",
		 * "http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"
		 * )); testModels.add(new TestModel("ONE12",
		 * "http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"
		 * )); testModels.add(new TestModel("ONE13",
		 * "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"
		 * ));
		 */

		multipleListAdapter = new MultipleListAdapter(activity,
				arrayListItemModels);

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

			showSortPopup(activity);

		} else if (v == txtRefine) {
			NotifyManager.showShortToast(activity, "Refine");
			/*
			 * multipleListAdapter.setViewType(0);
			 * gridList.setAdapter(multipleListAdapter);
			 */
		} else if (v == getBtnLeft()) {

			finishActivity();
		}

	}

	public void showSortPopup(final Context activity) {

		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.sort_popup, null, false);

		final PopupWindow pw = new PopupWindow(view, LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, true);

		RelativeLayout rel1 = (RelativeLayout) view.findViewById(R.id.rel1);
		RelativeLayout rel2 = (RelativeLayout) view.findViewById(R.id.rel2);
		RelativeLayout rel3 = (RelativeLayout) view.findViewById(R.id.rel3);
		RelativeLayout rel4 = (RelativeLayout) view.findViewById(R.id.rel4);

		rel1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				pw.dismiss();
			}
		});

		rel2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				pw.dismiss();
			}
		});

		rel3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				pw.dismiss();
			}
		});

		rel4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				pw.dismiss();
			}
		});

		
		
		 
		pw.showAtLocation(view, Gravity.BOTTOM, 0, 0);
		

	}

}
