import java.util.Hashtable;
import javax.net.ssl.SSLSocketFactory;

public final class ji
{
  private int jdField_a_of_type_Int;
  public dz a;
  public ea a;
  public String a;
  private jy jdField_a_of_type_Jy = null;
  public boolean a;
  private int jdField_b_of_type_Int = 900;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private String f;
  private String g;
  
  public ji(String paramString1, int paramInt1, String paramString2, String paramString3, dz paramdz, int paramInt2)
  {
    this(paramString1, paramInt1, false, null, null, null, paramString2, paramString3, paramdz, "JKS", paramInt2);
  }
  
  public ji(String paramString1, int paramInt, String paramString2, String paramString3, dz paramdz, String paramString4)
  {
    this(paramString1, paramInt, false, null, null, null, paramString2, paramString3, paramdz, "JKS", 60, paramString4);
  }
  
  public ji(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, dz paramdz, String paramString7, String paramString8)
  {
    this(paramString1, paramInt, true, paramString2, paramString3, paramString4, paramString5, paramString6, paramdz, paramString7, 60, paramString8);
  }
  
  public ji(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, dz paramdz, String paramString7, int paramInt2)
  {
    this(paramString1, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, paramString6, paramdz, paramString7, paramInt2, null);
  }
  
  private ji(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, dz paramdz, String paramString7, int paramInt2, String paramString8)
  {
    this.jdField_a_of_type_Dz = null;
    this.jdField_a_of_type_Ea = ea.jdField_a_of_type_Ea;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString5;
    this.jdField_c_of_type_JavaLangString = paramString6;
    this.jdField_a_of_type_Dz = paramdz;
    this.jdField_e_of_type_JavaLangString = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.jdField_b_of_type_JavaLangString = paramString7;
    this.jdField_b_of_type_Int = paramInt2;
    paramString2 = new StringBuilder();
    if (this.jdField_b_of_type_Boolean) {
      paramString1 = "ssl://";
    }
    for (;;)
    {
      paramString2 = paramString1 + this.jdField_d_of_type_JavaLangString + ":" + this.jdField_a_of_type_Int;
      try
      {
        paramString1 = new jy;
        paramString1.<init>(paramString2, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Jy = paramString1;
      }
      catch (jm paramString1)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_Jy.jdField_a_of_type_Js.jdField_a_of_type_Ju.a(this);
            a(paramString7, paramString8);
            return;
            paramString1 = "tcp://";
            break;
            paramString1 = paramString1;
            if (this.jdField_a_of_type_Dz != null) {
              this.jdField_a_of_type_Dz.a(paramString1);
            }
          }
        }
        catch (jm paramString1)
        {
          for (;;)
          {
            this.jdField_a_of_type_Dz.a(paramString1);
          }
        }
      }
    }
  }
  
  private SSLSocketFactory a(String paramString)
  {
    try
    {
      paramString = at.a(this.jdField_e_of_type_JavaLangString, this.f, this.g, "", paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_Ea.equals(ea.c)) {
      this.jdField_d_of_type_Boolean = true;
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Ea = ea.b;
      try
      {
        localjy = this.jdField_a_of_type_Jy;
        kk localkk = localjy.jdField_a_of_type_Kk;
        localObject = new java/lang/Long;
        ((Long)localObject).<init>(30000L);
        localkk.a(104, new Object[] { localObject });
        localObject = new ks;
        ((ks)localObject).<init>();
      }
      catch (Exception localException)
      {
        try
        {
          jy localjy;
          Object localObject;
          localjy.jdField_a_of_type_Js.a((ks)localObject);
          this.jdField_a_of_type_Ea = ea.jdField_a_of_type_Ea;
          if (this.jdField_a_of_type_Dz == null) {
            continue;
          }
          this.jdField_a_of_type_Dz.b(null);
          this.jdField_d_of_type_Boolean = false;
          if (!this.jdField_e_of_type_Boolean) {
            break label162;
          }
          b();
        }
        catch (jm localjm)
        {
          localException.jdField_a_of_type_Kk.a(105, null, localjm);
          throw localjm;
        }
        localException = localException;
        this.jdField_a_of_type_Ea = ea.e;
      }
      if (this.jdField_a_of_type_Dz != null)
      {
        this.jdField_a_of_type_Dz.d(localException);
        continue;
        label162:
        if (this.jdField_c_of_type_Boolean) {
          a(this.jdField_b_of_type_JavaLangString, null);
        }
      }
    }
  }
  
  public final void a(String paramString)
  {
    a("clearSession", paramString, "", true, 0);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ea.equals(ea.b)) {
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Ea = ea.c;
      jk localjk;
      try
      {
        localjk = new jk;
        localjk.<init>();
        localjk.jdField_a_of_type_Boolean = false;
        localjk.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        if (paramString2 == null) {
          break label110;
        }
        if ((paramString2 == null) || (!paramString2.trim().equals(""))) {
          break label105;
        }
        paramString1 = new java/lang/IllegalArgumentException;
        paramString1.<init>();
        throw paramString1;
      }
      catch (Exception paramString1)
      {
        this.jdField_a_of_type_Ea = ea.e;
      }
      if (this.jdField_a_of_type_Dz != null)
      {
        this.jdField_a_of_type_Dz.c(paramString1);
        continue;
        label105:
        localjk.jdField_a_of_type_JavaLangString = paramString2;
        label110:
        if (this.jdField_b_of_type_Boolean) {
          localjk.jdField_a_of_type_JavaxNetSocketFactory = a(paramString1);
        }
        paramString1 = this.jdField_a_of_type_Jy;
        if (paramString1.jdField_a_of_type_Js.jdField_a_of_type_Boolean) {
          throw at.a(32100);
        }
        if (paramString1.jdField_a_of_type_Kk.a())
        {
          kk localkk = paramString1.jdField_a_of_type_Kk;
          Boolean localBoolean = new java/lang/Boolean;
          localBoolean.<init>(localjk.jdField_a_of_type_Boolean);
          localObject = new java/lang/Integer;
          ((Integer)localObject).<init>(localjk.jdField_b_of_type_Int);
          paramString2 = new java/lang/Integer;
          paramString2.<init>(localjk.jdField_a_of_type_Int);
          localkk.a(103, new Object[] { localBoolean, localObject, paramString2, localjk.jdField_a_of_type_JavaLangString, "[null]", "[null]" });
        }
        paramString1.jdField_a_of_type_Js.jdField_a_of_type_Kc = paramString1.a(paramString1.jdField_b_of_type_JavaLangString, localjk);
        paramString2 = paramString1.jdField_a_of_type_Jj;
        Object localObject = paramString1.jdField_a_of_type_JavaLangString;
        localObject = paramString1.jdField_b_of_type_JavaLangString;
        paramString2.a();
        if (localjk.jdField_a_of_type_Boolean) {
          paramString1.jdField_a_of_type_Jj.a.clear();
        }
        paramString2 = paramString1.jdField_a_of_type_Js;
        localObject = new kr;
        ((kr)localObject).<init>(paramString1.jdField_a_of_type_JavaLangString, localjk.jdField_a_of_type_Boolean, localjk.jdField_a_of_type_Int, localjk.jdField_a_of_type_JavaLangString);
        paramString2.a((kr)localObject, localjk.jdField_b_of_type_Int, localjk.jdField_a_of_type_Int, localjk.jdField_a_of_type_Boolean);
        paramString1 = this.jdField_c_of_type_JavaLangString;
        try
        {
          this.jdField_a_of_type_Jy.a(new String[] { paramString1 }, new int[] { 2 });
          this.jdField_a_of_type_Ea = ea.d;
          if (this.jdField_a_of_type_Dz != null) {
            this.jdField_a_of_type_Dz.b();
          }
          if (this.jdField_a_of_type_Dz == null) {
            continue;
          }
          this.jdField_a_of_type_Dz.a();
          this.jdField_c_of_type_Boolean = false;
          if (this.jdField_e_of_type_Boolean) {
            b();
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            this.jdField_a_of_type_Ea = ea.jdField_a_of_type_Ea;
            if (this.jdField_a_of_type_Dz != null) {
              this.jdField_a_of_type_Dz.e(paramString1);
            }
          }
        }
        if (this.jdField_d_of_type_Boolean) {
          a();
        }
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramString2 = this.jdField_a_of_type_Jy.a(paramString2);
        Object localObject = paramString3.getBytes();
        paramString3 = new jn;
        paramString3.<init>((byte[])localObject);
        paramString3.a(paramInt);
        paramString3.a(paramBoolean);
        localObject = paramString2.jdField_a_of_type_Js;
        lc locallc = new lc;
        locallc.<init>(paramString2.jdField_a_of_type_JavaLangString, paramString3);
        ((js)localObject).a(locallc).a(-1L);
        if (this.jdField_a_of_type_Dz != null)
        {
          if (this.jdField_a_of_type_Jy.jdField_a_of_type_Jj == null) {
            continue;
          }
          paramString3 = this.jdField_a_of_type_Jy.jdField_a_of_type_Jj;
          paramString2 = new java/lang/StringBuilder;
          paramString2.<init>("mid-");
          paramString2 = paramString3.a(paramString1);
          if ((paramString2 instanceof kb))
          {
            this.jdField_a_of_type_Dz.a(paramString1, ((kb)paramString2).jdField_a_of_type_JavaLangString);
            paramString2 = this.jdField_a_of_type_Jy.jdField_a_of_type_Jj;
            paramString3 = new java/lang/StringBuilder;
            paramString3.<init>("mid-");
            paramString2.a(paramString1);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString2)
      {
        if (this.jdField_a_of_type_Dz == null) {
          continue;
        }
        this.jdField_a_of_type_Dz.a(paramString1, paramString2);
        continue;
        this.jdField_a_of_type_Dz.a(paramString1, null);
        continue;
      }
      this.jdField_a_of_type_Dz.a(paramString1, null);
    }
  }
  
  public final void b()
  {
    if ((this.jdField_a_of_type_Ea.equals(ea.c)) || (this.jdField_a_of_type_Ea.equals(ea.b))) {
      this.jdField_e_of_type_Boolean = true;
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Jy = null;
      this.jdField_a_of_type_Ea = ea.jdField_a_of_type_Ea;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */