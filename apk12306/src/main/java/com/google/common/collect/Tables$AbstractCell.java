package com.google.common.collect;

import com.google.common.base.Objects;

abstract class Tables$AbstractCell<R, C, V>
  implements Table.Cell<R, C, V>
{
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if ((paramObject instanceof Table.Cell))
      {
        paramObject = (Table.Cell)paramObject;
        if ((!Objects.equal(getRowKey(), ((Table.Cell)paramObject).getRowKey())) || (!Objects.equal(getColumnKey(), ((Table.Cell)paramObject).getColumnKey())) || (!Objects.equal(getValue(), ((Table.Cell)paramObject).getValue()))) {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { getRowKey(), getColumnKey(), getValue() });
  }
  
  public String toString()
  {
    return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Tables$AbstractCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */