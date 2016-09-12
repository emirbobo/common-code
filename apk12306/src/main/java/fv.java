import java.io.IOException;

public abstract class fv
  extends fo
{
  public static fv a(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new fl(paramArrayOfByte);
    try
    {
      paramArrayOfByte = paramArrayOfByte.a();
      return paramArrayOfByte;
    }
    catch (ClassCastException paramArrayOfByte)
    {
      throw new IOException("cannot recognise object in stream");
    }
  }
  
  abstract int a()
    throws IOException;
  
  abstract void a(fs paramfs)
    throws IOException;
  
  abstract boolean a();
  
  abstract boolean a(fv paramfv);
  
  public final fv b()
  {
    return this;
  }
  
  fv c()
  {
    return this;
  }
  
  fv d()
  {
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if ((!(paramObject instanceof fg)) || (!a(((fg)paramObject).b()))) {
        bool = false;
      }
    }
  }
  
  public abstract int hashCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\fv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */