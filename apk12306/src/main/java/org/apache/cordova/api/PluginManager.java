package org.apache.cordova.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.webkit.WebResourceResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

public class PluginManager
{
  private static String TAG = "PluginManager";
  private final CordovaWebView app;
  private final CordovaInterface ctx;
  private final HashMap<String, PluginEntry> entries = new HashMap();
  private boolean firstRun;
  protected HashMap<String, String> urlMap = new HashMap();
  
  public PluginManager(CordovaWebView paramCordovaWebView, CordovaInterface paramCordovaInterface)
  {
    this.ctx = paramCordovaInterface;
    this.app = paramCordovaWebView;
    this.firstRun = true;
  }
  
  private void pluginConfigurationMissing()
  {
    LOG.e(TAG, "=====================================================================================");
    LOG.e(TAG, "ERROR: plugin.xml is missing.  Add res/xml/plugins.xml to your project.");
    LOG.e(TAG, "https://git-wip-us.apache.org/repos/asf?p=incubator-cordova-android.git;a=blob;f=framework/res/xml/plugins.xml");
    LOG.e(TAG, "=====================================================================================");
  }
  
  public void addService(String paramString1, String paramString2)
  {
    addService(new PluginEntry(paramString1, paramString2, false));
  }
  
  public void addService(PluginEntry paramPluginEntry)
  {
    this.entries.put(paramPluginEntry.service, paramPluginEntry);
  }
  
  public void clearPluginObjects()
  {
    Iterator localIterator = this.entries.values().iterator();
    while (localIterator.hasNext()) {
      ((PluginEntry)localIterator.next()).plugin = null;
    }
  }
  
  public boolean exec(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool2 = true;
    CordovaPlugin localCordovaPlugin = getPlugin(paramString1);
    boolean bool1;
    if (localCordovaPlugin == null)
    {
      Log.d(TAG, "exec() call to unknown plugin: " + paramString1);
      paramString1 = new PluginResult(PluginResult.Status.CLASS_NOT_FOUND_EXCEPTION);
      this.app.sendPluginResult(paramString1, paramString3);
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        paramString1 = new org/apache/cordova/api/CallbackContext;
        paramString1.<init>(paramString3, this.app);
        if (localCordovaPlugin.execute(paramString2, paramString4, paramString1)) {
          break label148;
        }
        paramString1 = new org/apache/cordova/api/PluginResult;
        paramString1.<init>(PluginResult.Status.INVALID_ACTION);
        this.app.sendPluginResult(paramString1, paramString3);
        bool1 = bool2;
      }
      catch (JSONException paramString1)
      {
        paramString1 = new PluginResult(PluginResult.Status.JSON_EXCEPTION);
        this.app.sendPluginResult(paramString1, paramString3);
        bool1 = bool2;
      }
      continue;
      label148:
      bool1 = paramString1.isFinished();
    }
  }
  
  @Deprecated
  public boolean exec(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    return exec(paramString1, paramString2, paramString3, paramString4);
  }
  
  public CordovaPlugin getPlugin(String paramString)
  {
    PluginEntry localPluginEntry = (PluginEntry)this.entries.get(paramString);
    if (localPluginEntry == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      CordovaPlugin localCordovaPlugin = localPluginEntry.plugin;
      paramString = localCordovaPlugin;
      if (localCordovaPlugin == null) {
        paramString = localPluginEntry.createPlugin(this.app, this.ctx);
      }
    }
  }
  
  public void init()
  {
    LOG.d(TAG, "init()");
    if (this.firstRun)
    {
      loadPlugins();
      this.firstRun = false;
    }
    for (;;)
    {
      startupPlugins();
      return;
      onPause(false);
      onDestroy();
      clearPluginObjects();
    }
  }
  
  public void loadPlugins()
  {
    int j = this.ctx.getActivity().getResources().getIdentifier("config", "xml", this.ctx.getActivity().getPackageName());
    int i = j;
    if (j == 0)
    {
      i = this.ctx.getActivity().getResources().getIdentifier("plugins", "xml", this.ctx.getActivity().getPackageName());
      LOG.i(TAG, "Using plugins.xml instead of config.xml.  plugins.xml will eventually be deprecated");
    }
    if (i == 0) {
      pluginConfigurationMissing();
    }
    for (;;)
    {
      return;
      XmlResourceParser localXmlResourceParser = this.ctx.getActivity().getResources().getXml(i);
      j = -1;
      Object localObject3 = "";
      Object localObject6 = "";
      int k = 0;
      while (j != 1)
      {
        Object localObject7;
        Object localObject2;
        Object localObject1;
        if (j == 2)
        {
          localObject7 = localXmlResourceParser.getName();
          if (((String)localObject7).equals("plugin"))
          {
            localObject2 = localXmlResourceParser.getAttributeValue(null, "name");
            localObject1 = localXmlResourceParser.getAttributeValue(null, "value");
            addService(new PluginEntry((String)localObject2, (String)localObject1, "true".equals(localXmlResourceParser.getAttributeValue(null, "onload"))));
            i = k;
          }
        }
        try
        {
          for (;;)
          {
            k = localXmlResourceParser.next();
            j = k;
            k = i;
            localObject6 = localObject1;
            localObject3 = localObject2;
            break;
            if (((String)localObject7).equals("url-filter"))
            {
              this.urlMap.put(localXmlResourceParser.getAttributeValue(null, "value"), localObject3);
              i = k;
              localObject1 = localObject6;
              localObject2 = localObject3;
            }
            else if (((String)localObject7).equals("feature"))
            {
              i = 1;
              localXmlResourceParser.getAttributeValue(null, "name");
              localObject1 = localObject6;
              localObject2 = localObject3;
            }
            else
            {
              i = k;
              localObject1 = localObject6;
              localObject2 = localObject3;
              if (((String)localObject7).equals("param"))
              {
                i = k;
                localObject1 = localObject6;
                localObject2 = localObject3;
                if (k != 0)
                {
                  localObject1 = localXmlResourceParser.getAttributeValue(null, "name");
                  if (((String)localObject1).equals("service")) {
                    localObject7 = localXmlResourceParser.getAttributeValue(null, "value");
                  }
                  for (;;)
                  {
                    i = k;
                    localObject1 = localObject6;
                    localObject2 = localObject7;
                    if (((String)localObject7).length() <= 0) {
                      break;
                    }
                    i = k;
                    localObject1 = localObject6;
                    localObject2 = localObject7;
                    if (((String)localObject6).length() <= 0) {
                      break;
                    }
                    addService(new PluginEntry((String)localObject7, (String)localObject6, "true".equals(localXmlResourceParser.getAttributeValue(null, "onload"))));
                    localObject2 = "";
                    localObject1 = "";
                    i = k;
                    break;
                    localObject7 = localObject3;
                    if (((String)localObject1).equals("package"))
                    {
                      localObject6 = localXmlResourceParser.getAttributeValue(null, "value");
                      localObject7 = localObject3;
                    }
                  }
                  i = k;
                  localObject1 = localObject6;
                  localObject2 = localObject3;
                  if (j == 3)
                  {
                    i = k;
                    localObject1 = localObject6;
                    localObject2 = localObject3;
                    if (localXmlResourceParser.getName().equals("feature"))
                    {
                      localObject2 = "";
                      localObject1 = "";
                      i = 0;
                    }
                  }
                }
              }
            }
          }
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          localXmlPullParserException.printStackTrace();
          k = i;
          localObject6 = localObject1;
          Object localObject4 = localObject2;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          k = i;
          localObject6 = localObject1;
          Object localObject5 = localObject2;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.entries.values().iterator();
    while (localIterator.hasNext())
    {
      PluginEntry localPluginEntry = (PluginEntry)localIterator.next();
      if (localPluginEntry.plugin != null) {
        localPluginEntry.plugin.onDestroy();
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    Iterator localIterator = this.entries.values().iterator();
    while (localIterator.hasNext())
    {
      PluginEntry localPluginEntry = (PluginEntry)localIterator.next();
      if (localPluginEntry.plugin != null) {
        localPluginEntry.plugin.onNewIntent(paramIntent);
      }
    }
  }
  
  public boolean onOverrideUrlLoading(String paramString)
  {
    Iterator localIterator = this.urlMap.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.startsWith((String)localEntry.getKey()));
    for (boolean bool = getPlugin((String)localEntry.getValue()).onOverrideUrlLoading(paramString);; bool = false) {
      return bool;
    }
  }
  
  public void onPause(boolean paramBoolean)
  {
    Iterator localIterator = this.entries.values().iterator();
    while (localIterator.hasNext())
    {
      PluginEntry localPluginEntry = (PluginEntry)localIterator.next();
      if (localPluginEntry.plugin != null) {
        localPluginEntry.plugin.onPause(paramBoolean);
      }
    }
  }
  
  public void onReset()
  {
    Iterator localIterator = this.entries.values().iterator();
    while (localIterator.hasNext())
    {
      CordovaPlugin localCordovaPlugin = ((PluginEntry)localIterator.next()).plugin;
      if (localCordovaPlugin != null) {
        localCordovaPlugin.onReset();
      }
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    Iterator localIterator = this.entries.values().iterator();
    while (localIterator.hasNext())
    {
      PluginEntry localPluginEntry = (PluginEntry)localIterator.next();
      if (localPluginEntry.plugin != null) {
        localPluginEntry.plugin.onResume(paramBoolean);
      }
    }
  }
  
  public Object postMessage(String paramString, Object paramObject)
  {
    Object localObject = this.ctx.onMessage(paramString, paramObject);
    if (localObject != null) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      Iterator localIterator = this.entries.values().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (PluginEntry)localIterator.next();
          if (((PluginEntry)localObject).plugin != null)
          {
            localObject = ((PluginEntry)localObject).plugin.onMessage(paramString, paramObject);
            if (localObject != null)
            {
              paramString = (String)localObject;
              break;
            }
          }
        }
      }
      paramString = null;
    }
  }
  
  public WebResourceResponse shouldInterceptRequest(String paramString)
  {
    Iterator localIterator = this.urlMap.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.startsWith((String)localEntry.getKey()));
    for (paramString = getPlugin((String)localEntry.getValue()).shouldInterceptRequest(paramString);; paramString = null) {
      return paramString;
    }
  }
  
  public void startupPlugins()
  {
    Iterator localIterator = this.entries.values().iterator();
    while (localIterator.hasNext())
    {
      PluginEntry localPluginEntry = (PluginEntry)localIterator.next();
      if (localPluginEntry.onload) {
        localPluginEntry.createPlugin(this.app, this.ctx);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\api\PluginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */