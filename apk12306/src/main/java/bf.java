import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

final class bf
  implements Runnable
{
  bf(be parambe, SharedPreferences paramSharedPreferences) {}
  
  public final void run()
  {
    Object localObject = be.a(this.jdField_a_of_type_Be);
    if (localObject == null) {}
    for (;;)
    {
      return;
      String str = this.jdField_a_of_type_Be.a();
      if (!"".equals(str))
      {
        ((List)localObject).add(new BasicNameValuePair("device_id", str));
        ((List)localObject).add(new BasicNameValuePair("device_type", "android"));
        ((List)localObject).add(new BasicNameValuePair("an_sdk", "2.25.3"));
        if (be.a(this.jdField_a_of_type_Be, be.a(this.jdField_a_of_type_Be) + "?key=" + be.b(this.jdField_a_of_type_Be), "POST", (List)localObject) == 200)
        {
          localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject).putBoolean("com.arrownock.internal.device.IS_REPORTED", true);
          ((SharedPreferences.Editor)localObject).putString("com.arrownock.internal.device.SDK_VERSION", "2.25.3");
          ((SharedPreferences.Editor)localObject).commit();
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */