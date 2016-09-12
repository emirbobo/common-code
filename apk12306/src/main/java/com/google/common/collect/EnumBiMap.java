package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.Map;

@GwtCompatible(emulated=true)
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>>
  extends AbstractBiMap<K, V>
{
  @GwtIncompatible("not needed in emulated source.")
  private static final long serialVersionUID = 0L;
  private transient Class<K> keyType;
  private transient Class<V> valueType;
  
  static
  {
    JniLib.a(EnumBiMap.class, 439);
  }
  
  private EnumBiMap(Class<K> paramClass, Class<V> paramClass1)
  {
    super(WellBehavedMap.wrap(new EnumMap(paramClass)), WellBehavedMap.wrap(new EnumMap(paramClass1)));
    this.keyType = paramClass;
    this.valueType = paramClass1;
  }
  
  public static native <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> paramClass, Class<V> paramClass1);
  
  public static native <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> paramMap);
  
  static native <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> paramMap);
  
  private static native <V extends Enum<V>> Class<V> inferValueType(Map<?, V> paramMap);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native Class<K> keyType();
  
  public native Class<V> valueType();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\EnumBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */