package cn.dbox.core.f;

import cn.dbox.core.bean.a;
import cn.dbox.core.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class b$b
  extends b.c
{
  b$b(b paramb, c paramc, a parama)
  {
    super(paramb, paramc, parama, null);
    this.b.put("sid", paramc.e());
  }
  
  public void a(String paramString)
  {
    this.b.put("origin", paramString);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if ((str != null) && (localObject != null)) {
          this.b.put(str, localObject);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */