import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public final class bm
  implements X509HostnameVerifier
{
  private static final Pattern a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
  
  private static List<String> a(X509Certificate paramX509Certificate, int paramInt)
  {
    localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate != null) {
        break label23;
      }
      paramX509Certificate = Collections.emptyList();
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      for (;;)
      {
        paramX509Certificate = Collections.emptyList();
        continue;
        paramX509Certificate = localArrayList;
      }
    }
    return paramX509Certificate;
    label23:
    paramX509Certificate = paramX509Certificate.iterator();
    while (paramX509Certificate.hasNext())
    {
      List localList = (List)paramX509Certificate.next();
      if ((localList != null) && (localList.size() >= 2))
      {
        Object localObject = (Integer)localList.get(0);
        if ((localObject != null) && (((Integer)localObject).intValue() == paramInt))
        {
          localObject = (String)localList.get(1);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty())) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      paramString2 = paramString2.toLowerCase(Locale.US);
      if (!paramString2.contains("*"))
      {
        bool1 = paramString1.equals(paramString2);
      }
      else if (paramString2.startsWith("*."))
      {
        bool1 = bool2;
        if (paramString1.regionMatches(0, paramString2, 2, paramString2.length() - 2)) {}
      }
      else
      {
        int i = paramString2.indexOf('*');
        if (i > paramString2.indexOf('.'))
        {
          bool1 = false;
        }
        else if (!paramString1.regionMatches(0, paramString2, 0, i))
        {
          bool1 = false;
        }
        else
        {
          int k = paramString2.length() - (i + 1);
          int j = paramString1.length() - k;
          if ((paramString1.indexOf('.', i) < j) && (!paramString1.endsWith(".clients.google.com")))
          {
            bool1 = false;
          }
          else
          {
            bool1 = bool2;
            if (!paramString1.regionMatches(j, paramString2, i + 1, k)) {
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  public final void verify(String paramString, X509Certificate paramX509Certificate)
    throws SSLException
  {
    boolean bool2 = true;
    boolean bool1;
    if (a.matcher(paramString).matches())
    {
      paramX509Certificate = a(paramX509Certificate, 7).iterator();
      while (paramX509Certificate.hasNext()) {
        if (paramString.equalsIgnoreCase((String)paramX509Certificate.next())) {
          bool1 = bool2;
        }
      }
    }
    while (!bool1)
    {
      throw new SSLException("not verified");
      bool1 = false;
      continue;
      paramString = paramString.toLowerCase(Locale.US);
      Iterator localIterator = a(paramX509Certificate, 2).iterator();
      for (int i = 0;; i = 1)
      {
        if (!localIterator.hasNext()) {
          break label136;
        }
        bool1 = bool2;
        if (a(paramString, (String)localIterator.next())) {
          break;
        }
      }
      label136:
      if (i == 0)
      {
        paramX509Certificate = new co(paramX509Certificate.getSubjectX500Principal()).a("cn");
        if (paramX509Certificate != null)
        {
          bool1 = a(paramString, paramX509Certificate);
          continue;
        }
      }
      bool1 = false;
    }
  }
  
  public final void verify(String paramString, SSLSocket paramSSLSocket)
    throws IOException
  {}
  
  public final void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SSLException
  {}
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      verify(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      bool = true;
    }
    catch (SSLException paramString)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */