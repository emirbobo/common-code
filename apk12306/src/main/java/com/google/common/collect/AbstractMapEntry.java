package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractMapEntry<K, V>
  implements Map.Entry<K, V>
{
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      bool1 = bool2;
      if (Objects.equal(getKey(), ((Map.Entry)paramObject).getKey()))
      {
        bool1 = bool2;
        if (Objects.equal(getValue(), ((Map.Entry)paramObject).getValue())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public abstract K getKey();
  
  public abstract V getValue();
  
  public int hashCode()
  {
    int j = 0;
    Object localObject2 = getKey();
    Object localObject1 = getValue();
    int i;
    if (localObject2 == null)
    {
      i = 0;
      if (localObject1 != null) {
        break label37;
      }
    }
    for (;;)
    {
      return j ^ i;
      i = localObject2.hashCode();
      break;
      label37:
      j = localObject1.hashCode();
    }
  }
  
  public V setValue(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return getKey() + "=" + getValue();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */