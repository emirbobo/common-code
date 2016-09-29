import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class fo
  implements fg
{
  public final byte[] a()
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    new fs(localByteArrayOutputStream).a(this);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public final byte[] a(String paramString)
    throws IOException
  {
    if (paramString.equals("DER"))
    {
      paramString = new ByteArrayOutputStream();
      new hg(paramString).a(this);
      paramString = paramString.toByteArray();
    }
    for (;;)
    {
      return paramString;
      if (paramString.equals("DL"))
      {
        paramString = new ByteArrayOutputStream();
        new hs(paramString).a(this);
        paramString = paramString.toByteArray();
      }
      else
      {
        paramString = a();
      }
    }
  }
  
  public abstract fv b();
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof fg))
      {
        bool = false;
      }
      else
      {
        paramObject = (fg)paramObject;
        bool = b().equals(((fg)paramObject).b());
      }
    }
  }
  
  public int hashCode()
  {
    return b().hashCode();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\fo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */