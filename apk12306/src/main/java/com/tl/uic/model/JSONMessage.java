package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class JSONMessage
  implements Serializable
{
  private static final long serialVersionUID = 3976757161355685264L;
  private String jsonData;
  private int logLevel;
  private long size;
  
  static
  {
    JniLib.a(JSONMessage.class, 1103);
  }
  
  public JSONMessage()
  {
    this.logLevel = 0;
    this.jsonData = "";
    this.size = 0L;
  }
  
  public JSONMessage(ClientMessageHeader paramClientMessageHeader)
  {
    this.logLevel = paramClientMessageHeader.getLogLevel();
    this.jsonData = paramClientMessageHeader.getJSON().toString();
    this.size = 0L;
  }
  
  public final native Boolean clean();
  
  public final native boolean equals(Object paramObject);
  
  public final native String getJsonData();
  
  public final native int getLogLevel();
  
  public final native long getSize();
  
  public final native int hashCode();
  
  public final native void setJsonData(String paramString);
  
  public final native void setLogLevel(int paramInt);
  
  public final native void setSize(long paramLong);
  
  public final native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\JSONMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */