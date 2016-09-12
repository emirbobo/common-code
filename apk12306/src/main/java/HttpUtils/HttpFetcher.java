package HttpUtils;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.alipay.mobilesecuritysdk.util.CommonUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class HttpFetcher
{
  private List<BasicNameValuePair> paramBuilder(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramString2 == null) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      if (paramBoolean) {}
      try
      {
        for (paramString2 = CommonUtils.textCompress(paramString2);; paramString2 = Base64.encodeToString(paramString2.getBytes(), 8))
        {
          if (!CommonUtils.isBlank(paramString2)) {
            break label43;
          }
          paramString1 = null;
          break;
        }
        label43:
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        if (!CommonUtils.isBlank(paramString1))
        {
          BasicNameValuePair localBasicNameValuePair = new org/apache/http/message/BasicNameValuePair;
          localBasicNameValuePair.<init>("serviceId", paramString1);
          localArrayList.add(localBasicNameValuePair);
          localStringBuilder.append("serviceId=");
          localStringBuilder.append(paramString1);
          localStringBuilder.append("&");
        }
        if (!CommonUtils.isBlank(paramString3))
        {
          paramString1 = new org/apache/http/message/BasicNameValuePair;
          paramString1.<init>("version", paramString3);
          localArrayList.add(paramString1);
          localStringBuilder.append("version=");
          localStringBuilder.append(paramString3);
          localStringBuilder.append("&");
        }
        paramString1 = new org/apache/http/message/BasicNameValuePair;
        paramString1.<init>("data", paramString2);
        localArrayList.add(paramString1);
        localStringBuilder.append("data=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("02000016-0010-0080-8000-10CA006D2CA5");
        paramString1 = new org/apache/http/message/BasicNameValuePair;
        paramString1.<init>("sign", CommonUtils.MD5(localStringBuilder.toString()));
        localArrayList.add(paramString1);
        paramString1 = new java/lang/StringBuilder;
        paramString1.<init>(String.valueOf(localStringBuilder.toString()));
        Log.i("ALP", localArrayList.toString());
        paramString1 = localArrayList;
      }
      catch (Exception paramString1)
      {
        Log.i("ALP", paramString1.getMessage());
        paramString1 = null;
      }
    }
  }
  
  public HttpClient getHttpClient()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 5000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 5000);
    return new DefaultHttpClient(localBasicHttpParams);
  }
  
  public HttpResponse uploadCollectedData(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    paramContext = null;
    if (paramString3 == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        HttpPost localHttpPost = new org/apache/http/client/methods/HttpPost;
        localHttpPost.<init>(paramString1);
        paramString1 = paramBuilder(paramString2, paramString3, paramString4, paramBoolean);
        if (paramString1 == null)
        {
          paramContext = null;
          continue;
        }
        paramString2 = new org/apache/http/client/entity/UrlEncodedFormEntity;
        paramString2.<init>(paramString1, "UTF-8");
        localHttpPost.setEntity(paramString2);
        paramString1 = getHttpClient().execute(localHttpPost);
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          Log.i("ALP", paramString1.getMessage());
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\HttpUtils\HttpFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */