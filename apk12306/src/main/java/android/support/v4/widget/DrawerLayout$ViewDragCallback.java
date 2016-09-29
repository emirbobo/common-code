package android.support.v4.widget;

import android.view.View;

class DrawerLayout$ViewDragCallback
  extends ViewDragHelper.Callback
{
  private final int mAbsGravity;
  private ViewDragHelper mDragger;
  private final Runnable mPeekRunnable = new Runnable()
  {
    public void run()
    {
      DrawerLayout.ViewDragCallback.this.peekDrawer();
    }
  };
  
  public DrawerLayout$ViewDragCallback(DrawerLayout paramDrawerLayout, int paramInt)
  {
    this.mAbsGravity = paramInt;
  }
  
  private void closeOtherDrawer()
  {
    int i = 3;
    if (this.mAbsGravity == 3) {
      i = 5;
    }
    View localView = this.this$0.findDrawerWithGravity(i);
    if (localView != null) {
      this.this$0.closeDrawer(localView);
    }
  }
  
  private void peekDrawer()
  {
    int j = 0;
    int k = this.mDragger.getEdgeSize();
    int i;
    View localView;
    if (this.mAbsGravity == 3)
    {
      i = 1;
      if (i == 0) {
        break label149;
      }
      localView = this.this$0.findDrawerWithGravity(3);
      if (localView != null) {
        j = -localView.getWidth();
      }
      j += k;
    }
    for (;;)
    {
      if ((localView != null) && (((i != 0) && (localView.getLeft() < j)) || ((i == 0) && (localView.getLeft() > j) && (this.this$0.getDrawerLockMode(localView) == 0))))
      {
        DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        this.mDragger.smoothSlideViewTo(localView, j, localView.getTop());
        localLayoutParams.isPeeking = true;
        this.this$0.invalidate();
        closeOtherDrawer();
        this.this$0.cancelChildViewTouch();
      }
      return;
      i = 0;
      break;
      label149:
      localView = this.this$0.findDrawerWithGravity(5);
      j = this.this$0.getWidth() - k;
    }
  }
  
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    if (this.this$0.checkDrawerViewAbsoluteGravity(paramView, 3)) {}
    for (paramInt1 = Math.max(-paramView.getWidth(), Math.min(paramInt1, 0));; paramInt1 = Math.max(paramInt2 - paramView.getWidth(), Math.min(paramInt1, paramInt2)))
    {
      return paramInt1;
      paramInt2 = this.this$0.getWidth();
    }
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getTop();
  }
  
  public int getViewHorizontalDragRange(View paramView)
  {
    return paramView.getWidth();
  }
  
  public void onEdgeDragStarted(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) == 1) {}
    for (View localView = this.this$0.findDrawerWithGravity(3);; localView = this.this$0.findDrawerWithGravity(5))
    {
      if ((localView != null) && (this.this$0.getDrawerLockMode(localView) == 0)) {
        this.mDragger.captureChildView(localView, paramInt2);
      }
      return;
    }
  }
  
  public boolean onEdgeLock(int paramInt)
  {
    return false;
  }
  
  public void onEdgeTouched(int paramInt1, int paramInt2)
  {
    this.this$0.postDelayed(this.mPeekRunnable, 160L);
  }
  
  public void onViewCaptured(View paramView, int paramInt)
  {
    ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).isPeeking = false;
    closeOtherDrawer();
  }
  
  public void onViewDragStateChanged(int paramInt)
  {
    this.this$0.updateDrawerState(this.mAbsGravity, paramInt, this.mDragger.getCapturedView());
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = paramView.getWidth();
    float f;
    if (this.this$0.checkDrawerViewAbsoluteGravity(paramView, 3))
    {
      f = (paramInt2 + paramInt1) / paramInt2;
      this.this$0.setDrawerViewOffset(paramView, f);
      if (f != 0.0F) {
        break label76;
      }
    }
    label76:
    for (paramInt1 = 4;; paramInt1 = 0)
    {
      paramView.setVisibility(paramInt1);
      this.this$0.invalidate();
      return;
      f = (this.this$0.getWidth() - paramInt1) / paramInt2;
      break;
    }
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
  {
    paramFloat2 = this.this$0.getDrawerViewOffset(paramView);
    int j = paramView.getWidth();
    if (this.this$0.checkDrawerViewAbsoluteGravity(paramView, 3))
    {
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {}
      for (i = 0;; i = -j)
      {
        this.mDragger.settleCapturedViewAt(i, paramView.getTop());
        this.this$0.invalidate();
        return;
      }
    }
    int i = this.this$0.getWidth();
    if ((paramFloat1 < 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
      i -= j;
    }
    for (;;)
    {
      break;
    }
  }
  
  public void removeCallbacks()
  {
    this.this$0.removeCallbacks(this.mPeekRunnable);
  }
  
  public void setDragger(ViewDragHelper paramViewDragHelper)
  {
    this.mDragger = paramViewDragHelper;
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    if ((this.this$0.isDrawerView(paramView)) && (this.this$0.checkDrawerViewAbsoluteGravity(paramView, this.mAbsGravity)) && (this.this$0.getDrawerLockMode(paramView) == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\widget\DrawerLayout$ViewDragCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */