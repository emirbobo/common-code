package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;

class ImmutableMap$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final Object[] keys;
  private final Object[] values;
  
  static
  {
    JniLib.a(SerializedForm.class, 461);
  }
  
  ImmutableMap$SerializedForm(ImmutableMap<?, ?> paramImmutableMap)
  {
    this.keys = new Object[paramImmutableMap.size()];
    this.values = new Object[paramImmutableMap.size()];
    int i = 0;
    paramImmutableMap = paramImmutableMap.entrySet().iterator();
    while (paramImmutableMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramImmutableMap.next();
      this.keys[i] = localEntry.getKey();
      this.values[i] = localEntry.getValue();
      i++;
    }
  }
  
  native Object createMap(ImmutableMap.Builder<Object, Object> paramBuilder);
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMap$SerializedForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */