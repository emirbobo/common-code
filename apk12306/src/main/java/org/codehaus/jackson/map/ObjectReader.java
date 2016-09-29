package org.codehaus.jackson.map;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.FormatSchema;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.map.deser.StdDeserializationContext;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.NullNode;
import org.codehaus.jackson.node.TreeTraversingParser;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.util.VersionUtil;

public class ObjectReader
  extends ObjectCodec
  implements Versioned
{
  private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(JsonNode.class);
  protected final DeserializationConfig _config;
  protected final JsonFactory _jsonFactory;
  protected final DeserializerProvider _provider;
  protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers;
  protected final FormatSchema _schema;
  protected final Object _valueToUpdate;
  protected final JavaType _valueType;
  
  protected ObjectReader(ObjectMapper paramObjectMapper, DeserializationConfig paramDeserializationConfig)
  {
    this(paramObjectMapper, paramDeserializationConfig, null, null, null);
  }
  
  protected ObjectReader(ObjectMapper paramObjectMapper, DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, Object paramObject, FormatSchema paramFormatSchema)
  {
    this._config = paramDeserializationConfig;
    this._rootDeserializers = paramObjectMapper._rootDeserializers;
    this._provider = paramObjectMapper._deserializerProvider;
    this._jsonFactory = paramObjectMapper._jsonFactory;
    this._valueType = paramJavaType;
    this._valueToUpdate = paramObject;
    if ((paramObject != null) && (paramJavaType.isArrayType())) {
      throw new IllegalArgumentException("Can not update an array value");
    }
    this._schema = paramFormatSchema;
  }
  
  protected ObjectReader(ObjectReader paramObjectReader, DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, Object paramObject, FormatSchema paramFormatSchema)
  {
    this._config = paramDeserializationConfig;
    this._rootDeserializers = paramObjectReader._rootDeserializers;
    this._provider = paramObjectReader._provider;
    this._jsonFactory = paramObjectReader._jsonFactory;
    this._valueType = paramJavaType;
    this._valueToUpdate = paramObject;
    if ((paramObject != null) && (paramJavaType.isArrayType())) {
      throw new IllegalArgumentException("Can not update an array value");
    }
    this._schema = paramFormatSchema;
  }
  
  protected static JsonToken _initForReading(JsonParser paramJsonParser)
    throws IOException, JsonParseException, JsonMappingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    Object localObject = localJsonToken;
    if (localJsonToken == null)
    {
      paramJsonParser = paramJsonParser.nextToken();
      localObject = paramJsonParser;
      if (paramJsonParser == null) {
        throw new EOFException("No content to map to Object due to end of input");
      }
    }
    return (JsonToken)localObject;
  }
  
  protected Object _bind(JsonParser paramJsonParser)
    throws IOException, JsonParseException, JsonMappingException
  {
    Object localObject = _initForReading(paramJsonParser);
    if ((localObject == JsonToken.VALUE_NULL) || (localObject == JsonToken.END_ARRAY) || (localObject == JsonToken.END_OBJECT)) {
      localObject = this._valueToUpdate;
    }
    for (;;)
    {
      paramJsonParser.clearCurrentToken();
      return localObject;
      localObject = _createDeserializationContext(paramJsonParser, this._config);
      if (this._valueToUpdate == null)
      {
        localObject = _findRootDeserializer(this._config, this._valueType).deserialize(paramJsonParser, (DeserializationContext)localObject);
      }
      else
      {
        _findRootDeserializer(this._config, this._valueType).deserialize(paramJsonParser, (DeserializationContext)localObject, this._valueToUpdate);
        localObject = this._valueToUpdate;
      }
    }
  }
  
  /* Error */
  protected Object _bindAndClose(JsonParser paramJsonParser)
    throws IOException, JsonParseException, JsonMappingException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	org/codehaus/jackson/map/ObjectReader:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   4: ifnull +11 -> 15
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 76	org/codehaus/jackson/map/ObjectReader:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   12: invokevirtual 141	org/codehaus/jackson/JsonParser:setSchema	(Lorg/codehaus/jackson/FormatSchema;)V
    //   15: aload_1
    //   16: invokestatic 104	org/codehaus/jackson/map/ObjectReader:_initForReading	(Lorg/codehaus/jackson/JsonParser;)Lorg/codehaus/jackson/JsonToken;
    //   19: astore_2
    //   20: aload_2
    //   21: getstatic 110	org/codehaus/jackson/JsonToken:VALUE_NULL	Lorg/codehaus/jackson/JsonToken;
    //   24: if_acmpeq +17 -> 41
    //   27: aload_2
    //   28: getstatic 113	org/codehaus/jackson/JsonToken:END_ARRAY	Lorg/codehaus/jackson/JsonToken;
    //   31: if_acmpeq +10 -> 41
    //   34: aload_2
    //   35: getstatic 116	org/codehaus/jackson/JsonToken:END_OBJECT	Lorg/codehaus/jackson/JsonToken;
    //   38: if_acmpne +14 -> 52
    //   41: aload_0
    //   42: getfield 61	org/codehaus/jackson/map/ObjectReader:_valueToUpdate	Ljava/lang/Object;
    //   45: astore_2
    //   46: aload_1
    //   47: invokevirtual 144	org/codehaus/jackson/JsonParser:close	()V
    //   50: aload_2
    //   51: areturn
    //   52: aload_0
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 44	org/codehaus/jackson/map/ObjectReader:_config	Lorg/codehaus/jackson/map/DeserializationConfig;
    //   58: invokevirtual 123	org/codehaus/jackson/map/ObjectReader:_createDeserializationContext	(Lorg/codehaus/jackson/JsonParser;Lorg/codehaus/jackson/map/DeserializationConfig;)Lorg/codehaus/jackson/map/DeserializationContext;
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 61	org/codehaus/jackson/map/ObjectReader:_valueToUpdate	Ljava/lang/Object;
    //   66: ifnonnull +24 -> 90
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 44	org/codehaus/jackson/map/ObjectReader:_config	Lorg/codehaus/jackson/map/DeserializationConfig;
    //   74: aload_0
    //   75: getfield 59	org/codehaus/jackson/map/ObjectReader:_valueType	Lorg/codehaus/jackson/type/JavaType;
    //   78: invokevirtual 127	org/codehaus/jackson/map/ObjectReader:_findRootDeserializer	(Lorg/codehaus/jackson/map/DeserializationConfig;Lorg/codehaus/jackson/type/JavaType;)Lorg/codehaus/jackson/map/JsonDeserializer;
    //   81: aload_1
    //   82: aload_2
    //   83: invokevirtual 133	org/codehaus/jackson/map/JsonDeserializer:deserialize	(Lorg/codehaus/jackson/JsonParser;Lorg/codehaus/jackson/map/DeserializationContext;)Ljava/lang/Object;
    //   86: astore_2
    //   87: goto -41 -> 46
    //   90: aload_0
    //   91: aload_0
    //   92: getfield 44	org/codehaus/jackson/map/ObjectReader:_config	Lorg/codehaus/jackson/map/DeserializationConfig;
    //   95: aload_0
    //   96: getfield 59	org/codehaus/jackson/map/ObjectReader:_valueType	Lorg/codehaus/jackson/type/JavaType;
    //   99: invokevirtual 127	org/codehaus/jackson/map/ObjectReader:_findRootDeserializer	(Lorg/codehaus/jackson/map/DeserializationConfig;Lorg/codehaus/jackson/type/JavaType;)Lorg/codehaus/jackson/map/JsonDeserializer;
    //   102: aload_1
    //   103: aload_2
    //   104: aload_0
    //   105: getfield 61	org/codehaus/jackson/map/ObjectReader:_valueToUpdate	Ljava/lang/Object;
    //   108: invokevirtual 136	org/codehaus/jackson/map/JsonDeserializer:deserialize	(Lorg/codehaus/jackson/JsonParser;Lorg/codehaus/jackson/map/DeserializationContext;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: aload_0
    //   113: getfield 61	org/codehaus/jackson/map/ObjectReader:_valueToUpdate	Ljava/lang/Object;
    //   116: astore_2
    //   117: goto -71 -> 46
    //   120: astore_2
    //   121: aload_1
    //   122: invokevirtual 144	org/codehaus/jackson/JsonParser:close	()V
    //   125: aload_2
    //   126: athrow
    //   127: astore_1
    //   128: goto -78 -> 50
    //   131: astore_1
    //   132: goto -7 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	ObjectReader
    //   0	135	1	paramJsonParser	JsonParser
    //   19	98	2	localObject1	Object
    //   120	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	41	120	finally
    //   41	46	120	finally
    //   52	87	120	finally
    //   90	117	120	finally
    //   46	50	127	java/io/IOException
    //   121	125	131	java/io/IOException
  }
  
  /* Error */
  protected JsonNode _bindAndCloseAsTree(JsonParser paramJsonParser)
    throws IOException, JsonParseException, JsonMappingException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	org/codehaus/jackson/map/ObjectReader:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   4: ifnull +11 -> 15
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 76	org/codehaus/jackson/map/ObjectReader:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   12: invokevirtual 141	org/codehaus/jackson/JsonParser:setSchema	(Lorg/codehaus/jackson/FormatSchema;)V
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 149	org/codehaus/jackson/map/ObjectReader:_bindAsTree	(Lorg/codehaus/jackson/JsonParser;)Lorg/codehaus/jackson/JsonNode;
    //   20: astore_2
    //   21: aload_1
    //   22: invokevirtual 144	org/codehaus/jackson/JsonParser:close	()V
    //   25: aload_2
    //   26: areturn
    //   27: astore_2
    //   28: aload_1
    //   29: invokevirtual 144	org/codehaus/jackson/JsonParser:close	()V
    //   32: aload_2
    //   33: athrow
    //   34: astore_1
    //   35: goto -10 -> 25
    //   38: astore_1
    //   39: goto -7 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	ObjectReader
    //   0	42	1	paramJsonParser	JsonParser
    //   20	6	2	localJsonNode	JsonNode
    //   27	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	21	27	finally
    //   21	25	34	java/io/IOException
    //   28	32	38	java/io/IOException
  }
  
  protected JsonNode _bindAsTree(JsonParser paramJsonParser)
    throws IOException, JsonParseException, JsonMappingException
  {
    Object localObject = _initForReading(paramJsonParser);
    if ((localObject == JsonToken.VALUE_NULL) || (localObject == JsonToken.END_ARRAY) || (localObject == JsonToken.END_OBJECT)) {}
    for (localObject = NullNode.instance;; localObject = (JsonNode)_findRootDeserializer(this._config, JSON_NODE_TYPE).deserialize(paramJsonParser, (DeserializationContext)localObject))
    {
      paramJsonParser.clearCurrentToken();
      return (JsonNode)localObject;
      localObject = _createDeserializationContext(paramJsonParser, this._config);
    }
  }
  
  protected DeserializationContext _createDeserializationContext(JsonParser paramJsonParser, DeserializationConfig paramDeserializationConfig)
  {
    return new StdDeserializationContext(paramDeserializationConfig, paramJsonParser, this._provider);
  }
  
  protected JsonDeserializer<Object> _findRootDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
    throws JsonMappingException
  {
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)this._rootDeserializers.get(paramJavaType);
    if (localJsonDeserializer != null) {
      paramDeserializationConfig = localJsonDeserializer;
    }
    for (;;)
    {
      return paramDeserializationConfig;
      paramDeserializationConfig = this._provider.findTypedValueDeserializer(paramDeserializationConfig, paramJavaType, null);
      if (paramDeserializationConfig == null) {
        throw new JsonMappingException("Can not find a deserializer for type " + paramJavaType);
      }
      this._rootDeserializers.put(paramJavaType, paramDeserializationConfig);
    }
  }
  
  public JsonNode createArrayNode()
  {
    return this._config.getNodeFactory().arrayNode();
  }
  
  public JsonNode createObjectNode()
  {
    return this._config.getNodeFactory().objectNode();
  }
  
  public JsonNode readTree(InputStream paramInputStream)
    throws IOException, JsonProcessingException
  {
    return _bindAndCloseAsTree(this._jsonFactory.createJsonParser(paramInputStream));
  }
  
  public JsonNode readTree(Reader paramReader)
    throws IOException, JsonProcessingException
  {
    return _bindAndCloseAsTree(this._jsonFactory.createJsonParser(paramReader));
  }
  
  public JsonNode readTree(String paramString)
    throws IOException, JsonProcessingException
  {
    return _bindAndCloseAsTree(this._jsonFactory.createJsonParser(paramString));
  }
  
  public JsonNode readTree(JsonParser paramJsonParser)
    throws IOException, JsonProcessingException
  {
    return _bindAsTree(paramJsonParser);
  }
  
  public <T> T readValue(File paramFile)
    throws IOException, JsonProcessingException
  {
    return (T)_bindAndClose(this._jsonFactory.createJsonParser(paramFile));
  }
  
  public <T> T readValue(InputStream paramInputStream)
    throws IOException, JsonProcessingException
  {
    return (T)_bindAndClose(this._jsonFactory.createJsonParser(paramInputStream));
  }
  
  public <T> T readValue(Reader paramReader)
    throws IOException, JsonProcessingException
  {
    return (T)_bindAndClose(this._jsonFactory.createJsonParser(paramReader));
  }
  
  public <T> T readValue(String paramString)
    throws IOException, JsonProcessingException
  {
    return (T)_bindAndClose(this._jsonFactory.createJsonParser(paramString));
  }
  
  public <T> T readValue(URL paramURL)
    throws IOException, JsonProcessingException
  {
    return (T)_bindAndClose(this._jsonFactory.createJsonParser(paramURL));
  }
  
  public <T> T readValue(JsonNode paramJsonNode)
    throws IOException, JsonProcessingException
  {
    return (T)_bindAndClose(treeAsTokens(paramJsonNode));
  }
  
  public <T> T readValue(JsonParser paramJsonParser)
    throws IOException, JsonProcessingException
  {
    return (T)_bind(paramJsonParser);
  }
  
  public <T> T readValue(JsonParser paramJsonParser, Class<T> paramClass)
    throws IOException, JsonProcessingException
  {
    return (T)withType(paramClass).readValue(paramJsonParser);
  }
  
  public <T> T readValue(JsonParser paramJsonParser, JavaType paramJavaType)
    throws IOException, JsonProcessingException
  {
    return (T)withType(paramJavaType).readValue(paramJsonParser);
  }
  
  public <T> T readValue(JsonParser paramJsonParser, TypeReference<?> paramTypeReference)
    throws IOException, JsonProcessingException
  {
    return (T)withType(paramTypeReference).readValue(paramJsonParser);
  }
  
  public <T> T readValue(byte[] paramArrayOfByte)
    throws IOException, JsonProcessingException
  {
    return (T)_bindAndClose(this._jsonFactory.createJsonParser(paramArrayOfByte));
  }
  
  public <T> T readValue(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonProcessingException
  {
    return (T)_bindAndClose(this._jsonFactory.createJsonParser(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public <T> MappingIterator<T> readValues(File paramFile)
    throws IOException, JsonProcessingException
  {
    paramFile = this._jsonFactory.createJsonParser(paramFile);
    if (this._schema != null) {
      paramFile.setSchema(this._schema);
    }
    DeserializationContext localDeserializationContext = _createDeserializationContext(paramFile, this._config);
    return new MappingIterator(this._valueType, paramFile, localDeserializationContext, _findRootDeserializer(this._config, this._valueType));
  }
  
  public <T> MappingIterator<T> readValues(InputStream paramInputStream)
    throws IOException, JsonProcessingException
  {
    paramInputStream = this._jsonFactory.createJsonParser(paramInputStream);
    if (this._schema != null) {
      paramInputStream.setSchema(this._schema);
    }
    DeserializationContext localDeserializationContext = _createDeserializationContext(paramInputStream, this._config);
    return new MappingIterator(this._valueType, paramInputStream, localDeserializationContext, _findRootDeserializer(this._config, this._valueType));
  }
  
  public <T> MappingIterator<T> readValues(Reader paramReader)
    throws IOException, JsonProcessingException
  {
    JsonParser localJsonParser = this._jsonFactory.createJsonParser(paramReader);
    if (this._schema != null) {
      localJsonParser.setSchema(this._schema);
    }
    paramReader = _createDeserializationContext(localJsonParser, this._config);
    return new MappingIterator(this._valueType, localJsonParser, paramReader, _findRootDeserializer(this._config, this._valueType));
  }
  
  public <T> MappingIterator<T> readValues(String paramString)
    throws IOException, JsonProcessingException
  {
    JsonParser localJsonParser = this._jsonFactory.createJsonParser(paramString);
    if (this._schema != null) {
      localJsonParser.setSchema(this._schema);
    }
    paramString = _createDeserializationContext(localJsonParser, this._config);
    return new MappingIterator(this._valueType, localJsonParser, paramString, _findRootDeserializer(this._config, this._valueType));
  }
  
  public <T> MappingIterator<T> readValues(URL paramURL)
    throws IOException, JsonProcessingException
  {
    JsonParser localJsonParser = this._jsonFactory.createJsonParser(paramURL);
    if (this._schema != null) {
      localJsonParser.setSchema(this._schema);
    }
    paramURL = _createDeserializationContext(localJsonParser, this._config);
    return new MappingIterator(this._valueType, localJsonParser, paramURL, _findRootDeserializer(this._config, this._valueType));
  }
  
  public <T> MappingIterator<T> readValues(JsonParser paramJsonParser)
    throws IOException, JsonProcessingException
  {
    DeserializationContext localDeserializationContext = _createDeserializationContext(paramJsonParser, this._config);
    return new MappingIterator(this._valueType, paramJsonParser, localDeserializationContext, _findRootDeserializer(this._config, this._valueType));
  }
  
  public <T> MappingIterator<T> readValues(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonProcessingException
  {
    JsonParser localJsonParser = this._jsonFactory.createJsonParser(paramArrayOfByte, paramInt1, paramInt2);
    if (this._schema != null) {
      localJsonParser.setSchema(this._schema);
    }
    paramArrayOfByte = _createDeserializationContext(localJsonParser, this._config);
    return new MappingIterator(this._valueType, localJsonParser, paramArrayOfByte, _findRootDeserializer(this._config, this._valueType));
  }
  
  public JsonParser treeAsTokens(JsonNode paramJsonNode)
  {
    return new TreeTraversingParser(paramJsonNode, this);
  }
  
  public <T> T treeToValue(JsonNode paramJsonNode, Class<T> paramClass)
    throws IOException, JsonProcessingException
  {
    return (T)readValue(treeAsTokens(paramJsonNode), paramClass);
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public ObjectReader withNodeFactory(JsonNodeFactory paramJsonNodeFactory)
  {
    if (paramJsonNodeFactory == this._config.getNodeFactory()) {}
    for (paramJsonNodeFactory = this;; paramJsonNodeFactory = new ObjectReader(this, this._config.withNodeFactory(paramJsonNodeFactory), this._valueType, this._valueToUpdate, this._schema)) {
      return paramJsonNodeFactory;
    }
  }
  
  public ObjectReader withSchema(FormatSchema paramFormatSchema)
  {
    if (this._schema == paramFormatSchema) {}
    for (paramFormatSchema = this;; paramFormatSchema = new ObjectReader(this, this._config, this._valueType, this._valueToUpdate, paramFormatSchema)) {
      return paramFormatSchema;
    }
  }
  
  public ObjectReader withType(Class<?> paramClass)
  {
    return withType(this._config.constructType(paramClass));
  }
  
  public ObjectReader withType(Type paramType)
  {
    return withType(this._config.getTypeFactory().constructType(paramType));
  }
  
  public ObjectReader withType(JavaType paramJavaType)
  {
    if (paramJavaType == this._valueType) {}
    for (paramJavaType = this;; paramJavaType = new ObjectReader(this, this._config, paramJavaType, this._valueToUpdate, this._schema)) {
      return paramJavaType;
    }
  }
  
  public ObjectReader withType(TypeReference<?> paramTypeReference)
  {
    return withType(this._config.getTypeFactory().constructType(paramTypeReference.getType()));
  }
  
  public ObjectReader withValueToUpdate(Object paramObject)
  {
    if (paramObject == this._valueToUpdate) {}
    JavaType localJavaType;
    for (paramObject = this;; paramObject = new ObjectReader(this, this._config, localJavaType, paramObject, this._schema))
    {
      return (ObjectReader)paramObject;
      if (paramObject == null) {
        throw new IllegalArgumentException("cat not update null value");
      }
      localJavaType = this._config.constructType(paramObject.getClass());
    }
  }
  
  public void writeTree(JsonGenerator paramJsonGenerator, JsonNode paramJsonNode)
    throws IOException, JsonProcessingException
  {
    throw new UnsupportedOperationException("Not implemented for ObjectReader");
  }
  
  public void writeValue(JsonGenerator paramJsonGenerator, Object paramObject)
    throws IOException, JsonProcessingException
  {
    throw new UnsupportedOperationException("Not implemented for ObjectReader");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ObjectReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */