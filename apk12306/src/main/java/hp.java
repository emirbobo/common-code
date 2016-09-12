import java.io.IOException;

public final class hp
  extends fv
{
  private byte[] a;
  
  hp(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  final int a()
    throws IOException
  {
    return id.a(this.a.length) + 1 + this.a.length;
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    paramfs.a(12, this.a);
  }
  
  final boolean a()
  {
    return false;
  }
  
  final boolean a(fv paramfv)
  {
    if (!(paramfv instanceof hp)) {}
    for (boolean bool = false;; bool = at.a(this.a, paramfv.a))
    {
      return bool;
      paramfv = (hp)paramfv;
    }
  }
  
  public final int hashCode()
  {
    return at.a(this.a);
  }
  
  public final String toString()
  {
    int k = 0;
    byte[] arrayOfByte = this.a;
    int j = 0;
    int i = 0;
    while (i < arrayOfByte.length)
    {
      j++;
      if ((arrayOfByte[i] & 0xF0) == 240)
      {
        j++;
        i += 4;
      }
      else if ((arrayOfByte[i] & 0xE0) == 224)
      {
        i += 3;
      }
      else if ((arrayOfByte[i] & 0xC0) == 192)
      {
        i += 2;
      }
      else
      {
        i++;
      }
    }
    char[] arrayOfChar = new char[j];
    j = 0;
    i = k;
    if (j < arrayOfByte.length)
    {
      int m;
      if ((arrayOfByte[j] & 0xF0) == 240)
      {
        k = ((arrayOfByte[j] & 0x3) << 18 | (arrayOfByte[(j + 1)] & 0x3F) << 12 | (arrayOfByte[(j + 2)] & 0x3F) << 6 | arrayOfByte[(j + 3)] & 0x3F) - 65536;
        int n = (char)(0xD800 | k >> 10);
        m = (char)(k & 0x3FF | 0xDC00);
        k = i + 1;
        arrayOfChar[i] = ((char)n);
        i = j + 4;
        j = m;
      }
      for (;;)
      {
        m = k + 1;
        arrayOfChar[k] = ((char)j);
        j = i;
        i = m;
        break;
        if ((arrayOfByte[j] & 0xE0) == 224)
        {
          m = (char)((arrayOfByte[j] & 0xF) << 12 | (arrayOfByte[(j + 1)] & 0x3F) << 6 | arrayOfByte[(j + 2)] & 0x3F);
          j += 3;
          k = i;
          i = j;
          j = m;
        }
        else if ((arrayOfByte[j] & 0xD0) == 208)
        {
          m = (char)((arrayOfByte[j] & 0x1F) << 6 | arrayOfByte[(j + 1)] & 0x3F);
          j += 2;
          k = i;
          i = j;
          j = m;
        }
        else if ((arrayOfByte[j] & 0xC0) == 192)
        {
          m = (char)((arrayOfByte[j] & 0x1F) << 6 | arrayOfByte[(j + 1)] & 0x3F);
          j += 2;
          k = i;
          i = j;
          j = m;
        }
        else
        {
          m = (char)(arrayOfByte[j] & 0xFF);
          j++;
          k = i;
          i = j;
          j = m;
        }
      }
    }
    return new String(arrayOfChar);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */