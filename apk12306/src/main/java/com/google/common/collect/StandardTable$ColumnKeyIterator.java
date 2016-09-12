package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Supplier;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$ColumnKeyIterator
  extends AbstractIterator<C>
{
  Iterator<Map.Entry<C, V>> entryIterator = Iterators.emptyIterator();
  final Iterator<Map<C, V>> mapIterator = this.this$0.backingMap.values().iterator();
  final Map<C, V> seen = (Map)this.this$0.factory.get();
  
  static
  {
    JniLib.a(ColumnKeyIterator.class, 763);
  }
  
  private StandardTable$ColumnKeyIterator(StandardTable paramStandardTable) {}
  
  protected native C computeNext();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$ColumnKeyIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */