package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSequentialList;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public final class LinkedListMultimap<K, V>
  implements ListMultimap<K, V>, Serializable
{
  @GwtIncompatible("java serialization not supported")
  private static final long serialVersionUID = 0L;
  private transient Collection<Map.Entry<K, V>> entries;
  private transient Node<K, V> head;
  private transient Multiset<K> keyCount;
  private transient Set<K> keySet;
  private transient Map<K, Node<K, V>> keyToKeyHead;
  private transient Map<K, Node<K, V>> keyToKeyTail;
  private transient Multiset<K> keys;
  private transient Map<K, Collection<V>> map;
  private transient Node<K, V> tail;
  private transient Collection<V> valuesCollection;
  
  static
  {
    JniLib.a(LinkedListMultimap.class, 573);
  }
  
  private LinkedListMultimap()
  {
    this.keyCount = LinkedHashMultiset.create();
    this.keyToKeyHead = Maps.newHashMap();
    this.keyToKeyTail = Maps.newHashMap();
  }
  
  private LinkedListMultimap(int paramInt)
  {
    this.keyCount = LinkedHashMultiset.create(paramInt);
    this.keyToKeyHead = Maps.newHashMapWithExpectedSize(paramInt);
    this.keyToKeyTail = Maps.newHashMapWithExpectedSize(paramInt);
  }
  
  private LinkedListMultimap(Multimap<? extends K, ? extends V> paramMultimap)
  {
    this(paramMultimap.keySet().size());
    putAll(paramMultimap);
  }
  
  private native Node<K, V> addNode(@Nullable K paramK, @Nullable V paramV, @Nullable Node<K, V> paramNode);
  
  private static native void checkElement(@Nullable Object paramObject);
  
  public static native <K, V> LinkedListMultimap<K, V> create();
  
  public static native <K, V> LinkedListMultimap<K, V> create(int paramInt);
  
  public static native <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap);
  
  private native List<V> getCopy(@Nullable Object paramObject);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  private native void removeAllNodes(@Nullable Object paramObject);
  
  private native void removeNode(Node<K, V> paramNode);
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native Map<K, Collection<V>> asMap();
  
  public native void clear();
  
  public native boolean containsEntry(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public native boolean containsKey(@Nullable Object paramObject);
  
  public native boolean containsValue(@Nullable Object paramObject);
  
  public native Collection<Map.Entry<K, V>> entries();
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native List<V> get(@Nullable K paramK);
  
  public native int hashCode();
  
  public native boolean isEmpty();
  
  public native Set<K> keySet();
  
  public native Multiset<K> keys();
  
  public native boolean put(@Nullable K paramK, @Nullable V paramV);
  
  public native boolean putAll(Multimap<? extends K, ? extends V> paramMultimap);
  
  public native boolean putAll(@Nullable K paramK, Iterable<? extends V> paramIterable);
  
  public native boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public native List<V> removeAll(@Nullable Object paramObject);
  
  public native List<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable);
  
  public native int size();
  
  public native String toString();
  
  public native Collection<V> values();
  
  private class AsMapEntries
    extends AbstractSet<Map.Entry<K, Collection<V>>>
  {
    static
    {
      JniLib.a(AsMapEntries.class, 563);
    }
    
    private AsMapEntries() {}
    
    public native Iterator<Map.Entry<K, Collection<V>>> iterator();
    
    public native int size();
  }
  
  private class DistinctKeyIterator
    implements Iterator<K>
  {
    LinkedListMultimap.Node<K, V> current;
    LinkedListMultimap.Node<K, V> next = LinkedListMultimap.this.head;
    final Set<K> seenKeys = new HashSet(Maps.capacity(LinkedListMultimap.this.keySet().size()));
    
    static
    {
      JniLib.a(DistinctKeyIterator.class, 564);
    }
    
    private DistinctKeyIterator() {}
    
    public native boolean hasNext();
    
    public native K next();
    
    public native void remove();
  }
  
  private class MultisetView
    extends AbstractCollection<K>
    implements Multiset<K>
  {
    static
    {
      JniLib.a(MultisetView.class, 569);
    }
    
    private MultisetView() {}
    
    public native int add(@Nullable K paramK, int paramInt);
    
    public native int count(@Nullable Object paramObject);
    
    public native Set<K> elementSet();
    
    public native Set<Multiset.Entry<K>> entrySet();
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native int hashCode();
    
    public native Iterator<K> iterator();
    
    public native int remove(@Nullable Object paramObject, int paramInt);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int setCount(K paramK, int paramInt);
    
    public native boolean setCount(K paramK, int paramInt1, int paramInt2);
    
    public native int size();
    
    public native String toString();
  }
  
  private static final class Node<K, V>
  {
    final K key;
    Node<K, V> next;
    Node<K, V> nextSibling;
    Node<K, V> previous;
    Node<K, V> previousSibling;
    V value;
    
    static
    {
      JniLib.a(Node.class, 570);
    }
    
    Node(@Nullable K paramK, @Nullable V paramV)
    {
      this.key = paramK;
      this.value = paramV;
    }
    
    public native String toString();
  }
  
  private class NodeIterator
    implements Iterator<LinkedListMultimap.Node<K, V>>
  {
    LinkedListMultimap.Node<K, V> current;
    LinkedListMultimap.Node<K, V> next = LinkedListMultimap.this.head;
    
    static
    {
      JniLib.a(NodeIterator.class, 571);
    }
    
    private NodeIterator() {}
    
    public native boolean hasNext();
    
    public native LinkedListMultimap.Node<K, V> next();
    
    public native void remove();
  }
  
  private class ValueForKeyIterator
    implements ListIterator<V>
  {
    LinkedListMultimap.Node<K, V> current;
    final Object key;
    LinkedListMultimap.Node<K, V> next;
    int nextIndex;
    LinkedListMultimap.Node<K, V> previous;
    
    static
    {
      JniLib.a(ValueForKeyIterator.class, 572);
    }
    
    ValueForKeyIterator(Object paramObject)
    {
      this.key = paramObject;
      this.next = ((LinkedListMultimap.Node)LinkedListMultimap.this.keyToKeyHead.get(paramObject));
    }
    
    public ValueForKeyIterator(Object paramObject, int paramInt)
    {
      int i = LinkedListMultimap.this.keyCount.count(paramObject);
      Preconditions.checkPositionIndex(paramInt, i);
      if (paramInt >= i / 2)
      {
        this.previous = ((LinkedListMultimap.Node)LinkedListMultimap.this.keyToKeyTail.get(paramObject));
        this.nextIndex = i;
        while (paramInt < i)
        {
          previous();
          paramInt++;
        }
      }
      this.next = ((LinkedListMultimap.Node)LinkedListMultimap.this.keyToKeyHead.get(paramObject));
      while (paramInt > 0)
      {
        next();
        paramInt--;
      }
      this.key = paramObject;
      this.current = null;
    }
    
    public native void add(V paramV);
    
    public native boolean hasNext();
    
    public native boolean hasPrevious();
    
    public native V next();
    
    public native int nextIndex();
    
    public native V previous();
    
    public native int previousIndex();
    
    public native void remove();
    
    public native void set(V paramV);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */