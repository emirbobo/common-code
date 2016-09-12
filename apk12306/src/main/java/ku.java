import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class ku
  extends OutputStream
{
  private BufferedOutputStream a;
  
  public ku(OutputStream paramOutputStream)
  {
    this.a = new BufferedOutputStream(paramOutputStream);
  }
  
  public final void a(li paramli)
    throws IOException, jm
  {
    byte[] arrayOfByte = paramli.c();
    paramli = paramli.b();
    this.a.write(arrayOfByte, 0, arrayOfByte.length);
    this.a.write(paramli, 0, paramli.length);
  }
  
  public final void close()
    throws IOException
  {
    this.a.close();
  }
  
  public final void flush()
    throws IOException
  {
    this.a.flush();
  }
  
  public final void write(int paramInt)
    throws IOException
  {
    this.a.write(paramInt);
  }
  
  public final void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.a.write(paramArrayOfByte);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */