package com.MobileTicket;

import android.os.AsyncTask;
import android.text.format.DateFormat;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import java.util.Date;

public class TrackRestart
  extends AsyncTask<Object, Integer, Boolean>
{
  protected Boolean doInBackground(Object... paramVarArgs)
  {
    try
    {
      HttpUtils localHttpUtils = new com/lidroid/xutils/HttpUtils;
      localHttpUtils.<init>();
      RequestParams localRequestParams = new com/lidroid/xutils/http/RequestParams;
      localRequestParams.<init>();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      Object localObject = new java/util/Date;
      ((Date)localObject).<init>();
      localStringBuilder.<init>(String.valueOf(DateFormat.format("yyyyMMddHHmmss", (Date)localObject).toString()));
      localObject = paramVarArgs[0];
      paramVarArgs = new java/lang/StringBuilder;
      paramVarArgs.<init>("[{");
      localRequestParams.addBodyParameter("para", CheckCodeUtil.checkcode("", (String)localObject + "}]"));
      localObject = HttpRequest.HttpMethod.POST;
      paramVarArgs = new com/MobileTicket/TrackRestart$1;
      paramVarArgs.<init>(this);
      localHttpUtils.send((HttpRequest.HttpMethod)localObject, "https://mobile.12306.cn/otsmobile/track/arestart", localRequestParams, paramVarArgs);
      return null;
    }
    catch (Exception paramVarArgs)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\TrackRestart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */