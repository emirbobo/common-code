package org.codehaus.jackson.map;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.deser.BeanDeserializerModifier;
import org.codehaus.jackson.map.ser.BeanSerializerModifier;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.type.TypeModifier;

class ObjectMapper$1
  implements Module.SetupContext
{
  ObjectMapper$1(ObjectMapper paramObjectMapper1, ObjectMapper paramObjectMapper2) {}
  
  public void addAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver)
  {
    this.val$mapper._deserializerProvider = this.val$mapper._deserializerProvider.withAbstractTypeResolver(paramAbstractTypeResolver);
  }
  
  public void addBeanDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier)
  {
    this.val$mapper._deserializerProvider = this.val$mapper._deserializerProvider.withDeserializerModifier(paramBeanDeserializerModifier);
  }
  
  public void addBeanSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier)
  {
    this.val$mapper._serializerFactory = this.val$mapper._serializerFactory.withSerializerModifier(paramBeanSerializerModifier);
  }
  
  public void addDeserializers(Deserializers paramDeserializers)
  {
    this.val$mapper._deserializerProvider = this.val$mapper._deserializerProvider.withAdditionalDeserializers(paramDeserializers);
  }
  
  public void addKeyDeserializers(KeyDeserializers paramKeyDeserializers)
  {
    this.val$mapper._deserializerProvider = this.val$mapper._deserializerProvider.withAdditionalKeyDeserializers(paramKeyDeserializers);
  }
  
  public void addKeySerializers(Serializers paramSerializers)
  {
    this.val$mapper._serializerFactory = this.val$mapper._serializerFactory.withAdditionalKeySerializers(paramSerializers);
  }
  
  public void addSerializers(Serializers paramSerializers)
  {
    this.val$mapper._serializerFactory = this.val$mapper._serializerFactory.withAdditionalSerializers(paramSerializers);
  }
  
  public void addTypeModifier(TypeModifier paramTypeModifier)
  {
    paramTypeModifier = this.val$mapper._typeFactory.withModifier(paramTypeModifier);
    this.val$mapper.setTypeFactory(paramTypeModifier);
  }
  
  public void appendAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    this.val$mapper._deserializationConfig.appendAnnotationIntrospector(paramAnnotationIntrospector);
    this.val$mapper._serializationConfig.appendAnnotationIntrospector(paramAnnotationIntrospector);
  }
  
  public DeserializationConfig getDeserializationConfig()
  {
    return this.val$mapper.getDeserializationConfig();
  }
  
  public Version getMapperVersion()
  {
    return this.this$0.version();
  }
  
  public SerializationConfig getSerializationConfig()
  {
    return this.val$mapper.getSerializationConfig();
  }
  
  public void insertAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    this.val$mapper._deserializationConfig.insertAnnotationIntrospector(paramAnnotationIntrospector);
    this.val$mapper._serializationConfig.insertAnnotationIntrospector(paramAnnotationIntrospector);
  }
  
  public void setMixInAnnotations(Class<?> paramClass1, Class<?> paramClass2)
  {
    this.val$mapper._deserializationConfig.addMixInAnnotations(paramClass1, paramClass2);
    this.val$mapper._serializationConfig.addMixInAnnotations(paramClass1, paramClass2);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ObjectMapper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */