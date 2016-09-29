package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class AbstractBiMap$KeySet
  extends ForwardingSet<K>
{
  static
  {
    JniLib.a(KeySet.class, 333);
  }
  
  private AbstractBiMap$KeySet(AbstractBiMap paramAbstractBiMap) {}
  
  public native void clear();
  
  protected native Set<K> delegate();
  
  public native Iterator<K> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractBiMap$KeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */