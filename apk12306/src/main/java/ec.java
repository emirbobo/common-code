import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocketFactory;

public final class ec
  extends SSLSocketFactory
{
  public ec(SSLSocketFactory paramSSLSocketFactory) {}
  
  private static void a(InetAddress paramInetAddress, String paramString)
  {
    try
    {
      Field localField = InetAddress.class.getDeclaredField("hostName");
      localField.setAccessible(true);
      localField.set(paramInetAddress, paramString);
      return;
    }
    catch (Exception paramInetAddress)
    {
      for (;;) {}
    }
  }
  
  public final Socket createSocket(String paramString, int paramInt)
    throws IOException, UnknownHostException
  {
    InetAddress localInetAddress = InetAddress.getByName(paramString);
    a(localInetAddress, paramString);
    return this.a.createSocket(localInetAddress, paramInt);
  }
  
  public final Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException, UnknownHostException
  {
    return this.a.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
  }
  
  public final Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return this.a.createSocket(paramInetAddress, paramInt);
  }
  
  public final Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return this.a.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    a(paramSocket.getInetAddress(), paramString);
    return this.a.createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public final String[] getDefaultCipherSuites()
  {
    return this.a.getDefaultCipherSuites();
  }
  
  public final String[] getSupportedCipherSuites()
  {
    return this.a.getSupportedCipherSuites();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */