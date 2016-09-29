package org.codehaus.jackson.map.ser.impl;

import java.util.Set;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;

public class SimpleBeanPropertyFilter$FilterExceptFilter
  extends SimpleBeanPropertyFilter
{
  protected final Set<String> _propertiesToInclude;
  
  public SimpleBeanPropertyFilter$FilterExceptFilter(Set<String> paramSet)
  {
    this._propertiesToInclude = paramSet;
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, BeanPropertyWriter paramBeanPropertyWriter)
    throws Exception
  {
    if (this._propertiesToInclude.contains(paramBeanPropertyWriter.getName())) {
      paramBeanPropertyWriter.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\impl\SimpleBeanPropertyFilter$FilterExceptFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */