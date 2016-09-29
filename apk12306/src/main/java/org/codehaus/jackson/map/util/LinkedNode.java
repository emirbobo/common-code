package org.codehaus.jackson.map.util;

public final class LinkedNode<T>
{
  final LinkedNode<T> _next;
  final T _value;
  
  public LinkedNode(T paramT, LinkedNode<T> paramLinkedNode)
  {
    this._value = paramT;
    this._next = paramLinkedNode;
  }
  
  public static <ST> boolean contains(LinkedNode<ST> paramLinkedNode, ST paramST)
  {
    if (paramLinkedNode != null) {
      if (paramLinkedNode.value() != paramST) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      paramLinkedNode = paramLinkedNode.next();
      break;
    }
  }
  
  public LinkedNode<T> next()
  {
    return this._next;
  }
  
  public T value()
  {
    return (T)this._value;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\util\LinkedNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */