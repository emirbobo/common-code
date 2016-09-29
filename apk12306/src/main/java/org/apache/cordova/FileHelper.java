package org.apache.cordova;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LOG;

public class FileHelper
{
  private static final String LOG_TAG = "FileUtils";
  private static final String _DATA = "_data";
  
  public static InputStream getInputStreamFromUriString(String paramString, CordovaInterface paramCordovaInterface)
    throws IOException
  {
    if (paramString.startsWith("content"))
    {
      paramString = Uri.parse(paramString);
      paramString = paramCordovaInterface.getActivity().getContentResolver().openInputStream(paramString);
    }
    for (;;)
    {
      return paramString;
      if (paramString.startsWith("file:///android_asset/"))
      {
        paramString = paramString.substring(22);
        paramString = paramCordovaInterface.getActivity().getAssets().open(paramString);
      }
      else
      {
        paramString = new FileInputStream(getRealPath(paramString, paramCordovaInterface));
      }
    }
  }
  
  public static String getMimeType(String paramString, CordovaInterface paramCordovaInterface)
  {
    if (paramString.startsWith("content://"))
    {
      paramString = Uri.parse(paramString);
      paramString = paramCordovaInterface.getActivity().getContentResolver().getType(paramString);
    }
    for (;;)
    {
      return paramString;
      paramString = MimeTypeMap.getFileExtensionFromUrl(paramString.replace(" ", "%20").toLowerCase());
      if (paramString.equals("3ga")) {
        paramString = "audio/3gpp";
      } else {
        paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      }
    }
  }
  
  public static String getRealPath(Uri paramUri, CordovaInterface paramCordovaInterface)
  {
    return getRealPath(paramUri.toString(), paramCordovaInterface);
  }
  
  public static String getRealPath(String paramString, CordovaInterface paramCordovaInterface)
  {
    String str;
    if (paramString.startsWith("content://"))
    {
      paramCordovaInterface = paramCordovaInterface.getActivity().managedQuery(Uri.parse(paramString), new String[] { "_data" }, null, null, null);
      int i = paramCordovaInterface.getColumnIndexOrThrow("_data");
      paramCordovaInterface.moveToFirst();
      str = paramCordovaInterface.getString(i);
      paramCordovaInterface = str;
      if (str == null)
      {
        LOG.e("FileUtils", "Could get real path for URI string %s", new Object[] { paramString });
        paramCordovaInterface = str;
      }
    }
    for (;;)
    {
      return paramCordovaInterface;
      if (paramString.startsWith("file://"))
      {
        str = paramString.substring(7);
        paramCordovaInterface = str;
        if (str.startsWith("/android_asset/"))
        {
          LOG.e("FileUtils", "Cannot get real path for URI string %s because it is a file:///android_asset/ URI.", new Object[] { paramString });
          paramCordovaInterface = null;
        }
      }
      else
      {
        paramCordovaInterface = paramString;
      }
    }
  }
  
  public static String stripFileProtocol(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("file://")) {
      str = paramString.substring(7);
    }
    return str;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\FileHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */