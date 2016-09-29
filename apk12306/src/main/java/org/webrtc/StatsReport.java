package org.webrtc;

public class StatsReport
{
  public final String id;
  public final double timestamp;
  public final String type;
  public final StatsReport.Value[] values;
  
  public StatsReport(String paramString1, String paramString2, double paramDouble, StatsReport.Value[] paramArrayOfValue)
  {
    this.id = paramString1;
    this.type = paramString2;
    this.timestamp = paramDouble;
    this.values = paramArrayOfValue;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ").append(this.id).append(", type: ").append(this.type).append(", timestamp: ").append(this.timestamp).append(", values: ");
    for (int i = 0; i < this.values.length; i++) {
      localStringBuilder.append(this.values[i].toString()).append(", ");
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\StatsReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */