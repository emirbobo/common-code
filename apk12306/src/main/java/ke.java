import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class ke
  extends kf
{
  public int a;
  private String[] a;
  
  public ke(kk paramkk, SSLSocketFactory paramSSLSocketFactory, String paramString, int paramInt)
  {
    super(paramkk, paramSSLSocketFactory, paramString, paramInt);
  }
  
  public final void a()
    throws IOException, jm
  {
    super.a();
    a(this.jdField_a_of_type_ArrayOfJavaLangString);
    int i = this.jdField_a_of_type_JavaNetSocket.getSoTimeout();
    if (i == 0) {
      this.jdField_a_of_type_JavaNetSocket.setSoTimeout(this.jdField_a_of_type_Int * 1000);
    }
    ((SSLSocket)this.jdField_a_of_type_JavaNetSocket).startHandshake();
    this.jdField_a_of_type_JavaNetSocket.setSoTimeout(i);
  }
  
  public final void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    if ((this.jdField_a_of_type_JavaNetSocket != null) && (paramArrayOfString != null))
    {
      if (this.jdField_a_of_type_Kk.a())
      {
        String str1 = "";
        for (int i = 0; i < paramArrayOfString.length; i++)
        {
          String str2 = str1;
          if (i > 0) {
            str2 = str1 + ",";
          }
          str1 = str2 + paramArrayOfString[i];
        }
        this.jdField_a_of_type_Kk.a(260, new Object[] { str1 });
      }
      ((SSLSocket)this.jdField_a_of_type_JavaNetSocket).setEnabledCipherSuites(paramArrayOfString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */