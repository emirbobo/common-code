package android.support.v4.net;

import java.net.Socket;
import java.net.SocketException;

abstract interface TrafficStatsCompat$TrafficStatsCompatImpl
{
  public abstract void clearThreadStatsTag();
  
  public abstract int getThreadStatsTag();
  
  public abstract void incrementOperationCount(int paramInt);
  
  public abstract void incrementOperationCount(int paramInt1, int paramInt2);
  
  public abstract void setThreadStatsTag(int paramInt);
  
  public abstract void tagSocket(Socket paramSocket)
    throws SocketException;
  
  public abstract void untagSocket(Socket paramSocket)
    throws SocketException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\net\TrafficStatsCompat$TrafficStatsCompatImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */