package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class CustomConcurrentHashMap$HashIterator
{
  AtomicReferenceArray<CustomConcurrentHashMap.ReferenceEntry<K, V>> currentTable;
  CustomConcurrentHashMap<K, V>.WriteThroughEntry lastReturned;
  CustomConcurrentHashMap.ReferenceEntry<K, V> nextEntry;
  CustomConcurrentHashMap<K, V>.WriteThroughEntry nextExternal;
  int nextSegmentIndex;
  int nextTableIndex;
  
  CustomConcurrentHashMap$HashIterator(CustomConcurrentHashMap paramCustomConcurrentHashMap)
  {
    this.nextSegmentIndex = (paramCustomConcurrentHashMap.segments.length - 1);
    this.nextTableIndex = -1;
    advance();
  }
  
  final void advance()
  {
    this.nextExternal = null;
    if (nextInChain())
    {
      return;
      break label20;
    }
    for (;;)
    {
      if (!nextInTable()) {
        label20:
        if (this.nextSegmentIndex >= 0)
        {
          Object localObject = this.this$0.segments;
          int i = this.nextSegmentIndex;
          this.nextSegmentIndex = (i - 1);
          localObject = localObject[i];
          if (((CustomConcurrentHashMap.Segment)localObject).count == 0) {
            break;
          }
          this.currentTable = ((CustomConcurrentHashMap.Segment)localObject).table;
          this.nextTableIndex = (this.currentTable.length() - 1);
          if (!nextInTable()) {
            break;
          }
        }
      }
    }
  }
  
  boolean advanceTo(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    Object localObject1 = paramReferenceEntry.getKey();
    Object localObject2 = paramReferenceEntry.getValueReference().get();
    if ((localObject1 != null) && (localObject2 != null) && ((!this.this$0.expires()) || (!this.this$0.isExpired(paramReferenceEntry)))) {
      this.nextExternal = new CustomConcurrentHashMap.WriteThroughEntry(this.this$0, localObject1, localObject2);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean hasNext()
  {
    if (this.nextExternal != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  CustomConcurrentHashMap<K, V>.WriteThroughEntry nextEntry()
  {
    if (this.nextExternal == null) {
      throw new NoSuchElementException();
    }
    this.lastReturned = this.nextExternal;
    advance();
    return this.lastReturned;
  }
  
  boolean nextInChain()
  {
    if (this.nextEntry != null)
    {
      this.nextEntry = this.nextEntry.getNext();
      if (this.nextEntry != null) {
        if (!advanceTo(this.nextEntry)) {}
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      this.nextEntry = this.nextEntry.getNext();
      break;
    }
  }
  
  boolean nextInTable()
  {
    Object localObject;
    do
    {
      if (this.nextTableIndex < 0) {
        break;
      }
      localObject = this.currentTable;
      int i = this.nextTableIndex;
      this.nextTableIndex = (i - 1);
      localObject = (CustomConcurrentHashMap.ReferenceEntry)((AtomicReferenceArray)localObject).get(i);
      this.nextEntry = ((CustomConcurrentHashMap.ReferenceEntry)localObject);
    } while ((localObject == null) || ((!advanceTo(this.nextEntry)) && (!nextInChain())));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void remove()
  {
    if (this.lastReturned != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      this.this$0.remove(this.lastReturned.getKey());
      this.lastReturned = null;
      return;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$HashIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */