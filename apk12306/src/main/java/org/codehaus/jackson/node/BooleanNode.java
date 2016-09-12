package org.codehaus.jackson.node;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;

public final class BooleanNode
  extends ValueNode
{
  public static final BooleanNode FALSE = new BooleanNode();
  public static final BooleanNode TRUE = new BooleanNode();
  
  public static BooleanNode getFalse()
  {
    return FALSE;
  }
  
  public static BooleanNode getTrue()
  {
    return TRUE;
  }
  
  public static BooleanNode valueOf(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (BooleanNode localBooleanNode = TRUE;; localBooleanNode = FALSE) {
      return localBooleanNode;
    }
  }
  
  public JsonToken asToken()
  {
    if (this == TRUE) {}
    for (JsonToken localJsonToken = JsonToken.VALUE_TRUE;; localJsonToken = JsonToken.VALUE_FALSE) {
      return localJsonToken;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean getBooleanValue()
  {
    if (this == TRUE) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean getValueAsBoolean()
  {
    if (this == TRUE) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean getValueAsBoolean(boolean paramBoolean)
  {
    if (this == TRUE) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public double getValueAsDouble(double paramDouble)
  {
    if (this == TRUE) {}
    for (paramDouble = 1.0D;; paramDouble = 0.0D) {
      return paramDouble;
    }
  }
  
  public int getValueAsInt(int paramInt)
  {
    if (this == TRUE) {}
    for (paramInt = 1;; paramInt = 0) {
      return paramInt;
    }
  }
  
  public long getValueAsLong(long paramLong)
  {
    if (this == TRUE) {}
    for (paramLong = 1L;; paramLong = 0L) {
      return paramLong;
    }
  }
  
  public String getValueAsText()
  {
    if (this == TRUE) {}
    for (String str = "true";; str = "false") {
      return str;
    }
  }
  
  public boolean isBoolean()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    if (this == TRUE) {}
    for (boolean bool = true;; bool = false)
    {
      paramJsonGenerator.writeBoolean(bool);
      return;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\BooleanNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */