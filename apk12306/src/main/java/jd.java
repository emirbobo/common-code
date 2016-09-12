import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class jd
{
  private static int a = 512;
  
  public static int a(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramInputStream.read(paramArrayOfByte, i, j - i);
      if (k < 0) {
        break;
      }
      i += k;
    }
    return i;
  }
  
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[a];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i < 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */