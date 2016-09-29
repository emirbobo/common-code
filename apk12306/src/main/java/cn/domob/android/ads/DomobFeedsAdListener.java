package cn.domob.android.ads;

public abstract interface DomobFeedsAdListener
{
  public abstract void onFeedsAdClicked(DomobFeedsAdView paramDomobFeedsAdView);
  
  public abstract void onFeedsAdDismiss();
  
  public abstract void onFeedsAdFailed(DomobAdManager.ErrorCode paramErrorCode);
  
  public abstract void onFeedsAdLeaveApplication();
  
  public abstract void onFeedsAdPresent();
  
  public abstract void onFeedsAdReady();
  
  public abstract void onLandingPageClose();
  
  public abstract void onLandingPageOpen();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobFeedsAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */