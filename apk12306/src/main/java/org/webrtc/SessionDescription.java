package org.webrtc;

public class SessionDescription
{
  public final String description;
  public final SessionDescription.Type type;
  
  public SessionDescription(SessionDescription.Type paramType, String paramString)
  {
    this.type = paramType;
    this.description = paramString;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\SessionDescription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */