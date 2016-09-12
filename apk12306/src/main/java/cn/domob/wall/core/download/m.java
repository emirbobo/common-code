package cn.domob.wall.core.download;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class m<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public m(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.c = paramInt;
    this.a = new LinkedHashMap(0, 0.75F, true);
  }
  
  private void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.b < 0) || ((this.a.isEmpty()) && (this.b != 0)))
        {
          IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          localIllegalStateException.<init>(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
          throw localIllegalStateException;
        }
      }
      finally {}
      if ((this.b <= paramInt) || (this.a.isEmpty())) {
        return;
      }
      Object localObject3 = (Map.Entry)this.a.entrySet().iterator().next();
      Object localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      this.a.remove(localObject2);
      this.b -= c(localObject2, localObject3);
      this.f += 1;
      a(true, localObject2, localObject3, null);
    }
  }
  
  private int c(K paramK, V paramV)
  {
    int i = a(paramK, paramV);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    }
    return i;
  }
  
  protected int a(K paramK, V paramV)
  {
    return 1;
  }
  
  public final V a(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = this.a.get(paramK);
        if (localObject1 != null)
        {
          this.g += 1;
          paramK = (K)localObject1;
          return paramK;
        }
        this.h += 1;
        localObject2 = c(paramK);
        if (localObject2 == null)
        {
          paramK = null;
          continue;
        }
      }
      finally {}
      try
      {
        this.e += 1;
        localObject1 = this.a.put(paramK, localObject2);
        if (localObject1 != null) {
          this.a.put(paramK, localObject1);
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label155;
          }
          a(false, paramK, localObject2, localObject1);
          paramK = (K)localObject1;
          break;
          this.b += c(paramK, localObject2);
        }
        a(this.c);
      }
      finally {}
      label155:
      paramK = (K)localObject2;
    }
  }
  
  public final void a()
  {
    a(-1);
  }
  
  protected void a(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final int b()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final V b(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Object localObject = this.a.remove(paramK);
      if (localObject != null) {
        this.b -= c(paramK, localObject);
      }
      if (localObject != null) {
        a(false, paramK, localObject, null);
      }
      return (V)localObject;
    }
    finally {}
  }
  
  public final V b(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.d += 1;
      this.b += c(paramK, paramV);
      Object localObject = this.a.put(paramK, paramV);
      if (localObject != null) {
        this.b -= c(paramK, localObject);
      }
      if (localObject != null) {
        a(false, paramK, localObject, paramV);
      }
      a(this.c);
      return (V)localObject;
    }
    finally {}
  }
  
  public final int c()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected V c(K paramK)
  {
    return null;
  }
  
  public final int d()
  {
    try
    {
      int i = this.g;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int e()
  {
    try
    {
      int i = this.h;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int f()
  {
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int g()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int h()
  {
    try
    {
      int i = this.f;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final Map<K, V> i()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.a);
      return localLinkedHashMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.g + this.h;
      if (j != 0) {
        i = this.g * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */