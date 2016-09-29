import java.io.EOFException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public final class jt
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  Object jdField_a_of_type_JavaLangObject = new Object();
  Hashtable jdField_a_of_type_JavaUtilHashtable = null;
  Vector jdField_a_of_type_JavaUtilVector;
  jj jdField_a_of_type_Jj;
  ju jdField_a_of_type_Ju = null;
  jx jdField_a_of_type_Jx;
  kk jdField_a_of_type_Kk;
  private li jdField_a_of_type_Li;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  Object jdField_b_of_type_JavaLangObject = new Object();
  Hashtable jdField_b_of_type_JavaUtilHashtable = null;
  Vector jdField_b_of_type_JavaUtilVector;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  Object jdField_c_of_type_JavaLangObject = new Object();
  Hashtable jdField_c_of_type_JavaUtilHashtable = null;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private Hashtable jdField_d_of_type_JavaUtilHashtable;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 10;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = false;
  
  protected jt(kk paramkk, jj paramjj, jx paramjx, ju paramju)
    throws jm
  {
    this.jdField_a_of_type_Kk = paramkk;
    this.jdField_d_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_JavaUtilVector = new Vector(this.jdField_e_of_type_Int);
    this.jdField_b_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_b_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_c_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_Li = new kw();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Jj = paramjj;
    this.jdField_a_of_type_Ju = paramju;
    this.jdField_a_of_type_Jx = paramjx;
    c();
  }
  
  private int a()
    throws jm
  {
    Hashtable localHashtable;
    do
    {
      try
      {
        int k = this.jdField_d_of_type_Int;
        j = 0;
        this.jdField_d_of_type_Int += 1;
        if (this.jdField_d_of_type_Int > 65535) {
          this.jdField_d_of_type_Int = 1;
        }
        i = j;
        if (this.jdField_d_of_type_Int == k)
        {
          j++;
          i = j;
          if (j == 2) {
            throw at.a(32001);
          }
        }
      }
      finally {}
      localHashtable = this.jdField_d_of_type_JavaUtilHashtable;
      localInteger = new java/lang/Integer;
      localInteger.<init>(this.jdField_d_of_type_Int);
      int j = i;
    } while (localHashtable.containsKey(localInteger));
    Integer localInteger = new java/lang/Integer;
    localInteger.<init>(this.jdField_d_of_type_Int);
    this.jdField_d_of_type_JavaUtilHashtable.put(localInteger, localInteger);
    int i = this.jdField_d_of_type_Int;
    return i;
  }
  
  static String a(li paramli)
  {
    return "s-" + paramli.c();
  }
  
  private static Vector a(Vector paramVector)
  {
    int i1 = 0;
    Vector localVector = new Vector();
    if (paramVector.size() == 0) {}
    for (;;)
    {
      return localVector;
      int i = 0;
      int j = 0;
      int k = 0;
      int m = 0;
      while (i < paramVector.size())
      {
        int i2 = ((li)paramVector.elementAt(i)).c();
        int n = k;
        if (i2 - m > k)
        {
          n = i2 - m;
          j = i;
        }
        i++;
        m = i2;
        k = n;
      }
      if (((li)paramVector.elementAt(0)).c() + (65535 - m) > k) {
        j = 0;
      }
      for (i = j;; i++)
      {
        k = i1;
        if (i >= paramVector.size()) {
          break;
        }
        localVector.addElement(paramVector.elementAt(i));
      }
      while (k < j)
      {
        localVector.addElement(paramVector.elementAt(k));
        k++;
      }
    }
  }
  
  private li a(String paramString, jo paramjo)
    throws jm
  {
    localObject2 = null;
    try
    {
      Object localObject3 = paramjo.a_();
      Object localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new byte[0];
      }
      localObject3 = new lj;
      ((lj)localObject3).<init>(paramjo.a(), paramjo.a(), (byte[])localObject1, paramjo.b());
      paramjo = li.a((InputStream)localObject3);
    }
    catch (jm paramjo)
    {
      for (;;)
      {
        this.jdField_a_of_type_Kk.a(602, new Object[] { paramString }, paramjo);
        if (!(paramjo.getCause() instanceof EOFException)) {
          break;
        }
        paramjo = (jo)localObject2;
        if (paramString != null)
        {
          this.jdField_a_of_type_Jj.a(paramString);
          paramjo = (jo)localObject2;
        }
      }
      throw paramjo;
    }
    this.jdField_a_of_type_Kk.a(601, new Object[] { paramString, paramjo });
    return paramjo;
  }
  
  private void a(int paramInt)
  {
    try
    {
      Hashtable localHashtable = this.jdField_d_of_type_JavaUtilHashtable;
      Integer localInteger = new java/lang/Integer;
      localInteger.<init>(paramInt);
      localHashtable.remove(localInteger);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void a(Vector paramVector, li paramli)
  {
    int j = paramli.c();
    int i = 0;
    if (i < paramVector.size()) {
      if (((li)paramVector.elementAt(i)).c() > j) {
        paramVector.insertElementAt(paramli, i);
      }
    }
    for (;;)
    {
      return;
      i++;
      break;
      paramVector.addElement(paramli);
    }
  }
  
  private boolean a()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Kk.a()) {
      this.jdField_a_of_type_Kk.a(626, new Object[] { new Boolean(this.jdField_b_of_type_Boolean), new Integer(this.jdField_a_of_type_Int), new Integer(this.jdField_b_of_type_JavaUtilVector.size()), new Integer(this.jdField_b_of_type_Int) });
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_JavaUtilVector.size() == 0) && (this.jdField_b_of_type_Int == 0)) {}
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaLangObject.notifyAll();
        return bool;
      }
      bool = false;
    }
  }
  
  static String b(li paramli)
  {
    return "r-" + paramli.c();
  }
  
  private li b()
    throws jm
  {
    li localli = null;
    if ((System.currentTimeMillis() - this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long) || (System.currentTimeMillis() - this.jdField_c_of_type_Long >= this.jdField_a_of_type_Long))
    {
      if (this.f)
      {
        if (this.jdField_a_of_type_Kk.a()) {
          this.jdField_a_of_type_Kk.a(619, new Object[] { new Long(this.jdField_a_of_type_Long), new Long(this.jdField_b_of_type_Long), new Long(this.jdField_c_of_type_Long) });
        }
        throw at.a(32000);
      }
      if (this.jdField_a_of_type_Kk.a()) {
        this.jdField_a_of_type_Kk.a(620, new Object[] { new Long(this.jdField_a_of_type_Long), new Long(this.jdField_b_of_type_Long), new Long(this.jdField_c_of_type_Long) });
      }
      this.f = true;
      localli = this.jdField_a_of_type_Li;
      this.jdField_a_of_type_Jx.d(localli);
    }
    return localli;
  }
  
  private void b()
    throws jm
  {
    this.jdField_a_of_type_Kk.a(603);
    this.jdField_a_of_type_Jj.jdField_a_of_type_JavaUtilHashtable.clear();
    this.jdField_d_of_type_JavaUtilHashtable.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_b_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilHashtable.clear();
    this.jdField_b_of_type_JavaUtilHashtable.clear();
    this.jdField_c_of_type_JavaUtilHashtable.clear();
    jx localjx = this.jdField_a_of_type_Jx;
    localjx.jdField_a_of_type_Kk.a(305);
    localjx.jdField_a_of_type_JavaUtilHashtable.clear();
  }
  
  private static String c(li paramli)
  {
    return "sc-" + paramli.c();
  }
  
  private void c()
    throws jm
  {
    Object localObject2 = this.jdField_a_of_type_Jj.jdField_a_of_type_JavaUtilHashtable.keys();
    int i = this.jdField_d_of_type_Int;
    Object localObject1 = new Vector();
    this.jdField_a_of_type_Kk.a(600);
    while (((Enumeration)localObject2).hasMoreElements())
    {
      Object localObject4 = (String)((Enumeration)localObject2).nextElement();
      Object localObject6 = a((String)localObject4, this.jdField_a_of_type_Jj.a((String)localObject4));
      if (localObject6 != null) {
        if (((String)localObject4).startsWith("r-"))
        {
          this.jdField_a_of_type_Kk.a(604, new Object[] { localObject4, localObject6 });
          this.jdField_c_of_type_JavaUtilHashtable.put(new Integer(((li)localObject6).c()), localObject6);
        }
        else
        {
          Object localObject3;
          if (((String)localObject4).startsWith("s-"))
          {
            localObject3 = (lc)localObject6;
            i = Math.max(((lc)localObject3).c(), i);
            Object localObject5;
            if (this.jdField_a_of_type_Jj.a(c((li)localObject3)))
            {
              localObject5 = (lb)a((String)localObject4, this.jdField_a_of_type_Jj.a(c((li)localObject3)));
              if (localObject5 != null)
              {
                this.jdField_a_of_type_Kk.a(605, new Object[] { localObject4, localObject6 });
                this.jdField_a_of_type_JavaUtilHashtable.put(new Integer(((lb)localObject5).c()), localObject5);
                label251:
                localObject4 = this.jdField_a_of_type_Jx;
                localObject5 = new Integer(((lc)localObject3).c());
                if (!((jx)localObject4).jdField_a_of_type_JavaUtilHashtable.containsKey(localObject5)) {
                  break label512;
                }
                localObject6 = (jl)((jx)localObject4).jdField_a_of_type_JavaUtilHashtable.get(localObject5);
                if (((jx)localObject4).jdField_a_of_type_Kk.a()) {
                  ((jx)localObject4).jdField_a_of_type_Kk.a(302, new Object[] { localObject3, localObject5, localObject6 });
                }
              }
            }
            for (;;)
            {
              this.jdField_d_of_type_JavaUtilHashtable.put(new Integer(((lc)localObject3).c()), new Integer(((lc)localObject3).c()));
              break;
              this.jdField_a_of_type_Kk.a(606, new Object[] { localObject4, localObject6 });
              break label251;
              if (((lc)localObject3).a.jdField_a_of_type_Int == 2)
              {
                this.jdField_a_of_type_Kk.a(607, new Object[] { localObject4, localObject6 });
                this.jdField_a_of_type_JavaUtilHashtable.put(new Integer(((lc)localObject3).c()), localObject3);
                break label251;
              }
              this.jdField_a_of_type_Kk.a(608, new Object[] { localObject4, localObject6 });
              this.jdField_b_of_type_JavaUtilHashtable.put(new Integer(((lc)localObject3).c()), localObject3);
              break label251;
              label512:
              localObject6 = new jl(((jx)localObject4).jdField_a_of_type_Kk, (lc)localObject3);
              ((jx)localObject4).jdField_a_of_type_JavaUtilHashtable.put(localObject5, localObject6);
              if (((jx)localObject4).jdField_a_of_type_Kk.a()) {
                ((jx)localObject4).jdField_a_of_type_Kk.a(303, new Object[] { localObject3, localObject5, localObject6 });
              }
            }
          }
          if (((String)localObject4).startsWith("sc-"))
          {
            localObject3 = (lb)localObject6;
            if (!this.jdField_a_of_type_Jj.a(a((li)localObject3))) {
              ((Vector)localObject1).addElement(localObject4);
            }
          }
        }
      }
    }
    localObject1 = ((Vector)localObject1).elements();
    while (((Enumeration)localObject1).hasMoreElements())
    {
      localObject2 = (String)((Enumeration)localObject1).nextElement();
      this.jdField_a_of_type_Kk.a(609, new Object[] { localObject2 });
      this.jdField_a_of_type_Jj.a((String)localObject2);
    }
    this.jdField_d_of_type_Int = i;
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector(this.jdField_e_of_type_Int);
    this.jdField_b_of_type_JavaUtilVector = new Vector();
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashtable.keys();
    Object localObject3;
    while (((Enumeration)localObject1).hasMoreElements())
    {
      localObject2 = ((Enumeration)localObject1).nextElement();
      localObject3 = this.jdField_a_of_type_JavaUtilHashtable.get(localObject2);
      if ((localObject3 instanceof lc))
      {
        this.jdField_a_of_type_Kk.a(610, new Object[] { localObject2 });
        a(this.jdField_a_of_type_JavaUtilVector, (lc)localObject3);
      }
      else if ((localObject3 instanceof lb))
      {
        this.jdField_a_of_type_Kk.a(611, new Object[] { localObject2 });
        a(this.jdField_b_of_type_JavaUtilVector, (lb)localObject3);
      }
    }
    Object localObject2 = this.jdField_b_of_type_JavaUtilHashtable.keys();
    while (((Enumeration)localObject2).hasMoreElements())
    {
      localObject1 = ((Enumeration)localObject2).nextElement();
      localObject3 = (lc)this.jdField_b_of_type_JavaUtilHashtable.get(localObject1);
      this.jdField_a_of_type_Kk.a(612, new Object[] { localObject1 });
      a(this.jdField_a_of_type_JavaUtilVector, (li)localObject3);
    }
    this.jdField_b_of_type_JavaUtilVector = a(this.jdField_b_of_type_JavaUtilVector);
    this.jdField_a_of_type_JavaUtilVector = a(this.jdField_a_of_type_JavaUtilVector);
  }
  
  private void e()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Int -= 1;
      if (this.jdField_a_of_type_Kk.a())
      {
        kk localkk = this.jdField_a_of_type_Kk;
        Integer localInteger = new java/lang/Integer;
        localInteger.<init>(this.jdField_a_of_type_Int);
        localkk.a(646, new Object[] { localInteger });
      }
      if (!a()) {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
      }
      return;
    }
  }
  
  public final jl a(li paramli)
    throws jm
  {
    if ((paramli instanceof kr))
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = false;
    }
    if ((paramli.a()) && (paramli.c() == 0)) {
      paramli.a(a());
    }
    if ((paramli instanceof lc)) {}
    Object localObject1;
    kk localkk;
    Integer localInteger;
    Object localObject3;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Kk.a()) {
          this.jdField_a_of_type_Kk.a(613, new Object[] { paramli });
        }
        throw at.a(32102);
      }
    }
  }
  
  protected final li a()
    throws jm
  {
    for (;;)
    {
      li localli;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((!this.jdField_d_of_type_Boolean) || (!this.jdField_e_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
          break label469;
        }
        this.jdField_a_of_type_Kk.a(648);
        localli = null;
        return localli;
        if (!this.jdField_b_of_type_JavaUtilVector.isEmpty())
        {
          localli = (li)this.jdField_b_of_type_JavaUtilVector.elementAt(0);
          this.jdField_b_of_type_JavaUtilVector.removeElementAt(0);
          a();
          if (localli != null) {
            break label379;
          }
          if (this.jdField_a_of_type_JavaUtilVector.isEmpty())
          {
            boolean bool = this.jdField_b_of_type_JavaUtilVector.isEmpty();
            if (!bool) {}
          }
        }
      }
      try
      {
        this.jdField_a_of_type_Kk.a(644);
        this.jdField_a_of_type_JavaLangObject.wait(this.jdField_a_of_type_Long);
        if (((this.jdField_b_of_type_JavaUtilVector.isEmpty()) || (!((li)this.jdField_b_of_type_JavaUtilVector.elementAt(0) instanceof kr))) && (!this.jdField_c_of_type_Boolean))
        {
          this.jdField_a_of_type_Kk.a(621);
          localli = null;
          continue;
        }
        if ((!this.jdField_a_of_type_JavaUtilVector.isEmpty()) || (!this.jdField_b_of_type_JavaUtilVector.isEmpty())) {
          continue;
        }
        localli = b();
        continue;
        if (this.jdField_a_of_type_JavaUtilVector.isEmpty()) {
          continue;
        }
        if (this.jdField_a_of_type_Int == this.jdField_e_of_type_Int) {
          this.jdField_a_of_type_Kk.a(622);
        }
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(this.jdField_a_of_type_Long);
          if (!this.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_Kk.a(647);
            localli = null;
            continue;
          }
          if (this.jdField_a_of_type_Int >= this.jdField_e_of_type_Int) {
            continue;
          }
          localli = (li)this.jdField_a_of_type_JavaUtilVector.elementAt(0);
          this.jdField_a_of_type_JavaUtilVector.removeElementAt(0);
          if (localli == null)
          {
            localli = b();
            continue;
          }
          this.jdField_a_of_type_Int += 1;
          if (this.jdField_a_of_type_Kk.a())
          {
            kk localkk = this.jdField_a_of_type_Kk;
            Integer localInteger = new java/lang/Integer;
            localInteger.<init>(this.jdField_a_of_type_Int);
            localkk.a(623, new Object[] { localInteger });
            continue;
            label379:
            if (this.jdField_a_of_type_Kk.a())
            {
              if (localli != null)
              {
                i = localli.c();
                this.jdField_a_of_type_Kk.a(624, new Object[] { localli, new Integer(i) });
              }
            }
            else
            {
              if ((localli instanceof kr)) {
                this.jdField_d_of_type_Boolean = true;
              }
              continue;
              localObject1 = finally;
              throw ((Throwable)localObject1);
            }
          }
        }
        catch (InterruptedException localInterruptedException1)
        {
          for (;;) {}
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        for (;;)
        {
          continue;
          int i = 0;
        }
      }
      continue;
      label469:
      Object localObject2 = null;
    }
  }
  
  protected final void a()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Int -= 1;
      if (this.jdField_a_of_type_Kk.a())
      {
        kk localkk = this.jdField_a_of_type_Kk;
        Integer localInteger = new java/lang/Integer;
        localInteger.<init>(this.jdField_c_of_type_Int);
        localkk.a(643, new Object[] { localInteger });
      }
      if (this.jdField_c_of_type_Int == 0) {
        this.jdField_c_of_type_JavaLangObject.notifyAll();
      }
      return;
    }
  }
  
  final void a(Vector paramVector)
  {
    this.jdField_a_of_type_Kk.a(636);
    Enumeration localEnumeration = paramVector.elements();
    jm localjm = at.a(32102);
    while (localEnumeration.hasMoreElements())
    {
      li localli = (li)localEnumeration.nextElement();
      jl localjl = this.jdField_a_of_type_Jx.a(localli);
      Integer localInteger = new Integer(localli.c());
      if (this.jdField_a_of_type_JavaUtilHashtable.containsKey(localInteger)) {
        this.jdField_a_of_type_JavaUtilHashtable.remove(localInteger);
      }
      if (localjl != null)
      {
        localjl.a(localjm);
        this.jdField_a_of_type_Jx.c(localli);
      }
      paramVector.removeElement(localli);
    }
  }
  
  public final void a(jm paramjm)
  {
    this.jdField_a_of_type_Kk.a(632, null, paramjm);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      ??? = this.jdField_a_of_type_Jx;
      ((jx)???).jdField_a_of_type_Boolean = true;
      ((jx)???).jdField_a_of_type_Jm = paramjm;
      Enumeration localEnumeration = ((jx)???).jdField_a_of_type_JavaUtilHashtable.elements();
      ((jx)???).jdField_a_of_type_Kk.a(304, null, paramjm);
      for (;;)
      {
        if (localEnumeration.hasMoreElements())
        {
          ??? = localEnumeration.nextElement();
          if (??? != null) {
            try
            {
              ((jl)???).a(paramjm);
            }
            finally
            {
              paramjm = finally;
              throw paramjm;
            }
          }
        }
      }
    }
  }
  
  protected final void a(li paramli)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Kk.a()) {
      this.jdField_a_of_type_Kk.a(625, new Object[] { paramli });
    }
    jl localjl = this.jdField_a_of_type_Jx.a(paramli);
    localjl.jdField_a_of_type_Kk.a(403, new Object[] { localjl });
    synchronized (localjl.jdField_a_of_type_JavaLangObject)
    {
      localjl.jdField_a_of_type_Li = null;
      localjl.jdField_b_of_type_Boolean = false;
    }
    synchronized (localjl.jdField_b_of_type_JavaLangObject)
    {
      localjl.jdField_a_of_type_Boolean = true;
      localjl.jdField_b_of_type_JavaLangObject.notifyAll();
      if (((paramli instanceof lc)) && (((lc)paramli).a.jdField_a_of_type_Int == 0))
      {
        localjl.a(null);
        this.jdField_a_of_type_Jx.c(paramli);
        this.jdField_a_of_type_Ju.a(localjl);
        e();
        a(paramli.c());
      }
      if ((paramli instanceof ks)) {
        this.jdField_a_of_type_Jx.c(paramli);
      }
      return;
      paramli = finally;
      throw paramli;
    }
  }
  
  public final void b(jm arg1)
  {
    this.jdField_a_of_type_Kk.a(633, null, ???);
    this.jdField_c_of_type_Boolean = false;
    kk localkk;
    Integer localInteger;
    int i;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
    }
  }
  
  protected final void b(li paramli)
    throws jm
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Kk.a()) {
      this.jdField_a_of_type_Kk.a(627, new Object[] { paramli, new Integer(paramli.c()) });
    }
    kp localkp;
    Object localObject1;
    if ((paramli instanceof kp))
    {
      localkp = (kp)paramli;
      localObject1 = this.jdField_a_of_type_Jx.a(paramli);
      if (((localkp instanceof la)) && (this.jdField_a_of_type_JavaUtilHashtable.containsKey(new Integer(localkp.c()))))
      {
        a(new lb((la)localkp));
        paramli = (la)localkp;
        if ((paramli.a != null) && (paramli.b != null)) {
          this.jdField_a_of_type_Jj.a("mid-" + paramli.a, new kb(paramli.b));
        }
      }
    }
    for (;;)
    {
      return;
      if ((localkp instanceof ky))
      {
        if (this.jdField_a_of_type_Kk.a()) {
          this.jdField_a_of_type_Kk.a(628, new Object[] { new Integer(localkp.c()) });
        }
        this.jdField_a_of_type_Jj.a(a(paramli));
        this.jdField_b_of_type_JavaUtilHashtable.remove(new Integer(localkp.c()));
        label247:
        a(paramli.c());
        if (((localkp instanceof ky)) || ((localkp instanceof la)) || ((localkp instanceof kz))) {
          e();
        }
        if (!(localkp instanceof kx)) {
          break label482;
        }
        this.jdField_a_of_type_Kk.a(629);
        this.f = false;
      }
      label482:
      while (!(paramli instanceof kq))
      {
        ??? = this.jdField_a_of_type_Jx;
        paramli = (kp)paramli;
        jl localjl = ((jx)???).b(paramli);
        ((jx)???).c(paramli);
        if (localjl != null) {
          localjl.a(paramli);
        }
        if (((localkp instanceof ky)) || ((localkp instanceof kz))) {
          this.jdField_a_of_type_Ju.a((jl)localObject1);
        }
        a();
        break;
        if (!(localkp instanceof kz)) {
          break label247;
        }
        this.jdField_a_of_type_JavaUtilHashtable.remove(new Integer(localkp.c()));
        this.jdField_a_of_type_Jj.a(a(paramli));
        this.jdField_a_of_type_Jj.a(c(paramli));
        this.jdField_b_of_type_Int -= 1;
        if (!this.jdField_a_of_type_Kk.a()) {
          break label247;
        }
        this.jdField_a_of_type_Kk.a(645, new Object[] { new Integer(localkp.c()), new Integer(this.jdField_b_of_type_Int) });
        break label247;
      }
      if (((kq)paramli).jdField_a_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_Boolean) {
          b();
        }
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
        d();
        this.jdField_a_of_type_Kk.a(631);
        this.jdField_c_of_type_Boolean = true;
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaLangObject.notifyAll();
        }
        this.jdField_e_of_type_Boolean = true;
      }
      if (!this.jdField_b_of_type_Boolean) {
        if ((paramli instanceof lc))
        {
          localObject1 = (lc)paramli;
          switch (((lc)localObject1).a.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 0: 
          case 1: 
            if (this.jdField_a_of_type_Ju == null) {
              continue;
            }
            this.jdField_a_of_type_Ju.a((lc)localObject1);
            break;
          case 2: 
            if (this.jdField_a_of_type_Kk.a()) {
              this.jdField_a_of_type_Kk.a(630, new Object[] { new Integer(((lc)localObject1).c()) });
            }
            this.jdField_a_of_type_Jj.a(b(paramli), (lc)paramli);
            this.jdField_c_of_type_JavaUtilHashtable.put(new Integer(((lc)localObject1).c()), localObject1);
            a(new la((lc)localObject1));
            break;
          }
        }
        else if ((paramli instanceof lb))
        {
          localObject1 = (lc)this.jdField_c_of_type_JavaUtilHashtable.get(new Integer(paramli.c()));
          if (localObject1 != null)
          {
            if (this.jdField_a_of_type_Ju != null) {
              this.jdField_a_of_type_Ju.a((lc)localObject1);
            }
          }
          else {
            a(new kz(paramli.c()));
          }
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */