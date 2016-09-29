package com.bontai.mobiads.ads;

import android.view.View;
import android.widget.PopupWindow;
import com.bangcle.andjni.JniLib;

public class BTPopupWindow
  extends PopupWindow
{
  static
  {
    JniLib.a(BTPopupWindow.class, 184);
  }
  
  public BTPopupWindow(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
  }
  
  public native void btDismiss();
  
  public native void dismiss();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\BTPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */