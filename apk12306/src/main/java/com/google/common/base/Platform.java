package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class Platform
{
  private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal()
  {
    static
    {
      JniLib.a(1.class, 297);
    }
    
    protected native char[] initialValue();
  };
  
  static
  {
    JniLib.a(Platform.class, 298);
  }
  
  static native char[] charBufferFromThreadLocal();
  
  static native boolean isInstance(Class<?> paramClass, @Nullable Object paramObject);
  
  static native CharMatcher precomputeCharMatcher(CharMatcher paramCharMatcher);
  
  static native long systemNanoTime();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */