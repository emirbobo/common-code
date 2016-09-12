package org.codehaus.jackson.node;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonToken;

public final class NodeCursor$RootValue
  extends NodeCursor
{
  protected boolean _done = false;
  JsonNode _node;
  
  public NodeCursor$RootValue(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
  {
    super(0, paramNodeCursor);
    this._node = paramJsonNode;
  }
  
  public boolean currentHasChildren()
  {
    return false;
  }
  
  public JsonNode currentNode()
  {
    return this._node;
  }
  
  public JsonToken endToken()
  {
    return null;
  }
  
  public String getCurrentName()
  {
    return null;
  }
  
  public JsonToken nextToken()
  {
    JsonToken localJsonToken = null;
    if (!this._done)
    {
      this._done = true;
      localJsonToken = this._node.asToken();
    }
    for (;;)
    {
      return localJsonToken;
      this._node = null;
    }
  }
  
  public JsonToken nextValue()
  {
    return nextToken();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\NodeCursor$RootValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */