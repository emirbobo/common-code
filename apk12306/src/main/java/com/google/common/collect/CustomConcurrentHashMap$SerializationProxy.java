package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Equivalence;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentMap;

class CustomConcurrentHashMap$SerializationProxy<K, V>
  extends CustomConcurrentHashMap.AbstractSerializationProxy<K, V>
{
  private static final long serialVersionUID = 2L;
  
  static
  {
    JniLib.a(SerializationProxy.class, 409);
  }
  
  CustomConcurrentHashMap$SerializationProxy(CustomConcurrentHashMap.Strength paramStrength1, CustomConcurrentHashMap.Strength paramStrength2, Equivalence<Object> paramEquivalence1, Equivalence<Object> paramEquivalence2, long paramLong1, long paramLong2, int paramInt1, int paramInt2, MapEvictionListener<? super K, ? super V> paramMapEvictionListener, ConcurrentMap<K, V> paramConcurrentMap)
  {
    super(paramStrength1, paramStrength2, paramEquivalence1, paramEquivalence2, paramLong1, paramLong2, paramInt1, paramInt2, paramMapEvictionListener, paramConcurrentMap);
  }
  
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  private native Object readResolve();
  
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$SerializationProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */