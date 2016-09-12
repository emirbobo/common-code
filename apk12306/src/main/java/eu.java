import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

final class eu
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private final ev jdField_a_of_type_Ev;
  private final HttpUriRequest jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest;
  private final AbstractHttpClient jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient;
  private final HttpContext jdField_a_of_type_OrgApacheHttpProtocolHttpContext;
  private boolean jdField_a_of_type_Boolean;
  
  public eu(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, ev paramev)
  {
    this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient = paramAbstractHttpClient;
    this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext = paramHttpContext;
    this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest = paramHttpUriRequest;
    this.jdField_a_of_type_Ev = paramev;
    if ((paramev instanceof ex)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public final void run()
  {
    try
    {
      if (this.jdField_a_of_type_Ev != null) {
        this.jdField_a_of_type_Ev.a();
      }
      localObject = this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient.getHttpRequestRetryHandler();
      bool = true;
      localHttpResponse = null;
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        IOException localIOException3;
        try
        {
          HttpResponse localHttpResponse;
          if (!Thread.currentThread().isInterrupted())
          {
            localHttpResponse = this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient.execute(this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext);
            if ((!Thread.currentThread().isInterrupted()) && (this.jdField_a_of_type_Ev != null)) {
              this.jdField_a_of_type_Ev.a(localHttpResponse);
            }
          }
          if (this.jdField_a_of_type_Ev != null) {
            this.jdField_a_of_type_Ev.b();
          }
          return;
        }
        catch (UnknownHostException localUnknownHostException)
        {
          if (this.jdField_a_of_type_Ev == null) {
            continue;
          }
          this.jdField_a_of_type_Ev.a(localUnknownHostException, "can't resolve host");
          continue;
          localIOException1 = localIOException1;
          if (this.jdField_a_of_type_Ev == null) {
            continue;
          }
          this.jdField_a_of_type_Ev.b();
          if (!this.jdField_a_of_type_Boolean) {
            break label306;
          }
          this.jdField_a_of_type_Ev.a(localIOException1, null);
          continue;
        }
        catch (SocketException localSocketException)
        {
          if (this.jdField_a_of_type_Ev == null) {
            continue;
          }
          this.jdField_a_of_type_Ev.a(localSocketException, "can't resolve host");
          continue;
        }
        catch (SocketTimeoutException localSocketTimeoutException)
        {
          if (this.jdField_a_of_type_Ev == null) {
            continue;
          }
          this.jdField_a_of_type_Ev.a(localSocketTimeoutException, "socket time out");
          continue;
        }
        catch (IOException localIOException2)
        {
          i = this.jdField_a_of_type_Int + 1;
          this.jdField_a_of_type_Int = i;
          bool = ((HttpRequestRetryHandler)localObject).retryRequest(localIOException2, i, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext);
        }
        catch (NullPointerException localNullPointerException)
        {
          localIOException3 = new java/io/IOException;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("NPE in HttpClient");
          localIOException3.<init>(localNullPointerException.getMessage());
          int i = this.jdField_a_of_type_Int + 1;
          this.jdField_a_of_type_Int = i;
          boolean bool = ((HttpRequestRetryHandler)localObject).retryRequest(localIOException3, i, this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext);
        }
        continue;
        Object localObject = new java/net/ConnectException;
        ((ConnectException)localObject).<init>();
        ((ConnectException)localObject).initCause(localIOException3);
        throw ((Throwable)localObject);
        label306:
        this.jdField_a_of_type_Ev.a(localIOException3, null);
      }
    }
    if (!bool) {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */