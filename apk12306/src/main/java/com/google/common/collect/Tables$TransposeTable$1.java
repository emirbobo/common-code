package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;

final class Tables$TransposeTable$1
  implements Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>>
{
  static
  {
    JniLib.a(1.class, 798);
  }
  
  public native Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> paramCell);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Tables$TransposeTable$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */