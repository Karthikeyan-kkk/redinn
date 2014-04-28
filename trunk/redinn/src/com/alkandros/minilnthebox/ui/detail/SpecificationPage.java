package com.alkandros.minilnthebox.ui.detail;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.baseclass.BaseActivity;
import com.alkandros.minilnthebox.model.ColorModel;
import com.alkandros.minilnthebox.model.GetItemModel;
import com.alkandros.minilnthebox.model.ItemSizeColorModel;
import com.alkandros.minilnthebox.model.SizeModel;
import com.alkandros.minilnthebox.utils.StringUtil;

public class SpecificationPage extends BaseActivity{
	
	private Bundle extras;
	 private GetItemModel getItemModel;
	 
	 LinearLayout layoutSepcGroup;
	 private LayoutInflater mInflater;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_specification);
		
		
		
		extras = getIntent().getExtras();
		if (extras != null) {
			getItemModel=(GetItemModel) extras.getSerializable("DATA");
		}
		
		
		intializeUI();
		clickListner();
		setData();
	}

	

	private void setData() {
		
		//Set Collection , Category and Label
		layoutSepcGroup.addView(getSpecificationView("Collection", ""+getItemModel.getCollectionModel().getName()));
		layoutSepcGroup.addView(getSpecificationView("Category", ""+getItemModel.getCategoryModel().getName()));
		layoutSepcGroup.addView(getSpecificationView("Label", ""+getItemModel.getLabelModel().getLabel()));
		
		
		
		
		
		//Set Size and Color
		ArrayList<ColorModel> color=new ArrayList<ColorModel>();
		ArrayList<SizeModel> size=new ArrayList<SizeModel>();
		ArrayList<ItemSizeColorModel> itemSizeColorModels=getItemModel.getItemSizeColorModels();
		
		for (int i = 0; i < itemSizeColorModels.size(); i++) {
			
			boolean isColor=true;
			for (int j = 0; j < color.size(); j++) {
				
				if(itemSizeColorModels.get(i).getColor_id().endsWith(color.get(j).getId())){
					
					isColor=false;
					break;
					
				}
				
				
				
			}
			
			if(isColor){
				color.add(itemSizeColorModels.get(i).getColorModel());
			}
			
			
			
			boolean isSize=true;
			for (int j = 0; j < size.size(); j++) {
				
				if(itemSizeColorModels.get(i).getSize_id().endsWith(size.get(j).getId())){
					
					isSize=false;
					break;
					
				}
				
				
				
			}
			
			if(isSize){
				size.add(itemSizeColorModels.get(i).getSizeModel());
			}
			
			
			
		}
		
		String sColor="";
		
		for (int i = 0; i < color.size(); i++) {
			
			sColor+=color.get(i).getColor()+",";
			
		}
		
		sColor=StringUtil.removeComma(sColor);
		
		
		String sSize="";
		
		for (int i = 0; i < size.size(); i++) {
			
			sSize+=size.get(i).getSize()+",";
			
		}
		
		sSize=StringUtil.removeComma(sSize);
		
		
		
		
		layoutSepcGroup.addView(getSpecificationView("Color", sColor));
		layoutSepcGroup.addView(getSpecificationView("Size", sSize));
		
	}



	private void intializeUI() {
		
		setHeaderIntialize();
		setLeftSelector(R.drawable.left_arrow, R.drawable.left_arrow);
		setRightSelector(R.drawable.button_2_hover, R.drawable.button_2_hover);
		
		layoutSepcGroup=(LinearLayout)findViewById(R.id.layoutSepcGroup);
		 mInflater = (LayoutInflater) activity	.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	}
	
	private void clickListner() {
		// TODO Auto-generated method stub
		
	}
	
	private View getSpecificationView(String name,String value){
		
		View convertView= mInflater.inflate(R.layout.spec_group_item, null);
		
		TextView txtTagName=(TextView)convertView.findViewById(R.id.txtTagName);
		TextView txtTagValue=(TextView)convertView.findViewById(R.id.txtTagValue);
		
		txtTagName.setText(name);
		txtTagValue.setText(value);
    	
    	
		return convertView;
	}

}
