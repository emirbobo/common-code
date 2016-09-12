package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public final class LinkedHashMultimap<K, V>
  extends AbstractSetMultimap<K, V>
{
  private static final int DEFAULT_VALUES_PER_KEY = 8;
  @GwtIncompatible("java serialization not supported")
  private static final long serialVersionUID = 0L;
  @VisibleForTesting
  transient int expectedValuesPerKey = 8;
  transient Collection<Map.Entry<K, V>> linkedEntries;
  
  static
  {
    JniLib.a(LinkedHashMultimap.class, 551);
  }
  
  private LinkedHashMultimap()
  {
    super(new LinkedHashMap());
    this.linkedEntries = Sets.newLinkedHashSet();
  }
  
  private LinkedHashMultimap(int paramInt1, int paramInt2)
  {
    super(new LinkedHashMap(paramInt1));
    if (paramInt2 >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.expectedValuesPerKey = paramInt2;
      this.linkedEntries = new LinkedHashSet((int)Math.min(1073741824L, paramInt1 * paramInt2));
      return;
    }
  }
  
  private LinkedHashMultimap(Multimap<? extends K, ? extends V> paramMultimap)
  {
    super(new LinkedHashMap(Maps.capacity(paramMultimap.keySet().size())));
    this.linkedEntries = new LinkedHashSet(Maps.capacity(paramMultimap.size()));
    putAll(paramMultimap);
  }
  
  public static native <K, V> LinkedHashMultimap<K, V> create();
  
  public static native <K, V> LinkedHashMultimap<K, V> create(int paramInt1, int paramInt2);
  
  public static native <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  native Collection<V> createCollection(@Nullable K paramK);
  
  native Set<V> createCollection();
  
  native Iterator<Map.Entry<K, V>> createEntryIterator();
  
  public native Set<Map.Entry<K, V>> entries();
  
  public native Set<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable);
  
  public native Collection<V> values();
  
  private class SetDecorator
    extends ForwardingSet<V>
  {
    final Set<V> delegate;
    final K key;
    
    static
    {
      JniLib.a(SetDecorator.class, 550);
    }
    
    SetDecorator(Set<V> paramSet)
    {
      Set localSet;
      this.delegate = localSet;
      this.key = paramSet;
    }
    
    public native boolean add(@Nullable V paramV);
    
    public native boolean addAll(Collection<? extends V> paramCollection);
    
    public native void clear();
    
    native <E> Collection<Map.Entry<K, E>> createEntries(Collection<E> paramCollection);
    
    native <E> Map.Entry<K, E> createEntry(@Nullable E paramE);
    
    protected native Set<V> delegate();
    
    public native Iterator<V> iterator();
    
    public native boolean remove(@Nullable Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedHashMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */