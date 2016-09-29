import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

public final class jz
  implements kc
{
  private Class jdField_a_of_type_JavaLangClass;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  
  public jz(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final InputStream a()
    throws IOException
  {
    try
    {
      InputStream localInputStream = (InputStream)this.jdField_a_of_type_JavaLangClass.getMethod("getClientInputStream", new Class[0]).invoke(this.jdField_a_of_type_JavaLangObject, new Object[0]);
      return localInputStream;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public final OutputStream a()
    throws IOException
  {
    try
    {
      OutputStream localOutputStream = (OutputStream)this.jdField_a_of_type_JavaLangClass.getMethod("getClientOutputStream", new Class[0]).invoke(this.jdField_a_of_type_JavaLangObject, new Object[0]);
      return localOutputStream;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public final void a()
    throws IOException, jm
  {
    if (!at.b("com.ibm.mqttdirect.modules.local.bindings.LocalListener")) {
      throw at.a(32103);
    }
    try
    {
      this.jdField_a_of_type_JavaLangClass = Class.forName("com.ibm.mqttdirect.modules.local.bindings.LocalListener");
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangClass.getMethod("connect", new Class[] { String.class }).invoke(null, new Object[] { this.jdField_a_of_type_JavaLangString });
      if (this.jdField_a_of_type_JavaLangObject == null) {
        throw at.a(32103);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public final void b()
    throws IOException
  {
    if (this.jdField_a_of_type_JavaLangObject != null) {}
    try
    {
      this.jdField_a_of_type_JavaLangClass.getMethod("close", new Class[0]).invoke(this.jdField_a_of_type_JavaLangObject, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */