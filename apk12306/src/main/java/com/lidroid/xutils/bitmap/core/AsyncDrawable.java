package com.lidroid.xutils.bitmap.core;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.View;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.BitmapUtils.BitmapLoadTask;
import java.lang.ref.WeakReference;

public class AsyncDrawable<T extends View>
  extends Drawable
{
  private final Drawable baseDrawable;
  private final WeakReference<BitmapUtils.BitmapLoadTask<T>> bitmapLoadTaskReference;
  
  static
  {
    JniLib.a(AsyncDrawable.class, 928);
  }
  
  public AsyncDrawable(Drawable paramDrawable, BitmapUtils.BitmapLoadTask<T> paramBitmapLoadTask)
  {
    if (paramBitmapLoadTask == null) {
      throw new IllegalArgumentException("bitmapWorkerTask may not be null");
    }
    this.baseDrawable = paramDrawable;
    this.bitmapLoadTaskReference = new WeakReference(paramBitmapLoadTask);
  }
  
  public native void clearColorFilter();
  
  public native void draw(Canvas paramCanvas);
  
  public native BitmapUtils.BitmapLoadTask<T> getBitmapWorkerTask();
  
  public native int getChangingConfigurations();
  
  public native Drawable.ConstantState getConstantState();
  
  public native Drawable getCurrent();
  
  public native int getIntrinsicHeight();
  
  public native int getIntrinsicWidth();
  
  public native int getMinimumHeight();
  
  public native int getMinimumWidth();
  
  public native int getOpacity();
  
  public native boolean getPadding(Rect paramRect);
  
  public native int[] getState();
  
  public native Region getTransparentRegion();
  
  public native void invalidateSelf();
  
  public native boolean isStateful();
  
  public native Drawable mutate();
  
  public native void scheduleSelf(Runnable paramRunnable, long paramLong);
  
  public native void setAlpha(int paramInt);
  
  public native void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void setBounds(Rect paramRect);
  
  public native void setChangingConfigurations(int paramInt);
  
  public native void setColorFilter(int paramInt, PorterDuff.Mode paramMode);
  
  public native void setColorFilter(ColorFilter paramColorFilter);
  
  public native void setDither(boolean paramBoolean);
  
  public native void setFilterBitmap(boolean paramBoolean);
  
  public native boolean setState(int[] paramArrayOfInt);
  
  public native boolean setVisible(boolean paramBoolean1, boolean paramBoolean2);
  
  public native void unscheduleSelf(Runnable paramRunnable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\core\AsyncDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */