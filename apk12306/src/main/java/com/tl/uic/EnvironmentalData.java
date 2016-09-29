package com.tl.uic;

import android.app.Application;
import android.os.Handler;
import com.bangcle.andjni.JniLib;
import com.tl.uic.model.ClientEnvironment;
import com.tl.uic.model.ClientState;
import com.tl.uic.model.KeyboardStateType;
import com.tl.uic.model.KeyboardType;
import com.tl.uic.model.OrientationType;
import com.tl.uic.model.StorageType;
import com.tl.uic.util.BatteryReceiver;
import com.tl.uic.util.ClientStateTask;
import com.tl.uic.util.ConnectionReceiver;
import com.tl.uic.util.ScreenReceiver;
import java.util.TimerTask;

public class EnvironmentalData
{
  private static final int IP_BIT_16 = 16;
  private static final int IP_BIT_24 = 24;
  private static final int IP_BIT_8 = 8;
  private static final int SET_BITS_TO_CHAR = 255;
  private static ClientStateTask _clientStateTask;
  private Application _application;
  private String applicationName;
  private String applicationPackageName;
  private String applicationVersion;
  private BatteryReceiver batteryReceiver;
  private TimerTask clientStateTimerTask;
  private ConnectionReceiver connectionReceiver;
  private ClientState prevClientState;
  private ScreenReceiver screenReceiver;
  
  static
  {
    JniLib.a(EnvironmentalData.class, 1081);
  }
  
  public EnvironmentalData(Application paramApplication)
  {
    this._application = paramApplication;
    init();
  }
  
  public static final native Boolean closeClientStateTask();
  
  private native void init();
  
  private native Boolean isNotApplicationContextNull();
  
  private native Boolean isNotApplicationResourcesNull();
  
  public final native ClientEnvironment createClientEnvironment();
  
  public final native ClientState createClientState();
  
  public final native void disableBatteryManager();
  
  public final native void disableClientStateTask();
  
  public final native void disableConnectionListener();
  
  public final native void disableScreenReceiver();
  
  public final native void enableBatteryManager();
  
  public final native void enableClientStateTask();
  
  public final native void enableConnectionListener();
  
  public final native void enableScreenReceiver();
  
  public final native void getApplicationData();
  
  public final native String getApplicationName();
  
  public final native String getApplicationPackageName();
  
  public final native String getApplicationVersion();
  
  public final native long getAvailableMemory();
  
  public final native BatteryReceiver getBatteryReceiver();
  
  public final native String getCarrier();
  
  public final native TimerTask getClientStateTimerTask();
  
  public final native ConnectionReceiver getConnectionReceiver();
  
  public final native String getHttpXTealeafProperty();
  
  public final native String getIpAddress();
  
  public final native KeyboardStateType getKeyboardStateType();
  
  public final native KeyboardType getKeyboardType();
  
  public final native String getManufacturer();
  
  public final native OrientationType getOrientationType();
  
  public final native ScreenReceiver getScreenReceiver();
  
  public final native long getStorage(StorageType paramStorageType);
  
  public final native Boolean hasClientStateChanged();
  
  public final native Boolean onPause();
  
  public final native Boolean onResume();
  
  public final native void setupClientStateTask();
  
  public final native Boolean terminate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\EnvironmentalData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */