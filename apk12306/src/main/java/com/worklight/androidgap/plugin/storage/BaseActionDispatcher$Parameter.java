package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;

class BaseActionDispatcher$Parameter
{
  private boolean loggable;
  private String name;
  private boolean required;
  private BaseActionDispatcher.ParameterType[] types;
  
  static
  {
    JniLib.a(Parameter.class, 1214);
  }
  
  private BaseActionDispatcher$Parameter(BaseActionDispatcher paramBaseActionDispatcher, String paramString, boolean paramBoolean1, boolean paramBoolean2, BaseActionDispatcher.ParameterType[] paramArrayOfParameterType)
  {
    this.name = paramString;
    this.required = paramBoolean1;
    this.loggable = paramBoolean2;
    this.types = paramArrayOfParameterType;
  }
  
  public native String getName();
  
  public native BaseActionDispatcher.ParameterType[] getTypes();
  
  public native boolean isLoggable();
  
  public native boolean isRequired();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\BaseActionDispatcher$Parameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */