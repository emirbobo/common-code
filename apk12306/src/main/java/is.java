import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;

final class is
  extends ir
{
  private String a;
  
  public is(iq paramiq, String paramString1, String paramString2)
  {
    super(paramiq, paramString1);
    this.a = paramString2;
  }
  
  public final Object a(jf paramjf)
    throws IOException
  {
    try
    {
      paramjf = a(paramjf);
      if (paramjf.b() != 9)
      {
        paramjf = new ip;
        paramjf.<init>("malformed sequence in RSA private key");
        throw paramjf;
      }
    }
    catch (IOException paramjf)
    {
      throw paramjf;
      if ((paramjf instanceof ie)) {
        paramjf = (ie)paramjf;
      }
      for (;;)
      {
        RSAPublicKeySpec localRSAPublicKeySpec = new java/security/spec/RSAPublicKeySpec;
        localRSAPublicKeySpec.<init>(paramjf.a, paramjf.b);
        RSAPrivateCrtKeySpec localRSAPrivateCrtKeySpec = new java/security/spec/RSAPrivateCrtKeySpec;
        localRSAPrivateCrtKeySpec.<init>(paramjf.a, paramjf.b, paramjf.c, paramjf.d, paramjf.e, paramjf.f, paramjf.g, paramjf.h);
        paramjf = KeyFactory.getInstance("RSA", this.a);
        return new KeyPair(paramjf.generatePublic(localRSAPublicKeySpec), paramjf.generatePrivate(localRSAPrivateCrtKeySpec));
        if (paramjf != null) {
          paramjf = new ie(fw.a(paramjf));
        } else {
          paramjf = null;
        }
      }
    }
    catch (Exception paramjf)
    {
      throw new ip("problem creating RSA private key: " + paramjf.toString(), paramjf);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\is.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */