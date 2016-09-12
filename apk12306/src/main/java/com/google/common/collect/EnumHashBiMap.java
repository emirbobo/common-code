package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class EnumHashBiMap<K extends Enum<K>, V>
  extends AbstractBiMap<K, V>
{
  @GwtIncompatible("only needed in emulated source.")
  private static final long serialVersionUID = 0L;
  private transient Class<K> keyType;
  
  static
  {
    JniLib.a(EnumHashBiMap.class, 440);
  }
  
  private EnumHashBiMap(Class<K> paramClass)
  {
    super(WellBehavedMap.wrap(new EnumMap(paramClass)), Maps.newHashMapWithExpectedSize(((Enum[])paramClass.getEnumConstants()).length));
    this.keyType = paramClass;
  }
  
  public static native <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> paramClass);
  
  public static native <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> paramMap);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native V forcePut(K paramK, @Nullable V paramV);
  
  public native Class<K> keyType();
  
  public native V put(K paramK, @Nullable V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\EnumHashBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */