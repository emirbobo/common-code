package cn.dbox.core.d;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class m$2
  extends LinkedHashMap<String, SoftReference<Bitmap>>
{
  private static final long serialVersionUID = 6040103833179403725L;
  
  m$2(m paramm, int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(paramInt, paramFloat, paramBoolean);
  }
  
  protected boolean removeEldestEntry(Map.Entry<String, SoftReference<Bitmap>> paramEntry)
  {
    if (size() > 15) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\m$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */