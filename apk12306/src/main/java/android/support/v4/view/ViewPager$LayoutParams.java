package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class ViewPager$LayoutParams
  extends ViewGroup.LayoutParams
{
  int childIndex;
  public int gravity;
  public boolean isDecor;
  boolean needsMeasure;
  int position;
  float widthFactor = 0.0F;
  
  public ViewPager$LayoutParams()
  {
    super(-1, -1);
  }
  
  public ViewPager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.access$400());
    this.gravity = paramContext.getInteger(0, 48);
    paramContext.recycle();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\view\ViewPager$LayoutParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */