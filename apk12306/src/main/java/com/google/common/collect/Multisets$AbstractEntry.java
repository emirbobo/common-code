package com.google.common.collect;

import com.google.common.base.Objects;
import javax.annotation.Nullable;

abstract class Multisets$AbstractEntry<E>
  implements Multiset.Entry<E>
{
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Multiset.Entry))
    {
      paramObject = (Multiset.Entry)paramObject;
      bool1 = bool2;
      if (getCount() == ((Multiset.Entry)paramObject).getCount())
      {
        bool1 = bool2;
        if (Objects.equal(getElement(), ((Multiset.Entry)paramObject).getElement())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    Object localObject = getElement();
    if (localObject == null) {}
    for (int i = 0;; i = localObject.hashCode()) {
      return i ^ getCount();
    }
  }
  
  public String toString()
  {
    String str = String.valueOf(getElement());
    int i = getCount();
    if (i == 1) {}
    for (;;)
    {
      return str;
      str = str + " x " + i;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$AbstractEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */