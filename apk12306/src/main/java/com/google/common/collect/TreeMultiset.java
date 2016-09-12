package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class TreeMultiset<E>
  extends AbstractMapBasedMultiset<E>
{
  @GwtIncompatible("not needed in emulated source")
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(TreeMultiset.class, 811);
  }
  
  private TreeMultiset()
  {
    super(new TreeMap());
  }
  
  private TreeMultiset(Comparator<? super E> paramComparator)
  {
    super(new TreeMap(paramComparator));
  }
  
  public static native <E extends Comparable> TreeMultiset<E> create();
  
  public static native <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> paramIterable);
  
  public static native <E> TreeMultiset<E> create(Comparator<? super E> paramComparator);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native int count(@Nullable Object paramObject);
  
  native Set<E> createElementSet();
  
  public native SortedSet<E> elementSet();
  
  private class SortedMapBasedElementSet
    extends AbstractMapBasedMultiset<E>.MapBasedElementSet
    implements SortedSet<E>
  {
    static
    {
      JniLib.a(SortedMapBasedElementSet.class, 810);
    }
    
    SortedMapBasedElementSet()
    {
      super(localMap);
    }
    
    public native Comparator<? super E> comparator();
    
    public native E first();
    
    public native SortedSet<E> headSet(E paramE);
    
    public native E last();
    
    public native boolean remove(Object paramObject);
    
    native SortedMap<E, AtomicInteger> sortedMap();
    
    public native SortedSet<E> subSet(E paramE1, E paramE2);
    
    public native SortedSet<E> tailSet(E paramE);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\TreeMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */