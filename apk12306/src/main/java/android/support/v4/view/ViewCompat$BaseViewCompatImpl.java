package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

class ViewCompat$BaseViewCompatImpl
  implements ViewCompat.ViewCompatImpl
{
  public boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return false;
  }
  
  public boolean canScrollVertically(View paramView, int paramInt)
  {
    return false;
  }
  
  public int getAccessibilityLiveRegion(View paramView)
  {
    return 0;
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    return null;
  }
  
  public float getAlpha(View paramView)
  {
    return 1.0F;
  }
  
  long getFrameTime()
  {
    return 10L;
  }
  
  public int getImportantForAccessibility(View paramView)
  {
    return 0;
  }
  
  public int getLabelFor(View paramView)
  {
    return 0;
  }
  
  public int getLayerType(View paramView)
  {
    return 0;
  }
  
  public int getLayoutDirection(View paramView)
  {
    return 0;
  }
  
  public int getMeasuredHeightAndState(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  public int getMeasuredState(View paramView)
  {
    return 0;
  }
  
  public int getMeasuredWidthAndState(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  public int getOverScrollMode(View paramView)
  {
    return 2;
  }
  
  public ViewParent getParentForAccessibility(View paramView)
  {
    return paramView.getParent();
  }
  
  public boolean hasTransientState(View paramView)
  {
    return false;
  }
  
  public boolean isOpaque(View paramView)
  {
    boolean bool2 = false;
    paramView = paramView.getBackground();
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if (paramView.getOpacity() == -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  public void postInvalidateOnAnimation(View paramView)
  {
    paramView.postInvalidateDelayed(getFrameTime());
  }
  
  public void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.postInvalidateDelayed(getFrameTime(), paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, getFrameTime());
  }
  
  public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postDelayed(paramRunnable, getFrameTime() + paramLong);
  }
  
  public int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSize(paramInt1, paramInt2);
  }
  
  public void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {}
  
  public void setAccessibilityLiveRegion(View paramView, int paramInt) {}
  
  public void setHasTransientState(View paramView, boolean paramBoolean) {}
  
  public void setImportantForAccessibility(View paramView, int paramInt) {}
  
  public void setLabelFor(View paramView, int paramInt) {}
  
  public void setLayerPaint(View paramView, Paint paramPaint) {}
  
  public void setLayerType(View paramView, int paramInt, Paint paramPaint) {}
  
  public void setLayoutDirection(View paramView, int paramInt) {}
  
  public void setOverScrollMode(View paramView, int paramInt) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\view\ViewCompat$BaseViewCompatImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */