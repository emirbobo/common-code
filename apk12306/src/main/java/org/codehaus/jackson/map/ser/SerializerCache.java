package org.codehaus.jackson.map.ser;

import java.util.HashMap;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.impl.ReadOnlyClassToSerializerMap;
import org.codehaus.jackson.type.JavaType;

public final class SerializerCache
{
  private ReadOnlyClassToSerializerMap _readOnlyMap = null;
  private HashMap<TypeKey, JsonSerializer<Object>> _sharedMap = new HashMap(64);
  
  public void addAndResolveNonTypedSerializer(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    try
    {
      HashMap localHashMap = this._sharedMap;
      TypeKey localTypeKey = new org/codehaus/jackson/map/ser/SerializerCache$TypeKey;
      localTypeKey.<init>(paramClass, false);
      if (localHashMap.put(localTypeKey, paramJsonSerializer) == null) {
        this._readOnlyMap = null;
      }
      if ((paramJsonSerializer instanceof ResolvableSerializer)) {
        ((ResolvableSerializer)paramJsonSerializer).resolve(paramSerializerProvider);
      }
      return;
    }
    finally {}
  }
  
  public void addAndResolveNonTypedSerializer(JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    try
    {
      HashMap localHashMap = this._sharedMap;
      TypeKey localTypeKey = new org/codehaus/jackson/map/ser/SerializerCache$TypeKey;
      localTypeKey.<init>(paramJavaType, false);
      if (localHashMap.put(localTypeKey, paramJsonSerializer) == null) {
        this._readOnlyMap = null;
      }
      if ((paramJsonSerializer instanceof ResolvableSerializer)) {
        ((ResolvableSerializer)paramJsonSerializer).resolve(paramSerializerProvider);
      }
      return;
    }
    finally {}
  }
  
