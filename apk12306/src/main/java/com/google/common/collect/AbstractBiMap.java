package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class AbstractBiMap<K, V>
  extends ForwardingMap<K, V>
  implements BiMap<K, V>, Serializable
{
  @GwtIncompatible("Not needed in emulated source.")
  private static final long serialVersionUID = 0L;
  private transient Map<K, V> delegate;
  private transient Set<Map.Entry<K, V>> entrySet;
  private transient AbstractBiMap<V, K> inverse;
  private transient Set<K> keySet;
  private transient Set<V> valueSet;
  
  private AbstractBiMap(Map<K, V> paramMap, AbstractBiMap<V, K> paramAbstractBiMap)
  {
    this.delegate = paramMap;
    this.inverse = paramAbstractBiMap;
  }
  
  AbstractBiMap(Map<K, V> paramMap, Map<V, K> paramMap1)
  {
    setDelegates(paramMap, paramMap1);
  }
  
  private V putInBothMaps(@Nullable K paramK, @Nullable V paramV, boolean paramBoolean)
  {
    boolean bool = containsKey(paramK);
    if ((bool) && (Objects.equal(paramV, get(paramK)))) {}
    Object localObject;
    for (paramK = paramV;; paramK = (K)localObject)
    {
      return paramK;
      if (!paramBoolean) {
        break;
      }
      inverse().remove(paramV);
      localObject = this.delegate.put(paramK, paramV);
      updateInverseMap(paramK, bool, localObject, paramV);
    }
    if (!containsValue(paramV)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Preconditions.checkArgument(paramBoolean, "value already present: %s", new Object[] { paramV });
      break;
    }
  }
  
  private V removeFromBothMaps(Object paramObject)
  {
    paramObject = this.delegate.remove(paramObject);
    removeFromInverseMap(paramObject);
    return (V)paramObject;
  }
  
  private void removeFromInverseMap(V paramV)
  {
    this.inverse.delegate.remove(paramV);
  }
  
  private void updateInverseMap(K paramK, boolean paramBoolean, V paramV1, V paramV2)
  {
    if (paramBoolean) {
      removeFromInverseMap(paramV1);
    }
    this.inverse.delegate.put(paramV2, paramK);
  }
  
  public void clear()
  {
    this.delegate.clear();
    this.inverse.delegate.clear();
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.inverse.containsKey(paramObject);
  }
  
  protected Map<K, V> delegate()
  {
    return this.delegate;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet = this.entrySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new EntrySet(null);
      this.entrySet = ((Set)localObject);
    }
    return (Set<Map.Entry<K, V>>)localObject;
  }
  
  public V forcePut(K paramK, V paramV)
  {
    return (V)putInBothMaps(paramK, paramV, true);
  }
  
  public BiMap<V, K> inverse()
  {
    return this.inverse;
  }
  
  public Set<K> keySet()
  {
    Set localSet = this.keySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new KeySet(null);
      this.keySet = ((Set)localObject);
    }
    return (Set<K>)localObject;
  }
  
  public V put(K paramK, V paramV)
  {
    return (V)putInBothMaps(paramK, paramV, false);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      put(paramMap.getKey(), paramMap.getValue());
    }
  }
  
  public V remove(Object paramObject)
  {
    if (containsKey(paramObject)) {}
    for (paramObject = removeFromBothMaps(paramObject);; paramObject = null) {
      return (V)paramObject;
    }
  }
  
  void setDelegates(Map<K, V> paramMap, Map<V, K> paramMap1)
  {
    boolean bool2 = true;
    if (this.delegate == null)
    {
      bool1 = true;
      Preconditions.checkState(bool1);
      if (this.inverse != null) {
        break label84;
      }
      bool1 = true;
      label25:
      Preconditions.checkState(bool1);
      Preconditions.checkArgument(paramMap.isEmpty());
      Preconditions.checkArgument(paramMap1.isEmpty());
      if (paramMap == paramMap1) {
        break label89;
      }
    }
    label84:
    label89:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      this.delegate = paramMap;
      this.inverse = new Inverse(paramMap1, this, null);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label25;
    }
  }
  
  void setInverse(AbstractBiMap<V, K> paramAbstractBiMap)
  {
    this.inverse = paramAbstractBiMap;
  }
  
  public Set<V> values()
  {
    Set localSet = this.valueSet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new ValueSet(null);
      this.valueSet = ((Set)localObject);
    }
    return (Set<V>)localObject;
  }
  
  private class EntrySet
    extends ForwardingSet<Map.Entry<K, V>>
  {
    final Set<Map.Entry<K, V>> esDelegate = AbstractBiMap.this.delegate.entrySet();
    
    static
    {
      JniLib.a(EntrySet.class, 330);
    }
    
    private EntrySet() {}
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    protected native Set<Map.Entry<K, V>> delegate();
    
    public native Iterator<Map.Entry<K, V>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
  
  private static class Inverse<K, V>
    extends AbstractBiMap<K, V>
  {
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(Inverse.class, 331);
    }
    
    private Inverse(Map<K, V> paramMap, AbstractBiMap<V, K> paramAbstractBiMap)
    {
      super(paramAbstractBiMap, null);
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private native void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException;
    
    @GwtIncompatible("java.io.ObjectOuputStream")
    private native void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException;
    
    @GwtIncompatible("Not needed in the emulated source.")
    native Object readResolve();
  }
  
  private class KeySet
    extends ForwardingSet<K>
  {
    static
    {
      JniLib.a(KeySet.class, 333);
    }
    
    private KeySet() {}
    
    public native void clear();
    
    protected native Set<K> delegate();
    
    public native Iterator<K> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
  }
  
  private class ValueSet
    extends ForwardingSet<V>
  {
    final Set<V> valuesDelegate = AbstractBiMap.this.inverse.keySet();
    
    static
    {
      JniLib.a(ValueSet.class, 335);
    }
    
    private ValueSet() {}
    
    protected native Set<V> delegate();
    
    public native Iterator<V> iterator();
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
    
    public native String toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */