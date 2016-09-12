package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(serializable=true)
class EmptyImmutableListMultimap
  extends ImmutableListMultimap<Object, Object>
{
  static final EmptyImmutableListMultimap INSTANCE = new EmptyImmutableListMultimap();
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(EmptyImmutableListMultimap.class, 431);
  }
  
  private EmptyImmutableListMultimap()
  {
    super(ImmutableMap.of(), 0);
  }
  
  private native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\EmptyImmutableListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */