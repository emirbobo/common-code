package com.worklight.androidgap.push;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.bangcle.andjni.JniLib;

final class WLGCMIntentService$Message$1
  implements Parcelable.Creator<WLGCMIntentService.Message>
{
  static
  {
    JniLib.a(1.class, 1243);
  }
  
  public native WLGCMIntentService.Message createFromParcel(Parcel paramParcel);
  
  public native WLGCMIntentService.Message[] newArray(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\push\WLGCMIntentService$Message$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */