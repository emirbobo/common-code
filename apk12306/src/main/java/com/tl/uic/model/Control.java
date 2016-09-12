package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class Control
  extends ClientMessageHeader
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = -859543818892459798L;
  private EventInfo eventInfo;
  private long focusInOffset;
  private Target target;
  
  static
  {
    JniLib.a(Control.class, 1099);
  }
  
  public Control()
  {
    setMessageType(MessageType.CONTROL);
  }
  
  public final native Boolean clean();
  
  public final native boolean equals(Object paramObject);
  
  public final native EventInfo getEventInfo();
  
  public final native long getFocusInOffset();
  
  public final native JSONObject getJSON();
  
  public final native Target getTarget();
  
  public final native int hashCode();
  
  public final native void setEventInfo(EventInfo paramEventInfo);
  
  public final native void setFocusInOffset(long paramLong);
  
  public final native void setTarget(Target paramTarget);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\Control.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */