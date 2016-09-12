package org.codehaus.jackson.map.ser;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

final class FilteredBeanPropertyWriter$SingleView
  extends BeanPropertyWriter
{
  protected final Class<?> _view;
  
  protected FilteredBeanPropertyWriter$SingleView(BeanPropertyWriter paramBeanPropertyWriter, Class<?> paramClass)
  {
    super(paramBeanPropertyWriter);
    this._view = paramClass;
  }
  
  protected FilteredBeanPropertyWriter$SingleView(SingleView paramSingleView, JsonSerializer<Object> paramJsonSerializer)
  {
    super(paramSingleView, paramJsonSerializer);
    this._view = paramSingleView._view;
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    Class localClass = paramSerializerProvider.getSerializationView();
    if ((localClass == null) || (this._view.isAssignableFrom(localClass))) {
      super.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
  }
  
  public BeanPropertyWriter withSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    return new SingleView(this, paramJsonSerializer);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\FilteredBeanPropertyWriter$SingleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */