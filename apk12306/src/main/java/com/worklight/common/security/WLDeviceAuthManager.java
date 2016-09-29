package com.worklight.common.security;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.webkit.WebView;
import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.HashMap;
import org.json.JSONObject;

public class WLDeviceAuthManager
{
  private static final String ALG = "alg";
  private static final String APPLICATION = "application";
  private static final String EXP = "exp";
  private static final String JPK = "jpk";
  private static final String KEYSTORE_FILENAME = ".keystore";
  private static final String MOD = "mod";
  private static final String RSA = "RSA";
  private static final String X5C = "x5c";
  private static WLDeviceAuthManager instance;
  private static char[] keyStorePassword = null;
  private Context context;
  private String deviceUuid;
  private HashMap<String, KeyPair> keyPairHash = new HashMap();
  private WebView webView;
  
  static
  {
    JniLib.a(WLDeviceAuthManager.class, 1272);
  }
  
  private native String getAlias(String paramString);
  
  public static native WLDeviceAuthManager getInstance();
  
  private native byte[] signCsrData(String paramString, PrivateKey paramPrivateKey)
    throws NoSuchAlgorithmException, InvalidKeyException, SignatureException;
  
  private native byte[] signData(String paramString, PrivateKey paramPrivateKey)
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException;
  
  public native KeyPair generateKeyPair(String paramString)
    throws NoSuchAlgorithmException;
  
  public native String getDeviceUUID(Context paramContext);
  
  protected native KeyStore.PrivateKeyEntry getPrivateKeyEntry(String paramString)
    throws IOException, KeyStoreException, NoSuchAlgorithmException, CertificateException, PackageManager.NameNotFoundException, UnrecoverableEntryException;
  
  public native void init(Activity paramActivity, WebView paramWebView);
  
  public native boolean isCertificateExists(String paramString);
  
  public native void removeEntityKeyStoreValues(String paramString)
    throws KeyStoreException;
  
  public native void saveCertificate(String paramString1, String paramString2, String paramString3)
    throws Exception;
  
  public native void saveCertificate(String paramString1, Certificate paramCertificate, String paramString2)
    throws Exception;
  
  public native String signCsr(JSONObject paramJSONObject, String paramString)
    throws Exception;
  
  public native String signDeviceAuth(String paramString1, String paramString2, boolean paramBoolean)
    throws Exception;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\security\WLDeviceAuthManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */