package cn.dm.download;

import android.os.Environment;
import android.os.StatFs;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.a;
import cn.dm.download.util.Constants;
import cn.dm.download.util.b;
import cn.dm.download.util.c;
import java.io.File;

public class d
{
  private static b j = new b(d.class.getSimpleName());
  private a n;
  private DownloadAppInfo o;
  private int w = 2097152;
  private int x;
  
  public d(DownloadAppInfo paramDownloadAppInfo, a parama)
  {
    this.o = paramDownloadAppInfo;
    this.n = parama;
  }
  
  public final boolean a(long paramLong, String paramString)
  {
    boolean bool = false;
    if (paramLong == Constants.DownloadUrlWrong)
    {
      paramString = j;
      this.n.onDownloadFailed(this.o);
    }
    for (;;)
    {
      return bool;
      if (c.s())
      {
        StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (localStatFs.getBlockSize() * localStatFs.getAvailableBlocks() > this.w + paramLong) {
          c.t(paramString);
        }
        for (;;)
        {
          bool = true;
          break;
          paramString = j;
          this.n.onDownloadFailed(this.o);
        }
      }
      paramString = j;
      this.o.setErrorFlag(1);
      this.n.onDownloadFailed(this.o);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */