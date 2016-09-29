package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LocalBroadcastManager
{
  private static final boolean DEBUG = false;
  static final int MSG_EXEC_PENDING_BROADCASTS = 1;
  private static final String TAG = "LocalBroadcastManager";
  private static LocalBroadcastManager mInstance;
  private static final Object mLock = new Object();
  private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap();
  private final Context mAppContext;
  private final Handler mHandler;
  private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList();
  private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap();
  
  private LocalBroadcastManager(Context paramContext)
  {
    this.mAppContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          super.handleMessage(paramAnonymousMessage);
        }
        for (;;)
        {
          return;
          LocalBroadcastManager.this.executePendingBroadcasts();
        }
      }
    };
  }
  
  private void executePendingBroadcasts()
  {
    for (;;)
    {
      int i;
      synchronized (this.mReceivers)
      {
        i = this.mPendingBroadcasts.size();
        if (i <= 0) {
          return;
        }
        BroadcastRecord[] arrayOfBroadcastRecord = new BroadcastRecord[i];
        this.mPendingBroadcasts.toArray(arrayOfBroadcastRecord);
        this.mPendingBroadcasts.clear();
        i = 0;
        if (i >= arrayOfBroadcastRecord.length) {
          continue;
        }
        ??? = arrayOfBroadcastRecord[i];
        int j = 0;
        if (j < ???.receivers.size())
        {
          ((ReceiverRecord)???.receivers.get(j)).receiver.onReceive(this.mAppContext, ???.intent);
          j++;
        }
      }
      i++;
    }
  }
  
  public static LocalBroadcastManager getInstance(Context paramContext)
  {
    synchronized (mLock)
    {
      if (mInstance == null)
      {
        LocalBroadcastManager localLocalBroadcastManager = new android/support/v4/content/LocalBroadcastManager;
        localLocalBroadcastManager.<init>(paramContext.getApplicationContext());
        mInstance = localLocalBroadcastManager;
      }
      paramContext = mInstance;
      return paramContext;
    }
  }
  
  public void registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    synchronized (this.mReceivers)
    {
      ReceiverRecord localReceiverRecord = new android/support/v4/content/LocalBroadcastManager$ReceiverRecord;
      localReceiverRecord.<init>(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.mReceivers.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>(1);
        this.mReceivers.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(paramIntentFilter);
      for (int i = 0; i < paramIntentFilter.countActions(); i++)
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.mActions.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new java/util/ArrayList;
          paramBroadcastReceiver.<init>(1);
          this.mActions.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localReceiverRecord);
      }
      return;
    }
  }
  
  public boolean sendBroadcast(Intent paramIntent)
  {
    Object localObject3;
    int i;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      Object localObject4;
      int k;
      synchronized (this.mReceivers)
      {
        String str2 = paramIntent.getAction();
        String str1 = paramIntent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
        Uri localUri = paramIntent.getData();
        localObject3 = paramIntent.getScheme();
        Set localSet = paramIntent.getCategories();
        if ((paramIntent.getFlags() & 0x8) != 0)
        {
          i = 1;
          if (i != 0)
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            Log.v("LocalBroadcastManager", "Resolving type " + str1 + " scheme " + (String)localObject3 + " of intent " + paramIntent);
          }
          ArrayList localArrayList = (ArrayList)this.mActions.get(paramIntent.getAction());
          if (localArrayList == null) {
            break label581;
          }
          if (i != 0)
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            Log.v("LocalBroadcastManager", "Action list: " + localArrayList);
          }
          localObject2 = null;
          int j = 0;
          if (j >= localArrayList.size()) {
            break;
          }
          localObject4 = (ReceiverRecord)localArrayList.get(j);
          if (i != 0)
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            Log.v("LocalBroadcastManager", "Matching against filter " + ((ReceiverRecord)localObject4).filter);
          }
          if (((ReceiverRecord)localObject4).broadcasting)
          {
            localObject1 = localObject2;
            if (i != 0)
            {
              Log.v("LocalBroadcastManager", "  Filter's target already added");
              localObject1 = localObject2;
            }
            j++;
            localObject2 = localObject1;
            continue;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        k = ((ReceiverRecord)localObject4).filter.match(str2, str1, (String)localObject3, localUri, localSet, "LocalBroadcastManager");
        if (k >= 0)
        {
          if (i != 0)
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(k));
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new java/util/ArrayList;
            ((ArrayList)localObject1).<init>();
          }
          ((ArrayList)localObject1).add(localObject4);
          ((ReceiverRecord)localObject4).broadcasting = true;
        }
      }
      localObject1 = localObject2;
      if (i != 0)
      {
        switch (k)
        {
        default: 
          localObject1 = "unknown reason";
        }
        for (;;)
        {
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>();
          Log.v("LocalBroadcastManager", "  Filter did not match: " + (String)localObject1);
          localObject1 = localObject2;
          break;
          localObject1 = "action";
          continue;
          localObject1 = "category";
          continue;
          localObject1 = "data";
          continue;
          localObject1 = "type";
        }
      }
    }
    boolean bool;
    if (localObject2 != null)
    {
      for (i = 0; i < ((ArrayList)localObject2).size(); i++) {
        ((ReceiverRecord)((ArrayList)localObject2).get(i)).broadcasting = false;
      }
      localObject3 = this.mPendingBroadcasts;
      localObject1 = new android/support/v4/content/LocalBroadcastManager$BroadcastRecord;
      ((BroadcastRecord)localObject1).<init>(paramIntent, (ArrayList)localObject2);
      ((ArrayList)localObject3).add(localObject1);
      if (!this.mHandler.hasMessages(1)) {
        this.mHandler.sendEmptyMessage(1);
      }
      bool = true;
    }
    for (;;)
    {
      return bool;
      label581:
      bool = false;
    }
  }
  
  public void sendBroadcastSync(Intent paramIntent)
  {
    if (sendBroadcast(paramIntent)) {
      executePendingBroadcasts();
    }
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    synchronized (this.mReceivers)
    {
      ArrayList localArrayList2 = (ArrayList)this.mReceivers.remove(paramBroadcastReceiver);
      if (localArrayList2 == null) {
        return;
      }
      for (int j = 0; j < localArrayList2.size(); j++)
      {
        IntentFilter localIntentFilter = (IntentFilter)localArrayList2.get(j);
        for (int k = 0; k < localIntentFilter.countActions(); k++)
        {
          String str = localIntentFilter.getAction(k);
          ArrayList localArrayList1 = (ArrayList)this.mActions.get(str);
          if (localArrayList1 != null)
          {
            int m;
            for (int i = 0; i < localArrayList1.size(); i = m + 1)
            {
              m = i;
              if (((ReceiverRecord)localArrayList1.get(i)).receiver == paramBroadcastReceiver)
              {
                localArrayList1.remove(i);
                m = i - 1;
              }
            }
            if (localArrayList1.size() <= 0) {
              this.mActions.remove(str);
            }
          }
        }
      }
    }
  }
  
  private static class BroadcastRecord
  {
    final Intent intent;
    final ArrayList<LocalBroadcastManager.ReceiverRecord> receivers;
    
    BroadcastRecord(Intent paramIntent, ArrayList<LocalBroadcastManager.ReceiverRecord> paramArrayList)
    {
      this.intent = paramIntent;
      this.receivers = paramArrayList;
    }
  }
  
  private static class ReceiverRecord
  {
    boolean broadcasting;
    final IntentFilter filter;
    final BroadcastReceiver receiver;
    
    ReceiverRecord(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
    {
      this.filter = paramIntentFilter;
      this.receiver = paramBroadcastReceiver;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("Receiver{");
      localStringBuilder.append(this.receiver);
      localStringBuilder.append(" filter=");
      localStringBuilder.append(this.filter);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\content\LocalBroadcastManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */