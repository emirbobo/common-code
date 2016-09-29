package cn.dbox.core.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;

public class j
{
  private static final String a = "DrwCach";
  private static final String b = ".cach";
  private static final int c = 1048576;
  private static final int d = 10;
  private static final int e = 10;
  
  public j()
  {
    c(b());
  }
  
  private int a()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    return (int)(localStatFs.getAvailableBlocks() * localStatFs.getBlockSize() / 1048576.0D);
  }
  
  private String b()
  {
    return c() + "/" + "DrwCach";
  }
  
  private String c()
  {
    Object localObject = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localObject = Environment.getExternalStorageDirectory();
    }
    if (localObject != null) {}
    for (localObject = ((File)localObject).toString();; localObject = "") {
      return (String)localObject;
    }
  }
  
  private boolean c(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString).listFiles();
    boolean bool1;
    if (paramString == null) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        int i = 0;
        int j;
        for (int k = 0; i < paramString.length; k = j)
        {
          j = k;
          if (paramString[i].getName().contains(".cach")) {
            j = (int)(k + paramString[i].length());
          }
          i++;
        }
        if ((k > 10485760) || (10 > a()))
        {
          j = (int)(0.4D * paramString.length + 1.0D);
          Arrays.sort(paramString, new a(null));
          for (i = 0; i < j; i++) {
            if (paramString[i].getName().contains(".cach")) {
              paramString[i].delete();
            }
          }
        }
        bool1 = bool2;
        if (a() > 10) {
          bool1 = true;
        }
      }
    }
  }
  
  private String d(String paramString)
  {
    paramString = paramString.split("/");
    return paramString[(paramString.length - 1)] + ".cach";
  }
  
  public Bitmap a(String paramString)
  {
    String str = b() + "/" + d(paramString);
    File localFile = new File(str);
    if (localFile.exists())
    {
      paramString = BitmapFactory.decodeFile(str);
      if (paramString == null) {
        localFile.delete();
      }
    }
    else
    {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      b(str);
    }
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {}
    for (;;)
    {
      return;
      if (10 <= a())
      {
        String str = d(paramString);
        paramString = b();
        Object localObject = new File(paramString);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        paramString = new File(paramString + "/" + str);
        try
        {
          paramString.createNewFile();
          localObject = new java/io/FileOutputStream;
          ((FileOutputStream)localObject).<init>(paramString);
          paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
          ((OutputStream)localObject).flush();
          ((OutputStream)localObject).close();
        }
        catch (FileNotFoundException paramBitmap)
        {
          Log.w("ImageFileCache", "FileNotFoundException");
        }
        catch (IOException paramBitmap)
        {
          Log.w("ImageFileCache", "IOException");
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    new File(paramString).setLastModified(System.currentTimeMillis());
  }
  
  private class a
    implements Comparator<File>
  {
    private a() {}
    
    public int a(File paramFile1, File paramFile2)
    {
      int i;
      if (paramFile1.lastModified() > paramFile2.lastModified()) {
        i = 1;
      }
      for (;;)
      {
        return i;
        if (paramFile1.lastModified() == paramFile2.lastModified()) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */