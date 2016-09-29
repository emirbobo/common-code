package com.worklight.common;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class SSLConfig
{
  public static final String WL_CLIENT_PROPS_NAME = "wlclient.properties";
  public static final String WL_HTTPS_PORT = "wlServerHttpsPort";
  public static final String WL_SSL_IGNORE_CERTIFICATE = "ignoreSSLCertificate";
  private Context context;
  private int httpsPort = 443;
  private boolean isIgnoreSSLCertificate = true;
  private boolean isPrivateCA = true;
  private String keystore = "server_trust2";
  private String keystorePassword = "passw0rd";
  
  static
  {
    JniLib.a(SSLConfig.class, 1257);
  }
  
  public SSLConfig(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public native Context getContext();
  
  public native int getHttpsPort();
  
  public native String getKeystore();
  
  public native String getKeystorePassword();
  
  public native boolean isIgnoreSSLCertificate();
  
  public native boolean isPrivateCA();
  
  public native void setContext(Context paramContext);
  
  public native void setHttpsPort(int paramInt);
  
  public native void setIgnoreSSLCertificate(boolean paramBoolean);
  
  public native void setKeystore(String paramString);
  
  public native void setKeystorePassword(String paramString);
  
  public native void setPrivateCA(boolean paramBoolean);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\SSLConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */