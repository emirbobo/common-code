package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

class ComputingConcurrentHashMap$ComputingSerializationProxy<K, V>
  extends CustomConcurrentHashMap.AbstractSerializationProxy<K, V>
{
  private static final long serialVersionUID = 2L;
  transient MapMaker.Cache<K, V> cache;
  final Function<? super K, ? extends V> computingFunction;
  
  static
  {
    JniLib.a(ComputingSerializationProxy.class, 380);
  }
  
  ComputingConcurrentHashMap$ComputingSerializationProxy(CustomConcurrentHashMap.Strength paramStrength1, CustomConcurrentHashMap.Strength paramStrength2, Equivalence<Object> paramEquivalence1, Equivalence<Object> paramEquivalence2, long paramLong1, long paramLong2, int paramInt1, int paramInt2, MapEvictionListener<? super K, ? super V> paramMapEvictionListener, ConcurrentMap<K, V> paramConcurrentMap, Function<? super K, ? extends V> paramFunction)
  {
    super(paramStrength1, paramStrength2, paramEquivalence1, paramEquivalence2, paramLong1, paramLong2, paramInt1, paramInt2, paramMapEvictionListener, paramConcurrentMap);
    this.computingFunction = paramFunction;
  }
  
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native V apply(@Nullable K paramK);
  
  public native ConcurrentMap<K, V> asMap();
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ComputingConcurrentHashMap$ComputingSerializationProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */