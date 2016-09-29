import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

final class id
{
  private static final long a = Runtime.getRuntime().maxMemory();
  
  static int a(int paramInt)
  {
    int j = 1;
    int k = 1;
    if (paramInt > 127)
    {
      for (int i = 1;; i++)
      {
        paramInt >>>= 8;
        if (paramInt == 0) {
          break;
        }
      }
      i = i - 1 << 3;
      paramInt = k;
      for (;;)
      {
        j = paramInt;
        if (i < 0) {
          break;
        }
        paramInt++;
        i -= 8;
      }
    }
    return j;
  }
  
  static int a(InputStream paramInputStream)
  {
    int i;
    if ((paramInputStream instanceof ib)) {
      i = ((ib)paramInputStream).a();
    }
    for (;;)
    {
      return i;
      if ((paramInputStream instanceof fl)) {
        i = ((fl)paramInputStream).a();
      } else if ((paramInputStream instanceof ByteArrayInputStream)) {
        i = ((ByteArrayInputStream)paramInputStream).available();
      } else if ((paramInputStream instanceof FileInputStream)) {
        try
        {
          long l = ((FileInputStream)paramInputStream).getChannel().size();
          if (l < 2147483647L) {
            i = (int)l;
          }
        }
        catch (IOException paramInputStream) {}
      } else if (a > 2147483647L) {
        i = Integer.MAX_VALUE;
      } else {
        i = (int)a;
      }
    }
  }
  
  static int b(int paramInt)
    throws IOException
  {
    int i = 1;
    if (paramInt >= 31) {
      if (paramInt >= 128) {
        break label19;
      }
    }
    label19:
    byte[] arrayOfByte;
    int k;
    for (i = 2;; i = arrayOfByte.length - k + 1)
    {
      return i;
      arrayOfByte = new byte[5];
      i = arrayOfByte.length - 1;
      arrayOfByte[i] = ((byte)(byte)(paramInt & 0x7F));
      int j;
      do
      {
        j = paramInt >> 7;
        k = i - 1;
        arrayOfByte[k] = ((byte)(byte)(j & 0x7F | 0x80));
        i = k;
        paramInt = j;
      } while (j > 127);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */