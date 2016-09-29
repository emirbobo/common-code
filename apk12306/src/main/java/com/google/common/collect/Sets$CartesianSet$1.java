package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.List;

class Sets$CartesianSet$1
  extends UnmodifiableIterator<List<B>>
{
  int index;
  
  static
  {
    JniLib.a(1.class, 720);
  }
  
  Sets$CartesianSet$1(Sets.CartesianSet paramCartesianSet) {}
  
  public native boolean hasNext();
  
  public native List<B> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$CartesianSet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */