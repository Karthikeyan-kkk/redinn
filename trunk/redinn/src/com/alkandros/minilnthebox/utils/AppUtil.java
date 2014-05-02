// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.alkandros.minilnthebox.utils;


import android.content.Context;
import android.view.WindowManager;

// Referenced classes of package com.miniinthebox.android.util:
//            FileUtil, Constants

public final class AppUtil
{
  

    private AppUtil()
    {
    }

   

    public static int getScreenHeight(Context context)
    {
        return ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public static int getScreenWidth(Context context)
    {
        return ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

  
    private static Context mAppContext = null;

}
