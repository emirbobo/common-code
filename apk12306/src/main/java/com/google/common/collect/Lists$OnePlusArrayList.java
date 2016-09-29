package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class Lists$OnePlusArrayList<E>
  extends AbstractList<E>
  implements Serializable, RandomAccess
{
  private static final long serialVersionUID = 0L;
  final E first;
  final E[] rest;
  
  static
  {
    JniLib.a(OnePlusArrayList.class, 578);
  }
  
  Lists$OnePlusArrayList(@Nullable E paramE, E[] paramArrayOfE)
  {
    this.first = paramE;
    this.rest = ((Object[])Preconditions.checkNotNull(paramArrayOfE));
  }
  
  public native E get(int paramInt);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$OnePlusArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */