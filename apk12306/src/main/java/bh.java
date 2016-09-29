import java.util.List;
import java.util.Map;

public abstract interface bh
{
  public abstract void createSession(List<String> paramList, String paramString);
  
  public abstract String getPartyId();
  
  public abstract void sendAnswer(String paramString1, String paramString2, int paramInt);
  
  public abstract void sendHangup(List<String> paramList);
  
  public abstract void sendICECandidate(String paramString1, String paramString2);
  
  public abstract void sendInvitations(String paramString1, List<String> paramList, String paramString2, Map<String, String> paramMap);
  
  public abstract void sendOffer(String paramString1, String paramString2, int paramInt);
  
  public abstract void setCallbacks(bi parambi);
  
  public abstract void terminateSession(String paramString);
  
  public abstract void validateSession(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */