package org.codehaus.jackson.node;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import org.codehaus.jackson.JsonNode;

public class ObjectNode$NoFieldsIterator
  implements Iterator<Map.Entry<String, JsonNode>>
{
  static final NoFieldsIterator instance = new NoFieldsIterator();
  
  public boolean hasNext()
  {
    return false;
  }
  
  public Map.Entry<String, JsonNode> next()
  {
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new IllegalStateException();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\ObjectNode$NoFieldsIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */