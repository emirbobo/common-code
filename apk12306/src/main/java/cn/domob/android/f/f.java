package cn.domob.android.f;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class f
{
  private static String b = "UTF-8";
  protected ConcurrentHashMap<String, String> a;
  
  public f()
  {
    c();
  }
  
  public f(String paramString1, String paramString2)
  {
    c();
    a(paramString1, paramString2);
  }
  
  public f(Map<String, String> paramMap)
  {
    c();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }
  
  public f(Object... paramVarArgs)
  {
    c();
    int j = paramVarArgs.length;
    if (j % 2 != 0) {
      throw new IllegalArgumentException("Supplied arguments must be even");
    }
    for (int i = 0; i < j; i += 2) {
      a(String.valueOf(paramVarArgs[i]), String.valueOf(paramVarArgs[(i + 1)]));
    }
  }
  
  private void c()
  {
    this.a = new ConcurrentHashMap();
  }
  
  protected List<BasicNameValuePair> a()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localLinkedList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localLinkedList;
  }
  
  public void a(String paramString)
  {
    this.a.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      this.a.put(paramString1, paramString2);
    }
  }
  
  protected String b()
  {
    return URLEncodedUtils.format(a(), b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\f\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */