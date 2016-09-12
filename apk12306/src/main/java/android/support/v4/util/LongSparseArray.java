package android.support.v4.util;

public class LongSparseArray<E>
  implements Cloneable
{
  private static final Object DELETED = new Object();
  private boolean mGarbage = false;
  private long[] mKeys;
  private int mSize;
  private Object[] mValues;
  
  public LongSparseArray()
  {
    this(10);
  }
  
  public LongSparseArray(int paramInt)
  {
    if (paramInt == 0) {
      this.mKeys = ContainerHelpers.EMPTY_LONGS;
    }
    for (this.mValues = ContainerHelpers.EMPTY_OBJECTS;; this.mValues = new Object[paramInt])
    {
      this.mSize = 0;
      return;
      paramInt = ContainerHelpers.idealLongArraySize(paramInt);
      this.mKeys = new long[paramInt];
    }
  }
  
  private void gc()
  {
    int m = this.mSize;
    int i = 0;
    long[] arrayOfLong = this.mKeys;
    Object[] arrayOfObject = this.mValues;
    int j = 0;
    while (j < m)
    {
      Object localObject = arrayOfObject[j];
      int k = i;
      if (localObject != DELETED)
      {
        if (j != i)
        {
          arrayOfLong[i] = arrayOfLong[j];
          arrayOfObject[i] = localObject;
          arrayOfObject[j] = null;
        }
        k = i + 1;
      }
      j++;
      i = k;
    }
    this.mGarbage = false;
    this.mSize = i;
  }
  
  public void append(long paramLong, E paramE)
  {
    if ((this.mSize != 0) && (paramLong <= this.mKeys[(this.mSize - 1)])) {
      put(paramLong, paramE);
    }
    for (;;)
    {
      return;
      if ((this.mGarbage) && (this.mSize >= this.mKeys.length)) {
        gc();
      }
      int j = this.mSize;
      if (j >= this.mKeys.length)
      {
        int i = ContainerHelpers.idealLongArraySize(j + 1);
        long[] arrayOfLong = new long[i];
        Object[] arrayOfObject = new Object[i];
        System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
        System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
        this.mKeys = arrayOfLong;
        this.mValues = arrayOfObject;
      }
      this.mKeys[j] = paramLong;
      this.mValues[j] = paramE;
      this.mSize = (j + 1);
    }
  }
  
  public void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.mValues;
    for (int i = 0; i < j; i++) {
      arrayOfObject[i] = null;
    }
    this.mSize = 0;
    this.mGarbage = false;
  }
  
  public LongSparseArray<E> clone()
  {
    Object localObject = null;
    try
    {
      LongSparseArray localLongSparseArray = (LongSparseArray)super.clone();
      localObject = localLongSparseArray;
      localLongSparseArray.mKeys = ((long[])this.mKeys.clone());
      localObject = localLongSparseArray;
      localLongSparseArray.mValues = ((Object[])this.mValues.clone());
      localObject = localLongSparseArray;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;) {}
    }
    return (LongSparseArray<E>)localObject;
  }
  
  public void delete(long paramLong)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if ((i >= 0) && (this.mValues[i] != DELETED))
    {
      this.mValues[i] = DELETED;
      this.mGarbage = true;
    }
  }
  
  public E get(long paramLong)
  {
    return (E)get(paramLong, null);
  }
  
  public E get(long paramLong, E paramE)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    Object localObject = paramE;
    if (i >= 0) {
      if (this.mValues[i] != DELETED) {
        break label41;
      }
    }
    label41:
    for (localObject = paramE;; localObject = this.mValues[i]) {
      return (E)localObject;
    }
  }
  
  public int indexOfKey(long paramLong)
  {
    if (this.mGarbage) {
      gc();
    }
    return ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
  }
  
  public int indexOfValue(E paramE)
  {
    if (this.mGarbage) {
      gc();
    }
    int i = 0;
    if (i < this.mSize) {
      if (this.mValues[i] != paramE) {}
    }
    for (;;)
    {
      return i;
      i++;
      break;
      i = -1;
    }
  }
  
  public long keyAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mKeys[paramInt];
  }
  
  public void put(long paramLong, E paramE)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if (i >= 0) {
      this.mValues[i] = paramE;
    }
    for (;;)
    {
      return;
      int j = i ^ 0xFFFFFFFF;
      if ((j < this.mSize) && (this.mValues[j] == DELETED))
      {
        this.mKeys[j] = paramLong;
        this.mValues[j] = paramE;
      }
      else
      {
        i = j;
        if (this.mGarbage)
        {
          i = j;
          if (this.mSize >= this.mKeys.length)
          {
            gc();
            i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong) ^ 0xFFFFFFFF;
          }
        }
        if (this.mSize >= this.mKeys.length)
        {
          j = ContainerHelpers.idealLongArraySize(this.mSize + 1);
          long[] arrayOfLong = new long[j];
          Object[] arrayOfObject = new Object[j];
          System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
          System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
          this.mKeys = arrayOfLong;
          this.mValues = arrayOfObject;
        }
        if (this.mSize - i != 0)
        {
          System.arraycopy(this.mKeys, i, this.mKeys, i + 1, this.mSize - i);
          System.arraycopy(this.mValues, i, this.mValues, i + 1, this.mSize - i);
        }
        this.mKeys[i] = paramLong;
        this.mValues[i] = paramE;
        this.mSize += 1;
      }
    }
  }
  
  public void remove(long paramLong)
  {
    delete(paramLong);
  }
  
  public void removeAt(int paramInt)
  {
    if (this.mValues[paramInt] != DELETED)
    {
      this.mValues[paramInt] = DELETED;
      this.mGarbage = true;
    }
  }
  
  public void setValueAt(int paramInt, E paramE)
  {
    if (this.mGarbage) {
      gc();
    }
    this.mValues[paramInt] = paramE;
  }
  
  public int size()
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mSize;
  }
  
  public String toString()
  {
    if (size() <= 0) {}
    for (Object localObject1 = "{}";; localObject1 = ((StringBuilder)localObject1).toString())
    {
      return (String)localObject1;
      localObject1 = new StringBuilder(this.mSize * 28);
      ((StringBuilder)localObject1).append('{');
      int i = 0;
      if (i < this.mSize)
      {
        if (i > 0) {
          ((StringBuilder)localObject1).append(", ");
        }
        ((StringBuilder)localObject1).append(keyAt(i));
        ((StringBuilder)localObject1).append('=');
        Object localObject2 = valueAt(i);
        if (localObject2 != this) {
          ((StringBuilder)localObject1).append(localObject2);
        }
        for (;;)
        {
          i++;
          break;
          ((StringBuilder)localObject1).append("(this Map)");
        }
      }
      ((StringBuilder)localObject1).append('}');
    }
  }
  
  public E valueAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return (E)this.mValues[paramInt];
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\util\LongSparseArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */