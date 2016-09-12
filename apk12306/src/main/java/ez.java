import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public final class ez
{
  private static String jdField_a_of_type_JavaLangString = "UTF-8";
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap<String, fa> b;
  private ConcurrentHashMap<String, ArrayList<String>> c;
  
  public ez()
  {
    a();
  }
  
  public ez(Map<String, String> paramMap)
  {
    a();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      paramMap = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if ((paramMap != null) && (localObject != null)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramMap, localObject);
      }
    }
  }
  
  private List<BasicNameValuePair> a()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator1.hasNext())
    {
      localEntry = (Map.Entry)localIterator1.next();
      localLinkedList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    localIterator1 = this.c.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      localEntry = (Map.Entry)localIterator1.next();
      Iterator localIterator2 = ((ArrayList)localEntry.getValue()).iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localLinkedList.add(new BasicNameValuePair((String)localEntry.getKey(), str));
      }
    }
    return localLinkedList;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    this.c = new ConcurrentHashMap();
  }
  
  protected final String a()
  {
    return URLEncodedUtils.format(a(), jdField_a_of_type_JavaLangString);
  }
  
  public final HttpEntity a()
  {
    Object localObject1;
    if (!this.b.isEmpty())
    {
      fc localfc = new fc();
      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localfc.a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
      int j = this.b.entrySet().size();
      Object localObject3 = this.b.entrySet().iterator();
      int i = 0;
      Object localObject4;
      label163:
      Object localObject5;
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject3).next();
        localObject4 = (fa)((Map.Entry)localObject1).getValue();
        boolean bool;
        if (((fa)localObject4).jdField_a_of_type_JavaIoInputStream != null)
        {
          if (i != j - 1) {
            break label211;
          }
          bool = true;
          localObject5 = (String)((Map.Entry)localObject1).getKey();
          if (((fa)localObject4).jdField_a_of_type_JavaLangString == null) {
            break label216;
          }
        }
        label211:
        label216:
        for (localObject1 = ((fa)localObject4).jdField_a_of_type_JavaLangString;; localObject1 = "nofilename")
        {
          localfc.a((String)localObject5, (String)localObject1, ((fa)localObject4).jdField_a_of_type_JavaIoInputStream, bool);
          i++;
          break;
          bool = false;
          break label163;
        }
      }
      localObject1 = this.c.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject5 = ((ArrayList)((Map.Entry)localObject3).getValue()).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject4 = (String)((Iterator)localObject5).next();
          localfc.a((String)((Map.Entry)localObject3).getKey(), (String)localObject4);
        }
      }
      localObject1 = localfc;
    }
    for (;;)
    {
      return (HttpEntity)localObject1;
      try
      {
        localObject1 = new org/apache/http/client/entity/UrlEncodedFormEntity;
        ((UrlEncodedFormEntity)localObject1).<init>(a(), jdField_a_of_type_JavaLangString);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  public final void a(String paramString1, InputStream paramInputStream, String paramString2)
  {
    if ((paramString1 != null) && (paramInputStream != null)) {
      this.b.put(paramString1, new fa(paramInputStream, paramString2));
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    Map.Entry localEntry;
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
    }
    localObject = this.b.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append("FILE");
    }
    Iterator localIterator1 = this.c.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      localEntry = (Map.Entry)localIterator1.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localObject = (ArrayList)localEntry.getValue();
      Iterator localIterator2 = ((ArrayList)localObject).iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        if (((ArrayList)localObject).indexOf(str) != 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */