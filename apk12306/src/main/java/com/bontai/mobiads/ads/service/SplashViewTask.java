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

public class SplashViewTask
  extends AsyncTask<Object, Integer, Boolean>
{
  protected Boolean doInBackground(Object... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        Log.i("----------------", "------SplashViewTask--------");
        localObject1 = (Context)paramVarArgs[0];
        paramVarArgs = (AdDomain)paramVarArgs[1];
        if ((paramVarArgs != null) && (paramVarArgs.getViewUrl() != null) && (!paramVarArgs.getViewUrl().equals("")))
        {
          paramVarArgs = paramVarArgs.getViewUrl();
          if (!paramVarArgs.contains("?")) {
            continue;
          }
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>(String.valueOf(paramVarArgs));
          paramVarArgs = "&clientType=1&ip=" + DeviceUtils.getDeviceId((Context)localObject1);
          localObject1 = new com/lidroid/xutils/HttpUtils;
          ((HttpUtils)localObject1).<init>();
          ((HttpUtils)localObject1).configDefaultHttpCacheExpiry(0L);
          localObject2 = HttpRequest.HttpMethod.GET;
          RequestCallBack local1 = new com/bontai/mobiads/ads/service/SplashViewTask$1;
          local1.<init>(this);
          ((HttpUtils)localObject1).send((HttpRequest.HttpMethod)localObject2, paramVarArgs, local1);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\service\SplashViewTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */