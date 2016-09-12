package com.worklight.utils;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Mac;
import org.json.JSONArray;
import org.json.JSONException;

public class SecurityUtils
{
  public static final String HASH_ALGORITH_MD5 = "MD5";
  public static final String HASH_ALGORITH_SHA1 = "SHA-1";
  
  static
  {
    JniLib.a(SecurityUtils.class, 1277);
  }
  
  public static native InputStream decryptData(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws Exception;
  
  public static native String hashData(String paramString1, String paramString2);
  
  public static native byte[] hashData(byte[] paramArrayOfByte, String paramString);
  
  public static native String hashDataFromJSON(Context paramContext, JSONArray paramJSONArray)
    throws JSONException, UnsupportedEncodingException;
  
  public static native byte[] kpg(Context paramContext, String[] paramArrayOfString);
  
  public static class PBKDF2
  {
    static
    {
      JniLib.a(PBKDF2.class, 1276);
    }
    
    private static native int ceil(int paramInt1, int paramInt2);
    
    private static native byte[] concat(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
    
    private static native byte[] encodedInt(int paramInt);
    
    private static native byte[] f(Mac paramMac, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException;
    
    public static native Key genKey(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException;
    
    private static native byte[] xor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\utils\SecurityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */