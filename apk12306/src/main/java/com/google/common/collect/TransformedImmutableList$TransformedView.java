package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class TransformedImmutableList$TransformedView
  extends TransformedImmutableList<D, E>
{
  static
  {
    JniLib.a(TransformedView.class, 803);
  }
  
  TransformedImmutableList$TransformedView(ImmutableList<D> paramImmutableList)
  {
    super(localImmutableList);
  }
  
  native E transform(D paramD);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\TransformedImmutableList$TransformedView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */