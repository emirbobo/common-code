package org.codehaus.jackson;

public abstract class JsonStreamContext
{
  protected static final int TYPE_ARRAY = 1;
  protected static final int TYPE_OBJECT = 2;
  protected static final int TYPE_ROOT = 0;
  protected int _index;
  protected int _type;
  
  public final int getCurrentIndex()
  {
    if (this._index < 0) {}
    for (int i = 0;; i = this._index) {
      return i;
    }
  }
  
  public abstract String getCurrentName();
  
  public final int getEntryCount()
  {
    return this._index + 1;
  }
  
  public abstract JsonStreamContext getParent();
  
  public final String getTypeDesc()
  {
    String str;
    switch (this._type)
    {
    default: 
      str = "?";
    }
    for (;;)
    {
      return str;
      str = "ROOT";
      continue;
      str = "ARRAY";
      continue;
      str = "OBJECT";
    }
  }
  
  public final boolean inArray()
  {
    boolean bool = true;
    if (this._type == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public final boolean inObject()
  {
    if (this._type == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean inRoot()
  {
    if (this._type == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\JsonStreamContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */