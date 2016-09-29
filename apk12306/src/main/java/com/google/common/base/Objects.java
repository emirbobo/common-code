package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import javax.annotation.Nullable;

@GwtCompatible
public final class Objects
{
  static
  {
    JniLib.a(Objects.class, 295);
  }
  
  public static native boolean equal(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public static native <T> T firstNonNull(@Nullable T paramT1, @Nullable T paramT2);
  
  public static int hashCode(@Nullable Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  private static native String simpleName(Class<?> paramClass);
  
  public static native ToStringHelper toStringHelper(Class<?> paramClass);
  
  public static native ToStringHelper toStringHelper(Object paramObject);
  
  public static native ToStringHelper toStringHelper(String paramString);
  
  public static final class ToStringHelper
  {
    private final StringBuilder builder;
    private String separator = "";
    
    static
    {
      JniLib.a(ToStringHelper.class, 294);
    }
    
    private ToStringHelper(String paramString)
    {
      this.builder = new StringBuilder(32).append((String)Preconditions.checkNotNull(paramString)).append('{');
    }
    
    public native ToStringHelper add(String paramString, @Nullable Object paramObject);
    
    public native ToStringHelper addValue(@Nullable Object paramObject);
    
    public native String toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Objects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */