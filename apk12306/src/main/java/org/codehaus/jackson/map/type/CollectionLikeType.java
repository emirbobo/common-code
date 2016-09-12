package org.codehaus.jackson.map.type;

import java.util.Collection;
import org.codehaus.jackson.type.JavaType;

public class CollectionLikeType
  extends TypeBase
{
  protected final JavaType _elementType;
  
  protected CollectionLikeType(Class<?> paramClass, JavaType paramJavaType)
  {
    super(paramClass, paramJavaType.hashCode());
    this._elementType = paramJavaType;
  }
  
  public static CollectionLikeType construct(Class<?> paramClass, JavaType paramJavaType)
  {
    return new CollectionLikeType(paramClass, paramJavaType);
  }
  
  protected JavaType _narrow(Class<?> paramClass)
  {
    return new CollectionLikeType(paramClass, this._elementType);
  }
  
  protected String buildCanonicalName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this._class.getName());
    if (this._elementType != null)
    {
      localStringBuilder.append('<');
      localStringBuilder.append(this._elementType.toCanonical());
      localStringBuilder.append('>');
    }
    return localStringBuilder.toString();
  }
  
  public JavaType containedType(int paramInt)
  {
    if (paramInt == 0) {}
    for (JavaType localJavaType = this._elementType;; localJavaType = null) {
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
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if (paramObject == null)
      {
        bool = false;
      }
      else if (paramObject.getClass() != getClass())
      {
        bool = false;
      }
      else
      {
        paramObject = (CollectionLikeType)paramObject;
        if ((this._class != ((CollectionLikeType)paramObject)._class) || (!this._elementType.equals(((CollectionLikeType)paramObject)._elementType))) {
          bool = false;
        }
      }
    }
  }
  
  public JavaType getContentType()
  {
    return this._elementType;
  }
  
  public StringBuilder getErasedSignature(StringBuilder paramStringBuilder)
  {
    return _classSignature(this._class, paramStringBuilder, true);
  }
  
  public StringBuilder getGenericSignature(StringBuilder paramStringBuilder)
  {
    _classSignature(this._class, paramStringBuilder, false);
    paramStringBuilder.append('<');
    this._elementType.getGenericSignature(paramStringBuilder);
    paramStringBuilder.append(">;");
    return paramStringBuilder;
  }
  
  public boolean isCollectionLikeType()
  {
    return true;
  }
  
  public boolean isContainerType()
  {
    return true;
  }
  
  public boolean isTrueCollectionType()
  {
    return Collection.class.isAssignableFrom(this._class);
  }
  
  public JavaType narrowContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._elementType.getRawClass()) {}
    for (paramClass = this;; paramClass = new CollectionLikeType(this._class, this._elementType.narrowBy(paramClass)).copyHandlers(this)) {
      return paramClass;
    }
  }
  
  public String toString()
  {
    return "[collection-like type; class " + this._class.getName() + ", contains " + this._elementType + "]";
  }
  
  public JavaType widenContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._elementType.getRawClass()) {}
    for (paramClass = this;; paramClass = new CollectionLikeType(this._class, this._elementType.widenBy(paramClass)).copyHandlers(this)) {
      return paramClass;
    }
  }
  
  public CollectionLikeType withContentTypeHandler(Object paramObject)
  {
    return new CollectionLikeType(this._class, this._elementType.withTypeHandler(paramObject));
  }
  
  public CollectionLikeType withTypeHandler(Object paramObject)
  {
    CollectionLikeType localCollectionLikeType = new CollectionLikeType(this._class, this._elementType);
    localCollectionLikeType._typeHandler = paramObject;
    return localCollectionLikeType;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\type\CollectionLikeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */