package org.webrtc;

public class StatsReport$Value
{
  public final String name;
  public final String value;
  
  public StatsReport$Value(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.value = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.name).append(": ").append(this.value).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\StatsReport$Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */