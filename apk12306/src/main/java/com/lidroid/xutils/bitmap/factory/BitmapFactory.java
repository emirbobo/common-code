package com.lidroid.xutils.bitmap.factory;

import android.graphics.Bitmap;

public abstract interface BitmapFactory
{
  public abstract BitmapFactory cloneNew();
  
  public abstract Bitmap createBitmap(Bitmap paramBitmap);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\factory\BitmapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */