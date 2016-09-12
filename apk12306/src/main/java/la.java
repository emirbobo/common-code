import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class la
  extends kp
{
  public String a = null;
  public String b;
  
  public la(lc paramlc)
  {
    super((byte)5);
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = paramlc.c();
  }
  
  public la(byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)5);
    this.jdField_b_of_type_JavaLangString = null;
    ko localko = new ko(new ByteArrayInputStream(paramArrayOfByte));
    Object localObject = new DataInputStream(localko);
    this.jdField_b_of_type_Int = ((DataInputStream)localObject).readUnsignedShort();
    ((DataInputStream)localObject).close();
    if (paramArrayOfByte.length > localko.a())
    {
      paramArrayOfByte = new byte[paramArrayOfByte.length - localko.a()];
      ((DataInputStream)localObject).readFully(paramArrayOfByte);
      localObject = new String(paramArrayOfByte);
    }
    try
    {
      paramArrayOfByte = new org/json/JSONObject;
      paramArrayOfByte.<init>((String)localObject);
      this.a = paramArrayOfByte.optString("msgId", null);
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;) {}
    }
  }
  
  protected final byte[] b_()
    throws jm
  {
    return d();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\la.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */