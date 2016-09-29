package cn.dbox.core.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cn.dbox.core.h.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements Parcelable
{
  public static final Parcelable.Creator<a> a = new Parcelable.Creator()
  {
    public a a(Parcel paramAnonymousParcel)
    {
      a locala = new a();
      a.a(locala, paramAnonymousParcel.readString());
      a.b(locala, paramAnonymousParcel.readString());
      a.c(locala, paramAnonymousParcel.readString());
      a.d(locala, paramAnonymousParcel.readString());
      a.e(locala, paramAnonymousParcel.readString());
      a.f(locala, paramAnonymousParcel.readString());
      a.g(locala, paramAnonymousParcel.readString());
      a.h(locala, paramAnonymousParcel.readString());
      a.i(locala, paramAnonymousParcel.readString());
      a.a(locala, paramAnonymousParcel.readArrayList(getClass().getClassLoader()));
      return locala;
    }
    
    public a[] a(int paramAnonymousInt)
    {
      return new a[paramAnonymousInt];
    }
  };
  private static d b = new d(a.class.getSimpleName());
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private ArrayList<String> i = new ArrayList();
  private String j;
  private String k;
  private String l;
  private int m;
  private String n;
  private String o;
  private String p;
  
  public a() {}
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
  }
  
  public a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.c = paramJSONObject.optString("id");
      this.d = paramJSONObject.optString("title");
      this.e = paramJSONObject.optString("description");
      this.f = paramJSONObject.optString("logo");
      this.g = paramJSONObject.optString("banner");
      this.h = paramJSONObject.optString("thumbnail");
      this.j = paramJSONObject.optString("action_url");
      this.k = paramJSONObject.optString("tracker");
      this.l = paramJSONObject.optString("click_tracker");
      try
      {
        JSONArray localJSONArray = new org/json/JSONArray;
        localJSONArray.<init>(paramJSONObject.getString("tags"));
        int i1 = 0;
        for (;;)
        {
          int i2 = localJSONArray.length();
          if (i1 < i2) {
            try
            {
              this.i.add(localJSONArray.getString(i1));
              i1++;
            }
            catch (JSONException paramJSONObject)
            {
              for (;;)
              {
                b.a(paramJSONObject);
              }
            }
          }
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        b.b(paramJSONObject.toString());
      }
    }
  }
  
  public String a()
  {
    return this.p;
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(String paramString)
  {
    this.p = paramString;
  }
  
  public String b()
  {
    return this.n;
  }
  
  public void b(String paramString)
  {
    this.n = paramString;
  }
  
  public String c()
  {
    return this.o;
  }
  
  public void c(String paramString)
  {
    this.o = paramString;
  }
  
  public int d()
  {
    return this.m;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public String f()
  {
    return this.h;
  }
  
  public ArrayList<String> g()
  {
    return this.i;
  }
  
  public String h()
  {
    return this.k;
  }
  
  public String i()
  {
    return this.c;
  }
  
  public String j()
  {
    return this.e;
  }
  
  public String k()
  {
    return this.f;
  }
  
  public String l()
  {
    return this.g;
  }
  
  public String m()
  {
    return this.j;
  }
  
  public String n()
  {
    return this.l;
  }
  
  public String toString()
  {
    return "AdInfo [mId=" + this.c + ", mTitle=" + this.d + ", mDescription=" + this.e + ", mLogo=" + this.f + ", mBanner=" + this.g + ", mThumbnail=" + this.h + ", mTags=" + this.i + ", mActionUrl=" + this.j + ", mTracker=" + this.k + ", mClickTracker=" + this.l + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeList(this.i);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\bean\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */