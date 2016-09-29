package org.codehaus.jackson.map.ext;

import org.codehaus.jackson.map.DeserializationContext;
import org.w3c.dom.Node;

public class DOMDeserializer$NodeDeserializer
  extends DOMDeserializer<Node>
{
  public DOMDeserializer$NodeDeserializer()
  {
    super(Node.class);
  }
  
  public Node _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IllegalArgumentException
  {
    return parse(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ext\DOMDeserializer$NodeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */