

package com.alkandros.minilnthebox.utils;

import android.text.TextUtils;
import java.security.MessageDigest;

public class StringUtil
{

	
	 
	 
	 public static String removeComma(String str) {
		  if (str.charAt(str.length()-1)==',')
		  {
		    str = str.replace(str.substring(str.length()-1), "");
		    return str;
		  }
		  else
		  {
		    return str;
		  }
		}
}
