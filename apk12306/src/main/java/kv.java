public abstract class kv
  extends li
  implements jo
{
  public kv(byte paramByte)
  {
    super(paramByte);
  }
  
  public final int a()
    throws jp
  {
    return a().length;
  }
  
  public final byte[] a()
    throws jp
  {
    try
    {
      byte[] arrayOfByte = c();
      return arrayOfByte;
    }
    catch (jm localjm)
    {
      throw new jp(localjm.getCause());
    }
  }
  
  public final byte[] a_()
    throws jp
  {
    try
    {
      byte[] arrayOfByte = b();
      return arrayOfByte;
    }
    catch (jm localjm)
    {
      throw new jp(localjm.getCause());
    }
  }
  
  public int b()
    throws jp
  {
    return 0;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\kv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */