package com.bangcle.andjni;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.secneo.apkwrapper.Helper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class JniLib
  extends Application
{
  private static final String LIB_DIR = "lib";
  private static final String TAG = "LibraryLoaderHelper";
  private static boolean sLibrariesWereUnpacked;
  
  static
  {
    boolean bool;
    if (!JniLib.class.desiredAssertionStatus()) {
      bool = true;
    }
    for (;;)
    {
      $assertionsDisabled = bool;
      try
      {
        System.loadLibrary("DexHelper");
        if (Helper.PPATH != null) {
          System.load(Helper.PPATH);
        }
        sLibrariesWereUnpacked = false;
        return;
        bool = false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          try
          {
            tryLoadLibraryUsingWorkaround(getApplicationUsingReflection().getApplicationContext(), "DexHelper");
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public static native void a(Class paramClass, int paramInt);
  
  public static void b() {}
  
  private static void deleteDirectorySync(File paramFile)
  {
    try
    {
      File[] arrayOfFile = paramFile.listFiles();
      Object localObject;
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        for (int i = 0; i < j; i++)
        {
          localObject = arrayOfFile[i];
          if (!((File)localObject).delete())
          {
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            Log.e("LibraryLoaderHelper", "Failed to remove " + ((File)localObject).getAbsolutePath());
          }
        }
      }
      if (!paramFile.delete())
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        Log.w("LibraryLoaderHelper", "Failed to remove " + paramFile.getAbsolutePath());
      }
      return;
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        Log.e("LibraryLoaderHelper", "Failed to remove old libs, ", paramFile);
      }
    }
  }
  
  public static Application getApplicationUsingReflection()
    throws Exception
  {
    return (Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null);
  }
  
  private static String getJniNameInApk(String paramString)
  {
    return "lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(paramString);
  }
  
  private static String[] getSupportAbis()
  {
    String[] arrayOfString;
    if ((Build.VERSION.SDK_INT >= 21) && (Build.SUPPORTED_ABIS.length > 0)) {
      arrayOfString = Build.SUPPORTED_ABIS;
    }
    for (;;)
    {
      return arrayOfString;
      if ((Build.CPU_ABI.equals("armeabi")) || (Build.CPU_ABI.equals("armeabi-v7a")))
      {
        arrayOfString = new String[2];
        arrayOfString[0] = "armeabi";
        arrayOfString[1] = "armeabi-v7a";
      }
      else
      {
        arrayOfString = new String[1];
        arrayOfString[0] = Build.CPU_ABI;
      }
    }
  }
  
  public static File getWorkaroundLibDir(Context paramContext)
  {
    return paramContext.getDir("lib", 0);
  }
  
  private static File getWorkaroundLibFile(Context paramContext, String paramString)
  {
    paramString = System.mapLibraryName(paramString);
    return new File(getWorkaroundLibDir(paramContext), paramString);
  }
  
  private static ZipEntry getZipEntry(ZipFile paramZipFile, String paramString)
  {
    String[] arrayOfString = getSupportAbis();
    int j = arrayOfString.length;
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = arrayOfString[i];
      localObject = paramZipFile.getEntry("lib" + File.separatorChar + (String)localObject + File.separatorChar + System.mapLibraryName(paramString));
      if (localObject == null) {}
    }
    for (paramZipFile = (ZipFile)localObject;; paramZipFile = null)
    {
      return paramZipFile;
      i++;
      break;
    }
  }
  
  static boolean tryLoadLibraryUsingWorkaround(Context paramContext, String paramString)
  {
    boolean bool = false;
    assert (paramContext != null);
    File localFile = getWorkaroundLibFile(paramContext, paramString);
    if ((!localFile.exists()) && (!unpackLibrariesOnce(paramContext, paramString))) {}
    for (;;)
    {
      return bool;
      try
      {
        System.load(localFile.getAbsolutePath());
        bool = true;
      }
      catch (UnsatisfiedLinkError paramContext) {}
    }
  }
  
  private static boolean unpackLibrariesOnce(Context paramContext, String paramString)
  {
    boolean bool;
    if (sLibrariesWereUnpacked) {
      bool = false;
    }
    ZipFile localZipFile;
    Object localObject1;
    File localFile2;
    for (;;)
    {
      return bool;
      sLibrariesWereUnpacked = true;
      File localFile1 = getWorkaroundLibDir(paramContext);
      deleteDirectorySync(localFile1);
      try
      {
        localApplicationInfo = paramContext.getApplicationInfo();
        localZipFile = new java/util/zip/ZipFile;
        localObject1 = new java/io/File;
        ((File)localObject1).<init>(localApplicationInfo.sourceDir);
        localZipFile.<init>((File)localObject1, 1);
        localObject1 = getZipEntry(localZipFile, paramString);
        if (localObject1 == null)
        {
          paramContext = new java/lang/StringBuilder;
          paramContext.<init>();
          Log.e("LibraryLoaderHelper", localApplicationInfo.sourceDir + " doesn't have file " + ((ZipEntry)localObject1).getName());
          localZipFile.close();
          deleteDirectorySync(localFile1);
          bool = false;
        }
        else
        {
          localFile2 = getWorkaroundLibFile(paramContext, paramString);
          paramContext = new java/lang/StringBuilder;
          paramContext.<init>();
          Log.i("LibraryLoaderHelper", "Extracting native libraries into " + localFile2.getAbsolutePath());
          if (($assertionsDisabled) || (!localFile2.exists())) {
            break;
          }
          paramContext = new java/lang/AssertionError;
          paramContext.<init>();
          throw paramContext;
        }
      }
      catch (IOException paramContext)
      {
        Log.e("LibraryLoaderHelper", "Failed to unpack native libraries", paramContext);
        deleteDirectorySync(localFile1);
        bool = false;
      }
    }
    try
    {
      if (!localFile2.createNewFile())
      {
        paramContext = new java/io/IOException;
        paramContext.<init>();
        throw paramContext;
      }
    }
    catch (IOException paramContext)
    {
      if ((localFile2.exists()) && (!localFile2.delete()))
      {
        paramString = new java/lang/StringBuilder;
        paramString.<init>();
        Log.e("LibraryLoaderHelper", "Failed to delete " + localFile2.getAbsolutePath());
      }
      localZipFile.close();
      throw paramContext;
    }
    paramContext = null;
    localApplicationInfo = null;
    for (;;)
    {
      try
      {
        paramString = localZipFile.getInputStream((ZipEntry)localObject1);
        paramContext = paramString;
        localFileOutputStream = new java/io/FileOutputStream;
        paramContext = paramString;
        localFileOutputStream.<init>(localFile2);
        try
        {
          paramContext = new byte['䀀'];
          int i = paramString.read(paramContext);
          if (i > 0)
          {
            localFileOutputStream.write(paramContext, 0, i);
            continue;
            if (paramString == null) {}
          }
        }
        finally
        {
          paramContext = localFileOutputStream;
        }
      }
      finally
      {
        FileOutputStream localFileOutputStream;
        paramString = paramContext;
        paramContext = localApplicationInfo;
        continue;
      }
      try
      {
        paramString.close();
        if (paramContext != null) {
          paramContext.close();
        }
        throw ((Throwable)localObject2);
        if (paramString == null) {}
      }
      finally
      {
        paramContext.close();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\andjni\JniLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */