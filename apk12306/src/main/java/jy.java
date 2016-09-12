import java.util.Hashtable;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public final class jy
{
  private int jdField_a_of_type_Int;
  public String a;
  private Hashtable jdField_a_of_type_JavaUtilHashtable;
  public jj a;
  public js a;
  public kk a;
  public String b;
  
  public jy(String paramString1, String paramString2)
    throws jm
  {
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString2.length() > 23)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Kk = kk.a(paramString2);
    this.b = paramString1;
    int i;
    if (paramString1.startsWith("tcp://")) {
      i = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_Jj = null;
      if (this.jdField_a_of_type_Jj == null) {
        this.jdField_a_of_type_Jj = new jj();
      }
      this.jdField_a_of_type_Kk.a(101, new Object[] { paramString2, paramString1, null });
      this.jdField_a_of_type_Jj.a();
      this.jdField_a_of_type_Js = new js(this, this.jdField_a_of_type_Jj, this.jdField_a_of_type_Kk);
      this.jdField_a_of_type_Jj.jdField_a_of_type_JavaUtilHashtable.clear();
      this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
      return;
      if (paramString1.startsWith("ssl://"))
      {
        i = 1;
      }
      else
      {
        if (!paramString1.startsWith("local://")) {
          break;
        }
        i = 2;
      }
    }
    throw new IllegalArgumentException();
  }
  
  private static int a(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf(':');
    if (i == -1) {}
    for (;;)
    {
      return paramInt;
      paramInt = Integer.valueOf(paramString.substring(i + 1)).intValue();
    }
  }
  
  private static String a(String paramString)
  {
    int k = paramString.lastIndexOf('/');
    int j = paramString.lastIndexOf(':');
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    return paramString.substring(k + 1, i);
  }
  
  public final jr a(String paramString)
  {
    if ((paramString.indexOf('#') == -1) && (paramString.indexOf('+') == -1))
    {
      jr localjr2 = (jr)this.jdField_a_of_type_JavaUtilHashtable.get(paramString);
      jr localjr1 = localjr2;
      if (localjr2 == null)
      {
        localjr1 = new jr(paramString, this.jdField_a_of_type_Js);
        this.jdField_a_of_type_JavaUtilHashtable.put(paramString, localjr1);
      }
      return localjr1;
    }
    throw new IllegalArgumentException();
  }
  
  public final kc a(String paramString, jk paramjk)
    throws jm
  {
    Object localObject2 = null;
    Object localObject1 = paramjk.a;
    int i;
    String str;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramString = (String)localObject2;
      return paramString;
    case 0: 
      paramString = paramString.substring(6);
      localObject2 = a(paramString);
      i = a(paramString, 1883);
      if (localObject1 == null)
      {
        paramString = SocketFactory.getDefault();
        paramjk.a = paramString;
      }
      do
      {
        paramString = new kf(this.jdField_a_of_type_Kk, paramString, (String)localObject2, i);
        break;
        paramString = (String)localObject1;
      } while (!(localObject1 instanceof SSLSocketFactory));
      throw at.a(32105);
    case 1: 
      paramString = paramString.substring(6);
      str = a(paramString);
      i = a(paramString, 8883);
      if (localObject1 != null) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new ki;
        ((ki)localObject1).<init>();
        paramString = ki.a();
        localObject2 = new ke(this.jdField_a_of_type_Kk, (SSLSocketFactory)paramString, str, i);
        ((ke)localObject2).jdField_a_of_type_Int = paramjk.b;
        paramString = (String)localObject2;
        if (localObject1 == null) {
          break;
        }
        paramjk = ki.a();
        paramString = (String)localObject2;
        if (paramjk == null) {
          break;
        }
        ((ke)localObject2).a(paramjk);
        paramString = (String)localObject2;
      }
      catch (kg paramString)
      {
        throw at.a(paramString.getCause());
      }
      if (!(localObject1 instanceof SSLSocketFactory))
      {
        throw at.a(32105);
        paramString = new jz(paramString.substring(8));
        break;
      }
      localObject2 = null;
      paramString = (String)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public final void a(String[] paramArrayOfString, int[] paramArrayOfInt)
    throws jm, jq
  {
    if (paramArrayOfString.length != paramArrayOfInt.length) {
      throw new IllegalArgumentException();
    }
    if (this.jdField_a_of_type_Kk.a())
    {
      String str1 = "";
      for (int i = 0; i < paramArrayOfString.length; i++)
      {
        String str2 = str1;
        if (i > 0) {
          str2 = str1 + ", ";
        }
        str1 = str2 + paramArrayOfString[i] + ":" + paramArrayOfInt[i];
      }
      this.jdField_a_of_type_Kk.a(106, new Object[] { str1 });
    }
    paramArrayOfInt = new lf(paramArrayOfString, paramArrayOfInt);
    paramArrayOfString = this.jdField_a_of_type_Js;
    paramArrayOfString.a(paramArrayOfInt).a(paramArrayOfString.jdField_a_of_type_Int * 1000);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */