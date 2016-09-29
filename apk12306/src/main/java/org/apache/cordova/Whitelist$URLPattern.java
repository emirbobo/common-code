package org.apache.cordova;

import android.net.Uri;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.cordova.api.LOG;

class Whitelist$URLPattern
{
  public Pattern host;
  public Pattern path;
  public Integer port;
  public Pattern scheme;
  
  public Whitelist$URLPattern(String paramString1, String paramString2, String paramString3, String paramString4)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Whitelist$URLPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */