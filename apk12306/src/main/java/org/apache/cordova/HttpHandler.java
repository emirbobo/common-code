package org.apache.cordova;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpHandler
{
  private HttpEntity getHttpEntity(String paramString)
  {
    try
    {
      DefaultHttpClient localDefaultHttpClient = new org/apache/http/impl/client/DefaultHttpClient;
      localDefaultHttpClient.<init>();
      HttpGet localHttpGet = new org/apache/http/client/methods/HttpGet;
      localHttpGet.<init>(paramString);
      paramString = localDefaultHttpClient.execute(localHttpGet).getEntity();
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private void writeToDisk(HttpEntity paramHttpEntity, String paramString)
    throws IllegalStateException, IOException
  {
    paramString = "/sdcard/" + paramString;
    InputStream localInputStream = paramHttpEntity.getContent();
    paramHttpEntity = new byte['Ѐ'];
    paramString = new FileOutputStream(paramString);
    for (;;)
    {
      int i = localInputStream.read(paramHttpEntity);
      if (i <= 0)
      {
        paramString.flush();
        paramString.close();
        return;
      }
      paramString.write(paramHttpEntity, 0, i);
    }
  }
  
  protected Boolean get(String paramString1, String paramString2)
  {
    paramString1 = getHttpEntity(paramString1);
    try
    {
      writeToDisk(paramString1, paramString2);
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        label23:
        paramString1.printStackTrace();
        paramString1 = Boolean.valueOf(false);
      }
    }
    try
    {
      paramString1.consumeContent();
      paramString1 = Boolean.valueOf(true);
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = Boolean.valueOf(false);
      break label23;
    }
    return paramString1;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\HttpHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */