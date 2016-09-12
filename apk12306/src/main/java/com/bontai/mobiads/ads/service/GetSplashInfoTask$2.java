package com.bontai.mobiads.ads.service;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.entity.AdDomain;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import java.io.File;

class GetSplashInfoTask$2
  extends RequestCallBack<File>
{
  static
  {
    JniLib.a(2.class, 200);
  }
  
  GetSplashInfoTask$2(GetSplashInfoTask paramGetSplashInfoTask, Context paramContext, AdDomain paramAdDomain) {}
  
  public native void onFailure(HttpException paramHttpException, String paramString);
  
  public native void onLoading(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public native void onStart();
  
  public native void onSuccess(ResponseInfo<File> paramResponseInfo);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\service\GetSplashInfoTask$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */