package org.codehaus.jackson.sym;

final class BytesToNameCanonicalizer$Bucket
{
  protected final Name _name;
  protected final Bucket _next;
  
  BytesToNameCanonicalizer$Bucket(Name paramName, Bucket paramBucket)
  {
    this._name = paramName;
    this._next = paramBucket;
  }
  
  public Name find(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if ((this._name.hashCode() == paramInt1) && (this._name.equals(paramInt2, paramInt3))) {
      localObject = this._name;
    }
    for (;;)
    {
      return (Name)localObject;
      for (Bucket localBucket = this._next;; localBucket = localBucket._next)
      {
        if (localBucket == null) {
          break label83;
        }
        Name localName = localBucket._name;
        if (localName.hashCode() == paramInt1)
        {
          localObject = localName;
          if (localName.equals(paramInt2, paramInt3)) {
            break;
          }
        }
      }
      label83:
      localObject = null;
    }
  }
  
  public Name find(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    Object localObject;
    if ((this._name.hashCode() == paramInt1) && (this._name.equals(paramArrayOfInt, paramInt2))) {
      localObject = this._name;
    }
    for (;;)
    {
      return (Name)localObject;
      for (Bucket localBucket = this._next;; localBucket = localBucket._next)
      {
        if (localBucket == null) {
          break label83;
        }
        Name localName = localBucket._name;
        if (localName.hashCode() == paramInt1)
        {
          localObject = localName;
          if (localName.equals(paramArrayOfInt, paramInt2)) {
            break;
          }
        }
      }
      label83:
      localObject = null;
    }
  }
  
  public int length()
  {
    int i = 1;
    for (Bucket localBucket = this._next; localBucket != null; localBucket = localBucket._next) {
      i++;
    }
    return i;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\sym\BytesToNameCanonicalizer$Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */