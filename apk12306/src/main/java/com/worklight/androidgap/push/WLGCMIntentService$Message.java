package com.worklight.androidgap.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.bangcle.andjni.JniLib;
import org.json.JSONObject;

public class WLGCMIntentService$Message
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
  
  public WLGCMIntentService$Message()
  {
    this.alert = null;
    this.badge = 1;
    this.sound = null;
    this.payload = null;
  }
  
  private WLGCMIntentService$Message(Parcel paramParcel)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\push\WLGCMIntentService$Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */