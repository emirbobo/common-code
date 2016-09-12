import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushRegistrationCallback;

final class ds
  implements Runnable
{
  ds(df paramdf, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, IAnPushRegistrationCallback paramIAnPushRegistrationCallback) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim()))) {
          continue;
        }
        str = this.jdField_a_of_type_Df.a("ANID");
        if (!this.b.equals("android-gcm")) {
          continue;
        }
        if (str == null) {
          continue;
        }
        this.jdField_a_of_type_Df.a(this.c, null, this.d, this.jdField_a_of_type_Boolean, this.b, str);
      }
      catch (ArrownockException localArrownockException)
      {
        String str;
        if (this.jdField_a_of_type_ComArrownockPushIAnPushRegistrationCallback == null) {
          continue;
        }
        this.jdField_a_of_type_ComArrownockPushIAnPushRegistrationCallback.onError(localArrownockException);
        continue;
        this.jdField_a_of_type_Df.a(this.c, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_Boolean, this.b, null);
        this.jdField_a_of_type_Df.a("ANID");
        continue;
        bk.a().c(df.b(), "Device Token is null.");
        continue;
      }
      if (this.jdField_a_of_type_ComArrownockPushIAnPushRegistrationCallback != null) {
        this.jdField_a_of_type_ComArrownockPushIAnPushRegistrationCallback.onSuccess(str);
      }
      return;
      this.jdField_a_of_type_Df.a(this.c, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_Boolean, this.b, null);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */