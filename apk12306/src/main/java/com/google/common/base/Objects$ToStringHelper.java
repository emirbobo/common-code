package com.google.common.base;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;

public final class Objects$ToStringHelper
{
  private final StringBuilder builder;
  private String separator = "";
  
  static
  {
    JniLib.a(ToStringHelper.class, 294);
  }
  
  private Objects$ToStringHelper(String paramString)
  {
    this.builder = new StringBuilder(32).append((String)Preconditions.checkNotNull(paramString)).append('{');
  }
  
  public native ToStringHelper add(String paramString, @Nullable Object paramObject);
  
  public native ToStringHelper addValue(@Nullable Object paramObject);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Objects$ToStringHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */