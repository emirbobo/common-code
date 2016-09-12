package org.apache.cordova;

import org.json.JSONException;
import org.json.JSONObject;

public class FileProgressResult
{
  private boolean lengthComputable = false;
  private long loaded = 0L;
  private long total = 0L;
  
  public boolean getLengthComputable()
  {
    return this.lengthComputable;
  }
  
  public long getLoaded()
  {
    return this.loaded;
  }
  
  public long getTotal()
  {
    return this.total;
  }
  
  public void setLengthComputable(boolean paramBoolean)
  {
    this.lengthComputable = paramBoolean;
  }
  
  public void setLoaded(long paramLong)
  {
    this.loaded = paramLong;
  }
  
  public void setTotal(long paramLong)
  {
    this.total = paramLong;
  }
  
  public JSONObject toJSONObject()
    throws JSONException
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{loaded:").append(this.loaded).append(",total:").append(this.total).append(",lengthComputable:");
    if (this.lengthComputable) {}
    for (String str = "true";; str = "false") {
      return new JSONObject(str + "}");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\FileProgressResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */