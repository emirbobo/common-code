package org.codehaus.jackson.map.ext;

import javax.xml.namespace.QName;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.FromStringDeserializer;

public class CoreXMLDeserializers$QNameDeserializer
  extends FromStringDeserializer<QName>
{
  public CoreXMLDeserializers$QNameDeserializer()
  {
    super(QName.class);
  }
  
  protected QName _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IllegalArgumentException
  {
    return QName.valueOf(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ext\CoreXMLDeserializers$QNameDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */