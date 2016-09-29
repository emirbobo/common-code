package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class Position
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = -6298612983396630564L;
  private int height;
  private int width;
  private int x;
  private int y;
  
  static
  {
    JniLib.a(Position.class, 1107);
  }
  
  public final native Boolean clean();
  
  public final native boolean equals(Object paramObject);
  
  public final native int getHeight();
  
  public final native JSONObject getJSON();
  
  public final native int getWidth();
  
  public final native int getX();
  
  public final native int getY();
  
  public final native int hashCode();
  
  public final native void setHeight(int paramInt);
  
  public final native void setWidth(int paramInt);
  
  public final native void setX(int paramInt);
  
  public final native void setY(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\Position.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */