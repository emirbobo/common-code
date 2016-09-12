package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

class AbstractBiMap$Inverse<K, V>
  extends AbstractBiMap<K, V>
{
  @GwtIncompatible("Not needed in emulated source.")
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(Inverse.class, 331);
  }
  
  private AbstractBiMap$Inverse(Map<K, V> paramMap, AbstractBiMap<V, K> paramAbstractBiMap)
  {
    super(paramMap, paramAbstractBiMap, null);
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOuputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  @GwtIncompatible("Not needed in the emulated source.")
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractBiMap$Inverse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */