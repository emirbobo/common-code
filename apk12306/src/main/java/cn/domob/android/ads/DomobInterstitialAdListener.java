package cn.domob.android.ads;

public abstract interface DomobInterstitialAdListener
{
  public abstract void onInterstitialAdClicked(DomobInterstitialAd paramDomobInterstitialAd);
  
  public abstract void onInterstitialAdDismiss();
  
  public abstract void onInterstitialAdFailed(DomobAdManager.ErrorCode paramErrorCode);
  
  public abstract void onInterstitialAdLeaveApplication();
  
  public abstract void onInterstitialAdPresent();
  
  public abstract void onInterstitialAdReady();
  
  public abstract void onLandingPageClose();
  
  public abstract void onLandingPageOpen();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobInterstitialAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */