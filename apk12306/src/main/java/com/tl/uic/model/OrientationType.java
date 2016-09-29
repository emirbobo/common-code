package com.tl.uic.model;

import java.io.Serializable;

public enum OrientationType
  implements Serializable
{
  LANDSCAPE(0),  PORTRAIT(1),  SQUARE(2),  UNDEFINED(3);
  
  private int value;
  
  private OrientationType(int paramInt1)
  {
    this.value = paramInt1;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\OrientationType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */