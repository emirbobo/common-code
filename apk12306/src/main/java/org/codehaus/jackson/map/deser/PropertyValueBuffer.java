package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;

public final class PropertyValueBuffer
{
  private PropertyValue _buffered;
  final DeserializationContext _context;
  final Object[] _creatorParameters;
  private int _paramsNeeded;
  final JsonParser _parser;
  
  public PropertyValueBuffer(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, int paramInt)
  {
    this._parser = paramJsonParser;
    this._context = paramDeserializationContext;
    this._paramsNeeded = paramInt;
    this._creatorParameters = new Object[paramInt];
  }
  
  public boolean assignParameter(int paramInt, Object paramObject)
  {
    this._creatorParameters[paramInt] = paramObject;
    paramInt = this._paramsNeeded - 1;
    this._paramsNeeded = paramInt;
    if (paramInt <= 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void bufferAnyProperty(SettableAnyProperty paramSettableAnyProperty, String paramString, Object paramObject)
  {
    this._buffered = new PropertyValue.Any(this._buffered, paramObject, paramSettableAnyProperty, paramString);
  }
  
  public void bufferMapProperty(Object paramObject1, Object paramObject2)
  {
    this._buffered = new PropertyValue.Map(this._buffered, paramObject2, paramObject1);
  }
  
  public void bufferProperty(SettableBeanProperty paramSettableBeanProperty, Object paramObject)
  {
    this._buffered = new PropertyValue.Regular(this._buffered, paramObject, paramSettableBeanProperty);
  }
  
  protected PropertyValue buffered()
  {
    return this._buffered;
  }
  
  protected final Object[] getParameters(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      int i = 0;
      int j = this._creatorParameters.length;
      while (i < j)
      {
        if (this._creatorParameters[i] == null)
        {
          Object localObject = paramArrayOfObject[i];
          if (localObject != null) {
            this._creatorParameters[i] = localObject;
          }
        }
        i++;
      }
    }
    return this._creatorParameters;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\PropertyValueBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */