package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper
{
  private static final int BASE_SETTLE_DURATION = 256;
  public static final int DIRECTION_ALL = 3;
  public static final int DIRECTION_HORIZONTAL = 1;
  public static final int DIRECTION_VERTICAL = 2;
  public static final int EDGE_ALL = 15;
  public static final int EDGE_BOTTOM = 8;
  public static final int EDGE_LEFT = 1;
  public static final int EDGE_RIGHT = 2;
  private static final int EDGE_SIZE = 20;
  public static final int EDGE_TOP = 4;
  public static final int INVALID_POINTER = -1;
  private static final int MAX_SETTLE_DURATION = 600;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String TAG = "ViewDragHelper";
  private static final Interpolator sInterpolator = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
    }
  };
  private int mActivePointerId = -1;
  private final Callback mCallback;
  private View mCapturedView;
  private int mDragState;
  private int[] mEdgeDragsInProgress;
  private int[] mEdgeDragsLocked;
  private int mEdgeSize;
  private int[] mInitialEdgesTouched;
  private float[] mInitialMotionX;
  private float[] mInitialMotionY;
  private float[] mLastMotionX;
  private float[] mLastMotionY;
  private float mMaxVelocity;
  private float mMinVelocity;
  private final ViewGroup mParentView;
  private int mPointersDown;
  private boolean mReleaseInProgress;
  private ScrollerCompat mScroller;
  private final Runnable mSetIdleRunnable = new Runnable()
  {
    public void run()
    {
      ViewDragHelper.this.setDragState(0);
    }
  };
  private int mTouchSlop;
  private int mTrackingEdges;
  private VelocityTracker mVelocityTracker;
  
  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, Callback paramCallback)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (paramCallback == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.mParentView = paramViewGroup;
    this.mCallback = paramCallback;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.mEdgeSize = ((int)(20.0F * paramContext.getResources().getDisplayMetrics().density + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.mMaxVelocity = paramViewGroup.getScaledMaximumFlingVelocity();
    this.mMinVelocity = paramViewGroup.getScaledMinimumFlingVelocity();
    this.mScroller = ScrollerCompat.create(paramContext, sInterpolator);
  }
  
  private boolean checkNewEdgeDrag(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    boolean bool1 = bool2;
    if ((this.mInitialEdgesTouched[paramInt1] & paramInt2) == paramInt2)
    {
      bool1 = bool2;
      if ((this.mTrackingEdges & paramInt2) != 0)
      {
        bool1 = bool2;
        if ((this.mEdgeDragsLocked[paramInt1] & paramInt2) != paramInt2)
        {
          bool1 = bool2;
          if ((this.mEdgeDragsInProgress[paramInt1] & paramInt2) != paramInt2)
          {
            if ((paramFloat1 > this.mTouchSlop) || (paramFloat2 > this.mTouchSlop)) {
              break label108;
            }
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      return bool1;
      label108:
      if ((paramFloat1 < 0.5F * paramFloat2) && (this.mCallback.onEdgeLock(paramInt2)))
      {
        int[] arrayOfInt = this.mEdgeDragsLocked;
        arrayOfInt[paramInt1] |= paramInt2;
        bool1 = bool2;
      }
      else
      {
        bool1 = bool2;
        if ((this.mEdgeDragsInProgress[paramInt1] & paramInt2) == 0)
        {
          bool1 = bool2;
          if (paramFloat1 > this.mTouchSlop) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private boolean checkTouchSlop(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    if (paramView == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      int i;
      if (this.mCallback.getViewHorizontalDragRange(paramView) > 0)
      {
        i = 1;
        label27:
        if (this.mCallback.getViewVerticalDragRange(paramView) <= 0) {
          break label84;
        }
      }
      label84:
      for (int j = 1;; j = 0)
      {
        if ((i == 0) || (j == 0)) {
          break label90;
        }
        if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > this.mTouchSlop * this.mTouchSlop) {
          break;
        }
        bool = false;
        break;
        i = 0;
        break label27;
      }
      label90:
      if (i != 0)
      {
        if (Math.abs(paramFloat1) <= this.mTouchSlop) {
          bool = false;
        }
      }
      else if (j != 0)
      {
        if (Math.abs(paramFloat2) <= this.mTouchSlop) {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  private float clampMag(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    for (;;)
    {
      return paramFloat2;
      if (f > paramFloat3)
      {
        paramFloat2 = paramFloat3;
        if (paramFloat1 <= 0.0F) {
          paramFloat2 = -paramFloat3;
        }
      }
      else
      {
        paramFloat2 = paramFloat1;
      }
    }
  }
  
  private int clampMag(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      paramInt2 = 0;
    }
    for (;;)
    {
      return paramInt2;
      if (i > paramInt3)
      {
        paramInt2 = paramInt3;
        if (paramInt1 <= 0) {
          paramInt2 = -paramInt3;
        }
      }
      else
      {
        paramInt2 = paramInt1;
      }
    }
  }
  
  private void clearMotionHistory()
  {
    if (this.mInitialMotionX == null) {}
    for (;;)
    {
      return;
      Arrays.fill(this.mInitialMotionX, 0.0F);
      Arrays.fill(this.mInitialMotionY, 0.0F);
      Arrays.fill(this.mLastMotionX, 0.0F);
      Arrays.fill(this.mLastMotionY, 0.0F);
      Arrays.fill(this.mInitialEdgesTouched, 0);
      Arrays.fill(this.mEdgeDragsInProgress, 0);
      Arrays.fill(this.mEdgeDragsLocked, 0);
      this.mPointersDown = 0;
    }
  }
  
  private void clearMotionHistory(int paramInt)
  {
    if (this.mInitialMotionX == null) {}
    for (;;)
    {
      return;
      this.mInitialMotionX[paramInt] = 0.0F;
      this.mInitialMotionY[paramInt] = 0.0F;
      this.mLastMotionX[paramInt] = 0.0F;
      this.mLastMotionY[paramInt] = 0.0F;
      this.mInitialEdgesTouched[paramInt] = 0;
      this.mEdgeDragsInProgress[paramInt] = 0;
      this.mEdgeDragsLocked[paramInt] = 0;
      this.mPointersDown &= (1 << paramInt ^ 0xFFFFFFFF);
    }
  }
  
  private int computeAxisDuration(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramInt1 = 0;
      return paramInt1;
    }
    int i = this.mParentView.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f1 + f2 * f3) / paramInt2)) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      break;
    }
  }
  
  private int computeSettleDuration(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = clampMag(paramInt3, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    paramInt3 = clampMag(paramInt4, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    int i1 = Math.abs(paramInt1);
    int m = Math.abs(paramInt2);
    int k = Math.abs(i);
    paramInt4 = Math.abs(paramInt3);
    int j = k + paramInt4;
    int n = i1 + m;
    float f1;
    if (i != 0)
    {
      f1 = k / j;
      if (paramInt3 == 0) {
        break label161;
      }
    }
    label161:
    for (float f2 = paramInt4 / j;; f2 = m / n)
    {
      paramInt1 = computeAxisDuration(paramInt1, i, this.mCallback.getViewHorizontalDragRange(paramView));
      paramInt2 = computeAxisDuration(paramInt2, paramInt3, this.mCallback.getViewVerticalDragRange(paramView));
      return (int)(paramInt1 * f1 + paramInt2 * f2);
      f1 = i1 / n;
      break;
    }
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, float paramFloat, Callback paramCallback)
  {
    paramViewGroup = create(paramViewGroup, paramCallback);
    paramViewGroup.mTouchSlop = ((int)(paramViewGroup.mTouchSlop * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, Callback paramCallback)
  {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }
  
  private void dispatchViewReleased(float paramFloat1, float paramFloat2)
  {
    this.mReleaseInProgress = true;
    this.mCallback.onViewReleased(this.mCapturedView, paramFloat1, paramFloat2);
    this.mReleaseInProgress = false;
    if (this.mDragState == 1) {
      setDragState(0);
    }
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  private void dragTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramInt1;
    int i = paramInt2;
    int m = this.mCapturedView.getLeft();
    int k = this.mCapturedView.getTop();
    if (paramInt3 != 0)
    {
      j = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, paramInt1, paramInt3);
      this.mCapturedView.offsetLeftAndRight(j - m);
    }
    if (paramInt4 != 0)
    {
      i = this.mCallback.clampViewPositionVertical(this.mCapturedView, paramInt2, paramInt4);
      this.mCapturedView.offsetTopAndBottom(i - k);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      this.mCallback.onViewPositionChanged(this.mCapturedView, j, i, j - m, i - k);
    }
  }
  
  private void ensureMotionHistorySizeForId(int paramInt)
  {
    if ((this.mInitialMotionX == null) || (this.mInitialMotionX.length <= paramInt))
    {
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.mInitialMotionX != null)
      {
        System.arraycopy(this.mInitialMotionX, 0, arrayOfFloat2, 0, this.mInitialMotionX.length);
        System.arraycopy(this.mInitialMotionY, 0, arrayOfFloat3, 0, this.mInitialMotionY.length);
        System.arraycopy(this.mLastMotionX, 0, arrayOfFloat1, 0, this.mLastMotionX.length);
        System.arraycopy(this.mLastMotionY, 0, arrayOfFloat4, 0, this.mLastMotionY.length);
        System.arraycopy(this.mInitialEdgesTouched, 0, arrayOfInt1, 0, this.mInitialEdgesTouched.length);
        System.arraycopy(this.mEdgeDragsInProgress, 0, arrayOfInt2, 0, this.mEdgeDragsInProgress.length);
        System.arraycopy(this.mEdgeDragsLocked, 0, arrayOfInt3, 0, this.mEdgeDragsLocked.length);
      }
      this.mInitialMotionX = arrayOfFloat2;
      this.mInitialMotionY = arrayOfFloat3;
      this.mLastMotionX = arrayOfFloat1;
      this.mLastMotionY = arrayOfFloat4;
      this.mInitialEdgesTouched = arrayOfInt1;
      this.mEdgeDragsInProgress = arrayOfInt2;
      this.mEdgeDragsLocked = arrayOfInt3;
    }
  }
  
  private boolean forceSettleCapturedViewAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = false;
    int i = this.mCapturedView.getLeft();
    int j = this.mCapturedView.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mScroller.abortAnimation();
      setDragState(0);
    }
    for (;;)
    {
      return bool;
      paramInt3 = computeSettleDuration(this.mCapturedView, paramInt1, paramInt2, paramInt3, paramInt4);
      this.mScroller.startScroll(i, j, paramInt1, paramInt2, paramInt3);
      setDragState(2);
      bool = true;
    }
  }
  
  private int getEdgesTouched(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt1 < this.mParentView.getLeft() + this.mEdgeSize) {
      i = 0x0 | 0x1;
    }
    int j = i;
    if (paramInt2 < this.mParentView.getTop() + this.mEdgeSize) {
      j = i | 0x4;
    }
    i = j;
    if (paramInt1 > this.mParentView.getRight() - this.mEdgeSize) {
      i = j | 0x2;
    }
    paramInt1 = i;
    if (paramInt2 > this.mParentView.getBottom() - this.mEdgeSize) {
      paramInt1 = i | 0x8;
    }
    return paramInt1;
  }
  
  private void releaseViewForPointerUp()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
    dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
  }
  
  private void reportNewEdgeDrags(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i = 0;
    if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 1)) {
      i = 0x0 | 0x1;
    }
    int j = i;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 4)) {
      j = i | 0x4;
    }
    i = j;
    if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 2)) {
      i = j | 0x2;
    }
    j = i;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 8)) {
      j = i | 0x8;
    }
    if (j != 0)
    {
      int[] arrayOfInt = this.mEdgeDragsInProgress;
      arrayOfInt[paramInt] |= j;
      this.mCallback.onEdgeDragStarted(j, paramInt);
    }
  }
  
  private void saveInitialMotion(float paramFloat1, float paramFloat2, int paramInt)
  {
    ensureMotionHistorySizeForId(paramInt);
    float[] arrayOfFloat = this.mInitialMotionX;
    this.mLastMotionX[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.mInitialMotionY;
    this.mLastMotionY[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.mInitialEdgesTouched[paramInt] = getEdgesTouched((int)paramFloat1, (int)paramFloat2);
    this.mPointersDown |= 1 << paramInt;
  }
  
  private void saveLastMotion(MotionEvent paramMotionEvent)
  {
    int j = MotionEventCompat.getPointerCount(paramMotionEvent);
    for (int i = 0; i < j; i++)
    {
      int k = MotionEventCompat.getPointerId(paramMotionEvent, i);
      float f2 = MotionEventCompat.getX(paramMotionEvent, i);
      float f1 = MotionEventCompat.getY(paramMotionEvent, i);
      this.mLastMotionX[k] = f2;
      this.mLastMotionY[k] = f1;
    }
  }
  
  public void abort()
  {
    cancel();
    if (this.mDragState == 2)
    {
      int j = this.mScroller.getCurrX();
      int i = this.mScroller.getCurrY();
      this.mScroller.abortAnimation();
      int m = this.mScroller.getCurrX();
      int k = this.mScroller.getCurrY();
      this.mCallback.onViewPositionChanged(this.mCapturedView, m, k, m - j, k - i);
    }
    setDragState(0);
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int k = paramView.getScrollX();
      int j = paramView.getScrollY();
      i = localViewGroup.getChildCount() - 1;
      if (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((paramInt3 + k >= localView.getLeft()) && (paramInt3 + k < localView.getRight()) && (paramInt4 + j >= localView.getTop()) && (paramInt4 + j < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2, paramInt3 + k - localView.getLeft(), paramInt4 + j - localView.getTop()))) {
          paramBoolean = true;
        }
      }
    }
    for (;;)
    {
      return paramBoolean;
      i--;
      break;
      if ((paramBoolean) && ((ViewCompat.canScrollHorizontally(paramView, -paramInt1)) || (ViewCompat.canScrollVertically(paramView, -paramInt2)))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
  }
  
  public void cancel()
  {
    this.mActivePointerId = -1;
    clearMotionHistory();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public void captureChildView(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.mParentView) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }
    this.mCapturedView = paramView;
    this.mActivePointerId = paramInt;
    this.mCallback.onViewCaptured(paramView, paramInt);
    setDragState(1);
  }
  
  public boolean checkTouchSlop(int paramInt)
  {
    int j = this.mInitialMotionX.length;
    int i = 0;
    if (i < j) {
      if (!checkTouchSlop(paramInt, i)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i++;
      break;
    }
  }
  
  public boolean checkTouchSlop(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!isPointerDown(paramInt2)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      int i;
      if ((paramInt1 & 0x1) == 1)
      {
        i = 1;
        label27:
        if ((paramInt1 & 0x2) != 2) {
          break label109;
        }
      }
      float f2;
      float f1;
      label109:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        f2 = this.mLastMotionX[paramInt2] - this.mInitialMotionX[paramInt2];
        f1 = this.mLastMotionY[paramInt2] - this.mInitialMotionY[paramInt2];
        if ((i == 0) || (paramInt1 == 0)) {
          break label114;
        }
        if (f2 * f2 + f1 * f1 > this.mTouchSlop * this.mTouchSlop) {
          break;
        }
        bool = false;
        break;
        i = 0;
        break label27;
      }
      label114:
      if (i != 0)
      {
        if (Math.abs(f2) <= this.mTouchSlop) {
          bool = false;
        }
      }
      else if (paramInt1 != 0)
      {
        if (Math.abs(f1) <= this.mTouchSlop) {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public boolean continueSettling(boolean paramBoolean)
  {
    if (this.mDragState == 2)
    {
      boolean bool2 = this.mScroller.computeScrollOffset();
      int i = this.mScroller.getCurrX();
      int k = this.mScroller.getCurrY();
      int m = i - this.mCapturedView.getLeft();
      int j = k - this.mCapturedView.getTop();
      if (m != 0) {
        this.mCapturedView.offsetLeftAndRight(m);
      }
      if (j != 0) {
        this.mCapturedView.offsetTopAndBottom(j);
      }
      if ((m != 0) || (j != 0)) {
        this.mCallback.onViewPositionChanged(this.mCapturedView, i, k, m, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == this.mScroller.getFinalX())
        {
          bool1 = bool2;
          if (k == this.mScroller.getFinalY())
          {
            this.mScroller.abortAnimation();
            bool1 = this.mScroller.isFinished();
          }
        }
      }
      if (!bool1)
      {
        if (!paramBoolean) {
          break label197;
        }
        this.mParentView.post(this.mSetIdleRunnable);
      }
    }
    if (this.mDragState == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      label197:
      setDragState(0);
      break;
    }
  }
  
  public View findTopChildUnder(int paramInt1, int paramInt2)
  {
    int i = this.mParentView.getChildCount() - 1;
    View localView;
    if (i >= 0)
    {
      localView = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(i));
      if ((paramInt1 < localView.getLeft()) || (paramInt1 >= localView.getRight()) || (paramInt2 < localView.getTop()) || (paramInt2 >= localView.getBottom())) {}
    }
    for (;;)
    {
      return localView;
      i--;
      break;
      localView = null;
    }
  }
  
  public void flingCapturedView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mReleaseInProgress) {
      throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }
    this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), paramInt1, paramInt3, paramInt2, paramInt4);
    setDragState(2);
  }
  
  public int getActivePointerId()
  {
    return this.mActivePointerId;
  }
  
  public View getCapturedView()
  {
    return this.mCapturedView;
  }
  
  public int getEdgeSize()
  {
    return this.mEdgeSize;
  }
  
  public float getMinVelocity()
  {
    return this.mMinVelocity;
  }
  
  public int getTouchSlop()
  {
    return this.mTouchSlop;
  }
  
  public int getViewDragState()
  {
    return this.mDragState;
  }
  
  public boolean isCapturedViewUnder(int paramInt1, int paramInt2)
  {
    return isViewUnder(this.mCapturedView, paramInt1, paramInt2);
  }
  
  public boolean isEdgeTouched(int paramInt)
  {
    int j = this.mInitialEdgesTouched.length;
    int i = 0;
    if (i < j) {
      if (!isEdgeTouched(paramInt, i)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i++;
      break;
    }
  }
  
  public boolean isEdgeTouched(int paramInt1, int paramInt2)
  {
    if ((isPointerDown(paramInt2)) && ((this.mInitialEdgesTouched[paramInt2] & paramInt1) != 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isPointerDown(int paramInt)
  {
    boolean bool = true;
    if ((this.mPointersDown & 1 << paramInt) != 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean isViewUnder(View paramView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramView == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramInt1 >= paramView.getLeft())
      {
        bool1 = bool2;
        if (paramInt1 < paramView.getRight())
        {
          bool1 = bool2;
          if (paramInt2 >= paramView.getTop())
          {
            bool1 = bool2;
            if (paramInt2 < paramView.getBottom()) {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  public void processTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (i)
    {
    }
    for (;;)
    {
      return;
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      i = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      paramMotionEvent = findTopChildUnder((int)f2, (int)f1);
      saveInitialMotion(f2, f1, i);
      tryCaptureViewForDrag(paramMotionEvent, i);
      j = this.mInitialEdgesTouched[i];
      if ((this.mTrackingEdges & j) != 0)
      {
        this.mCallback.onEdgeTouched(this.mTrackingEdges & j, i);
        continue;
        i = MotionEventCompat.getPointerId(paramMotionEvent, j);
        f2 = MotionEventCompat.getX(paramMotionEvent, j);
        f1 = MotionEventCompat.getY(paramMotionEvent, j);
        saveInitialMotion(f2, f1, i);
        if (this.mDragState == 0)
        {
          tryCaptureViewForDrag(findTopChildUnder((int)f2, (int)f1), i);
          j = this.mInitialEdgesTouched[i];
          if ((this.mTrackingEdges & j) != 0) {
            this.mCallback.onEdgeTouched(this.mTrackingEdges & j, i);
          }
        }
        else if (isCapturedViewUnder((int)f2, (int)f1))
        {
          tryCaptureViewForDrag(this.mCapturedView, i);
          continue;
          if (this.mDragState == 1)
          {
            i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
            f2 = MotionEventCompat.getX(paramMotionEvent, i);
            f1 = MotionEventCompat.getY(paramMotionEvent, i);
            j = (int)(f2 - this.mLastMotionX[this.mActivePointerId]);
            i = (int)(f1 - this.mLastMotionY[this.mActivePointerId]);
            dragTo(this.mCapturedView.getLeft() + j, this.mCapturedView.getTop() + i, j, i);
            saveLastMotion(paramMotionEvent);
          }
          else
          {
            j = MotionEventCompat.getPointerCount(paramMotionEvent);
            int k;
            for (i = 0;; i++)
            {
              float f4;
              float f3;
              if (i < j)
              {
                k = MotionEventCompat.getPointerId(paramMotionEvent, i);
                f4 = MotionEventCompat.getX(paramMotionEvent, i);
                f1 = MotionEventCompat.getY(paramMotionEvent, i);
                f3 = f4 - this.mInitialMotionX[k];
                f2 = f1 - this.mInitialMotionY[k];
                reportNewEdgeDrags(f3, f2, k);
                if (this.mDragState != 1) {
                  break label466;
                }
              }
              label466:
              View localView;
              do
              {
                saveLastMotion(paramMotionEvent);
                break;
                localView = findTopChildUnder((int)f4, (int)f1);
              } while ((checkTouchSlop(localView, f3, f2)) && (tryCaptureViewForDrag(localView, k)));
            }
            int m = MotionEventCompat.getPointerId(paramMotionEvent, j);
            if ((this.mDragState == 1) && (m == this.mActivePointerId))
            {
              k = -1;
              int n = MotionEventCompat.getPointerCount(paramMotionEvent);
              i = 0;
              j = k;
              if (i < n)
              {
                j = MotionEventCompat.getPointerId(paramMotionEvent, i);
                if (j == this.mActivePointerId) {}
                do
                {
                  i++;
                  break;
                  f2 = MotionEventCompat.getX(paramMotionEvent, i);
                  f1 = MotionEventCompat.getY(paramMotionEvent, i);
                } while ((findTopChildUnder((int)f2, (int)f1) != this.mCapturedView) || (!tryCaptureViewForDrag(this.mCapturedView, j)));
                j = this.mActivePointerId;
              }
              if (j == -1) {
                releaseViewForPointerUp();
              }
            }
            clearMotionHistory(m);
            continue;
            if (this.mDragState == 1) {
              releaseViewForPointerUp();
            }
            cancel();
            continue;
            if (this.mDragState == 1) {
              dispatchViewReleased(0.0F, 0.0F);
            }
            cancel();
          }
        }
      }
    }
  }
  
  void setDragState(int paramInt)
  {
    if (this.mDragState != paramInt)
    {
      this.mDragState = paramInt;
      this.mCallback.onViewDragStateChanged(paramInt);
      if (paramInt == 0) {
        this.mCapturedView = null;
      }
    }
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.mTrackingEdges = paramInt;
  }
  
  public void setMinVelocity(float paramFloat)
  {
    this.mMinVelocity = paramFloat;
  }
  
  public boolean settleCapturedViewAt(int paramInt1, int paramInt2)
  {
    if (!this.mReleaseInProgress) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return forceSettleCapturedViewAt(paramInt1, paramInt2, (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
  }
  
  public boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (j == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (j)
    {
    case 4: 
    default: 
      if (this.mDragState != 1) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      i = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      saveInitialMotion(f2, f1, i);
      paramMotionEvent = findTopChildUnder((int)f2, (int)f1);
      if ((paramMotionEvent == this.mCapturedView) && (this.mDragState == 2)) {
        tryCaptureViewForDrag(paramMotionEvent, i);
      }
      j = this.mInitialEdgesTouched[i];
      if ((this.mTrackingEdges & j) == 0) {
        break;
      }
      this.mCallback.onEdgeTouched(this.mTrackingEdges & j, i);
      break;
      j = MotionEventCompat.getPointerId(paramMotionEvent, i);
      f2 = MotionEventCompat.getX(paramMotionEvent, i);
      f1 = MotionEventCompat.getY(paramMotionEvent, i);
      saveInitialMotion(f2, f1, j);
      if (this.mDragState == 0)
      {
        i = this.mInitialEdgesTouched[j];
        if ((this.mTrackingEdges & i) == 0) {
          break;
        }
        this.mCallback.onEdgeTouched(this.mTrackingEdges & i, j);
        break;
      }
      if (this.mDragState != 2) {
        break;
      }
      paramMotionEvent = findTopChildUnder((int)f2, (int)f1);
      if (paramMotionEvent != this.mCapturedView) {
        break;
      }
      tryCaptureViewForDrag(paramMotionEvent, j);
      break;
      j = MotionEventCompat.getPointerCount(paramMotionEvent);
      for (i = 0;; i++)
      {
        int k;
        float f4;
        float f3;
        if (i < j)
        {
          k = MotionEventCompat.getPointerId(paramMotionEvent, i);
          f4 = MotionEventCompat.getX(paramMotionEvent, i);
          f1 = MotionEventCompat.getY(paramMotionEvent, i);
          f2 = f4 - this.mInitialMotionX[k];
          f3 = f1 - this.mInitialMotionY[k];
          reportNewEdgeDrags(f2, f3, k);
          if (this.mDragState != 1) {
            break label395;
          }
        }
        label395:
        View localView;
        do
        {
          saveLastMotion(paramMotionEvent);
          break;
          localView = findTopChildUnder((int)f4, (int)f1);
        } while ((localView != null) && (checkTouchSlop(localView, f2, f3)) && (tryCaptureViewForDrag(localView, k)));
      }
      clearMotionHistory(MotionEventCompat.getPointerId(paramMotionEvent, i));
      break;
      cancel();
      break;
    }
  }
  
  public boolean smoothSlideViewTo(View paramView, int paramInt1, int paramInt2)
  {
    this.mCapturedView = paramView;
    this.mActivePointerId = -1;
    return forceSettleCapturedViewAt(paramInt1, paramInt2, 0, 0);
  }
  
  boolean tryCaptureViewForDrag(View paramView, int paramInt)
  {
    boolean bool = true;
    if ((paramView == this.mCapturedView) && (this.mActivePointerId == paramInt)) {}
    for (;;)
    {
      return bool;
      if ((paramView != null) && (this.mCallback.tryCaptureView(paramView, paramInt)))
      {
        this.mActivePointerId = paramInt;
        captureChildView(paramView, paramInt);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public static abstract class Callback
  {
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public int getOrderedChildIndex(int paramInt)
    {
      return paramInt;
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return 0;
    }
    
    public int getViewVerticalDragRange(View paramView)
    {
      return 0;
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2) {}
    
    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }
    
    public void onEdgeTouched(int paramInt1, int paramInt2) {}
    
    public void onViewCaptured(View paramView, int paramInt) {}
    
    public void onViewDragStateChanged(int paramInt) {}
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2) {}
    
    public abstract boolean tryCaptureView(View paramView, int paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\widget\ViewDragHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */