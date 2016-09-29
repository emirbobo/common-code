package com.bangcle.everisk.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.everisk.shell.b;

class MyListen
  implements DialogInterface.OnClickListener
{
  private NewActivity S = null;
  
  final MyListen a(NewActivity paramNewActivity)
  {
    this.S = paramNewActivity;
    return this;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.u();
    this.S.finish();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\stub\MyListen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */