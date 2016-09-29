package org.codehaus.jackson.map.ser;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

final class FilteredBeanPropertyWriter$MultiView
  extends BeanPropertyWriter
{
  protected final Class<?>[] _views;
  
  protected FilteredBeanPropertyWriter$MultiView(BeanPropertyWriter paramBeanPropertyWriter, Class<?>[] paramArrayOfClass)
  {
    super(paramBeanPropertyWriter);
    this._views = paramArrayOfClass;
  }
  
  protected FilteredBeanPropertyWriter$MultiView(MultiView paramMultiView, JsonSerializer<Object> paramJsonSerializer)
  {
    super(paramMultiView, paramJsonSerializer);
    this._views = paramMultiView._views;
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    Class localClass = paramSerializerProvider.getSerializationView();
    int i;
    if (localClass != null)
    {
      i = 0;
      int j = this._views.length;
      if ((i >= j) || (this._views[i].isAssignableFrom(localClass))) {
        if (i != j) {
          break label57;
        }
      }
    }
    for (;;)
    {
      return;
      i++;
      break;
      label57:
      super.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
  }
  
  public BeanPropertyWriter withSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    return new MultiView(this, paramJsonSerializer);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\FilteredBeanPropertyWriter$MultiView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */