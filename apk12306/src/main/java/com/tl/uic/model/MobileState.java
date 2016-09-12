package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class MobileState
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = -2088868938362419070L;
  private AndroidState androidState;
  private double battery;
  private String carrier;
  private String connectionType;
  private long freeMemory;
  private long freeStorage;
  private String ip;
  private ReachabilityType networkReachability;
  private int orientation;
  
  static
  {
    JniLib.a(MobileState.class, 1106);
  }
  
  public final native Boolean clean();
  
  public final native boolean equals(Object paramObject);
  
  public final native AndroidState getAndroidState();
  
  public final native double getBattery();
  
  public final native String getCarrier();
  
  public final native String getConnectionType();
  
  public final native long getFreeMemory();
  
  public final native long getFreeStorage();
  
  public final native String getIp();
  
  public final native JSONObject getJSON();
  
  public final native ReachabilityType getNetworkReachability();
  
  public final native int getOrientation();
  
  public final native int hashCode();
  
  public final native void setAndroidState(AndroidState paramAndroidState);
  
  public final native void setBattery(double paramDouble);
  
  public final native void setCarrier(String paramString);
  
  public final native void setConnectionType(String paramString);
  
  public final native void setFreeMemory(long paramLong);
  
  public final native void setFreeStorage(long paramLong);
  
  public final native void setIp(String paramString);
  
  public final native void setNetworkReachability(ReachabilityType paramReachabilityType);
  
  public final native void setOrientation(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\MobileState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */