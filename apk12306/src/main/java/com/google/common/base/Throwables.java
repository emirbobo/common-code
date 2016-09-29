package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.util.List;
import javax.annotation.Nullable;

public final class Throwables
{
  static
  {
    JniLib.a(Throwables.class, 326);
  }
  
  @Beta
  public static native List<Throwable> getCausalChain(Throwable paramThrowable);
  
  public static native Throwable getRootCause(Throwable paramThrowable);
  
  public static native String getStackTraceAsString(Throwable paramThrowable);
  
  public static native RuntimeException propagate(Throwable paramThrowable);
  
  public static native <X extends Throwable> void propagateIfInstanceOf(@Nullable Throwable paramThrowable, Class<X> paramClass)
    throws Throwable;
  
  public static native void propagateIfPossible(@Nullable Throwable paramThrowable);
  
  public static native <X extends Throwable> void propagateIfPossible(@Nullable Throwable paramThrowable, Class<X> paramClass)
    throws Throwable;
  
  public static native <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@Nullable Throwable paramThrowable, Class<X1> paramClass, Class<X2> paramClass1)
    throws Throwable, Throwable;
  
  @Beta
  public static native Exception throwCause(Exception paramException, boolean paramBoolean)
    throws Exception;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Throwables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */