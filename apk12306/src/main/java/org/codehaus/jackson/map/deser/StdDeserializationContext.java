package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializationProblemHandler;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.LinkedNode;
import org.codehaus.jackson.map.util.ObjectBuffer;
import org.codehaus.jackson.type.JavaType;

public class StdDeserializationContext
  extends DeserializationContext
{
  static final int MAX_ERROR_STR_LEN = 500;
  protected ArrayBuilders _arrayBuilders;
  protected DateFormat _dateFormat;
  protected final DeserializerProvider _deserProvider;
  protected ObjectBuffer _objectBuffer;
  protected JsonParser _parser;
  
  public StdDeserializationContext(DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, DeserializerProvider paramDeserializerProvider)
  {
    super(paramDeserializationConfig);
    this._parser = paramJsonParser;
    this._deserProvider = paramDeserializerProvider;
  }
  
  protected String _calcName(Class<?> paramClass)
  {
    if (paramClass.isArray()) {}
    for (paramClass = _calcName(paramClass.getComponentType()) + "[]";; paramClass = paramClass.getName()) {
      return paramClass;
    }
  }
  
  protected String _desc(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 500) {
      str = paramString.substring(0, 500) + "]...[" + paramString.substring(paramString.length() - 500);
    }
    return str;
  }
  
  protected String _valueDesc()
  {
    try
    {
      String str1 = _desc(this._parser.getText());
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = "[N/A]";
      }
    }
  }
  
  public Calendar constructCalendar(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar;
  }
  
  protected String determineClassName(Object paramObject)
  {
    return ClassUtil.getClassDescription(paramObject);
  }
  
  public final ArrayBuilders getArrayBuilders()
  {
    if (this._arrayBuilders == null) {
      this._arrayBuilders = new ArrayBuilders();
    }
    return this._arrayBuilders;
  }
  
  protected DateFormat getDateFormat()
  {
    if (this._dateFormat == null) {
      this._dateFormat = ((DateFormat)this._config.getDateFormat().clone());
    }
    return this._dateFormat;
  }
  
  public DeserializerProvider getDeserializerProvider()
  {
    return this._deserProvider;
  }
  
  public JsonParser getParser()
  {
    return this._parser;
  }
  
  public boolean handleUnknownProperty(JsonParser paramJsonParser, JsonDeserializer<?> paramJsonDeserializer, Object paramObject, String paramString)
    throws IOException, JsonProcessingException
  {
    LinkedNode localLinkedNode = this._config.getProblemHandlers();
    if (localLinkedNode != null)
    {
      localJsonParser = this._parser;
      this._parser = paramJsonParser;
      paramJsonParser = localLinkedNode;
      if (paramJsonParser == null) {}
    }
    for (;;)
    {
      try
      {
        bool = ((DeserializationProblemHandler)paramJsonParser.value()).handleUnknownProperty(this, paramJsonDeserializer, paramObject, paramString);
        if (bool)
        {
          bool = true;
          return bool;
        }
        paramJsonParser = paramJsonParser.next();
        break;
      }
      finally
      {
        boolean bool;
        this._parser = localJsonParser;
      }
      this._parser = localJsonParser;
      bool = false;
    }
  }
  
  public JsonMappingException instantiationException(Class<?> paramClass, String paramString)
  {
    return JsonMappingException.from(this._parser, "Can not construct instance of " + paramClass.getName() + ", problem: " + paramString);
  }
  
  public JsonMappingException instantiationException(Class<?> paramClass, Throwable paramThrowable)
  {
    return JsonMappingException.from(this._parser, "Can not construct instance of " + paramClass.getName() + ", problem: " + paramThrowable.getMessage(), paramThrowable);
  }
  
  public final ObjectBuffer leaseObjectBuffer()
  {
    ObjectBuffer localObjectBuffer = this._objectBuffer;
    if (localObjectBuffer == null) {
      localObjectBuffer = new ObjectBuffer();
    }
    for (;;)
    {
      return localObjectBuffer;
      this._objectBuffer = null;
    }
  }
  
  public JsonMappingException mappingException(Class<?> paramClass)
  {
    paramClass = _calcName(paramClass);
    return JsonMappingException.from(this._parser, "Can not deserialize instance of " + paramClass + " out of " + this._parser.getCurrentToken() + " token");
  }
  
  public Date parseDate(String paramString)
    throws IllegalArgumentException
  {
    try
    {
      paramString = getDateFormat().parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      throw new IllegalArgumentException(paramString.getMessage());
    }
  }
  
  public final void returnObjectBuffer(ObjectBuffer paramObjectBuffer)
  {
    if ((this._objectBuffer == null) || (paramObjectBuffer.initialCapacity() >= this._objectBuffer.initialCapacity())) {
      this._objectBuffer = paramObjectBuffer;
    }
  }
  
  public JsonMappingException unknownFieldException(Object paramObject, String paramString)
  {
    return UnrecognizedPropertyException.from(this._parser, paramObject, paramString);
  }
  
  public JsonMappingException unknownTypeException(JavaType paramJavaType, String paramString)
  {
    return JsonMappingException.from(this._parser, "Could not resolve type id '" + paramString + "' into a subtype of " + paramJavaType);
  }
  
  public JsonMappingException weirdKeyException(Class<?> paramClass, String paramString1, String paramString2)
  {
    return JsonMappingException.from(this._parser, "Can not construct Map key of type " + paramClass.getName() + " from String \"" + _desc(paramString1) + "\": " + paramString2);
  }
  
  public JsonMappingException weirdNumberException(Class<?> paramClass, String paramString)
  {
    return JsonMappingException.from(this._parser, "Can not construct instance of " + paramClass.getName() + " from number value (" + _valueDesc() + "): " + paramString);
  }
  
  public JsonMappingException weirdStringException(Class<?> paramClass, String paramString)
  {
    return JsonMappingException.from(this._parser, "Can not construct instance of " + paramClass.getName() + " from String value '" + _valueDesc() + "': " + paramString);
  }
  
  public JsonMappingException wrongTokenException(JsonParser paramJsonParser, JsonToken paramJsonToken, String paramString)
  {
    return JsonMappingException.from(paramJsonParser, "Unexpected token (" + paramJsonParser.getCurrentToken() + "), expected " + paramJsonToken + ": " + paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */