package net.sqlcipher.database;

public abstract class SQLiteClosable
{
  private Object mLock = new Object();
  private int mReferenceCount = 1;
  
  private String getObjInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" (");
    if ((this instanceof SQLiteDatabase))
    {
      localStringBuilder.append("database = ");
      localStringBuilder.append(((SQLiteDatabase)this).getPath());
    }
    for (;;)
    {
      localStringBuilder.append(") ");
      return localStringBuilder.toString();
      if (((this instanceof SQLiteProgram)) || ((this instanceof SQLiteStatement)) || ((this instanceof SQLiteQuery)))
      {
        localStringBuilder.append("mSql = ");
        localStringBuilder.append(((SQLiteProgram)this).mSql);
      }
    }
  }
  
  public void acquireReference()
  {
    synchronized (this.mLock)
    {
      if (this.mReferenceCount <= 0)
      {
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localIllegalStateException.<init>("attempt to re-open an already-closed object: " + getObjInfo());
        throw localIllegalStateException;
      }
    }
    this.mReferenceCount += 1;
  }
  
  protected abstract void onAllReferencesReleased();
  
  protected void onAllReferencesReleasedFromContainer() {}
  
  public void releaseReference()
  {
    synchronized (this.mLock)
    {
      this.mReferenceCount -= 1;
      if (this.mReferenceCount == 0) {
        onAllReferencesReleased();
      }
      return;
    }
  }
  
  public void releaseReferenceFromContainer()
  {
    synchronized (this.mLock)
    {
      this.mReferenceCount -= 1;
      if (this.mReferenceCount == 0) {
        onAllReferencesReleasedFromContainer();
      }
      return;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteClosable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */