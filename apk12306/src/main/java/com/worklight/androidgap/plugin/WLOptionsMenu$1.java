package com.worklight.androidgap.plugin;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;

class WLOptionsMenu$1
  implements Comparator<WLMenuItem>
{
  static
  {
    JniLib.a(1.class, 1204);
  }
  
  WLOptionsMenu$1(WLOptionsMenu paramWLOptionsMenu) {}
  
  public native int compare(WLMenuItem paramWLMenuItem1, WLMenuItem paramWLMenuItem2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WLOptionsMenu$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */