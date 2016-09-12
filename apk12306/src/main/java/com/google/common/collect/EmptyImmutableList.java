package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
final class EmptyImmutableList
  extends ImmutableList<Object>
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  static final EmptyImmutableList INSTANCE;
  static final UnmodifiableListIterator<Object> ITERATOR;
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(EmptyImmutableList.class, 429);
    INSTANCE = new EmptyImmutableList();
    ITERATOR = new UnmodifiableListIterator()
    {
      static
      {
        JniLib.a(1.class, 428);
      }
      
      public native boolean hasNext();
      
      public native boolean hasPrevious();
      
      public native Object next();
      
      public native int nextIndex();
      
      public native Object previous();
      
      public native int previousIndex();
    };
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native Object get(int paramInt);
  
  public native int hashCode();
  
  public native int indexOf(Object paramObject);
  
  public native boolean isEmpty();
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<Object> iterator();
  
  public native int lastIndexOf(Object paramObject);
  
  public native UnmodifiableListIterator<Object> listIterator();
  
  public native UnmodifiableListIterator<Object> listIterator(int paramInt);
  
  native Object readResolve();
  
  public native ImmutableList<Object> reverse();
  
  public native int size();
  
  public native ImmutableList<Object> subList(int paramInt1, int paramInt2);
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\EmptyImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */