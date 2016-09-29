package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

public final class ConcurrentHashMultiset<E>
  extends AbstractMultiset<E>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final transient ConcurrentMap<E, Integer> countMap;
  private transient ConcurrentHashMultiset<E>.EntrySet entrySet;
  
  static
  {
    JniLib.a(ConcurrentHashMultiset.class, 388);
  }
  
  @VisibleForTesting
  ConcurrentHashMultiset(ConcurrentMap<E, Integer> paramConcurrentMap)
  {
    Preconditions.checkArgument(paramConcurrentMap.isEmpty());
    this.countMap = paramConcurrentMap;
  }
  
  public static native <E> ConcurrentHashMultiset<E> create();
  
  @Beta
  public static native <E> ConcurrentHashMultiset<E> create(GenericMapMaker<? super E, ? super Number> paramGenericMapMaker);
  
  public static native <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> paramIterable);
  
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  private native int removeAllOccurrences(@Nullable Object paramObject);
  
  private native List<E> snapshot();
  
  private static native int unbox(@Nullable Integer paramInteger);
  
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native int add(E paramE, int paramInt);
  
  public native int count(@Nullable Object paramObject);
  
  native Set<E> createElementSet();
  
  public native Set<Multiset.Entry<E>> entrySet();
  
  public native int remove(@Nullable Object paramObject, int paramInt);
  
  public native boolean removeExactly(@Nullable Object paramObject, int paramInt);
  
  public native int setCount(E paramE, int paramInt);
  
  public native boolean setCount(E paramE, int paramInt1, int paramInt2);
  
  public native int size();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
  
  private class EntrySet
    extends AbstractSet<Multiset.Entry<E>>
  {
    static
    {
      JniLib.a(EntrySet.class, 387);
    }
    
    private EntrySet() {}
    
    private native List<Multiset.Entry<E>> snapshot();
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native int hashCode();
    
    public native boolean isEmpty();
    
    public native Iterator<Multiset.Entry<E>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
  
  private static class FieldSettersHolder
  {
    static final Serialization.FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER = Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ConcurrentHashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */