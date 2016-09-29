package org.codehaus.jackson.map.type;

import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.type.JavaType;

public final class SimpleType
  extends TypeBase
{
  protected final String[] _typeNames;
  protected final JavaType[] _typeParameters;
  
  protected SimpleType(Class<?> paramClass)
  {
    this(paramClass, null, null);
  }
  
  protected SimpleType(Class<?> paramClass, String[] paramArrayOfString, JavaType[] paramArrayOfJavaType)
  {
    super(paramClass, 0);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      this._typeNames = null;
    }
    for (this._typeParameters = null;; this._typeParameters = paramArrayOfJavaType)
    {
      return;
      this._typeNames = paramArrayOfString;
    }
  }
  
  public static SimpleType construct(Class<?> paramClass)
  {
    if (Map.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("Can not construct SimpleType for a Map (class: " + paramClass.getName() + ")");
    }
    if (Collection.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("Can not construct SimpleType for a Collection (class: " + paramClass.getName() + ")");
    }
    if (paramClass.isArray()) {
      throw new IllegalArgumentException("Can not construct SimpleType for an array (class: " + paramClass.getName() + ")");
    }
    return new SimpleType(paramClass);
  }
  
  public static SimpleType constructUnsafe(Class<?> paramClass)
  {
    return new SimpleType(paramClass, null, null);
  }
  
  protected JavaType _narrow(Class<?> paramClass)
  {
    return new SimpleType(paramClass, this._typeNames, this._typeParameters);
  }
  
  protected String buildCanonicalName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this._class.getName());
    if ((this._typeParameters != null) && (this._typeParameters.length > 0))
    {
      localStringBuilder.append('<');
      int j = 1;
      JavaType[] arrayOfJavaType = this._typeParameters;
      int k = arrayOfJavaType.length;
      int i = 0;
      if (i < k)
      {
        JavaType localJavaType = arrayOfJavaType[i];
        if (j != 0) {
          j = 0;
        }
        for (;;)
        {
          localStringBuilder.append(localJavaType.toCanonical());
          i++;
          break;
          localStringBuilder.append(',');
        }
      }
      localStringBuilder.append('>');
    }
    return localStringBuilder.toString();
  }
  
  public JavaType containedType(int paramInt)
  {
    if ((paramInt < 0) || (this._typeParameters == null) || (paramInt >= this._typeParameters.length)) {}
    for (JavaType localJavaType = null;; localJavaType = this._typeParameters[paramInt]) {
      return localJavaType;
    }
  }
  
  public int containedTypeCount()
  {
    if (this._typeParameters == null) {}
    for (int i = 0;; i = this._typeParameters.length) {
      return i;
    }
  }
  
  public String containedTypeName(int paramInt)
  {
    if ((paramInt < 0) || (this._typeNames == null) || (paramInt >= this._typeNames.length)) {}
    for (String str = null;; str = this._typeNames[paramInt]) {
      return str;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.getClass() == getClass())
        {
          Object localObject = (SimpleType)paramObject;
          bool1 = bool2;
          if (((SimpleType)localObject)._class == this._class)
          {
            paramObject = this._typeParameters;
            localObject = ((SimpleType)localObject)._typeParameters;
            if (paramObject == null)
            {
              if (localObject != null)
              {
                bool1 = bool2;
                if (localObject.length != 0) {}
              }
              else
              {
                bool1 = true;
              }
            }
            else
            {
              bool1 = bool2;
              if (localObject != null)
              {
                bool1 = bool2;
                if (paramObject.length == localObject.length)
                {
                  int i = 0;
                  int j = paramObject.length;
                  for (;;)
                  {
                    if (i >= j) {
                      break label150;
                    }
                    bool1 = bool2;
                    if (!paramObject[i].equals(localObject[i])) {
                      break;
                    }
                    i++;
                  }
                  label150:
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public StringBuilder getErasedSignature(StringBuilder paramStringBuilder)
  {
    return _classSignature(this._class, paramStringBuilder, true);
  }
  
  public StringBuilder getGenericSignature(StringBuilder paramStringBuilder)
  {
    _classSignature(this._class, paramStringBuilder, false);
    Object localObject = paramStringBuilder;
    if (this._typeParameters != null)
    {
      paramStringBuilder.append('<');
      localObject = this._typeParameters;
      int j = localObject.length;
      for (int i = 0; i < j; i++) {
        paramStringBuilder = localObject[i].getGenericSignature(paramStringBuilder);
      }
      paramStringBuilder.append('>');
      localObject = paramStringBuilder;
    }
    ((StringBuilder)localObject).append(';');
    return (StringBuilder)localObject;
  }
  
  public boolean isContainerType()
  {
    return false;
  }
  
  public JavaType narrowContentsBy(Class<?> paramClass)
  {
    throw new IllegalArgumentException("Internal error: SimpleType.narrowContentsBy() should never be called");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    localStringBuilder.append("[simple type, class ").append(buildCanonicalName()).append(']');
    return localStringBuilder.toString();
  }
  
  public JavaType widenContentsBy(Class<?> paramClass)
  {
    throw new IllegalArgumentException("Internal error: SimpleType.widenContentsBy() should never be called");
  }
  
  public JavaType withContentTypeHandler(Object paramObject)
  {
    throw new IllegalArgumentException("Simple types have no content types; can not call withContenTypeHandler()");
  }
  
  public SimpleType withTypeHandler(Object paramObject)
  {
    SimpleType localSimpleType = new SimpleType(this._class, this._typeNames, this._typeParameters);
    localSimpleType._typeHandler = paramObject;
    return localSimpleType;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\type\SimpleType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */