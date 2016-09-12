import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public final class fl
  extends FilterInputStream
{
  private final int jdField_a_of_type_Int;
  private final boolean jdField_a_of_type_Boolean;
  private final byte[][] jdField_a_of_type_Array2dOfByte;
  
  private fl(InputStream paramInputStream)
  {
    this(paramInputStream, id.a(paramInputStream));
  }
  
  private fl(InputStream paramInputStream, int paramInt)
  {
    this(paramInputStream, paramInt, false);
  }
  
  private fl(InputStream paramInputStream, int paramInt, boolean paramBoolean)
  {
    super(paramInputStream);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Array2dOfByte = new byte[11][];
  }
  
  public fl(byte[] paramArrayOfByte)
  {
    this(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
  }
  
  public fl(byte[] paramArrayOfByte, byte paramByte)
  {
    this(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length, true);
  }
  
  static int a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    int i = paramInt & 0x1F;
    paramInt = i;
    if (i == 31)
    {
      i = 0;
      int j = paramInputStream.read();
      paramInt = j;
      if ((j & 0x7F) == 0) {
        throw new IOException("corrupted stream - invalid high tag number found");
      }
      while ((paramInt >= 0) && ((paramInt & 0x80) != 0))
      {
        i = (paramInt & 0x7F | i) << 7;
        paramInt = paramInputStream.read();
      }
      if (paramInt < 0) {
        throw new EOFException("EOF found inside tag value.");
      }
      paramInt = paramInt & 0x7F | i;
    }
    return paramInt;
  }
  
  private static fh a(hw paramhw)
    throws IOException
  {
    paramhw = new fl(paramhw);
    fh localfh = new fh();
    for (;;)
    {
      fv localfv = paramhw.a();
      if (localfv == null) {
        break;
      }
      localfh.a(localfv);
    }
    return localfh;
  }
  
  private fv a(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    int i = 0;
    boolean bool;
    Object localObject;
    if ((paramInt1 & 0x20) != 0)
    {
      bool = true;
      localObject = new hw(this, paramInt3);
      if ((paramInt1 & 0x40) == 0) {
        break label57;
      }
      localObject = new gp(bool, paramInt2, ((hw)localObject).a());
    }
    for (;;)
    {
      return (fv)localObject;
      bool = false;
      break;
      label57:
      if ((paramInt1 & 0x80) != 0) {
        localObject = new ga((InputStream)localObject).a(bool, paramInt2);
      } else if (bool) {
        switch (paramInt2)
        {
        default: 
          throw new IOException("unknown tag " + paramInt2 + " encountered");
        case 4: 
          localObject = a((hw)localObject);
          fq[] arrayOffq = new fq[((fh)localObject).a.size()];
          for (paramInt1 = i; paramInt1 != arrayOffq.length; paramInt1++) {
            arrayOffq[paramInt1] = ((fq)((fh)localObject).a(paramInt1));
          }
          localObject = new gf(arrayOffq);
          break;
        case 16: 
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new ia(((hw)localObject).a());
            continue;
          }
          localObject = gw.a(a((hw)localObject));
          break;
        case 17: 
          localObject = gw.a(a((hw)localObject));
          break;
        case 8: 
          localObject = new gu(a((hw)localObject));
          break;
        }
      } else {
        localObject = a(paramInt2, (hw)localObject, this.jdField_a_of_type_Array2dOfByte);
      }
    }
  }
  
  static fv a(int paramInt, hw paramhw, byte[][] paramArrayOfByte)
    throws IOException
  {
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 21: 
    case 25: 
    case 29: 
    default: 
      throw new IOException("unknown tag " + paramInt + " encountered");
    case 3: 
      paramhw = gr.a(paramhw.a(), paramhw);
    }
    for (;;)
    {
      return paramhw;
      paramhw = new gq(a(paramhw));
      continue;
      paramhw = fe.a(a(paramhw, paramArrayOfByte));
      continue;
      paramhw = fi.a(a(paramhw, paramArrayOfByte));
      continue;
      paramhw = new fk(paramhw.a());
      continue;
      paramhw = new gx(paramhw.a());
      continue;
      paramhw = new gz(paramhw.a());
      continue;
      paramhw = new fm(paramhw.a());
      continue;
      paramhw = hb.a;
      continue;
      paramhw = new hc(paramhw.a());
      continue;
      paramhw = fp.a(a(paramhw, paramArrayOfByte));
      continue;
      paramhw = new he(paramhw.a());
      continue;
      paramhw = new hh(paramhw.a());
      continue;
      paramhw = new hm(paramhw.a());
      continue;
      paramhw = new hq(paramhw.a());
      continue;
      paramhw = new gc(paramhw.a());
      continue;
      paramhw = new hp(paramhw.a());
      continue;
      paramhw = new hr(paramhw.a());
    }
  }
  
  private static byte[] a(hw paramhw, byte[][] paramArrayOfByte)
    throws IOException
  {
    int i = paramhw.a();
    byte[] arrayOfByte1;
    if (paramhw.a() < paramArrayOfByte.length)
    {
      byte[] arrayOfByte2 = paramArrayOfByte[i];
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = new byte[i];
        paramArrayOfByte[i] = arrayOfByte1;
      }
      jd.a(paramhw, arrayOfByte1);
    }
    for (;;)
    {
      return arrayOfByte1;
      arrayOfByte1 = paramhw.a();
    }
  }
  
  private static char[] a(hw paramhw)
    throws IOException
  {
    int j = paramhw.a() / 2;
    char[] arrayOfChar = new char[j];
    for (int i = 0; i < j; i++)
    {
      int m = paramhw.read();
      if (m < 0) {
        break;
      }
      int k = paramhw.read();
      if (k < 0) {
        break;
      }
      arrayOfChar[i] = ((char)(char)(m << 8 | k & 0xFF));
    }
    return arrayOfChar;
  }
  
  private int b()
    throws IOException
  {
    return b(this, this.jdField_a_of_type_Int);
  }
  
  static int b(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    int i = 0;
    int k = paramInputStream.read();
    if (k < 0) {
      throw new EOFException("EOF found when length expected");
    }
    int j;
    if (k == 128) {
      j = -1;
    }
    do
    {
      do
      {
        return j;
        j = k;
      } while (k <= 127);
      int m = k & 0x7F;
      if (m > 4) {
        throw new IOException("DER length more than 4 bytes: " + m);
      }
      k = 0;
      j = i;
      for (i = k; j < m; i = k + (i << 8))
      {
        k = paramInputStream.read();
        if (k < 0) {
          throw new EOFException("EOF found reading length");
        }
        j++;
      }
      if (i < 0) {
        throw new IOException("corrupted stream - negative length found");
      }
      j = i;
    } while (i < paramInt);
    throw new IOException("corrupted stream - out of bounds length found");
  }
  
  final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final fv a()
    throws IOException
  {
    int k = read();
    Object localObject;
    if (k <= 0)
    {
      if (k == 0) {
        throw new IOException("unexpected end-of-contents marker");
      }
      localObject = null;
    }
    for (;;)
    {
      return (fv)localObject;
      int j = a(this, k);
      if ((k & 0x20) != 0) {}
      int m;
      for (int i = 1;; i = 0)
      {
        m = b();
        if (m >= 0) {
          break label275;
        }
        if (i != 0) {
          break;
        }
        throw new IOException("indefinite length primitive encoding encountered");
      }
      localObject = new ga(new hy(this, this.jdField_a_of_type_Int), this.jdField_a_of_type_Int);
      if ((k & 0x40) != 0)
      {
        localObject = new fd(j, (ga)localObject).a();
        continue;
      }
      if ((k & 0x80) != 0)
      {
        localObject = new gn(true, j, (ga)localObject).a();
        continue;
      }
      switch (j)
      {
      default: 
        throw new IOException("unknown BER object encountered");
      case 4: 
        localObject = new gh((ga)localObject).a();
        break;
      case 16: 
        localObject = new gj((ga)localObject).a();
        break;
      case 17: 
        localObject = new gl((ga)localObject).a();
        break;
      case 8: 
        localObject = new gv((ga)localObject).a();
        continue;
        try
        {
          label275:
          localObject = a(k, j, m);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw new fj("corrupted stream detected", localIllegalArgumentException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\fl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */