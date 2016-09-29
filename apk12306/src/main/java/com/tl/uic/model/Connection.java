package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class Connection
  extends ClientMessageHeader
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = 4394765877843086798L;
  private long initTime;
  private long loadTime;
  private long responseDataSize;
  private long responseTime;
  private int statusCode;
  private String url;
  
  static
  {
    JniLib.a(Connection.class, 1098);
  }
  
  public Connection()
  {
    setMessageType(MessageType.CONNECTION);
  }
  
  public final native Boolean clean();
  
  public final native long getInitTime();
  
  public final native JSONObject getJSON();
  
  public final native long getLoadTime();
  
  public final native long getResponseDataSize();
  
  public final native long getResponseTime();
  
  public final native int getStatusCode();
  
  public final native String getUrl();
  
  public final native void setInitTime(long paramLong);
  
  public final native void setLoadTime(long paramLong);
  
  public final native void setResponseDataSize(long paramLong);
  
  public final native void setResponseTime(long paramLong);
  
  public final native void setStatusCode(int paramInt);
  
  public final native void setUrl(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */