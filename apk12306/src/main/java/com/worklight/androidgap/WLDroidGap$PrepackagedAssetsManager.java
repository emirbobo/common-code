package com.worklight.androidgap;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class WLDroidGap$PrepackagedAssetsManager
{
  private static final String APP_INSTALL_TIME_KEY = "appInstallTime";
  private static final String RESOURCES_ZIP = "resources.zip";
  private long appInstallTime = -1L;
  
  static
  {
    JniLib.a(PrepackagedAssetsManager.class, 1146);
  }
  
  public WLDroidGap$PrepackagedAssetsManager(WLDroidGap paramWLDroidGap) {}
  
  private native void copyPrepackagedAssetsToLocalCopyIfNeeded();
  
  private native void deleteOldAssets();
  
  private native void handleNotEnoughSpace(Long paramLong, long paramLong1);
  
  private native boolean isNewInstallOrUpgrade();
  
  private native boolean isResourcesZippedInBundle();
  
  private native void setNewInstallTime();
  
  private native boolean unzipAssetsToLocalCopy();
  
  class Checksum
    implements Comparable<Checksum>
  {
    private String checksum;
    private Long date;
    private String machine;
    
    static
    {
      JniLib.a(Checksum.class, 1145);
    }
    
    public Checksum(JSONObject paramJSONObject)
      throws JSONException
    {
      this.checksum = paramJSONObject.getString("checksum");
      this.date = Long.valueOf(paramJSONObject.getLong("date"));
      this.machine = paramJSONObject.getString("machine");
    }
    
    public native int compareTo(Checksum paramChecksum);
    
    public native String getChecksum();
    
    public native Long getDate();
    
    public native String getMachine();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\WLDroidGap$PrepackagedAssetsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */