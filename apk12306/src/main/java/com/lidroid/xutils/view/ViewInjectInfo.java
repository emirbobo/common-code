package com.lidroid.xutils.view;

import com.bangcle.andjni.JniLib;

public class ViewInjectInfo
{
  public int parentId;
  public Object value;
  
  static
  {
    JniLib.a(ViewInjectInfo.class, 1033);
  }
  
  public native boolean equals(Object paramObject);
  
  public native int hashCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\view\ViewInjectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */