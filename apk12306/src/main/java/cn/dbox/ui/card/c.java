package cn.dbox.ui.card;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;

public class c
  extends GridView
{
  private a mGridViewScrollListener;
  private int mLastVisiblePosition = 0;
  AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener()
  {
    public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      if ((paramAnonymousAbsListView.getLastVisiblePosition() > 0) && (paramAnonymousInt == 0))
      {
        int j = paramAnonymousAbsListView.getLastVisiblePosition();
        c localc = c.this;
        int i = j;
        if (c.this.mLastVisiblePosition > j) {
          i = c.this.mLastVisiblePosition;
        }
        c.access$002(localc, i);
      }
      if ((paramAnonymousAbsListView.getLastVisiblePosition() > 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (paramAnonymousInt == 0) && (c.this.mGridViewScrollListener != null)) {
        c.this.mGridViewScrollListener.a();
      }
    }
  };
  
  public c(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  public int getGridViewLastVisiblePosition()
  {
    if (this.mLastVisiblePosition == 0) {
      this.mLastVisiblePosition = getLastVisiblePosition();
    }
    return this.mLastVisiblePosition;
  }
  
  public void initView(Context paramContext)
  {
    setBackgroundColor(-789000);
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setCacheColorHint(-1);
    setStretchMode(2);
    setSelector(new ColorDrawable(0));
    setOnScrollListener(this.mOnScrollListener);
    setVerticalScrollBarEnabled(false);
  }
  
  public void setOnGridViewScrollListener(a parama)
  {
    this.mGridViewScrollListener = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\card\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */