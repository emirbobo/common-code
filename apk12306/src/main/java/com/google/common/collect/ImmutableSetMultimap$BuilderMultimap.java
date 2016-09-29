package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.LinkedHashMap;

class ImmutableSetMultimap$BuilderMultimap<K, V>
  extends AbstractMultimap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(BuilderMultimap.class, 491);
  }
  
  ImmutableSetMultimap$BuilderMultimap()
  {
    super(new LinkedHashMap());
  }
  
  native Collection<V> createCollection();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSetMultimap$BuilderMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */