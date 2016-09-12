package org.codehaus.jackson.map.ser;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class StdSerializers$SerializableWithTypeSerializer
  extends SerializerBase<JsonSerializableWithType>
{
  protected static final SerializableWithTypeSerializer instance = new SerializableWithTypeSerializer();
  
  private StdSerializers$SerializableWithTypeSerializer()
  {
    super(JsonSerializableWithType.class);
  }
  
  /* Error */
  public org.codehaus.jackson.JsonNode getSchema(SerializerProvider paramSerializerProvider, java.lang.reflect.Type paramType)
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
    //   0	232	2	paramType	java.lang.reflect.Type
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\StdSerializers$SerializableWithTypeSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */