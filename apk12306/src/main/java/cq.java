import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class cq
{
  private static cq jdField_a_of_type_Cq = new cq();
  private final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
  
  public static cq a()
  {
    return jdField_a_of_type_Cq;
  }
  
  private String a(cr paramcr, String paramString)
  {
    cr localcr2 = null;
    cr localcr1 = null;
    try
    {
      paramcr = MessageDigest.getInstance(paramcr.name());
      localcr1 = paramcr;
      localcr2 = paramcr;
      paramcr.update(paramString.getBytes("UTF-8"));
    }
    catch (NoSuchAlgorithmException paramcr)
    {
      for (;;)
      {
        int j;
        System.out.println("NoSuchAlgorithmException caught!");
        paramcr = localcr1;
      }
    }
    catch (UnsupportedEncodingException paramcr)
    {
      for (;;)
      {
        int m;
        paramcr.printStackTrace();
        paramcr = localcr2;
        continue;
        int k = this.jdField_a_of_type_ArrayOfChar[((k + m) % 36)];
        int i = k;
      }
    }
    paramString = paramcr.digest();
    paramcr = new StringBuffer();
    for (j = 0;; j++)
    {
      if (j >= paramString.length) {
        break label158;
      }
      m = paramString[j];
      k = m;
      if (m < 0) {
        k = Math.abs(m);
      }
      m = k / 36;
      if (m > 0) {
        break;
      }
      k = this.jdField_a_of_type_ArrayOfChar[k];
      i = k;
      paramcr.append(i);
    }
    label158:
    return paramcr.toString();
  }
  
  public final String a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.trim().equals(""))) {}
    for (paramString1 = null;; paramString1 = paramString3 + paramString1)
    {
      return paramString1;
      String str = paramString1;
      if (0L > 0L) {
        str = paramString1 + 0L;
      }
      paramString1 = a(cr.a, str + paramString2);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */