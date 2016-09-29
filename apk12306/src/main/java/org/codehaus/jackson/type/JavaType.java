package org.codehaus.jackson.type;

import java.lang.reflect.Modifier;

public abstract class JavaType
{
  protected final Class<?> _class;
  protected final int _hashCode;
  protected Object _typeHandler;
  protected Object _valueHandler;
  
  protected JavaType(Class<?> paramClass, int paramInt)
  {
    this._class = paramClass;
    this._hashCode = (paramClass.getName().hashCode() + paramInt);
  }
  
  protected void _assertSubclass(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (!this._class.isAssignableFrom(paramClass1)) {
      throw new IllegalArgumentException("Class " + paramClass1.getName() + " is not assignable to " + this._class.getName());
    }
  }
  
  protected abstract JavaType _narrow(Class<?> paramClass);
  
  protected JavaType _widen(Class<?> paramClass)
  {
    return _narrow(paramClass);
  }
  
  public JavaType containedType(int paramInt)
  {
    return null;
  }
  
  public int containedTypeCount()
  {
    return 0;
  }
  
  public String containedTypeName(int paramInt)
  {
    return null;
  }
  
  public abstract boolean equals(Object paramObject);
  
  public final JavaType forcedNarrowBy(Class<?> paramClass)
  {
    if (paramClass == this._class) {
      paramClass = this;
    }
    for (;;)
    {
      return paramClass;
      JavaType localJavaType = _narrow(paramClass);
      if (this._valueHandler != null) {
        localJavaType.setValueHandler(this._valueHandler);
      }
      paramClass = localJavaType;
      if (this._typeHandler != null) {
        paramClass = localJavaType.withTypeHandler(this._typeHandler);
      }
    }
  }
  
  public JavaType getContentType()
  {
    return null;
  }
  
  public String getErasedSignature()
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    getErasedSignature(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public abstract StringBuilder getErasedSignature(StringBuilder paramStringBuilder);
  
  public String getGenericSignature()
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    getGenericSignature(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public abstract StringBuilder getGenericSignature(StringBuilder paramStringBuilder);
  
  public JavaType getKeyType()
  {
    return null;
  }
  
  public final Class<?> getRawClass()
  {
    return this._class;
  }
  
  public <T> T getTypeHandler()
  {
    return (T)this._typeHandler;
  }
  
  public <T> T getValueHandler()
  {
    return (T)this._valueHandler;
  }
  
  public boolean hasGenericTypes()
  {
    if (containedTypeCount() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean hasRawClass(Class<?> paramClass)
  {
    if (this._class == paramClass) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int hashCode()
  {
    return this._hashCode;
  }
  
  public boolean isAbstract()
  {
    return Modifier.isAbstract(this._class.getModifiers());
  }
  
  public boolean isArrayType()
  {
    return false;
  }
  
  public boolean isCollectionLikeType()
  {
    return false;
  }
  
  public boolean isConcrete()
  {
    boolean bool = true;
    if ((this._class.getModifiers() & 0x600) == 0) {}
    for (;;)
    {
      return bool;
      if (!this._class.isPrimitive()) {
        bool = false;
      }
    }
  }
  
  public abstract boolean isContainerType();
  
  public final boolean isEnumType()
  {
    return this._class.isEnum();
  }
  
  public final boolean isFinal()
  {
    return Modifier.isFinal(this._class.getModifiers());
  }
  
  public final boolean isInterface()
  {
    return this._class.isInterface();
  }
  
  public boolean isMapLikeType()
  {
    return false;
  }
  
  public final boolean isPrimitive()
  {
    return this._class.isPrimitive();
  }
  
  public boolean isThrowable()
  {
    return Throwable.class.isAssignableFrom(this._class);
  }
  
  public final JavaType narrowBy(Class<?> paramClass)
  {
    if (paramClass == this._class) {
      paramClass = this;
    }
    for (;;)
    {
      return paramClass;
      _assertSubclass(paramClass, this._class);
      JavaType localJavaType = _narrow(paramClass);
      if (this._valueHandler != null) {
        localJavaType.setValueHandler(this._valueHandler);
      }
      paramClass = localJavaType;
      if (this._typeHandler != null) {
        paramClass = localJavaType.withTypeHandler(this._typeHandler);
      }
    }
  }
  
  public abstract JavaType narrowContentsBy(Class<?> paramClass);
  
  @Deprecated
  public void setTypeHandler(Object paramObject)
  {
    if ((paramObject != null) && (this._typeHandler != null)) {
      throw new IllegalStateException("Trying to reset type handler for type [" + toString() + "]; old handler of type " + this._typeHandler.getClass().getName() + ", new handler of type " + paramObject.getClass().getName());
    }
    this._typeHandler = paramObject;
  }
  
  public void setValueHandler(Object paramObject)
  {
    if ((paramObject != null) && (this._valueHandler != null)) {
      throw new IllegalStateException("Trying to reset value handler for type [" + toString() + "]; old handler of type " + this._valueHandler.getClass().getName() + ", new handler of type " + paramObject.getClass().getName());
    }
    this._valueHandler = paramObject;
  }
  
  public abstract String toCanonical();
  
  public abstract String toString();
  
  public final JavaType widenBy(Class<?> paramClass)
  {
    if (paramClass == this._class) {}
    for (paramClass = this;; paramClass = _widen(paramClass))
    {
      return paramClass;
      _assertSubclass(this._class, paramClass);
    }
  }
  
  public abstract JavaType widenContentsBy(Class<?> paramClass);
  
  public abstract JavaType withContentTypeHandler(Object paramObject);
  
  public abstract JavaType withTypeHandler(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\type\JavaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */