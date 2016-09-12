package com.worklight.common;

import android.util.Log;
import com.bangcle.andjni.JniLib;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class WLX509TrustManager
  implements X509TrustManager
{
  private X509TrustManager standardTrustManager = null;
  
  static
  {
    JniLib.a(WLX509TrustManager.class, 1269);
  }
  
  public WLX509TrustManager(KeyStore paramKeyStore)
  {
    try
    {
      Log.d("SSL", "initial keystore");
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      localTrustManagerFactory.init(paramKeyStore);
      paramKeyStore = localTrustManagerFactory.getTrustManagers();
      if (paramKeyStore.length == 0)
      {
        paramKeyStore = new java/security/NoSuchAlgorithmException;
        paramKeyStore.<init>("no trust manager found");
        throw paramKeyStore;
      }
    }
    catch (NoSuchAlgorithmException paramKeyStore)
    {
      Log.e("SSL", "init keystore error. NoSuchAlgorithmException\n" + paramKeyStore.getMessage());
      for (;;)
      {
        return;
        this.standardTrustManager = ((X509TrustManager)paramKeyStore[0]);
      }
    }
    catch (KeyStoreException paramKeyStore)
    {
      for (;;)
      {
        Log.e("SSL", "init keystore error. KeyStoreException\n" + paramKeyStore.getMessage());
      }
    }
  }
  
  public native void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString);
  
  public native void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString);
  
  public native X509Certificate[] getAcceptedIssuers();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\WLX509TrustManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */