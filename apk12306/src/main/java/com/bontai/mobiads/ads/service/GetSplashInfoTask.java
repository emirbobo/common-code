package com.bontai.mobiads.ads.service;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.AppHelp;
import com.bontai.mobiads.ads.DeviceScreen;
import com.bontai.mobiads.ads.DeviceUtils;
import com.bontai.mobiads.ads.entity.AdDomain;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import java.io.File;

public class GetSplashInfoTask
  extends AsyncTask<Object, Integer, Boolean>
{
  static
  {
    JniLib.a(GetSplashInfoTask.class, 201);
  }
  
  private native void downloadPic(AdDomain paramAdDomain, Context paramContext);
  
  protected Boolean doInBackground(Object... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        Context localContext = (Context)paramVarArgs[0];
        Object localObject4 = (String)paramVarArgs[2];
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>(String.valueOf(AppHelp.getBontaiMobiAdsUrl(localContext)));
        localObject3 = AppHelp.GT_CDN_AD_URL + "/" + (String)localObject4 + ".html";
        if (paramVarArgs[1] == null) {
          continue;
        }
        Object localObject2 = (AdDomain)paramVarArgs[1];
        paramVarArgs = (Object[])localObject2;
        localObject1 = localObject3;
        if (((AdDomain)localObject2).getServiceType() != null)
        {
          paramVarArgs = (Object[])localObject2;
          localObject1 = localObject3;
          if (((AdDomain)localObject2).getServiceType().equals("0"))
          {
            paramVarArgs = (Object[])localObject2;
            localObject1 = localObject3;
            if (((AdDomain)localObject2).getServiceUrl() != null)
            {
              paramVarArgs = (Object[])localObject2;
              localObject1 = localObject3;
              if (!((AdDomain)localObject2).getServiceUrl().equals(""))
              {
                localObject1 = DeviceScreen.getAdSize(localContext);
                paramVarArgs = new java/lang/StringBuilder;
                paramVarArgs.<init>(String.valueOf(((AdDomain)localObject2).getServiceUrl()));
                localObject1 = "?placementNo=" + (String)localObject4 + "&placementType=1&screenSize=" + (String)localObject1 + "&appKey=" + AppHelp.getAppKey(localContext) + "&clientType=1&ip=" + DeviceUtils.getDeviceId(localContext);
                paramVarArgs = (Object[])localObject2;
              }
            }
          }
        }
        Log.i("---------", (String)localObject1);
        localObject3 = new com/lidroid/xutils/HttpUtils;
        ((HttpUtils)localObject3).<init>();
        ((HttpUtils)localObject3).configDefaultHttpCacheExpiry(0L);
        localObject2 = HttpRequest.HttpMethod.GET;
        localObject4 = new com/bontai/mobiads/ads/service/GetSplashInfoTask$1;
        ((1)localObject4).<init>(this, paramVarArgs, localContext);
        ((HttpUtils)localObject3).send((HttpRequest.HttpMethod)localObject2, (String)localObject1, (RequestCallBack)localObject4);
        paramVarArgs = Boolean.valueOf(true);
      }
      catch (Exception paramVarArgs)
      {
        Object localObject1;
        Object localObject3;
        paramVarArgs = Boolean.valueOf(false);
        continue;
      }
      return paramVarArgs;
      paramVarArgs = null;
      localObject1 = localObject3;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\service\GetSplashInfoTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */