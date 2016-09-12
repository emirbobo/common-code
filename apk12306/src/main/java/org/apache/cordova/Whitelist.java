package org.apache.cordova;

import android.net.Uri;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.cordova.api.LOG;

public class Whitelist
{
  public static final String TAG = "Whitelist";
  private ArrayList<URLPattern> whiteList = new ArrayList();
  
  public void addWhiteListEntry(String paramString, boolean paramBoolean)
  {
    if (this.whiteList != null) {}
    try
    {
      if (paramString.compareTo("*") == 0)
      {
        LOG.d("Whitelist", "Unlimited access to network resources");
        this.whiteList = null;
      }
      for (;;)
      {
        return;
        localObject1 = Pattern.compile("^((\\*|[A-Za-z-]+):(//)?)?(\\*|((\\*\\.)?[^*/:]+))?(:(\\d+))?(/.*)?").matcher(paramString);
        if (((Matcher)localObject1).matches())
        {
          localObject2 = ((Matcher)localObject1).group(2);
          str2 = ((Matcher)localObject1).group(4);
          String str1;
          if (!"file".equals(localObject2))
          {
            str1 = str2;
            if (!"content".equals(localObject2)) {}
          }
          else
          {
            str1 = str2;
            if (str2 == null) {
              str1 = "*";
            }
          }
          str2 = ((Matcher)localObject1).group(8);
          localObject1 = ((Matcher)localObject1).group(9);
          if (localObject2 != null) {
            break;
          }
          localObject2 = this.whiteList;
          localObject3 = new org/apache/cordova/Whitelist$URLPattern;
          ((URLPattern)localObject3).<init>("http", str1, str2, (String)localObject1);
          ((ArrayList)localObject2).add(localObject3);
          localObject3 = this.whiteList;
          localObject2 = new org/apache/cordova/Whitelist$URLPattern;
          ((URLPattern)localObject2).<init>("https", str1, str2, (String)localObject1);
          ((ArrayList)localObject3).add(localObject2);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        String str2;
        LOG.d("Whitelist", "Failed to add origin %s", new Object[] { paramString });
        continue;
        Object localObject3 = this.whiteList;
        URLPattern localURLPattern = new org/apache/cordova/Whitelist$URLPattern;
        localURLPattern.<init>((String)localObject2, localException, str2, (String)localObject1);
        ((ArrayList)localObject3).add(localURLPattern);
      }
    }
  }
  
  public boolean isUrlWhiteListed(String paramString)
  {
    boolean bool = true;
    if (this.whiteList == null) {}
    for (;;)
    {
      return bool;
      Uri localUri = Uri.parse(paramString);
      paramString = this.whiteList.iterator();
      for (;;)
      {
        if (paramString.hasNext()) {
          if (((URLPattern)paramString.next()).matches(localUri)) {
            break;
          }
        }
      }
      bool = false;
    }
  }
  
  private static class URLPattern
  {
    public Pattern host;
    public Pattern path;
    public Integer port;
    public Pattern scheme;
    
    public URLPattern(String paramString1, String paramString2, String paramString3, String paramString4)
      throws MalformedURLException
    {
      if (paramString1 != null) {}
      for (;;)
      {
        try
        {
          if ("*".equals(paramString1))
          {
            this.scheme = null;
            if ("*".equals(paramString2))
            {
              this.host = null;
              if ((paramString3 != null) && (!"*".equals(paramString3))) {
                break label167;
              }
              this.port = null;
              if ((paramString4 != null) && (!"/*".equals(paramString4))) {
                break label183;
              }
              this.path = null;
            }
          }
          else
          {
            this.scheme = Pattern.compile(regexFromPattern(paramString1, false));
            continue;
          }
          if (!paramString2.startsWith("*.")) {
            break label151;
          }
        }
        catch (NumberFormatException paramString1)
        {
          throw new MalformedURLException("Port must be a number");
        }
        paramString1 = new java/lang/StringBuilder;
        paramString1.<init>();
        this.host = Pattern.compile("([a-z0-9.-]*\\.)?" + regexFromPattern(paramString2.substring(2), false));
        continue;
        label151:
        this.host = Pattern.compile(regexFromPattern(paramString2, false));
        continue;
        label167:
        this.port = Integer.valueOf(Integer.parseInt(paramString3, 10));
        continue;
        label183:
        this.path = Pattern.compile(regexFromPattern(paramString4, true));
      }
    }
    
    private String regexFromPattern(String paramString, boolean paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((c == '*') && (paramBoolean)) {
          localStringBuilder.append(".");
        }
        for (;;)
        {
          localStringBuilder.append(c);
          i++;
          break;
          if ("\\.[]{}()^$?+|".indexOf(c) > -1) {
            localStringBuilder.append('\\');
          }
        }
      }
      return localStringBuilder.toString();
    }
    
    public boolean matches(Uri paramUri)
    {
      bool2 = false;
      try
      {
        if (this.scheme != null)
        {
          bool1 = bool2;
          if (!this.scheme.matcher(paramUri.getScheme()).matches()) {}
        }
        else if (this.host != null)
        {
          bool1 = bool2;
          if (!this.host.matcher(paramUri.getHost()).matches()) {}
        }
        else if (this.port != null)
        {
          bool1 = bool2;
          if (!this.port.equals(Integer.valueOf(paramUri.getPort()))) {}
        }
        else if (this.path != null)
        {
          boolean bool3 = this.path.matcher(paramUri.getPath()).matches();
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      catch (Exception paramUri)
      {
        for (;;)
        {
          LOG.d("Whitelist", paramUri.toString());
          boolean bool1 = bool2;
        }
      }
      return bool1;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Whitelist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */