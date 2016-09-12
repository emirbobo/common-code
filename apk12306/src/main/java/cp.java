public final class cp<K, V>
{
  public K a;
  public V b;
  
  public cp() {}
  
  public cp(K paramK, V paramV)
  {
    this.a = paramK;
    this.b = paramV;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    do
    {
      for (;;)
      {
        return bool;
        if ((paramObject != null) && (getClass() == paramObject.getClass())) {
          break;
        }
        bool = false;
      }
      paramObject = (cp)paramObject;
      if (this.a == null) {
        break;
      }
    } while (this.a.equals(((cp)paramObject).a));
    for (;;)
    {
      bool = false;
      break;
      if (((cp)paramObject).a == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    if (this.a != null) {}
    for (int i = this.a.hashCode();; i = 0) {
      return i;
    }
  }
  
  public final String toString()
  {
    return "{" + this.a + "," + this.b + "}";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */