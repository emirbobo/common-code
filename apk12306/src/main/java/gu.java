import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Vector;

public final class gu
  extends fv
{
  private int jdField_a_of_type_Int;
  private fm jdField_a_of_type_Fm;
  private fp jdField_a_of_type_Fp;
  private fv jdField_a_of_type_Fv;
  private fv b;
  
  public gu(fh paramfh)
  {
    Object localObject2 = a(paramfh, 0);
    if ((localObject2 instanceof fp))
    {
      this.jdField_a_of_type_Fp = ((fp)localObject2);
      localObject2 = a(paramfh, 1);
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      int i = j;
      if ((localObject2 instanceof fm))
      {
        this.jdField_a_of_type_Fm = ((fm)localObject2);
        i = j + 1;
        localObject1 = a(paramfh, i);
      }
      localObject2 = localObject1;
      j = i;
      if (!(localObject1 instanceof hn))
      {
        this.jdField_a_of_type_Fv = ((fv)localObject1);
        j = i + 1;
        localObject2 = a(paramfh, j);
      }
      if (paramfh.a.size() != j + 1) {
        throw new IllegalArgumentException("input vector too large");
      }
      if (!(localObject2 instanceof hn)) {
        throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
      }
      paramfh = (hn)localObject2;
      i = paramfh.jdField_a_of_type_Int;
      if ((i < 0) || (i > 2)) {
        throw new IllegalArgumentException("invalid encoding value: " + i);
      }
      this.jdField_a_of_type_Int = i;
      if (paramfh.jdField_a_of_type_Fg != null) {}
      for (paramfh = paramfh.jdField_a_of_type_Fg.b();; paramfh = null)
      {
        this.b = paramfh;
        return;
      }
      j = 0;
    }
  }
  
  private static fv a(fh paramfh, int paramInt)
  {
    if (paramfh.a.size() <= paramInt) {
      throw new IllegalArgumentException("too few objects in input vector");
    }
    return paramfh.a(paramInt).b();
  }
  
  final int a()
    throws IOException
  {
    return a().length;
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (this.jdField_a_of_type_Fp != null) {
      localByteArrayOutputStream.write(this.jdField_a_of_type_Fp.a("DER"));
    }
    if (this.jdField_a_of_type_Fm != null) {
      localByteArrayOutputStream.write(this.jdField_a_of_type_Fm.a("DER"));
    }
    if (this.jdField_a_of_type_Fv != null) {
      localByteArrayOutputStream.write(this.jdField_a_of_type_Fv.a("DER"));
    }
    localByteArrayOutputStream.write(new hn(true, this.jdField_a_of_type_Int, this.b).a("DER"));
    paramfs.a(32, 8, localByteArrayOutputStream.toByteArray());
  }
  
  final boolean a()
  {
    return true;
  }
  
  final boolean a(fv paramfv)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramfv instanceof gu)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (this == paramfv)
      {
        bool1 = true;
      }
      else
      {
        paramfv = (gu)paramfv;
        if (this.jdField_a_of_type_Fp != null)
        {
          bool1 = bool2;
          if (paramfv.jdField_a_of_type_Fp != null)
          {
            bool1 = bool2;
            if (!paramfv.jdField_a_of_type_Fp.equals(this.jdField_a_of_type_Fp)) {}
          }
        }
        else if (this.jdField_a_of_type_Fm != null)
        {
          bool1 = bool2;
          if (paramfv.jdField_a_of_type_Fm != null)
          {
            bool1 = bool2;
            if (!paramfv.jdField_a_of_type_Fm.equals(this.jdField_a_of_type_Fm)) {}
          }
        }
        else if (this.jdField_a_of_type_Fv != null)
        {
          bool1 = bool2;
          if (paramfv.jdField_a_of_type_Fv != null)
          {
            bool1 = bool2;
            if (!paramfv.jdField_a_of_type_Fv.equals(this.jdField_a_of_type_Fv)) {}
          }
        }
        else
        {
          bool1 = this.b.equals(paramfv.b);
        }
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (this.jdField_a_of_type_Fp != null) {
      j = this.jdField_a_of_type_Fp.hashCode();
    }
    int i = j;
    if (this.jdField_a_of_type_Fm != null) {
      i = j ^ this.jdField_a_of_type_Fm.hashCode();
    }
    j = i;
    if (this.jdField_a_of_type_Fv != null) {
      j = i ^ this.jdField_a_of_type_Fv.hashCode();
    }
    return j ^ this.b.hashCode();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */