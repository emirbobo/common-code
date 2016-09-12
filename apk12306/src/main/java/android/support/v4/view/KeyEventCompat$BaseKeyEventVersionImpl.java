package android.support.v4.view;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;

class KeyEventCompat$BaseKeyEventVersionImpl
  implements KeyEventCompat.KeyEventVersionImpl
{
  private static final int META_ALL_MASK = 247;
  private static final int META_MODIFIER_MASK = 247;
  
  private static int metaStateFilterDirectionalModifiers(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int j = 1;
    int i;
    if ((paramInt2 & paramInt3) != 0)
    {
      i = 1;
      paramInt5 = paramInt4 | paramInt5;
      if ((paramInt2 & paramInt5) == 0) {
        break label53;
      }
      paramInt4 = j;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (paramInt4 != 0)
        {
          throw new IllegalArgumentException("bad arguments");
          i = 0;
          break;
          label53:
          paramInt4 = 0;
          continue;
        }
        paramInt2 = paramInt1 & (paramInt5 ^ 0xFFFFFFFF);
      }
    }
    for (;;)
    {
      return paramInt2;
      paramInt2 = paramInt1;
      if (paramInt4 != 0) {
        paramInt2 = paramInt1 & (paramInt3 ^ 0xFFFFFFFF);
      }
    }
  }
  
  public boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2)
  {
    return paramKeyEvent.dispatch(paramCallback);
  }
  
  public Object getKeyDispatcherState(View paramView)
  {
    return null;
  }
  
  public boolean isTracking(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean metaStateHasModifiers(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(paramInt1) & 0xF7, paramInt2, 1, 64, 128), paramInt2, 2, 16, 32) == paramInt2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean metaStateHasNoModifiers(int paramInt)
  {
    if ((normalizeMetaState(paramInt) & 0xF7) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int normalizeMetaState(int paramInt)
  {
    int i = paramInt;
    if ((paramInt & 0xC0) != 0) {
      i = paramInt | 0x1;
    }
    paramInt = i;
    if ((i & 0x30) != 0) {
      paramInt = i | 0x2;
    }
    return paramInt & 0xF7;
  }
  
  public void startTracking(KeyEvent paramKeyEvent) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\view\KeyEventCompat$BaseKeyEventVersionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */