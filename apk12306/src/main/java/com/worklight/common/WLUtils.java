package com.worklight.common;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.NoSuchResourceException;
import com.worklight.androidgap.WLDroidGap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.Checksum;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WLUtils
{
  public static final int ANDROID_BUFFER_8K = 8192;
  public static final String LOG_CAT = "WLDroidGap";
  public static final String WL_CHALLENGE_DATA = "WL-Challenge-Data";
  public static final String WL_CHALLENGE_RESPONSE_DATA = "WL-Challenge-Response-Data";
  public static final String WL_INSTANCE_AUTH_ID = "WL-Instance-Id";
  public static final String WL_PREFS = "WLPrefs";
  private static final String WWW = "www";
  
  static
  {
    JniLib.a(WLUtils.class, 1268);
  }
  
  public static native String byteArrayToHexString(byte[] paramArrayOfByte);
  
  private static native void calculateCheckSum(InputStream paramInputStream, Checksum paramChecksum);
  
  public static native boolean checkIfMediaFile(File paramFile);
  
  private static native boolean checkIfMediaFile(String paramString);
  
  public static native boolean checksumTestOnResources(String paramString, Context paramContext, boolean paramBoolean);
  
  public static native void clearWLPref(Context paramContext);
  
  private static native long computeChecksumOnBundle(Context paramContext);
  
  public static native long computeChecksumOnExternal(String paramString);
  
  public static native String convertGZIPStreamToString(InputStream paramInputStream);
  
  public static native List<String> convertJSONArrayToList(JSONArray paramJSONArray);
  
  public static native String convertStreamToString(InputStream paramInputStream);
  
  public static native JSONObject convertStringToJSON(String paramString)
    throws JSONException;
  
  public static native void copyFile(File paramFile1, File paramFile2)
    throws IOException;
  
  public static native void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException;
  
  public static native void debug(String paramString);
  
  public static native void debug(String paramString, Throwable paramThrowable);
  
  public static native boolean deleteDirectory(File paramFile)
    throws Exception;
  
  public static native void error(String paramString);
  
  public static native void error(String paramString, Throwable paramThrowable);
  
  public static native Drawable findDrawableAsset(WLDroidGap paramWLDroidGap, String paramString);
  
  private static native List<String> getBundleTree(String paramString, AssetManager paramAssetManager, List<String> paramList);
  
  public static native long getFreeSpaceOnDevice();
  
  public static native String getFullAppName(Context paramContext);
  
  private static native String getMsgNotNull(String paramString);
  
  public static native int getResourceId(Context paramContext, String paramString1, String paramString2)
    throws NoSuchResourceException;
  
  public static native String getResourceString(String paramString, Activity paramActivity);
  
  public static native int getSDKVersion();
  
  public static native List<File> getTree(File paramFile);
  
  private static native List<File> getTree(File paramFile, List<File> paramList);
  
  public static native byte[] hexStringToByteArray(String paramString);
  
  public static native void info(String paramString);
  
  public static native void info(String paramString, Throwable paramThrowable);
  
  public static native boolean isStringEmpty(String paramString);
  
  public static native void log(String paramString, int paramInt);
  
  public static native String readWLPref(Context paramContext, String paramString);
  
  private static native String readZipToStringString(InputStream paramInputStream)
    throws IOException;
  
  public static native Drawable scaleImage(Drawable paramDrawable, float paramFloat1, float paramFloat2);
  
  public static native void showDialog(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public static native void showDialog(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener);
  
  public static native void unpack(InputStream paramInputStream, File paramFile)
    throws IOException;
  
  public static native void warning(String paramString);
  
  public static native void warning(String paramString, Throwable paramThrowable);
  
  public static native void writeWLPref(Context paramContext, String paramString1, String paramString2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\WLUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */