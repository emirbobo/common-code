package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class MemberKey
{
  static final Class<?>[] NO_CLASSES = new Class[0];
  final Class<?>[] _argTypes;
  final String _name;
  
  public MemberKey(String paramString, Class<?>[] paramArrayOfClass)
  {
    this._name = paramString;
    paramString = paramArrayOfClass;
    if (paramArrayOfClass == null) {
      paramString = NO_CLASSES;
    }
    this._argTypes = paramString;
  }
  
  public MemberKey(Constructor<?> paramConstructor)
  {
    this("", paramConstructor.getParameterTypes());
  }
  
  public MemberKey(Method paramMethod)
  {
    this(paramMethod.getName(), paramMethod.getParameterTypes());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramObject == this) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (paramObject == null)
      {
        bool1 = false;
      }
      else if (paramObject.getClass() != getClass())
      {
        bool1 = false;
      }
      else
      {
        paramObject = (MemberKey)paramObject;
        if (!this._name.equals(((MemberKey)paramObject)._name))
        {
          bool1 = false;
        }
        else
        {
          paramObject = ((MemberKey)paramObject)._argTypes;
          int j = this._argTypes.length;
          if (paramObject.length != j)
          {
            bool1 = false;
          }
          else
          {
            int i = 0;
            bool1 = bool2;
            if (i < j)
            {
              Class localClass1 = paramObject[i];
              Class localClass2 = this._argTypes[i];
              if (localClass1 == localClass2) {}
              while ((localClass1.isAssignableFrom(localClass2)) || (localClass2.isAssignableFrom(localClass1)))
              {
                i++;
                break;
              }
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  public int hashCode()
  {
    return this._name.hashCode() + this._argTypes.length;
  }
  
  public String toString()
  {
    return this._name + "(" + this._argTypes.length + "-args)";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\MemberKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */