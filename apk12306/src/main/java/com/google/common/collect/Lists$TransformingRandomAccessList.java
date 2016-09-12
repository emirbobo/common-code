package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

class Lists$TransformingRandomAccessList<F, T>
  extends AbstractList<T>
  implements RandomAccess, Serializable
{
  private static final long serialVersionUID = 0L;
  final List<F> fromList;
  final Function<? super F, ? extends T> function;
  
  static
  {
    JniLib.a(TransformingRandomAccessList.class, 584);
  }
  
  Lists$TransformingRandomAccessList(List<F> paramList, Function<? super F, ? extends T> paramFunction)
  {
    this.fromList = ((List)Preconditions.checkNotNull(paramList));
    this.function = ((Function)Preconditions.checkNotNull(paramFunction));
  }
  
  public native void clear();
  
  public native T get(int paramInt);
  
  public native boolean isEmpty();
  
  public native T remove(int paramInt);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$TransformingRandomAccessList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */