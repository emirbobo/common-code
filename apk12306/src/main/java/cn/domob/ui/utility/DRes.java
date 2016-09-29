package cn.domob.ui.utility;

import android.content.Context;
import android.util.Log;
import cn.domob.ui.main.Logger;
import java.lang.reflect.Field;

public class DRes
{
  private static Class<?> AnimD;
  private static Class<?> ArrayD = null;
  private static Class<?> ColorD;
  private static Class<?> DrawableD;
  private static Class<?> IdD;
  private static Class<?> LayoutD;
  private static Class<?> StringD;
  private static Class<?> StyleD;
  private static final String logTag;
  private static DRes mGetRes;
  private static Logger mLogger = new Logger(DRes.class.getSimpleName());
  private Context mContext;
  
  static
  {
    logTag = DRes.class.getName();
    IdD = null;
    DrawableD = null;
    LayoutD = null;
    AnimD = null;
    StyleD = null;
    StringD = null;
    ColorD = null;
  }
  
  private DRes(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    try
    {
      paramContext = new java/lang/StringBuilder;
      paramContext.<init>();
      DrawableD = Class.forName(this.mContext.getPackageName() + ".R$drawable");
    }
    catch (ClassNotFoundException paramContext)
    {
      try
      {
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>();
        LayoutD = Class.forName(this.mContext.getPackageName() + ".R$layout");
      }
      catch (ClassNotFoundException paramContext)
      {
        try
        {
          paramContext = new java/lang/StringBuilder;
          paramContext.<init>();
          IdD = Class.forName(this.mContext.getPackageName() + ".R$id");
        }
        catch (ClassNotFoundException paramContext)
        {
          try
          {
            paramContext = new java/lang/StringBuilder;
            paramContext.<init>();
            AnimD = Class.forName(this.mContext.getPackageName() + ".R$anim");
          }
          catch (ClassNotFoundException paramContext)
          {
            try
            {
              paramContext = new java/lang/StringBuilder;
              paramContext.<init>();
              StyleD = Class.forName(this.mContext.getPackageName() + ".R$style");
            }
            catch (ClassNotFoundException paramContext)
            {
              try
              {
                paramContext = new java/lang/StringBuilder;
                paramContext.<init>();
                StringD = Class.forName(this.mContext.getPackageName() + ".R$string");
              }
              catch (ClassNotFoundException paramContext)
              {
                try
                {
                  paramContext = new java/lang/StringBuilder;
                  paramContext.<init>();
                  ColorD = Class.forName(this.mContext.getPackageName() + ".R$color");
                }
                catch (ClassNotFoundException paramContext)
                {
                  try
                  {
                    for (;;)
                    {
                      paramContext = new java/lang/StringBuilder;
                      paramContext.<init>();
                      ArrayD = Class.forName(this.mContext.getPackageName() + ".R$array");
                      return;
                      paramContext = paramContext;
                      mLogger.errorLog(logTag, paramContext.getMessage());
                      continue;
                      paramContext = paramContext;
                      mLogger.errorLog(logTag, paramContext.getMessage());
                      continue;
                      paramContext = paramContext;
                      mLogger.errorLog(logTag, paramContext.getMessage());
                      continue;
                      paramContext = paramContext;
                      mLogger.errorLog(logTag, paramContext.getMessage());
                      continue;
                      paramContext = paramContext;
                      mLogger.errorLog(logTag, paramContext.getMessage());
                      continue;
                      paramContext = paramContext;
                      mLogger.errorLog(logTag, paramContext.getMessage());
                      continue;
                      paramContext = paramContext;
                      mLogger.errorLog(logTag, paramContext.getMessage());
                    }
                  }
                  catch (ClassNotFoundException paramContext)
                  {
                    for (;;)
                    {
                      mLogger.errorLog(logTag, paramContext.getMessage());
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private int getInt(Class<?> paramClass, String paramString)
  {
    if (paramClass == null)
    {
      mLogger.errorLog(logTag, "getRes(null," + paramString + ")");
      throw new IllegalArgumentException("ResClass is not initialized. Please make sure you have added neccessary resources. Also make sure you have " + this.mContext.getPackageName() + ".R$* configured in obfuscation. field=" + paramString);
    }
    try
    {
      i = paramClass.getField(paramString).getInt(paramString);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(logTag, "getRes(" + paramClass.getName() + ", " + paramString + ")");
        Log.e(logTag, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
        mLogger.errorLog(logTag, localException.getMessage());
        int i = -1;
      }
    }
  }
  
  public static DRes initGetRes(Context paramContext)
  {
    if (mGetRes == null) {
      mGetRes = new DRes(paramContext);
    }
    return mGetRes;
  }
  
  public int getAnim(String paramString)
  {
    return getInt(AnimD, paramString);
  }
  
  public int getArray(String paramString)
  {
    return getInt(ArrayD, paramString);
  }
  
  public int getColor(String paramString)
  {
    return getInt(ColorD, paramString);
  }
  
  public int getDrawable(String paramString)
  {
    return getInt(DrawableD, paramString);
  }
  
  public int getId(String paramString)
  {
    return getInt(IdD, paramString);
  }
  
  public int getLayout(String paramString)
  {
    return getInt(LayoutD, paramString);
  }
  
  public int getString(String paramString)
  {
    return getInt(StringD, paramString);
  }
  
  public int getStyle(String paramString)
  {
    return getInt(StyleD, paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\utility\DRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */