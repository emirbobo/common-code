import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import javax.net.SocketFactory;

public class kf
  implements kc
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  protected Socket a;
  private SocketFactory jdField_a_of_type_JavaxNetSocketFactory;
  protected kk a;
  
  public kf(kk paramkk, SocketFactory paramSocketFactory, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaxNetSocketFactory = paramSocketFactory;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Kk = paramkk;
  }
  
  public final InputStream a()
    throws IOException
  {
    return this.jdField_a_of_type_JavaNetSocket.getInputStream();
  }
  
  public final OutputStream a()
    throws IOException
  {
    return this.jdField_a_of_type_JavaNetSocket.getOutputStream();
  }
  
  public void a()
    throws IOException, jm
  {
    try
    {
      this.jdField_a_of_type_JavaNetSocket = this.jdField_a_of_type_JavaxNetSocketFactory.createSocket(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaNetSocket.setTcpNoDelay(true);
      return;
    }
    catch (ConnectException localConnectException)
    {
      this.jdField_a_of_type_Kk.a(250, null, localConnectException);
      throw at.a(32103);
    }
  }
  
  public final void b()
    throws IOException
  {
    if (this.jdField_a_of_type_JavaNetSocket != null) {
      this.jdField_a_of_type_JavaNetSocket.close();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\kf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */