package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

class AbstractMultimap$MultisetView
  extends AbstractMultiset<K>
{
  transient Set<Multiset.Entry<K>> entrySet;
  
  static
  {
    JniLib.a(MultisetView.class, 354);
  }
  
  private AbstractMultimap$MultisetView(AbstractMultimap paramAbstractMultimap) {}
  
  public native void clear();
  
  public native int count(Object paramObject);
  
  public native Set<K> elementSet();
  
  public native Set<Multiset.Entry<K>> entrySet();
  
  public native Iterator<K> iterator();
  
  public native int remove(Object paramObject, int paramInt);
  
  public native int size();
  
  private class EntrySet
    extends AbstractSet<Multiset.Entry<K>>
  {
    static
    {
      JniLib.a(EntrySet.class, 353);
    }
    
    private EntrySet() {}
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<Multiset.Entry<K>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$MultisetView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */