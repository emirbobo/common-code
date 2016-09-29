package org.webrtc;

public class MediaConstraints$KeyValuePair
{
  private final String key;
  private final String value;
  
  public MediaConstraints$KeyValuePair(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.value = paramString2;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public String toString()
  {
    return this.key + ": " + this.value;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\MediaConstraints$KeyValuePair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */