package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;

class Multimaps$CustomMultimap<K, V>
  extends AbstractMultimap<K, V>
{
  @GwtIncompatible("java serialization not supported")
  private static final long serialVersionUID = 0L;
  transient Supplier<? extends Collection<V>> factory;
  
  static
  {
    JniLib.a(CustomMultimap.class, 651);
  }
  
  Multimaps$CustomMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends Collection<V>> paramSupplier)
  {
    super(paramMap);
    this.factory = ((Supplier)Preconditions.checkNotNull(paramSupplier));
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  protected native Collection<V> createCollection();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$CustomMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */