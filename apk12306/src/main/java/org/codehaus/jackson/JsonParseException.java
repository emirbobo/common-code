package org.codehaus.jackson;

public class JsonParseException
  extends JsonProcessingException
{
  static final long serialVersionUID = 123L;
  
  public JsonParseException(String paramString, JsonLocation paramJsonLocation)
  {
    super(paramString, paramJsonLocation);
  }
  
  public JsonParseException(String paramString, JsonLocation paramJsonLocation, Throwable paramThrowable)
  {
    super(paramString, paramJsonLocation, paramThrowable);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\JsonParseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */