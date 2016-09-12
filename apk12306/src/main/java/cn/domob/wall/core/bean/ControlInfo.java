package cn.domob.wall.core.bean;

import cn.domob.wall.core.h.d;
import org.json.JSONObject;

public class ControlInfo
{
  private static final boolean r = Boolean.FALSE.booleanValue();
  private static final boolean s = Boolean.TRUE.booleanValue();
  private static final boolean t = Boolean.TRUE.booleanValue();
  private static final boolean u = Boolean.FALSE.booleanValue();
  private static final boolean v = Boolean.TRUE.booleanValue();
  d a = new d(ControlInfo.class.getSimpleName());
  private String b;
  private int c = 5;
  private int d = 15;
  private int e = 1;
  private int f = 0;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private long p;
  private boolean q;
  
  public ControlInfo() {}
  
  public ControlInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    try
    {
      this.g = paramJSONObject.optBoolean("ent_pic", r);
      if (Boolean.valueOf(this.g).booleanValue()) {
        this.b = paramJSONObject.optString("pic_url", "");
      }
      this.h = paramJSONObject.optBoolean("new_rem", s);
      this.c = paramJSONObject.optInt("top_tim", this.c);
      this.i = paramJSONObject.optBoolean("dbut_show", t);
      this.d = paramJSONObject.optInt("show_num", this.d);
      this.e = paramJSONObject.optInt("ad_order", this.e);
      this.j = paramJSONObject.optBoolean("app_classify", u);
      this.k = paramJSONObject.optBoolean("ishavebanner", v);
      this.m = paramJSONObject.optBoolean("showOpen", Boolean.FALSE.booleanValue());
      this.l = paramJSONObject.optBoolean("showUpdate", Boolean.FALSE.booleanValue());
      this.n = paramJSONObject.optBoolean("showNew", Boolean.TRUE.booleanValue());
      this.o = paramJSONObject.optBoolean("showSearchEntry", Boolean.FALSE.booleanValue());
      this.p = paramJSONObject.optLong("timeout", 86400000L);
      this.q = paramJSONObject.optBoolean("showEWallEntry", Boolean.FALSE.booleanValue());
      d locald = this.a;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      locald.b("controlJsonObject: " + toString());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.a.e("Error happens when decoding controlJsonObject: " + paramJSONObject.toString());
        this.a.a(localException);
      }
    }
  }
  
  public a getAdOrder()
  {
    a locala;
    if (this.e == 1) {
      locala = a.a;
    }
    for (;;)
    {
      return locala;
      if (this.e == 2) {
        locala = a.b;
      } else if (this.e == 3) {
        locala = a.c;
      } else {
        locala = a.a;
      }
    }
  }
  
  public int getBannerIntervalTime()
  {
    return this.c;
  }
  
  public String getEnterPicURL()
  {
    return this.b;
  }
  
  public int getNumberOfNewAd()
  {
    return this.f;
  }
  
  public int getShowAdNum()
  {
    return this.d;
  }
  
  public long getTimeout()
  {
    return this.p;
  }
  
  public boolean isButtonShow()
  {
    return this.i;
  }
  
  public boolean isChangeEnterPic()
  {
    return this.g;
  }
  
  public boolean isClassify()
  {
    return this.j;
  }
  
  public boolean isHasBanner()
  {
    return this.k;
  }
  
  public boolean isShowEWallEntrance()
  {
    return this.q;
  }
  
  public boolean isShowNew()
  {
    return this.n;
  }
  
  public boolean isShowNewReminder()
  {
    return this.h;
  }
  
  public boolean isShowOpen()
  {
    return this.m;
  }
  
  public boolean isShowSearchEntrance()
  {
    return this.o;
  }
  
  public boolean isShowUpdate()
  {
    return this.l;
  }
  
  public void setNumberOfNewAd(int paramInt)
  {
    this.f = paramInt;
  }
  
  public String toString()
  {
    return "ControlInfo [mLogger=" + this.a + ", mPicURL=" + this.b + ", bannerIntervalTime=" + this.c + ", mShowNum=" + this.d + ", mOrder=" + this.e + ", numberOfNewAd=" + this.f + ", mChangePic=" + this.g + ", mNewReminder=" + this.h + ", mRightButShow=" + this.i + ", mClassify=" + this.j + ", mIshaveBanner=" + this.k + ", mShowUpdate=" + this.l + ", mShowOpen=" + this.m + ", mShowNew=" + this.n + ", mShowSearchEntrance=" + this.o + ", mTimeout=" + this.p + "]";
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\bean\ControlInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */