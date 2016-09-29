package net.sqlcipher;

import android.database.ContentObserver;
import java.lang.ref.WeakReference;

public class AbstractCursor$SelfContentObserver
  extends ContentObserver
{
  WeakReference<AbstractCursor> mCursor;
  
  public AbstractCursor$SelfContentObserver(AbstractCursor paramAbstractCursor)
  {
    super(null);
    this.mCursor = new WeakReference(paramAbstractCursor);
  }
  
  public boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public void onChange(boolean paramBoolean)
  {
    AbstractCursor localAbstractCursor = (AbstractCursor)this.mCursor.get();
    if (localAbstractCursor != null) {
      localAbstractCursor.onChange(false);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\AbstractCursor$SelfContentObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */