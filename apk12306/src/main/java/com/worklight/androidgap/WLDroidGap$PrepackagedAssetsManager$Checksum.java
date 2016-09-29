package com.worklight.androidgap;

import com.bangcle.andjni.JniLib;
import org.json.JSONException;
import org.json.JSONObject;

class WLDroidGap$PrepackagedAssetsManager$Checksum
  implements Comparable<Checksum>
{
  private String checksum;
  private Long date;
  private String machine;
  
  static
  {
    JniLib.a(Checksum.class, 1145);
  }
  
  public WLDroidGap$PrepackagedAssetsManager$Checksum(WLDroidGap.PrepackagedAssetsManager paramPrepackagedAssetsManager, JSONObject paramJSONObject)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\WLDroidGap$PrepackagedAssetsManager$Checksum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */