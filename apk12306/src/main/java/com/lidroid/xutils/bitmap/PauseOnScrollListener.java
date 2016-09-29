package com.lidroid.xutils.bitmap;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.task.TaskHandler;

public class PauseOnScrollListener
  implements AbsListView.OnScrollListener
{
  private final AbsListView.OnScrollListener externalListener;
  private final boolean pauseOnFling;
  private final boolean pauseOnScroll;
  private TaskHandler taskHandler;
  
  static
  {
    JniLib.a(PauseOnScrollListener.class, 927);
  }
  
  public PauseOnScrollListener(TaskHandler paramTaskHandler, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramTaskHandler, paramBoolean1, paramBoolean2, null);
  }
  
  public PauseOnScrollListener(TaskHandler paramTaskHandler, boolean paramBoolean1, boolean paramBoolean2, AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.taskHandler = paramTaskHandler;
    this.pauseOnScroll = paramBoolean1;
    this.pauseOnFling = paramBoolean2;
    this.externalListener = paramOnScrollListener;
  }
  
  public native void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3);
  
  public native void onScrollStateChanged(AbsListView paramAbsListView, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\PauseOnScrollListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */