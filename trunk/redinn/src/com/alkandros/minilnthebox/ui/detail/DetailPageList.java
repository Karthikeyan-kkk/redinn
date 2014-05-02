package com.alkandros.minilnthebox.ui.detail;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.adapter.MultipleListAdapter;
import com.alkandros.minilnthebox.baseclass.BaseActivity;
import com.alkandros.minilnthebox.constants.IUrlConstants;
import com.alkandros.minilnthebox.manager.ApiManager;
import com.alkandros.minilnthebox.manager.ApiManager.ApiResponseListner;
import com.alkandros.minilnthebox.manager.NotifyManager;
import com.alkandros.minilnthebox.model.TestModel;

public class DetailPageList extends BaseActivity implements OnClickListener {

	private ImageView imgViewChange;

	private TextView txtSort;
	private TextView txtRefine;
	
	private GridView gridList;

	private Bundle extras;
	private MultipleListAdapter multipleListAdapter;
	private ApiManager apiManager;
	String catID,subCatID;
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

	//	clickListner();
		
		//setData();
		
		callGetSublistApi(catID,subCatID);

	}

	

	private void callGetSublistApi(String catID, String subCatID) {
		
		apiManager = new ApiManager(IUrlConstants.GET_ITEMS_BY_SUB_CATEGORY+subCatID+"/"+catID, activity,
				true);
		
		apiManager.setApiResponseListener(new ApiResponseListner() {
			
			@Override
			public void dataDownloadedSuccessfully(JSONObject response) {
				
				
				try {
					JSONArray items=new JSONArray(response.toString());
					
					
					System.out.println("Size=="+items.length());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			@Override
			public void dataDownloadedFailed(String error) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}



	private void setData() {
		
		
		ArrayList<TestModel> testModels=new ArrayList<TestModel>();
		
		testModels.add(new TestModel("ONE", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		testModels.add(new TestModel("ONE1", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"));
		testModels.add(new TestModel("ONE2", "http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"));
		testModels.add(new TestModel("ONE3", "http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"));
		testModels.add(new TestModel("ONE4", "http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"));
		testModels.add(new TestModel("ONE5", "http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"));
		testModels.add(new TestModel("ONE6", "http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"));
		testModels.add(new TestModel("ONE7", "http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"));
		testModels.add(new TestModel("ONE8", "http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"));
		testModels.add(new TestModel("ONE9", "http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"));
		testModels.add(new TestModel("ONE10", "http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"));
		testModels.add(new TestModel("ONE11", "http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"));
		testModels.add(new TestModel("ONE12", "http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"));
		testModels.add(new TestModel("ONE13", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		/*
		testModels.add(new TestModel("ONE", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		testModels.add(new TestModel("ONE1", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"));
		testModels.add(new TestModel("ONE2", "http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"));
		testModels.add(new TestModel("ONE3", "http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"));
		testModels.add(new TestModel("ONE4", "http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"));
		testModels.add(new TestModel("ONE5", "http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"));
		testModels.add(new TestModel("ONE6", "http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"));
		testModels.add(new TestModel("ONE7", "http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"));
		testModels.add(new TestModel("ONE8", "http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"));
		testModels.add(new TestModel("ONE9", "http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"));
		testModels.add(new TestModel("ONE10", "http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"));
		testModels.add(new TestModel("ONE11", "http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"));
		testModels.add(new TestModel("ONE12", "http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"));
		testModels.add(new TestModel("ONE13", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		
		testModels.add(new TestModel("ONE", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		testModels.add(new TestModel("ONE1", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"));
		testModels.add(new TestModel("ONE2", "http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"));
		testModels.add(new TestModel("ONE3", "http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"));
		testModels.add(new TestModel("ONE4", "http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"));
		testModels.add(new TestModel("ONE5", "http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"));
		testModels.add(new TestModel("ONE6", "http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"));
		testModels.add(new TestModel("ONE7", "http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"));
		testModels.add(new TestModel("ONE8", "http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"));
		testModels.add(new TestModel("ONE9", "http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"));
		testModels.add(new TestModel("ONE10", "http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"));
		testModels.add(new TestModel("ONE11", "http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"));
		testModels.add(new TestModel("ONE12", "http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"));
		testModels.add(new TestModel("ONE13", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		
		testModels.add(new TestModel("ONE", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		testModels.add(new TestModel("ONE1", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"));
		testModels.add(new TestModel("ONE2", "http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"));
		testModels.add(new TestModel("ONE3", "http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"));
		testModels.add(new TestModel("ONE4", "http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"));
		testModels.add(new TestModel("ONE5", "http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"));
		testModels.add(new TestModel("ONE6", "http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"));
		testModels.add(new TestModel("ONE7", "http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"));
		testModels.add(new TestModel("ONE8", "http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"));
		testModels.add(new TestModel("ONE9", "http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"));
		testModels.add(new TestModel("ONE10", "http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"));
		testModels.add(new TestModel("ONE11", "http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"));
		testModels.add(new TestModel("ONE12", "http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"));
		testModels.add(new TestModel("ONE13", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		
		testModels.add(new TestModel("ONE", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		testModels.add(new TestModel("ONE1", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"));
		testModels.add(new TestModel("ONE2", "http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"));
		testModels.add(new TestModel("ONE3", "http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"));
		testModels.add(new TestModel("ONE4", "http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"));
		testModels.add(new TestModel("ONE5", "http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"));
		testModels.add(new TestModel("ONE6", "http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"));
		testModels.add(new TestModel("ONE7", "http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"));
		testModels.add(new TestModel("ONE8", "http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"));
		testModels.add(new TestModel("ONE9", "http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"));
		testModels.add(new TestModel("ONE10", "http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"));
		testModels.add(new TestModel("ONE11", "http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"));
		testModels.add(new TestModel("ONE12", "http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"));
		testModels.add(new TestModel("ONE13", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		
		testModels.add(new TestModel("ONE", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		testModels.add(new TestModel("ONE1", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-7.jpg"));
		testModels.add(new TestModel("ONE2", "http://bloximages.chicago2.vip.townnews.com/azstarnet.com/content/tncms/assets/v3/business/b/4f/b4fcd1e8-2e38-50c0-857d-0fbe466c3d68/50b777e089212.image.jpg"));
		testModels.add(new TestModel("ONE3", "http://im.tech2.in.com/gallery/2012/dec/stockimage_070930177527_640x360.jpg"));
		testModels.add(new TestModel("ONE4", "http://1.bp.blogspot.com/-C-NVc1o7sxM/UlnzHPCYwbI/AAAAAAAAGQI/0Qk12eDMSdg/s640/nhung-hinh-anh-dep-de-thuong-nhat-6.jpeg"));
		testModels.add(new TestModel("ONE5", "http://static3.businessinsider.com/image/52cddfb169beddee2a6c2246/the-29-coolest-us-air-force-images-of-the-year.jpg"));
		testModels.add(new TestModel("ONE6", "http://img.xcitefun.net/users/2013/11/343324,xcitefun-creative-edited-images-digital-wizardry-.jpg"));
		testModels.add(new TestModel("ONE7", "http://2.bp.blogspot.com/-PnWhMJrjdNY/T043tW4cLyI/AAAAAAAAMHk/J7ZnMEdeyPI/s1600/bm-image-733729.jpeg"));
		testModels.add(new TestModel("ONE8", "http://crispyclicks.com/wp-content/uploads/2013/03/weird-images-weird-pictures-floating-in-the-air-4.jpg"));
		testModels.add(new TestModel("ONE9", "http://static.indianexpress.com/m-images/Wed%20Nov%2013%202013,%2014:24%20hrs/M_Id_438809_Saturn_image.jpg"));
		testModels.add(new TestModel("ONE10", "http://images4.fanpop.com/image/photos/22300000/coolest-random-22350423-1600-1200.jpg"));
		testModels.add(new TestModel("ONE11", "http://www.abc.net.au/radionational/image/4220698-3x2-700x467.jpg"));
		testModels.add(new TestModel("ONE12", "http://www.davidgaledigital.co.uk/wp-content/uploads/2014/04/best_images_of_2012_1355117665_1355117684.jpg"));
		testModels.add(new TestModel("ONE13", "http://www.wallpaperfunda.com/wp-content/uploads/2014/03/images-2.jpg"));
		

		*/
		
		
		multipleListAdapter=new MultipleListAdapter(activity, testModels);
		
		gridList.setAdapter(multipleListAdapter);
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
		gridList=(GridView)findViewById(R.id.gridList);
		
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
			if(multipleListAdapter!=null){
				
				if(multipleListAdapter.getViewType()==0){
					
					multipleListAdapter.setViewType(1);
					gridList.setNumColumns(1);
					
					
				}
				else if(multipleListAdapter.getViewType()==1){
					multipleListAdapter.setViewType(2);
					gridList.setNumColumns(2);
				}
				else if(multipleListAdapter.getViewType()==2){
					multipleListAdapter.setViewType(0);
					
				}
				
				gridList.setAdapter(multipleListAdapter);
				
			}
			

		} else if (v == txtSort) {
			
			NotifyManager.showShortToast(activity, "SORT");
			/*multipleListAdapter.setViewType(1);
			gridList.setAdapter(multipleListAdapter);*/
			
		} else if (v == txtRefine) {
			NotifyManager.showShortToast(activity, "Refine");
			/*multipleListAdapter.setViewType(0);
			gridList.setAdapter(multipleListAdapter);*/
		}
		 else if (v == getBtnLeft()) {
				
				finishActivity();
			} 
			

	}

}
