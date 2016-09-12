package org.codehaus.jackson.map.ser;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializable;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class StdSerializers$SerializableSerializer
  extends SerializerBase<JsonSerializable>
{
  protected static final SerializableSerializer instance = new SerializableSerializer();
  
  private StdSerializers$SerializableSerializer()
  {
    super(JsonSerializable.class);
  }
  
  /* Error */
  public org.codehaus.jackson.JsonNode getSchema(SerializerProvider paramSerializerProvider, java.lang.reflect.Type paramType)
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
    //   0	235	2	paramType	java.lang.reflect.Type
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\StdSerializers$SerializableSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */