package com.lidroid.xutils.util;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class PreferencesCookieStore$SerializableCookie
  implements Serializable
{
  private static final long serialVersionUID = 6374381828722046732L;
  private transient BasicClientCookie clientCookie;
  private final transient Cookie cookie;
  
  static
  {
    JniLib.a(SerializableCookie.class, 1027);
  }
  
  public PreferencesCookieStore$SerializableCookie(PreferencesCookieStore paramPreferencesCookieStore, Cookie paramCookie)
  {
    this.cookie = paramCookie;
  }
  
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native Cookie getCookie();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\util\PreferencesCookieStore$SerializableCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */