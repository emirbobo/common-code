import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.CertificateFactory;

final class it
  implements jg
{
  private String a;
  
  public it(String paramString)
  {
    this.a = paramString;
  }
  
  public final Object a(jf paramjf)
    throws IOException
  {
    paramjf = new ByteArrayInputStream(paramjf.a());
    try
    {
      paramjf = CertificateFactory.getInstance("X.509", this.a).generateCertificate(paramjf);
      return paramjf;
    }
    catch (Exception paramjf)
    {
      throw new ip("problem parsing cert: " + paramjf.toString(), paramjf);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\it.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */