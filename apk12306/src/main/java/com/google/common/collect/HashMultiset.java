package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

@GwtCompatible(emulated=true, serializable=true)
public final class HashMultiset<E>
  extends AbstractMapBasedMultiset<E>
{
  @GwtIncompatible("Not needed in emulated source.")
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(HashMultiset.class, 453);
  }
  
  private HashMultiset()
  {
    super(new HashMap());
  }
  
  private HashMultiset(int paramInt)
  {
    super(new HashMap(Maps.capacity(paramInt)));
  }
  
  public static native <E> HashMultiset<E> create();
  
  public static native <E> HashMultiset<E> create(int paramInt);
  
  public static native <E> HashMultiset<E> create(Iterable<? extends E> paramIterable);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\HashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */