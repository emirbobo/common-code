package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class AndroidState
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = 1263057271140459227L;
  private KeyboardStateType keyboardStateType;
  
  static
  {
    JniLib.a(AndroidState.class, 1094);
  }
  
  public final native Boolean clean();
  
  public final native boolean equals(Object paramObject);
  
  public final native JSONObject getJSON();
  
  public final native KeyboardStateType getKeyboardStateType();
  
  public final native int hashCode();
  
  public final native void setKeyboardStateType(KeyboardStateType paramKeyboardStateType);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\AndroidState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */