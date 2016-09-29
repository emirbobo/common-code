import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class hd
  extends fv
{
  private static fp[][] jdField_a_of_type_Array2dOfFp = new fp['Ā'][];
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  hd(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    BigInteger localBigInteger1 = null;
    long l1 = 0L;
    int k = 0;
    if (k != paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[k] & 0xFF;
      if (l1 <= 72057594037927808L)
      {
        l1 += (j & 0x7F);
        if ((j & 0x80) == 0)
        {
          j = i;
          long l2 = l1;
          if (i != 0)
          {
            if (l1 < 40L)
            {
              localStringBuffer.append('0');
              label94:
              j = 0;
              l2 = l1;
            }
          }
          else
          {
            localStringBuffer.append('.');
            localStringBuffer.append(l2);
            l1 = 0L;
            i = j;
          }
        }
        for (;;)
        {
          k++;
          break;
          if (l1 < 80L)
          {
            localStringBuffer.append('1');
            l1 -= 40L;
            break label94;
          }
          localStringBuffer.append('2');
          l1 -= 80L;
          break label94;
          l1 <<= 7;
        }
      }
      BigInteger localBigInteger2 = localBigInteger1;
      if (localBigInteger1 == null) {
        localBigInteger2 = BigInteger.valueOf(l1);
      }
      localBigInteger1 = localBigInteger2.or(BigInteger.valueOf(j & 0x7F));
      if ((j & 0x80) == 0)
      {
        if (i == 0) {
          break label305;
        }
        localStringBuffer.append('2');
        localBigInteger1 = localBigInteger1.subtract(BigInteger.valueOf(80L));
        i = 0;
      }
    }
    label305:
    for (;;)
    {
      localStringBuffer.append('.');
      localStringBuffer.append(localBigInteger1);
      l1 = 0L;
      localBigInteger1 = null;
      break;
      localBigInteger1 = localBigInteger1.shiftLeft(7);
      break;
      this.jdField_a_of_type_JavaLangString = localStringBuffer.toString();
      this.jdField_a_of_type_ArrayOfByte = at.a(paramArrayOfByte);
      return;
    }
  }
  
  static fp a(byte[] paramArrayOfByte)
  {
    Object localObject1;
    if (paramArrayOfByte.length < 3)
    {
      localObject1 = new fp(paramArrayOfByte);
      return (fp)localObject1;
    }
    int j = paramArrayOfByte[(paramArrayOfByte.length - 2)] & 0xFF;
    int i = paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0x7F;
    label301:
    for (;;)
    {
      Object localObject2;
      synchronized (jdField_a_of_type_Array2dOfFp)
      {
        localObject1 = jdField_a_of_type_Array2dOfFp[j];
        if (localObject1 != null) {
          break label301;
        }
        localObject2 = jdField_a_of_type_Array2dOfFp;
        localObject1 = new fp[''];
        localObject2[j] = localObject1;
        localObject2 = localObject1[i];
        if (localObject2 == null)
        {
          localObject2 = new fp;
          ((fp)localObject2).<init>(paramArrayOfByte);
          localObject1[i] = localObject2;
          localObject1 = localObject2;
        }
      }
      if (at.a(paramArrayOfByte, ((fp)localObject2).b()))
      {
        localObject1 = localObject2;
        break;
      }
      j = j + 1 & 0xFF;
      localObject1 = jdField_a_of_type_Array2dOfFp[j];
      if (localObject1 == null)
      {
        localObject2 = jdField_a_of_type_Array2dOfFp;
        localObject1 = new fp[''];
        localObject2[j] = localObject1;
      }
      for (;;)
      {
        localObject2 = localObject1[i];
        if (localObject2 == null)
        {
          localObject2 = new fp;
          ((fp)localObject2).<init>(paramArrayOfByte);
          localObject1[i] = localObject2;
          localObject1 = localObject2;
          break;
        }
        if (at.a(paramArrayOfByte, ((fp)localObject2).b()))
        {
          localObject1 = localObject2;
          break;
        }
        i = i + 1 & 0x7F;
        localObject2 = localObject1[i];
        if (localObject2 == null)
        {
          localObject2 = new fp;
          ((fp)localObject2).<init>(paramArrayOfByte);
          localObject1[i] = localObject2;
          localObject1 = localObject2;
          break;
        }
        localObject1 = localObject2;
        if (at.a(paramArrayOfByte, ((fp)localObject2).b())) {
          break;
        }
        localObject1 = new fp(paramArrayOfByte);
        break;
      }
    }
  }
  
  private void a(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    ic localic = new ic(this.jdField_a_of_type_JavaLangString);
    int i = Integer.parseInt(localic.a()) * 40;
    String str = localic.a();
    if (str.length() <= 18) {
      a(paramByteArrayOutputStream, i + Long.parseLong(str));
    }
    for (;;)
    {
      if (localic.a != -1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          return;
        }
        str = localic.a();
        if (str.length() > 18) {
          break label122;
        }
        a(paramByteArrayOutputStream, Long.parseLong(str));
        break;
        a(paramByteArrayOutputStream, new BigInteger(str).add(BigInteger.valueOf(i)));
        break;
      }
      label122:
      a(paramByteArrayOutputStream, new BigInteger(str));
    }
  }
  
  private static void a(ByteArrayOutputStream paramByteArrayOutputStream, long paramLong)
  {
    int i = 8;
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[8] = ((byte)(byte)((int)paramLong & 0x7F));
    while (paramLong >= 128L)
    {
      paramLong >>= 7;
      i--;
      arrayOfByte[i] = ((byte)(byte)((int)paramLong & 0x7F | 0x80));
    }
    paramByteArrayOutputStream.write(arrayOfByte, i, 9 - i);
  }
  
  private static void a(ByteArrayOutputStream paramByteArrayOutputStream, BigInteger paramBigInteger)
  {
    int j = (paramBigInteger.bitLength() + 6) / 7;
    if (j == 0) {
      paramByteArrayOutputStream.write(0);
    }
    for (;;)
    {
      return;
      byte[] arrayOfByte = new byte[j];
      for (int i = j - 1; i >= 0; i--)
      {
        arrayOfByte[i] = ((byte)(byte)(paramBigInteger.intValue() & 0x7F | 0x80));
        paramBigInteger = paramBigInteger.shiftRight(7);
      }
      i = j - 1;
      arrayOfByte[i] = ((byte)(byte)(arrayOfByte[i] & 0x7F));
      paramByteArrayOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
    }
  }
  
  final int a()
    throws IOException
  {
    int i = b().length;
    return i + (id.a(i) + 1);
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    byte[] arrayOfByte = b();
    paramfs.b(6);
    paramfs.a(arrayOfByte.length);
    paramfs.a(arrayOfByte);
  }
  
  final boolean a()
  {
    return false;
  }
  
  final boolean a(fv paramfv)
  {
    if (!(paramfv instanceof hd)) {}
    for (boolean bool = false;; bool = this.jdField_a_of_type_JavaLangString.equals(((hd)paramfv).jdField_a_of_type_JavaLangString)) {
      return bool;
    }
  }
  
  protected final byte[] b()
  {
    try
    {
      if (this.jdField_a_of_type_ArrayOfByte == null)
      {
        localObject1 = new java/io/ByteArrayOutputStream;
        ((ByteArrayOutputStream)localObject1).<init>();
        a((ByteArrayOutputStream)localObject1);
        this.jdField_a_of_type_ArrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
      }
      Object localObject1 = this.jdField_a_of_type_ArrayOfByte;
      return (byte[])localObject1;
    }
    finally {}
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */