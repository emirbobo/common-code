package com.alipay.sdk.util;

import com.bangcle.andjni.JniLib;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

final class FileFetch
  implements Runnable
{
  private String a;
  private String b;
  private FileDownloader c;
  private boolean d = false;
  private long e;
  private long f;
  
  static
  {
    JniLib.a(FileFetch.class, 133);
  }
  
  public FileFetch(String paramString1, String paramString2, FileDownloader paramFileDownloader)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramFileDownloader;
  }
  
  public final native long a();
  
  public final native void a(long paramLong);
  
  public final native long b();
  
  public final native void b(long paramLong);
  
  public final native boolean c();
  
  public final native void d();
  
  public native void run();
  
  final class FileAccess
  {
    private FileOutputStream b;
    
    static
    {
      JniLib.a(FileAccess.class, 132);
    }
    
    public FileAccess()
    {
      try
      {
        FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
        localFileOutputStream.<init>(FileFetch.a(FileFetch.this), true);
        this.b = localFileOutputStream;
        return;
      }
      catch (FileNotFoundException this$1)
      {
        for (;;)
        {
          FileFetch.this.printStackTrace();
        }
      }
    }
    
    public native int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException;
    
    public native void a();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\FileFetch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */