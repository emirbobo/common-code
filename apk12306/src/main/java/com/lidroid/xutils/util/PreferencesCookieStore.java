package com.lidroid.xutils.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class PreferencesCookieStore
  implements CookieStore
{
  private static final String COOKIE_NAME_PREFIX = "cookie_";
  private static final String COOKIE_NAME_STORE = "names";
  private static final String COOKIE_PREFS = "CookiePrefsFile";
  private final SharedPreferences cookiePrefs;
  private final ConcurrentHashMap<String, Cookie> cookies;
  
  static
  {
    JniLib.a(PreferencesCookieStore.class, 1028);
  }
  
  public PreferencesCookieStore(Context paramContext)
  {
    this.cookiePrefs = paramContext.getSharedPreferences("CookiePrefsFile", 0);
    this.cookies = new ConcurrentHashMap();
    paramContext = this.cookiePrefs.getString("names", null);
    String[] arrayOfString;
    int j;
    if (paramContext != null)
    {
      arrayOfString = TextUtils.split(paramContext, ",");
      j = arrayOfString.length;
    }
    for (;;)
    {
      if (i >= j)
      {
        clearExpired(new Date());
        return;
      }
      paramContext = arrayOfString[i];
      Object localObject = this.cookiePrefs.getString("cookie_" + paramContext, null);
      if (localObject != null)
      {
        localObject = decodeCookie((String)localObject);
        if (localObject != null) {
          this.cookies.put(paramContext, localObject);
        }
      }
      i++;
    }
  }
  
  public native void addCookie(Cookie paramCookie);
  
  protected native String byteArrayToHexString(byte[] paramArrayOfByte);
  
  public native void clear();
  
  public native boolean clearExpired(Date paramDate);
  
  protected native Cookie decodeCookie(String paramString);
  
  protected native String encodeCookie(SerializableCookie paramSerializableCookie);
  
  public native Cookie getCookie(String paramString);
  
  public native List<Cookie> getCookies();
  
  protected native byte[] hexStringToByteArray(String paramString);
  
  public class SerializableCookie
    implements Serializable
  {
    private static final long serialVersionUID = 6374381828722046732L;
    private transient BasicClientCookie clientCookie;
    private final transient Cookie cookie;
    
    static
    {
      JniLib.a(SerializableCookie.class, 1027);
    }
    
    public SerializableCookie(Cookie paramCookie)
    {
      this.cookie = paramCookie;
    }
    
    private native void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException;
    
    private native void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException;
    
    public native Cookie getCookie();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\util\PreferencesCookieStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */