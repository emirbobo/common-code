package org.codehaus.jackson.map.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class HierarchicType
{
  protected final Type _actualType;
  protected final ParameterizedType _genericType;
  protected final Class<?> _rawClass;
  protected HierarchicType _subType;
  protected HierarchicType _superType;
  
  public HierarchicType(Type paramType)
  {
    this._actualType = paramType;
    if ((paramType instanceof Class))
    {
      this._rawClass = ((Class)paramType);
      this._genericType = null;
    }
    for (;;)
    {
      return;
      if (!(paramType instanceof ParameterizedType)) {
        break;
      }
      this._genericType = ((ParameterizedType)paramType);
      this._rawClass = ((Class)this._genericType.getRawType());
    }
    throw new IllegalArgumentException("Type " + paramType.getClass().getName() + " can not be used to construct HierarchicType");
  }
  
  public ParameterizedType asGeneric()
  {
    return this._genericType;
  }
  
  public Class<?> getRawClass()
  {
    return this._rawClass;
  }
  
  public HierarchicType getSubType()
  {
    return this._subType;
  }
  
  public HierarchicType getSuperType()
  {
    return this._superType;
  }
  
  public boolean isGeneric()
  {
    if (this._genericType != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void setSubType(HierarchicType paramHierarchicType)
  {
    this._subType = paramHierarchicType;
  }
  
  public void setSuperType(HierarchicType paramHierarchicType)
  {
    this._superType = paramHierarchicType;
  }
  
  public String toString()
  {
    if (this._genericType != null) {}
    for (String str = this._genericType.toString();; str = this._rawClass.getName()) {
      return str;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\type\HierarchicType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */