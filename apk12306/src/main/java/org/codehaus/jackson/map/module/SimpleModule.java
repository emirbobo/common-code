package org.codehaus.jackson.map.module;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.Module;
import org.codehaus.jackson.map.Module.SetupContext;

public class SimpleModule
  extends Module
{
  protected SimpleAbstractTypeResolver _abstractTypes = null;
  protected SimpleDeserializers _deserializers = null;
  protected SimpleKeyDeserializers _keyDeserializers = null;
  protected SimpleSerializers _keySerializers = null;
  protected final String _name;
  protected SimpleSerializers _serializers = null;
  protected final Version _version;
  
  public SimpleModule(String paramString, Version paramVersion)
  {
    this._name = paramString;
    this._version = paramVersion;
  }
  
  public <T> SimpleModule addAbstractTypeMapping(Class<T> paramClass, Class<? extends T> paramClass1)
  {
    if (this._abstractTypes == null) {
      this._abstractTypes = new SimpleAbstractTypeResolver();
    }
    this._abstractTypes = this._abstractTypes.addMapping(paramClass, paramClass1);
    return this;
  }
  
  public <T> SimpleModule addDeserializer(Class<T> paramClass, JsonDeserializer<? extends T> paramJsonDeserializer)
  {
    if (this._deserializers == null) {
      this._deserializers = new SimpleDeserializers();
    }
    this._deserializers.addDeserializer(paramClass, paramJsonDeserializer);
    return this;
  }
  
  public SimpleModule addKeyDeserializer(Class<?> paramClass, KeyDeserializer paramKeyDeserializer)
  {
    if (this._keyDeserializers == null) {
      this._keyDeserializers = new SimpleKeyDeserializers();
    }
    this._keyDeserializers.addDeserializer(paramClass, paramKeyDeserializer);
    return this;
  }
  
  public <T> SimpleModule addKeySerializer(Class<? extends T> paramClass, JsonSerializer<T> paramJsonSerializer)
  {
    if (this._keySerializers == null) {
      this._keySerializers = new SimpleSerializers();
    }
    this._keySerializers.addSerializer(paramClass, paramJsonSerializer);
    return this;
  }
  
  public <T> SimpleModule addSerializer(Class<? extends T> paramClass, JsonSerializer<T> paramJsonSerializer)
  {
    if (this._serializers == null) {
      this._serializers = new SimpleSerializers();
    }
    this._serializers.addSerializer(paramClass, paramJsonSerializer);
    return this;
  }
  
  public SimpleModule addSerializer(JsonSerializer<?> paramJsonSerializer)
  {
    if (this._serializers == null) {
      this._serializers = new SimpleSerializers();
    }
    this._serializers.addSerializer(paramJsonSerializer);
    return this;
  }
  
  public String getModuleName()
  {
    return this._name;
  }
  
  public void setupModule(Module.SetupContext paramSetupContext)
  {
    if (this._serializers != null) {
      paramSetupContext.addSerializers(this._serializers);
    }
    if (this._deserializers != null) {
      paramSetupContext.addDeserializers(this._deserializers);
    }
    if (this._keySerializers != null) {
      paramSetupContext.addKeySerializers(this._keySerializers);
    }
    if (this._keyDeserializers != null) {
      paramSetupContext.addKeyDeserializers(this._keyDeserializers);
    }
    if (this._abstractTypes != null) {
      paramSetupContext.addAbstractTypeResolver(this._abstractTypes);
    }
  }
  
  public Version version()
  {
    return this._version;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\module\SimpleModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */