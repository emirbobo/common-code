package cn.domob.wall.core.bean;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cn.domob.wall.core.h.d;
import cn.domob.wall.core.h.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AdInfo> CREATOR = new Parcelable.Creator()
  {
    public AdInfo a(Parcel paramAnonymousParcel)
    {
      AdInfo localAdInfo = new AdInfo();
      AdInfo.a(localAdInfo, paramAnonymousParcel.readInt());
      AdInfo.b(localAdInfo, paramAnonymousParcel.readInt());
      AdInfo.c(localAdInfo, paramAnonymousParcel.readInt());
      AdInfo.d(localAdInfo, paramAnonymousParcel.readInt());
      AdInfo.e(localAdInfo, paramAnonymousParcel.readInt());
      AdInfo.f(localAdInfo, paramAnonymousParcel.readInt());
      localAdInfo.b = paramAnonymousParcel.readInt();
      AdInfo.a(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.b(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.c(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.d(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.e(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.f(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.g(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.h(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.i(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.j(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.k(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.l(localAdInfo, paramAnonymousParcel.readString());
      localAdInfo.c = paramAnonymousParcel.readString();
      AdInfo.m(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.n(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.o(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.p(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.q(localAdInfo, paramAnonymousParcel.readString());
      AdInfo.a(localAdInfo, paramAnonymousParcel.readLong());
      AdInfo.a(localAdInfo, paramAnonymousParcel.readArrayList(getClass().getClassLoader()));
      return localAdInfo;
    }
    
    public AdInfo[] a(int paramAnonymousInt)
    {
      return new AdInfo[paramAnonymousInt];
    }
  };
  protected static final int a = -1;
  private static d d = new d(AdInfo.class.getSimpleName());
  private String A = "true";
  private String B;
  private ControlInfo C;
  private List<String> D = new ArrayList();
  protected int b;
  protected String c;
  private int e;
  private int f;
  private int g = -1;
  private int h;
  private int i;
  private int j;
  private long k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private String y;
  private String z = "false";
  
  public AdInfo() {}
  
  public AdInfo(long paramLong, JSONObject paramJSONObject, String paramString1, String paramString2, ControlInfo paramControlInfo)
  {
    if (paramJSONObject != null)
    {
      this.C = paramControlInfo;
      this.l = paramString1;
      this.m = paramJSONObject.optString("id");
      this.e = paramJSONObject.optInt("type", 0);
      this.f = paramJSONObject.optInt("pos");
      this.n = paramJSONObject.optString("logo");
      this.o = paramJSONObject.optString("image");
      this.p = paramJSONObject.optString("name");
      this.q = paramJSONObject.optString("title");
      this.r = paramJSONObject.optString("texts");
      this.s = paramJSONObject.optString("provider");
      this.t = paramJSONObject.optString("desc");
      this.j = paramJSONObject.optInt("app_category");
      this.y = paramString2;
      try
      {
        paramString1 = new org/json/JSONArray;
        paramString1.<init>(paramJSONObject.getString("screenshot"));
        if (paramString1 != null)
        {
          i1 = 0;
          if (i1 >= paramString1.length()) {
            break label265;
          }
        }
      }
      catch (JSONException paramString1)
      {
        try
        {
          for (;;)
          {
            int i1;
            this.D.add(paramString1.getString(i1));
            i1++;
          }
          paramString1 = paramString1;
          d.b(paramString1.toString());
          paramString1 = null;
        }
        catch (JSONException paramString2)
        {
          for (;;)
          {
            d.a(paramString2);
          }
        }
        d.d("Screenshot of the page with details of the ad is empty");
        label265:
        this.u = paramJSONObject.optString("identifier");
        this.i = paramJSONObject.optInt("vc");
        this.v = paramJSONObject.optString("vn");
        this.c = paramJSONObject.optString("action_url");
        this.w = paramJSONObject.optString("click_tracker");
        this.B = paramJSONObject.optString("thumbnail");
        this.h = paramJSONObject.optInt("size");
        this.k = paramJSONObject.optLong("release_time");
        d.b("上次请求时间：" + paramLong + "广告上线时间：" + this.k);
        if (paramLong != 0L) {}
      }
    }
    for (this.z = Boolean.toString(Boolean.TRUE.booleanValue());; this.z = Boolean.toString(bool))
    {
      this.b = paramJSONObject.optInt("action_type");
      this.x = paramJSONObject.optString("tr");
      this.A = Boolean.toString(paramJSONObject.optBoolean("showd", Boolean.valueOf(this.A).booleanValue()));
      return;
      if (this.k > paramLong) {
        bool = true;
      }
    }
  }
  
  public AdInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    this.m = paramString1;
    this.u = paramString2;
    this.i = paramInt;
    this.v = paramString3;
    this.x = paramString4;
    this.l = paramString5;
  }
  
  protected String a()
  {
    return this.B;
  }
  
  protected long b()
  {
    return this.k;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ClickActionType getAdActionType()
  {
    ClickActionType localClickActionType;
    if (this.b == 1) {
      localClickActionType = ClickActionType.DOWNLOAD;
    }
    for (;;)
    {
      return localClickActionType;
      if (this.b == 2) {
        localClickActionType = ClickActionType.INTERNAL_BROWSER;
      } else if (this.b == 3) {
        localClickActionType = ClickActionType.EXTERNAL_BROWSER;
      } else if (this.b == 4) {
        localClickActionType = ClickActionType.LAUNCH;
      } else if (this.b == 5) {
        localClickActionType = ClickActionType.UPDATE;
      } else {
        localClickActionType = ClickActionType.NONE;
      }
    }
  }
  
  public String getAdActionURL()
  {
    return this.c;
  }
  
  public int getAdActualPosition()
  {
    return this.g;
  }
  
  public String getAdBannerImageURL()
  {
    return this.o;
  }
  
  public String getAdBriefText()
  {
    return this.r;
  }
  
  public int getAdCategory()
  {
    return this.j;
  }
  
  public String getAdDetailDescription()
  {
    return this.t;
  }
  
  public String getAdDownloadURL()
  {
    return Uri.parse(this.c).getQueryParameter("url");
  }
  
  public String getAdId()
  {
    return this.m;
  }
  
  public String getAdLogoURL()
  {
    return this.n;
  }
  
  public String getAdName()
  {
    return this.p;
  }
  
  public String getAdPackageName()
  {
    return this.u;
  }
  
  public int getAdPosition()
  {
    return this.f;
  }
  
  public String getAdProvider()
  {
    return this.s;
  }
  
  public int getAdSize()
  {
    return this.h;
  }
  
  public AdStyle getAdStyle()
  {
    AdStyle localAdStyle;
    if (this.y != null) {
      if (this.y.equals(f.a())) {
        localAdStyle = AdStyle.XX;
      }
    }
    for (;;)
    {
      return localAdStyle;
      if (this.y.equals("own")) {
        localAdStyle = AdStyle.HOUSE_AD;
      } else if (this.y.equals("wheel")) {
        localAdStyle = AdStyle.BANNER;
      } else {
        localAdStyle = AdStyle.NONE;
      }
    }
  }
  
  public String getAdTitle()
  {
    return this.q;
  }
  
  public String getAdTracker()
  {
    return this.x;
  }
  
  public AdType getAdType()
  {
    AdType localAdType;
    if (this.e == 1) {
      localAdType = AdType.GAME;
    }
    for (;;)
    {
      return localAdType;
      if (this.e == 2) {
        localAdType = AdType.APPLICATION;
      } else {
        localAdType = AdType.NONE;
      }
    }
  }
  
  public int getAdVersionCode()
  {
    return this.i;
  }
  
  public String getAdVersionName()
  {
    return this.v;
  }
  
  public String getClickTrackerUrl()
  {
    return this.w;
  }
  
  public List<String> getScreenshot()
  {
    return this.D;
  }
  
  public String getSearchId()
  {
    return this.l;
  }
  
  public boolean isAdActualPositionAvailable()
  {
    if (this.g != -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isDownloadAd()
  {
    return Boolean.valueOf(this.A).booleanValue();
  }
  
  public boolean isNew()
  {
    if ((this.C != null) && (!this.C.isShowNew())) {
      this.z = Boolean.toString(false);
    }
    return Boolean.valueOf(this.z).booleanValue();
  }
  
  public boolean isShowDetail()
  {
    return Boolean.valueOf(this.A).booleanValue();
  }
  
  public void setAdActionURL(String paramString)
  {
    this.c = paramString;
  }
  
  public void setAdActualPosition(int paramInt)
  {
    this.g = (paramInt + 1);
  }
  
  public void setClickActionType(int paramInt)
  {
    this.b = paramInt;
  }
  
  public String toString()
  {
    return "AdInfo [mType=" + this.e + ", mPosition=" + this.f + ", mActualPosition=" + this.g + ", mSize=" + this.h + ", mVersionCode=" + this.i + ", mActionType=" + this.b + ", mSearchId=" + this.l + ", mId=" + this.m + ", mLogoURL=" + this.n + ", mBannnerImage=" + this.o + ", mName=" + this.p + ", mTitle=" + this.q + ", mText=" + this.r + ", mProvider=" + this.s + ", mDescription=" + this.t + ", mPackageName=" + this.u + ", mVersionName=" + this.v + ", mClickTrackerUrl=" + this.w + ", mActionURL=" + this.c + ", mTracker=" + this.x + ", mStyle=" + this.y + ", isNew=" + this.z + ", isShowDetail=" + this.A + ", mReleaseTime=" + this.k + ", mThumbnail=" + this.B + ", mAdCategory=" + this.j + ", mScreenshot=" + this.D + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeString(this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeString(this.v);
    paramParcel.writeString(this.w);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.x);
    paramParcel.writeString(this.y);
    paramParcel.writeString(this.z);
    paramParcel.writeString(this.A);
    paramParcel.writeString(this.B);
    paramParcel.writeLong(this.k);
    paramParcel.writeList(this.D);
  }
  
  public static enum AdStyle
  {
    private AdStyle() {}
  }
  
  public static enum AdType
  {
    static
    {
      GAME = new AdType("GAME", 1);
    }
    
    private AdType() {}
  }
  
  public static enum ClickActionType
  {
    static
    {
      DOWNLOAD = new ClickActionType("DOWNLOAD", 1);
      INTERNAL_BROWSER = new ClickActionType("INTERNAL_BROWSER", 2);
      EXTERNAL_BROWSER = new ClickActionType("EXTERNAL_BROWSER", 3);
      LAUNCH = new ClickActionType("LAUNCH", 4);
      UPDATE = new ClickActionType("UPDATE", 5);
    }
    
    private ClickActionType() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\bean\AdInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */