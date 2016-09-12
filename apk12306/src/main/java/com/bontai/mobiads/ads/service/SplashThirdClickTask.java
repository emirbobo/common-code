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

public class SplashThirdClickTask
  extends AsyncTask<Object, Integer, Boolean>
{
  protected Boolean doInBackground(Object... paramVarArgs)
  {
    try
    {
      Log.i("----------------", "------SplashThirdClickTask--------");
      localContext = (Context)paramVarArgs[0];
      paramVarArgs = (AdDomain)paramVarArgs[1];
      if ((paramVarArgs != null) && (paramVarArgs.getThirdClickUrls() != null) && (!paramVarArgs.getThirdClickUrls().equals("")))
      {
        arrayOfString = paramVarArgs.getThirdClickUrls().split(",");
        int j = arrayOfString.length;
        i = 0;
        if (i < j) {
          break label75;
        }
      }
      paramVarArgs = Boolean.valueOf(true);
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        Context localContext;
        String[] arrayOfString;
        int i;
        label75:
        Object localObject;
        paramVarArgs = Boolean.valueOf(false);
      }
    }
    return paramVarArgs;
    paramVarArgs = arrayOfString[i];
    if (paramVarArgs.contains("?"))
    {
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>(String.valueOf(paramVarArgs));
    }
    for (paramVarArgs = "&clientType=1&ip=" + DeviceUtils.getDeviceId(localContext);; paramVarArgs = "?clientType=1&ip=" + DeviceUtils.getDeviceId(localContext))
    {
      localObject = new com/lidroid/xutils/HttpUtils;
      ((HttpUtils)localObject).<init>();
      ((HttpUtils)localObject).configDefaultHttpCacheExpiry(0L);
      HttpRequest.HttpMethod localHttpMethod = HttpRequest.HttpMethod.GET;
      RequestCallBack local1 = new com/bontai/mobiads/ads/service/SplashThirdClickTask$1;
      local1.<init>(this);
      ((HttpUtils)localObject).send(localHttpMethod, paramVarArgs, local1);
      i++;
      break;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>(String.valueOf(paramVarArgs));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\service\SplashThirdClickTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */