package cn.dbox.core.h;

import android.net.wifi.ScanResult;
import java.util.Comparator;

final class b$1
  implements Comparator<ScanResult>
{
  public int a(ScanResult paramScanResult1, ScanResult paramScanResult2)
  {
    int j = paramScanResult2.level - paramScanResult1.level;
    int i = 0;
    if (j > 0) {
      i = 1;
    }
    for (;;)
    {
      return i;
      if (j < 0) {
        i = -1;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\h\b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */