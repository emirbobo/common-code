package cn.domob.android.offerwall;

import android.webkit.DownloadListener;

class a$2
  implements DownloadListener
{
  a$2(a parama) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (a.e(this.a) != null) {
      a.e(this.a).a(paramString1);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\a$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */