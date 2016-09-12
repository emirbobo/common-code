package org.codehaus.jackson.map;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.map.deser.BeanDeserializerModifier;
import org.codehaus.jackson.map.ser.BeanSerializerModifier;
import org.codehaus.jackson.map.type.TypeModifier;

public abstract class Module
  implements Versioned
{
  public abstract String getModuleName();
  
  public abstract void setupModule(SetupContext paramSetupContext);
  
  public abstract Version version();
  
  public static abstract interface SetupContext
  {
    public abstract void addAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver);
    
    public abstract void addBeanDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier);
    
    public abstract void addBeanSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier);
    
    public abstract void addDeserializers(Deserializers paramDeserializers);
    
    public abstract void addKeyDeserializers(KeyDeserializers paramKeyDeserializers);
    
    public abstract void addKeySerializers(Serializers paramSerializers);
    
    public abstract void addSerializers(Serializers paramSerializers);
    
    public abstract void addTypeModifier(TypeModifier paramTypeModifier);
    
    public abstract void appendAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
    
    public abstract DeserializationConfig getDeserializationConfig();
    
    public abstract Version getMapperVersion();
    
    public abstract SerializationConfig getSerializationConfig();
    
    public abstract void insertAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
    
    public abstract void setMixInAnnotations(Class<?> paramClass1, Class<?> paramClass2);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */