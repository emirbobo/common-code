import java.io.ByteArrayOutputStream;

public final class iw
{
  private static final iz a = new ix();
  
  public static byte[] a(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramString.length() / 4 * 3);
    try
    {
      a.a(paramString, localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception paramString)
    {
      throw new iy("unable to decode base64 string: " + paramString.getMessage(), paramString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\iw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */