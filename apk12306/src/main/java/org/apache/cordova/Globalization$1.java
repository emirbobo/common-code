package org.apache.cordova;

import java.util.Comparator;
import java.util.Map;

class Globalization$1
  implements Comparator<String>
{
  Globalization$1(Globalization paramGlobalization, Map paramMap) {}
  
  public int compare(String paramString1, String paramString2)
  {
    return ((Integer)this.val$namesMap.get(paramString1)).compareTo((Integer)this.val$namesMap.get(paramString2));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Globalization$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */