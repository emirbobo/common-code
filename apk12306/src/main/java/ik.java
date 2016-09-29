import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;

public final class ik
  extends BasicPermission
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  
  public ik(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = a(paramString2);
  }
  
  private static int a(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(at.a(paramString), " ,");
    int i = 0;
    while (localStringTokenizer.hasMoreTokens())
    {
      paramString = localStringTokenizer.nextToken();
      if (paramString.equals("threadlocalecimplicitlyca")) {
        i |= 0x1;
      } else if (paramString.equals("ecimplicitlyca")) {
        i |= 0x2;
      } else if (paramString.equals("threadlocaldhdefaultparams")) {
        i |= 0x4;
      } else if (paramString.equals("dhdefaultparams")) {
        i |= 0x8;
      } else if (paramString.equals("all")) {
        i |= 0xF;
      }
    }
    if (i == 0) {
      throw new IllegalArgumentException("unknown permissions passed to mask");
    }
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if ((paramObject instanceof ik))
      {
        paramObject = (ik)paramObject;
        if ((this.jdField_a_of_type_Int != ((ik)paramObject).jdField_a_of_type_Int) || (!getName().equals(((ik)paramObject).getName()))) {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final String getActions()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final int hashCode()
  {
    return getName().hashCode() + this.jdField_a_of_type_Int;
  }
  
  public final boolean implies(Permission paramPermission)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramPermission instanceof ik)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (getName().equals(paramPermission.getName()))
      {
        paramPermission = (ik)paramPermission;
        bool1 = bool2;
        if ((this.jdField_a_of_type_Int & paramPermission.jdField_a_of_type_Int) == paramPermission.jdField_a_of_type_Int) {
          bool1 = true;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */