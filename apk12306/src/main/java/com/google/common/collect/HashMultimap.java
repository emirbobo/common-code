package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

@GwtCompatible(emulated=true, serializable=true)
public final class HashMultimap<K, V>
  extends AbstractSetMultimap<K, V>
{
  private static final int DEFAULT_VALUES_PER_KEY = 8;
  @GwtIncompatible("Not needed in emulated source")
  private static final long serialVersionUID = 0L;
  @VisibleForTesting
  transient int expectedValuesPerKey = 8;
  
  static
  {
    JniLib.a(HashMultimap.class, 452);
  }
  
  private HashMultimap()
  {
    super(new HashMap());
  }
  
  private HashMultimap(int paramInt1, int paramInt2)
  {
    super(Maps.newHashMapWithExpectedSize(paramInt1));
    if (paramInt2 >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.expectedValuesPerKey = paramInt2;
      return;
    }
  }
  
  private HashMultimap(Multimap<? extends K, ? extends V> paramMultimap)
  {
    super(Maps.newHashMapWithExpectedSize(paramMultimap.keySet().size()));
    putAll(paramMultimap);
  }
  
  public static native <K, V> HashMultimap<K, V> create();
  
  public static native <K, V> HashMultimap<K, V> create(int paramInt1, int paramInt2);
  
  public static native <K, V> HashMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  native Set<V> createCollection();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\HashMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */