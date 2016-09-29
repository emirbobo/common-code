package org.codehaus.jackson.impl;

import org.codehaus.jackson.JsonStreamContext;

public class JsonWriteContext
  extends JsonStreamContext
{
  public static final int STATUS_EXPECT_NAME = 5;
  public static final int STATUS_EXPECT_VALUE = 4;
  public static final int STATUS_OK_AFTER_COLON = 2;
  public static final int STATUS_OK_AFTER_COMMA = 1;
  public static final int STATUS_OK_AFTER_SPACE = 3;
  public static final int STATUS_OK_AS_IS = 0;
  protected JsonWriteContext _child = null;
  protected String _currentName;
  protected final JsonWriteContext _parent;
  
  protected JsonWriteContext(int paramInt, JsonWriteContext paramJsonWriteContext)
  {
    this._type = paramInt;
    this._parent = paramJsonWriteContext;
    this._index = -1;
  }
  
  public static JsonWriteContext createRootContext()
  {
    return new JsonWriteContext(0, null);
  }
  
  private final JsonWriteContext reset(int paramInt)
  {
    this._type = paramInt;
    this._index = -1;
    this._currentName = null;
    return this;
  }
  
  protected final void appendDesc(StringBuilder paramStringBuilder)
  {
    if (this._type == 2)
    {
      paramStringBuilder.append('{');
      if (this._currentName != null)
      {
        paramStringBuilder.append('"');
        paramStringBuilder.append(this._currentName);
        paramStringBuilder.append('"');
        paramStringBuilder.append(']');
      }
    }
    for (;;)
    {
      return;
      paramStringBuilder.append('?');
      break;
      if (this._type == 1)
      {
        paramStringBuilder.append('[');
        paramStringBuilder.append(getCurrentIndex());
        paramStringBuilder.append(']');
      }
      else
      {
        paramStringBuilder.append("/");
      }
    }
  }
  
  public final JsonWriteContext createChildArrayContext()
  {
    JsonWriteContext localJsonWriteContext = this._child;
    if (localJsonWriteContext == null)
    {
      localJsonWriteContext = new JsonWriteContext(1, this);
      this._child = localJsonWriteContext;
    }
    for (;;)
    {
      return localJsonWriteContext;
      localJsonWriteContext = localJsonWriteContext.reset(1);
    }
  }
  
  public final JsonWriteContext createChildObjectContext()
  {
    JsonWriteContext localJsonWriteContext = this._child;
    if (localJsonWriteContext == null)
    {
      localJsonWriteContext = new JsonWriteContext(2, this);
      this._child = localJsonWriteContext;
    }
    for (;;)
    {
      return localJsonWriteContext;
      localJsonWriteContext = localJsonWriteContext.reset(2);
    }
  }
  
  public final String getCurrentName()
  {
    return this._currentName;
  }
  
  public final JsonWriteContext getParent()
  {
    return this._parent;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    appendDesc(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public final int writeFieldName(String paramString)
  {
    int j = 4;
    int i = j;
    if (this._type == 2)
    {
      if (this._currentName == null) {
        break label23;
      }
      i = j;
    }
    for (;;)
    {
      return i;
      label23:
      this._currentName = paramString;
      if (this._index < 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final int writeValue()
  {
    int i = 0;
    if (this._type == 2) {
      if (this._currentName == null) {
        i = 5;
      }
    }
    for (;;)
    {
      return i;
      this._currentName = null;
      this._index += 1;
      i = 2;
      continue;
      if (this._type == 1)
      {
        int j = this._index;
        this._index += 1;
        if (j >= 0) {
          i = 1;
        }
      }
      else
      {
        this._index += 1;
        if (this._index != 0) {
          i = 3;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\impl\JsonWriteContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */