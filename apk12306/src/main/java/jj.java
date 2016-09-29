import java.util.Hashtable;

public final class jj
{
  public Hashtable a;
  
  public final jo a(String paramString)
    throws jp
  {
    return (jo)this.a.get(paramString);
  }
  
  public final void a()
    throws jp
  {
    this.a = new Hashtable();
  }
  
  public final void a(String paramString)
    throws jp
  {
    this.a.remove(paramString);
  }
  
  public final void a(String paramString, jo paramjo)
    throws jp
  {
    this.a.put(paramString, paramjo);
  }
  
  public final boolean a(String paramString)
    throws jp
  {
    return this.a.containsKey(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */