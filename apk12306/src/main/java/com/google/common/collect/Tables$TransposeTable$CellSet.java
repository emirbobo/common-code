package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Set;

class Tables$TransposeTable$CellSet
  extends Collections2.TransformedCollection<Table.Cell<R, C, V>, Table.Cell<C, R, V>>
  implements Set<Table.Cell<C, R, V>>
{
  static
  {
    JniLib.a(CellSet.class, 799);
  }
  
  Tables$TransposeTable$CellSet(Tables.TransposeTable paramTransposeTable)
  {
    super(paramTransposeTable.original.cellSet(), Tables.TransposeTable.access$000());
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean equals(Object paramObject);
  
  public native int hashCode();
  
  public native boolean remove(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Tables$TransposeTable$CellSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */