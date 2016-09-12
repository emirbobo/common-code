package com.lidroid.xutils.bitmap.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.bangcle.andjni.JniLib;
import java.io.FileDescriptor;

public class BitmapDecoder
{
  private static final Object lock = new Object();
  
  static
  {
    JniLib.a(BitmapDecoder.class, 933);
  }
  
  public static native int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2);
  
  public static native Bitmap decodeByteArray(byte[] paramArrayOfByte);
  
  public static native Bitmap decodeFile(String paramString);
  
  public static native Bitmap decodeFileDescriptor(FileDescriptor paramFileDescriptor);
  
  public static native Bitmap decodeResource(Resources paramResources, int paramInt);
  
  public static native Bitmap decodeSampledBitmapFromByteArray(byte[] paramArrayOfByte, BitmapSize paramBitmapSize, Bitmap.Config paramConfig);
  
  public static native Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor paramFileDescriptor, BitmapSize paramBitmapSize, Bitmap.Config paramConfig);
  
  public static native Bitmap decodeSampledBitmapFromFile(String paramString, BitmapSize paramBitmapSize, Bitmap.Config paramConfig);
  
  public static native Bitmap decodeSampledBitmapFromResource(Resources paramResources, int paramInt, BitmapSize paramBitmapSize, Bitmap.Config paramConfig);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\core\BitmapDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */