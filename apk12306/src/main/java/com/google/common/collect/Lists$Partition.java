package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractList;
import java.util.List;

class Lists$Partition<T>
  extends AbstractList<List<T>>
{
  final List<T> list;
  final int size;
  
  static
  {
    JniLib.a(Partition.class, 579);
  }
  
  Lists$Partition(List<T> paramList, int paramInt)
  {
    this.list = paramList;
    this.size = paramInt;
  }
  
  public native List<T> get(int paramInt);
  
  public native boolean isEmpty();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$Partition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */