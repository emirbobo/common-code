package cn.dbox.ui.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

public class ScrollCardView
  extends c
{
  public ScrollCardView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScrollCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScrollCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\card\ScrollCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */