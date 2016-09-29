package org.apache.cordova;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class InAppBrowser$4$4
  implements View.OnKeyListener
{
  InAppBrowser$4$4(InAppBrowser.4 param4) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 66)) {
      InAppBrowser.access$600(this.this$1.this$0, InAppBrowser.access$500(this.this$1.this$0).getText().toString());
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\InAppBrowser$4$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */