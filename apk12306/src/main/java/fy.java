import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public abstract class fy
  extends fv
{
  Vector jdField_a_of_type_JavaUtilVector = new Vector();
  private boolean jdField_a_of_type_Boolean = false;
  
  protected fy() {}
  
  protected fy(fh paramfh)
  {
    while (i != paramfh.jdField_a_of_type_JavaUtilVector.size())
    {
      this.jdField_a_of_type_JavaUtilVector.addElement(paramfh.a(i));
      i++;
    }
  }
  
  private static fg a(Enumeration paramEnumeration)
  {
    fg localfg = (fg)paramEnumeration.nextElement();
    paramEnumeration = localfg;
    if (localfg == null) {
      paramEnumeration = hb.a;
    }
    return paramEnumeration;
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilVector.size() > 1)
      {
        int n = this.jdField_a_of_type_JavaUtilVector.size() - 1;
        int i = 1;
        while (i != 0)
        {
          Object localObject1 = a((fg)this.jdField_a_of_type_JavaUtilVector.elementAt(0));
          int j = 0;
          int m = 0;
          i = 0;
          if (m != n)
          {
            Object localObject2 = a((fg)this.jdField_a_of_type_JavaUtilVector.elementAt(m + 1));
            int i1 = Math.min(localObject1.length, localObject2.length);
            int k = 0;
            label102:
            if (k != i1) {
              if (localObject1[k] != localObject2[k]) {
                if ((localObject1[k] & 0xFF) < (localObject2[k] & 0xFF))
                {
                  k = 1;
                  label140:
                  if (k == 0) {
                    break label195;
                  }
                  k = j;
                  j = i;
                  i = k;
                  localObject1 = localObject2;
                }
              }
            }
            for (;;)
            {
              m++;
              k = j;
              j = i;
              i = k;
              break;
              k = 0;
              break label140;
              k++;
              break label102;
              if (i1 == localObject1.length)
              {
                k = 1;
                break label140;
              }
              k = 0;
              break label140;
              label195:
              localObject2 = this.jdField_a_of_type_JavaUtilVector.elementAt(m);
              this.jdField_a_of_type_JavaUtilVector.setElementAt(this.jdField_a_of_type_JavaUtilVector.elementAt(m + 1), m);
              this.jdField_a_of_type_JavaUtilVector.setElementAt(localObject2, m + 1);
              j = 1;
              i = m;
            }
          }
          n = j;
        }
      }
    }
  }
  
  private static byte[] a(fg paramfg)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    fs localfs = new fs(localByteArrayOutputStream);
    try
    {
      localfs.a(paramfg);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramfg)
    {
      throw new IllegalArgumentException("cannot encode object added to SET");
    }
  }
  
  final boolean a()
  {
    return true;
  }
  
  final boolean a(fv paramfv)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramfv instanceof fy)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      Object localObject1 = (fy)paramfv;
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilVector.size() == ((fy)localObject1).jdField_a_of_type_JavaUtilVector.size())
      {
        paramfv = this.jdField_a_of_type_JavaUtilVector.elements();
        localObject1 = ((fy)localObject1).jdField_a_of_type_JavaUtilVector.elements();
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
  
  final fv c()
  {
    hk localhk;
    if (this.jdField_a_of_type_Boolean)
    {
      localhk = new hk();
      localhk.jdField_a_of_type_JavaUtilVector = this.jdField_a_of_type_JavaUtilVector;
    }
    for (;;)
    {
      return localhk;
      Vector localVector = new Vector();
      for (int i = 0; i != this.jdField_a_of_type_JavaUtilVector.size(); i++) {
        localVector.addElement(this.jdField_a_of_type_JavaUtilVector.elementAt(i));
      }
      localhk = new hk();
      localhk.jdField_a_of_type_JavaUtilVector = localVector;
      localhk.a();
    }
  }
  
  final fv d()
  {
    hu localhu = new hu();
    localhu.jdField_a_of_type_JavaUtilVector = this.jdField_a_of_type_JavaUtilVector;
    return localhu;
  }
  
  public int hashCode()
  {
    Enumeration localEnumeration = this.jdField_a_of_type_JavaUtilVector.elements();
    for (int i = this.jdField_a_of_type_JavaUtilVector.size(); localEnumeration.hasMoreElements(); i = i * 17 ^ a(localEnumeration).hashCode()) {}
    return i;
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaUtilVector.toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\fy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */