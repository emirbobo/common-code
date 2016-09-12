package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(serializable=true)
final class EmptyImmutableMultiset
  extends ImmutableMultiset<Object>
{
  static final EmptyImmutableMultiset INSTANCE = new EmptyImmutableMultiset();
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(EmptyImmutableMultiset.class, 434);
  }
  
  private EmptyImmutableMultiset()
  {
    super(ImmutableMap.of(), 0);
  }
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\EmptyImmutableMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */