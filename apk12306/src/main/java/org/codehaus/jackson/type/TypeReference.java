package org.codehaus.jackson.type;

import java.lang.reflect.Type;

public class TypeReference<T>
{
  private final Type genericType = ((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  
  public Type getType()
  {
    return this.genericType;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\type\TypeReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */