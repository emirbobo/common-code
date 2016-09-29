package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class EventInfo
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = 7080612713953252184L;
  private String subType;
  private String tlEvent;
  private String type;
  
  static
  {
    JniLib.a(EventInfo.class, 1101);
  }
  
  public final native Boolean clean();
  
  public final native boolean equals(Object paramObject);
  
  public final native JSONObject getJSON();
  
  public final native String getSubType();
  
  public final native String getTlEvent();
  
  public final native String getType();
  
  public final native int hashCode();
  
  public final native void setSubType(String paramString);
  
  public final native void setTlEvent(String paramString);
  
  public final native void setType(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\EventInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */