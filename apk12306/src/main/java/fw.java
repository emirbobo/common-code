import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public abstract class fw
  extends fv
{
  protected Vector a = new Vector();
  
  protected fw() {}
  
  protected fw(fh paramfh)
  {
    for (int i = 0; i != paramfh.a.size(); i++) {
      this.a.addElement(paramfh.a(i));
    }
  }
  
  private static fg a(Enumeration paramEnumeration)
  {
    return (fg)paramEnumeration.nextElement();
  }
  
  public static fw a(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof fw))) {}
    fv localfv;
    for (paramObject = (fw)paramObject;; paramObject = (fw)localfv)
    {
      for (;;)
      {
        return (fw)paramObject;
        if ((paramObject instanceof fx))
        {
          paramObject = ((fx)paramObject).b();
          break;
        }
        if ((paramObject instanceof byte[])) {
          try
          {
            paramObject = a(a((byte[])paramObject));
          }
          catch (IOException paramObject)
          {
            throw new IllegalArgumentException("failed to construct sequence from byte[]: " + ((IOException)paramObject).getMessage());
          }
        }
      }
      if (!(paramObject instanceof fg)) {
        break label119;
      }
      localfv = ((fg)paramObject).b();
      if (!(localfv instanceof fw)) {
        break label119;
      }
    }
    label119:
    throw new IllegalArgumentException("unknown object in getInstance: " + paramObject.getClass().getName());
  }
  
  public Enumeration a()
  {
    return this.a.elements();
  }
  
  final boolean a()
  {
    return true;
  }
  
  final boolean a(fv paramfv)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramfv instanceof fw)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      Object localObject1 = (fw)paramfv;
      bool1 = bool2;
      if (b() == ((fw)localObject1).b())
      {
        paramfv = a();
        localObject1 = ((fw)localObject1).a();
        for (;;)
        {
          if (paramfv.hasMoreElements())
          {
            Object localObject2 = a(paramfv);
            Object localObject3 = a((Enumeration)localObject1);
            localObject2 = ((fg)localObject2).b();
            localObject3 = ((fg)localObject3).b();
            if ((localObject2 != localObject3) && (!((fv)localObject2).equals(localObject3)))
            {
              bool1 = bool2;
              break;
            }
          }
        }
        bool1 = true;
      }
    }
  }
  
  public int b()
  {
    return this.a.size();
  }
  
  fv c()
  {
    hi localhi = new hi();
    localhi.a = this.a;
    return localhi;
  }
  
  fv d()
  {
    ht localht = new ht();
    localht.a = this.a;
    return localht;
  }
  
  public int hashCode()
  {
    Enumeration localEnumeration = a();
    for (int i = b(); localEnumeration.hasMoreElements(); i = i * 17 ^ a(localEnumeration).hashCode()) {}
    return i;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\fw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */