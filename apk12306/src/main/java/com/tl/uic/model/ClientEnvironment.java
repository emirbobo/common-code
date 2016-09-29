package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class ClientEnvironment
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = -5008152574755865321L;
  private int height;
  private MobileEnvironment mobileEnvironment;
  private String osVersion;
  private int width;
  
  static
  {
    JniLib.a(ClientEnvironment.class, 1095);
  }
  
  public final native Boolean clean();
  
  public final native int getHeight();
  
  public final native JSONObject getJSON();
  
  public final native MobileEnvironment getMobileEnvironment();
  
  public final native String getOsVersion();
  
  public final native int getWidth();
  
  public final native void setHeight(int paramInt);
  
  public final native void setMobileEnvironment(MobileEnvironment paramMobileEnvironment);
  
  public final native void setOsVersion(String paramString);
  
  public final native void setWidth(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\ClientEnvironment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */