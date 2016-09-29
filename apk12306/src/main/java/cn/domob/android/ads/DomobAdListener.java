package cn.domob.android.ads;

public abstract interface DomobAdListener
{
  public abstract void onFailedToReceiveFreshAd(DomobAdView paramDomobAdView);
  
  public abstract void onLandingPageClose();
  
  public abstract void onLandingPageOpening();
  
  public abstract void onReceivedFreshAd(DomobAdView paramDomobAdView);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */