package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.NumberInput;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.TokenBuffer;

public abstract class StdDeserializer<T>
  extends JsonDeserializer<T>
{
  protected final Class<?> _valueClass;
  
  protected StdDeserializer(Class<?> paramClass)
  {
    this._valueClass = paramClass;
  }
  
  protected StdDeserializer(JavaType paramJavaType)
  {
    if (paramJavaType == null) {}
    for (paramJavaType = null;; paramJavaType = paramJavaType.getRawClass())
    {
      this._valueClass = paramJavaType;
      return;
    }
  }
  
  protected static final double parseDouble(String paramString)
    throws NumberFormatException
  {
    if ("2.2250738585072012e-308".equals(paramString)) {}
    for (double d = 2.2250738585072014E-308D;; d = Double.parseDouble(paramString)) {
      return d;
    }
  }
  
  protected final Boolean _parseBoolean(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_TRUE) {
      paramJsonParser = Boolean.TRUE;
    }
    for (;;)
    {
      return paramJsonParser;
      if (localJsonToken == JsonToken.VALUE_FALSE)
      {
        paramJsonParser = Boolean.FALSE;
      }
      else if (localJsonToken == JsonToken.VALUE_NULL)
      {
        paramJsonParser = null;
      }
      else if (localJsonToken == JsonToken.VALUE_NUMBER_INT)
      {
        if (paramJsonParser.getIntValue() == 0) {
          paramJsonParser = Boolean.FALSE;
        } else {
          paramJsonParser = Boolean.TRUE;
        }
      }
      else
      {
        if (localJsonToken != JsonToken.VALUE_STRING) {
          break label137;
        }
        paramJsonParser = paramJsonParser.getText().trim();
        if ("true".equals(paramJsonParser))
        {
          paramJsonParser = Boolean.TRUE;
        }
        else
        {
          if ((!"false".equals(paramJsonParser)) && (paramJsonParser.length() != 0)) {
            break;
          }
          paramJsonParser = Boolean.FALSE;
        }
      }
    }
    throw paramDeserializationContext.weirdStringException(this._valueClass, "only \"true\" or \"false\" recognized");
    label137:
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  protected final boolean _parseBooleanPrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    boolean bool = true;
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_TRUE) {}
    for (;;)
    {
      return bool;
      if (localJsonToken == JsonToken.VALUE_FALSE)
      {
        bool = false;
      }
      else if (localJsonToken == JsonToken.VALUE_NULL)
      {
        bool = false;
      }
      else if (localJsonToken == JsonToken.VALUE_NUMBER_INT)
      {
        if (paramJsonParser.getIntValue() == 0) {
          bool = false;
        }
      }
      else
      {
        if (localJsonToken != JsonToken.VALUE_STRING) {
          break label126;
        }
        paramJsonParser = paramJsonParser.getText().trim();
        if (!"true".equals(paramJsonParser))
        {
          if ((!"false".equals(paramJsonParser)) && (paramJsonParser.length() != 0)) {
            break;
          }
          bool = Boolean.FALSE.booleanValue();
        }
      }
    }
    throw paramDeserializationContext.weirdStringException(this._valueClass, "only \"true\" or \"false\" recognized");
    label126:
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  protected java.util.Date _parseDate(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    try
    {
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        paramJsonParser = new java.util.Date(paramJsonParser.getLongValue());
      }
      for (;;)
      {
        return paramJsonParser;
        if (localJsonToken != JsonToken.VALUE_STRING) {
          break;
        }
        paramJsonParser = paramJsonParser.getText().trim();
        if (paramJsonParser.length() == 0) {
          paramJsonParser = null;
        } else {
          paramJsonParser = paramDeserializationContext.parseDate(paramJsonParser);
        }
      }
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    catch (IllegalArgumentException paramJsonParser)
    {
      throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid representation (error: " + paramJsonParser.getMessage() + ")");
    }
  }
  
  protected final Double _parseDouble(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject1 = null;
    Object localObject2 = paramJsonParser.getCurrentToken();
    if ((localObject2 == JsonToken.VALUE_NUMBER_INT) || (localObject2 == JsonToken.VALUE_NUMBER_FLOAT)) {
      paramJsonParser = Double.valueOf(paramJsonParser.getDoubleValue());
    }
    do
    {
      for (;;)
      {
        return paramJsonParser;
        if (localObject2 != JsonToken.VALUE_STRING) {
          break;
        }
        localObject2 = paramJsonParser.getText().trim();
        paramJsonParser = (JsonParser)localObject1;
        if (((String)localObject2).length() != 0)
        {
          switch (((String)localObject2).charAt(0))
          {
          }
          do
          {
            do
            {
              do
              {
                try
                {
                  double d = parseDouble((String)localObject2);
                  paramJsonParser = Double.valueOf(d);
                }
                catch (IllegalArgumentException paramJsonParser)
                {
                  throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid Double value");
                }
              } while ((!"Infinity".equals(localObject2)) && (!"INF".equals(localObject2)));
              paramJsonParser = Double.valueOf(Double.POSITIVE_INFINITY);
              break;
            } while (!"NaN".equals(localObject2));
            paramJsonParser = Double.valueOf(NaN.0D);
            break;
          } while ((!"-Infinity".equals(localObject2)) && (!"-INF".equals(localObject2)));
          paramJsonParser = Double.valueOf(Double.NEGATIVE_INFINITY);
        }
      }
      paramJsonParser = (JsonParser)localObject1;
    } while (localObject2 == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  protected final double _parseDoublePrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    double d = 0.0D;
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      d = paramJsonParser.getDoubleValue();
    }
    do
    {
      for (;;)
      {
        return d;
        if (localJsonToken != JsonToken.VALUE_STRING) {
          break;
        }
        paramJsonParser = paramJsonParser.getText().trim();
        if (paramJsonParser.length() != 0)
        {
          switch (paramJsonParser.charAt(0))
          {
          }
          do
          {
            do
            {
              do
              {
                try
                {
                  d = parseDouble(paramJsonParser);
                }
                catch (IllegalArgumentException paramJsonParser)
                {
                  throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid double value");
                }
              } while ((!"Infinity".equals(paramJsonParser)) && (!"INF".equals(paramJsonParser)));
              d = Double.POSITIVE_INFINITY;
              break;
            } while (!"NaN".equals(paramJsonParser));
            d = NaN.0D;
            break;
          } while ((!"-Infinity".equals(paramJsonParser)) && (!"-INF".equals(paramJsonParser)));
          d = Double.NEGATIVE_INFINITY;
        }
      }
    } while (localJsonToken == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  protected final Float _parseFloat(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject1 = null;
    Object localObject2 = paramJsonParser.getCurrentToken();
    if ((localObject2 == JsonToken.VALUE_NUMBER_INT) || (localObject2 == JsonToken.VALUE_NUMBER_FLOAT)) {
      paramJsonParser = Float.valueOf(paramJsonParser.getFloatValue());
    }
    do
    {
      for (;;)
      {
        return paramJsonParser;
        if (localObject2 != JsonToken.VALUE_STRING) {
          break;
        }
        localObject2 = paramJsonParser.getText().trim();
        paramJsonParser = (JsonParser)localObject1;
        if (((String)localObject2).length() != 0)
        {
          switch (((String)localObject2).charAt(0))
          {
          }
          do
          {
            do
            {
              do
              {
                try
                {
                  float f = Float.parseFloat((String)localObject2);
                  paramJsonParser = Float.valueOf(f);
                }
                catch (IllegalArgumentException paramJsonParser)
                {
                  throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid Float value");
                }
              } while ((!"Infinity".equals(localObject2)) && (!"INF".equals(localObject2)));
              paramJsonParser = Float.valueOf(Float.POSITIVE_INFINITY);
              break;
            } while (!"NaN".equals(localObject2));
            paramJsonParser = Float.valueOf(NaN.0F);
            break;
          } while ((!"-Infinity".equals(localObject2)) && (!"-INF".equals(localObject2)));
          paramJsonParser = Float.valueOf(Float.NEGATIVE_INFINITY);
        }
      }
      paramJsonParser = (JsonParser)localObject1;
    } while (localObject2 == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  protected final float _parseFloatPrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    float f = 0.0F;
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      f = paramJsonParser.getFloatValue();
    }
    do
    {
      for (;;)
      {
        return f;
        if (localJsonToken != JsonToken.VALUE_STRING) {
          break;
        }
        paramJsonParser = paramJsonParser.getText().trim();
        if (paramJsonParser.length() != 0)
        {
          switch (paramJsonParser.charAt(0))
          {
          }
          do
          {
            do
            {
              do
              {
                try
                {
                  f = Float.parseFloat(paramJsonParser);
                }
                catch (IllegalArgumentException paramJsonParser)
                {
                  throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid float value");
                }
              } while ((!"Infinity".equals(paramJsonParser)) && (!"INF".equals(paramJsonParser)));
              f = Float.POSITIVE_INFINITY;
              break;
            } while (!"NaN".equals(paramJsonParser));
            f = NaN.0F;
            break;
          } while ((!"-Infinity".equals(paramJsonParser)) && (!"-INF".equals(paramJsonParser)));
          f = Float.NEGATIVE_INFINITY;
        }
      }
    } while (localJsonToken == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  protected final int _parseIntPrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    int i = 0;
    Object localObject = paramJsonParser.getCurrentToken();
    if ((localObject == JsonToken.VALUE_NUMBER_INT) || (localObject == JsonToken.VALUE_NUMBER_FLOAT)) {
      i = paramJsonParser.getIntValue();
    }
    label172:
    do
    {
      for (;;)
      {
        return i;
        if (localObject != JsonToken.VALUE_STRING) {
          break;
        }
        localObject = paramJsonParser.getText().trim();
        int j;
        long l;
        try
        {
          j = ((String)localObject).length();
          if (j <= 9) {
            break label172;
          }
          l = Long.parseLong((String)localObject);
          if ((l < -2147483648L) || (l > 2147483647L))
          {
            Class localClass = this._valueClass;
            paramJsonParser = new java/lang/StringBuilder;
            paramJsonParser.<init>();
            throw paramDeserializationContext.weirdStringException(localClass, "Overflow: numeric value (" + (String)localObject + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
          }
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid int value");
        }
        i = (int)l;
        continue;
        if (j != 0) {
          i = NumberInput.parseInt((String)localObject);
        }
      }
    } while (localObject == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  protected final Integer _parseInteger(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    StringBuilder localStringBuilder = null;
    Object localObject = paramJsonParser.getCurrentToken();
    if ((localObject == JsonToken.VALUE_NUMBER_INT) || (localObject == JsonToken.VALUE_NUMBER_FLOAT)) {
      paramJsonParser = Integer.valueOf(paramJsonParser.getIntValue());
    }
    label180:
    do
    {
      for (;;)
      {
        return paramJsonParser;
        if (localObject != JsonToken.VALUE_STRING) {
          break;
        }
        localObject = paramJsonParser.getText().trim();
        long l;
        try
        {
          i = ((String)localObject).length();
          if (i <= 9) {
            break label180;
          }
          l = Long.parseLong((String)localObject);
          if ((l < -2147483648L) || (l > 2147483647L))
          {
            paramJsonParser = this._valueClass;
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            throw paramDeserializationContext.weirdStringException(paramJsonParser, "Overflow: numeric value (" + (String)localObject + ") out of range of Integer (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
          }
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid Integer value");
        }
        int i = (int)l;
        paramJsonParser = Integer.valueOf(i);
        continue;
        paramJsonParser = localStringBuilder;
        if (i != 0)
        {
          i = NumberInput.parseInt((String)localObject);
          paramJsonParser = Integer.valueOf(i);
        }
      }
      paramJsonParser = localStringBuilder;
    } while (localObject == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  protected final Long _parseLong(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject1 = null;
    Object localObject2 = paramJsonParser.getCurrentToken();
    if ((localObject2 == JsonToken.VALUE_NUMBER_INT) || (localObject2 == JsonToken.VALUE_NUMBER_FLOAT)) {
      paramJsonParser = Long.valueOf(paramJsonParser.getLongValue());
    }
    do
    {
      for (;;)
      {
        return paramJsonParser;
        if (localObject2 == JsonToken.VALUE_STRING)
        {
          localObject2 = paramJsonParser.getText().trim();
          paramJsonParser = (JsonParser)localObject1;
          if (((String)localObject2).length() == 0) {
            continue;
          }
          try
          {
            long l = NumberInput.parseLong((String)localObject2);
            paramJsonParser = Long.valueOf(l);
          }
          catch (IllegalArgumentException paramJsonParser)
          {
            throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid Long value");
          }
        }
      }
      paramJsonParser = (JsonParser)localObject1;
    } while (localObject2 == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  protected final long _parseLongPrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    long l = 0L;
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      l = paramJsonParser.getLongValue();
    }
    do
    {
      for (;;)
      {
        return l;
        if (localJsonToken == JsonToken.VALUE_STRING)
        {
          paramJsonParser = paramJsonParser.getText().trim();
          if (paramJsonParser.length() == 0) {
            continue;
          }
          try
          {
            l = NumberInput.parseLong(paramJsonParser);
          }
          catch (IllegalArgumentException paramJsonParser)
          {
            throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid long value");
          }
        }
      }
    } while (localJsonToken == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  protected final Short _parseShort(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_NULL) {
      paramJsonParser = null;
    }
    for (;;)
    {
      return paramJsonParser;
      if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT))
      {
        paramJsonParser = Short.valueOf(paramJsonParser.getShortValue());
      }
      else
      {
        int i = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
        if ((i < 32768) || (i > 32767)) {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 16-bit value");
        }
        paramJsonParser = Short.valueOf((short)i);
      }
    }
  }
  
  protected final short _parseShortPrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    int i = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
    if ((i < 32768) || (i > 32767)) {
      throw paramDeserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 16-bit value");
    }
    return (short)i;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
  }
  
  protected JsonDeserializer<Object> findDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    return paramDeserializerProvider.findValueDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
  }
  
  public Class<?> getValueClass()
  {
    return this._valueClass;
  }
  
  public JavaType getValueType()
  {
    return null;
  }
  
  protected void handleUnknownProperty(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
    throws IOException, JsonProcessingException
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = getValueClass();
    }
    if (paramDeserializationContext.handleUnknownProperty(paramJsonParser, this, localObject, paramString)) {}
    for (;;)
    {
      return;
      reportUnknownProperty(paramDeserializationContext, localObject, paramString);
      paramJsonParser.skipChildren();
    }
  }
  
  protected boolean isDefaultSerializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    if ((paramJsonDeserializer != null) && (paramJsonDeserializer.getClass().getAnnotation(JacksonStdImpl.class) != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void reportUnknownProperty(DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
    throws IOException, JsonProcessingException
  {
    if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES)) {
      throw paramDeserializationContext.unknownFieldException(paramObject, paramString);
    }
  }
  
  public static final class AtomicBooleanDeserializer
    extends StdScalarDeserializer<AtomicBoolean>
  {
    public AtomicBooleanDeserializer()
    {
      super();
    }
    
    public AtomicBoolean deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return new AtomicBoolean(_parseBooleanPrimitive(paramJsonParser, paramDeserializationContext));
    }
  }
  
  public static class AtomicReferenceDeserializer
    extends StdScalarDeserializer<AtomicReference<?>>
    implements ResolvableDeserializer
  {
    protected final BeanProperty _property;
    protected final JavaType _referencedType;
    protected JsonDeserializer<?> _valueDeserializer;
    
    public AtomicReferenceDeserializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
    {
      super();
      this._referencedType = paramJavaType;
      this._property = paramBeanProperty;
    }
    
    public AtomicReference<?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return new AtomicReference(this._valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    
    public void resolve(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider)
      throws JsonMappingException
    {
      this._valueDeserializer = paramDeserializerProvider.findValueDeserializer(paramDeserializationConfig, this._referencedType, this._property);
    }
  }
  
  @JacksonStdImpl
  public static class BigDecimalDeserializer
    extends StdScalarDeserializer<BigDecimal>
  {
    public BigDecimalDeserializer()
    {
      super();
    }
    
    public BigDecimal deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
        paramJsonParser = paramJsonParser.getDecimalValue();
      }
      for (;;)
      {
        return paramJsonParser;
        if (localJsonToken == JsonToken.VALUE_STRING)
        {
          paramJsonParser = paramJsonParser.getText().trim();
          if (paramJsonParser.length() == 0)
          {
            paramJsonParser = null;
            continue;
          }
          try
          {
            paramJsonParser = new BigDecimal(paramJsonParser);
          }
          catch (IllegalArgumentException paramJsonParser)
          {
            throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid representation");
          }
        }
      }
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
  }
  
  @JacksonStdImpl
  public static class BigIntegerDeserializer
    extends StdScalarDeserializer<BigInteger>
  {
    public BigIntegerDeserializer()
    {
      super();
    }
    
    public BigInteger deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        switch (StdDeserializer.1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
        {
        default: 
          paramJsonParser = paramJsonParser.getText().trim();
          if (paramJsonParser.length() == 0) {
            paramJsonParser = null;
          }
          break;
        }
      }
      for (;;)
      {
        return paramJsonParser;
        paramJsonParser = BigInteger.valueOf(paramJsonParser.getLongValue());
        continue;
        if (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)
        {
          paramJsonParser = paramJsonParser.getDecimalValue().toBigInteger();
          continue;
        }
        if (localJsonToken == JsonToken.VALUE_STRING) {
          break;
        }
        throw paramDeserializationContext.mappingException(this._valueClass);
        try
        {
          paramJsonParser = new BigInteger(paramJsonParser);
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid representation");
        }
      }
    }
  }
  
  @JacksonStdImpl
  public static final class BooleanDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Boolean>
  {
    public BooleanDeserializer(Class<Boolean> paramClass, Boolean paramBoolean)
    {
      super(paramBoolean);
    }
    
    public Boolean deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseBoolean(paramJsonParser, paramDeserializationContext);
    }
    
    public Boolean deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      return _parseBoolean(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static final class ByteDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Byte>
  {
    public ByteDeserializer(Class<Byte> paramClass, Byte paramByte)
    {
      super(paramByte);
    }
    
    public Byte deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      int i = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
      if ((i < -128) || (i > 127)) {
        throw paramDeserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 8-bit value");
      }
      return Byte.valueOf((byte)i);
    }
  }
  
  @JacksonStdImpl
  public static class CalendarDeserializer
    extends StdScalarDeserializer<Calendar>
  {
    Class<? extends Calendar> _calendarClass;
    
    public CalendarDeserializer()
    {
      this(null);
    }
    
    public CalendarDeserializer(Class<? extends Calendar> paramClass)
    {
      super();
      this._calendarClass = paramClass;
    }
    
    public Calendar deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      java.util.Date localDate = _parseDate(paramJsonParser, paramDeserializationContext);
      if (localDate == null) {
        paramJsonParser = null;
      }
      for (;;)
      {
        return paramJsonParser;
        if (this._calendarClass == null)
        {
          paramJsonParser = paramDeserializationContext.constructCalendar(localDate);
          continue;
        }
        try
        {
          paramJsonParser = (Calendar)this._calendarClass.newInstance();
          paramJsonParser.setTimeInMillis(localDate.getTime());
        }
        catch (Exception paramJsonParser)
        {
          throw paramDeserializationContext.instantiationException(this._calendarClass, paramJsonParser);
        }
      }
    }
  }
  
  @JacksonStdImpl
  public static final class CharacterDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Character>
  {
    public CharacterDeserializer(Class<Character> paramClass, Character paramCharacter)
    {
      super(paramCharacter);
    }
    
    public Character deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      int i;
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT)
      {
        i = paramJsonParser.getIntValue();
        if ((i < 0) || (i > 65535)) {}
      }
      else
      {
        for (paramJsonParser = Character.valueOf((char)i);; paramJsonParser = Character.valueOf(paramJsonParser.charAt(0)))
        {
          return paramJsonParser;
          if (localJsonToken != JsonToken.VALUE_STRING) {
            break;
          }
          paramJsonParser = paramJsonParser.getText();
          if (paramJsonParser.length() != 1) {
            break;
          }
        }
      }
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
  }
  
  @JacksonStdImpl
  public static final class ClassDeserializer
    extends StdScalarDeserializer<Class<?>>
  {
    public ClassDeserializer()
    {
      super();
    }
    
    public Class<?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
        try
        {
          paramJsonParser = Class.forName(paramJsonParser.getText());
          return paramJsonParser;
        }
        catch (ClassNotFoundException paramJsonParser)
        {
          throw paramDeserializationContext.instantiationException(this._valueClass, paramJsonParser);
        }
      }
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
  }
  
  @JacksonStdImpl
  public static final class DoubleDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Double>
  {
    public DoubleDeserializer(Class<Double> paramClass, Double paramDouble)
    {
      super(paramDouble);
    }
    
    public Double deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseDouble(paramJsonParser, paramDeserializationContext);
    }
    
    public Double deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      return _parseDouble(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static final class FloatDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Float>
  {
    public FloatDeserializer(Class<Float> paramClass, Float paramFloat)
    {
      super(paramFloat);
    }
    
    public Float deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseFloat(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static final class IntegerDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Integer>
  {
    public IntegerDeserializer(Class<Integer> paramClass, Integer paramInteger)
    {
      super(paramInteger);
    }
    
    public Integer deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseInteger(paramJsonParser, paramDeserializationContext);
    }
    
    public Integer deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      return _parseInteger(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static final class LongDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Long>
  {
    public LongDeserializer(Class<Long> paramClass, Long paramLong)
    {
      super(paramLong);
    }
    
    public Long deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseLong(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static final class NumberDeserializer
    extends StdScalarDeserializer<Number>
  {
    public NumberDeserializer()
    {
      super();
    }
    
    public Number deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) {
          paramJsonParser = paramJsonParser.getBigIntegerValue();
        }
      }
      for (;;)
      {
        return paramJsonParser;
        paramJsonParser = paramJsonParser.getNumberValue();
        continue;
        if (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)
        {
          if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            paramJsonParser = paramJsonParser.getDecimalValue();
          } else {
            paramJsonParser = Double.valueOf(paramJsonParser.getDoubleValue());
          }
        }
        else
        {
          if (localJsonToken != JsonToken.VALUE_STRING) {
            break;
          }
          paramJsonParser = paramJsonParser.getText().trim();
          try
          {
            if (paramJsonParser.indexOf('.') < 0) {
              break label147;
            }
            if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) {
              paramJsonParser = new BigDecimal(paramJsonParser);
            }
          }
          catch (IllegalArgumentException paramJsonParser)
          {
            throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid number");
          }
          paramJsonParser = new Double(paramJsonParser);
          continue;
          label147:
          if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS))
          {
            paramJsonParser = new BigInteger(paramJsonParser);
          }
          else
          {
            long l = Long.parseLong(paramJsonParser);
            if ((l <= 2147483647L) && (l >= -2147483648L)) {
              paramJsonParser = Integer.valueOf((int)l);
            } else {
              paramJsonParser = Long.valueOf(l);
            }
          }
        }
      }
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    
    public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      switch (StdDeserializer.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
      {
      }
      for (paramJsonParser = paramTypeDeserializer.deserializeTypedFromScalar(paramJsonParser, paramDeserializationContext);; paramJsonParser = deserialize(paramJsonParser, paramDeserializationContext)) {
        return paramJsonParser;
      }
    }
  }
  
  protected static abstract class PrimitiveOrWrapperDeserializer<T>
    extends StdScalarDeserializer<T>
  {
    final T _nullValue;
    
    protected PrimitiveOrWrapperDeserializer(Class<T> paramClass, T paramT)
    {
      super();
      this._nullValue = paramT;
    }
    
    public final T getNullValue()
    {
      return (T)this._nullValue;
    }
  }
  
  @JacksonStdImpl
  public static final class ShortDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Short>
  {
    public ShortDeserializer(Class<Short> paramClass, Short paramShort)
    {
      super(paramShort);
    }
    
    public Short deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseShort(paramJsonParser, paramDeserializationContext);
    }
  }
  
  public static class SqlDateDeserializer
    extends StdScalarDeserializer<java.sql.Date>
  {
    public SqlDateDeserializer()
    {
      super();
    }
    
    public java.sql.Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      paramJsonParser = _parseDate(paramJsonParser, paramDeserializationContext);
      if (paramJsonParser == null) {}
      for (paramJsonParser = null;; paramJsonParser = new java.sql.Date(paramJsonParser.getTime())) {
        return paramJsonParser;
      }
    }
  }
  
  public static class StackTraceElementDeserializer
    extends StdScalarDeserializer<StackTraceElement>
  {
    public StackTraceElementDeserializer()
    {
      super();
    }
    
    public StackTraceElement deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (paramJsonParser.getCurrentToken() == JsonToken.START_OBJECT)
      {
        String str3 = "";
        String str1 = "";
        String str2 = "";
        int i = -1;
        for (;;)
        {
          JsonToken localJsonToken = paramJsonParser.nextValue();
          if (localJsonToken == JsonToken.END_OBJECT) {
            break;
          }
          String str4 = paramJsonParser.getCurrentName();
          if ("className".equals(str4)) {
            str3 = paramJsonParser.getText();
          } else if ("fileName".equals(str4)) {
            str2 = paramJsonParser.getText();
          } else if ("lineNumber".equals(str4))
          {
            if (localJsonToken.isNumeric()) {
              i = paramJsonParser.getIntValue();
            } else {
              throw JsonMappingException.from(paramJsonParser, "Non-numeric token (" + localJsonToken + ") for property 'lineNumber'");
            }
          }
          else if ("methodName".equals(str4)) {
            str1 = paramJsonParser.getText();
          } else if (!"nativeMethod".equals(str4)) {
            handleUnknownProperty(paramJsonParser, paramDeserializationContext, this._valueClass, str4);
          }
        }
        return new StackTraceElement(str3, str1, str2, i);
      }
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
  }
  
  @JacksonStdImpl
  public static final class StringDeserializer
    extends StdScalarDeserializer<String>
  {
    public StringDeserializer()
    {
      super();
    }
    
    public String deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if (localJsonToken == JsonToken.VALUE_STRING) {
        paramJsonParser = paramJsonParser.getText();
      }
      for (;;)
      {
        return paramJsonParser;
        if (localJsonToken == JsonToken.VALUE_EMBEDDED_OBJECT)
        {
          paramJsonParser = paramJsonParser.getEmbeddedObject();
          if (paramJsonParser == null) {
            paramJsonParser = null;
          } else if ((paramJsonParser instanceof byte[])) {
            paramJsonParser = Base64Variants.getDefaultVariant().encode((byte[])paramJsonParser, false);
          } else {
            paramJsonParser = paramJsonParser.toString();
          }
        }
        else
        {
          if (!localJsonToken.isScalarValue()) {
            break;
          }
          paramJsonParser = paramJsonParser.getText();
        }
      }
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    
    public String deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      return deserialize(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static class TokenBufferDeserializer
    extends StdScalarDeserializer<TokenBuffer>
  {
    public TokenBufferDeserializer()
    {
      super();
    }
    
    public TokenBuffer deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      paramDeserializationContext = new TokenBuffer(paramJsonParser.getCodec());
      paramDeserializationContext.copyCurrentStructure(paramJsonParser);
      return paramDeserializationContext;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */