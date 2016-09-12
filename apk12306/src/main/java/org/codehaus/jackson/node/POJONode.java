package org.codehaus.jackson.node;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;

public final class POJONode
  extends ValueNode
{
  protected final Object _value;
  
  public POJONode(Object paramObject)
  {
    this._value = paramObject;
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_EMBEDDED_OBJECT;
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
        paramObject = (POJONode)paramObject;
        if (this._value == null)
        {
          if (((POJONode)paramObject)._value != null) {
            bool = false;
          }
        }
        else {
          bool = this._value.equals(((POJONode)paramObject)._value);
        }
      }
    }
  }
  
  public Object getPojo()
  {
    return this._value;
  }
  
  public boolean getValueAsBoolean(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this._value != null)
    {
      bool = paramBoolean;
      if ((this._value instanceof Boolean)) {
        bool = ((Boolean)this._value).booleanValue();
      }
    }
    return bool;
  }
  
  public double getValueAsDouble(double paramDouble)
  {
    if ((this._value instanceof Number)) {
      paramDouble = ((Number)this._value).doubleValue();
    }
    return paramDouble;
  }
  
  public int getValueAsInt(int paramInt)
  {
    if ((this._value instanceof Number)) {
      paramInt = ((Number)this._value).intValue();
    }
    return paramInt;
  }
  
  public long getValueAsLong(long paramLong)
  {
    if ((this._value instanceof Number)) {
      paramLong = ((Number)this._value).longValue();
    }
    return paramLong;
  }
  
  public String getValueAsText()
  {
    if (this._value == null) {}
    for (String str = "null";; str = this._value.toString()) {
      return str;
    }
  }
  
  public int hashCode()
  {
    return this._value.hashCode();
  }
  
  public boolean isPojo()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    if (this._value == null) {
      paramJsonGenerator.writeNull();
    }
    for (;;)
    {
      return;
      paramJsonGenerator.writeObject(this._value);
    }
  }
  
  public String toString()
  {
    return String.valueOf(this._value);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\POJONode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */