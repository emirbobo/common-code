package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

class LocalBroadcastManager$ReceiverRecord
{
  boolean broadcasting;
  final IntentFilter filter;
  final BroadcastReceiver receiver;
  
  LocalBroadcastManager$ReceiverRecord(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\content\LocalBroadcastManager$ReceiverRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */