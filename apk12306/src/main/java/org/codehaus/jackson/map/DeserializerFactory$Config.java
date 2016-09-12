package org.codehaus.jackson.map;

import org.codehaus.jackson.map.deser.BeanDeserializerModifier;

public abstract class DeserializerFactory$Config
{
  public abstract Iterable<AbstractTypeResolver> abstractTypeResolvers();
  
  public abstract Iterable<BeanDeserializerModifier> deserializerModifiers();
  
  public abstract Iterable<Deserializers> deserializers();
  
  public abstract boolean hasAbstractTypeResolvers();
  
  public abstract boolean hasDeserializerModifiers();
  
  public abstract boolean hasDeserializers();
  
  public abstract boolean hasKeyDeserializers();
  
  public abstract Iterable<KeyDeserializers> keyDeserializers();
  
  public abstract Config withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver);
  
  public abstract Config withAdditionalDeserializers(Deserializers paramDeserializers);
  
  public abstract Config withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers);
  
  public abstract Config withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\DeserializerFactory$Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */