package com.lidroid.xutils.bitmap.core;

import com.bangcle.andjni.JniLib;

public class BitmapSize
{
  public static final BitmapSize ZERO = new BitmapSize(0, 0);
  private final int height;
  private final int width;
  
  static
  {
    JniLib.a(BitmapSize.class, 934);
  }
  
  public BitmapSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public native int getHeight();
  
  public native int getWidth();
  
  public native BitmapSize scale(float paramFloat);
  
  public native BitmapSize scaleDown(int paramInt);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\core\BitmapSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */