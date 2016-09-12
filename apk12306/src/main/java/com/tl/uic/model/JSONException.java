package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public class JSONException
  extends ClientMessageHeader
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = 1817811642841780549L;
  private HashMap<String, String> data;
  private String description;
  private String name;
  private String stackTrace;
  
  static
  {
    JniLib.a(JSONException.class, 1102);
  }
  
  public JSONException()
  {
    setMessageType(MessageType.EXCEPTION);
    setLogLevel(0);
  }
  
  public final native Boolean clean();
  
  public final native HashMap<String, String> getData();
  
  public final native String getDescription();
  
  public final native JSONObject getJSON();
  
  public final native String getName();
  
  public final native String getStackTrace();
  
  public final native void setData(HashMap<String, String> paramHashMap);
  
  public final native void setDescription(String paramString);
  
  public final native void setName(String paramString);
  
  public final native void setStackTrace(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\JSONException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */