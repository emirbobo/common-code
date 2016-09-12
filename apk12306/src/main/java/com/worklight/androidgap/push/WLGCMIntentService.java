package com.worklight.androidgap.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.bangcle.andjni.JniLib;
import com.google.android.gcm.GCMBaseIntentService;
import java.util.LinkedList;
import org.json.JSONObject;

public class WLGCMIntentService
  extends GCMBaseIntentService
{
  public static final String GCM_ERROR = ".C2DM_ERROR";
  public static final String GCM_EXTRA_ALERT = "alert";
  public static final String GCM_EXTRA_BADGE = "badge";
  public static final String GCM_EXTRA_ERROR_ID = "errorId";
  public static final String GCM_EXTRA_MESSAGE = "message";
  public static final String GCM_EXTRA_PAYLOAD = "payload";
  public static final String GCM_EXTRA_REGISTRATION_ID = "registrationId";
  public static final String GCM_EXTRA_SOUND = "sound";
  public static final String GCM_MESSAGE = ".C2DM_MESSAGE";
  public static final String GCM_NOTIFICATION = ".NOTIFICATION";
  public static final String GCM_REGISTERED = ".C2DM_REGISTERED";
  public static final String GCM_UNREGISTERED = ".C2DM_UNREGISTERED";
  private static int RES_PUSH_NOTIFICATION_ICON = -1;
  private static int RES_PUSH_NOTIFICATION_TITLE = -1;
  public static LinkedList<Intent> intentsQueue = new LinkedList();
  private BroadcastReceiver resultReceiver = new BroadcastReceiver()
  {
    static
    {
      JniLib.a(1.class, 1242);
    }
    
    public native void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent);
  };
  
  static
  {
    JniLib.a(WLGCMIntentService.class, 5);
  }
  
  public WLGCMIntentService() {}
  
  public WLGCMIntentService(String paramString)
  {
    super(new String[] { paramString });
  }
  
  private native void generateNotification(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Intent paramIntent);
  
  private native void playNotificationSound(Context paramContext, String paramString);
  
  protected native void addToIntentQueue(Intent paramIntent);
  
  protected native String getNotificationTitle(Context paramContext);
  
  public native void notify(Context paramContext, String paramString);
  
  public native void notify(Context paramContext, String paramString1, int paramInt, String paramString2, Intent paramIntent);
  
  public native void onError(Context paramContext, String paramString);
  
  protected native void onMessage(Context paramContext, Intent paramIntent);
  
  protected native boolean onRecoverableError(Context paramContext, String paramString);
  
  public native void onRegistered(Context paramContext, String paramString);
  
  protected native void onUnhandled(Context paramContext, Intent paramIntent);
  
  protected native void onUnregistered(Context paramContext, String paramString);
  
  protected native void setBroadcastReceiver(BroadcastReceiver paramBroadcastReceiver);
  
  protected native void setNotificationIcon(int paramInt);
  
  protected native void setResources();
  
  public static class Message
    implements Parcelable
  {
    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator()
    {
      static
      {
        JniLib.a(1.class, 1243);
      }
      
      public native WLGCMIntentService.Message createFromParcel(Parcel paramAnonymousParcel);
      
      public native WLGCMIntentService.Message[] newArray(int paramAnonymousInt);
    };
    private String alert;
    private int badge;
    private String payload;
    private String sound;
    
    static
    {
      JniLib.a(Message.class, 1244);
    }
    
    public Message()
    {
      this.alert = null;
      this.badge = 1;
      this.sound = null;
      this.payload = null;
    }
    
    private Message(Parcel paramParcel)
    {
      this.alert = paramParcel.readString();
      this.badge = paramParcel.readInt();
      this.sound = paramParcel.readString();
      this.payload = paramParcel.readString();
    }
    
    public native int describeContents();
    
    public native JSONObject getPayload();
    
    public native JSONObject getProps();
    
    public native String toString();
    
    public native void writeToParcel(Parcel paramParcel, int paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\push\WLGCMIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */