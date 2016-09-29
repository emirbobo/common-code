package org.codehaus.jackson.map.type;

import org.codehaus.jackson.type.JavaType;

public final class CollectionType
  extends CollectionLikeType
{
  private CollectionType(Class<?> paramClass, JavaType paramJavaType)
  {
    super(paramClass, paramJavaType);
  }
  
  public static CollectionType construct(Class<?> paramClass, JavaType paramJavaType)
  {
    return new CollectionType(paramClass, paramJavaType);
  }
  
  protected JavaType _narrow(Class<?> paramClass)
  {
    return new CollectionType(paramClass, this._elementType);
  }
  
  public JavaType narrowContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._elementType.getRawClass()) {}
    for (paramClass = this;; paramClass = new CollectionType(this._class, this._elementType.narrowBy(paramClass)).copyHandlers(this)) {
      return paramClass;
    }
  }
  
  public String toString()
  {
    return "[collection type; class " + this._class.getName() + ", contains " + this._elementType + "]";
  }
  
  public JavaType widenContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._elementType.getRawClass()) {}
    for (paramClass = this;; paramClass = new CollectionType(this._class, this._elementType.widenBy(paramClass)).copyHandlers(this)) {
      return paramClass;
    }
  }
  
  public CollectionType withContentTypeHandler(Object paramObject)
  {
    return new CollectionType(this._class, this._elementType.withTypeHandler(paramObject));
  }
  
  public CollectionType withTypeHandler(Object paramObject)
  {
    CollectionType localCollectionType = new CollectionType(this._class, this._elementType);
    localCollectionType._typeHandler = paramObject;
    return localCollectionType;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\type\CollectionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */