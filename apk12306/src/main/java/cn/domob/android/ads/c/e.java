package cn.domob.android.ads.c;

import cn.domob.android.i.f;

public class e
{
  private static f a = new f(e.class.getSimpleName());
  
  public static String a()
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append(Integer.valueOf("040602".substring(0, 2))).append(".").append(Integer.valueOf("040602".substring(2, 4))).append(".").append(Integer.valueOf("040602".substring(4, 6)));
      localObject = ((StringBuilder)localObject).toString();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a(localException);
        String str = "040602";
      }
    }
  }
  
  public static String b()
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("20141125".substring(0, 4)).append("-").append("20141125".substring(4, 6)).append("-").append("20141125".substring(6, 8));
      localObject = ((StringBuilder)localObject).toString();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a(localException);
        String str = "20141125";
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */