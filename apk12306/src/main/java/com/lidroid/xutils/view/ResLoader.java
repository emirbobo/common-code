package com.lidroid.xutils.view;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class ResLoader
{
  static
  {
    JniLib.a(ResLoader.class, 1031);
  }
  
  public static native Object loadRes(ResType paramResType, Context paramContext, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\view\ResLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */