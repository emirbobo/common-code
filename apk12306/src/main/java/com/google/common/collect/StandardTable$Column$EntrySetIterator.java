package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$Column$EntrySetIterator
  extends AbstractIterator<Map.Entry<R, V>>
{
  final Iterator<Map.Entry<R, Map<C, V>>> iterator = this.this$1.this$0.backingMap.entrySet().iterator();
  
  static
  {
    JniLib.a(EntrySetIterator.class, 756);
  }
  
  StandardTable$Column$EntrySetIterator(StandardTable.Column paramColumn) {}
  
  protected native Map.Entry<R, V> computeNext();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$Column$EntrySetIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */