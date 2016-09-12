package cn.dbox.core.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a$1
  implements Parcelable.Creator<a>
{
  public a a(Parcel paramParcel)
  {
    a locala = new a();
    a.a(locala, paramParcel.readString());
    a.b(locala, paramParcel.readString());
    a.c(locala, paramParcel.readString());
    a.d(locala, paramParcel.readString());
    a.e(locala, paramParcel.readString());
    a.f(locala, paramParcel.readString());
    a.g(locala, paramParcel.readString());
    a.h(locala, paramParcel.readString());
    a.i(locala, paramParcel.readString());
    a.a(locala, paramParcel.readArrayList(getClass().getClassLoader()));
    return locala;
  }
  
  public a[] a(int paramInt)
  {
    return new a[paramInt];
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\bean\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */