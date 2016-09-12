package com.ta.utdid2.core.persistent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.bangcle.andjni.JniLib;
import com.ta.utdid2.android.utils.StringUtils;
import java.io.File;
import java.util.Map;

public class PersistentConfiguration
{
  private static final String KEY_TIMESTAMP = "t";
  private static final String KEY_TIMESTAMP2 = "t2";
  private boolean mCanRead = false;
  private boolean mCanWrite = false;
  private String mConfigName = "";
  private Context mContext = null;
  private SharedPreferences.Editor mEditor = null;
  private String mFolderName = "";
  private boolean mIsLessMode = false;
  private boolean mIsSafety = false;
  private MySharedPreferences.MyEditor mMyEditor = null;
  private MySharedPreferences mMySP = null;
  private SharedPreferences mSp = null;
  private TransactionXMLFile mTxf = null;
  
  static
  {
    JniLib.a(PersistentConfiguration.class, 1068);
  }
  
  public PersistentConfiguration(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mIsSafety = paramBoolean1;
    this.mIsLessMode = paramBoolean2;
    this.mConfigName = paramString2;
    this.mFolderName = paramString1;
    this.mContext = paramContext;
    long l2 = 0L;
    long l4 = 0L;
    if (paramContext != null)
    {
      this.mSp = paramContext.getSharedPreferences(paramString2, 0);
      l2 = this.mSp.getLong("t", 0L);
    }
    String str = Environment.getExternalStorageState();
    if (StringUtils.isEmpty(str))
    {
      this.mCanWrite = false;
      this.mCanRead = false;
    }
    for (;;)
    {
      long l1;
      long l3;
      if (!this.mCanRead)
      {
        l1 = l4;
        l3 = l2;
        if (!this.mCanWrite) {}
      }
      else
      {
        l1 = l4;
        l3 = l2;
        if (paramContext != null)
        {
          l1 = l4;
          l3 = l2;
          if (!StringUtils.isEmpty(paramString1))
          {
            this.mTxf = getTransactionXMLFile(paramString1);
            l1 = l4;
            l3 = l2;
            if (this.mTxf != null)
            {
              l1 = l4;
              l3 = l2;
            }
          }
        }
      }
      try
      {
        this.mMySP = this.mTxf.getMySharedPreferences(paramString2, 0);
        l1 = l4;
        l3 = l2;
        l4 = this.mMySP.getLong("t", 0L);
        if (!paramBoolean2) {
          if (l2 > l4)
          {
            l1 = l4;
            l3 = l2;
            copySPToMySP(this.mSp, this.mMySP);
            l1 = l4;
            l3 = l2;
            this.mMySP = this.mTxf.getMySharedPreferences(paramString2, 0);
            l3 = l2;
            l1 = l4;
            if ((l3 != l1) || ((l3 == 0L) && (l1 == 0L)))
            {
              l2 = System.currentTimeMillis();
              if ((!this.mIsLessMode) || ((this.mIsLessMode) && (l3 == 0L) && (l1 == 0L))) {
                if (this.mSp != null)
                {
                  paramContext = this.mSp.edit();
                  paramContext.putLong("t2", l2);
                  paramContext.commit();
                }
              }
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        try
        {
          label946:
          do
          {
            for (;;)
            {
              if (this.mMySP != null)
              {
                paramContext = this.mMySP.edit();
                paramContext.putLong("t2", l2);
                paramContext.commit();
              }
              return;
              if (str.equals("mounted"))
              {
                this.mCanWrite = true;
                this.mCanRead = true;
                break;
              }
              if (str.equals("mounted_ro"))
              {
                this.mCanRead = true;
                this.mCanWrite = false;
                break;
              }
              this.mCanWrite = false;
              this.mCanRead = false;
              break;
              if (l2 < l4)
              {
                l1 = l4;
                l3 = l2;
                copyMySPToSP(this.mMySP, this.mSp);
                l1 = l4;
                l3 = l2;
                this.mSp = paramContext.getSharedPreferences(paramString2, 0);
                l1 = l4;
                l3 = l2;
                continue;
                paramContext = paramContext;
              }
              else
              {
                l1 = l4;
                l3 = l2;
                if (l2 == l4)
                {
                  l1 = l4;
                  l3 = l2;
                  copySPToMySP(this.mSp, this.mMySP);
                  l1 = l4;
                  l3 = l2;
                  this.mMySP = this.mTxf.getMySharedPreferences(paramString2, 0);
                  l1 = l4;
                  l3 = l2;
                  continue;
                  l1 = l4;
                  l3 = l2;
                  l2 = this.mSp.getLong("t2", 0L);
                  l1 = l4;
                  l3 = l2;
                  l4 = this.mMySP.getLong("t2", 0L);
                  if ((l2 < l4) && (l2 > 0L))
                  {
                    l1 = l4;
                    l3 = l2;
                    copySPToMySP(this.mSp, this.mMySP);
                    l1 = l4;
                    l3 = l2;
                    this.mMySP = this.mTxf.getMySharedPreferences(paramString2, 0);
                    l1 = l4;
                    l3 = l2;
                  }
                  else if ((l2 > l4) && (l4 > 0L))
                  {
                    l1 = l4;
                    l3 = l2;
                    copyMySPToSP(this.mMySP, this.mSp);
                    l1 = l4;
                    l3 = l2;
                    this.mSp = paramContext.getSharedPreferences(paramString2, 0);
                    l1 = l4;
                    l3 = l2;
                  }
                  else if ((l2 == 0L) && (l4 > 0L))
                  {
                    l1 = l4;
                    l3 = l2;
                    copyMySPToSP(this.mMySP, this.mSp);
                    l1 = l4;
                    l3 = l2;
                    this.mSp = paramContext.getSharedPreferences(paramString2, 0);
                    l1 = l4;
                    l3 = l2;
                  }
                  else
                  {
                    if ((l4 != 0L) || (l2 <= 0L)) {
                      break label946;
                    }
                    l1 = l4;
                    l3 = l2;
                    copySPToMySP(this.mSp, this.mMySP);
                    l1 = l4;
                    l3 = l2;
                    this.mMySP = this.mTxf.getMySharedPreferences(paramString2, 0);
                    l1 = l4;
                    l3 = l2;
                  }
                }
              }
            }
            l1 = l4;
            l3 = l2;
          } while (l2 != l4);
          l1 = l4;
          l3 = l2;
          copySPToMySP(this.mSp, this.mMySP);
          l1 = l4;
          l3 = l2;
          this.mMySP = this.mTxf.getMySharedPreferences(paramString2, 0);
          l1 = l4;
          l3 = l2;
        }
        catch (Exception paramContext)
        {
          for (;;) {}
        }
      }
    }
  }
  
  private native boolean checkSDCardXMLFile();
  
  private native void copyMySPToSP(MySharedPreferences paramMySharedPreferences, SharedPreferences paramSharedPreferences);
  
  private native void copySPToMySP(SharedPreferences paramSharedPreferences, MySharedPreferences paramMySharedPreferences);
  
  private native File getRootFolder(String paramString);
  
  private native TransactionXMLFile getTransactionXMLFile(String paramString);
  
  private native void initEditor();
  
  public native void clear();
  
  public native boolean commit();
  
  public native Map<String, ?> getAll();
  
  public native boolean getBoolean(String paramString);
  
  public native float getFloat(String paramString);
  
  public native int getInt(String paramString);
  
  public native long getLong(String paramString);
  
  public native String getString(String paramString);
  
  public native void putBoolean(String paramString, boolean paramBoolean);
  
  public native void putFloat(String paramString, float paramFloat);
  
  public native void putInt(String paramString, int paramInt);
  
  public native void putLong(String paramString, long paramLong);
  
  public native void putString(String paramString1, String paramString2);
  
  public native void reload();
  
  public native void remove(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\core\persistent\PersistentConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */