package com.tl.uic.model;

import java.io.Serializable;

public enum ScreenviewType
  implements Serializable
{
  LOAD(0),  UNLOAD(1);
  
  private int value;
  
  private ScreenviewType(int paramInt1)
  {
    this.value = paramInt1;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\ScreenviewType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */