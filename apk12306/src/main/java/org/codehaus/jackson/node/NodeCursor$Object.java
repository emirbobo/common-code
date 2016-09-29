package org.codehaus.jackson.node;

import java.util.Iterator;
import java.util.Map.Entry;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonToken;

public final class NodeCursor$Object
  extends NodeCursor
{
  Iterator<Map.Entry<String, JsonNode>> _contents;
  Map.Entry<String, JsonNode> _current;
  boolean _needEntry;
  
  public NodeCursor$Object(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
  {
    super(2, paramNodeCursor);
    this._contents = ((ObjectNode)paramJsonNode).getFields();
    this._needEntry = true;
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
    if (this._current == null) {}
    for (JsonNode localJsonNode = null;; localJsonNode = (JsonNode)this._current.getValue()) {
      return localJsonNode;
    }
  }
  
  public JsonToken endToken()
  {
    return JsonToken.END_OBJECT;
  }
  
  public String getCurrentName()
  {
    if (this._current == null) {}
    for (String str = null;; str = (String)this._current.getKey()) {
      return str;
    }
  }
  
  public JsonToken nextToken()
  {
    JsonToken localJsonToken = null;
    if (this._needEntry) {
      if (!this._contents.hasNext()) {
        this._current = null;
      }
    }
    for (;;)
    {
      return localJsonToken;
      this._needEntry = false;
      this._current = ((Map.Entry)this._contents.next());
      localJsonToken = JsonToken.FIELD_NAME;
      continue;
      this._needEntry = true;
      localJsonToken = ((JsonNode)this._current.getValue()).asToken();
    }
  }
  
  public JsonToken nextValue()
  {
    JsonToken localJsonToken2 = nextToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == JsonToken.FIELD_NAME) {
      localJsonToken1 = nextToken();
    }
    return localJsonToken1;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\NodeCursor$Object.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */