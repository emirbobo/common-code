import java.math.BigInteger;
import java.util.Enumeration;

public final class ie
  extends fo
{
  private fw a;
  public BigInteger a;
  public BigInteger b;
  public BigInteger c;
  public BigInteger d;
  public BigInteger e;
  public BigInteger f;
  public BigInteger g;
  public BigInteger h;
  private BigInteger i;
  
  public ie(fw paramfw)
  {
    this.jdField_a_of_type_Fw = null;
    Enumeration localEnumeration = paramfw.a();
    paramfw = ((fm)localEnumeration.nextElement()).a();
    if ((paramfw.intValue() != 0) && (paramfw.intValue() != 1)) {
      throw new IllegalArgumentException("wrong version for RSA private key");
    }
    this.i = paramfw;
    this.jdField_a_of_type_JavaMathBigInteger = ((fm)localEnumeration.nextElement()).a();
    this.b = ((fm)localEnumeration.nextElement()).a();
    this.c = ((fm)localEnumeration.nextElement()).a();
    this.d = ((fm)localEnumeration.nextElement()).a();
    this.e = ((fm)localEnumeration.nextElement()).a();
    this.f = ((fm)localEnumeration.nextElement()).a();
    this.g = ((fm)localEnumeration.nextElement()).a();
    this.h = ((fm)localEnumeration.nextElement()).a();
    if (localEnumeration.hasMoreElements()) {
      this.jdField_a_of_type_Fw = ((fw)localEnumeration.nextElement());
    }
  }
  
  public final fv b()
  {
    fh localfh = new fh();
    localfh.a(new fm(this.i));
    localfh.a(new fm(this.jdField_a_of_type_JavaMathBigInteger));
    localfh.a(new fm(this.b));
    localfh.a(new fm(this.c));
    localfh.a(new fm(this.d));
    localfh.a(new fm(this.e));
    localfh.a(new fm(this.f));
    localfh.a(new fm(this.g));
    localfh.a(new fm(this.h));
    if (this.jdField_a_of_type_Fw != null) {
      localfh.a(this.jdField_a_of_type_Fw);
    }
    return new hi(localfh);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */