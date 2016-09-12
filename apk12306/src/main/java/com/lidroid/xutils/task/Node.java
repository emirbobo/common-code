package com.lidroid.xutils.task;

import com.bangcle.andjni.JniLib;

class Node<T>
{
  Node<T> next;
  private PriorityObject<?> value;
  private boolean valueAsT = false;
  
  static
  {
    JniLib.a(Node.class, 1011);
  }
  
  Node(T paramT)
  {
    setValue(paramT);
  }
  
  public native Priority getPriority();
  
  public native T getValue();
  
  public native void setValue(T paramT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\task\Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */