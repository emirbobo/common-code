import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

final class et
  extends HttpEntityWrapper
{
  public et(HttpEntity paramHttpEntity)
  {
    super(paramHttpEntity);
  }
  
  public final InputStream getContent()
    throws IOException
  {
    return new GZIPInputStream(this.wrappedEntity.getContent());
  }
  
  public final long getContentLength()
  {
    return -1L;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */