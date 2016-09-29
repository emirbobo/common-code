package org.codehaus.jackson.map.deser;

import java.util.Currency;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$CurrencyDeserializer
  extends FromStringDeserializer<Currency>
{
  public FromStringDeserializer$CurrencyDeserializer()
  {
    super(Currency.class);
  }
  
  protected Currency _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IllegalArgumentException
  {
    return Currency.getInstance(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\FromStringDeserializer$CurrencyDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */