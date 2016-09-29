package cn.domob.android.offerwall;

import org.json.JSONObject;

class k$b
{
  private boolean b;
  private boolean c;
  
  k$b(k paramk, JSONObject paramJSONObject)
  {
    this.b = paramJSONObject.optBoolean("autorun", false);
    this.c = paramJSONObject.optBoolean("autodownload", false);
  }
  
  protected boolean a()
  {
    return this.b;
  }
  
  protected boolean b()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OfferConfig [mAutorun=").append(this.b).append(", mAutoDownload=").append(this.c).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\k$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */