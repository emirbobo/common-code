package com.MobileTicket;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

class TrackRestart$1
  extends RequestCallBack<String>
{
  static
  {
    JniLib.a(1.class, 19);
  }
  
  TrackRestart$1(TrackRestart paramTrackRestart) {}
  
  public native void onFailure(HttpException paramHttpException, String paramString);
  
  public native void onLoading(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public native void onStart();
  
  public native void onSuccess(ResponseInfo<String> paramResponseInfo);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\TrackRestart$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */