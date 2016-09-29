package com.ta.utdid2.device;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import com.ta.utdid2.android.utils.StringUtils;
import com.ta.utdid2.core.persistent.PersistentConfiguration;
import java.io.File;
import java.util.regex.Pattern;

public class UTUtdid
{
  private static final Object CREATE_LOCK;
  private static final String HMAC_KEY = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
  private static final String S_GLOBAL_PERSISTENT_CONFIG_DIR = ".UTSystemConfig" + File.separator + "Global";
  private static final String S_GLOBAL_PERSISTENT_CONFIG_KEY = "Alvin2";
  private static final String S_LOCAL_STORAGE_KEY = "ContextData";
  private static final String S_LOCAL_STORAGE_NAME = ".DataStorage";
  static final String UM_SETTINGS_STORAGE = "dxCRMxhQkdGePGnp";
  static final String UM_SETTINGS_STORAGE_NEW = "mqBRboGZkQPcAkyk";
  private static UTUtdid s_umutdid;
  private String mCBDomain = "xx_utdid_domain";
  private String mCBKey = "xx_utdid_key";
  private Context mContext = null;
  private PersistentConfiguration mPC = null;
  private Pattern mPattern = Pattern.compile("[^0-9a-zA-Z=/+]+");
  private PersistentConfiguration mTaoPC = null;
  private String mUtdid = null;
  private UTUtdidHelper mUtdidHelper = null;
  
  static
  {
    JniLib.a(UTUtdid.class, 1076);
    CREATE_LOCK = new Object();
    s_umutdid = null;
  }
  
  public UTUtdid(Context paramContext)
  {
    this.mContext = paramContext;
    this.mTaoPC = new PersistentConfiguration(paramContext, S_GLOBAL_PERSISTENT_CONFIG_DIR, "Alvin2", false, true);
    this.mPC = new PersistentConfiguration(paramContext, ".DataStorage", "ContextData", false, true);
    this.mUtdidHelper = new UTUtdidHelper();
    this.mCBKey = String.format("K_%d", new Object[] { Integer.valueOf(StringUtils.hashCode(this.mCBKey)) });
    this.mCBDomain = String.format("D_%d", new Object[] { Integer.valueOf(StringUtils.hashCode(this.mCBDomain)) });
  }
  
  private static native String _calcHmac(byte[] paramArrayOfByte)
    throws Exception;
  
  private final native byte[] _generateUtdid()
    throws Exception;
  
  static native long getMetadataCheckSum(Device paramDevice);
  
  private native String getUtdidFromTaoPPC();
  
  public static native UTUtdid instance(Context paramContext);
  
  private native boolean isValidUTDID(String paramString);
  
  private native void saveUtdidToLocalStorage(String paramString);
  
  private native void saveUtdidToNewSettings(String paramString);
  
  private native void saveUtdidToSettings(String paramString);
  
  private native void saveUtdidToTaoPPC(String paramString);
  
  private native void syncUTDIDToSettings(String paramString);
  
  public native String getValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\device\UTUtdid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */