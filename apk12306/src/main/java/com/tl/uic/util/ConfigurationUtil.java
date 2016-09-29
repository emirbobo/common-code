package com.tl.uic.util;

import android.app.Application;
import com.bangcle.andjni.JniLib;
import java.util.Properties;

public final class ConfigurationUtil
{
  private static final String EMPTY_STRING = "";
  private static final String EXCEPTION_LOG_TITLE = "Key was ";
  private static final int MILLISECOND_CONVERTER = 1000;
  private static final int MINIMUM_BOOLEAN_SIZE = 3;
  private static volatile ConfigurationUtil _myInstance;
  private static Application application;
  private static Properties configurableItems;
  
  static
  {
    JniLib.a(ConfigurationUtil.class, 1113);
  }
  
  public static native Boolean getBoolean(String paramString);
  
  private static native Properties getConfigurationSettings(String paramString);
  
  public static native ConfigurationUtil getInstance();
  
  public static native int getInt(String paramString);
  
  public static native int getIntMS(String paramString);
  
  public static native long getLong(String paramString);
  
  public static native long getLongMS(String paramString);
  
  public static native String getString(String paramString);
  
  public static native void init(Application paramApplication);
  
  public static native Boolean setProperty(String paramString1, String paramString2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\ConfigurationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */