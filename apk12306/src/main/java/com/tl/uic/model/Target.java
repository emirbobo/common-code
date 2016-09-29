package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public class Target
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = 4998476519365613648L;
  private HashMap<String, String> currentState;
  private long dwell;
  private String id;
  private Position position;
  private HashMap<String, String> previousState;
  private String subType;
  private String tlType;
  private String type;
  private int visitedCount = -1;
  
  static
  {
    JniLib.a(Target.class, 1111);
  }
  
  public final native Boolean clean();
  
  public final native boolean equals(Object paramObject);
  
  public final native HashMap<String, String> getCurrentState();
  
  public final native long getDwell();
  
  public final native String getId();
  
  public final native JSONObject getJSON();
  
  public final native Position getPosition();
  
  public final native HashMap<String, String> getPreviousState();
  
  public final native String getSubType();
  
  public final native String getTlType();
  
  public final native String getType();
  
  public final native int getVisitedCount();
  
  public final native int hashCode();
  
  public final native void setCurrentState(HashMap<String, String> paramHashMap);
  
  public final native void setDwell(long paramLong);
  
  public final native void setId(String paramString);
  
  public final native void setPosition(Position paramPosition);
  
  public final native void setPreviousState(HashMap<String, String> paramHashMap);
  
  public final native void setSubType(String paramString);
  
  public final native void setTlType(String paramString);
  
  public final native void setType(String paramString);
  
  public final native void setVisitedCount(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\Target.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */