package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import com.tl.uic.TLFCache;
import com.tl.uic.Tealeaf;
import java.io.Serializable;
import org.json.JSONObject;

public class ClientMessageHeader
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = 876537710682369925L;
  private Boolean fromWeb = Boolean.valueOf(false);
  private int logLevel;
  private MessageType messageType;
  private long offset = TLFCache.timestampFromSession();
  private long screenviewOffset = Tealeaf.getApplicationScreenviewOffset();
  
  static
  {
    JniLib.a(ClientMessageHeader.class, 1096);
  }
  
  public native Boolean clean();
  
  public native boolean equals(Object paramObject);
  
  public final native Boolean getFromWeb();
  
  public native JSONObject getJSON();
  
  public final native int getLogLevel();
  
  public final native MessageType getMessageType();
  
  public final native long getOffset();
  
  public final native long getScreenviewOffset();
  
  public native int hashCode();
  
  public final native void setFromWeb(Boolean paramBoolean);
  
  public final native void setLogLevel(int paramInt);
  
  public final native void setMessageType(MessageType paramMessageType);
  
  public final native void setOffset(long paramLong);
  
  public final native void setScreenviewOffset(long paramLong);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\ClientMessageHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */