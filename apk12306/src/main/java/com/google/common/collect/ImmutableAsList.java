package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

@GwtCompatible(emulated=true, serializable=true)
final class ImmutableAsList<E>
  extends RegularImmutableList<E>
{
  private final transient ImmutableCollection<E> collection;
  
  static
  {
    JniLib.a(ImmutableAsList.class, 457);
  }
  
  ImmutableAsList(Object[] paramArrayOfObject, ImmutableCollection<E> paramImmutableCollection)
  {
    super(paramArrayOfObject, 0, paramArrayOfObject.length);
    this.collection = paramImmutableCollection;
  }
  
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException;
  
  public native boolean contains(Object paramObject);
  
  native Object writeReplace();
  
  static class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final ImmutableCollection<?> collection;
    
    static
    {
      JniLib.a(SerializedForm.class, 455);
    }
    
    SerializedForm(ImmutableCollection<?> paramImmutableCollection)
    {
      this.collection = paramImmutableCollection;
    }
    
    native Object readResolve();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */