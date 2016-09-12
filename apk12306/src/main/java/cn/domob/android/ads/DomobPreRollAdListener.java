package cn.domob.android.ads;

public abstract interface DomobPreRollAdListener
{
  public abstract void onLandingPageClose();
  
  public abstract void onLandingPageOpen();
  
  public abstract void onPreRollAdClicked();
  
  public abstract void onPreRollAdDismiss();
  
  public abstract void onPreRollAdFailed(DomobAdManager.ErrorCode paramErrorCode);
  
  public abstract void onPreRollAdLeaveApplication();
  
  public abstract void onPreRollAdPresent();
  
  public abstract void onPreRollAdReady();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobPreRollAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */