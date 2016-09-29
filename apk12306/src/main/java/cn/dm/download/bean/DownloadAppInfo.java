package cn.dm.download.bean;

import java.io.Serializable;

public class DownloadAppInfo
  implements Serializable
{
  private long O = -1L;
  private String P = "";
  private String Q = "";
  private String R = "";
  private String S = "";
  private long T = 0L;
  private int U;
  private int V;
  private int W;
  private String X;
  private String Y;
  private String Z;
  private String aa;
  private String ab;
  private long p = -1L;
  private int position;
  private int t = 0;
  private int versionCode;
  private String versionName;
  
  public long getAppId()
  {
    return this.O;
  }
  
  public String getAppName()
  {
    return this.P;
  }
  
  public long getAppSize()
  {
    return this.p;
  }
  
  public String getClick_tracker()
  {
    return this.aa;
  }
  
  public long getCurrentDownloadSize()
  {
    return this.T;
  }
  
  public int getDownloadStatus()
  {
    return this.t;
  }
  
  public String getDownloadUrl()
  {
    return this.R;
  }
  
  public int getErrorFlag()
  {
    return this.W;
  }
  
  public int getIsThirdInstalled()
  {
    return this.V;
  }
  
  public int getIsUpdate()
  {
    return this.U;
  }
  
  public String getLogoUrl()
  {
    return this.S;
  }
  
  public String getPkgName()
  {
    return this.Q;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public String getRefer()
  {
    return this.Z;
  }
  
  public String getSid()
  {
    return this.ab;
  }
  
  public String getTr()
  {
    return this.Y;
  }
  
  public String getVendor()
  {
    return this.X;
  }
  
  public int getVersionCode()
  {
    return this.versionCode;
  }
  
  public String getVersionName()
  {
    return this.versionName;
  }
  
  public void setAppId(long paramLong)
  {
    this.O = paramLong;
  }
  
  public void setAppName(String paramString)
  {
    this.P = paramString;
  }
  
  public void setAppSize(long paramLong)
  {
    this.p = paramLong;
  }
  
  public void setClick_tracker(String paramString)
  {
    this.aa = paramString;
  }
  
  public void setCurrentDownloadSize(long paramLong)
  {
    this.T = paramLong;
  }
  
  public void setDownloadStatus(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setDownloadUrl(String paramString)
  {
    this.R = paramString;
  }
  
  public void setErrorFlag(int paramInt)
  {
    this.W = paramInt;
  }
  
  public void setIsThirdInstalled(int paramInt)
  {
    this.V = paramInt;
  }
  
  public void setIsUpdate(int paramInt)
  {
    this.U = paramInt;
  }
  
  public void setLogoUrl(String paramString)
  {
    this.S = paramString;
  }
  
  public void setPkgName(String paramString)
  {
    this.Q = paramString;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void setRefer(String paramString)
  {
    this.Z = paramString;
  }
  
  public void setSid(String paramString)
  {
    this.ab = paramString;
  }
  
  public void setTr(String paramString)
  {
    this.Y = paramString;
  }
  
  public void setVendor(String paramString)
  {
    this.X = paramString;
  }
  
  public void setVersionCode(int paramInt)
  {
    this.versionCode = paramInt;
  }
  
  public void setVersionName(String paramString)
  {
    this.versionName = paramString;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\bean\DownloadAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */