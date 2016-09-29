package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.HashMap;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ArrayBuilders.BooleanBuilder;
import org.codehaus.jackson.map.util.ArrayBuilders.ByteBuilder;
import org.codehaus.jackson.map.util.ArrayBuilders.DoubleBuilder;
import org.codehaus.jackson.map.util.ArrayBuilders.FloatBuilder;
import org.codehaus.jackson.map.util.ArrayBuilders.IntBuilder;
import org.codehaus.jackson.map.util.ArrayBuilders.LongBuilder;
import org.codehaus.jackson.map.util.ArrayBuilders.ShortBuilder;
import org.codehaus.jackson.map.util.ObjectBuffer;
import org.codehaus.jackson.type.JavaType;

public class ArrayDeserializers
{
  static final ArrayDeserializers instance = new ArrayDeserializers();
  HashMap<JavaType, JsonDeserializer<Object>> _allDeserializers = new HashMap();
  
  private ArrayDeserializers()
  {
    add(Boolean.TYPE, new BooleanDeser());
    add(Byte.TYPE, new ByteDeser());
    add(Short.TYPE, new ShortDeser());
    add(Integer.TYPE, new IntDeser());
    add(Long.TYPE, new LongDeser());
    add(Float.TYPE, new FloatDeser());
    add(Double.TYPE, new DoubleDeser());
    add(String.class, new StringDeser());
    add(Character.TYPE, new CharDeser());
  }
  
  private void add(Class<?> paramClass, JsonDeserializer<?> paramJsonDeserializer)
  {
    this._allDeserializers.put(TypeFactory.defaultInstance().constructType(paramClass), paramJsonDeserializer);
  }
  
  public static HashMap<JavaType, JsonDeserializer<Object>> getAll()
  {
    return instance._allDeserializers;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
  
  static abstract class ArrayDeser<T>
    extends StdDeserializer<T>
  {
    protected ArrayDeser(Class<T> paramClass)
    {
      super();
    }
    
    public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  static final class BooleanDeser
    extends ArrayDeserializers.ArrayDeser<boolean[]>
  {
    public BooleanDeser()
    {
      super();
    }
    
    private final boolean[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new boolean[] { _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public boolean[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {}
      ArrayBuilders.BooleanBuilder localBooleanBuilder;
      Object localObject1;
      int i;
      for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (boolean[])localBooleanBuilder.completeAndClearBuffer(localObject1, i))
      {
        return paramJsonParser;
        localBooleanBuilder = paramDeserializationContext.getArrayBuilders().getBooleanBuilder();
        localObject1 = (boolean[])localBooleanBuilder.resetAndStart();
        i = 0;
        while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          boolean bool = _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext);
          Object localObject2 = localObject1;
          int j = i;
          if (i >= localObject1.length)
          {
            localObject2 = (boolean[])localBooleanBuilder.appendCompletedChunk(localObject1, i);
            j = 0;
          }
          localObject2[j] = bool;
          i = j + 1;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class ByteDeser
    extends ArrayDeserializers.ArrayDeser<byte[]>
  {
    public ByteDeser()
    {
      super();
    }
    
    private final byte[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      int j;
      if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
        j = paramJsonParser.getByteValue();
      }
      for (int i = j;; i = j)
      {
        return new byte[] { i };
        if (localJsonToken != JsonToken.VALUE_NULL) {
          throw paramDeserializationContext.mappingException(this._valueClass.getComponentType());
        }
        j = 0;
      }
    }
    
    public byte[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      Object localObject1 = paramJsonParser.getCurrentToken();
      if (localObject1 == JsonToken.VALUE_STRING) {
        paramJsonParser = paramJsonParser.getBinaryValue(paramDeserializationContext.getBase64Variant());
      }
      for (;;)
      {
        return paramJsonParser;
        if (localObject1 == JsonToken.VALUE_EMBEDDED_OBJECT)
        {
          localObject1 = paramJsonParser.getEmbeddedObject();
          if (localObject1 == null)
          {
            paramJsonParser = null;
            continue;
          }
          if ((localObject1 instanceof byte[]))
          {
            paramJsonParser = (byte[])localObject1;
            continue;
          }
        }
        if (!paramJsonParser.isExpectedStartArrayToken())
        {
          paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);
        }
        else
        {
          ArrayBuilders.ByteBuilder localByteBuilder = paramDeserializationContext.getArrayBuilders().getByteBuilder();
          localObject1 = (byte[])localByteBuilder.resetAndStart();
          int i = 0;
          Object localObject2 = paramJsonParser.nextToken();
          if (localObject2 != JsonToken.END_ARRAY)
          {
            if ((localObject2 == JsonToken.VALUE_NUMBER_INT) || (localObject2 == JsonToken.VALUE_NUMBER_FLOAT)) {}
            for (int j = paramJsonParser.getByteValue();; j = 0)
            {
              localObject2 = localObject1;
              int k = i;
              if (i >= localObject1.length)
              {
                localObject2 = (byte[])localByteBuilder.appendCompletedChunk(localObject1, i);
                k = 0;
              }
              localObject2[k] = ((byte)j);
              i = k + 1;
              localObject1 = localObject2;
              break;
              if (localObject2 != JsonToken.VALUE_NULL) {
                throw paramDeserializationContext.mappingException(this._valueClass.getComponentType());
              }
            }
          }
          paramJsonParser = (byte[])localByteBuilder.completeAndClearBuffer(localObject1, i);
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class CharDeser
    extends ArrayDeserializers.ArrayDeser<char[]>
  {
    public CharDeser()
    {
      super();
    }
    
    public char[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      Object localObject1 = paramJsonParser.getCurrentToken();
      if (localObject1 == JsonToken.VALUE_STRING)
      {
        paramDeserializationContext = paramJsonParser.getTextCharacters();
        int i = paramJsonParser.getTextOffset();
        int j = paramJsonParser.getTextLength();
        paramJsonParser = new char[j];
        System.arraycopy(paramDeserializationContext, i, paramJsonParser, 0, j);
      }
      for (;;)
      {
        return paramJsonParser;
        if (paramJsonParser.isExpectedStartArrayToken())
        {
          localObject1 = new StringBuilder(64);
          for (;;)
          {
            Object localObject2 = paramJsonParser.nextToken();
            if (localObject2 == JsonToken.END_ARRAY) {
              break;
            }
            if (localObject2 != JsonToken.VALUE_STRING) {
              throw paramDeserializationContext.mappingException(Character.TYPE);
            }
            localObject2 = paramJsonParser.getText();
            if (((String)localObject2).length() != 1) {
              throw JsonMappingException.from(paramJsonParser, "Can not convert a JSON String of length " + ((String)localObject2).length() + " into a char element of char array");
            }
            ((StringBuilder)localObject1).append(((String)localObject2).charAt(0));
          }
          paramJsonParser = ((StringBuilder)localObject1).toString().toCharArray();
        }
        else
        {
          if (localObject1 != JsonToken.VALUE_EMBEDDED_OBJECT) {
            break;
          }
          paramJsonParser = paramJsonParser.getEmbeddedObject();
          if (paramJsonParser == null)
          {
            paramJsonParser = null;
          }
          else if ((paramJsonParser instanceof char[]))
          {
            paramJsonParser = (char[])paramJsonParser;
          }
          else if ((paramJsonParser instanceof String))
          {
            paramJsonParser = ((String)paramJsonParser).toCharArray();
          }
          else
          {
            if (!(paramJsonParser instanceof byte[])) {
              break;
            }
            paramJsonParser = Base64Variants.getDefaultVariant().encode((byte[])paramJsonParser, false).toCharArray();
          }
        }
      }
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
  }
  
  @JacksonStdImpl
  static final class DoubleDeser
    extends ArrayDeserializers.ArrayDeser<double[]>
  {
    public DoubleDeser()
    {
      super();
    }
    
    private final double[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new double[] { _parseDoublePrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public double[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {}
      ArrayBuilders.DoubleBuilder localDoubleBuilder;
      Object localObject2;
      int i;
      for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (double[])localDoubleBuilder.completeAndClearBuffer(localObject2, i))
      {
        return paramJsonParser;
        localDoubleBuilder = paramDeserializationContext.getArrayBuilders().getDoubleBuilder();
        localObject2 = (double[])localDoubleBuilder.resetAndStart();
        i = 0;
        while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          double d = _parseDoublePrimitive(paramJsonParser, paramDeserializationContext);
          Object localObject1 = localObject2;
          int j = i;
          if (i >= localObject2.length)
          {
            localObject1 = (double[])localDoubleBuilder.appendCompletedChunk(localObject2, i);
            j = 0;
          }
          localObject1[j] = d;
          i = j + 1;
          localObject2 = localObject1;
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class FloatDeser
    extends ArrayDeserializers.ArrayDeser<float[]>
  {
    public FloatDeser()
    {
      super();
    }
    
    private final float[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new float[] { _parseFloatPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public float[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {}
      ArrayBuilders.FloatBuilder localFloatBuilder;
      Object localObject2;
      int i;
      for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (float[])localFloatBuilder.completeAndClearBuffer(localObject2, i))
      {
        return paramJsonParser;
        localFloatBuilder = paramDeserializationContext.getArrayBuilders().getFloatBuilder();
        localObject2 = (float[])localFloatBuilder.resetAndStart();
        i = 0;
        while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          float f = _parseFloatPrimitive(paramJsonParser, paramDeserializationContext);
          Object localObject1 = localObject2;
          int j = i;
          if (i >= localObject2.length)
          {
            localObject1 = (float[])localFloatBuilder.appendCompletedChunk(localObject2, i);
            j = 0;
          }
          localObject1[j] = f;
          i = j + 1;
          localObject2 = localObject1;
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class IntDeser
    extends ArrayDeserializers.ArrayDeser<int[]>
  {
    public IntDeser()
    {
      super();
    }
    
    private final int[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new int[] { _parseIntPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public int[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {}
      ArrayBuilders.IntBuilder localIntBuilder;
      Object localObject1;
      int i;
      for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (int[])localIntBuilder.completeAndClearBuffer(localObject1, i))
      {
        return paramJsonParser;
        localIntBuilder = paramDeserializationContext.getArrayBuilders().getIntBuilder();
        localObject1 = (int[])localIntBuilder.resetAndStart();
        i = 0;
        while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          int k = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
          Object localObject2 = localObject1;
          int j = i;
          if (i >= localObject1.length)
          {
            localObject2 = (int[])localIntBuilder.appendCompletedChunk(localObject1, i);
            j = 0;
          }
          localObject2[j] = k;
          i = j + 1;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class LongDeser
    extends ArrayDeserializers.ArrayDeser<long[]>
  {
    public LongDeser()
    {
      super();
    }
    
    private final long[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new long[] { _parseLongPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public long[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {}
      ArrayBuilders.LongBuilder localLongBuilder;
      Object localObject2;
      int i;
      for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (long[])localLongBuilder.completeAndClearBuffer(localObject2, i))
      {
        return paramJsonParser;
        localLongBuilder = paramDeserializationContext.getArrayBuilders().getLongBuilder();
        localObject2 = (long[])localLongBuilder.resetAndStart();
        i = 0;
        while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          long l = _parseLongPrimitive(paramJsonParser, paramDeserializationContext);
          Object localObject1 = localObject2;
          int j = i;
          if (i >= localObject2.length)
          {
            localObject1 = (long[])localLongBuilder.appendCompletedChunk(localObject2, i);
            j = 0;
          }
          localObject1[j] = l;
          i = j + 1;
          localObject2 = localObject1;
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class ShortDeser
    extends ArrayDeserializers.ArrayDeser<short[]>
  {
    public ShortDeser()
    {
      super();
    }
    
    private final short[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      return new short[] { _parseShortPrimitive(paramJsonParser, paramDeserializationContext) };
    }
    
    public short[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {}
      ArrayBuilders.ShortBuilder localShortBuilder;
      Object localObject2;
      int i;
      for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (short[])localShortBuilder.completeAndClearBuffer(localObject2, i))
      {
        return paramJsonParser;
        localShortBuilder = paramDeserializationContext.getArrayBuilders().getShortBuilder();
        localObject2 = (short[])localShortBuilder.resetAndStart();
        i = 0;
        while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          int k = _parseShortPrimitive(paramJsonParser, paramDeserializationContext);
          Object localObject1 = localObject2;
          int j = i;
          if (i >= localObject2.length)
          {
            localObject1 = (short[])localShortBuilder.appendCompletedChunk(localObject2, i);
            j = 0;
          }
          localObject1[j] = ((short)k);
          i = j + 1;
          localObject2 = localObject1;
        }
      }
    }
  }
  
  @JacksonStdImpl
  static final class StringDeser
    extends ArrayDeserializers.ArrayDeser<String[]>
  {
    public StringDeser()
    {
      super();
    }
    
    private final String[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
        throw paramDeserializationContext.mappingException(this._valueClass);
      }
      if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {}
      for (paramJsonParser = null;; paramJsonParser = paramJsonParser.getText()) {
        return new String[] { paramJsonParser };
      }
    }
    
    public String[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (!paramJsonParser.isExpectedStartArrayToken()) {
        paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      for (;;)
      {
        return paramJsonParser;
        ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
        Object localObject1 = localObjectBuffer.resetAndStart();
        int i = 0;
        Object localObject2 = paramJsonParser.nextToken();
        if (localObject2 != JsonToken.END_ARRAY)
        {
          if (localObject2 == JsonToken.VALUE_NULL) {}
          for (localObject2 = null;; localObject2 = paramJsonParser.getText())
          {
            Object localObject3 = localObject1;
            int j = i;
            if (i >= localObject1.length)
            {
              localObject3 = localObjectBuffer.appendCompletedChunk((Object[])localObject1);
              j = 0;
            }
            localObject3[j] = localObject2;
            i = j + 1;
            localObject1 = localObject3;
            break;
          }
        }
        paramJsonParser = (String[])localObjectBuffer.completeAndClearBuffer((Object[])localObject1, i, String.class);
        paramDeserializationContext.returnObjectBuffer(localObjectBuffer);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\ArrayDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */