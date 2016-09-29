package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout
  extends ViewGroup
{
  private static final int DEFAULT_FADE_COLOR = -858993460;
  private static final int DEFAULT_OVERHANG_SIZE = 32;
  static final SlidingPanelLayoutImpl IMPL;
  private static final int MIN_FLING_VELOCITY = 400;
  private static final String TAG = "SlidingPaneLayout";
  private boolean mCanSlide;
  private int mCoveredFadeColor;
  private final ViewDragHelper mDragHelper;
  private boolean mFirstLayout = true;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private boolean mIsUnableToDrag;
  private final int mOverhangSize;
  private PanelSlideListener mPanelSlideListener;
  private int mParallaxBy;
  private float mParallaxOffset;
  private final ArrayList<DisableLayerRunnable> mPostedRunnables = new ArrayList();
  private boolean mPreservedOpenState;
  private Drawable mShadowDrawable;
  private float mSlideOffset;
  private int mSlideRange;
  private View mSlideableView;
  private int mSliderFadeColor = -858993460;
  private final Rect mTmpRect = new Rect();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17) {
      IMPL = new SlidingPanelLayoutImplJBMR1();
    }
    for (;;)
    {
      return;
      if (i >= 16) {
        IMPL = new SlidingPanelLayoutImplJB();
      } else {
        IMPL = new SlidingPanelLayoutImplBase();
      }
    }
  }
  
  public SlidingPaneLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mOverhangSize = ((int)(32.0F * f + 0.5F));
    ViewConfiguration.get(paramContext);
    setWillNotDraw(false);
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
    ViewCompat.setImportantForAccessibility(this, 1);
    this.mDragHelper = ViewDragHelper.create(this, 0.5F, new DragHelperCallback(null));
    this.mDragHelper.setEdgeTrackingEnabled(1);
    this.mDragHelper.setMinVelocity(400.0F * f);
  }
  
  private boolean closePane(View paramView, int paramInt)
  {
    boolean bool = false;
    if ((this.mFirstLayout) || (smoothSlideTo(0.0F, paramInt)))
    {
      this.mPreservedOpenState = false;
      bool = true;
    }
    return bool;
  }
  
  private void dimChildView(View paramView, float paramFloat, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      int i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (localLayoutParams.dimPaint == null) {
        localLayoutParams.dimPaint = new Paint();
      }
      localLayoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (ViewCompat.getLayerType(paramView) != 2) {
        ViewCompat.setLayerType(paramView, 2, localLayoutParams.dimPaint);
      }
      invalidateChildRegion(paramView);
    }
    for (;;)
    {
      return;
      if (ViewCompat.getLayerType(paramView) != 0)
      {
        if (localLayoutParams.dimPaint != null) {
          localLayoutParams.dimPaint.setColorFilter(null);
        }
        paramView = new DisableLayerRunnable(paramView);
        this.mPostedRunnables.add(paramView);
        ViewCompat.postOnAnimation(this, paramView);
      }
    }
  }
  
  private void invalidateChildRegion(View paramView)
  {
    IMPL.invalidateChildRegion(this, paramView);
  }
  
  private void onPanelDragged(int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
    this.mSlideOffset = ((paramInt - (getPaddingLeft() + localLayoutParams.leftMargin)) / this.mSlideRange);
    if (this.mParallaxBy != 0) {
      parallaxOtherViews(this.mSlideOffset);
    }
    if (localLayoutParams.dimWhenOffset) {
      dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
    }
    dispatchOnPanelSlide(this.mSlideableView);
  }
  
  private boolean openPane(View paramView, int paramInt)
  {
    boolean bool = true;
    if ((this.mFirstLayout) || (smoothSlideTo(1.0F, paramInt))) {
      this.mPreservedOpenState = true;
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void parallaxOtherViews(float paramFloat)
  {
    Object localObject = (LayoutParams)this.mSlideableView.getLayoutParams();
    int i;
    int j;
    if ((((LayoutParams)localObject).dimWhenOffset) && (((LayoutParams)localObject).leftMargin <= 0))
    {
      i = 1;
      int k = getChildCount();
      j = 0;
      label38:
      if (j >= k) {
        return;
      }
      localObject = getChildAt(j);
      if (localObject != this.mSlideableView) {
        break label71;
      }
    }
    for (;;)
    {
      j++;
      break label38;
      i = 0;
      break;
      label71:
      int m = (int)((1.0F - this.mParallaxOffset) * this.mParallaxBy);
      this.mParallaxOffset = paramFloat;
      ((View)localObject).offsetLeftAndRight(m - (int)((1.0F - paramFloat) * this.mParallaxBy));
      if (i != 0) {
        dimChildView((View)localObject, 1.0F - this.mParallaxOffset, this.mCoveredFadeColor);
      }
    }
  }
  
  private static boolean viewIsOpaque(View paramView)
  {
    boolean bool = true;
    if (ViewCompat.isOpaque(paramView)) {}
    for (;;)
    {
      return bool;
      if (Build.VERSION.SDK_INT >= 18)
      {
        bool = false;
      }
      else
      {
        paramView = paramView.getBackground();
        if (paramView != null)
        {
          if (paramView.getOpacity() != -1) {
            bool = false;
          }
        }
        else {
          bool = false;
        }
      }
    }
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      i = localViewGroup.getChildCount() - 1;
      if (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {
          paramBoolean = true;
        }
      }
    }
    for (;;)
    {
      return paramBoolean;
      i--;
      break;
      if ((paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
  }
  
  @Deprecated
  public boolean canSlide()
  {
    return this.mCanSlide;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean closePane()
  {
    return closePane(this.mSlideableView, 0);
  }
  
  public void computeScroll()
  {
    if (this.mDragHelper.continueSettling(true))
    {
      if (this.mCanSlide) {
        break label26;
      }
      this.mDragHelper.abort();
    }
    for (;;)
    {
      return;
      label26:
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void dispatchOnPanelClosed(View paramView)
  {
    if (this.mPanelSlideListener != null) {
      this.mPanelSlideListener.onPanelClosed(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelOpened(View paramView)
  {
    if (this.mPanelSlideListener != null) {
      this.mPanelSlideListener.onPanelOpened(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelSlide(View paramView)
  {
    if (this.mPanelSlideListener != null) {
      this.mPanelSlideListener.onPanelSlide(paramView, this.mSlideOffset);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    View localView;
    if (getChildCount() > 1)
    {
      localView = getChildAt(1);
      if ((localView != null) && (this.mShadowDrawable != null)) {
        break label39;
      }
    }
    for (;;)
    {
      return;
      localView = null;
      break;
      label39:
      int k = this.mShadowDrawable.getIntrinsicWidth();
      int j = localView.getLeft();
      int i = localView.getTop();
      int m = localView.getBottom();
      this.mShadowDrawable.setBounds(j - k, i, j, m);
      this.mShadowDrawable.draw(paramCanvas);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save(2);
    if ((this.mCanSlide) && (!localLayoutParams.slideable) && (this.mSlideableView != null))
    {
      paramCanvas.getClipBounds(this.mTmpRect);
      this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
      paramCanvas.clipRect(this.mTmpRect);
    }
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      return bool;
      if ((localLayoutParams.dimWhenOffset) && (this.mSlideOffset > 0.0F))
      {
        if (!paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(true);
        }
        Bitmap localBitmap = paramView.getDrawingCache();
        if (localBitmap != null)
        {
          paramCanvas.drawBitmap(localBitmap, paramView.getLeft(), paramView.getTop(), localLayoutParams.dimPaint);
          bool = false;
        }
        else
        {
          Log.e("SlidingPaneLayout", "drawChild: child view " + paramView + " returned null drawing cache");
          bool = super.drawChild(paramCanvas, paramView, paramLong);
        }
      }
      else
      {
        if (paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(false);
        }
        bool = super.drawChild(paramCanvas, paramView, paramLong);
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {}
    for (paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);; paramLayoutParams = new LayoutParams(paramLayoutParams)) {
      return paramLayoutParams;
    }
  }
  
  public int getCoveredFadeColor()
  {
    return this.mCoveredFadeColor;
  }
  
  public int getParallaxDistance()
  {
    return this.mParallaxBy;
  }
  
  public int getSliderFadeColor()
  {
    return this.mSliderFadeColor;
  }
  
  boolean isDimmed(View paramView)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramView == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramView = (LayoutParams)paramView.getLayoutParams();
      bool1 = bool2;
      if (this.mCanSlide)
      {
        bool1 = bool2;
        if (paramView.dimWhenOffset)
        {
          bool1 = bool2;
          if (this.mSlideOffset > 0.0F) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public boolean isOpen()
  {
    if ((!this.mCanSlide) || (this.mSlideOffset == 1.0F)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isSlideable()
  {
    return this.mCanSlide;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    int i = 0;
    int j = this.mPostedRunnables.size();
    while (i < j)
    {
      ((DisableLayerRunnable)this.mPostedRunnables.get(i)).run();
      i++;
    }
    this.mPostedRunnables.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = MotionEventCompat.getActionMasked(paramMotionEvent);
    boolean bool;
    if ((!this.mCanSlide) && (k == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null)
      {
        if (this.mDragHelper.isViewUnder(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label105;
        }
        bool = true;
        this.mPreservedOpenState = bool;
      }
    }
    if ((!this.mCanSlide) || ((this.mIsUnableToDrag) && (k != 0)))
    {
      this.mDragHelper.cancel();
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool;
      label105:
      bool = false;
      break;
      if ((k == 3) || (k == 1))
      {
        this.mDragHelper.cancel();
        bool = false;
      }
      else
      {
        int j = 0;
        int i = j;
        switch (k)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          if ((this.mDragHelper.shouldInterceptTouchEvent(paramMotionEvent)) || (i != 0))
          {
            bool = true;
            break;
            this.mIsUnableToDrag = false;
            float f1 = paramMotionEvent.getX();
            float f2 = paramMotionEvent.getY();
            this.mInitialMotionX = f1;
            this.mInitialMotionY = f2;
            i = j;
            if (this.mDragHelper.isViewUnder(this.mSlideableView, (int)f1, (int)f2))
            {
              i = j;
              if (isDimmed(this.mSlideableView))
              {
                i = 1;
                continue;
                f2 = paramMotionEvent.getX();
                f1 = paramMotionEvent.getY();
                f2 = Math.abs(f2 - this.mInitialMotionX);
                f1 = Math.abs(f1 - this.mInitialMotionY);
                i = j;
                if (f2 > this.mDragHelper.getTouchSlop())
                {
                  i = j;
                  if (f1 > f2)
                  {
                    this.mDragHelper.cancel();
                    this.mIsUnableToDrag = true;
                    bool = false;
                    break;
                  }
                }
              }
            }
          }
        }
        bool = false;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = paramInt3 - paramInt1;
    paramInt1 = getPaddingLeft();
    int k = getPaddingRight();
    int j = getPaddingTop();
    int i = getChildCount();
    paramInt3 = paramInt1;
    if (this.mFirstLayout) {
      if ((!this.mCanSlide) || (!this.mPreservedOpenState)) {
        break label105;
      }
    }
    View localView;
    label105:
    for (float f = 1.0F;; f = 0.0F)
    {
      this.mSlideOffset = f;
      paramInt4 = 0;
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      for (paramInt3 = paramInt4;; paramInt3++)
      {
        if (paramInt3 >= i) {
          break label315;
        }
        localView = getChildAt(paramInt3);
        if (localView.getVisibility() != 8) {
          break;
        }
      }
    }
    LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
    int n = localView.getMeasuredWidth();
    paramInt4 = 0;
    if (localLayoutParams.slideable)
    {
      int i2 = localLayoutParams.leftMargin;
      int i1 = localLayoutParams.rightMargin;
      i1 = Math.min(paramInt1, m - k - this.mOverhangSize) - paramInt2 - (i2 + i1);
      this.mSlideRange = i1;
      if (localLayoutParams.leftMargin + paramInt2 + i1 + n / 2 > m - k)
      {
        paramBoolean = true;
        label208:
        localLayoutParams.dimWhenOffset = paramBoolean;
        paramInt2 += (int)(i1 * this.mSlideOffset) + localLayoutParams.leftMargin;
      }
    }
    for (;;)
    {
      paramInt4 = paramInt2 - paramInt4;
      localView.layout(paramInt4, j, paramInt4 + n, j + localView.getMeasuredHeight());
      paramInt1 += localView.getWidth();
      break;
      paramBoolean = false;
      break label208;
      if ((this.mCanSlide) && (this.mParallaxBy != 0))
      {
        paramInt4 = (int)((1.0F - this.mSlideOffset) * this.mParallaxBy);
        paramInt2 = paramInt1;
      }
      else
      {
        paramInt2 = paramInt1;
      }
    }
    label315:
    if (this.mFirstLayout)
    {
      if (!this.mCanSlide) {
        break label390;
      }
      if (this.mParallaxBy != 0) {
        parallaxOtherViews(this.mSlideOffset);
      }
      if (((LayoutParams)this.mSlideableView.getLayoutParams()).dimWhenOffset) {
        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
      }
    }
    for (;;)
    {
      updateObscuredViewsVisibility(this.mSlideableView);
      this.mFirstLayout = false;
      return;
      label390:
      for (paramInt1 = 0; paramInt1 < i; paramInt1++) {
        dimChildView(getChildAt(paramInt1), 0.0F, this.mSliderFadeColor);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int k;
    int n;
    label88:
    float f1;
    boolean bool1;
    int i3;
    int i1;
    label136:
    View localView;
    LayoutParams localLayoutParams;
    int i2;
    if (m != 1073741824) {
      if (isInEditMode()) {
        if (m == Integer.MIN_VALUE)
        {
          k = i;
          paramInt1 = paramInt2;
          n = j;
          i = 0;
          paramInt2 = -1;
          switch (n)
          {
          default: 
            f1 = 0.0F;
            bool1 = false;
            m = k - getPaddingLeft() - getPaddingRight();
            i3 = getChildCount();
            if (i3 > 2) {
              Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
            }
            this.mSlideableView = null;
            i1 = 0;
            if (i1 >= i3) {
              break label646;
            }
            localView = getChildAt(i1);
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if (localView.getVisibility() == 8)
            {
              localLayoutParams.dimWhenOffset = false;
              i2 = m;
              j = i;
              bool2 = bool1;
            }
            break;
          }
        }
      }
    }
    float f2;
    do
    {
      i1++;
      bool1 = bool2;
      i = j;
      m = i2;
      break label136;
      n = j;
      paramInt1 = paramInt2;
      k = i;
      if (m != 0) {
        break;
      }
      k = 300;
      n = j;
      paramInt1 = paramInt2;
      break;
      throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
      n = j;
      paramInt1 = paramInt2;
      k = i;
      if (j != 0) {
        break;
      }
      if (isInEditMode())
      {
        n = j;
        paramInt1 = paramInt2;
        k = i;
        if (j != 0) {
          break;
        }
        n = Integer.MIN_VALUE;
        paramInt1 = 300;
        k = i;
        break;
      }
      throw new IllegalStateException("Height must not be UNSPECIFIED");
      paramInt2 = paramInt1 - getPaddingTop() - getPaddingBottom();
      i = paramInt2;
      break label88;
      paramInt2 = paramInt1 - getPaddingTop() - getPaddingBottom();
      break label88;
      f2 = f1;
      if (localLayoutParams.weight <= 0.0F) {
        break label389;
      }
      f2 = f1 + localLayoutParams.weight;
      bool2 = bool1;
      j = i;
      f1 = f2;
      i2 = m;
    } while (localLayoutParams.width == 0);
    label389:
    paramInt1 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
    if (localLayoutParams.width == -2)
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(k - paramInt1, Integer.MIN_VALUE);
      label422:
      if (localLayoutParams.height != -2) {
        break label603;
      }
      j = View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE);
      label441:
      localView.measure(paramInt1, j);
      j = localView.getMeasuredWidth();
      i2 = localView.getMeasuredHeight();
      paramInt1 = i;
      if (n == Integer.MIN_VALUE)
      {
        paramInt1 = i;
        if (i2 > i) {
          paramInt1 = Math.min(i2, paramInt2);
        }
      }
      i = m - j;
      if (i >= 0) {
        break label640;
      }
    }
    label603:
    label640:
    for (boolean bool2 = true;; bool2 = false)
    {
      localLayoutParams.slideable = bool2;
      bool1 |= bool2;
      bool2 = bool1;
      j = paramInt1;
      f1 = f2;
      i2 = i;
      if (!localLayoutParams.slideable) {
        break;
      }
      this.mSlideableView = localView;
      bool2 = bool1;
      j = paramInt1;
      f1 = f2;
      i2 = i;
      break;
      if (localLayoutParams.width == -1)
      {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(k - paramInt1, 1073741824);
        break label422;
      }
      paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
      break label422;
      if (localLayoutParams.height == -1)
      {
        j = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        break label441;
      }
      j = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
      break label441;
    }
    label646:
    if ((bool1) || (f1 > 0.0F))
    {
      i1 = k - this.mOverhangSize;
      j = 0;
      if (j < i3)
      {
        localView = getChildAt(j);
        if (localView.getVisibility() == 8) {}
        for (;;)
        {
          j++;
          break;
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (localView.getVisibility() != 8)
          {
            if ((localLayoutParams.width == 0) && (localLayoutParams.weight > 0.0F))
            {
              paramInt1 = 1;
              label740:
              if (paramInt1 == 0) {
                break label830;
              }
              n = 0;
              label747:
              if ((!bool1) || (localView == this.mSlideableView)) {
                break label890;
              }
              if ((localLayoutParams.width >= 0) || ((n <= i1) && (localLayoutParams.weight <= 0.0F))) {
                continue;
              }
              if (paramInt1 == 0) {
                break label875;
              }
              if (localLayoutParams.height != -2) {
                break label840;
              }
              paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE);
            }
            for (;;)
            {
              localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), paramInt1);
              break;
              paramInt1 = 0;
              break label740;
              label830:
              n = localView.getMeasuredWidth();
              break label747;
              label840:
              if (localLayoutParams.height == -1)
              {
                paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
              }
              else
              {
                paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                continue;
                label875:
                paramInt1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
              }
            }
            label890:
            if (localLayoutParams.weight > 0.0F)
            {
              if (localLayoutParams.width == 0) {
                if (localLayoutParams.height == -2) {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE);
                }
              }
              for (;;)
              {
                if (!bool1) {
                  break label1025;
                }
                i2 = k - (localLayoutParams.leftMargin + localLayoutParams.rightMargin);
                int i4 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                if (n == i2) {
                  break;
                }
                localView.measure(i4, paramInt1);
                break;
                if (localLayoutParams.height == -1)
                {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
                }
                else
                {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                  continue;
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                }
              }
              label1025:
              i2 = Math.max(0, m);
              localView.measure(View.MeasureSpec.makeMeasureSpec(n + (int)(localLayoutParams.weight * i2 / f1), 1073741824), paramInt1);
            }
          }
        }
      }
    }
    setMeasuredDimension(k, i);
    this.mCanSlide = bool1;
    if ((this.mDragHelper.getViewDragState() != 0) && (!bool1)) {
      this.mDragHelper.abort();
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.isOpen) {
      openPane();
    }
    for (;;)
    {
      this.mPreservedOpenState = paramParcelable.isOpen;
      return;
      closePane();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (isSlideable()) {}
    for (boolean bool = isOpen();; bool = this.mPreservedOpenState)
    {
      localSavedState.isOpen = bool;
      return localSavedState;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.mFirstLayout = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (!this.mCanSlide) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool1;
      this.mDragHelper.processTouchEvent(paramMotionEvent);
      int i = paramMotionEvent.getAction();
      boolean bool2 = true;
      float f2;
      float f1;
      switch (i & 0xFF)
      {
      default: 
        bool1 = bool2;
        break;
      case 0: 
        f2 = paramMotionEvent.getX();
        f1 = paramMotionEvent.getY();
        this.mInitialMotionX = f2;
        this.mInitialMotionY = f1;
        bool1 = bool2;
        break;
      case 1: 
        bool1 = bool2;
        if (isDimmed(this.mSlideableView))
        {
          float f4 = paramMotionEvent.getX();
          float f3 = paramMotionEvent.getY();
          f2 = f4 - this.mInitialMotionX;
          f1 = f3 - this.mInitialMotionY;
          i = this.mDragHelper.getTouchSlop();
          bool1 = bool2;
          if (f2 * f2 + f1 * f1 < i * i)
          {
            bool1 = bool2;
            if (this.mDragHelper.isViewUnder(this.mSlideableView, (int)f4, (int)f3))
            {
              closePane(this.mSlideableView, 0);
              bool1 = bool2;
            }
          }
        }
        break;
      }
    }
  }
  
  public boolean openPane()
  {
    return openPane(this.mSlideableView, 0);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.mCanSlide)) {
      if (paramView1 != this.mSlideableView) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.mPreservedOpenState = bool;
      return;
    }
  }
  
  void setAllChildrenVisible()
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i++;
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    this.mCoveredFadeColor = paramInt;
  }
  
  public void setPanelSlideListener(PanelSlideListener paramPanelSlideListener)
  {
    this.mPanelSlideListener = paramPanelSlideListener;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    this.mParallaxBy = paramInt;
    requestLayout();
  }
  
  public void setShadowDrawable(Drawable paramDrawable)
  {
    this.mShadowDrawable = paramDrawable;
  }
  
  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setSliderFadeColor(int paramInt)
  {
    this.mSliderFadeColor = paramInt;
  }
  
  @Deprecated
  public void smoothSlideClosed()
  {
    closePane();
  }
  
  @Deprecated
  public void smoothSlideOpen()
  {
    openPane();
  }
  
  boolean smoothSlideTo(float paramFloat, int paramInt)
  {
    boolean bool = false;
    if (!this.mCanSlide) {}
    for (;;)
    {
      return bool;
      LayoutParams localLayoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
      paramInt = (int)(getPaddingLeft() + localLayoutParams.leftMargin + this.mSlideRange * paramFloat);
      if (this.mDragHelper.smoothSlideViewTo(this.mSlideableView, paramInt, this.mSlideableView.getTop()))
      {
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        bool = true;
      }
    }
  }
  
  void updateObscuredViewsVisibility(View paramView)
  {
    int i2 = getPaddingLeft();
    int i3 = getWidth();
    int i5 = getPaddingRight();
    int i4 = getPaddingTop();
    int i7 = getHeight();
    int i6 = getPaddingBottom();
    int m;
    int j;
    int i;
    int k;
    if ((paramView != null) && (viewIsOpaque(paramView)))
    {
      m = paramView.getLeft();
      j = paramView.getRight();
      i = paramView.getTop();
      k = paramView.getBottom();
    }
    int n;
    View localView;
    for (;;)
    {
      n = 0;
      int i8 = getChildCount();
      if (n < i8)
      {
        localView = getChildAt(n);
        if (localView != paramView) {
          break;
        }
      }
      return;
      k = 0;
      i = 0;
      j = 0;
      m = 0;
    }
    int i1 = Math.max(i2, localView.getLeft());
    int i9 = Math.max(i4, localView.getTop());
    int i10 = Math.min(i3 - i5, localView.getRight());
    int i11 = Math.min(i7 - i6, localView.getBottom());
    if ((i1 >= m) && (i9 >= i) && (i10 <= j) && (i11 <= k)) {}
    for (i1 = 4;; i1 = 0)
    {
      localView.setVisibility(i1);
      n++;
      break;
    }
  }
  
  class AccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    private final Rect mTmpRect = new Rect();
    
    AccessibilityDelegate() {}
    
    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2)
    {
      Rect localRect = this.mTmpRect;
      paramAccessibilityNodeInfoCompat2.getBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
      paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
      paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
      paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
      paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
      paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
      paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
      paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
      paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
      paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
      paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
      paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
      paramAccessibilityNodeInfoCompat1.setMovementGranularities(paramAccessibilityNodeInfoCompat2.getMovementGranularities());
    }
    
    public boolean filter(View paramView)
    {
      return SlidingPaneLayout.this.isDimmed(paramView);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
      super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
      copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
      localAccessibilityNodeInfoCompat.recycle();
      paramAccessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
      paramAccessibilityNodeInfoCompat.setSource(paramView);
      paramView = ViewCompat.getParentForAccessibility(paramView);
      if ((paramView instanceof View)) {
        paramAccessibilityNodeInfoCompat.setParent((View)paramView);
      }
      int j = SlidingPaneLayout.this.getChildCount();
      for (int i = 0; i < j; i++)
      {
        paramView = SlidingPaneLayout.this.getChildAt(i);
        if ((!filter(paramView)) && (paramView.getVisibility() == 0))
        {
          ViewCompat.setImportantForAccessibility(paramView, 1);
          paramAccessibilityNodeInfoCompat.addChild(paramView);
        }
      }
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!filter(paramView)) {}
      for (boolean bool = super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);; bool = false) {
        return bool;
      }
    }
  }
  
  private class DisableLayerRunnable
    implements Runnable
  {
    final View mChildView;
    
    DisableLayerRunnable(View paramView)
    {
      this.mChildView = paramView;
    }
    
    public void run()
    {
      if (this.mChildView.getParent() == SlidingPaneLayout.this)
      {
        ViewCompat.setLayerType(this.mChildView, 0, null);
        SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
      }
      SlidingPaneLayout.this.mPostedRunnables.remove(this);
    }
  }
  
  private class DragHelperCallback
    extends ViewDragHelper.Callback
  {
    private DragHelperCallback() {}
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.mSlideableView.getLayoutParams();
      paramInt2 = SlidingPaneLayout.this.getPaddingLeft() + paramView.leftMargin;
      int i = SlidingPaneLayout.this.mSlideRange;
      return Math.min(Math.max(paramInt1, paramInt2), paramInt2 + i);
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return SlidingPaneLayout.this.mSlideRange;
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, paramInt2);
    }
    
    public void onViewCaptured(View paramView, int paramInt)
    {
      SlidingPaneLayout.this.setAllChildrenVisible();
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0)
      {
        if (SlidingPaneLayout.this.mSlideOffset != 0.0F) {
          break label63;
        }
        SlidingPaneLayout.this.updateObscuredViewsVisibility(SlidingPaneLayout.this.mSlideableView);
        SlidingPaneLayout.this.dispatchOnPanelClosed(SlidingPaneLayout.this.mSlideableView);
        SlidingPaneLayout.access$502(SlidingPaneLayout.this, false);
      }
      for (;;)
      {
        return;
        label63:
        SlidingPaneLayout.this.dispatchOnPanelOpened(SlidingPaneLayout.this.mSlideableView);
        SlidingPaneLayout.access$502(SlidingPaneLayout.this, true);
      }
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      SlidingPaneLayout.this.onPanelDragged(paramInt1);
      SlidingPaneLayout.this.invalidate();
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int j = SlidingPaneLayout.this.getPaddingLeft() + localLayoutParams.leftMargin;
      int i;
      if (paramFloat1 <= 0.0F)
      {
        i = j;
        if (paramFloat1 == 0.0F)
        {
          i = j;
          if (SlidingPaneLayout.this.mSlideOffset <= 0.5F) {}
        }
      }
      else
      {
        i = j + SlidingPaneLayout.this.mSlideRange;
      }
      SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(i, paramView.getTop());
      SlidingPaneLayout.this.invalidate();
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      if (SlidingPaneLayout.this.mIsUnableToDrag) {}
      for (boolean bool = false;; bool = ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).slideable) {
        return bool;
      }
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] ATTRS = { 16843137 };
    Paint dimPaint;
    boolean dimWhenOffset;
    boolean slideable;
    public float weight = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
      this.weight = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.weight = paramLayoutParams.weight;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface PanelSlideListener
  {
    public abstract void onPanelClosed(View paramView);
    
    public abstract void onPanelOpened(View paramView);
    
    public abstract void onPanelSlide(View paramView, float paramFloat);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public SlidingPaneLayout.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new SlidingPaneLayout.SavedState(paramAnonymousParcel, null);
      }
      
      public SlidingPaneLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new SlidingPaneLayout.SavedState[paramAnonymousInt];
      }
    };
    boolean isOpen;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.isOpen = bool;
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.isOpen) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  public static class SimplePanelSlideListener
    implements SlidingPaneLayout.PanelSlideListener
  {
    public void onPanelClosed(View paramView) {}
    
    public void onPanelOpened(View paramView) {}
    
    public void onPanelSlide(View paramView, float paramFloat) {}
  }
  
  static abstract interface SlidingPanelLayoutImpl
  {
    public abstract void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView);
  }
  
  static class SlidingPanelLayoutImplBase
    implements SlidingPaneLayout.SlidingPanelLayoutImpl
  {
    public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      ViewCompat.postInvalidateOnAnimation(paramSlidingPaneLayout, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    }
  }
  
  static class SlidingPanelLayoutImplJB
    extends SlidingPaneLayout.SlidingPanelLayoutImplBase
  {
    private Method mGetDisplayList;
    private Field mRecreateDisplayList;
    
    SlidingPanelLayoutImplJB()
    {
      try
      {
        this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[])null);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          for (;;)
          {
            this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
            this.mRecreateDisplayList.setAccessible(true);
            return;
            localNoSuchMethodException = localNoSuchMethodException;
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", localNoSuchMethodException);
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          for (;;)
          {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", localNoSuchFieldException);
          }
        }
      }
    }
    
    public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      if ((this.mGetDisplayList != null) && (this.mRecreateDisplayList != null)) {}
      for (;;)
      {
        try
        {
          this.mRecreateDisplayList.setBoolean(paramView, true);
          this.mGetDisplayList.invoke(paramView, (Object[])null);
          super.invalidateChildRegion(paramSlidingPaneLayout, paramView);
          return;
        }
        catch (Exception localException)
        {
          Log.e("SlidingPaneLayout", "Error refreshing display list state", localException);
          continue;
        }
        paramView.invalidate();
      }
    }
  }
  
  static class SlidingPanelLayoutImplJBMR1
    extends SlidingPaneLayout.SlidingPanelLayoutImplBase
  {
    public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      ViewCompat.setLayerPaint(paramView, ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).dimPaint);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\widget\SlidingPaneLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */