package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class MessageFormat
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = 7470897849248685953L;
  private String messageVersion;
  private int serialNumber;
  private Session session;
  
  static
  {
    JniLib.a(MessageFormat.class, 1104);
  }
  
  public final native Boolean clean();
  
  public final native JSONObject getJSON();
  
  public final native String getMessageVersion();
  
  public final native int getSerialNumber();
  
  public final native Session getSession();
  
  public final native void setMessageVersion(String paramString);
  
  public final native void setSerialNumber(int paramInt);
  
  public final native void setSession(Session paramSession);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\MessageFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */