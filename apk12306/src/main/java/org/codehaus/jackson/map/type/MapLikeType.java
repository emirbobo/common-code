package org.codehaus.jackson.map.type;

import java.util.Map;
import org.codehaus.jackson.type.JavaType;

public class MapLikeType
  extends TypeBase
{
  protected final JavaType _keyType;
  protected final JavaType _valueType;
  
  protected MapLikeType(Class<?> paramClass, JavaType paramJavaType1, JavaType paramJavaType2)
  {
    super(paramClass, paramJavaType1.hashCode() ^ paramJavaType2.hashCode());
    this._keyType = paramJavaType1;
    this._valueType = paramJavaType2;
  }
  
  public static MapLikeType construct(Class<?> paramClass, JavaType paramJavaType1, JavaType paramJavaType2)
  {
    return new MapLikeType(paramClass, paramJavaType1, paramJavaType2);
  }
  
  protected JavaType _narrow(Class<?> paramClass)
  {
    return new MapLikeType(paramClass, this._keyType, this._valueType);
  }
  
  protected String buildCanonicalName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this._class.getName());
    if (this._keyType != null)
    {
      localStringBuilder.append('<');
      localStringBuilder.append(this._keyType.toCanonical());
      localStringBuilder.append(',');
      localStringBuilder.append(this._valueType.toCanonical());
      localStringBuilder.append('>');
    }
    return localStringBuilder.toString();
  }
  
  public JavaType containedType(int paramInt)
  {
    JavaType localJavaType;
    if (paramInt == 0) {
      localJavaType = this._keyType;
    }
    for (;;)
    {
      return localJavaType;
      if (paramInt == 1) {
        localJavaType = this._valueType;
      } else {
        localJavaType = null;
      }
    }
  }
  
  public int containedTypeCount()
  {
    return 2;
  }
  
  public String containedTypeName(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      str = "K";
    }
    for (;;)
    {
      return str;
      if (paramInt == 1) {
        str = "V";
      } else {
        str = null;
      }
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
        paramObject = (MapLikeType)paramObject;
        if ((this._class != ((MapLikeType)paramObject)._class) || (!this._keyType.equals(((MapLikeType)paramObject)._keyType)) || (!this._valueType.equals(((MapLikeType)paramObject)._valueType))) {
          bool = false;
        }
      }
    }
  }
  
  public JavaType getContentType()
  {
    return this._valueType;
  }
  
  public StringBuilder getErasedSignature(StringBuilder paramStringBuilder)
  {
    return _classSignature(this._class, paramStringBuilder, true);
  }
  
  public StringBuilder getGenericSignature(StringBuilder paramStringBuilder)
  {
    _classSignature(this._class, paramStringBuilder, false);
    paramStringBuilder.append('<');
    this._keyType.getGenericSignature(paramStringBuilder);
    this._valueType.getGenericSignature(paramStringBuilder);
    paramStringBuilder.append(">;");
    return paramStringBuilder;
  }
  
  public JavaType getKeyType()
  {
    return this._keyType;
  }
  
  public boolean isContainerType()
  {
    return true;
  }
  
  public boolean isMapLikeType()
  {
    return true;
  }
  
  public boolean isTrueMapType()
  {
    return Map.class.isAssignableFrom(this._class);
  }
  
  public JavaType narrowContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._valueType.getRawClass()) {}
    for (paramClass = this;; paramClass = new MapLikeType(this._class, this._keyType, this._valueType.narrowBy(paramClass)).copyHandlers(this)) {
      return paramClass;
    }
  }
  
  public JavaType narrowKey(Class<?> paramClass)
  {
    if (paramClass == this._keyType.getRawClass()) {}
    for (paramClass = this;; paramClass = new MapLikeType(this._class, this._keyType.narrowBy(paramClass), this._valueType).copyHandlers(this)) {
      return paramClass;
    }
  }
  
  public String toString()
  {
    return "[map-like type; class " + this._class.getName() + ", " + this._keyType + " -> " + this._valueType + "]";
  }
  
  public JavaType widenContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._valueType.getRawClass()) {}
    for (paramClass = this;; paramClass = new MapLikeType(this._class, this._keyType, this._valueType.widenBy(paramClass)).copyHandlers(this)) {
      return paramClass;
    }
  }
  
  public JavaType widenKey(Class<?> paramClass)
  {
    if (paramClass == this._keyType.getRawClass()) {}
    for (paramClass = this;; paramClass = new MapLikeType(this._class, this._keyType.widenBy(paramClass), this._valueType).copyHandlers(this)) {
      return paramClass;
    }
  }
  
  public MapLikeType withContentTypeHandler(Object paramObject)
  {
    return new MapLikeType(this._class, this._keyType, this._valueType.withTypeHandler(paramObject));
  }
  
  public MapLikeType withTypeHandler(Object paramObject)
  {
    MapLikeType localMapLikeType = new MapLikeType(this._class, this._keyType, this._valueType);
    localMapLikeType._typeHandler = paramObject;
    return localMapLikeType;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\type\MapLikeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */