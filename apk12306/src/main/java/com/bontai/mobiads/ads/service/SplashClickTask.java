package com.bontai.mobiads.ads.service;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.DeviceUtils;
import com.bontai.mobiads.ads.entity.AdDomain;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class SplashClickTask
  extends AsyncTask<Object, Integer, Boolean>
{
  protected Boolean doInBackground(Object... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        Log.i("----------------", "------SplashClickTask--------");
        localObject1 = (Context)paramVarArgs[0];
        paramVarArgs = (AdDomain)paramVarArgs[1];
        if ((paramVarArgs != null) && (paramVarArgs.getClickUrl() != null) && (!paramVarArgs.getClickUrl().equals("")))
        {
          paramVarArgs = paramVarArgs.getClickUrl();
          if (!paramVarArgs.contains("?")) {
            continue;
          }
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>(String.valueOf(paramVarArgs));
          paramVarArgs = "&clientType=1&ip=" + DeviceUtils.getDeviceId((Context)localObject1);
          HttpUtils localHttpUtils = new com/lidroid/xutils/HttpUtils;
          localHttpUtils.<init>();
          localHttpUtils.configDefaultHttpCacheExpiry(0L);
          localObject2 = HttpRequest.HttpMethod.GET;
          localObject1 = new com/bontai/mobiads/ads/service/SplashClickTask$1;
          ((1)localObject1).<init>(this);
          localHttpUtils.send((HttpRequest.HttpMethod)localObject2, paramVarArgs, (RequestCallBack)localObject1);
        }
        paramVarArgs = Boolean.valueOf(true);
      }
      catch (Exception paramVarArgs)
      {
        Object localObject1;
        Object localObject2;
        paramVarArgs = Boolean.valueOf(false);
        continue;
      }
      return paramVarArgs;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>(String.valueOf(paramVarArgs));
      paramVarArgs = "?clientType=1&ip=" + DeviceUtils.getDeviceId((Context)localObject1);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\service\SplashClickTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */