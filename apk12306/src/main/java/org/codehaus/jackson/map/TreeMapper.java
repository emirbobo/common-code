package org.codehaus.jackson.map;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.NullNode;

@Deprecated
public class TreeMapper
  extends JsonNodeFactory
{
  protected ObjectMapper _objectMapper;
  
  public TreeMapper()
  {
    this(null);
  }
  
  public TreeMapper(ObjectMapper paramObjectMapper)
  {
    this._objectMapper = paramObjectMapper;
  }
  
  public JsonFactory getJsonFactory()
  {
    return objectMapper().getJsonFactory();
  }
  
  protected ObjectMapper objectMapper()
  {
    try
    {
      if (this._objectMapper == null)
      {
        localObjectMapper = new org/codehaus/jackson/map/ObjectMapper;
        localObjectMapper.<init>();
        this._objectMapper = localObjectMapper;
      }
      ObjectMapper localObjectMapper = this._objectMapper;
      return localObjectMapper;
    }
    finally {}
  }
  
  public JsonNode readTree(File paramFile)
    throws IOException, JsonParseException
  {
    JsonNode localJsonNode = (JsonNode)objectMapper().readValue(paramFile, JsonNode.class);
    paramFile = localJsonNode;
    if (localJsonNode == null) {
      paramFile = NullNode.instance;
    }
    return paramFile;
  }
  
  public JsonNode readTree(InputStream paramInputStream)
    throws IOException, JsonParseException
  {
    JsonNode localJsonNode = (JsonNode)objectMapper().readValue(paramInputStream, JsonNode.class);
    paramInputStream = localJsonNode;
    if (localJsonNode == null) {
      paramInputStream = NullNode.instance;
    }
    return paramInputStream;
  }
  
  public JsonNode readTree(Reader paramReader)
    throws IOException, JsonParseException
  {
    JsonNode localJsonNode = (JsonNode)objectMapper().readValue(paramReader, JsonNode.class);
    paramReader = localJsonNode;
    if (localJsonNode == null) {
      paramReader = NullNode.instance;
    }
    return paramReader;
  }
  
  public JsonNode readTree(String paramString)
    throws IOException, JsonParseException
  {
    JsonNode localJsonNode = (JsonNode)objectMapper().readValue(paramString, JsonNode.class);
    paramString = localJsonNode;
    if (localJsonNode == null) {
      paramString = NullNode.instance;
    }
    return paramString;
  }
  
  public JsonNode readTree(URL paramURL)
    throws IOException, JsonParseException
  {
    JsonNode localJsonNode = (JsonNode)objectMapper().readValue(paramURL, JsonNode.class);
    paramURL = localJsonNode;
    if (localJsonNode == null) {
      paramURL = NullNode.instance;
    }
    return paramURL;
  }
  
  public JsonNode readTree(JsonParser paramJsonParser)
    throws IOException, JsonParseException
  {
    if ((paramJsonParser.getCurrentToken() == null) && (paramJsonParser.nextToken() == null)) {}
    for (paramJsonParser = null;; paramJsonParser = objectMapper().readTree(paramJsonParser)) {
      return paramJsonParser;
    }
  }
  
  public JsonNode readTree(byte[] paramArrayOfByte)
    throws IOException, JsonParseException
  {
    JsonNode localJsonNode = (JsonNode)objectMapper().readValue(paramArrayOfByte, 0, paramArrayOfByte.length, JsonNode.class);
    paramArrayOfByte = localJsonNode;
    if (localJsonNode == null) {
      paramArrayOfByte = NullNode.instance;
    }
    return paramArrayOfByte;
  }
  
  public void writeTree(JsonNode paramJsonNode, File paramFile)
    throws IOException, JsonParseException
  {
    objectMapper().writeValue(paramFile, paramJsonNode);
  }
  
  public void writeTree(JsonNode paramJsonNode, OutputStream paramOutputStream)
    throws IOException, JsonParseException
  {
    objectMapper().writeValue(paramOutputStream, paramJsonNode);
  }
  
  public void writeTree(JsonNode paramJsonNode, Writer paramWriter)
    throws IOException, JsonParseException
  {
    objectMapper().writeValue(paramWriter, paramJsonNode);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\TreeMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */