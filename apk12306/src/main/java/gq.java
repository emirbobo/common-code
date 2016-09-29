import java.io.IOException;

public final class gq
  extends fv
{
  private char[] a;
  
  gq(char[] paramArrayOfChar)
  {
    this.a = paramArrayOfChar;
  }
  
  final int a()
  {
    return id.a(this.a.length << 1) + 1 + (this.a.length << 1);
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    paramfs.b(30);
    paramfs.a(this.a.length << 1);
    for (int i = 0; i != this.a.length; i++)
    {
      int j = this.a[i];
      paramfs.b((byte)(j >> 8));
      paramfs.b((byte)j);
    }
  }
  
  final boolean a()
  {
    return false;
  }
  
  protected final boolean a(fv paramfv)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramfv instanceof gq)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      Object localObject = (gq)paramfv;
      paramfv = this.a;
      localObject = ((gq)localObject).a;
      if (paramfv != localObject)
      {
        bool1 = bool2;
        if (paramfv != null)
        {
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (paramfv.length == localObject.length) {
              for (int i = 0;; i++)
              {
                if (i == paramfv.length) {
                  break label92;
                }
                bool1 = bool2;
                if (paramfv[i] != localObject[i]) {
                  break;
                }
              }
            }
          }
        }
      }
      else
      {
        label92:
        bool1 = true;
      }
    }
  }
  
  public final int hashCode()
  {
    char[] arrayOfChar = this.a;
    if (arrayOfChar == null)
    {
      j = 0;
      return j;
    }
    int j = arrayOfChar.length;
    int i = j + 1;
    for (;;)
    {
      int k = j - 1;
      j = i;
      if (k < 0) {
        break;
      }
      i = i * 257 ^ arrayOfChar[k];
      j = k;
    }
  }
  
  public final String toString()
  {
    return new String(this.a);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */