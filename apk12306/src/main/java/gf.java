import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public final class gf
  extends fq
{
  fq[] a;
  
  public gf(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public gf(fq[] paramArrayOffq)
  {
    super(a(paramArrayOffq));
    this.jdField_a_of_type_ArrayOfFq = paramArrayOffq;
  }
  
  private static byte[] a(fq[] paramArrayOffq)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while (i != paramArrayOffq.length) {
      try
      {
        localByteArrayOutputStream.write(((he)paramArrayOffq[i]).b());
        i++;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new IllegalArgumentException(paramArrayOffq[i].getClass().getName() + " found in input should only contain DEROctetString");
      }
      catch (IOException paramArrayOffq)
      {
        throw new IllegalArgumentException("exception converting octets " + paramArrayOffq.toString());
      }
    }
    return localClassCastException.toByteArray();
  }
  
  final int a()
    throws IOException
  {
    Enumeration localEnumeration = a();
    for (int i = 0; localEnumeration.hasMoreElements(); i = ((fg)localEnumeration.nextElement()).b().a() + i) {}
    return i + 2 + 2;
  }
  
  public final Enumeration a()
  {
    Vector localVector;
    if (this.jdField_a_of_type_ArrayOfFq == null)
    {
      localVector = new Vector();
      int i = 0;
      if (i < this.jdField_a_of_type_ArrayOfByte.length)
      {
        if (i + 1000 > this.jdField_a_of_type_ArrayOfByte.length) {}
        for (int j = this.jdField_a_of_type_ArrayOfByte.length;; j = i + 1000)
        {
          localObject = new byte[j - i];
          System.arraycopy(this.jdField_a_of_type_ArrayOfByte, i, localObject, 0, localObject.length);
          localVector.addElement(new he((byte[])localObject));
          i += 1000;
          break;
        }
      }
    }
    for (Object localObject = localVector.elements();; localObject = new gg(this)) {
      return (Enumeration)localObject;
    }
  }
  
  public final void a(fs paramfs)
    throws IOException
  {
    paramfs.b(36);
    paramfs.b(128);
    Enumeration localEnumeration = a();
    while (localEnumeration.hasMoreElements()) {
      paramfs.a((fg)localEnumeration.nextElement());
    }
    paramfs.b(0);
    paramfs.b(0);
  }
  
  final boolean a()
  {
    return true;
  }
  
  public final byte[] b()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */