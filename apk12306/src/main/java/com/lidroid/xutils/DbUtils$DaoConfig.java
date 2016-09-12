package com.lidroid.xutils;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class DbUtils$DaoConfig
{
  private Context context;
  private String dbDir;
  private String dbName = "xUtils.db";
  private DbUtils.DbUpgradeListener dbUpgradeListener;
  private int dbVersion = 1;
  
  static
  {
    JniLib.a(DaoConfig.class, 916);
  }
  
  public DbUtils$DaoConfig(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
  }
  
  public native Context getContext();
  
  public native String getDbDir();
  
  public native String getDbName();
  
  public native DbUtils.DbUpgradeListener getDbUpgradeListener();
  
  public native int getDbVersion();
  
  public native void setDbDir(String paramString);
  
  public native void setDbName(String paramString);
  
  public native void setDbUpgradeListener(DbUtils.DbUpgradeListener paramDbUpgradeListener);
  
  public native void setDbVersion(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\DbUtils$DaoConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */