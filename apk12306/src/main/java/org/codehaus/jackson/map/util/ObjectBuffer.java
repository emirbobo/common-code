package org.codehaus.jackson.map.util;

import java.lang.reflect.Array;
import java.util.List;

public final class ObjectBuffer
{
  static final int INITIAL_CHUNK_SIZE = 12;
  static final int MAX_CHUNK_SIZE = 262144;
  static final int SMALL_CHUNK_SIZE = 16384;
  private Node _bufferHead;
  private Node _bufferTail;
  private int _bufferedEntryCount;
  private Object[] _freeBuffer;
  
  protected final void _copyTo(Object paramObject, int paramInt1, Object[] paramArrayOfObject, int paramInt2)
  {
    int i = 0;
    for (Node localNode = this._bufferHead; localNode != null; localNode = localNode.next())
    {
      Object[] arrayOfObject = localNode.getData();
      int j = arrayOfObject.length;
      System.arraycopy(arrayOfObject, 0, paramObject, i, j);
      i += j;
    }
    System.arraycopy(paramArrayOfObject, 0, paramObject, i, paramInt2);
    paramInt2 = i + paramInt2;
    if (paramInt2 != paramInt1) {
      throw new IllegalStateException("Should have gotten " + paramInt1 + " entries, got " + paramInt2);
    }
  }
  
  protected void _reset()
  {
    if (this._bufferTail != null) {
      this._freeBuffer = this._bufferTail.getData();
    }
    this._bufferTail = null;
    this._bufferHead = null;
    this._bufferedEntryCount = 0;
  }
  
  public Object[] appendCompletedChunk(Object[] paramArrayOfObject)
  {
    Node localNode = new Node(paramArrayOfObject);
    int i;
    if (this._bufferHead == null)
    {
      this._bufferTail = localNode;
      this._bufferHead = localNode;
      i = paramArrayOfObject.length;
      this._bufferedEntryCount += i;
      if (i >= 16384) {
        break label71;
      }
      i += i;
    }
    for (;;)
    {
      return new Object[i];
      this._bufferTail.linkNext(localNode);
      this._bufferTail = localNode;
      break;
      label71:
      i += (i >> 2);
    }
  }
  
  public int bufferedSize()
  {
    return this._bufferedEntryCount;
  }
  
  public void completeAndClearBuffer(Object[] paramArrayOfObject, int paramInt, List<Object> paramList)
  {
    for (Node localNode = this._bufferHead; localNode != null; localNode = localNode.next())
    {
      Object[] arrayOfObject = localNode.getData();
      i = 0;
      int j = arrayOfObject.length;
      while (i < j)
      {
        paramList.add(arrayOfObject[i]);
        i++;
      }
    }
    for (int i = 0; i < paramInt; i++) {
      paramList.add(paramArrayOfObject[i]);
    }
  }
  
  public Object[] completeAndClearBuffer(Object[] paramArrayOfObject, int paramInt)
  {
    int i = paramInt + this._bufferedEntryCount;
    Object[] arrayOfObject = new Object[i];
    _copyTo(arrayOfObject, i, paramArrayOfObject, paramInt);
    return arrayOfObject;
  }
  
  public <T> T[] completeAndClearBuffer(Object[] paramArrayOfObject, int paramInt, Class<T> paramClass)
  {
    int i = paramInt + this._bufferedEntryCount;
    paramClass = (Object[])Array.newInstance(paramClass, i);
    _copyTo(paramClass, i, paramArrayOfObject, paramInt);
    _reset();
    return paramClass;
  }
  
  public int initialCapacity()
  {
    if (this._freeBuffer == null) {}
    for (int i = 0;; i = this._freeBuffer.length) {
      return i;
    }
  }
  
  public Object[] resetAndStart()
  {
    _reset();
    if (this._freeBuffer == null) {}
    for (Object[] arrayOfObject = new Object[12];; arrayOfObject = this._freeBuffer) {
      return arrayOfObject;
    }
  }
  
  static final class Node
  {
    final Object[] _data;
    Node _next;
    
    public Node(Object[] paramArrayOfObject)
    {
      this._data = paramArrayOfObject;
    }
    
    public Object[] getData()
    {
      return this._data;
    }
    
    public void linkNext(Node paramNode)
    {
      if (this._next != null) {
        throw new IllegalStateException();
      }
      this._next = paramNode;
    }
    
    public Node next()
    {
      return this._next;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\util\ObjectBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */