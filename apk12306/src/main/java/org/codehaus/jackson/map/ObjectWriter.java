package org.codehaus.jackson.map;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import org.codehaus.jackson.FormatSchema;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.io.SegmentedStringWriter;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.codehaus.jackson.util.VersionUtil;

public class ObjectWriter
  implements Versioned
{
  protected static final PrettyPrinter NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
  protected final SerializationConfig _config;
  protected final JsonFactory _jsonFactory;
  protected final PrettyPrinter _prettyPrinter;
  protected final SerializerProvider _provider;
  protected final JavaType _rootType;
  protected final FormatSchema _schema;
  protected final SerializerFactory _serializerFactory;
  
  protected ObjectWriter(ObjectMapper paramObjectMapper, SerializationConfig paramSerializationConfig)
  {
    this._config = paramSerializationConfig;
    this._provider = paramObjectMapper._serializerProvider;
    this._serializerFactory = paramObjectMapper._serializerFactory;
    this._jsonFactory = paramObjectMapper._jsonFactory;
    this._rootType = null;
    this._prettyPrinter = null;
    this._schema = null;
  }
  
  protected ObjectWriter(ObjectMapper paramObjectMapper, SerializationConfig paramSerializationConfig, FormatSchema paramFormatSchema)
  {
    this._config = paramSerializationConfig;
    this._provider = paramObjectMapper._serializerProvider;
    this._serializerFactory = paramObjectMapper._serializerFactory;
    this._jsonFactory = paramObjectMapper._jsonFactory;
    this._rootType = null;
    this._prettyPrinter = null;
    this._schema = paramFormatSchema;
  }
  
  protected ObjectWriter(ObjectMapper paramObjectMapper, SerializationConfig paramSerializationConfig, JavaType paramJavaType, PrettyPrinter paramPrettyPrinter)
  {
    this._config = paramSerializationConfig;
    this._provider = paramObjectMapper._serializerProvider;
    this._serializerFactory = paramObjectMapper._serializerFactory;
    this._jsonFactory = paramObjectMapper._jsonFactory;
    this._rootType = paramJavaType;
    this._prettyPrinter = paramPrettyPrinter;
    this._schema = null;
  }
  
  protected ObjectWriter(ObjectWriter paramObjectWriter, SerializationConfig paramSerializationConfig)
  {
    this._config = paramSerializationConfig;
    this._provider = paramObjectWriter._provider;
    this._serializerFactory = paramObjectWriter._serializerFactory;
    this._jsonFactory = paramObjectWriter._jsonFactory;
    this._schema = paramObjectWriter._schema;
    this._rootType = paramObjectWriter._rootType;
    this._prettyPrinter = paramObjectWriter._prettyPrinter;
  }
  
  protected ObjectWriter(ObjectWriter paramObjectWriter, SerializationConfig paramSerializationConfig, JavaType paramJavaType, PrettyPrinter paramPrettyPrinter, FormatSchema paramFormatSchema)
  {
    this._config = paramSerializationConfig;
    this._provider = paramObjectWriter._provider;
    this._serializerFactory = paramObjectWriter._serializerFactory;
    this._jsonFactory = paramObjectWriter._jsonFactory;
    this._rootType = paramJavaType;
    this._prettyPrinter = paramPrettyPrinter;
    this._schema = paramFormatSchema;
  }
  
  /* Error */
  private final void _configAndWriteCloseable(JsonGenerator paramJsonGenerator, Object paramObject, SerializationConfig paramSerializationConfig)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    // Byte code:
    //   0: aload_2
    //   1: checkcast 68	java/io/Closeable
    //   4: astore 6
    //   6: aload 6
    //   8: astore 4
    //   10: aload_1
    //   11: astore 5
    //   13: aload_0
    //   14: getfield 50	org/codehaus/jackson/map/ObjectWriter:_rootType	Lorg/codehaus/jackson/type/JavaType;
    //   17: ifnonnull +104 -> 121
    //   20: aload 6
    //   22: astore 4
    //   24: aload_1
    //   25: astore 5
    //   27: aload_0
    //   28: getfield 42	org/codehaus/jackson/map/ObjectWriter:_provider	Lorg/codehaus/jackson/map/SerializerProvider;
    //   31: aload_3
    //   32: aload_1
    //   33: aload_2
    //   34: aload_0
    //   35: getfield 45	org/codehaus/jackson/map/ObjectWriter:_serializerFactory	Lorg/codehaus/jackson/map/SerializerFactory;
    //   38: invokevirtual 74	org/codehaus/jackson/map/SerializerProvider:serializeValue	(Lorg/codehaus/jackson/map/SerializationConfig;Lorg/codehaus/jackson/JsonGenerator;Ljava/lang/Object;Lorg/codehaus/jackson/map/SerializerFactory;)V
    //   41: aload 6
    //   43: astore 4
    //   45: aload_1
    //   46: astore 5
    //   48: aload_0
    //   49: getfield 54	org/codehaus/jackson/map/ObjectWriter:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   52: ifnull +18 -> 70
    //   55: aload 6
    //   57: astore 4
    //   59: aload_1
    //   60: astore 5
    //   62: aload_1
    //   63: aload_0
    //   64: getfield 54	org/codehaus/jackson/map/ObjectWriter:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   67: invokevirtual 80	org/codehaus/jackson/JsonGenerator:setSchema	(Lorg/codehaus/jackson/FormatSchema;)V
    //   70: aconst_null
    //   71: astore_2
    //   72: aload 6
    //   74: astore 4
    //   76: aload_2
    //   77: astore 5
    //   79: aload_1
    //   80: invokevirtual 83	org/codehaus/jackson/JsonGenerator:close	()V
    //   83: aconst_null
    //   84: astore 4
    //   86: aload_2
    //   87: astore 5
    //   89: aload 6
    //   91: invokeinterface 84 1 0
    //   96: iconst_0
    //   97: ifeq +11 -> 108
    //   100: new 86	java/lang/NullPointerException
    //   103: dup
    //   104: invokespecial 87	java/lang/NullPointerException:<init>	()V
    //   107: athrow
    //   108: iconst_0
    //   109: ifeq +11 -> 120
    //   112: new 86	java/lang/NullPointerException
    //   115: dup
    //   116: invokespecial 87	java/lang/NullPointerException:<init>	()V
    //   119: athrow
    //   120: return
    //   121: aload 6
    //   123: astore 4
    //   125: aload_1
    //   126: astore 5
    //   128: aload_0
    //   129: getfield 42	org/codehaus/jackson/map/ObjectWriter:_provider	Lorg/codehaus/jackson/map/SerializerProvider;
    //   132: aload_3
    //   133: aload_1
    //   134: aload_2
    //   135: aload_0
    //   136: getfield 50	org/codehaus/jackson/map/ObjectWriter:_rootType	Lorg/codehaus/jackson/type/JavaType;
    //   139: aload_0
    //   140: getfield 45	org/codehaus/jackson/map/ObjectWriter:_serializerFactory	Lorg/codehaus/jackson/map/SerializerFactory;
    //   143: invokevirtual 90	org/codehaus/jackson/map/SerializerProvider:serializeValue	(Lorg/codehaus/jackson/map/SerializationConfig;Lorg/codehaus/jackson/JsonGenerator;Ljava/lang/Object;Lorg/codehaus/jackson/type/JavaType;Lorg/codehaus/jackson/map/SerializerFactory;)V
    //   146: goto -105 -> 41
    //   149: astore_1
    //   150: aload 5
    //   152: ifnull +8 -> 160
    //   155: aload 5
    //   157: invokevirtual 83	org/codehaus/jackson/JsonGenerator:close	()V
    //   160: aload 4
    //   162: ifnull +10 -> 172
    //   165: aload 4
    //   167: invokeinterface 84 1 0
    //   172: aload_1
    //   173: athrow
    //   174: astore_1
    //   175: goto -67 -> 108
    //   178: astore_1
    //   179: goto -59 -> 120
    //   182: astore_2
    //   183: goto -23 -> 160
    //   186: astore_2
    //   187: goto -15 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	ObjectWriter
    //   0	190	1	paramJsonGenerator	JsonGenerator
    //   0	190	2	paramObject	Object
    //   0	190	3	paramSerializationConfig	SerializationConfig
    //   8	158	4	localCloseable1	Closeable
    //   11	145	5	localObject	Object
    //   4	118	6	localCloseable2	Closeable
    // Exception table:
    //   from	to	target	type
    //   13	20	149	finally
    //   27	41	149	finally
    //   48	55	149	finally
    //   62	70	149	finally
    //   79	83	149	finally
    //   89	96	149	finally
    //   128	146	149	finally
    //   100	108	174	java/io/IOException
    //   112	120	178	java/io/IOException
    //   155	160	182	java/io/IOException
    //   165	172	186	java/io/IOException
  }
  
  /* Error */
  private final void _writeCloseableValue(JsonGenerator paramJsonGenerator, Object paramObject, SerializationConfig paramSerializationConfig)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    // Byte code:
    //   0: aload_2
    //   1: checkcast 68	java/io/Closeable
    //   4: astore 5
    //   6: aload 5
    //   8: astore 4
    //   10: aload_0
    //   11: getfield 50	org/codehaus/jackson/map/ObjectWriter:_rootType	Lorg/codehaus/jackson/type/JavaType;
    //   14: ifnonnull +69 -> 83
    //   17: aload 5
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 42	org/codehaus/jackson/map/ObjectWriter:_provider	Lorg/codehaus/jackson/map/SerializerProvider;
    //   25: aload_3
    //   26: aload_1
    //   27: aload_2
    //   28: aload_0
    //   29: getfield 45	org/codehaus/jackson/map/ObjectWriter:_serializerFactory	Lorg/codehaus/jackson/map/SerializerFactory;
    //   32: invokevirtual 74	org/codehaus/jackson/map/SerializerProvider:serializeValue	(Lorg/codehaus/jackson/map/SerializationConfig;Lorg/codehaus/jackson/JsonGenerator;Ljava/lang/Object;Lorg/codehaus/jackson/map/SerializerFactory;)V
    //   35: aload 5
    //   37: astore 4
    //   39: aload_0
    //   40: getfield 35	org/codehaus/jackson/map/ObjectWriter:_config	Lorg/codehaus/jackson/map/SerializationConfig;
    //   43: getstatic 98	org/codehaus/jackson/map/SerializationConfig$Feature:FLUSH_AFTER_WRITE_VALUE	Lorg/codehaus/jackson/map/SerializationConfig$Feature;
    //   46: invokevirtual 104	org/codehaus/jackson/map/SerializationConfig:isEnabled	(Lorg/codehaus/jackson/map/SerializationConfig$Feature;)Z
    //   49: ifeq +11 -> 60
    //   52: aload 5
    //   54: astore 4
    //   56: aload_1
    //   57: invokevirtual 107	org/codehaus/jackson/JsonGenerator:flush	()V
    //   60: aconst_null
    //   61: astore 4
    //   63: aload 5
    //   65: invokeinterface 84 1 0
    //   70: iconst_0
    //   71: ifeq +11 -> 82
    //   74: new 86	java/lang/NullPointerException
    //   77: dup
    //   78: invokespecial 87	java/lang/NullPointerException:<init>	()V
    //   81: athrow
    //   82: return
    //   83: aload 5
    //   85: astore 4
    //   87: aload_0
    //   88: getfield 42	org/codehaus/jackson/map/ObjectWriter:_provider	Lorg/codehaus/jackson/map/SerializerProvider;
    //   91: aload_3
    //   92: aload_1
    //   93: aload_2
    //   94: aload_0
    //   95: getfield 50	org/codehaus/jackson/map/ObjectWriter:_rootType	Lorg/codehaus/jackson/type/JavaType;
    //   98: aload_0
    //   99: getfield 45	org/codehaus/jackson/map/ObjectWriter:_serializerFactory	Lorg/codehaus/jackson/map/SerializerFactory;
    //   102: invokevirtual 90	org/codehaus/jackson/map/SerializerProvider:serializeValue	(Lorg/codehaus/jackson/map/SerializationConfig;Lorg/codehaus/jackson/JsonGenerator;Ljava/lang/Object;Lorg/codehaus/jackson/type/JavaType;Lorg/codehaus/jackson/map/SerializerFactory;)V
    //   105: goto -70 -> 35
    //   108: astore_1
    //   109: aload 4
    //   111: ifnull +10 -> 121
    //   114: aload 4
    //   116: invokeinterface 84 1 0
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: goto -42 -> 82
    //   127: astore_2
    //   128: goto -7 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	ObjectWriter
    //   0	131	1	paramJsonGenerator	JsonGenerator
    //   0	131	2	paramObject	Object
    //   0	131	3	paramSerializationConfig	SerializationConfig
    //   8	107	4	localCloseable1	Closeable
    //   4	80	5	localCloseable2	Closeable
    // Exception table:
    //   from	to	target	type
    //   10	17	108	finally
    //   21	35	108	finally
    //   39	52	108	finally
    //   56	60	108	finally
    //   63	70	108	finally
    //   87	105	108	finally
    //   74	82	123	java/io/IOException
    //   114	121	127	java/io/IOException
  }
  
  protected final void _configAndWriteValue(JsonGenerator paramJsonGenerator, Object paramObject)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    if (this._prettyPrinter != null)
    {
      PrettyPrinter localPrettyPrinter2 = this._prettyPrinter;
      PrettyPrinter localPrettyPrinter1 = localPrettyPrinter2;
      if (localPrettyPrinter2 == NULL_PRETTY_PRINTER) {
        localPrettyPrinter1 = null;
      }
      paramJsonGenerator.setPrettyPrinter(localPrettyPrinter1);
      if (this._schema != null) {
        paramJsonGenerator.setSchema(this._schema);
      }
      if ((!this._config.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE)) || (!(paramObject instanceof Closeable))) {
        break label102;
      }
      _configAndWriteCloseable(paramJsonGenerator, paramObject, this._config);
    }
    for (;;)
    {
      return;
      if (!this._config.isEnabled(SerializationConfig.Feature.INDENT_OUTPUT)) {
        break;
      }
      paramJsonGenerator.useDefaultPrettyPrinter();
      break;
      label102:
      int j = 0;
      int i = j;
      try
      {
        if (this._rootType == null)
        {
          i = j;
          this._provider.serializeValue(this._config, paramJsonGenerator, paramObject, this._serializerFactory);
        }
        for (;;)
        {
          i = 1;
          paramJsonGenerator.close();
          if (1 != 0) {
            break;
          }
          try
          {
            paramJsonGenerator.close();
          }
          catch (IOException paramJsonGenerator) {}
          break;
          i = j;
          this._provider.serializeValue(this._config, paramJsonGenerator, paramObject, this._rootType, this._serializerFactory);
        }
        try
        {
          paramJsonGenerator.close();
          throw ((Throwable)paramObject);
        }
        catch (IOException paramJsonGenerator)
        {
          for (;;) {}
        }
      }
      finally
      {
        if (i != 0) {}
      }
    }
  }
  
  public boolean canSerialize(Class<?> paramClass)
  {
    return this._provider.hasSerializerFor(this._config, paramClass, this._serializerFactory);
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public ObjectWriter withDefaultPrettyPrinter()
  {
    return withPrettyPrinter(new DefaultPrettyPrinter());
  }
  
  public ObjectWriter withFilters(FilterProvider paramFilterProvider)
  {
    if (paramFilterProvider == this._config.getFilterProvider()) {}
    for (paramFilterProvider = this;; paramFilterProvider = new ObjectWriter(this, this._config.withFilters(paramFilterProvider))) {
      return paramFilterProvider;
    }
  }
  
  public ObjectWriter withPrettyPrinter(PrettyPrinter paramPrettyPrinter)
  {
    if (paramPrettyPrinter == this._prettyPrinter) {}
    PrettyPrinter localPrettyPrinter;
    for (paramPrettyPrinter = this;; paramPrettyPrinter = new ObjectWriter(this, this._config, this._rootType, localPrettyPrinter, this._schema))
    {
      return paramPrettyPrinter;
      localPrettyPrinter = paramPrettyPrinter;
      if (paramPrettyPrinter == null) {
        localPrettyPrinter = NULL_PRETTY_PRINTER;
      }
    }
  }
  
  public ObjectWriter withSchema(FormatSchema paramFormatSchema)
  {
    if (this._schema == paramFormatSchema) {}
    for (paramFormatSchema = this;; paramFormatSchema = new ObjectWriter(this, this._config, this._rootType, this._prettyPrinter, paramFormatSchema)) {
      return paramFormatSchema;
    }
  }
  
  public ObjectWriter withType(Class<?> paramClass)
  {
    return withType(this._config.constructType(paramClass));
  }
  
  public ObjectWriter withType(JavaType paramJavaType)
  {
    if (paramJavaType == this._rootType) {}
    for (paramJavaType = this;; paramJavaType = new ObjectWriter(this, this._config, paramJavaType, this._prettyPrinter, this._schema)) {
      return paramJavaType;
    }
  }
  
  public ObjectWriter withType(TypeReference<?> paramTypeReference)
  {
    return withType(this._config.getTypeFactory().constructType(paramTypeReference.getType()));
  }
  
  public ObjectWriter withView(Class<?> paramClass)
  {
    if (paramClass == this._config.getSerializationView()) {}
    for (paramClass = this;; paramClass = new ObjectWriter(this, this._config.withView(paramClass))) {
      return paramClass;
    }
  }
  
  public void writeValue(File paramFile, Object paramObject)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    _configAndWriteValue(this._jsonFactory.createJsonGenerator(paramFile, JsonEncoding.UTF8), paramObject);
  }
  
  public void writeValue(OutputStream paramOutputStream, Object paramObject)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    _configAndWriteValue(this._jsonFactory.createJsonGenerator(paramOutputStream, JsonEncoding.UTF8), paramObject);
  }
  
  public void writeValue(Writer paramWriter, Object paramObject)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    _configAndWriteValue(this._jsonFactory.createJsonGenerator(paramWriter), paramObject);
  }
  
  public void writeValue(JsonGenerator paramJsonGenerator, Object paramObject)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    if ((this._config.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE)) && ((paramObject instanceof Closeable))) {
      _writeCloseableValue(paramJsonGenerator, paramObject, this._config);
    }
    label97:
    for (;;)
    {
      return;
      if (this._rootType == null) {
        this._provider.serializeValue(this._config, paramJsonGenerator, paramObject, this._serializerFactory);
      }
      for (;;)
      {
        if (!this._config.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE)) {
          break label97;
        }
        paramJsonGenerator.flush();
        break;
        this._provider.serializeValue(this._config, paramJsonGenerator, paramObject, this._rootType, this._serializerFactory);
      }
    }
  }
  
  public byte[] writeValueAsBytes(Object paramObject)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    ByteArrayBuilder localByteArrayBuilder = new ByteArrayBuilder(this._jsonFactory._getBufferRecycler());
    _configAndWriteValue(this._jsonFactory.createJsonGenerator(localByteArrayBuilder, JsonEncoding.UTF8), paramObject);
    paramObject = localByteArrayBuilder.toByteArray();
    localByteArrayBuilder.release();
    return (byte[])paramObject;
  }
  
  public String writeValueAsString(Object paramObject)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    SegmentedStringWriter localSegmentedStringWriter = new SegmentedStringWriter(this._jsonFactory._getBufferRecycler());
    _configAndWriteValue(this._jsonFactory.createJsonGenerator(localSegmentedStringWriter), paramObject);
    return localSegmentedStringWriter.getAndClear();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ObjectWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */