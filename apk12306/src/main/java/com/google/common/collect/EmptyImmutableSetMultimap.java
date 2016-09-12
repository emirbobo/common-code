package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(serializable=true)
class EmptyImmutableSetMultimap
  extends ImmutableSetMultimap<Object, Object>
{
  static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(EmptyImmutableSetMultimap.class, 437);
  }
  
  private EmptyImmutableSetMultimap()
  {
    super(ImmutableMap.of(), 0, null);
  }
  
  private native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\EmptyImmutableSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */