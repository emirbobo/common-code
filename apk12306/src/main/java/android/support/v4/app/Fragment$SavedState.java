package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Fragment$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
  {
    public Fragment.SavedState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Fragment.SavedState(paramAnonymousParcel, null);
    }
    
    public Fragment.SavedState[] newArray(int paramAnonymousInt)
    {
      return new Fragment.SavedState[paramAnonymousInt];
    }
  };
  final Bundle mState;
  
  Fragment$SavedState(Bundle paramBundle)
  {
    this.mState = paramBundle;
  }
  
  Fragment$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    this.mState = paramParcel.readBundle();
    if ((paramClassLoader != null) && (this.mState != null)) {
      this.mState.setClassLoader(paramClassLoader);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.mState);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\app\Fragment$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */