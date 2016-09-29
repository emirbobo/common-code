import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public final class ex
  extends ev
{
  private static String[] a = { "image/jpeg", "image/png" };
  
  protected final void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.a(paramMessage);
    }
    for (;;)
    {
      return;
      ((Integer)((Object[])paramMessage.obj)[0]).intValue();
      continue;
      paramMessage = paramMessage.obj;
    }
  }
  
  protected final void a(Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    b(a(1, new Object[] { paramThrowable, paramArrayOfByte }));
  }
  
  final void a(HttpResponse paramHttpResponse)
  {
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    Object localObject1 = paramHttpResponse.getHeaders("Content-Type");
    if (localObject1.length != 1) {
      a(new HttpResponseException(localStatusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"), null);
    }
    for (;;)
    {
      return;
      Object localObject2 = localObject1[0];
      localObject1 = a;
      int k = localObject1.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        if (localObject1[i].equals(((Header)localObject2).getValue())) {
          j = 1;
        }
        i++;
      }
      if (j != 0) {
        break;
      }
      a(new HttpResponseException(localStatusLine.getStatusCode(), "Content-Type not allowed!"), null);
    }
    for (;;)
    {
      try
      {
        localObject1 = paramHttpResponse.getEntity();
        if (localObject1 == null) {
          break label241;
        }
        paramHttpResponse = new org/apache/http/entity/BufferedHttpEntity;
        paramHttpResponse.<init>((HttpEntity)localObject1);
        paramHttpResponse = EntityUtils.toByteArray(paramHttpResponse);
      }
      catch (IOException paramHttpResponse)
      {
        a(paramHttpResponse, null);
        paramHttpResponse = null;
        continue;
        b(a(0, new Object[] { Integer.valueOf(localStatusLine.getStatusCode()), paramHttpResponse }));
      }
      if (localStatusLine.getStatusCode() >= 300)
      {
        a(new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()), paramHttpResponse);
        break;
      }
      break;
      label241:
      paramHttpResponse = null;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */