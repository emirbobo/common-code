package org.codehaus.jackson.map.deser;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;

public abstract class FromStringDeserializer<T>
  extends StdScalarDeserializer<T>
{
  protected FromStringDeserializer(Class<?> paramClass)
  {
    super(paramClass);
  }
  
  public static Iterable<FromStringDeserializer<?>> all()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new UUIDDeserializer());
    localArrayList.add(new URLDeserializer());
    localArrayList.add(new URIDeserializer());
    localArrayList.add(new CurrencyDeserializer());
    localArrayList.add(new PatternDeserializer());
    localArrayList.add(new LocaleDeserializer());
    localArrayList.add(new InetAddressDeserializer());
    localArrayList.add(new TimeZoneDeserializer());
    return localArrayList;
  }
  
  protected abstract T _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException;
  
  protected T _deserializeEmbedded(Object paramObject, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    throw paramDeserializationContext.mappingException("Don't know how to convert embedded Object of type " + paramObject.getClass().getName() + " into " + this._valueClass.getName());
  }
  
  public final T deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject1 = null;
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        paramJsonParser = (JsonParser)localObject1;
      }
    }
    for (;;)
    {
      return paramJsonParser;
      try
      {
        localObject1 = _deserialize(paramJsonParser, paramDeserializationContext);
        paramJsonParser = (JsonParser)localObject1;
        if (localObject1 != null) {
          continue;
        }
      }
      catch (IllegalArgumentException paramJsonParser)
      {
        Object localObject2;
        for (;;) {}
      }
      throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid textual representation");
      if (paramJsonParser.getCurrentToken() != JsonToken.VALUE_EMBEDDED_OBJECT) {
        break;
      }
      localObject2 = paramJsonParser.getEmbeddedObject();
      paramJsonParser = (JsonParser)localObject1;
      if (localObject2 != null) {
        if (this._valueClass.isAssignableFrom(localObject2.getClass())) {
          paramJsonParser = (JsonParser)localObject2;
        } else {
          paramJsonParser = _deserializeEmbedded(localObject2, paramDeserializationContext);
        }
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  public static class CurrencyDeserializer
    extends FromStringDeserializer<Currency>
  {
    public CurrencyDeserializer()
    {
      super();
    }
    
    protected Currency _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IllegalArgumentException
    {
      return Currency.getInstance(paramString);
    }
  }
  
  protected static class InetAddressDeserializer
    extends FromStringDeserializer<InetAddress>
  {
    public InetAddressDeserializer()
    {
      super();
    }
    
    protected InetAddress _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      return InetAddress.getByName(paramString);
    }
  }
  
  protected static class LocaleDeserializer
    extends FromStringDeserializer<Locale>
  {
    public LocaleDeserializer()
    {
      super();
    }
    
    protected Locale _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      int i = paramString.indexOf('_');
      if (i < 0) {
        paramString = new Locale(paramString);
      }
      for (;;)
      {
        return paramString;
        paramDeserializationContext = paramString.substring(0, i);
        paramString = paramString.substring(i + 1);
        i = paramString.indexOf('_');
        if (i < 0) {
          paramString = new Locale(paramDeserializationContext, paramString);
        } else {
          paramString = new Locale(paramDeserializationContext, paramString.substring(0, i), paramString.substring(i + 1));
        }
      }
    }
  }
  
  public static class PatternDeserializer
    extends FromStringDeserializer<Pattern>
  {
    public PatternDeserializer()
    {
      super();
    }
    
    protected Pattern _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IllegalArgumentException
    {
      return Pattern.compile(paramString);
    }
  }
  
  protected static class TimeZoneDeserializer
    extends FromStringDeserializer<TimeZone>
  {
    public TimeZoneDeserializer()
    {
      super();
    }
    
    protected TimeZone _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      return TimeZone.getTimeZone(paramString);
    }
  }
  
  public static class URIDeserializer
    extends FromStringDeserializer<URI>
  {
    public URIDeserializer()
    {
      super();
    }
    
    protected URI _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IllegalArgumentException
    {
      return URI.create(paramString);
    }
  }
  
  public static class URLDeserializer
    extends FromStringDeserializer<URL>
  {
    public URLDeserializer()
    {
      super();
    }
    
    protected URL _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      return new URL(paramString);
    }
  }
  
  public static class UUIDDeserializer
    extends FromStringDeserializer<UUID>
  {
    public UUIDDeserializer()
    {
      super();
    }
    
    protected UUID _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return UUID.fromString(paramString);
    }
    
    protected UUID _deserializeEmbedded(Object paramObject, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if ((paramObject instanceof byte[]))
      {
        paramObject = (byte[])paramObject;
        if (paramObject.length != 16) {
          paramDeserializationContext.mappingException("Can only construct UUIDs from 16 byte arrays; got " + paramObject.length + " bytes");
        }
        paramObject = new DataInputStream(new ByteArrayInputStream((byte[])paramObject));
      }
      for (paramObject = new UUID(((DataInputStream)paramObject).readLong(), ((DataInputStream)paramObject).readLong());; paramObject = null)
      {
        return (UUID)paramObject;
        super._deserializeEmbedded(paramObject, paramDeserializationContext);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\FromStringDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */