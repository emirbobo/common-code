import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class ev
{
  private Handler a;
  
  public ev()
  {
    if (Looper.myLooper() != null) {
      this.a = new ew(this);
    }
  }
  
  protected final Message a(int paramInt, Object paramObject)
  {
    if (this.a != null) {}
    Message localMessage;
    for (paramObject = this.a.obtainMessage(paramInt, paramObject);; paramObject = localMessage)
    {
      return (Message)paramObject;
      localMessage = new Message();
      localMessage.what = paramInt;
      localMessage.obj = paramObject;
    }
  }
  
  protected final void a()
  {
    b(a(2, null));
  }
  
  protected void a(int paramInt, String paramString)
  {
    b(a(0, new Object[] { new Integer(paramInt), paramString }));
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      ((Integer)((Object[])paramMessage.obj)[0]).intValue();
      continue;
      b((String)((Object[])paramMessage.obj)[1]);
    }
  }
  
  public void a(String paramString) {}
  
  protected final void a(Throwable paramThrowable, String paramString)
  {
    b(a(1, new Object[] { paramThrowable, paramString }));
  }
  
  protected void a(Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    b(a(1, new Object[] { paramThrowable, paramArrayOfByte }));
  }
  
  void a(HttpResponse paramHttpResponse)
  {
    localObject = null;
    localStatusLine = paramHttpResponse.getStatusLine();
    try
    {
      HttpEntity localHttpEntity = paramHttpResponse.getEntity();
      paramHttpResponse = (HttpResponse)localObject;
      if (localHttpEntity != null)
      {
        paramHttpResponse = new org/apache/http/entity/BufferedHttpEntity;
        paramHttpResponse.<init>(localHttpEntity);
        paramHttpResponse = EntityUtils.toString(paramHttpResponse, "UTF-8");
      }
    }
    catch (IOException paramHttpResponse)
    {
      for (;;)
      {
        a(paramHttpResponse, null);
        paramHttpResponse = (HttpResponse)localObject;
        continue;
        a(localStatusLine.getStatusCode(), paramHttpResponse);
      }
    }
    if (localStatusLine.getStatusCode() >= 300)
    {
      a(new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()), paramHttpResponse);
      return;
    }
  }
  
  protected final void b()
  {
    b(a(3, null));
  }
  
  protected final void b(Message paramMessage)
  {
    if (this.a != null) {
      this.a.sendMessage(paramMessage);
    }
    for (;;)
    {
      return;
      a(paramMessage);
    }
  }
  
  protected void b(String paramString)
  {
    a(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */