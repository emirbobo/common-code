package org.codehaus.jackson.node;

import java.util.Iterator;
import java.util.Map.Entry;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;

abstract class NodeCursor
  extends JsonStreamContext
{
  final NodeCursor _parent;
  
  public NodeCursor(int paramInt, NodeCursor paramNodeCursor)
  {
    this._type = paramInt;
    this._index = -1;
    this._parent = paramNodeCursor;
  }
  
  public abstract boolean currentHasChildren();
  
  public abstract JsonNode currentNode();
  
  public abstract JsonToken endToken();
  
  public abstract String getCurrentName();
  
  public final NodeCursor getParent()
  {
    return this._parent;
  }
  
  public final NodeCursor iterateChildren()
  {
    Object localObject = currentNode();
    if (localObject == null) {
      throw new IllegalStateException("No current node");
    }
    if (((JsonNode)localObject).isArray()) {}
    for (localObject = new Array((JsonNode)localObject, this);; localObject = new Object((JsonNode)localObject, this))
    {
      return (NodeCursor)localObject;
      if (!((JsonNode)localObject).isObject()) {
        break;
      }
    }
    throw new IllegalStateException("Current node of type " + localObject.getClass().getName());
  }
  
  public abstract JsonToken nextToken();
  
  public abstract JsonToken nextValue();
  
  protected static final class Array
    extends NodeCursor
  {
    Iterator<JsonNode> _contents;
    JsonNode _currentNode;
    
    public Array(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
    {
      super(paramNodeCursor);
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
  
  protected static final class Object
    extends NodeCursor
  {
    Iterator<Map.Entry<String, JsonNode>> _contents;
    Map.Entry<String, JsonNode> _current;
    boolean _needEntry;
    
    public Object(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
    {
      super(paramNodeCursor);
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
  
  protected static final class RootValue
    extends NodeCursor
  {
    protected boolean _done = false;
    JsonNode _node;
    
    public RootValue(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
    {
      super(paramNodeCursor);
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\NodeCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */