package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible
abstract class Maps$ImprovedAbstractMap<K, V>
  extends AbstractMap<K, V>
{
  private Set<Map.Entry<K, V>> entrySet;
  private Set<K> keySet;
  private Collection<V> values;
  
  protected abstract Set<Map.Entry<K, V>> createEntrySet();
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet2 = this.entrySet;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = createEntrySet();
      this.entrySet = localSet1;
    }
    return localSet1;
  }
  
  public boolean isEmpty()
  {
    return entrySet().isEmpty();
  }
  
  public Set<K> keySet()
  {
    Set localSet = this.keySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new ForwardingSet()
      {
        static
        {
          JniLib.a(1.class, 630);
        }
        
        protected native Set<K> delegate();
        
        public native boolean isEmpty();
        
        public native boolean remove(Object paramAnonymousObject);
      };
      this.keySet = ((Set)localObject);
    }
    return (Set<K>)localObject;
  }
  
  public Collection<V> values()
  {
    Collection localCollection = this.values;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new ForwardingCollection()
      {
        static
        {
          JniLib.a(2.class, 631);
        }
        
        protected native Collection<V> delegate();
        
        public native boolean isEmpty();
      };
      this.values = ((Collection)localObject);
    }
    return (Collection<V>)localObject;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$ImprovedAbstractMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */