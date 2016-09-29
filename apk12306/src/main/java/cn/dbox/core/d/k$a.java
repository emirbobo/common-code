package cn.dbox.core.d;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class k$a
  extends FilterInputStream
{
  public k$a(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    long l2;
    for (long l1 = 0L;; l1 = l2 + l1)
    {
      if (l1 < paramLong)
      {
        long l3 = this.in.skip(paramLong - l1);
        l2 = l3;
        if (l3 != 0L) {
          continue;
        }
        if (read() >= 0) {}
      }
      else
      {
        return l1;
      }
      l2 = 1L;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\k$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */