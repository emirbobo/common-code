package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

class Sets$CartesianSet<B>
  extends AbstractSet<List<B>>
{
  final ImmutableList<CartesianSet<B>.Axis> axes;
  final int size;
  
  static
  {
    JniLib.a(CartesianSet.class, 722);
  }
  
  Sets$CartesianSet(List<? extends Set<? extends B>> paramList)
  {
    long l = 1L;
    ImmutableList.Builder localBuilder = ImmutableList.builder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Axis localAxis = new Axis((Set)paramList.next(), (int)l);
      localBuilder.add(localAxis);
      l *= localAxis.size();
    }
    this.axes = localBuilder.build();
    this.size = Ints.checkedCast(l);
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native UnmodifiableIterator<List<B>> iterator();
  
  public native int size();
  
  private class Axis
  {
    final ImmutableSet<? extends B> choices;
    final ImmutableList<? extends B> choicesList;
    final int dividend;
    
    static
    {
      JniLib.a(Axis.class, 721);
    }
    
    Axis(int paramInt)
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$CartesianSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */