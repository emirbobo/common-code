import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import java.util.Timer;

public final class az
{
  LocationListener jdField_a_of_type_AndroidLocationLocationListener = new ba(this);
  LocationManager jdField_a_of_type_AndroidLocationLocationManager;
  bd jdField_a_of_type_Bd;
  Timer jdField_a_of_type_JavaUtilTimer;
  boolean jdField_a_of_type_Boolean = false;
  LocationListener jdField_b_of_type_AndroidLocationLocationListener = new bb(this);
  boolean jdField_b_of_type_Boolean = false;
  
  public static String a(byte[] paramArrayOfByte)
  {
    int m = 0;
    if (paramArrayOfByte == null) {}
    byte[] arrayOfByte2;
    for (paramArrayOfByte = null;; paramArrayOfByte = new String(arrayOfByte2))
    {
      return paramArrayOfByte;
      byte[] arrayOfByte1 = new byte[paramArrayOfByte.length + 2];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
      arrayOfByte2 = new byte[arrayOfByte1.length / 3 << 2];
      int j = 0;
      int i = 0;
      int k;
      for (;;)
      {
        k = m;
        if (i >= paramArrayOfByte.length) {
          break;
        }
        arrayOfByte2[j] = ((byte)(byte)(arrayOfByte1[i] >>> 2 & 0x3F));
        arrayOfByte2[(j + 1)] = ((byte)(byte)(arrayOfByte1[(i + 1)] >>> 4 & 0xF | arrayOfByte1[i] << 4 & 0x3F));
        arrayOfByte2[(j + 2)] = ((byte)(byte)(arrayOfByte1[(i + 2)] >>> 6 & 0x3 | arrayOfByte1[(i + 1)] << 2 & 0x3F));
        arrayOfByte2[(j + 3)] = ((byte)(byte)(arrayOfByte1[(i + 2)] & 0x3F));
        i += 3;
        j += 4;
      }
      if (k < arrayOfByte2.length)
      {
        if (arrayOfByte2[k] < 26) {
          arrayOfByte2[k] = ((byte)(byte)(arrayOfByte2[k] + 65));
        }
        for (;;)
        {
          k++;
          break;
          if (arrayOfByte2[k] < 52) {
            arrayOfByte2[k] = ((byte)(byte)(arrayOfByte2[k] + 97 - 26));
          } else if (arrayOfByte2[k] < 62) {
            arrayOfByte2[k] = ((byte)(byte)(arrayOfByte2[k] + 48 - 52));
          } else if (arrayOfByte2[k] < 63) {
            arrayOfByte2[k] = ((byte)43);
          } else {
            arrayOfByte2[k] = ((byte)47);
          }
        }
      }
      for (i = arrayOfByte2.length - 1; i > (paramArrayOfByte.length << 2) / 3; i--) {
        arrayOfByte2[i] = ((byte)61);
      }
    }
  }
  
  public static byte[] a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      byte[] arrayOfByte = paramString.getBytes();
      for (int i = arrayOfByte.length; arrayOfByte[(i - 1)] == 61; i--) {}
      paramString = new byte[i - arrayOfByte.length / 4];
      i = 0;
      if (i < arrayOfByte.length)
      {
        if (arrayOfByte[i] == 61) {
          arrayOfByte[i] = ((byte)0);
        }
        for (;;)
        {
          i++;
          break;
          if (arrayOfByte[i] == 47) {
            arrayOfByte[i] = ((byte)63);
          } else if (arrayOfByte[i] == 43) {
            arrayOfByte[i] = ((byte)62);
          } else if ((arrayOfByte[i] >= 48) && (arrayOfByte[i] <= 57)) {
            arrayOfByte[i] = ((byte)(byte)(arrayOfByte[i] + 4));
          } else if ((arrayOfByte[i] >= 97) && (arrayOfByte[i] <= 122)) {
            arrayOfByte[i] = ((byte)(byte)(arrayOfByte[i] - 71));
          } else if ((arrayOfByte[i] >= 65) && (arrayOfByte[i] <= 90)) {
            arrayOfByte[i] = ((byte)(byte)(arrayOfByte[i] - 65));
          }
        }
      }
      i = 0;
      while (j < paramString.length - 2)
      {
        paramString[j] = ((byte)(byte)(arrayOfByte[i] << 2 & 0xFF | arrayOfByte[(i + 1)] >>> 4 & 0x3));
        paramString[(j + 1)] = ((byte)(byte)(arrayOfByte[(i + 1)] << 4 & 0xFF | arrayOfByte[(i + 2)] >>> 2 & 0xF));
        paramString[(j + 2)] = ((byte)(byte)(arrayOfByte[(i + 2)] << 6 & 0xFF | arrayOfByte[(i + 3)] & 0x3F));
        i += 4;
        j += 3;
      }
      if (j < paramString.length) {
        paramString[j] = ((byte)(byte)(arrayOfByte[i] << 2 & 0xFF | arrayOfByte[(i + 1)] >>> 4 & 0x3));
      }
      int k = j + 1;
      if (k < paramString.length)
      {
        j = arrayOfByte[(i + 1)];
        paramString[k] = ((byte)(byte)(arrayOfByte[(i + 2)] >>> 2 & 0xF | j << 4 & 0xFF));
      }
    }
  }
  
  public final boolean a(Context paramContext, bd parambd)
  {
    this.jdField_a_of_type_Bd = parambd;
    if (this.jdField_a_of_type_AndroidLocationLocationManager == null) {
      this.jdField_a_of_type_AndroidLocationLocationManager = ((LocationManager)paramContext.getSystemService("location"));
    }
    try
    {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidLocationLocationManager.isProviderEnabled("gps");
      try
      {
        this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidLocationLocationManager.isProviderEnabled("network");
        if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {}
        for (;;)
        {
          try
          {
            Location localLocation = this.jdField_a_of_type_AndroidLocationLocationManager.getLastKnownLocation("gps");
            paramContext = localLocation;
            if (localLocation == null) {
              paramContext = this.jdField_a_of_type_AndroidLocationLocationManager.getLastKnownLocation("network");
            }
            if (paramContext == null) {
              continue;
            }
            parambd.a(paramContext);
            bool = true;
          }
          catch (Exception paramContext)
          {
            Log.w("DeviceManager", paramContext.getMessage());
            paramContext.printStackTrace();
            bool = false;
            continue;
          }
          return bool;
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_AndroidLocationLocationManager.requestLocationUpdates("gps", 0L, 0.0F, this.jdField_a_of_type_AndroidLocationLocationListener);
          }
          if (this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_AndroidLocationLocationManager.requestLocationUpdates("network", 0L, 0.0F, this.jdField_b_of_type_AndroidLocationLocationListener);
          }
          this.jdField_a_of_type_JavaUtilTimer = new Timer();
          this.jdField_a_of_type_JavaUtilTimer.schedule(new bc(this), 20000L);
          boolean bool = true;
        }
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */