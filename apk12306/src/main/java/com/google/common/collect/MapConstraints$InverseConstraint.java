package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;

class MapConstraints$InverseConstraint<K, V>
  implements MapConstraint<K, V>
{
  final MapConstraint<? super V, ? super K> constraint;
  
  static
  {
    JniLib.a(InverseConstraint.class, 607);
  }
  
  public MapConstraints$InverseConstraint(MapConstraint<? super V, ? super K> paramMapConstraint)
  {
    this.constraint = ((MapConstraint)Preconditions.checkNotNull(paramMapConstraint));
  }
  
  public native void checkKeyValue(K paramK, V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$InverseConstraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */