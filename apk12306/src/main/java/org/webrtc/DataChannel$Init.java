package org.webrtc;

public class DataChannel$Init
{
  public int id = -1;
  public int maxRetransmitTimeMs = -1;
  public int maxRetransmits = -1;
  public boolean negotiated = false;
  public boolean ordered = true;
  public String protocol = "";
  
  public DataChannel$Init() {}
  
  private DataChannel$Init(boolean paramBoolean1, int paramInt1, int paramInt2, String paramString, boolean paramBoolean2, int paramInt3)
  {
    this.ordered = paramBoolean1;
    this.maxRetransmitTimeMs = paramInt1;
    this.maxRetransmits = paramInt2;
    this.protocol = paramString;
    this.negotiated = paramBoolean2;
    this.id = paramInt3;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\DataChannel$Init.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */