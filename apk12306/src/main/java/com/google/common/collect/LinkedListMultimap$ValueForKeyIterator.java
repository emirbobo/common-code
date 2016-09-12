package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.ListIterator;
import java.util.Map;
import javax.annotation.Nullable;

class LinkedListMultimap$ValueForKeyIterator
  implements ListIterator<V>
{
  LinkedListMultimap.Node<K, V> current;
  final Object key;
  LinkedListMultimap.Node<K, V> next;
  int nextIndex;
  LinkedListMultimap.Node<K, V> previous;
  
  static
  {
    JniLib.a(ValueForKeyIterator.class, 572);
  }
  
  LinkedListMultimap$ValueForKeyIterator(@Nullable LinkedListMultimap paramLinkedListMultimap, Object paramObject)
  {
    this.key = paramObject;
    this.next = ((LinkedListMultimap.Node)LinkedListMultimap.access$400(paramLinkedListMultimap).get(paramObject));
  }
  
  public LinkedListMultimap$ValueForKeyIterator(@Nullable LinkedListMultimap paramLinkedListMultimap, Object paramObject, int paramInt)
  {
    int i = LinkedListMultimap.access$500(paramLinkedListMultimap).count(paramObject);
    Preconditions.checkPositionIndex(paramInt, i);
    if (paramInt >= i / 2)
    {
      this.previous = ((LinkedListMultimap.Node)LinkedListMultimap.access$600(paramLinkedListMultimap).get(paramObject));
      this.nextIndex = i;
      while (paramInt < i)
      {
        previous();
        paramInt++;
      }
    }
    this.next = ((LinkedListMultimap.Node)LinkedListMultimap.access$400(paramLinkedListMultimap).get(paramObject));
    while (paramInt > 0)
    {
      next();
      paramInt--;
    }
    this.key = paramObject;
    this.current = null;
  }
  
  public native void add(V paramV);
  
  public native boolean hasNext();
  
  public native boolean hasPrevious();
  
  public native V next();
  
  public native int nextIndex();
  
  public native V previous();
  
  public native int previousIndex();
  
  public native void remove();
  
  public native void set(V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$ValueForKeyIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */