package com.google.common.collect;

import com.google.common.base.Preconditions;

 enum Constraints$NotNullConstraint
  implements Constraint<Object>
{
  INSTANCE;
  
  private Constraints$NotNullConstraint() {}
  
  public Object checkElement(Object paramObject)
  {
    return Preconditions.checkNotNull(paramObject);
  }
  
  public String toString()
  {
    return "Not null";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Constraints$NotNullConstraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */