import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class kt
  extends InputStream
{
  private DataInputStream a;
  
  public kt(InputStream paramInputStream)
  {
    this.a = new DataInputStream(paramInputStream);
  }
  
  public final li a()
    throws IOException, jm
  {
    Object localObject = new ByteArrayOutputStream();
    int j = this.a.readByte();
    int i = (byte)(j >>> 4 & 0xF);
    if ((i <= 0) || (i > 14)) {
      throw at.a(32108);
    }
    long l = li.a(this.a).a;
    ((ByteArrayOutputStream)localObject).write(j);
    ((ByteArrayOutputStream)localObject).write(li.a(l));
    byte[] arrayOfByte = new byte[(int)(((ByteArrayOutputStream)localObject).size() + l)];
    this.a.readFully(arrayOfByte, ((ByteArrayOutputStream)localObject).size(), arrayOfByte.length - ((ByteArrayOutputStream)localObject).size());
    localObject = ((ByteArrayOutputStream)localObject).toByteArray();
    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    return li.a(new ByteArrayInputStream(arrayOfByte));
  }
  
  public final int available()
    throws IOException
  {
    return this.a.available();
  }
  
  public final void close()
    throws IOException
  {
    this.a.close();
  }
  
  public final int read()
    throws IOException
  {
    return this.a.read();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\kt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */