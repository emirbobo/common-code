package org.codehaus.jackson.map.util;

final class PrimitiveArrayBuilder$Node<T>
{
  final T _data;
  final int _dataLength;
  Node<T> _next;
  
  public PrimitiveArrayBuilder$Node(T paramT, int paramInt)
  {
    this._data = paramT;
    this._dataLength = paramInt;
  }
  
  public int copyData(T paramT, int paramInt)
  {
    System.arraycopy(this._data, 0, paramT, paramInt, this._dataLength);
    return paramInt + this._dataLength;
  }
  
  public T getData()
  {
    return (T)this._data;
  }
  
  public void linkNext(Node<T> paramNode)
  {
    if (this._next != null) {
      throw new IllegalStateException();
    }
    this._next = paramNode;
  }
  
  public Node<T> next()
  {
    return this._next;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\util\PrimitiveArrayBuilder$Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */