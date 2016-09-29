package com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;

class Constraints$ConstrainedRandomAccessList<E>
  extends Constraints.ConstrainedList<E>
  implements RandomAccess
{
  Constraints$ConstrainedRandomAccessList(List<E> paramList, Constraint<? super E> paramConstraint)
  {
    super(paramList, paramConstraint);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Constraints$ConstrainedRandomAccessList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */