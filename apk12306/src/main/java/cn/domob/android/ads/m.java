package cn.domob.android.ads;

import android.content.Context;

public abstract interface m
{
  public abstract void close();
  
  public abstract void onDomobAdClicked();
  
  public abstract void onDomobAdFailed(DomobAdManager.ErrorCode paramErrorCode);
  
  public abstract void onDomobAdOverlayDismissed();
  
  public abstract void onDomobAdOverlayPresented();
  
  public abstract Context onDomobAdRequiresCurrentContext();
  
  public abstract void onDomobAdReturned(n paramn);
  
  public abstract void onDomobLeaveApplication();
  
  public abstract void onProcessActionType(String paramString);
  
  public abstract void setCreativeRect(int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */