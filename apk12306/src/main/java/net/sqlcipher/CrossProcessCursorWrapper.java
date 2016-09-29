package net.sqlcipher;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

public class CrossProcessCursorWrapper
  extends CursorWrapper
  implements CrossProcessCursor
{
  public CrossProcessCursorWrapper(Cursor paramCursor)
  {
    super(paramCursor);
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    if ((paramInt < 0) || (paramInt > getCount())) {
      return;
    }
    paramCursorWindow.acquireReference();
    for (;;)
    {
      try
      {
        moveToPosition(paramInt - 1);
        paramCursorWindow.clear();
        paramCursorWindow.setStartPosition(paramInt);
        int i = getColumnCount();
        paramCursorWindow.setNumColumns(i);
        if ((moveToNext()) && (paramCursorWindow.allocRow()))
        {
          paramInt = 0;
          if (paramInt >= i) {
            continue;
          }
          String str = getString(paramInt);
          if (str == null) {
            continue;
          }
          if (paramCursorWindow.putString(str, getPosition(), paramInt)) {
            break label136;
          }
          paramCursorWindow.freeLastRow();
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        paramCursorWindow.releaseReference();
        break;
        if (!paramCursorWindow.putNull(getPosition(), paramInt))
        {
          paramCursorWindow.freeLastRow();
          continue;
        }
      }
      finally
      {
        paramCursorWindow.releaseReference();
      }
      label136:
      paramInt++;
    }
  }
  
  public CursorWindow getWindow()
  {
    return null;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return true;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\CrossProcessCursorWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */