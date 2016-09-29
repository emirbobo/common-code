package com.worklight.wlclient.api.challengehandler;

import com.worklight.wlclient.WLRequest;
import com.worklight.wlclient.api.WLResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseChallengeHandler<T>
{
  protected WLRequest activeRequest = null;
  private String realm;
  private List<WLRequest> requestWaitingList = new ArrayList();
  
  protected BaseChallengeHandler(String paramString)
  {
    this.realm = paramString;
  }
  
  private void clearChallengeRequests()
  {
    try
    {
      this.activeRequest = null;
      clearWaitingList();
      return;
    }
    finally {}
  }
  
  public void clearWaitingList()
  {
    try
    {
      this.requestWaitingList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getRealm()
  {
    return this.realm;
  }
  
  public abstract void handleChallenge(T paramT);
  
  public void releaseWaitingList()
  {
    try
    {
      Iterator localIterator = this.requestWaitingList.iterator();
      while (localIterator.hasNext()) {
        ((WLRequest)localIterator.next()).removeExpectedAnswer(this.realm);
      }
      clearWaitingList();
    }
    finally {}
  }
  
  /* Error */
  public void startHandleChallenge(WLRequest paramWLRequest, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 66	com/worklight/wlclient/WLRequest:getOptions	()Lcom/worklight/wlclient/api/WLRequestOptions;
    //   6: invokevirtual 71	com/worklight/wlclient/api/WLRequestOptions:isFromChallenge	()Z
    //   9: ifne +29 -> 38
    //   12: aload_0
    //   13: getfield 19	com/worklight/wlclient/api/challengehandler/BaseChallengeHandler:activeRequest	Lcom/worklight/wlclient/WLRequest;
    //   16: ifnull +17 -> 33
    //   19: aload_0
    //   20: getfield 24	com/worklight/wlclient/api/challengehandler/BaseChallengeHandler:requestWaitingList	Ljava/util/List;
    //   23: aload_1
    //   24: invokeinterface 75 2 0
    //   29: pop
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: aload_1
    //   35: putfield 19	com/worklight/wlclient/api/challengehandler/BaseChallengeHandler:activeRequest	Lcom/worklight/wlclient/WLRequest;
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_0
    //   41: aload_2
    //   42: invokevirtual 77	com/worklight/wlclient/api/challengehandler/BaseChallengeHandler:handleChallenge	(Ljava/lang/Object;)V
    //   45: goto -13 -> 32
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	BaseChallengeHandler
    //   0	53	1	paramWLRequest	WLRequest
    //   0	53	2	paramT	T
    // Exception table:
    //   from	to	target	type
    //   2	32	48	finally
    //   33	38	48	finally
    //   38	40	48	finally
    //   49	51	48	finally
  }
  
  protected void submitFailure(WLResponse paramWLResponse)
  {
    clearChallengeRequests();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\challengehandler\BaseChallengeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */