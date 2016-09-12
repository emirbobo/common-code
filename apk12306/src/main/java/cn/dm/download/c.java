package cn.dm.download;

import cn.dm.download.util.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class c
{
  private static b j = new b(c.class.getSimpleName());
  public static HashMap v = new HashMap();
  
  public static void a(Long paramLong)
  {
    b localb = j;
    v.remove(paramLong);
  }
  
  public static void a(Long paramLong, a parama)
  {
    b localb = j;
    v.put(paramLong, parama);
  }
  
  public static a b(Long paramLong)
  {
    return (a)v.get(paramLong);
  }
  
  public static int k()
  {
    Object localObject = v.values().iterator();
    int i = 0;
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        localObject = j;
        new StringBuilder("当前正在下载的线程个数:").append(i);
        return i;
      }
      if (((a)((Iterator)localObject).next()).t == 2) {
        i++;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */