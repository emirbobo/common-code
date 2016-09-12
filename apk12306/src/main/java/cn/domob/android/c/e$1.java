package cn.domob.android.c;

import cn.domob.android.i.f;

class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public void run()
  {
    a.a(e.a(this.a), null, null, e.b(this.a), new b()
    {
      public void a() {}
      
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        e.1.this.a.a.d(String.format("cache download failed errCode: %d, errInfo: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString }));
        if (e.c(e.1.this.a) != null)
        {
          if (paramAnonymousInt != 1) {
            break label87;
          }
          e.c(e.1.this.a).a(e.d(e.1.this.a), e.e(e.1.this.a));
        }
        for (;;)
        {
          return;
          label87:
          if (paramAnonymousInt == 5) {
            e.c(e.1.this.a).c(e.d(e.1.this.a), e.e(e.1.this.a));
          } else if (paramAnonymousInt == 6) {
            e.c(e.1.this.a).d(e.d(e.1.this.a), e.e(e.1.this.a));
          } else if (paramAnonymousInt == 7) {
            e.c(e.1.this.a).b(e.d(e.1.this.a), e.e(e.1.this.a));
          }
        }
      }
      
      public void a(String paramAnonymousString) {}
      
      public void a(String paramAnonymousString, long paramAnonymousLong)
      {
        if (e.c(e.1.this.a) != null) {
          e.c(e.1.this.a).a(e.d(e.1.this.a), e.e(e.1.this.a), paramAnonymousString, paramAnonymousLong);
        }
      }
      
      public void b() {}
      
      public void b(String paramAnonymousString, long paramAnonymousLong)
      {
        if (e.c(e.1.this.a) != null) {
          e.c(e.1.this.a).b(e.d(e.1.this.a), e.e(e.1.this.a), paramAnonymousString, paramAnonymousLong);
        }
      }
    }, null, false, e.f(this.a), 3);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\c\e$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */