package org.codehaus.jackson.map.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class ArrayBuilders$ArrayIterator<T>
  implements Iterator<T>, Iterable<T>
{
  private final T[] _array;
  private int _index;
  
  public ArrayBuilders$ArrayIterator(T[] paramArrayOfT)
  {
    this._array = paramArrayOfT;
    this._index = 0;
  }
  
  public boolean hasNext()
  {
    if (this._index < this._array.length) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Iterator<T> iterator()
  {
    return this;
  }
  
  public T next()
  {
    if (this._index >= this._array.length) {
      throw new NoSuchElementException();
    }
    Object[] arrayOfObject = this._array;
    int i = this._index;
    this._index = (i + 1);
    return (T)arrayOfObject[i];
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\util\ArrayBuilders$ArrayIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */