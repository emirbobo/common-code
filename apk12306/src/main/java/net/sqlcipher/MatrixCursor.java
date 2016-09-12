package net.sqlcipher;

import java.util.ArrayList;
import java.util.Iterator;

public class MatrixCursor
  extends AbstractCursor
{
  private final int columnCount;
  private final String[] columnNames;
  private Object[] data;
  private int rowCount = 0;
  
  public MatrixCursor(String[] paramArrayOfString)
  {
    this(paramArrayOfString, 16);
  }
  
  public MatrixCursor(String[] paramArrayOfString, int paramInt)
  {
    this.columnNames = paramArrayOfString;
    this.columnCount = paramArrayOfString.length;
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    this.data = new Object[this.columnCount * i];
  }
  
  private void addRow(ArrayList<?> paramArrayList, int paramInt)
  {
    int j = paramArrayList.size();
    if (j != this.columnCount) {
      throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.size() = " + j);
    }
    this.rowCount += 1;
    Object[] arrayOfObject = this.data;
    for (int i = 0; i < j; i++) {
      arrayOfObject[(paramInt + i)] = paramArrayList.get(i);
    }
  }
  
  private void ensureCapacity(int paramInt)
  {
    if (paramInt > this.data.length)
    {
      Object[] arrayOfObject = this.data;
      int j = this.data.length * 2;
      int i = j;
      if (j < paramInt) {
        i = paramInt;
      }
      this.data = new Object[i];
      System.arraycopy(arrayOfObject, 0, this.data, 0, arrayOfObject.length);
    }
  }
  
  private Object get(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.columnCount)) {
      throw new CursorIndexOutOfBoundsException("Requested column: " + paramInt + ", # of columns: " + this.columnCount);
    }
    if (this.mPos < 0) {
      throw new CursorIndexOutOfBoundsException("Before first row.");
    }
    if (this.mPos >= this.rowCount) {
      throw new CursorIndexOutOfBoundsException("After last row.");
    }
    return this.data[(this.mPos * this.columnCount + paramInt)];
  }
  
  public void addRow(Iterable<?> paramIterable)
  {
    int i = this.rowCount * this.columnCount;
    int j = i + this.columnCount;
    ensureCapacity(j);
    if ((paramIterable instanceof ArrayList)) {
      addRow((ArrayList)paramIterable, i);
    }
    for (;;)
    {
      return;
      Object[] arrayOfObject = this.data;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (i == j) {
          throw new IllegalArgumentException("columnValues.size() > columnNames.length");
        }
        arrayOfObject[i] = localObject;
        i++;
      }
      if (i != j) {
        throw new IllegalArgumentException("columnValues.size() < columnNames.length");
      }
      this.rowCount += 1;
    }
  }
  
  public void addRow(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length != this.columnCount) {
      throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + paramArrayOfObject.length);
    }
    int i = this.rowCount;
    this.rowCount = (i + 1);
    i *= this.columnCount;
    ensureCapacity(this.columnCount + i);
    System.arraycopy(paramArrayOfObject, 0, this.data, i, this.columnCount);
  }
  
  public String[] getColumnNames()
  {
    return this.columnNames;
  }
  
  public int getCount()
  {
    return this.rowCount;
  }
  
  public double getDouble(int paramInt)
  {
    Object localObject = get(paramInt);
    double d;
    if (localObject == null) {
      d = 0.0D;
    }
    for (;;)
    {
      return d;
      if ((localObject instanceof Number)) {
        d = ((Number)localObject).doubleValue();
      } else {
        d = Double.parseDouble(localObject.toString());
      }
    }
  }
  
  public float getFloat(int paramInt)
  {
    Object localObject = get(paramInt);
    float f;
    if (localObject == null) {
      f = 0.0F;
    }
    for (;;)
    {
      return f;
      if ((localObject instanceof Number)) {
        f = ((Number)localObject).floatValue();
      } else {
        f = Float.parseFloat(localObject.toString());
      }
    }
  }
  
  public int getInt(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      paramInt = 0;
    }
    for (;;)
    {
      return paramInt;
      if ((localObject instanceof Number)) {
        paramInt = ((Number)localObject).intValue();
      } else {
        paramInt = Integer.parseInt(localObject.toString());
      }
    }
  }
  
  public long getLong(int paramInt)
  {
    Object localObject = get(paramInt);
    long l;
    if (localObject == null) {
      l = 0L;
    }
    for (;;)
    {
      return l;
      if ((localObject instanceof Number)) {
        l = ((Number)localObject).longValue();
      } else {
        l = Long.parseLong(localObject.toString());
      }
    }
  }
  
  public short getShort(int paramInt)
  {
    Object localObject = get(paramInt);
    int i;
    if (localObject == null)
    {
      paramInt = 0;
      i = paramInt;
    }
    for (;;)
    {
      return i;
      int j;
      if ((localObject instanceof Number))
      {
        paramInt = ((Number)localObject).shortValue();
        j = paramInt;
      }
      else
      {
        paramInt = Short.parseShort(localObject.toString());
        j = paramInt;
      }
    }
  }
  
  public String getString(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {}
    for (localObject = null;; localObject = localObject.toString()) {
      return (String)localObject;
    }
  }
  
  public boolean isNull(int paramInt)
  {
    if (get(paramInt) == null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public RowBuilder newRow()
  {
    this.rowCount += 1;
    int i = this.rowCount * this.columnCount;
    ensureCapacity(i);
    return new RowBuilder(i - this.columnCount, i);
  }
  
  public class RowBuilder
  {
    private final int endIndex;
    private int index;
    
    RowBuilder(int paramInt1, int paramInt2)
    {
      this.index = paramInt1;
      this.endIndex = paramInt2;
    }
    
    public RowBuilder add(Object paramObject)
    {
      if (this.index == this.endIndex) {
        throw new CursorIndexOutOfBoundsException("No more columns left.");
      }
      Object[] arrayOfObject = MatrixCursor.this.data;
      int i = this.index;
      this.index = (i + 1);
      arrayOfObject[i] = paramObject;
      return this;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\MatrixCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */