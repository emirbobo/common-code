package org.codehaus.jackson.map;

import java.io.IOException;
import java.util.Iterator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.type.JavaType;

public class MappingIterator<T>
  implements Iterator<T>
{
  protected static final MappingIterator<?> EMPTY_ITERATOR = new MappingIterator(null, null, null, null);
  protected final DeserializationContext _context;
  protected final JsonDeserializer<T> _deserializer;
  protected final JsonParser _parser;
  protected final JavaType _type;
  
  protected MappingIterator(JavaType paramJavaType, JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonDeserializer<?> paramJsonDeserializer)
  {
    this._type = paramJavaType;
    this._parser = paramJsonParser;
    this._context = paramDeserializationContext;
    this._deserializer = paramJsonDeserializer;
    if ((paramJsonParser != null) && (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) && (!paramJsonParser.getParsingContext().inRoot())) {
      paramJsonParser.clearCurrentToken();
    }
  }
  
  protected static <T> MappingIterator<T> emptyIterator()
  {
    return EMPTY_ITERATOR;
  }
  
  public boolean hasNext()
  {
    try
    {
      boolean bool = hasNextValue();
      return bool;
    }
    catch (JsonMappingException localJsonMappingException)
    {
      throw new RuntimeJsonMappingException(localJsonMappingException.getMessage(), localJsonMappingException);
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.getMessage(), localIOException);
    }
  }
  
  public boolean hasNextValue()
    throws IOException
  {
    boolean bool = false;
    if (this._parser == null) {}
    for (;;)
    {
      return bool;
      if (this._parser.getCurrentToken() == null)
      {
        JsonToken localJsonToken = this._parser.nextToken();
        if (localJsonToken == null) {
          this._parser.close();
        } else if (localJsonToken == JsonToken.END_ARRAY) {}
      }
      else
      {
        bool = true;
      }
    }
  }
  
  public T next()
  {
    try
    {
      Object localObject = nextValue();
      return (T)localObject;
    }
    catch (JsonMappingException localJsonMappingException)
    {
      throw new RuntimeJsonMappingException(localJsonMappingException.getMessage(), localJsonMappingException);
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.getMessage(), localIOException);
    }
  }
  
  public T nextValue()
    throws IOException
  {
    Object localObject = this._deserializer.deserialize(this._parser, this._context);
    this._parser.clearCurrentToken();
    return (T)localObject;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\MappingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */