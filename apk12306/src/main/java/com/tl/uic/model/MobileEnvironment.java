package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class MobileEnvironment
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = -4663909733862705899L;
  private AndroidArray androidArray;
  private String appName;
  private String appVersion;
  private String deviceModel;
  private String language;
  private String locale;
  private String manufacturer;
  private OrientationType orientationType;
  private long totalMemory;
  private long totalStorage;
  private String userID;
  
  static
  {
    JniLib.a(MobileEnvironment.class, 1105);
  }
  
  public final native Boolean clean();
  
  public final native AndroidArray getAndroidArray();
  
  public final native String getAppName();
  
  public final native String getAppVersion();
  
  public final native String getDeviceModel();
  
  public final native JSONObject getJSON();
  
  public final native String getLanguage();
  
  public final native String getLocale();
  
  public final native String getManufacturer();
  
  public final native OrientationType getOrientationType();
  
  public final native long getTotalMemory();
  
  public final native long getTotalStorage();
  
  public final native String getUserID();
  
  public final native void setAndroidArray(AndroidArray paramAndroidArray);
  
  public final native void setAppName(String paramString);
  
  public final native void setAppVersion(String paramString);
  
  public final native void setDeviceModel(String paramString);
  
  public final native void setLanguage(String paramString);
  
  public final native void setLocale(String paramString);
  
  public final native void setManufacturer(String paramString);
  
  public final native void setOrientationType(OrientationType paramOrientationType);
  
  public final native void setTotalMemory(long paramLong);
  
  public final native void setTotalStorage(long paramLong);
  
  public final native void setUserID(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\MobileEnvironment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */