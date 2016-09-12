package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.ArrayList;
import java.util.Iterator;

public final class ImmutableList$Builder<E>
  extends ImmutableCollection.Builder<E>
{
  private final ArrayList<E> contents = Lists.newArrayList();
  
  static
  {
    JniLib.a(Builder.class, 471);
  }
  
  public native Builder<E> add(E paramE);
  
  public Builder<E> add(E... paramVarArgs)
  {
    this.contents.ensureCapacity(this.contents.size() + paramVarArgs.length);
    super.add(paramVarArgs);
    return this;
  }
  
  public native Builder<E> addAll(Iterable<? extends E> paramIterable);
  
  public native Builder<E> addAll(Iterator<? extends E> paramIterator);
  
  public native ImmutableList<E> build();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableList$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */