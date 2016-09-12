package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class ViewPager$MyAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  ViewPager$MyAccessibilityDelegate(ViewPager paramViewPager) {}
  
  private boolean canScroll()
  {
    boolean bool = true;
    if ((ViewPager.access$200(this.this$0) != null) && (ViewPager.access$200(this.this$0).getCount() > 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramView = AccessibilityRecordCompat.obtain();
    paramView.setScrollable(canScroll());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (ViewPager.access$200(this.this$0) != null))
    {
      paramView.setItemCount(ViewPager.access$200(this.this$0).getCount());
      paramView.setFromIndex(ViewPager.access$300(this.this$0));
      paramView.setToIndex(ViewPager.access$300(this.this$0));
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
    paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
    if (this.this$0.canScrollHorizontally(1)) {
      paramAccessibilityNodeInfoCompat.addAction(4096);
    }
    if (this.this$0.canScrollHorizontally(-1)) {
      paramAccessibilityNodeInfoCompat.addAction(8192);
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {}
    for (;;)
    {
      return bool;
      switch (paramInt)
      {
      default: 
        bool = false;
        break;
      case 4096: 
        if (this.this$0.canScrollHorizontally(1)) {
          this.this$0.setCurrentItem(ViewPager.access$300(this.this$0) + 1);
        } else {
          bool = false;
        }
        break;
      case 8192: 
        if (this.this$0.canScrollHorizontally(-1)) {
          this.this$0.setCurrentItem(ViewPager.access$300(this.this$0) - 1);
        } else {
          bool = false;
        }
        break;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\view\ViewPager$MyAccessibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */