import java.io.IOException;
import java.io.OutputStream;

public final class ix
  implements iz
{
  private byte jdField_a_of_type_Byte = (byte)61;
  private byte[] jdField_a_of_type_ArrayOfByte = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private byte[] b = new byte[''];
  
  public ix()
  {
    a();
  }
  
  private static int a(String paramString, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (a(paramString.charAt(paramInt1)))) {
      paramInt1++;
    }
    return paramInt1;
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
    while (i < this.jdField_a_of_type_ArrayOfByte.length)
    {
      this.b[this.jdField_a_of_type_ArrayOfByte[i]] = ((byte)(byte)i);
      i++;
    }
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
    int j = 0;
    for (int i = paramString.length(); (i > 0) && (a(paramString.charAt(i - 1))); i--) {}
    int m = i - 4;
    for (int k = a(paramString, 0, m); k < m; k = a(paramString, i1 + 1, m))
    {
      n = this.b[paramString.charAt(k)];
      i1 = a(paramString, k + 1, m);
      k = this.b[paramString.charAt(i1)];
      i1 = a(paramString, i1 + 1, m);
      int i2 = this.b[paramString.charAt(i1)];
      i1 = a(paramString, i1 + 1, m);
      int i3 = this.b[paramString.charAt(i1)];
      if ((n | k | i2 | i3) < 0) {
        throw new IOException("invalid characters encountered in base64 data");
      }
      paramOutputStream.write(n << 2 | k >> 4);
      paramOutputStream.write(k << 4 | i2 >> 2);
      paramOutputStream.write(i2 << 6 | i3);
      j += 3;
    }
    int i1 = paramString.charAt(i - 4);
    m = paramString.charAt(i - 3);
    k = paramString.charAt(i - 2);
    int n = paramString.charAt(i - 1);
    if (k == this.jdField_a_of_type_Byte)
    {
      i = this.b[i1];
      k = this.b[m];
      if ((i | k) < 0) {
        throw new IOException("invalid characters encountered at end of base64 data");
      }
      paramOutputStream.write(i << 2 | k >> 4);
      i = 1;
    }
    for (;;)
    {
      return i + j;
      if (n == this.jdField_a_of_type_Byte)
      {
        i = this.b[i1];
        m = this.b[m];
        k = this.b[k];
        if ((i | m | k) < 0) {
          throw new IOException("invalid characters encountered at end of base64 data");
        }
        paramOutputStream.write(i << 2 | m >> 4);
        paramOutputStream.write(m << 4 | k >> 2);
        i = 2;
      }
      else
      {
        i = this.b[i1];
        m = this.b[m];
        k = this.b[k];
        n = this.b[n];
        if ((i | m | k | n) < 0) {
          throw new IOException("invalid characters encountered at end of base64 data");
        }
        paramOutputStream.write(i << 2 | m >> 4);
        paramOutputStream.write(m << 4 | k >> 2);
        paramOutputStream.write(k << 6 | n);
        i = 3;
      }
    }
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    int j = paramInt % 3;
    int k = paramInt - j;
    int m;
    for (paramInt = 0; paramInt < k; paramInt += 3)
    {
      int n = paramArrayOfByte[paramInt] & 0xFF;
      m = paramArrayOfByte[(paramInt + 1)] & 0xFF;
      int i1 = paramArrayOfByte[(paramInt + 2)] & 0xFF;
      paramOutputStream.write(this.jdField_a_of_type_ArrayOfByte[(n >>> 2 & 0x3F)]);
      paramOutputStream.write(this.jdField_a_of_type_ArrayOfByte[((n << 4 | m >>> 4) & 0x3F)]);
      paramOutputStream.write(this.jdField_a_of_type_ArrayOfByte[((m << 2 | i1 >>> 6) & 0x3F)]);
      paramOutputStream.write(this.jdField_a_of_type_ArrayOfByte[(i1 & 0x3F)]);
    }
    switch (j)
    {
    case 0: 
    default: 
      k /= 3;
      if (j != 0) {
        break;
      }
    }
    for (paramInt = i;; paramInt = 4)
    {
      return paramInt + (k << 2);
      paramInt = paramArrayOfByte[k] & 0xFF;
      paramOutputStream.write(this.jdField_a_of_type_ArrayOfByte[(paramInt >>> 2 & 0x3F)]);
      paramOutputStream.write(this.jdField_a_of_type_ArrayOfByte[(paramInt << 4 & 0x3F)]);
      paramOutputStream.write(this.jdField_a_of_type_Byte);
      paramOutputStream.write(this.jdField_a_of_type_Byte);
      break;
      m = paramArrayOfByte[k] & 0xFF;
      paramInt = paramArrayOfByte[(k + 1)] & 0xFF;
      paramOutputStream.write(this.jdField_a_of_type_ArrayOfByte[(m >>> 2 & 0x3F)]);
      paramOutputStream.write(this.jdField_a_of_type_ArrayOfByte[((m << 4 | paramInt >>> 4) & 0x3F)]);
      paramOutputStream.write(this.jdField_a_of_type_ArrayOfByte[(paramInt << 2 & 0x3F)]);
      paramOutputStream.write(this.jdField_a_of_type_Byte);
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */