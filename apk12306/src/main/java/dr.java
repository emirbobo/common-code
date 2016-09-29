import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushCallback;

final class dr
  implements Runnable
{
  dr(df paramdf, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, IAnPushCallback paramIAnPushCallback) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim()))) {
          continue;
        }
        if (!this.b.equals("android-gcm")) {
          continue;
        }
        String str = this.jdField_a_of_type_Df.a("ANID");
        if (str == null) {
          continue;
        }
        this.jdField_a_of_type_Df.a(this.c, null, this.d, this.jdField_a_of_type_Boolean, this.b, str);
      }
      catch (ArrownockException localArrownockException)
      {
        if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback == null) {
          continue;
        }
        this.jdField_a_of_type_ComArrownockPushIAnPushCallback.unregister(true, localArrownockException);
        continue;
        this.jdField_a_of_type_Df.a(this.c, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_Boolean, this.b, null);
        this.jdField_a_of_type_Df.a("ANID");
        continue;
        bk.a().c(df.b(), "Device Token is null.");
        continue;
      }
      if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
        this.jdField_a_of_type_ComArrownockPushIAnPushCallback.unregister(false, null);
      }
      return;
      this.jdField_a_of_type_Df.a(this.c, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_Boolean, this.b, null);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */