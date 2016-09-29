import com.arrownock.exception.ArrownockException;
import com.arrownock.live.AnLive;
import com.arrownock.live.IAnLiveEventListener;
import com.arrownock.live.IStartCallCallback;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class bi
{
  public bi(AnLive paramAnLive) {}
  
  public final void a(String paramString1, List<String> paramList, String paramString2, ArrownockException paramArrownockException)
  {
    if ((paramArrownockException == null) || (AnLive.access$100(this.a) != null)) {}
    try
    {
      AnLive.access$100(this.a).onFailure(paramArrownockException);
      for (;;)
      {
        AnLive.access$102(this.a, null);
        return;
        AnLive.access$202(this.a, paramString1);
        AnLive.access$302(this.a, true);
        paramArrownockException = paramList.iterator();
        while (paramArrownockException.hasNext())
        {
          String str = (String)paramArrownockException.next();
          if ((str != null) && (!str.equals(AnLive.access$400(this.a).getPartyId()))) {
            AnLive.access$502(this.a, str);
          }
        }
        if (AnLive.access$100(this.a) != null) {}
        try
        {
          AnLive.access$100(this.a).onReady(paramString1);
          if (AnLive.access$400(this.a) == null) {
            continue;
          }
          try
          {
            AnLive.access$400(this.a).sendInvitations(paramString1, paramList, paramString2, AnLive.access$600(this.a));
          }
          catch (Exception paramList)
          {
            AnLive.access$400(this.a).terminateSession(paramString1);
          }
        }
        catch (Exception paramArrownockException)
        {
          for (;;) {}
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
  }
  
  public final void a(boolean paramBoolean, String paramString1, List<String> paramList, String paramString2, Date paramDate)
  {
    if (paramBoolean)
    {
      AnLive.access$202(this.a, paramString1);
      AnLive.access$302(this.a, true);
      AnLive.access$802(this.a, paramString2);
      AnLive.access$502(this.a, (String)paramList.get(0));
    }
    for (;;)
    {
      try
      {
        AnLive.access$900(this.a).onReceivedInvitation(true, paramString1, (String)paramList.get(0), paramString2, paramDate);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        continue;
      }
      if (paramList != null) {}
      try
      {
        if (paramList.size() != 0) {
          break label128;
        }
        AnLive.access$900(this.a).onReceivedInvitation(false, null, null, null, null);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      continue;
      label128:
      AnLive.access$900(this.a).onReceivedInvitation(false, paramString1, (String)paramList.get(0), paramString2, paramDate);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */