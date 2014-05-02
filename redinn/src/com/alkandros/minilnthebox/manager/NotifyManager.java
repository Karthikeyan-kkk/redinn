package com.alkandros.minilnthebox.manager;






import com.alkandros.minilnthebox.R;
import com.alkandros.minilnthebox.utils.AppUtil;

import android.app.Dialog;
import android.content.Context;

import android.view.View;
import android.widget.Toast;

public class NotifyManager {
	
	public static void showShortToast(Context context, String message)
	{
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}
	
	public static void showLongToast(Context context, String message)
	{
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}
	
	 public static Dialog showBottomAnimatedAlert(View view,Context context)
	    {
	        Dialog dialog = new Dialog(view.getContext(),R.style.popdialog);
	        
	        
	        view.setMinimumWidth(AppUtil.getScreenHeight(context));
	        android.view.WindowManager.LayoutParams layoutparams = dialog.getWindow().getAttributes();
	        layoutparams.x = 0;
	        layoutparams.y = -AppUtil.getScreenHeight(context);
	        layoutparams.gravity = 80;
	        dialog.onWindowAttributesChanged(layoutparams);
	        dialog.setCanceledOnTouchOutside(true);
	        dialog.setContentView(view);
	        dialog.show();
	        return dialog;
	    }
	
	

}