  public void addTypedSerializer(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
  {
    try
    {
      HashMap localHashMap = this._sharedMap;
      TypeKey localTypeKey = new org/codehaus/jackson/map/ser/SerializerCache$TypeKey;
      localTypeKey.<init>(paramClass, true);
      if (localHashMap.put(localTypeKey, paramJsonSerializer) == null) {
        this._readOnlyMap = null;
      }
      return;
    }
    finally {}
  }
  
  public void addTypedSerializer(JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer)
  {
    try
    {
      HashMap localHashMap = this._sharedMap;
      TypeKey localTypeKey = new org/codehaus/jackson/map/ser/SerializerCache$TypeKey;
      localTypeKey.<init>(paramJavaType, true);
      if (localHashMap.put(localTypeKey, paramJsonSerializer) == null) {
        this._readOnlyMap = null;
      }
      return;
    }
    finally {}
  }
  
  public void flush()
  {
    try
    {
      this._sharedMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public ReadOnlyClassToSerializerMap getReadOnlyLookupMap()
  {
    try
    {
      ReadOnlyClassToSerializerMap localReadOnlyClassToSerializerMap2 = this._readOnlyMap;
      ReadOnlyClassToSerializerMap localReadOnlyClassToSerializerMap1 = localReadOnlyClassToSerializerMap2;
      if (localReadOnlyClassToSerializerMap2 == null)
      {
        localReadOnlyClassToSerializerMap1 = ReadOnlyClassToSerializerMap.from(this._sharedMap);
        this._readOnlyMap = localReadOnlyClassToSerializerMap1;
      }
      return localReadOnlyClassToSerializerMap1.instance();
    }
    finally {}
  }
  
  public int size()
  {
    try
    {
      int i = this._sharedMap.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public JsonSerializer<Object> typedValueSerializer(Class<?> paramClass)
  {
    try
    {
      HashMap localHashMap = this._sharedMap;
      TypeKey localTypeKey = new org/codehaus/jackson/map/ser/SerializerCache$TypeKey;
      localTypeKey.<init>(paramClass, true);
      paramClass = (JsonSerializer)localHashMap.get(localTypeKey);
      return paramClass;
    }
    finally {}
  }
  
  public JsonSerializer<Object> typedValueSerializer(JavaType paramJavaType)
  {
    try
    {
      HashMap localHashMap = this._sharedMap;
      TypeKey localTypeKey = new org/codehaus/jackson/map/ser/SerializerCache$TypeKey;
      localTypeKey.<init>(paramJavaType, true);
      paramJavaType = (JsonSerializer)localHashMap.get(localTypeKey);
      return paramJavaType;
    }
    finally {}
  }
  
  public JsonSerializer<Object> untypedValueSerializer(Class<?> paramClass)
  {
    try
    {
      HashMap localHashMap = this._sharedMap;
      TypeKey localTypeKey = new org/codehaus/jackson/map/ser/SerializerCache$TypeKey;
      localTypeKey.<init>(paramClass, false);
      paramClass = (JsonSerializer)localHashMap.get(localTypeKey);
      return paramClass;
    }
    finally {}
  }
  
  public JsonSerializer<Object> untypedValueSerializer(JavaType paramJavaType)
  {
    try
    {
      HashMap localHashMap = this._sharedMap;
      TypeKey localTypeKey = new org/codehaus/jackson/map/ser/SerializerCache$TypeKey;
      localTypeKey.<init>(paramJavaType, false);
      paramJavaType = (JsonSerializer)localHashMap.get(localTypeKey);
      return paramJavaType;
    }
    finally {}
  }
  
  public static final class TypeKey
  {
    protected Class<?> _class;
    protected int _hashCode;
    protected boolean _isTyped;
    protected JavaType _type;
    
    public TypeKey(Class<?> paramClass, boolean paramBoolean)
    {
      this._class = paramClass;
      this._type = null;
      this._isTyped = paramBoolean;
      this._hashCode = hash(paramClass, paramBoolean);
    }
    
    public TypeKey(JavaType paramJavaType, boolean paramBoolean)
    {
      this._type = paramJavaType;
      this._class = null;
      this._isTyped = paramBoolean;
      this._hashCode = hash(paramJavaType, paramBoolean);
    }
    
    private static final int hash(Class<?> paramClass, boolean paramBoolean)
    {
      int j = paramClass.getName().hashCode();
      int i = j;
      if (paramBoolean) {
        i = j + 1;
      }
      return i;
    }
    
    private static final int hash(JavaType paramJavaType, boolean paramBoolean)
    {
      int j = paramJavaType.hashCode() - 1;
      int i = j;
      if (paramBoolean) {
        i = j - 1;
      }
      return i;
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (paramObject == this) {}
      for (;;)
      {
        return bool;
        paramObject = (TypeKey)paramObject;
        if (((TypeKey)paramObject)._isTyped == this._isTyped)
        {
          if (this._class != null)
          {
            if (((TypeKey)paramObject)._class != this._class) {
              bool = false;
            }
          }
          else {
            bool = this._type.equals(((TypeKey)paramObject)._type);
          }
        }
        else {
          bool = false;
        }
      }
    }
    
    public final int hashCode()
    {
      return this._hashCode;
    }
    
    public void resetTyped(Class<?> paramClass)
    {
      this._type = null;
      this._class = paramClass;
      this._isTyped = true;
      this._hashCode = hash(paramClass, true);
    }
    
    public void resetTyped(JavaType paramJavaType)
    {
      this._type = paramJavaType;
      this._class = null;
      this._isTyped = true;
      this._hashCode = hash(paramJavaType, true);
    }
    
    public void resetUntyped(Class<?> paramClass)
    {
      this._type = null;
      this._class = paramClass;
      this._isTyped = false;
      this._hashCode = hash(paramClass, false);
    }
    
    public void resetUntyped(JavaType paramJavaType)
    {
      this._type = paramJavaType;
      this._class = null;
      this._isTyped = false;
      this._hashCode = hash(paramJavaType, false);
    }
    
    public final String toString()
    {
      if (this._class != null) {}
      for (String str = "{class: " + this._class.getName() + ", typed? " + this._isTyped + "}";; str = "{type: " + this._type + ", typed? " + this._isTyped + "}") {
        return str;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\SerializerCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */