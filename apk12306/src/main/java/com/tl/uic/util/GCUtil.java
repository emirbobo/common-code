package com.tl.uic.util;

import com.bangcle.andjni.JniLib;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class GCUtil
{
  private static volatile GCUtil _myInstance;
  
  static
  {
    JniLib.a(GCUtil.class, 1117);
  }
  
  public static native <T> Boolean clean(Object paramObject);
  
  public static native <K, V> Boolean clean(HashMap<K, V> paramHashMap);
  
  public static native <T> Boolean clean(List<T> paramList);
  
  public static native <K, V> Boolean clean(ConcurrentHashMap<K, V> paramConcurrentHashMap);
  
  public static native GCUtil getInstance();
  
  public static native Boolean invokeCleanMethod(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\GCUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */