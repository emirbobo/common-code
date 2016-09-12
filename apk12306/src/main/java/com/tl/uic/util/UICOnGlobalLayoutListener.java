package com.tl.uic.util;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.bangcle.andjni.JniLib;
import com.tl.uic.app.UICActivity;

public class UICOnGlobalLayoutListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final UICActivity uicActivity;
  private final View view;
  
  static
  {
    JniLib.a(UICOnGlobalLayoutListener.class, 1129);
  }
  
  public UICOnGlobalLayoutListener(UICActivity paramUICActivity, View paramView)
  {
    this.uicActivity = paramUICActivity;
    this.view = paramView;
  }
  
  public final native void onGlobalLayout();
  
  public final native void setListenersOnChildren(View paramView);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\UICOnGlobalLayoutListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */