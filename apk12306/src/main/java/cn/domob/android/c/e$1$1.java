package cn.domob.android.c;

import cn.domob.android.i.f;

class e$1$1
  implements b
{
  e$1$1(e.1 param1) {}
  
  public void a() {}
  
  public void a(int paramInt, String paramString)
  {
    this.a.a.a.d(String.format("cache download failed errCode: %d, errInfo: %s", new Object[] { Integer.valueOf(paramInt), paramString }));
    if (e.c(this.a.a) != null)
    {
      if (paramInt != 1) {
        break label87;
      }
      e.c(this.a.a).a(e.d(this.a.a), e.e(this.a.a));
    }
    for (;;)
    {
      return;
      label87:
      if (paramInt == 5) {
        e.c(this.a.a).c(e.d(this.a.a), e.e(this.a.a));
      } else if (paramInt == 6) {
        e.c(this.a.a).d(e.d(this.a.a), e.e(this.a.a));
      } else if (paramInt == 7) {
        e.c(this.a.a).b(e.d(this.a.a), e.e(this.a.a));
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong)
  {
    if (e.c(this.a.a) != null) {
      e.c(this.a.a).a(e.d(this.a.a), e.e(this.a.a), paramString, paramLong);
    }
  }
  
  public void b() {}
  
  public void b(String paramString, long paramLong)
  {
    if (e.c(this.a.a) != null) {
      e.c(this.a.a).b(e.d(this.a.a), e.e(this.a.a), paramString, paramLong);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\c\e$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */