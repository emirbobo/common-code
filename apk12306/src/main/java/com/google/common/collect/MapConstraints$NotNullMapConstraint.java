package com.google.common.collect;

import com.google.common.base.Preconditions;

 enum MapConstraints$NotNullMapConstraint
  implements MapConstraint<Object, Object>
{
  INSTANCE;
  
  private MapConstraints$NotNullMapConstraint() {}
  
  public void checkKeyValue(Object paramObject1, Object paramObject2)
  {
    Preconditions.checkNotNull(paramObject1);
    Preconditions.checkNotNull(paramObject2);
  }
  
  public String toString()
  {
    return "Not null";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$NotNullMapConstraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */