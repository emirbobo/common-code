package org.codehaus.jackson.node;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.impl.JsonParserMinimalBase;

public class TreeTraversingParser
  extends JsonParserMinimalBase
{
  protected boolean _closed;
  protected JsonToken _nextToken;
  protected NodeCursor _nodeCursor;
  protected ObjectCodec _objectCodec;
  protected boolean _startContainer;
  
  public TreeTraversingParser(JsonNode paramJsonNode)
  {
    this(paramJsonNode, null);
  }
  
  public TreeTraversingParser(JsonNode paramJsonNode, ObjectCodec paramObjectCodec)
  {
    super(0);
    this._objectCodec = paramObjectCodec;
    if (paramJsonNode.isArray())
    {
      this._nextToken = JsonToken.START_ARRAY;
      this._nodeCursor = new NodeCursor.Array(paramJsonNode, null);
    }
    for (;;)
    {
      return;
      if (paramJsonNode.isObject())
      {
        this._nextToken = JsonToken.START_OBJECT;
        this._nodeCursor = new NodeCursor.Object(paramJsonNode, null);
      }
      else
      {
        this._nodeCursor = new NodeCursor.RootValue(paramJsonNode, null);
      }
    }
  }
  
  protected void _handleEOF()
    throws JsonParseException
  {
    _throwInternal();
  }
  
  public void close()
    throws IOException
  {
    if (!this._closed)
    {
      this._closed = true;
      this._nodeCursor = null;
      this._currToken = null;
    }
  }
  
  protected JsonNode currentNode()
  {
    if ((this._closed) || (this._nodeCursor == null)) {}
    for (JsonNode localJsonNode = null;; localJsonNode = this._nodeCursor.currentNode()) {
      return localJsonNode;
    }
  }
  
  protected JsonNode currentNumericNode()
    throws JsonParseException
  {
    Object localObject = currentNode();
    if ((localObject == null) || (!((JsonNode)localObject).isNumber()))
    {
      if (localObject == null) {}
      for (localObject = null;; localObject = ((JsonNode)localObject).asToken()) {
        throw _constructError("Current token (" + localObject + ") not numeric, can not use numeric value accessors");
      }
    }
    return (JsonNode)localObject;
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().getBigIntegerValue();
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
  {
    JsonNode localJsonNode = currentNode();
    if (localJsonNode != null)
    {
      paramBase64Variant = localJsonNode.getBinaryValue();
      if (paramBase64Variant == null) {}
    }
    for (;;)
    {
      return paramBase64Variant;
      if (localJsonNode.isPojo())
      {
        paramBase64Variant = ((POJONode)localJsonNode).getPojo();
        if ((paramBase64Variant instanceof byte[]))
        {
          paramBase64Variant = (byte[])paramBase64Variant;
          continue;
        }
      }
      paramBase64Variant = null;
    }
  }
  
  public ObjectCodec getCodec()
  {
    return this._objectCodec;
  }
  
  public JsonLocation getCurrentLocation()
  {
    return JsonLocation.NA;
  }
  
  public String getCurrentName()
  {
    if (this._nodeCursor == null) {}
    for (String str = null;; str = this._nodeCursor.getCurrentName()) {
      return str;
    }
  }
  
  public BigDecimal getDecimalValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().getDecimalValue();
  }
  
  public double getDoubleValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().getDoubleValue();
  }
  
  public Object getEmbeddedObject()
  {
    if (!this._closed)
    {
      localObject = currentNode();
      if ((localObject == null) || (!((JsonNode)localObject).isPojo())) {}
    }
    for (Object localObject = ((POJONode)localObject).getPojo();; localObject = null) {
      return localObject;
    }
  }
  
  public float getFloatValue()
    throws IOException, JsonParseException
  {
    return (float)currentNumericNode().getDoubleValue();
  }
  
  public int getIntValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().getIntValue();
  }
  
  public long getLongValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().getLongValue();
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException, JsonParseException
  {
    Object localObject = currentNumericNode();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((JsonNode)localObject).getNumberType()) {
      return (JsonParser.NumberType)localObject;
    }
  }
  
  public Number getNumberValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().getNumberValue();
  }
  
  public JsonStreamContext getParsingContext()
  {
    return this._nodeCursor;
  }
  
  public String getText()
  {
    String str = null;
    if (this._closed) {
      label8:
      break label56;
    }
    for (;;)
    {
      return str;
      switch (this._currToken)
      {
      default: 
        if (this._currToken != null) {
          str = this._currToken.asString();
        }
        break;
      case ???: 
        str = this._nodeCursor.getCurrentName();
        break;
      case ???: 
        str = currentNode().getTextValue();
        break;
      case ???: 
      case ???: 
        str = String.valueOf(currentNode().getNumberValue());
        break;
      case ???: 
        label56:
        JsonNode localJsonNode = currentNode();
        if ((localJsonNode == null) || (!localJsonNode.isBinary())) {
          break label8;
        }
        str = localJsonNode.getValueAsText();
      }
    }
  }
  
  public char[] getTextCharacters()
    throws IOException, JsonParseException
  {
    return getText().toCharArray();
  }
  
  public int getTextLength()
    throws IOException, JsonParseException
  {
    return getText().length();
  }
  
  public int getTextOffset()
    throws IOException, JsonParseException
  {
    return 0;
  }
  
  public JsonLocation getTokenLocation()
  {
    return JsonLocation.NA;
  }
  
  public boolean hasTextCharacters()
  {
    return false;
  }
  
  public boolean isClosed()
  {
    return this._closed;
  }
  
  public JsonToken nextToken()
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = null;
    if (this._nextToken != null)
    {
      this._currToken = this._nextToken;
      this._nextToken = null;
      localJsonToken = this._currToken;
    }
    for (;;)
    {
      return localJsonToken;
      if (this._startContainer)
      {
        this._startContainer = false;
        if (!this._nodeCursor.currentHasChildren())
        {
          if (this._currToken == JsonToken.START_OBJECT) {}
          for (localJsonToken = JsonToken.END_OBJECT;; localJsonToken = JsonToken.END_ARRAY)
          {
            this._currToken = localJsonToken;
            localJsonToken = this._currToken;
            break;
          }
        }
        this._nodeCursor = this._nodeCursor.iterateChildren();
        this._currToken = this._nodeCursor.nextToken();
        if ((this._currToken == JsonToken.START_OBJECT) || (this._currToken == JsonToken.START_ARRAY)) {
          this._startContainer = true;
        }
        localJsonToken = this._currToken;
      }
      else if (this._nodeCursor == null)
      {
        this._closed = true;
      }
      else
      {
        this._currToken = this._nodeCursor.nextToken();
        if (this._currToken != null)
        {
          if ((this._currToken == JsonToken.START_OBJECT) || (this._currToken == JsonToken.START_ARRAY)) {
            this._startContainer = true;
          }
          localJsonToken = this._currToken;
        }
        else
        {
          this._currToken = this._nodeCursor.endToken();
          this._nodeCursor = this._nodeCursor.getParent();
          localJsonToken = this._currToken;
        }
      }
    }
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
  }
  
  public JsonParser skipChildren()
    throws IOException, JsonParseException
  {
    if (this._currToken == JsonToken.START_OBJECT)
    {
      this._startContainer = false;
      this._currToken = JsonToken.END_OBJECT;
    }
    for (;;)
    {
      return this;
      if (this._currToken == JsonToken.START_ARRAY)
      {
        this._startContainer = false;
        this._currToken = JsonToken.END_ARRAY;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\TreeTraversingParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */