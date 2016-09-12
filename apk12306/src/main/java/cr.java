 enum cr
{
  static
  {
    a = new cr("SHA1", 1);
    cr localcr = b;
    localcr = a;
  }
  
  private cr() {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */