package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Sets$SetFromMap<E>
  extends AbstractSet<E>
  implements Set<E>, Serializable
{
  @GwtIncompatible("not needed in emulated source")
  private static final long serialVersionUID = 0L;
  private final Map<E, Boolean> m;
  private transient Set<E> s;
  
  static
  {
    JniLib.a(SetFromMap.class, 729);
  }
  
  Sets$SetFromMap(Map<E, Boolean> paramMap)
  {
    Preconditions.checkArgument(paramMap.isEmpty(), "Map is non-empty");
    this.m = paramMap;
    this.s = paramMap.keySet();
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  public native boolean add(E paramE);
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native boolean isEmpty();
  
  public native Iterator<E> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int size();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$SetFromMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */