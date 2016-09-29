import java.io.IOException;
import java.io.OutputStream;

public class fs
{
  private OutputStream a;
  
  public fs(OutputStream paramOutputStream)
  {
    this.a = paramOutputStream;
  }
  
  fs a()
  {
    return new hg(this.a);
  }
  
  final void a(int paramInt)
    throws IOException
  {
    if (paramInt > 127)
    {
      int i = 1;
      int j = paramInt;
      for (;;)
      {
        j >>>= 8;
        if (j == 0) {
          break;
        }
        i++;
      }
      b((byte)(i | 0x80));
      for (i = i - 1 << 3; i >= 0; i -= 8) {
        b((byte)(paramInt >> i));
      }
    }
    b((byte)paramInt);
  }
  
  final void a(int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 31) {
      b(paramInt1 | paramInt2);
    }
    for (;;)
    {
      return;
      b(paramInt1 | 0x1F);
      if (paramInt2 < 128)
      {
        b(paramInt2);
      }
      else
      {
        byte[] arrayOfByte = new byte[5];
        paramInt1 = arrayOfByte.length - 1;
        arrayOfByte[paramInt1] = ((byte)(byte)(paramInt2 & 0x7F));
        int j;
        int i;
        do
        {
          j = paramInt2 >> 7;
          i = paramInt1 - 1;
          arrayOfByte[i] = ((byte)(byte)(j & 0x7F | 0x80));
          paramInt1 = i;
          paramInt2 = j;
        } while (j > 127);
        paramInt1 = arrayOfByte.length;
        this.a.write(arrayOfByte, i, paramInt1 - i);
      }
    }
  }
  
  final void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws IOException
  {
    a(paramInt1, paramInt2);
    a(paramArrayOfByte.length);
    a(paramArrayOfByte);
  }
  
  final void a(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    b(paramInt);
    a(paramArrayOfByte.length);
    a(paramArrayOfByte);
  }
  
  public void a(fg paramfg)
    throws IOException
  {
    if (paramfg != null)
    {
      paramfg.b().a(this);
      return;
    }
    throw new IOException("null object detected");
  }
  
  final void a(fv paramfv)
    throws IOException
  {
    if (paramfv != null)
    {
      paramfv.a(new ft(this.a));
      return;
    }
    throw new IOException("null object detected");
  }
  
  final void a(byte[] paramArrayOfByte)
    throws IOException
  {
    this.a.write(paramArrayOfByte);
  }
  
  fs b()
  {
    return new hs(this.a);
  }
  
  void b(int paramInt)
    throws IOException
  {
    this.a.write(paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\fs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */