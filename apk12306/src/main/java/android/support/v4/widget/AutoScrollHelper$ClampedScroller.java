package android.support.v4.widget;

import android.view.animation.AnimationUtils;

class AutoScrollHelper$ClampedScroller
{
  private long mDeltaTime = 0L;
  private int mDeltaX = 0;
  private int mDeltaY = 0;
  private int mEffectiveRampDown;
  private int mRampDownDuration;
  private int mRampUpDuration;
  private long mStartTime = Long.MIN_VALUE;
  private long mStopTime = -1L;
  private float mStopValue;
  private float mTargetVelocityX;
  private float mTargetVelocityY;
  
  private float getValueAt(long paramLong)
  {
    float f1 = 0.0F;
    if (paramLong < this.mStartTime) {}
    for (;;)
    {
      return f1;
      if ((this.mStopTime < 0L) || (paramLong < this.mStopTime))
      {
        f1 = AutoScrollHelper.access$900((float)(paramLong - this.mStartTime) / this.mRampUpDuration, 0.0F, 1.0F) * 0.5F;
      }
      else
      {
        long l = this.mStopTime;
        f1 = this.mStopValue;
        float f2 = this.mStopValue;
        f1 = AutoScrollHelper.access$900((float)(paramLong - l) / this.mEffectiveRampDown, 0.0F, 1.0F) * f2 + (1.0F - f1);
      }
    }
  }
  
  private float interpolateValue(float paramFloat)
  {
    return -4.0F * paramFloat * paramFloat + 4.0F * paramFloat;
  }
  
  public void computeScrollDelta()
  {
    if (this.mDeltaTime == 0L) {
      throw new RuntimeException("Cannot compute scroll delta before calling start()");
    }
    long l2 = AnimationUtils.currentAnimationTimeMillis();
    float f = interpolateValue(getValueAt(l2));
    long l1 = l2 - this.mDeltaTime;
    this.mDeltaTime = l2;
    this.mDeltaX = ((int)((float)l1 * f * this.mTargetVelocityX));
    this.mDeltaY = ((int)((float)l1 * f * this.mTargetVelocityY));
  }
  
  public int getDeltaX()
  {
    return this.mDeltaX;
  }
  
  public int getDeltaY()
  {
    return this.mDeltaY;
  }
  
  public int getHorizontalDirection()
  {
    return (int)(this.mTargetVelocityX / Math.abs(this.mTargetVelocityX));
  }
  
  public int getVerticalDirection()
  {
    return (int)(this.mTargetVelocityY / Math.abs(this.mTargetVelocityY));
  }
  
  public boolean isFinished()
  {
    if ((this.mStopTime > 0L) && (AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + this.mEffectiveRampDown)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void requestStop()
  {
    long l = AnimationUtils.currentAnimationTimeMillis();
    this.mEffectiveRampDown = AutoScrollHelper.access$800((int)(l - this.mStartTime), 0, this.mRampDownDuration);
    this.mStopValue = getValueAt(l);
    this.mStopTime = l;
  }
  
  public void setRampDownDuration(int paramInt)
  {
    this.mRampDownDuration = paramInt;
  }
  
  public void setRampUpDuration(int paramInt)
  {
    this.mRampUpDuration = paramInt;
  }
  
  public void setTargetVelocity(float paramFloat1, float paramFloat2)
  {
    this.mTargetVelocityX = paramFloat1;
    this.mTargetVelocityY = paramFloat2;
  }
  
  public void start()
  {
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStopTime = -1L;
    this.mDeltaTime = this.mStartTime;
    this.mStopValue = 0.5F;
    this.mDeltaX = 0;
    this.mDeltaY = 0;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\widget\AutoScrollHelper$ClampedScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */