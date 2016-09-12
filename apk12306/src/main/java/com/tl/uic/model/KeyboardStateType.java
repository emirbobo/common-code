package com.tl.uic.model;

import java.io.Serializable;

public enum KeyboardStateType
  implements Serializable
{
  HIDDEN_FALSE(0),  HIDDEN_TRUE(1),  UNDEFINED(2);
  
  private int value;
  
  private KeyboardStateType(int paramInt1)
  {
    this.value = paramInt1;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\KeyboardStateType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */