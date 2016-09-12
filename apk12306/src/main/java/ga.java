import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public final class ga
{
  private final int jdField_a_of_type_Int;
  private final InputStream jdField_a_of_type_JavaIoInputStream;
  private final byte[][] jdField_a_of_type_Array2dOfByte;
  
  public ga(InputStream paramInputStream)
  {
    this(paramInputStream, id.a(paramInputStream));
  }
  
  public ga(InputStream paramInputStream, int paramInt)
  {
    this.jdField_a_of_type_JavaIoInputStream = paramInputStream;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Array2dOfByte = new byte[11][];
  }
  
  public final fg a()
    throws IOException
  {
    int j = this.jdField_a_of_type_JavaIoInputStream.read();
    Object localObject;
    if (j == -1) {
      localObject = null;
    }
    for (;;)
    {
      return (fg)localObject;
      if ((this.jdField_a_of_type_JavaIoInputStream instanceof hy)) {
        ((hy)this.jdField_a_of_type_JavaIoInputStream).a(false);
      }
      int i = fl.a(this.jdField_a_of_type_JavaIoInputStream, j);
      if ((j & 0x20) != 0) {}
      int k;
      for (boolean bool = true;; bool = false)
      {
        k = fl.b(this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Int);
        if (k >= 0) {
          break label295;
        }
        if (bool) {
          break;
        }
        throw new IOException("indefinite length primitive encoding encountered");
      }
      localObject = new ga(new hy(this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Int), this.jdField_a_of_type_Int);
      if ((j & 0x40) != 0) {
        localObject = new fd(i, (ga)localObject);
      } else if ((j & 0x80) != 0) {
        localObject = new gn(true, i, (ga)localObject);
      } else {
        switch (i)
        {
        default: 
          throw new fj("unknown BER object encountered: 0x" + Integer.toHexString(i));
        case 8: 
          localObject = new gv((ga)localObject);
          break;
        case 4: 
          localObject = new gh((ga)localObject);
          break;
        case 16: 
          localObject = new gj((ga)localObject);
          break;
        case 17: 
          localObject = new gl((ga)localObject);
          continue;
          label295:
          localObject = new hw(this.jdField_a_of_type_JavaIoInputStream, k);
          if ((j & 0x40) != 0)
          {
            localObject = new gp(bool, i, ((hw)localObject).a());
            continue;
          }
          if ((j & 0x80) != 0)
          {
            localObject = new gn(bool, i, new ga((InputStream)localObject));
            continue;
          }
          if (bool) {
            switch (i)
            {
            default: 
              throw new IOException("unknown tag " + i + " encountered");
            case 4: 
              localObject = new gh(new ga((InputStream)localObject));
              break;
            case 16: 
              localObject = new hj(new ga((InputStream)localObject));
              break;
            case 17: 
              localObject = new hl(new ga((InputStream)localObject));
              break;
            case 8: 
              localObject = new gv(new ga((InputStream)localObject));
              break;
            }
          }
          switch (i)
          {
          }
          break;
        }
      }
      try
      {
        localObject = fl.a(i, (hw)localObject, this.jdField_a_of_type_Array2dOfByte);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new fj("corrupted stream detected", localIllegalArgumentException);
      }
      localObject = new hf((hw)localObject);
    }
  }
  
  final fh a()
    throws IOException
  {
    fh localfh = new fh();
    for (;;)
    {
      fg localfg = a();
      if (localfg == null) {
        break;
      }
      if ((localfg instanceof hx)) {
        localfh.a(((hx)localfg).a());
      } else {
        localfh.a(localfg.b());
      }
    }
    return localfh;
  }
  
  final fv a(boolean paramBoolean, int paramInt)
    throws IOException
  {
    Object localObject;
    if (!paramBoolean) {
      localObject = new hn(false, paramInt, new he(((hw)this.jdField_a_of_type_JavaIoInputStream).a()));
    }
    for (;;)
    {
      return (fv)localObject;
      localObject = a();
      if ((this.jdField_a_of_type_JavaIoInputStream instanceof hy))
      {
        if (((fh)localObject).a.size() == 1) {
          localObject = new gm(true, paramInt, ((fh)localObject).a(0));
        } else {
          localObject = new gm(false, paramInt, ge.a((fh)localObject));
        }
      }
      else if (((fh)localObject).a.size() == 1) {
        localObject = new hn(true, paramInt, ((fh)localObject).a(0));
      } else {
        localObject = new hn(false, paramInt, gw.a((fh)localObject));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */