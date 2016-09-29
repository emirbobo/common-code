public abstract class ka
{
  private static ka a = null;
  
  public static final String a(int paramInt)
  {
    if ((a != null) || (at.b("java.util.ResourceBundle"))) {}
    for (;;)
    {
      try
      {
        a = (ka)Class.forName("kd").newInstance();
        str1 = a.b(paramInt);
      }
      catch (Exception localException1)
      {
        String str1;
        String str2 = "";
        continue;
      }
      return str1;
      if (at.b("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog")) {
        try
        {
          a = (ka)Class.forName("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog").newInstance();
        }
        catch (Exception localException2)
        {
          String str3 = "";
        }
      }
    }
  }
  
  protected abstract String b(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */