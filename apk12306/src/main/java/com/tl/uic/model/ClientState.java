package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class ClientState
  extends ClientMessageHeader
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = 1149075321417838161L;
  private MobileState mobileState;
  
  static
  {
    JniLib.a(ClientState.class, 1097);
  }
  
  public ClientState()
  {
    setMessageType(MessageType.CLIENT_STATE);
  }
  
  public final native Boolean clean();
  
  public final native boolean equals(Object paramObject);
  
  public final native JSONObject getJSON();
  
  public final native MobileState getMobileState();
  
  public final native int hashCode();
  
  public final native void setMobileState(MobileState paramMobileState);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\ClientState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */