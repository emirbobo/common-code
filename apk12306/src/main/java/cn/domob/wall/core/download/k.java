package cn.domob.wall.core.download;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import cn.domob.wall.core.DService.OnImageDownload;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class k
{
  private static k b;
  DService.OnImageDownload a;
  private ExecutorService c = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
  private l d;
  private i e;
  private Map<String, ImageView> f;
  private boolean g = true;
  
  private k(Context paramContext)
  {
    this.d = new l(paramContext);
    this.e = new i();
    this.f = new HashMap();
  }
  
  private Bitmap a(String paramString)
  {
    Bitmap localBitmap2 = this.d.a(paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap1 = this.e.a(paramString);
      if (localBitmap1 != null) {
        break label61;
      }
      localBitmap2 = j.a(paramString);
      localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        this.e.a(localBitmap2, paramString);
        this.d.a(paramString, localBitmap2);
        localBitmap1 = localBitmap2;
      }
    }
    for (;;)
    {
      return localBitmap1;
      label61:
      this.d.a(paramString, localBitmap1);
    }
  }
  
  public static k a(Context paramContext)
  {
    if (b == null) {
      b = new k(paramContext);
    }
    return b;
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    this.c.submit(new b(new a(paramString, paramImageView), paramString));
  }
  
  private void d()
  {
    synchronized (this.f)
    {
      Iterator localIterator = this.f.values().iterator();
      while (localIterator.hasNext())
      {
        ImageView localImageView = (ImageView)localIterator.next();
        if ((localImageView != null) && (localImageView.getTag() != null)) {
          a((String)localImageView.getTag(), localImageView);
        }
      }
    }
    this.f.clear();
  }
  
  public void a()
  {
    this.g = true;
  }
  
  public void a(String arg1, ImageView paramImageView, DService.OnImageDownload paramOnImageDownload)
  {
    this.a = paramOnImageDownload;
    paramOnImageDownload = this.d.a(???);
    if (paramOnImageDownload != null) {
      if (this.a != null) {
        this.a.onDownloadSuc(paramOnImageDownload, ???, paramImageView);
      }
    }
    for (;;)
    {
      return;
      synchronized (this.f)
      {
        this.f.put(Integer.toString(paramImageView.hashCode()), paramImageView);
        if (!this.g) {
          continue;
        }
        d();
      }
    }
  }
  
  public void b()
  {
    this.g = false;
  }
  
  public void c()
  {
    this.g = true;
    d();
  }
  
  private class a
    extends Handler
  {
    String a;
    ImageView b;
    
    public a(String paramString, ImageView paramImageView)
    {
      this.a = paramString;
      this.b = paramImageView;
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.b.getTag().equals(this.a))
      {
        if (paramMessage.obj == null) {
          break label101;
        }
        paramMessage = (Bitmap)paramMessage.obj;
        if (paramMessage == null) {
          break label68;
        }
        if (k.this.a != null) {
          k.this.a.onDownloadSuc(paramMessage, this.a, this.b);
        }
      }
      for (;;)
      {
        return;
        label68:
        if (k.this.a != null)
        {
          k.this.a.onDownloadFail(this.a, this.b);
          continue;
          label101:
          if (k.this.a != null) {
            k.this.a.onDownloadFail(this.a, this.b);
          }
        }
      }
    }
  }
  
  private class b
    implements Callable<String>
  {
    private String b;
    private Handler c;
    
    public b(Handler paramHandler, String paramString)
    {
      this.b = paramString;
      this.c = paramHandler;
    }
    
    public String a()
      throws Exception
    {
      Message localMessage = new Message();
      localMessage.obj = k.a(k.this, this.b);
      this.c.sendMessage(localMessage);
      return this.b;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */