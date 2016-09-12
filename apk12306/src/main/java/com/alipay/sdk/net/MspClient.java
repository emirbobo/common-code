package com.alipay.sdk.net;

import android.content.Context;
import android.net.NetworkInfo;
import com.alipay.sdk.data.InteractionData;
import com.alipay.sdk.exception.NetErrorException;
import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.net.URL;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ByteArrayEntity;

public class MspClient
{
  private Context a;
  private String b;
  
  static
  {
    JniLib.a(MspClient.class, 113);
  }
  
  public MspClient(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MspClient(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  private static native ByteArrayEntity a(InteractionData paramInteractionData, String paramString, boolean paramBoolean)
    throws IOException;
  
  private native HttpHost e();
  
  private native NetworkInfo f();
  
  private native String g();
  
  public native String a();
  
  public native HttpResponse a(String paramString, InteractionData paramInteractionData)
    throws NetErrorException;
  
  public native void a(String paramString);
  
  public native URL b();
  
  public native HttpResponse b(String paramString)
    throws NetErrorException;
  
  public native HttpHost c();
  
  public native HttpHost d();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\net\MspClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */