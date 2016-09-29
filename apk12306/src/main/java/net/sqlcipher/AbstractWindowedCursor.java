package net.sqlcipher;

import android.database.CharArrayBuffer;

public abstract class AbstractWindowedCursor
  extends AbstractCursor
{
  protected CursorWindow mWindow;
  
  protected void checkPosition()
  {
    super.checkPosition();
    if (this.mWindow == null) {
      throw new StaleDataException("Access closed cursor");
    }
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt)) {
        super.copyStringToBuffer(paramInt, paramCharArrayBuffer);
      }
      this.mWindow.copyStringToBuffer(this.mPos, paramInt, paramCharArrayBuffer);
      return;
    }
  }
  
  public byte[] getBlob(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        arrayOfByte = (byte[])getUpdatedField(paramInt);
        return arrayOfByte;
      }
      byte[] arrayOfByte = this.mWindow.getBlob(this.mPos, paramInt);
    }
  }
  
  public double getDouble(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        d = ((Number)getUpdatedField(paramInt)).doubleValue();
        return d;
      }
      double d = this.mWindow.getDouble(this.mPos, paramInt);
    }
  }
  
  public float getFloat(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        f = ((Number)getUpdatedField(paramInt)).floatValue();
        return f;
      }
      float f = this.mWindow.getFloat(this.mPos, paramInt);
    }
  }
  
  public int getInt(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        paramInt = ((Number)getUpdatedField(paramInt)).intValue();
        return paramInt;
      }
      paramInt = this.mWindow.getInt(this.mPos, paramInt);
    }
  }
  
  public long getLong(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        l = ((Number)getUpdatedField(paramInt)).longValue();
        return l;
      }
      long l = this.mWindow.getLong(this.mPos, paramInt);
    }
  }
  
  public short getShort(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        paramInt = ((Number)getUpdatedField(paramInt)).shortValue();
        int i = paramInt;
        return i;
      }
      paramInt = this.mWindow.getShort(this.mPos, paramInt);
      int j = paramInt;
    }
  }
  
  public String getString(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        str = (String)getUpdatedField(paramInt);
        return str;
      }
      String str = this.mWindow.getString(this.mPos, paramInt);
    }
  }
  
  public CursorWindow getWindow()
  {
    return this.mWindow;
  }
  
  public boolean hasWindow()
  {
    if (this.mWindow != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isBlob(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        Object localObject1 = getUpdatedField(paramInt);
        if ((localObject1 == null) || ((localObject1 instanceof byte[]))) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      boolean bool = this.mWindow.isBlob(this.mPos, paramInt);
    }
  }
  
  public boolean isFloat(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        Object localObject1 = getUpdatedField(paramInt);
        if ((localObject1 != null) && (((localObject1 instanceof Float)) || ((localObject1 instanceof Double)))) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      boolean bool = this.mWindow.isFloat(this.mPos, paramInt);
    }
  }
  
  public boolean isLong(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        Object localObject1 = getUpdatedField(paramInt);
        if ((localObject1 != null) && (((localObject1 instanceof Integer)) || ((localObject1 instanceof Long)))) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      boolean bool = this.mWindow.isLong(this.mPos, paramInt);
    }
  }
  
  public boolean isNull(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        if (getUpdatedField(paramInt) == null) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      boolean bool = this.mWindow.isNull(this.mPos, paramInt);
    }
  }
  
  public boolean isString(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        Object localObject1 = getUpdatedField(paramInt);
        if ((localObject1 == null) || ((localObject1 instanceof String))) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      boolean bool = this.mWindow.isString(this.mPos, paramInt);
    }
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    if (this.mWindow != null) {
      this.mWindow.close();
    }
    this.mWindow = paramCursorWindow;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\AbstractWindowedCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */