package org.apache.cordova.api;

import java.io.PrintStream;
import org.apache.cordova.CordovaWebView;

public class PluginEntry
{
  public boolean onload = false;
  public CordovaPlugin plugin = null;
  public String pluginClass = "";
  public String service = "";
  
  public PluginEntry(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.service = paramString1;
    this.pluginClass = paramString2;
    this.onload = paramBoolean;
  }
  
  private Class getClassByName(String paramString)
    throws ClassNotFoundException
  {
    Class localClass = null;
    if (paramString != null) {
      localClass = Class.forName(paramString);
    }
    return localClass;
  }
  
  private boolean isCordovaPlugin(Class paramClass)
  {
    if (paramClass != null) {}
    for (boolean bool = CordovaPlugin.class.isAssignableFrom(paramClass);; bool = false) {
      return bool;
    }
  }
  
  public CordovaPlugin createPlugin(CordovaWebView paramCordovaWebView, CordovaInterface paramCordovaInterface)
  {
    if (this.plugin != null) {
      paramCordovaWebView = this.plugin;
    }
    for (;;)
    {
      return paramCordovaWebView;
      try
      {
        Class localClass = getClassByName(this.pluginClass);
        if (isCordovaPlugin(localClass))
        {
          this.plugin = ((CordovaPlugin)localClass.newInstance());
          this.plugin.initialize(paramCordovaInterface, paramCordovaWebView);
          paramCordovaWebView = this.plugin;
        }
      }
      catch (Exception paramCordovaWebView)
      {
        paramCordovaWebView.printStackTrace();
        System.out.println("Error adding plugin " + this.pluginClass + ".");
        paramCordovaWebView = null;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\api\PluginEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */