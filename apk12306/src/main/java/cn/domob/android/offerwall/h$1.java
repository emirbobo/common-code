package cn.domob.android.offerwall;

class h$1
  implements j.a
{
  h$1(h paramh) {}
  
  public void a(k paramk)
  {
    h.d().b("Offer Info Request Finished.");
    if (paramk != null)
    {
      h.d().b("DomobOfferResponse to String: " + paramk.toString());
      h.a(this.a, paramk);
      h.a(this.a).a(paramk.d());
    }
    for (;;)
    {
      return;
      h.d().e("Response is null.");
      h.a(this.a).a();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\h$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */