package android.support.v4.widget;

import android.view.View;

class SlidingPaneLayout$DragHelperCallback
  extends ViewDragHelper.Callback
{
  private SlidingPaneLayout$DragHelperCallback(SlidingPaneLayout paramSlidingPaneLayout) {}
  
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.access$400(this.this$0).getLayoutParams();
    paramInt2 = this.this$0.getPaddingLeft() + paramView.leftMargin;
    int i = SlidingPaneLayout.access$700(this.this$0);
    return Math.min(Math.max(paramInt1, paramInt2), paramInt2 + i);
  }
  
  public int getViewHorizontalDragRange(View paramView)
  {
    return SlidingPaneLayout.access$700(this.this$0);
  }
  
  public void onEdgeDragStarted(int paramInt1, int paramInt2)
  {
    SlidingPaneLayout.access$200(this.this$0).captureChildView(SlidingPaneLayout.access$400(this.this$0), paramInt2);
  }
  
  public void onViewCaptured(View paramView, int paramInt)
  {
    this.this$0.setAllChildrenVisible();
  }
  
  public void onViewDragStateChanged(int paramInt)
  {
    if (SlidingPaneLayout.access$200(this.this$0).getViewDragState() == 0)
    {
      if (SlidingPaneLayout.access$300(this.this$0) != 0.0F) {
        break label63;
      }
      this.this$0.updateObscuredViewsVisibility(SlidingPaneLayout.access$400(this.this$0));
      this.this$0.dispatchOnPanelClosed(SlidingPaneLayout.access$400(this.this$0));
      SlidingPaneLayout.access$502(this.this$0, false);
    }
    for (;;)
    {
      return;
      label63:
      this.this$0.dispatchOnPanelOpened(SlidingPaneLayout.access$400(this.this$0));
      SlidingPaneLayout.access$502(this.this$0, true);
    }
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SlidingPaneLayout.access$600(this.this$0, paramInt1);
    this.this$0.invalidate();
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    int j = this.this$0.getPaddingLeft() + localLayoutParams.leftMargin;
    int i;
    if (paramFloat1 <= 0.0F)
    {
      i = j;
      if (paramFloat1 == 0.0F)
      {
        i = j;
        if (SlidingPaneLayout.access$300(this.this$0) <= 0.5F) {}
      }
    }
    else
    {
      i = j + SlidingPaneLayout.access$700(this.this$0);
    }
    SlidingPaneLayout.access$200(this.this$0).settleCapturedViewAt(i, paramView.getTop());
    this.this$0.invalidate();
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    if (SlidingPaneLayout.access$100(this.this$0)) {}
    for (boolean bool = false;; bool = ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).slideable) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\widget\SlidingPaneLayout$DragHelperCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */