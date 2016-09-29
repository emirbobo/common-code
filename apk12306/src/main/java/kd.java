import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class kd
  extends ka
{
  private ResourceBundle a = ResourceBundle.getBundle("org.eclipse.paho.client.mqttv3.internal.nls.messages");
  
  public kd()
    throws MissingResourceException
  {}
  
  protected final String b(int paramInt)
  {
    try
    {
      String str1 = this.a.getString(Integer.toString(paramInt));
      return str1;
    }
    catch (MissingResourceException localMissingResourceException)
    {
      for (;;)
      {
        String str2 = "MqttException";
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\kd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */