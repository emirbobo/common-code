package android.support.v4.app;

import android.os.Bundle;

class ActivityOptionsCompat$ActivityOptionsImplJB
  extends ActivityOptionsCompat
{
  private final ActivityOptionsCompatJB mImpl;
  
  ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB paramActivityOptionsCompatJB)
  {
    this.mImpl = paramActivityOptionsCompatJB;
  }
  
  public Bundle toBundle()
  {
    return this.mImpl.toBundle();
  }
  
  public void update(ActivityOptionsCompat paramActivityOptionsCompat)
  {
    if ((paramActivityOptionsCompat instanceof ActivityOptionsImplJB))
    {
      paramActivityOptionsCompat = (ActivityOptionsImplJB)paramActivityOptionsCompat;
      this.mImpl.update(paramActivityOptionsCompat.mImpl);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\app\ActivityOptionsCompat$ActivityOptionsImplJB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */