package org.codehaus.jackson.node;

import java.util.Iterator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonToken;

public final class NodeCursor$Array
  extends NodeCursor
{
  Iterator<JsonNode> _contents;
  JsonNode _currentNode;
  
  public NodeCursor$Array(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
  {
    super(1, paramNodeCursor);
    this._contents = paramJsonNode.getElements();
  }
  
  public boolean currentHasChildren()
  {
    if (((ContainerNode)currentNode()).size() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public JsonNode currentNode()
  {
    return this._currentNode;
  }
  
  public JsonToken endToken()
  {
    return JsonToken.END_ARRAY;
  }
  
  public String getCurrentName()
  {
    return null;
  }
  
  public JsonToken nextToken()
  {
    JsonToken localJsonToken = null;
    if (!this._contents.hasNext()) {
      this._currentNode = null;
    }
    for (;;)
    {
      return localJsonToken;
      this._currentNode = ((JsonNode)this._contents.next());
      localJsonToken = this._currentNode.asToken();
    }
  }
  
  public JsonToken nextValue()
  {
    return nextToken();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\NodeCursor$Array.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */