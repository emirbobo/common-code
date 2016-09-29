package org.codehaus.jackson.map.ext;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.deser.StdScalarDeserializer;
import org.codehaus.jackson.map.util.Provider;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.ReadableDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class JodaDeserializers
  implements Provider<StdDeserializer<?>>
{
  public Collection<StdDeserializer<?>> provide()
  {
    return Arrays.asList(new StdDeserializer[] { new DateTimeDeserializer(DateTime.class), new DateTimeDeserializer(ReadableDateTime.class), new DateTimeDeserializer(ReadableInstant.class), new LocalDateDeserializer(), new LocalDateTimeDeserializer(), new DateMidnightDeserializer() });
  }
  
  public static class DateMidnightDeserializer
    extends JodaDeserializers.JodaDeserializer<DateMidnight>
  {
    public DateMidnightDeserializer()
    {
      super();
    }
    
    public DateMidnight deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      Object localObject = null;
      if (paramJsonParser.isExpectedStartArrayToken())
      {
        paramJsonParser.nextToken();
        int i = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int j = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int k = paramJsonParser.getIntValue();
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
          paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "after DateMidnight ints");
        }
        paramJsonParser = new DateMidnight(i, j, k);
      }
      for (;;)
      {
        return paramJsonParser;
        switch (JodaDeserializers.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
        {
        default: 
          paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "expected JSON Array, Number or String");
          paramJsonParser = (JsonParser)localObject;
          break;
        case 1: 
          paramJsonParser = new DateMidnight(paramJsonParser.getLongValue());
          break;
        case 2: 
          paramDeserializationContext = parseLocal(paramJsonParser);
          paramJsonParser = (JsonParser)localObject;
          if (paramDeserializationContext != null) {
            paramJsonParser = paramDeserializationContext.toDateMidnight();
          }
          break;
        }
      }
    }
  }
  
  public static class DateTimeDeserializer<T extends ReadableInstant>
    extends JodaDeserializers.JodaDeserializer<T>
  {
    public DateTimeDeserializer(Class<T> paramClass)
    {
      super();
    }
    
    public T deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        paramJsonParser = new DateTime(paramJsonParser.getLongValue(), DateTimeZone.UTC);
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
          paramJsonParser = new DateTime(paramJsonParser, DateTimeZone.UTC);
        }
      }
      throw paramDeserializationContext.mappingException(getValueClass());
    }
  }
  
  static abstract class JodaDeserializer<T>
    extends StdScalarDeserializer<T>
  {
    static final DateTimeFormatter _localDateTimeFormat = ;
    
    protected JodaDeserializer(Class<T> paramClass)
    {
      super();
    }
    
    protected DateTime parseLocal(JsonParser paramJsonParser)
      throws IOException, JsonProcessingException
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {}
      for (paramJsonParser = null;; paramJsonParser = _localDateTimeFormat.parseDateTime(paramJsonParser)) {
        return paramJsonParser;
      }
    }
  }
  
  public static class LocalDateDeserializer
    extends JodaDeserializers.JodaDeserializer<LocalDate>
  {
    public LocalDateDeserializer()
    {
      super();
    }
    
    public LocalDate deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      Object localObject = null;
      if (paramJsonParser.isExpectedStartArrayToken())
      {
        paramJsonParser.nextToken();
        int k = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int i = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int j = paramJsonParser.getIntValue();
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
          paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "after LocalDate ints");
        }
        paramJsonParser = new LocalDate(k, i, j);
      }
      for (;;)
      {
        return paramJsonParser;
        switch (JodaDeserializers.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
        {
        default: 
          paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "expected JSON Array, String or Number");
          paramJsonParser = (JsonParser)localObject;
          break;
        case 1: 
          paramJsonParser = new LocalDate(paramJsonParser.getLongValue());
          break;
        case 2: 
          paramDeserializationContext = parseLocal(paramJsonParser);
          paramJsonParser = (JsonParser)localObject;
          if (paramDeserializationContext != null) {
            paramJsonParser = paramDeserializationContext.toLocalDate();
          }
          break;
        }
      }
    }
  }
  
  public static class LocalDateTimeDeserializer
    extends JodaDeserializers.JodaDeserializer<LocalDateTime>
  {
    public LocalDateTimeDeserializer()
    {
      super();
    }
    
    public LocalDateTime deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      Object localObject = null;
      if (paramJsonParser.isExpectedStartArrayToken())
      {
        paramJsonParser.nextToken();
        int n = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int i1 = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int j = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int i2 = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int m = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int k = paramJsonParser.getIntValue();
        int i = 0;
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          i = paramJsonParser.getIntValue();
          paramJsonParser.nextToken();
        }
        if (paramJsonParser.getCurrentToken() != JsonToken.END_ARRAY) {
          paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "after LocalDateTime ints");
        }
        paramJsonParser = new LocalDateTime(n, i1, j, i2, m, k, i);
      }
      for (;;)
      {
        return paramJsonParser;
        switch (JodaDeserializers.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
        {
        default: 
          paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "expected JSON Array or Number");
          paramJsonParser = (JsonParser)localObject;
          break;
        case 1: 
          paramJsonParser = new LocalDateTime(paramJsonParser.getLongValue());
          break;
        case 2: 
          paramDeserializationContext = parseLocal(paramJsonParser);
          paramJsonParser = (JsonParser)localObject;
          if (paramDeserializationContext != null) {
            paramJsonParser = paramDeserializationContext.toLocalDateTime();
          }
          break;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ext\JodaDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */