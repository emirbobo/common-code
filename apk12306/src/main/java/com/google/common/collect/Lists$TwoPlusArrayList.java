package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class Lists$TwoPlusArrayList<E>
  extends AbstractList<E>
  implements Serializable, RandomAccess
{
  private static final long serialVersionUID = 0L;
  final E first;
  final E[] rest;
  final E second;
  
  static
  {
    JniLib.a(TwoPlusArrayList.class, 587);
  }
  
  Lists$TwoPlusArrayList(@Nullable E paramE1, @Nullable E paramE2, E[] paramArrayOfE)
  {
    this.first = paramE1;
    this.second = paramE2;
    this.rest = ((Object[])Preconditions.checkNotNull(paramArrayOfE));
  }
  
  public native E get(int paramInt);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$TwoPlusArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */