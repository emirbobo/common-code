package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Set;

class AbstractBiMap$ValueSet
  extends ForwardingSet<V>
{
  final Set<V> valuesDelegate = AbstractBiMap.access$600(this.this$0).keySet();
  
  static
  {
    JniLib.a(ValueSet.class, 335);
  }
  
  private AbstractBiMap$ValueSet(AbstractBiMap paramAbstractBiMap) {}
  
  protected native Set<V> delegate();
  
  public native Iterator<V> iterator();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractBiMap$ValueSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */