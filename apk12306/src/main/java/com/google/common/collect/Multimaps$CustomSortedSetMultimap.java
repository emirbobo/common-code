package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;

class Multimaps$CustomSortedSetMultimap<K, V>
  extends AbstractSortedSetMultimap<K, V>
{
  @GwtIncompatible("not needed in emulated source")
  private static final long serialVersionUID = 0L;
  transient Supplier<? extends SortedSet<V>> factory;
  transient Comparator<? super V> valueComparator;
  
  static
  {
    JniLib.a(CustomSortedSetMultimap.class, 653);
  }
  
  Multimaps$CustomSortedSetMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends SortedSet<V>> paramSupplier)
  {
    super(paramMap);
    this.factory = ((Supplier)Preconditions.checkNotNull(paramSupplier));
    this.valueComparator = ((SortedSet)paramSupplier.get()).comparator();
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  protected native SortedSet<V> createCollection();
  
  public native Comparator<? super V> valueComparator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$CustomSortedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */