package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtCompatible
public final class Suppliers
{
  static
  {
    JniLib.a(Suppliers.class, 325);
  }
  
  public static native <F, T> Supplier<T> compose(Function<? super F, T> paramFunction, Supplier<F> paramSupplier);
  
  public static native <T> Supplier<T> memoize(Supplier<T> paramSupplier);
  
  public static native <T> Supplier<T> memoizeWithExpiration(Supplier<T> paramSupplier, long paramLong, TimeUnit paramTimeUnit);
  
  public static native <T> Supplier<T> ofInstance(@Nullable T paramT);
  
  @Beta
  public static native <T> Function<Supplier<T>, T> supplierFunction();
  
  public static native <T> Supplier<T> synchronizedSupplier(Supplier<T> paramSupplier);
  
  @VisibleForTesting
  static class ExpiringMemoizingSupplier<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Supplier<T> delegate;
    final long durationNanos;
    volatile transient long expirationNanos;
    volatile transient T value;
    
    static
    {
      JniLib.a(ExpiringMemoizingSupplier.class, 320);
    }
    
    ExpiringMemoizingSupplier(Supplier<T> paramSupplier, long paramLong, TimeUnit paramTimeUnit)
    {
      this.delegate = ((Supplier)Preconditions.checkNotNull(paramSupplier));
      this.durationNanos = paramTimeUnit.toNanos(paramLong);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        return;
      }
    }
    
    public native T get();
  }
  
  @VisibleForTesting
  static class MemoizingSupplier<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Supplier<T> delegate;
    volatile transient boolean initialized;
    transient T value;
    
    static
    {
      JniLib.a(MemoizingSupplier.class, 321);
    }
    
    MemoizingSupplier(Supplier<T> paramSupplier)
    {
      this.delegate = paramSupplier;
    }
    
    public native T get();
  }
  
  private static class SupplierComposition<F, T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Function<? super F, T> function;
    final Supplier<F> supplier;
    
    static
    {
      JniLib.a(SupplierComposition.class, 322);
    }
    
    SupplierComposition(Function<? super F, T> paramFunction, Supplier<F> paramSupplier)
    {
      this.function = paramFunction;
      this.supplier = paramSupplier;
    }
    
    public native T get();
  }
  
  private static enum SupplierFunction
    implements Function<Supplier<?>, Object>
  {
    INSTANCE;
    
    private SupplierFunction() {}
    
    public Object apply(Supplier<?> paramSupplier)
    {
      return paramSupplier.get();
    }
  }
  
  private static class SupplierOfInstance<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final T instance;
    
    static
    {
      JniLib.a(SupplierOfInstance.class, 323);
    }
    
    SupplierOfInstance(@Nullable T paramT)
    {
      this.instance = paramT;
    }
    
    public native T get();
  }
  
  private static class ThreadSafeSupplier<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Supplier<T> delegate;
    
    static
    {
      JniLib.a(ThreadSafeSupplier.class, 324);
    }
    
    ThreadSafeSupplier(Supplier<T> paramSupplier)
    {
      this.delegate = paramSupplier;
    }
    
    public native T get();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Suppliers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */