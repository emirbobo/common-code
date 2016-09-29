package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

@GwtCompatible(emulated=true, serializable=true)
public class TreeMultimap<K, V>
  extends AbstractSortedSetMultimap<K, V>
{
  @GwtIncompatible("not needed in emulated source")
  private static final long serialVersionUID = 0L;
  private transient Comparator<? super K> keyComparator;
  private transient Comparator<? super V> valueComparator;
  
  static
  {
    JniLib.a(TreeMultimap.class, 809);
  }
  
  TreeMultimap(Comparator<? super K> paramComparator, Comparator<? super V> paramComparator1)
  {
    super(new TreeMap(paramComparator));
    this.keyComparator = paramComparator;
    this.valueComparator = paramComparator1;
  }
  
  private TreeMultimap(Comparator<? super K> paramComparator, Comparator<? super V> paramComparator1, Multimap<? extends K, ? extends V> paramMultimap)
  {
    this(paramComparator, paramComparator1);
    putAll(paramMultimap);
  }
  
  public static native <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create();
  
  public static native <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap);
  
  public static native <K, V> TreeMultimap<K, V> create(Comparator<? super K> paramComparator, Comparator<? super V> paramComparator1);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native SortedMap<K, Collection<V>> asMap();
  
  native SortedSet<V> createCollection();
  
  public native Comparator<? super K> keyComparator();
  
  public native SortedSet<K> keySet();
  
  public native Comparator<? super V> valueComparator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\TreeMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */