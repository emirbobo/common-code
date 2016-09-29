package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
final class EmptyImmutableSet
  extends ImmutableSet<Object>
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  static final EmptyImmutableSet INSTANCE;
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(EmptyImmutableSet.class, 435);
    INSTANCE = new EmptyImmutableSet();
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public final native int hashCode();
  
  public native boolean isEmpty();
  
  native boolean isHashCodeFast();
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<Object> iterator();
  
  native Object readResolve();
  
  public native int size();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\EmptyImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */