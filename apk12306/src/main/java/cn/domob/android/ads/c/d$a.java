package cn.domob.android.ads.c;

class d$a
  implements Runnable
{
  private boolean b = false;
  private d.b c;
  
  protected d$a(d paramd, d.b paramb)
  {
    this.c = paramb;
  }
  
  protected void a(d.b paramb)
  {
    this.c = paramb;
  }
  
  protected boolean a()
  {
    return this.b;
  }
  
  protected boolean b()
  {
    if ((this.c != null) && (!this.b)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void run()
  {
    if (this.c != null)
    {
      this.c.a();
      this.b = true;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\c\d$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */