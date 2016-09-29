package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Set;

class Sets$CartesianSet$Axis
{
  final ImmutableSet<? extends B> choices;
  final ImmutableList<? extends B> choicesList;
  final int dividend;
  
  static
  {
    JniLib.a(Axis.class, 721);
  }
  
  Sets$CartesianSet$Axis(Set<? extends B> paramSet, int paramInt)
  {
    this.choices = ImmutableSet.copyOf(paramInt);
    this.choicesList = this.choices.asList();
    int i;
    this.dividend = i;
  }
  
  native boolean contains(Object paramObject);
  
  public native boolean equals(Object paramObject);
  
  native B getForIndex(int paramInt);
  
  public native int hashCode();
  
  native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$CartesianSet$Axis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */