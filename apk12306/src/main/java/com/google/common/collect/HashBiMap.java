package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class HashBiMap<K, V>
  extends AbstractBiMap<K, V>
{
  @GwtIncompatible("Not needed in emulated source")
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(HashBiMap.class, 451);
  }
  
  private HashBiMap()
  {
    super(new HashMap(), new HashMap());
  }
  
  private HashBiMap(int paramInt)
  {
    super(new HashMap(Maps.capacity(paramInt)), new HashMap(Maps.capacity(paramInt)));
  }
  
  public static native <K, V> HashBiMap<K, V> create();
  
  public static native <K, V> HashBiMap<K, V> create(int paramInt);
  
  public static native <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> paramMap);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native V forcePut(@Nullable K paramK, @Nullable V paramV);
  
  public native V put(@Nullable K paramK, @Nullable V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\HashBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */