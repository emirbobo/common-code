package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class SlidingPaneLayout$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
  {
    public SlidingPaneLayout.SavedState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new SlidingPaneLayout.SavedState(paramAnonymousParcel, null);
    }
    
    public SlidingPaneLayout.SavedState[] newArray(int paramAnonymousInt)
    {
      return new SlidingPaneLayout.SavedState[paramAnonymousInt];
    }
  };
  boolean isOpen;
  
  private SlidingPaneLayout$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isOpen = bool;
      return;
    }
  }
  
  SlidingPaneLayout$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (this.isOpen) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\widget\SlidingPaneLayout$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */