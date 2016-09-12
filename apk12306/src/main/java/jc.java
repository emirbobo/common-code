import java.io.IOException;
import java.io.OutputStream;

public final class jc
  implements iz
{
  private byte[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private byte[] b = new byte[''];
  
  public jc()
  {
    a();
  }
  
  private void a()
  {
    int k = 0;
    int i;
    for (int j = 0;; j++)
    {
      i = k;
      if (j >= this.b.length) {
        break;
      }
      this.b[j] = ((byte)-1);
    }
    while (i < this.a.length)
    {
      this.b[this.a[i]] = ((byte)(byte)i);
      i++;
    }
    this.b[65] = ((byte)this.b[97]);
    this.b[66] = ((byte)this.b[98]);
    this.b[67] = ((byte)this.b[99]);
    this.b[68] = ((byte)this.b[100]);
    this.b[69] = ((byte)this.b[101]);
    this.b[70] = ((byte)this.b[102]);
  }
  
  private static boolean a(char paramChar)
  {
    if ((paramChar == '\n') || (paramChar == '\r') || (paramChar == '\t') || (paramChar == ' ')) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int a(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    for (int j = paramString.length(); (j > 0) && (a(paramString.charAt(j - 1))); j--) {}
    int k = 0;
    while (i < j)
    {
      while ((i < j) && (a(paramString.charAt(i)))) {
        i++;
      }
      byte[] arrayOfByte = this.b;
      int m = i + 1;
      int n = arrayOfByte[paramString.charAt(i)];
      for (i = m; (i < j) && (a(paramString.charAt(i))); i++) {}
      m = this.b[paramString.charAt(i)];
      if ((n | m) < 0) {
        throw new IOException("invalid characters encountered in Hex string");
      }
      paramOutputStream.write(m | n << 4);
      k++;
      i++;
    }
    return k;
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    for (int i = 0; i < paramInt; i++)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      paramOutputStream.write(this.a[(j >>> 4)]);
      paramOutputStream.write(this.a[(j & 0xF)]);
    }
    return paramInt << 1;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */