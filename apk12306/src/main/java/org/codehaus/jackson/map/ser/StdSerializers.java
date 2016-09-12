package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.util.Calendar;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonSerializable;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.util.TokenBuffer;

public class StdSerializers
{
  @JacksonStdImpl
  public static final class BooleanSerializer
    extends StdSerializers.NonTypedScalarSerializer<Boolean>
  {
    final boolean _forPrimitive;
    
    public BooleanSerializer(boolean paramBoolean)
    {
      super();
      this._forPrimitive = paramBoolean;
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      if (!this._forPrimitive) {}
      for (boolean bool = true;; bool = false) {
        return createSchemaNode("boolean", bool);
      }
    }
    
    public void serialize(Boolean paramBoolean, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeBoolean(paramBoolean.booleanValue());
    }
  }
  
  @JacksonStdImpl
  public static final class CalendarSerializer
    extends ScalarSerializerBase<Calendar>
  {
    public static final CalendarSerializer instance = new CalendarSerializer();
    
    public CalendarSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {}
      for (paramSerializerProvider = "number";; paramSerializerProvider = "string") {
        return createSchemaNode(paramSerializerProvider, true);
      }
    }
    
    public void serialize(Calendar paramCalendar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramSerializerProvider.defaultSerializeDateValue(paramCalendar.getTimeInMillis(), paramJsonGenerator);
    }
  }
  
  @JacksonStdImpl
  public static final class DoubleSerializer
    extends StdSerializers.NonTypedScalarSerializer<Double>
  {
    static final DoubleSerializer instance = new DoubleSerializer();
    
    public DoubleSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("number", true);
    }
    
    public void serialize(Double paramDouble, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeNumber(paramDouble.doubleValue());
    }
  }
  
  @JacksonStdImpl
  public static final class FloatSerializer
    extends ScalarSerializerBase<Float>
  {
    static final FloatSerializer instance = new FloatSerializer();
    
    public FloatSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("number", true);
    }
    
    public void serialize(Float paramFloat, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeNumber(paramFloat.floatValue());
    }
  }
  
  @JacksonStdImpl
  public static final class IntLikeSerializer
    extends ScalarSerializerBase<Number>
  {
    static final IntLikeSerializer instance = new IntLikeSerializer();
    
    public IntLikeSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("integer", true);
    }
    
    public void serialize(Number paramNumber, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeNumber(paramNumber.intValue());
    }
  }
  
  @JacksonStdImpl
  public static final class IntegerSerializer
    extends StdSerializers.NonTypedScalarSerializer<Integer>
  {
    public IntegerSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("integer", true);
    }
    
    public void serialize(Integer paramInteger, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeNumber(paramInteger.intValue());
    }
  }
  
  @JacksonStdImpl
  public static final class LongSerializer
    extends ScalarSerializerBase<Long>
  {
    static final LongSerializer instance = new LongSerializer();
    
    public LongSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("number", true);
    }
    
    public void serialize(Long paramLong, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeNumber(paramLong.longValue());
    }
  }
  
  protected static abstract class NonTypedScalarSerializer<T>
    extends ScalarSerializerBase<T>
  {
    protected NonTypedScalarSerializer(Class<T> paramClass)
    {
      super();
    }
    
    public final void serializeWithType(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
      throws IOException, JsonGenerationException
    {
      serialize(paramT, paramJsonGenerator, paramSerializerProvider);
    }
  }
  
  @JacksonStdImpl
  public static final class NumberSerializer
    extends ScalarSerializerBase<Number>
  {
    public static final NumberSerializer instance = new NumberSerializer();
    
    public NumberSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("number", true);
    }
    
    public void serialize(Number paramNumber, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      if ((paramNumber instanceof BigDecimal)) {
        paramJsonGenerator.writeNumber((BigDecimal)paramNumber);
      }
      for (;;)
      {
        return;
        if ((paramNumber instanceof BigInteger)) {
          paramJsonGenerator.writeNumber((BigInteger)paramNumber);
        } else if ((paramNumber instanceof Double)) {
          paramJsonGenerator.writeNumber(((Double)paramNumber).doubleValue());
        } else if ((paramNumber instanceof Float)) {
          paramJsonGenerator.writeNumber(((Float)paramNumber).floatValue());
        } else {
          paramJsonGenerator.writeNumber(paramNumber.toString());
        }
      }
    }
  }
  
  @JacksonStdImpl
  public static final class SerializableSerializer
    extends SerializerBase<JsonSerializable>
  {
    protected static final SerializableSerializer instance = new SerializableSerializer();
    
    private SerializableSerializer()
    {
      super();
    }
    
    /* Error */
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
      throws org.codehaus.jackson.map.JsonMappingException
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 34	org/codehaus/jackson/map/ser/StdSerializers$SerializableSerializer:createObjectNode	()Lorg/codehaus/jackson/node/ObjectNode;
      //   4: astore 9
      //   6: ldc 36
      //   8: astore 7
      //   10: aconst_null
      //   11: astore 8
      //   13: aconst_null
      //   14: astore_1
      //   15: aconst_null
      //   16: astore 6
      //   18: aload 6
      //   20: astore_3
      //   21: aload 8
      //   23: astore 4
      //   25: aload 7
      //   27: astore 5
      //   29: aload_2
      //   30: ifnull +111 -> 141
      //   33: aload_2
      //   34: invokestatic 42	org/codehaus/jackson/map/type/TypeFactory:type	(Ljava/lang/reflect/Type;)Lorg/codehaus/jackson/type/JavaType;
      //   37: invokevirtual 48	org/codehaus/jackson/type/JavaType:getRawClass	()Ljava/lang/Class;
      //   40: astore_2
      //   41: aload 6
      //   43: astore_3
      //   44: aload 8
      //   46: astore 4
      //   48: aload 7
      //   50: astore 5
      //   52: aload_2
      //   53: ldc 50
      //   55: invokevirtual 56	java/lang/Class:isAnnotationPresent	(Ljava/lang/Class;)Z
      //   58: ifeq +83 -> 141
      //   61: aload_2
      //   62: ldc 50
      //   64: invokevirtual 60	java/lang/Class:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
      //   67: checkcast 50	org/codehaus/jackson/schema/JsonSerializableSchema
      //   70: astore 7
      //   72: aload 7
      //   74: invokeinterface 64 1 0
      //   79: astore_2
      //   80: ldc 66
      //   82: aload 7
      //   84: invokeinterface 69 1 0
      //   89: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   92: ifne +11 -> 103
      //   95: aload 7
      //   97: invokeinterface 69 1 0
      //   102: astore_1
      //   103: aload 6
      //   105: astore_3
      //   106: aload_1
      //   107: astore 4
      //   109: aload_2
      //   110: astore 5
      //   112: ldc 66
      //   114: aload 7
      //   116: invokeinterface 78 1 0
      //   121: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   124: ifne +17 -> 141
      //   127: aload 7
      //   129: invokeinterface 78 1 0
      //   134: astore_3
      //   135: aload_2
      //   136: astore 5
      //   138: aload_1
      //   139: astore 4
      //   141: aload 9
      //   143: ldc 79
      //   145: aload 5
      //   147: invokevirtual 85	org/codehaus/jackson/node/ObjectNode:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   150: aload 4
      //   152: ifnull +30 -> 182
      //   155: new 87	org/codehaus/jackson/map/ObjectMapper
      //   158: astore_1
      //   159: aload_1
      //   160: invokespecial 88	org/codehaus/jackson/map/ObjectMapper:<init>	()V
      //   163: aload 9
      //   165: ldc 90
      //   167: aload_1
      //   168: aload 4
      //   170: ldc 92
      //   172: invokevirtual 96	org/codehaus/jackson/map/ObjectMapper:readValue	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
      //   175: checkcast 92	org/codehaus/jackson/JsonNode
      //   178: invokevirtual 99	org/codehaus/jackson/node/ObjectNode:put	(Ljava/lang/String;Lorg/codehaus/jackson/JsonNode;)Lorg/codehaus/jackson/JsonNode;
      //   181: pop
      //   182: aload_3
      //   183: ifnull +29 -> 212
      //   186: new 87	org/codehaus/jackson/map/ObjectMapper
      //   189: astore_1
      //   190: aload_1
      //   191: invokespecial 88	org/codehaus/jackson/map/ObjectMapper:<init>	()V
      //   194: aload 9
      //   196: ldc 101
      //   198: aload_1
      //   199: aload_3
      //   200: ldc 92
      //   202: invokevirtual 96	org/codehaus/jackson/map/ObjectMapper:readValue	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
      //   205: checkcast 92	org/codehaus/jackson/JsonNode
      //   208: invokevirtual 99	org/codehaus/jackson/node/ObjectNode:put	(Ljava/lang/String;Lorg/codehaus/jackson/JsonNode;)Lorg/codehaus/jackson/JsonNode;
      //   211: pop
      //   212: aload 9
      //   214: areturn
      //   215: astore_1
      //   216: new 103	java/lang/IllegalStateException
      //   219: dup
      //   220: aload_1
      //   221: invokespecial 106	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
      //   224: athrow
      //   225: astore_1
      //   226: new 103	java/lang/IllegalStateException
      //   229: dup
      //   230: aload_1
      //   231: invokespecial 106	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
      //   234: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	235	0	this	SerializableSerializer
      //   0	235	1	paramSerializerProvider	SerializerProvider
      //   0	235	2	paramType	Type
      //   20	180	3	localObject1	Object
      //   23	146	4	localObject2	Object
      //   27	119	5	localObject3	Object
      //   16	88	6	localObject4	Object
      //   8	120	7	localObject5	Object
      //   11	34	8	localObject6	Object
      //   4	209	9	localObjectNode	org.codehaus.jackson.node.ObjectNode
      // Exception table:
      //   from	to	target	type
      //   155	182	215	java/io/IOException
      //   186	212	225	java/io/IOException
    }
    
    public void serialize(JsonSerializable paramJsonSerializable, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonSerializable.serialize(paramJsonGenerator, paramSerializerProvider);
    }
    
    public final void serializeWithType(JsonSerializable paramJsonSerializable, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
      throws IOException, JsonGenerationException
    {
      if ((paramJsonSerializable instanceof JsonSerializableWithType)) {
        ((JsonSerializableWithType)paramJsonSerializable).serializeWithType(paramJsonGenerator, paramSerializerProvider, paramTypeSerializer);
      }
      for (;;)
      {
        return;
        serialize(paramJsonSerializable, paramJsonGenerator, paramSerializerProvider);
      }
    }
  }
  
  @JacksonStdImpl
  public static final class SerializableWithTypeSerializer
    extends SerializerBase<JsonSerializableWithType>
  {
    protected static final SerializableWithTypeSerializer instance = new SerializableWithTypeSerializer();
    
    private SerializableWithTypeSerializer()
    {
      super();
    }
    
    /* Error */
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
      throws org.codehaus.jackson.map.JsonMappingException
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 34	org/codehaus/jackson/map/ser/StdSerializers$SerializableWithTypeSerializer:createObjectNode	()Lorg/codehaus/jackson/node/ObjectNode;
      //   4: astore 9
      //   6: ldc 36
      //   8: astore 7
      //   10: aconst_null
      //   11: astore 8
      //   13: aconst_null
      //   14: astore_1
      //   15: aconst_null
      //   16: astore 6
      //   18: aload 6
      //   20: astore 4
      //   22: aload 8
      //   24: astore_3
      //   25: aload 7
      //   27: astore 5
      //   29: aload_2
      //   30: ifnull +108 -> 138
      //   33: aload_2
      //   34: invokestatic 42	org/codehaus/jackson/map/type/TypeFactory:rawClass	(Ljava/lang/reflect/Type;)Ljava/lang/Class;
      //   37: astore_2
      //   38: aload 6
      //   40: astore 4
      //   42: aload 8
      //   44: astore_3
      //   45: aload 7
      //   47: astore 5
      //   49: aload_2
      //   50: ldc 44
      //   52: invokevirtual 50	java/lang/Class:isAnnotationPresent	(Ljava/lang/Class;)Z
      //   55: ifeq +83 -> 138
      //   58: aload_2
      //   59: ldc 44
      //   61: invokevirtual 54	java/lang/Class:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
      //   64: checkcast 44	org/codehaus/jackson/schema/JsonSerializableSchema
      //   67: astore 7
      //   69: aload 7
      //   71: invokeinterface 58 1 0
      //   76: astore_2
      //   77: ldc 60
      //   79: aload 7
      //   81: invokeinterface 63 1 0
      //   86: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   89: ifne +11 -> 100
      //   92: aload 7
      //   94: invokeinterface 63 1 0
      //   99: astore_1
      //   100: aload 6
      //   102: astore 4
      //   104: aload_1
      //   105: astore_3
      //   106: aload_2
      //   107: astore 5
      //   109: ldc 60
      //   111: aload 7
      //   113: invokeinterface 72 1 0
      //   118: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   121: ifne +17 -> 138
      //   124: aload 7
      //   126: invokeinterface 72 1 0
      //   131: astore 4
      //   133: aload_2
      //   134: astore 5
      //   136: aload_1
      //   137: astore_3
      //   138: aload 9
      //   140: ldc 74
      //   142: aload 5
      //   144: invokevirtual 80	org/codehaus/jackson/node/ObjectNode:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   147: aload_3
      //   148: ifnull +29 -> 177
      //   151: new 82	org/codehaus/jackson/map/ObjectMapper
      //   154: astore_1
      //   155: aload_1
      //   156: invokespecial 83	org/codehaus/jackson/map/ObjectMapper:<init>	()V
      //   159: aload 9
      //   161: ldc 85
      //   163: aload_1
      //   164: aload_3
      //   165: ldc 87
      //   167: invokevirtual 91	org/codehaus/jackson/map/ObjectMapper:readValue	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
      //   170: checkcast 87	org/codehaus/jackson/JsonNode
      //   173: invokevirtual 94	org/codehaus/jackson/node/ObjectNode:put	(Ljava/lang/String;Lorg/codehaus/jackson/JsonNode;)Lorg/codehaus/jackson/JsonNode;
      //   176: pop
      //   177: aload 4
      //   179: ifnull +30 -> 209
      //   182: new 82	org/codehaus/jackson/map/ObjectMapper
      //   185: astore_1
      //   186: aload_1
      //   187: invokespecial 83	org/codehaus/jackson/map/ObjectMapper:<init>	()V
      //   190: aload 9
      //   192: ldc 96
      //   194: aload_1
      //   195: aload 4
      //   197: ldc 87
      //   199: invokevirtual 91	org/codehaus/jackson/map/ObjectMapper:readValue	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
      //   202: checkcast 87	org/codehaus/jackson/JsonNode
      //   205: invokevirtual 94	org/codehaus/jackson/node/ObjectNode:put	(Ljava/lang/String;Lorg/codehaus/jackson/JsonNode;)Lorg/codehaus/jackson/JsonNode;
      //   208: pop
      //   209: aload 9
      //   211: areturn
      //   212: astore_1
      //   213: new 98	java/lang/IllegalStateException
      //   216: dup
      //   217: aload_1
      //   218: invokespecial 101	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
      //   221: athrow
      //   222: astore_1
      //   223: new 98	java/lang/IllegalStateException
      //   226: dup
      //   227: aload_1
      //   228: invokespecial 101	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
      //   231: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	232	0	this	SerializableWithTypeSerializer
      //   0	232	1	paramSerializerProvider	SerializerProvider
      //   0	232	2	paramType	Type
      //   24	141	3	localObject1	Object
      //   20	176	4	localObject2	Object
      //   27	116	5	localObject3	Object
      //   16	85	6	localObject4	Object
      //   8	117	7	localObject5	Object
      //   11	32	8	localObject6	Object
      //   4	206	9	localObjectNode	org.codehaus.jackson.node.ObjectNode
      // Exception table:
      //   from	to	target	type
      //   151	177	212	java/io/IOException
      //   182	209	222	java/io/IOException
    }
    
    public void serialize(JsonSerializableWithType paramJsonSerializableWithType, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonSerializableWithType.serialize(paramJsonGenerator, paramSerializerProvider);
    }
    
    public final void serializeWithType(JsonSerializableWithType paramJsonSerializableWithType, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
      throws IOException, JsonGenerationException
    {
      paramJsonSerializableWithType.serializeWithType(paramJsonGenerator, paramSerializerProvider, paramTypeSerializer);
    }
  }
  
  @JacksonStdImpl
  public static final class SqlDateSerializer
    extends ScalarSerializerBase<java.sql.Date>
  {
    public SqlDateSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("string", true);
    }
    
    public void serialize(java.sql.Date paramDate, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeString(paramDate.toString());
    }
  }
  
  @JacksonStdImpl
  public static final class SqlTimeSerializer
    extends ScalarSerializerBase<Time>
  {
    public SqlTimeSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("string", true);
    }
    
    public void serialize(Time paramTime, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeString(paramTime.toString());
    }
  }
  
  @JacksonStdImpl
  public static final class StringSerializer
    extends StdSerializers.NonTypedScalarSerializer<String>
  {
    public StringSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("string", true);
    }
    
    public void serialize(String paramString, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeString(paramString);
    }
  }
  
  @JacksonStdImpl
  public static final class TokenBufferSerializer
    extends SerializerBase<TokenBuffer>
  {
    public TokenBufferSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("any", true);
    }
    
    public void serialize(TokenBuffer paramTokenBuffer, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramTokenBuffer.serialize(paramJsonGenerator);
    }
    
    public final void serializeWithType(TokenBuffer paramTokenBuffer, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
      throws IOException, JsonGenerationException
    {
      paramTypeSerializer.writeTypePrefixForScalar(paramTokenBuffer, paramJsonGenerator);
      serialize(paramTokenBuffer, paramJsonGenerator, paramSerializerProvider);
      paramTypeSerializer.writeTypeSuffixForScalar(paramTokenBuffer, paramJsonGenerator);
    }
  }
  
  @JacksonStdImpl
  public static final class UtilDateSerializer
    extends ScalarSerializerBase<java.util.Date>
  {
    public static final UtilDateSerializer instance = new UtilDateSerializer();
    
    public UtilDateSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {}
      for (paramSerializerProvider = "number";; paramSerializerProvider = "string") {
        return createSchemaNode(paramSerializerProvider, true);
      }
    }
    
    public void serialize(java.util.Date paramDate, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramSerializerProvider.defaultSerializeDateValue(paramDate, paramJsonGenerator);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\StdSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */