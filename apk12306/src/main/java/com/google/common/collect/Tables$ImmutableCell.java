package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import javax.annotation.Nullable;

class Tables$ImmutableCell<R, C, V>
  extends Tables.AbstractCell<R, C, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final C columnKey;
  final R rowKey;
  final V value;
  
  static
  {
    JniLib.a(ImmutableCell.class, 797);
  }
  
  Tables$ImmutableCell(@Nullable R paramR, @Nullable C paramC, @Nullable V paramV)
  {
    this.rowKey = paramR;
    this.columnKey = paramC;
    this.value = paramV;
  }
  
  public native C getColumnKey();
  
  public native R getRowKey();
  
  public native V getValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Tables$ImmutableCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */