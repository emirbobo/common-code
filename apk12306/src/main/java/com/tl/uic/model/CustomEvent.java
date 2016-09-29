package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public class CustomEvent
  extends ClientMessageHeader
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = -4501300217682609050L;
  private HashMap<String, String> data;
  private String name;
  
  static
  {
    JniLib.a(CustomEvent.class, 1100);
  }
  
  public CustomEvent()
  {
    setMessageType(MessageType.CUSTOM_EVENT);
  }
  
  public CustomEvent(int paramInt, String paramString, HashMap<String, String> paramHashMap)
  {
    setMessageType(MessageType.CUSTOM_EVENT);
    setLogLevel(paramInt);
    this.data = paramHashMap;
    this.name = paramString;
  }
  
  public final native Boolean clean();
  
  public final native HashMap<String, String> getData();
  
  public final native JSONObject getJSON();
  
  public final native String getName();
  
  public final native void setData(HashMap<String, String> paramHashMap);
  
  public final native void setName(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\CustomEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */