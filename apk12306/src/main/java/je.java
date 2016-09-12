public final class je
{
  public String a;
  public String b;
  
  public je(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  private static int a(String paramString)
  {
    if (paramString == null) {}
    for (int i = 1;; i = paramString.hashCode()) {
      return i;
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool;
    if (paramString1 == paramString2) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((paramString1 == null) || (paramString2 == null)) {
        bool = false;
      } else {
        bool = paramString1.equals(paramString2);
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramObject instanceof je)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramObject = (je)paramObject;
      if (paramObject != this)
      {
        bool1 = bool2;
        if (a(this.a, ((je)paramObject).a))
        {
          bool1 = bool2;
          if (!a(this.b, ((je)paramObject).b)) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public final int hashCode()
  {
    return a(this.a) + a(this.b) * 31;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\je.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */