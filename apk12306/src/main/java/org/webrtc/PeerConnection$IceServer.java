package org.webrtc;

public class PeerConnection$IceServer
{
  public final String password;
  public final String uri;
  public final String username;
  
  public PeerConnection$IceServer(String paramString)
  {
    this(paramString, "", "");
  }
  
  public PeerConnection$IceServer(String paramString1, String paramString2, String paramString3)
  {
    this.uri = paramString1;
    this.username = paramString2;
    this.password = paramString3;
  }
  
  public String toString()
  {
    return this.uri + "[" + this.username + ":" + this.password + "]";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\PeerConnection$IceServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */