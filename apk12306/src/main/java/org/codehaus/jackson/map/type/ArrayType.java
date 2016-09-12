package org.codehaus.jackson.map.type;

import java.lang.reflect.Array;
import org.codehaus.jackson.type.JavaType;

public final class ArrayType
  extends TypeBase
{
  final JavaType _componentType;
  final Object _emptyArray;
  
  private ArrayType(JavaType paramJavaType, Object paramObject)
  {
    super(paramObject.getClass(), paramJavaType.hashCode());
    this._componentType = paramJavaType;
    this._emptyArray = paramObject;
  }
  
  public static ArrayType construct(JavaType paramJavaType)
  {
    return new ArrayType(paramJavaType, Array.newInstance(paramJavaType.getRawClass(), 0));
  }
  
  protected JavaType _narrow(Class<?> paramClass)
  {
    if (!paramClass.isArray()) {
      throw new IllegalArgumentException("Incompatible narrowing operation: trying to narrow " + toString() + " to class " + paramClass.getName());
    }
    paramClass = paramClass.getComponentType();
    return construct(TypeFactory.defaultInstance().constructType(paramClass));
  }
  
  protected String buildCanonicalName()
  {
    return this._class.getName();
  }
  
  public JavaType containedType(int paramInt)
  {
    if (paramInt == 0) {}
    for (JavaType localJavaType = this._componentType;; localJavaType = null) {
      return localJavaType;
    }
  }
  
  public int containedTypeCount()
  {
    return 1;
  }
  
  public String containedTypeName(int paramInt)
  {
    if (paramInt == 0) {}
    for (String str = "E";; str = null) {
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
          paramObject = (ArrayType)paramObject;
          bool1 = this._componentType.equals(((ArrayType)paramObject)._componentType);
        }
      }
    }
  }
  
  public JavaType getContentType()
  {
    return this._componentType;
  }
  
  public StringBuilder getErasedSignature(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append('[');
    return this._componentType.getErasedSignature(paramStringBuilder);
  }
  
  public StringBuilder getGenericSignature(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append('[');
    return this._componentType.getGenericSignature(paramStringBuilder);
  }
  
  public boolean hasGenericTypes()
  {
    return this._componentType.hasGenericTypes();
  }
  
  public boolean isAbstract()
  {
    return false;
  }
  
  public boolean isArrayType()
  {
    return true;
  }
  
  public boolean isConcrete()
  {
    return true;
  }
  
  public boolean isContainerType()
  {
    return true;
  }
  
  public JavaType narrowContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._componentType.getRawClass()) {}
    for (paramClass = this;; paramClass = construct(this._componentType.narrowBy(paramClass)).copyHandlers(this)) {
      return paramClass;
    }
  }
  
  public String toString()
  {
    return "[array type, component type: " + this._componentType + "]";
  }
  
  public JavaType widenContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._componentType.getRawClass()) {}
    for (paramClass = this;; paramClass = construct(this._componentType.widenBy(paramClass)).copyHandlers(this)) {
      return paramClass;
    }
  }
  
  public ArrayType withContentTypeHandler(Object paramObject)
  {
    return new ArrayType(this._componentType.withTypeHandler(paramObject), this._emptyArray);
  }
  
  public ArrayType withTypeHandler(Object paramObject)
  {
    ArrayType localArrayType = new ArrayType(this._componentType, this._emptyArray);
    localArrayType._typeHandler = paramObject;
    return localArrayType;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\type\ArrayType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */