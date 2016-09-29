package com.arrownock.cordova.plugin;

import com.arrownock.exception.ArrownockException;
import com.arrownock.push.AnPushCallbackAdapter;
import com.arrownock.push.AnPushStatus;
import com.bangcle.andjni.JniLib;

class AnPushCDVFetchingModePlugin$CordovaAnPushCallback
  extends AnPushCallbackAdapter
{
  static
  {
    JniLib.a(CordovaAnPushCallback.class, 145);
  }
  
  AnPushCDVFetchingModePlugin$CordovaAnPushCallback(AnPushCDVFetchingModePlugin paramAnPushCDVFetchingModePlugin) {}
  
  private native String generateErrorJSON(ArrownockException paramArrownockException);
  
  public native void clearMute(boolean paramBoolean, ArrownockException paramArrownockException);
  
  public native void clearSilentPeriod(boolean paramBoolean, ArrownockException paramArrownockException);
  
  public native void register(boolean paramBoolean, String paramString, ArrownockException paramArrownockException);
  
  public native void setMute(boolean paramBoolean, ArrownockException paramArrownockException);
  
  public native void setScheduledMute(boolean paramBoolean, ArrownockException paramArrownockException);
  
  public native void setSilentPeriod(boolean paramBoolean, ArrownockException paramArrownockException);
  
  public native void statusChanged(AnPushStatus paramAnPushStatus, ArrownockException paramArrownockException);
  
  public native void unregister(boolean paramBoolean, ArrownockException paramArrownockException);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\cordova\plugin\AnPushCDVFetchingModePlugin$CordovaAnPushCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */