package org.apache.cordova;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.cordova.api.LOG;
import org.xmlpull.v1.XmlPullParserException;

public class Config
{
  public static final String TAG = "Config";
  private static String errorUrl;
  private static Config self = null;
  private Whitelist externalWhitelist = new Whitelist();
  private Whitelist internalWhitelist = new Whitelist();
  private String startUrl;
  
  private Config() {}
  
  private Config(Activity paramActivity)
  {
    if (paramActivity == null) {
      LOG.i("CordovaLog", "There is no activity. Is this on the lock screen?");
    }
    for (;;)
    {
      return;
      int j = paramActivity.getResources().getIdentifier("config", "xml", paramActivity.getPackageName());
      int i = j;
      if (j == 0)
      {
        i = paramActivity.getResources().getIdentifier("cordova", "xml", paramActivity.getPackageName());
        LOG.i("CordovaLog", "config.xml missing, reverting to cordova.xml");
      }
      if (i == 0)
      {
        LOG.i("CordovaLog", "cordova.xml missing. Ignoring...");
      }
      else
      {
        this.internalWhitelist.addWhiteListEntry("file:///*", false);
        this.internalWhitelist.addWhiteListEntry("content:///*", false);
        this.internalWhitelist.addWhiteListEntry("data:*", false);
        XmlResourceParser localXmlResourceParser = paramActivity.getResources().getXml(i);
        i = -1;
        while (i != 1)
        {
          Object localObject1;
          String str;
          label207:
          Object localObject2;
          boolean bool;
          if (i == 2)
          {
            localObject1 = localXmlResourceParser.getName();
            if (!((String)localObject1).equals("access")) {
              break label315;
            }
            localObject1 = localXmlResourceParser.getAttributeValue(null, "origin");
            str = localXmlResourceParser.getAttributeValue(null, "subdomains");
            if (localXmlResourceParser.getAttributeValue(null, "launch-external") == null) {
              break label262;
            }
            j = 1;
            if (localObject1 != null)
            {
              if (j == 0) {
                break label273;
              }
              localObject2 = this.externalWhitelist;
              if ((str == null) || (str.compareToIgnoreCase("true") != 0)) {
                break label267;
              }
              bool = true;
              label240:
              ((Whitelist)localObject2).addWhiteListEntry((String)localObject1, bool);
            }
          }
          try
          {
            for (;;)
            {
              j = localXmlResourceParser.next();
              i = j;
              break;
              label262:
              j = 0;
              break label207;
              label267:
              bool = false;
              break label240;
              label273:
              localObject2 = this.internalWhitelist;
              if ((str != null) && (str.compareToIgnoreCase("true") == 0)) {}
              for (bool = true;; bool = false)
              {
                ((Whitelist)localObject2).addWhiteListEntry((String)localObject1, bool);
                break;
              }
              label315:
              if (((String)localObject1).equals("log"))
              {
                localObject1 = localXmlResourceParser.getAttributeValue(null, "level");
                LOG.i("CordovaLog", "Found log level %s", new Object[] { localObject1 });
                if (localObject1 != null) {
                  LOG.setLogLevel((String)localObject1);
                }
              }
              else if (((String)localObject1).equals("preference"))
              {
                localObject2 = localXmlResourceParser.getAttributeValue(null, "name");
                if (((String)localObject2).equals("splashscreen"))
                {
                  str = localXmlResourceParser.getAttributeValue(null, "value");
                  localObject1 = str;
                  if (str != null) {
                    localObject1 = "splash";
                  }
                  j = paramActivity.getResources().getIdentifier((String)localObject1, "drawable", paramActivity.getPackageName());
                  paramActivity.getIntent().putExtra((String)localObject2, j);
                  LOG.i("CordovaLog", "Found preference for %s=%s", new Object[] { localObject2, localObject1 });
                  Log.d("CordovaLog", "Found preference for " + (String)localObject2 + "=" + (String)localObject1);
                }
                else if (((String)localObject2).equals("backgroundColor"))
                {
                  j = localXmlResourceParser.getAttributeIntValue(null, "value", -16777216);
                  paramActivity.getIntent().putExtra((String)localObject2, j);
                  LOG.i("CordovaLog", "Found preference for %s=%d", new Object[] { localObject2, Integer.valueOf(j) });
                  Log.d("CordovaLog", "Found preference for " + (String)localObject2 + "=" + Integer.toString(j));
                }
                else if (((String)localObject2).equals("loadUrlTimeoutValue"))
                {
                  j = localXmlResourceParser.getAttributeIntValue(null, "value", 20000);
                  paramActivity.getIntent().putExtra((String)localObject2, j);
                  LOG.i("CordovaLog", "Found preference for %s=%d", new Object[] { localObject2, Integer.valueOf(j) });
                  Log.d("CordovaLog", "Found preference for " + (String)localObject2 + "=" + Integer.toString(j));
                }
                else if (((String)localObject2).equals("keepRunning"))
                {
                  bool = localXmlResourceParser.getAttributeValue(null, "value").equals("true");
                  paramActivity.getIntent().putExtra((String)localObject2, bool);
                }
                else if (((String)localObject2).equals("InAppBrowserStorageEnabled"))
                {
                  bool = localXmlResourceParser.getAttributeValue(null, "value").equals("true");
                  paramActivity.getIntent().putExtra((String)localObject2, bool);
                }
                else if (((String)localObject2).equals("disallowOverscroll"))
                {
                  bool = localXmlResourceParser.getAttributeValue(null, "value").equals("true");
                  paramActivity.getIntent().putExtra((String)localObject2, bool);
                }
                else if (((String)localObject2).equalsIgnoreCase("errorurl"))
                {
                  errorUrl = localXmlResourceParser.getAttributeValue(null, "value");
                }
                else
                {
                  localObject1 = localXmlResourceParser.getAttributeValue(null, "value");
                  paramActivity.getIntent().putExtra((String)localObject2, (String)localObject1);
                  LOG.i("CordovaLog", "Found preference for %s=%s", new Object[] { localObject2, localObject1 });
                  Log.d("CordovaLog", "Found preference for " + (String)localObject2 + "=" + (String)localObject1);
                }
              }
              else if (((String)localObject1).equals("content"))
              {
                str = localXmlResourceParser.getAttributeValue(null, "src");
                LOG.i("CordovaLog", "Found start page location: %s", new Object[] { str });
                if (str != null) {
                  if (Pattern.compile("^[a-z]+://").matcher(str).find())
                  {
                    this.startUrl = str;
                  }
                  else
                  {
                    localObject1 = str;
                    if (str.charAt(0) == '/') {
                      localObject1 = str.substring(1);
                    }
                    this.startUrl = ("file:///android_asset/www/" + (String)localObject1);
                  }
                }
              }
            }
          }
          catch (XmlPullParserException localXmlPullParserException)
          {
            localXmlPullParserException.printStackTrace();
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
        }
      }
    }
  }
  
  public static void addWhiteListEntry(String paramString, boolean paramBoolean)
  {
    if (self == null) {
      Log.e("Config", "Config was not initialised. Did you forget to Config.init(this)?");
    }
    for (;;)
    {
      return;
      self.internalWhitelist.addWhiteListEntry(paramString, paramBoolean);
    }
  }
  
  public static String getErrorUrl()
  {
    return errorUrl;
  }
  
  public static String getStartUrl()
  {
    if ((self == null) || (self.startUrl == null)) {}
    for (String str = "file:///android_asset/www/index.html";; str = self.startUrl) {
      return str;
    }
  }
  
  public static void init()
  {
    if (self == null) {
      self = new Config();
    }
  }
  
  public static void init(Activity paramActivity)
  {
    if (self == null) {
      self = new Config(paramActivity);
    }
  }
  
  public static boolean isUrlExternallyWhiteListed(String paramString)
  {
    if (self == null) {
      Log.e("Config", "Config was not initialised. Did you forget to Config.init(this)?");
    }
    for (boolean bool = false;; bool = self.externalWhitelist.isUrlWhiteListed(paramString)) {
      return bool;
    }
  }
  
  public static boolean isUrlWhiteListed(String paramString)
  {
    if (self == null) {
      Log.e("Config", "Config was not initialised. Did you forget to Config.init(this)?");
    }
    for (boolean bool = false;; bool = self.internalWhitelist.isUrlWhiteListed(paramString)) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */