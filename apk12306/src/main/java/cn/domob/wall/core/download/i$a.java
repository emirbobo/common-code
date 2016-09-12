package cn.domob.wall.core.download;

import java.io.File;
import java.util.Comparator;

class i$a
  implements Comparator<File>
{
  private i$a(i parami) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    int i;
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      i = 1;
    }
    for (;;)
    {
      return i;
      if (paramFile1.lastModified() == paramFile2.lastModified()) {
        i = 0;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\i$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */