package cn.dm.download;

import android.content.Context;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.a;
import cn.dm.download.util.Constants;
import cn.dm.download.util.b;
import cn.dm.download.util.c;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;

public class e
  extends Thread
{
  private static final int BUFFER_SIZE = 10240;
  private static b j = new b(e.class.getSimpleName());
  private long A;
  private long B = 0L;
  private final int C;
  private final int D;
  private final int E;
  private String F = "";
  public boolean G;
  public boolean H;
  private File file;
  private Context mContext;
  private a n;
  private DownloadAppInfo o;
  private long y;
  private long z;
  
  e(Context paramContext, File paramFile, long paramLong1, long paramLong2, a parama, DownloadAppInfo paramDownloadAppInfo)
  {
    this.mContext = paramContext;
    this.n = parama;
    this.o = paramDownloadAppInfo;
    this.file = paramFile;
    this.y = paramLong1;
    this.A = paramLong1;
    this.z = paramLong2;
    this.B = paramLong1;
    this.F = paramFile.getAbsolutePath();
  }
  
  private static boolean a(File paramFile)
  {
    String str = paramFile.getAbsolutePath();
    if (str.endsWith(Constants.Unfinished_Sign)) {
      paramFile.renameTo(new File(str.substring(0, str.length() - Constants.Unfinished_Sign.length())));
    }
    return true;
  }
  
  public void run()
  {
    Object localObject3 = new byte['⠀'];
    long l1;
    for (;;)
    {
      try
      {
        localObject4 = new java/net/URL;
        ((URL)localObject4).<init>(this.o.getDownloadUrl());
        localObject1 = c.f(this.mContext);
        if (localObject1 != null)
        {
          localObject1 = (HttpURLConnection)((URL)localObject4).openConnection((Proxy)localObject1);
          ((HttpURLConnection)localObject1).setConnectTimeout(40000);
          ((HttpURLConnection)localObject1).setReadTimeout(60000);
          ((HttpURLConnection)localObject1).setAllowUserInteraction(true);
          localObject4 = j;
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>("下载文件：");
          ((StringBuilder)localObject4).append(this.file.getPath());
          localObject4 = new java/io/RandomAccessFile;
          ((RandomAccessFile)localObject4).<init>(this.file, "rw");
          if (this.file.getAbsoluteFile().toString().startsWith(this.mContext.getFilesDir().getAbsolutePath()))
          {
            localObject5 = new java/lang/StringBuilder;
            ((StringBuilder)localObject5).<init>("chmod 777 ");
            localObject5 = this.file.getAbsolutePath();
            Runtime.getRuntime().exec((String)localObject5);
          }
          if (this.y != 0L) {
            continue;
          }
          if (this.n.i()) {
            continue;
          }
          return;
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        File localFile;
        Object localObject1 = j;
        new StringBuilder("下载过程中网络出现异常：").append(localSocketTimeoutException.getMessage());
        this.n.onDownloadFailed(this.o);
        continue;
        ((RandomAccessFile)localObject4).seek(0L);
        this.B = 0L;
        this.A = 0L;
        continue;
      }
      catch (Exception localException)
      {
        Object localObject4;
        Object localObject5;
        b localb = j;
        new StringBuilder("下载过程中出现异常:").append(localException.getMessage());
        this.n.onDownloadFailed(this.o);
        continue;
        if ((!this.G) && (!this.H)) {
          continue;
        }
        ((BufferedInputStream)localObject5).close();
        ((RandomAccessFile)localObject4).close();
        if (!this.G) {
          continue;
        }
        this.n.a(this.o);
        if (!this.H) {
          continue;
        }
        this.n.c(this.F);
        continue;
        i = ((BufferedInputStream)localObject5).read(localb, 0, 10240);
        if (i == -1) {
          continue;
        }
        ((RandomAccessFile)localObject4).write(localb, 0, i);
        this.A += i;
        if (this.A <= this.z) {
          break label757;
        }
      }
      localObject1 = (HttpURLConnection)((URL)localObject4).openConnection();
      continue;
      if (this.n.j())
      {
        localObject5 = new java/lang/StringBuilder;
        ((StringBuilder)localObject5).<init>("bytes=");
        ((HttpURLConnection)localObject1).setRequestProperty("Range", this.y + "-" + this.z);
        localObject5 = j;
        localObject5 = new java/lang/StringBuilder;
        ((StringBuilder)localObject5).<init>("下载ResponseCode：");
        ((StringBuilder)localObject5).append(((HttpURLConnection)localObject1).getResponseCode());
        if (((HttpURLConnection)localObject1).getResponseCode() != 206) {
          continue;
        }
        ((RandomAccessFile)localObject4).seek(this.y);
        localObject5 = new java/io/BufferedInputStream;
        ((BufferedInputStream)localObject5).<init>(((HttpURLConnection)localObject1).getInputStream());
        l1 = System.currentTimeMillis();
        if (this.A < this.z) {
          continue;
        }
        localObject1 = this.file;
        localObject3 = ((File)localObject1).getAbsolutePath();
        if (((String)localObject3).endsWith(Constants.Unfinished_Sign))
        {
          localObject3 = ((String)localObject3).substring(0, ((String)localObject3).length() - Constants.Unfinished_Sign.length());
          localFile = new java/io/File;
          localFile.<init>((String)localObject3);
          ((File)localObject1).renameTo(localFile);
        }
        this.n.b(this.F);
        ((BufferedInputStream)localObject5).close();
        ((RandomAccessFile)localObject4).close();
      }
    }
    int i;
    long l2 = this.B;
    for (this.B = (i - (this.A - this.z) + 1L + l2);; this.B = (i + l2))
    {
      l2 = System.currentTimeMillis();
      if (l2 - l1 < 1000L) {
        break;
      }
      Object localObject2 = j;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("当前下载大小：");
      ((StringBuilder)localObject2).append(this.B);
      this.o.setCurrentDownloadSize(this.B);
      this.n.onProgressChange(this.o);
      l1 = l2;
      break;
      label757:
      l2 = this.B;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */