package android.support.v4.net;

import java.net.Socket;
import java.net.SocketException;

class TrafficStatsCompat$IcsTrafficStatsCompatImpl
  implements TrafficStatsCompat.TrafficStatsCompatImpl
{
  public void clearThreadStatsTag() {}
  
  public int getThreadStatsTag()
  {
    return TrafficStatsCompatIcs.getThreadStatsTag();
  }
  
  public void incrementOperationCount(int paramInt)
  {
    TrafficStatsCompatIcs.incrementOperationCount(paramInt);
  }
  
  public void incrementOperationCount(int paramInt1, int paramInt2)
  {
    TrafficStatsCompatIcs.incrementOperationCount(paramInt1, paramInt2);
  }
  
  public void setThreadStatsTag(int paramInt)
  {
    TrafficStatsCompatIcs.setThreadStatsTag(paramInt);
  }
  
  public void tagSocket(Socket paramSocket)
    throws SocketException
  {
    TrafficStatsCompatIcs.tagSocket(paramSocket);
  }
  
  public void untagSocket(Socket paramSocket)
    throws SocketException
  {
    TrafficStatsCompatIcs.untagSocket(paramSocket);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\net\TrafficStatsCompat$IcsTrafficStatsCompatImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */