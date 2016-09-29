package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

class Lists$TransformingSequentialList<F, T>
  extends AbstractSequentialList<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final List<F> fromList;
  final Function<? super F, ? extends T> function;
  
  static
  {
    JniLib.a(TransformingSequentialList.class, 586);
  }
  
  Lists$TransformingSequentialList(List<F> paramList, Function<? super F, ? extends T> paramFunction)
  {
    this.fromList = ((List)Preconditions.checkNotNull(paramList));
    this.function = ((Function)Preconditions.checkNotNull(paramFunction));
  }
  
  public native void clear();
  
  public native ListIterator<T> listIterator(int paramInt);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$TransformingSequentialList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */