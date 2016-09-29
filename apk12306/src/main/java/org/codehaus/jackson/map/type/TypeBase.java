package org.codehaus.jackson.map.type;

import org.codehaus.jackson.type.JavaType;

public abstract class TypeBase
  extends JavaType
{
  volatile String _canonicalName;
  
  protected TypeBase(Class<?> paramClass, int paramInt)
  {
    super(paramClass, paramInt);
  }
  
  protected static StringBuilder _classSignature(Class<?> paramClass, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if (paramClass.isPrimitive()) {
      if (paramClass == Boolean.TYPE) {
        paramStringBuilder.append('Z');
      }
    }
    for (;;)
    {
      return paramStringBuilder;
      if (paramClass == Byte.TYPE)
      {
        paramStringBuilder.append('B');
      }
      else if (paramClass == Short.TYPE)
      {
        paramStringBuilder.append('S');
      }
      else if (paramClass == Character.TYPE)
      {
        paramStringBuilder.append('C');
      }
      else if (paramClass == Integer.TYPE)
      {
        paramStringBuilder.append('I');
      }
      else if (paramClass == Long.TYPE)
      {
        paramStringBuilder.append('J');
      }
      else if (paramClass == Float.TYPE)
      {
        paramStringBuilder.append('F');
      }
      else if (paramClass == Double.TYPE)
      {
        paramStringBuilder.append('D');
      }
      else if (paramClass == Void.TYPE)
      {
        paramStringBuilder.append('V');
      }
      else
      {
        throw new IllegalStateException("Unrecognized primitive type: " + paramClass.getName());
        paramStringBuilder.append('L');
        paramClass = paramClass.getName();
        int i = 0;
        int j = paramClass.length();
        while (i < j)
        {
          char c2 = paramClass.charAt(i);
          char c1 = c2;
          if (c2 == '.')
          {
            c2 = '/';
            c1 = c2;
          }
          paramStringBuilder.append(c1);
          i++;
        }
        if (paramBoolean) {
          paramStringBuilder.append(';');
        }
      }
    }
  }
  
  protected abstract String buildCanonicalName();
  
  protected final JavaType copyHandlers(JavaType paramJavaType)
  {
    this._valueHandler = paramJavaType.getValueHandler();
    this._typeHandler = paramJavaType.getTypeHandler();
    return this;
  }
  
  public abstract StringBuilder getErasedSignature(StringBuilder paramStringBuilder);
  
  public abstract StringBuilder getGenericSignature(StringBuilder paramStringBuilder);
  
  public String toCanonical()
  {
    String str2 = this._canonicalName;
    String str1 = str2;
    if (str2 == null) {
      str1 = buildCanonicalName();
    }
    return str1;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\type\TypeBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */