package com.alipay.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bangcle.andjni.JniLib;
import java.lang.ref.WeakReference;
import org.apache.http.HttpEntity;

public final class FileDownloader
{
  public boolean a;
  private String b;
  private String c;
  private String d;
  private IDownloadProgress e;
  private FileFetch f;
  
  static
  {
    JniLib.a(FileDownloader.class, 131);
  }
  
  public FileDownloader()
  {
    this.a = false;
  }
  
  public FileDownloader(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public static native HttpEntity a(String paramString, boolean paramBoolean)
    throws Exception;
  
  private native long e();
  
  private native void f();
  
  private native void g();
  
  public final native void a(IDownloadProgress paramIDownloadProgress);
  
  public final native void a(String paramString);
  
  public final native void a(boolean paramBoolean);
  
  protected final native boolean a();
  
  public native void b();
  
  public final native void b(String paramString);
  
  public native void c();
  
  protected native void d();
  
  public static abstract interface IDownloadProgress
  {
    public abstract void a();
    
    public abstract void a(float paramFloat);
    
    public abstract void b();
  }
  
  private static class ProgressOutput
    extends Handler
  {
    WeakReference a;
    private boolean b = false;
    
    static
    {
      JniLib.a(ProgressOutput.class, 130);
    }
    
    private ProgressOutput(Looper paramLooper, FileDownloader paramFileDownloader)
    {
      super();
      this.a = new WeakReference(paramFileDownloader);
    }
    
    public native void handleMessage(Message paramMessage);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\FileDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */