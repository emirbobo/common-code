import android.util.Log;
import java.text.SimpleDateFormat;

public class bk
{
  private static bk jdField_a_of_type_Bk;
  private static final bl jdField_a_of_type_Bl;
  private bl b;
  
  static
  {
    bk.class.getName();
    jdField_a_of_type_Bl = bl.d;
    new SimpleDateFormat("[HH:mm:ss] ");
  }
  
  public static bk a()
  {
    if (jdField_a_of_type_Bk == null)
    {
      bk localbk = new bk();
      jdField_a_of_type_Bk = localbk;
      localbk.b = jdField_a_of_type_Bl;
    }
    return jdField_a_of_type_Bk;
  }
  
  public final void a(String paramString)
  {
    a(null, paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      Log.d(paramString1, paramString2);
    }
    if (bl.jdField_a_of_type_Bl.ordinal() >= this.b.ordinal()) {
      new StringBuilder("[D] ").append(paramString2).toString();
    }
  }
  
  public final void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString1 != null)
    {
      if (paramThrowable != null) {
        Log.e(paramString1, paramString2, paramThrowable);
      }
    }
    else if (bl.d.ordinal() >= this.b.ordinal())
    {
      paramString2 = new StringBuilder("[E] ").append(paramString2);
      if (paramThrowable != null) {
        break label71;
      }
    }
    label71:
    for (paramString1 = "";; paramString1 = " | Exception:" + paramThrowable.toString())
    {
      paramString2.append(paramString1).toString();
      return;
      Log.e(paramString1, paramString2);
      break;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      Log.i(paramString1, paramString2);
    }
    if (bl.b.ordinal() >= this.b.ordinal()) {
      new StringBuilder("[I] ").append(paramString2).toString();
    }
  }
  
  public final void c(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      Log.w(paramString1, paramString2);
    }
    if (bl.c.ordinal() >= this.b.ordinal()) {
      new StringBuilder("[W] ").append(paramString2).toString();
    }
  }
  
  public final void d(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */