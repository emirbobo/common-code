package com.bontai.mobiads.ads.entity;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;
import java.io.Serializable;

@Table(name="adDomain")
public class AdDomain
  extends EntityBase
  implements Serializable
{
  private static final long serialVersionUID = -1862909093195378975L;
  @Column(column="adCompany")
  private String adCompany;
  @Column(column="adId")
  private String adId;
  @Column(column="adName")
  private String adName;
  @Column(column="clickUrl")
  private String clickUrl;
  @Column(column="ext1")
  private String ext1;
  @Column(column="ext2")
  private String ext2;
  @Column(column="ext3")
  private String ext3;
  @Column(column="ext4")
  private String ext4;
  @Column(column="ext5")
  private String ext5;
  @Column(column="ext6")
  private String ext6;
  @Column(column="imgDiskUrl")
  private String imgDiskUrl;
  @Column(column="imgUrl")
  private String imgUrl;
  @Column(column="marginBottom")
  private String marginBottom;
  @Column(column="serviceType")
  private String serviceType;
  @Column(column="serviceUrl")
  private String serviceUrl;
  @Column(column="showSkipBtn")
  private String showSkipBtn;
  @Column(column="skipTime")
  private String skipTime;
  @Column(column="targetImgUrl")
  private String targetImgUrl;
  @Column(column="targetUrl")
  private String targetUrl;
  @Column(column="thirdClickUrls")
  private String thirdClickUrls;
  @Column(column="thirdViewUrls")
  private String thirdViewUrls;
  @Column(column="viewUrl")
  private String viewUrl;
  
  static
  {
    JniLib.a(AdDomain.class, 198);
  }
  
  public native String getAdCompany();
  
  public native String getAdId();
  
  public native String getAdName();
  
  public native String getClickUrl();
  
  public native String getExt1();
  
  public native String getExt2();
  
  public native String getExt3();
  
  public native String getExt4();
  
  public native String getExt5();
  
  public native String getExt6();
  
  public native String getImgDiskUrl();
  
  public native String getImgUrl();
  
  public native String getMarginBottom();
  
  public native String getServiceType();
  
  public native String getServiceUrl();
  
  public native String getShowSkipBtn();
  
  public native String getSkipTime();
  
  public native String getTargetImgUrl();
  
  public native String getTargetUrl();
  
  public native String getThirdClickUrls();
  
  public native String getThirdViewUrls();
  
  public native String getViewUrl();
  
  public native void setAdCompany(String paramString);
  
  public native void setAdId(String paramString);
  
  public native void setAdName(String paramString);
  
  public native void setClickUrl(String paramString);
  
  public native void setExt1(String paramString);
  
  public native void setExt2(String paramString);
  
  public native void setExt3(String paramString);
  
  public native void setExt4(String paramString);
  
  public native void setExt5(String paramString);
  
  public native void setExt6(String paramString);
  
  public native void setImgDiskUrl(String paramString);
  
  public native void setImgUrl(String paramString);
  
  public native void setMarginBottom(String paramString);
  
  public native void setServiceType(String paramString);
  
  public native void setServiceUrl(String paramString);
  
  public native void setShowSkipBtn(String paramString);
  
  public native void setSkipTime(String paramString);
  
  public native void setTargetImgUrl(String paramString);
  
  public native void setTargetUrl(String paramString);
  
  public native void setThirdClickUrls(String paramString);
  
  public native void setThirdViewUrls(String paramString);
  
  public native void setViewUrl(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\entity\AdDomain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */