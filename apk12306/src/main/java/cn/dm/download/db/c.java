package cn.dm.download.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.util.b;
import java.util.ArrayList;

public class c
{
  private static b f = new b(c.class.getSimpleName());
  private a av;
  private Context mContext;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
    this.av = a.b(this.mContext);
  }
  
  private boolean b(long paramLong)
  {
    bool2 = false;
    localObject3 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localObject4 = c(Long.valueOf(paramLong));
        localObject1 = localObject4;
        localObject3 = localObject4;
        Object localObject5 = f;
        localObject1 = localObject4;
        localObject3 = localObject4;
        localObject5 = new java/lang/StringBuilder;
        localObject1 = localObject4;
        localObject3 = localObject4;
        ((StringBuilder)localObject5).<init>("crs count and columncount is:");
        localObject1 = localObject4;
        localObject3 = localObject4;
        ((StringBuilder)localObject5).append(((Cursor)localObject4).getCount()).append("  ,").append(((Cursor)localObject4).getColumnCount());
        localObject1 = localObject4;
        localObject3 = localObject4;
        int i = ((Cursor)localObject4).getCount();
        if (i != 0) {
          continue;
        }
        bool1 = bool2;
        if (localObject4 != null)
        {
          ((Cursor)localObject4).close();
          bool1 = bool2;
        }
      }
      catch (Exception localException)
      {
        localObject3 = localObject1;
        Object localObject4 = f;
        localObject3 = localObject1;
        localException.getMessage();
        boolean bool1 = bool2;
        if (localObject1 == null) {
          continue;
        }
        ((Cursor)localObject1).close();
        bool1 = bool2;
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          continue;
        }
        ((Cursor)localObject3).close();
      }
      return bool1;
      if (localObject4 != null) {
        ((Cursor)localObject4).close();
      }
      bool1 = true;
    }
  }
  
  private Cursor c(Long paramLong)
  {
    try
    {
      paramLong = String.valueOf(paramLong);
      paramLong = this.av.a("download_app_tab", null, "_app_id=?", new String[] { paramLong }, null);
      return paramLong;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong = f;
        new StringBuilder("get getDownloadAppInfo failed:").append(localException.getMessage());
        paramLong = null;
      }
    }
  }
  
  private void e(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("_app_id", Long.valueOf(paramDownloadAppInfo.getAppId()));
    ((ContentValues)localObject).put("_app_name", paramDownloadAppInfo.getAppName());
    ((ContentValues)localObject).put("_app_packagename", paramDownloadAppInfo.getPkgName());
    ((ContentValues)localObject).put("_app_download_status", Integer.valueOf(paramDownloadAppInfo.getDownloadStatus()));
    ((ContentValues)localObject).put("_app_size", Long.valueOf(paramDownloadAppInfo.getAppSize()));
    ((ContentValues)localObject).put("_app_download_url", paramDownloadAppInfo.getDownloadUrl());
    ((ContentValues)localObject).put("_app_logo_url", paramDownloadAppInfo.getLogoUrl());
    ((ContentValues)localObject).put("_app_versioncode", Integer.valueOf(paramDownloadAppInfo.getVersionCode()));
    ((ContentValues)localObject).put("_app_isupdate", Integer.valueOf(paramDownloadAppInfo.getIsUpdate()));
    ((ContentValues)localObject).put("_app_tr", paramDownloadAppInfo.getTr());
    ((ContentValues)localObject).put("_app_vender", paramDownloadAppInfo.getVendor());
    ((ContentValues)localObject).put("_app_versionname", paramDownloadAppInfo.getVersionName());
    ((ContentValues)localObject).put("_app_refer", paramDownloadAppInfo.getRefer());
    ((ContentValues)localObject).put("_app_position", Integer.valueOf(paramDownloadAppInfo.getPosition()));
    ((ContentValues)localObject).put("_app_sid", paramDownloadAppInfo.getSid());
    try
    {
      this.av.a("download_app_tab", (ContentValues)localObject);
      localObject = f;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("插入数据，下载状态为：");
      ((StringBuilder)localObject).append(paramDownloadAppInfo.getDownloadStatus()).append("  ,是否真的插入了：").append(b(paramDownloadAppInfo.getAppId()));
      return;
    }
    catch (SQLiteConstraintException localSQLiteConstraintException)
    {
      for (;;)
      {
        b localb = f;
        new StringBuilder("the ").append(paramDownloadAppInfo.getAppId()).append(" is already exist, insert failed");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramDownloadAppInfo = f;
        localException.getMessage();
      }
    }
  }
  
  public final void a(long paramLong)
  {
    try
    {
      Object localObject = this.av;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("_app_id=");
      int i = ((a)localObject).delete("download_app_tab", paramLong, null);
      localObject = f;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("删除数据成功，delete number ");
      ((StringBuilder)localObject).append(i);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b localb = f;
      }
    }
  }
  
  public final void f(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = new ContentValues();
    String str = "_app_id=" + paramDownloadAppInfo.getAppId();
    ((ContentValues)localObject).put("_app_download_status", Integer.valueOf(paramDownloadAppInfo.getDownloadStatus()));
    ((ContentValues)localObject).put("_app_versioncode", Integer.valueOf(paramDownloadAppInfo.getVersionCode()));
    ((ContentValues)localObject).put("_app_isupdate", Integer.valueOf(paramDownloadAppInfo.getIsUpdate()));
    int i = this.av.update("download_app_tab", (ContentValues)localObject, str, null);
    localObject = f;
    new StringBuilder("更新数据库下载状态：").append(paramDownloadAppInfo.getDownloadStatus()).append("  ,appid:").append(paramDownloadAppInfo.getAppId()).append("  ,result:").append(i);
  }
  
  public final void g(DownloadAppInfo paramDownloadAppInfo)
  {
    if (b(paramDownloadAppInfo.getAppId())) {
      f(paramDownloadAppInfo);
    }
    for (;;)
    {
      return;
      Object localObject = new ContentValues();
      ((ContentValues)localObject).put("_app_id", Long.valueOf(paramDownloadAppInfo.getAppId()));
      ((ContentValues)localObject).put("_app_name", paramDownloadAppInfo.getAppName());
      ((ContentValues)localObject).put("_app_packagename", paramDownloadAppInfo.getPkgName());
      ((ContentValues)localObject).put("_app_download_status", Integer.valueOf(paramDownloadAppInfo.getDownloadStatus()));
      ((ContentValues)localObject).put("_app_size", Long.valueOf(paramDownloadAppInfo.getAppSize()));
      ((ContentValues)localObject).put("_app_download_url", paramDownloadAppInfo.getDownloadUrl());
      ((ContentValues)localObject).put("_app_logo_url", paramDownloadAppInfo.getLogoUrl());
      ((ContentValues)localObject).put("_app_versioncode", Integer.valueOf(paramDownloadAppInfo.getVersionCode()));
      ((ContentValues)localObject).put("_app_isupdate", Integer.valueOf(paramDownloadAppInfo.getIsUpdate()));
      ((ContentValues)localObject).put("_app_tr", paramDownloadAppInfo.getTr());
      ((ContentValues)localObject).put("_app_vender", paramDownloadAppInfo.getVendor());
      ((ContentValues)localObject).put("_app_versionname", paramDownloadAppInfo.getVersionName());
      ((ContentValues)localObject).put("_app_refer", paramDownloadAppInfo.getRefer());
      ((ContentValues)localObject).put("_app_position", Integer.valueOf(paramDownloadAppInfo.getPosition()));
      ((ContentValues)localObject).put("_app_sid", paramDownloadAppInfo.getSid());
      try
      {
        this.av.a("download_app_tab", (ContentValues)localObject);
        localObject = f;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("插入数据，下载状态为：");
        ((StringBuilder)localObject).append(paramDownloadAppInfo.getDownloadStatus()).append("  ,是否真的插入了：").append(b(paramDownloadAppInfo.getAppId()));
      }
      catch (SQLiteConstraintException localSQLiteConstraintException)
      {
        localb = f;
        new StringBuilder("the ").append(paramDownloadAppInfo.getAppId()).append(" is already exist, insert failed");
      }
      catch (Exception paramDownloadAppInfo)
      {
        b localb = f;
        paramDownloadAppInfo.getMessage();
      }
    }
  }
  
  public final ArrayList q()
  {
    Cursor localCursor = this.av.a("download_app_tab", null, null, null, null);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if (!localCursor.moveToNext())
      {
        if (localCursor != null) {
          localCursor.close();
        }
        return localArrayList;
      }
      DownloadAppInfo localDownloadAppInfo = new DownloadAppInfo();
      localDownloadAppInfo.setAppId(localCursor.getLong(localCursor.getColumnIndex("_app_id")));
      localDownloadAppInfo.setAppName(localCursor.getString(localCursor.getColumnIndex("_app_name")));
      localDownloadAppInfo.setPkgName(localCursor.getString(localCursor.getColumnIndex("_app_packagename")));
      localDownloadAppInfo.setDownloadStatus(localCursor.getInt(localCursor.getColumnIndex("_app_download_status")));
      localDownloadAppInfo.setAppSize(localCursor.getLong(localCursor.getColumnIndex("_app_size")));
      localDownloadAppInfo.setDownloadUrl(localCursor.getString(localCursor.getColumnIndex("_app_download_url")));
      localDownloadAppInfo.setLogoUrl(localCursor.getString(localCursor.getColumnIndex("_app_logo_url")));
      localDownloadAppInfo.setVersionCode(localCursor.getInt(localCursor.getColumnIndex("_app_versioncode")));
      localDownloadAppInfo.setIsUpdate(localCursor.getInt(localCursor.getColumnIndex("_app_isupdate")));
      localDownloadAppInfo.setTr(localCursor.getString(localCursor.getColumnIndex("_app_tr")));
      localDownloadAppInfo.setVendor(localCursor.getString(localCursor.getColumnIndex("_app_vender")));
      localDownloadAppInfo.setVersionName(localCursor.getString(localCursor.getColumnIndex("_app_versionname")));
      localDownloadAppInfo.setPosition(localCursor.getInt(localCursor.getColumnIndex("_app_position")));
      localDownloadAppInfo.setRefer(localCursor.getString(localCursor.getColumnIndex("_app_refer")));
      localDownloadAppInfo.setSid(localCursor.getString(localCursor.getColumnIndex("_app_sid")));
      localArrayList.add(localDownloadAppInfo);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\db\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */