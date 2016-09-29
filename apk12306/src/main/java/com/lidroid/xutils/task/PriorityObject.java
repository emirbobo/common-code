package com.lidroid.xutils.task;

public class PriorityObject<E>
{
  public final E obj;
  public final Priority priority;
  
  public PriorityObject(Priority paramPriority, E paramE)
  {
    Priority localPriority = paramPriority;
    if (paramPriority == null) {
      localPriority = Priority.DEFAULT;
    }
    this.priority = localPriority;
    this.obj = paramE;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\task\PriorityObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */