package com.lidroid.xutils.bitmap;

import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.bitmap.core.BitmapSize;
import com.lidroid.xutils.bitmap.factory.BitmapFactory;
import com.lidroid.xutils.task.Priority;

public class BitmapDisplayConfig
{
  private Animation animation;
  private boolean autoRotation = false;
  private Bitmap.Config bitmapConfig = Bitmap.Config.RGB_565;
  private BitmapFactory bitmapFactory;
  private BitmapSize bitmapMaxSize;
  private Drawable loadFailedDrawable;
  private Drawable loadingDrawable;
  private Priority priority;
  private boolean showOriginal = false;
  
  static
  {
    JniLib.a(BitmapDisplayConfig.class, 924);
  }
  
  public native BitmapDisplayConfig cloneNew();
  
  public native Animation getAnimation();
  
  public native Bitmap.Config getBitmapConfig();
  
  public native BitmapFactory getBitmapFactory();
  
  public native BitmapSize getBitmapMaxSize();
  
  public native Drawable getLoadFailedDrawable();
  
  public native Drawable getLoadingDrawable();
  
  public native Priority getPriority();
  
  public native boolean isAutoRotation();
  
  public native boolean isShowOriginal();
  
  public native void setAnimation(Animation paramAnimation);
  
  public native void setAutoRotation(boolean paramBoolean);
  
  public native void setBitmapConfig(Bitmap.Config paramConfig);
  
  public native void setBitmapFactory(BitmapFactory paramBitmapFactory);
  
  public native void setBitmapMaxSize(BitmapSize paramBitmapSize);
  
  public native void setLoadFailedDrawable(Drawable paramDrawable);
  
  public native void setLoadingDrawable(Drawable paramDrawable);
  
  public native void setPriority(Priority paramPriority);
  
  public native void setShowOriginal(boolean paramBoolean);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\BitmapDisplayConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */