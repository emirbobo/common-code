package cn.domob.wall.core.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AdInfo$1
  implements Parcelable.Creator<AdInfo>
{
  public AdInfo a(Parcel paramParcel)
  {
    AdInfo localAdInfo = new AdInfo();
    AdInfo.a(localAdInfo, paramParcel.readInt());
    AdInfo.b(localAdInfo, paramParcel.readInt());
    AdInfo.c(localAdInfo, paramParcel.readInt());
    AdInfo.d(localAdInfo, paramParcel.readInt());
    AdInfo.e(localAdInfo, paramParcel.readInt());
    AdInfo.f(localAdInfo, paramParcel.readInt());
    localAdInfo.b = paramParcel.readInt();
    AdInfo.a(localAdInfo, paramParcel.readString());
    AdInfo.b(localAdInfo, paramParcel.readString());
    AdInfo.c(localAdInfo, paramParcel.readString());
    AdInfo.d(localAdInfo, paramParcel.readString());
    AdInfo.e(localAdInfo, paramParcel.readString());
    AdInfo.f(localAdInfo, paramParcel.readString());
    AdInfo.g(localAdInfo, paramParcel.readString());
    AdInfo.h(localAdInfo, paramParcel.readString());
    AdInfo.i(localAdInfo, paramParcel.readString());
    AdInfo.j(localAdInfo, paramParcel.readString());
    AdInfo.k(localAdInfo, paramParcel.readString());
    AdInfo.l(localAdInfo, paramParcel.readString());
    localAdInfo.c = paramParcel.readString();
    AdInfo.m(localAdInfo, paramParcel.readString());
    AdInfo.n(localAdInfo, paramParcel.readString());
    AdInfo.o(localAdInfo, paramParcel.readString());
    AdInfo.p(localAdInfo, paramParcel.readString());
    AdInfo.q(localAdInfo, paramParcel.readString());
    AdInfo.a(localAdInfo, paramParcel.readLong());
    AdInfo.a(localAdInfo, paramParcel.readArrayList(getClass().getClassLoader()));
    return localAdInfo;
  }
  
  public AdInfo[] a(int paramInt)
  {
    return new AdInfo[paramInt];
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\bean\AdInfo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */