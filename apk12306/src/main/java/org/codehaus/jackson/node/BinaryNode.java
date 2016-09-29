package org.codehaus.jackson.node;

import java.io.IOException;
import java.util.Arrays;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;

public final class BinaryNode
  extends ValueNode
{
  static final BinaryNode EMPTY_BINARY_NODE = new BinaryNode(new byte[0]);
  final byte[] _data;
  
  public BinaryNode(byte[] paramArrayOfByte)
  {
    this._data = paramArrayOfByte;
  }
  
  public BinaryNode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == paramArrayOfByte.length)) {
      this._data = paramArrayOfByte;
    }
    for (;;)
    {
      return;
      this._data = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, this._data, 0, paramInt2);
    }
  }
  
  public static BinaryNode valueOf(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      if (paramArrayOfByte.length == 0) {
        paramArrayOfByte = EMPTY_BINARY_NODE;
      } else {
        paramArrayOfByte = new BinaryNode(paramArrayOfByte);
      }
    }
  }
  
  public static BinaryNode valueOf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      if (paramInt2 == 0) {
        paramArrayOfByte = EMPTY_BINARY_NODE;
      } else {
        paramArrayOfByte = new BinaryNode(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_EMBEDDED_OBJECT;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.getClass() == getClass()) {
          bool1 = Arrays.equals(((BinaryNode)paramObject)._data, this._data);
        }
      }
    }
  }
  
  public byte[] getBinaryValue()
  {
    return this._data;
  }
  
  public String getValueAsText()
  {
    return Base64Variants.getDefaultVariant().encode(this._data, false);
  }
  
  public int hashCode()
  {
    if (this._data == null) {}
    for (int i = -1;; i = this._data.length) {
      return i;
    }
  }
  
  public boolean isBinary()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeBinary(this._data);
  }
  
  public String toString()
  {
    return Base64Variants.getDefaultVariant().encode(this._data, true);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\BinaryNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */