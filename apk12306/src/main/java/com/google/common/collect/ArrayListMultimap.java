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
import java.util.List;

@GwtCompatible(emulated=true, serializable=true)
public final class ArrayListMultimap<K, V>
  extends AbstractListMultimap<K, V>
{
  private static final int DEFAULT_VALUES_PER_KEY = 10;
  @GwtIncompatible("Not needed in emulated source.")
  private static final long serialVersionUID = 0L;
  @VisibleForTesting
  transient int expectedValuesPerKey;
  
  static
  {
    JniLib.a(ArrayListMultimap.class, 364);
  }
  
  private ArrayListMultimap()
  {
    super(new HashMap());
    this.expectedValuesPerKey = 10;
  }
  
  private ArrayListMultimap(int paramInt1, int paramInt2)
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
  
  private ArrayListMultimap(Multimap<? extends K, ? extends V> paramMultimap) {}
  
  public static native <K, V> ArrayListMultimap<K, V> create();
  
  public static native <K, V> ArrayListMultimap<K, V> create(int paramInt1, int paramInt2);
  
  public static native <K, V> ArrayListMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap);
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  native List<V> createCollection();
  
  public native void trimToSize();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ArrayListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */