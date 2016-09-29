import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class li
{
  private byte jdField_a_of_type_Byte;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  protected int b;
  
  public li(byte paramByte)
  {
    this.jdField_a_of_type_Byte = ((byte)paramByte);
    this.b = 0;
  }
  
  public static li a(InputStream paramInputStream)
    throws jm
  {
    for (;;)
    {
      int i;
      try
      {
        ko localko = new ko;
        localko.<init>(paramInputStream);
        DataInputStream localDataInputStream = new java/io/DataInputStream;
        localDataInputStream.<init>(localko);
        int j = localDataInputStream.readUnsignedByte();
        i = (byte)(j >> 4);
        byte b1 = (byte)(j & 0xF);
        long l = a(localDataInputStream).a + localko.a() - localko.a();
        paramInputStream = new byte[0];
        if (l > 0L)
        {
          paramInputStream = new byte[(int)l];
          localDataInputStream.readFully(paramInputStream, 0, paramInputStream.length);
        }
        if (i == 3)
        {
          paramInputStream = new lc(b1, paramInputStream);
          return paramInputStream;
        }
        if (i == 4)
        {
          paramInputStream = new ky(paramInputStream);
          continue;
        }
        if (i != 7) {
          break label152;
        }
      }
      catch (IOException paramInputStream)
      {
        throw new jm(paramInputStream);
      }
      paramInputStream = new kz(paramInputStream);
      continue;
      label152:
      if (i == 2)
      {
        paramInputStream = new kq(paramInputStream);
      }
      else if (i == 13)
      {
        paramInputStream = new kx();
      }
      else if (i == 9)
      {
        paramInputStream = new le(paramInputStream);
      }
      else if (i == 11)
      {
        paramInputStream = new lg(paramInputStream);
      }
      else if (i == 6)
      {
        paramInputStream = new lb(paramInputStream);
      }
      else
      {
        if (i != 5) {
          break;
        }
        paramInputStream = new la(paramInputStream);
      }
    }
    throw at.a(6);
  }
  
  protected static lk a(DataInputStream paramDataInputStream)
    throws IOException
  {
    long l1 = 0L;
    int i = 1;
    int j;
    long l2;
    do
    {
      j = paramDataInputStream.readByte();
      l2 = l1 + (j & 0x7F) * i;
      i <<= 7;
      l1 = l2;
    } while ((j & 0x80) != 0);
    return new lk(l2);
  }
  
  protected static byte[] a(long paramLong)
  {
    int i = 0;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j;
    do
    {
      int k = (byte)(int)(paramLong % 128L);
      paramLong /= 128L;
      j = k;
      if (paramLong > 0L) {
        j = (byte)(k | 0x80);
      }
      localByteArrayOutputStream.write(j);
      j = i + 1;
      if (paramLong <= 0L) {
        break;
      }
      i = j;
    } while (j < 4);
    return localByteArrayOutputStream.toByteArray();
  }
  
  protected abstract byte a();
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public byte[] b()
    throws jm
  {
    return new byte[0];
  }
  
  protected abstract byte[] b_()
    throws jm;
  
  public final int c()
  {
    return this.b;
  }
  
  public final byte[] c()
    throws jm
  {
    if (this.jdField_a_of_type_ArrayOfByte == null) {}
    try
    {
      int k = this.jdField_a_of_type_Byte;
      int m = a();
      byte[] arrayOfByte = b_();
      int j = arrayOfByte.length;
      int i = b().length;
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      DataOutputStream localDataOutputStream = new java/io/DataOutputStream;
      localDataOutputStream.<init>(localByteArrayOutputStream);
      localDataOutputStream.writeByte((k & 0xF) << 4 ^ m & 0xF);
      localDataOutputStream.write(a(j + i));
      localDataOutputStream.write(arrayOfByte);
      localDataOutputStream.flush();
      this.jdField_a_of_type_ArrayOfByte = localByteArrayOutputStream.toByteArray();
      return this.jdField_a_of_type_ArrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new jm(localIOException);
    }
  }
  
  protected final byte[] d()
    throws jm
  {
    try
    {
      Object localObject = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject).<init>();
      DataOutputStream localDataOutputStream = new java/io/DataOutputStream;
      localDataOutputStream.<init>((OutputStream)localObject);
      localDataOutputStream.writeShort(this.b);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new jm(localIOException);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\li.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */