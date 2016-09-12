import java.io.ByteArrayOutputStream;

public final class jb
{
  private static final iz a = new jc();
  
  public static byte[] a(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      a.a(paramString, localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception paramString)
    {
      throw new iy("exception decoding Hex string: " + paramString.getMessage(), paramString);
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      a.a(paramArrayOfByte, paramInt, localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception paramArrayOfByte)
    {
      throw new ja("exception encoding Hex string: " + paramArrayOfByte.getMessage(), paramArrayOfByte);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */