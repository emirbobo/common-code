package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Map;

abstract class StandardTable$TableCollection<T>
  extends AbstractCollection<T>
{
  private StandardTable$TableCollection(StandardTable paramStandardTable) {}
  
  public void clear()
  {
    this.this$0.backingMap.clear();
  }
  
  public boolean isEmpty()
  {
    return this.this$0.backingMap.isEmpty();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$TableCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */