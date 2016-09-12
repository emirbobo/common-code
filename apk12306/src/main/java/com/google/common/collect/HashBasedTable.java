package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(serializable=true)
public class HashBasedTable<R, C, V>
  extends StandardTable<R, C, V>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(HashBasedTable.class, 450);
  }
  
  HashBasedTable(Map<R, Map<C, V>> paramMap, Factory<C, V> paramFactory)
  {
    super(paramMap, paramFactory);
  }
  
  public static native <R, C, V> HashBasedTable<R, C, V> create();
  
  public static native <R, C, V> HashBasedTable<R, C, V> create(int paramInt1, int paramInt2);
  
  public static native <R, C, V> HashBasedTable<R, C, V> create(Table<? extends R, ? extends C, ? extends V> paramTable);
  
  public native boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public native boolean containsColumn(@Nullable Object paramObject);
  
  public native boolean containsRow(@Nullable Object paramObject);
  
  public native boolean containsValue(@Nullable Object paramObject);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native V get(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public native V remove(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  private static class Factory<C, V>
    implements Supplier<Map<C, V>>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final int expectedSize;
    
    static
    {
      JniLib.a(Factory.class, 448);
    }
    
    Factory(int paramInt)
    {
      this.expectedSize = paramInt;
    }
    
    public native Map<C, V> get();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\HashBasedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */