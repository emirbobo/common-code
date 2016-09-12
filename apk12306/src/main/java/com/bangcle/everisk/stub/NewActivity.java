package com.bangcle.everisk.stub;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;
import com.bangcle.everisk.shell.b;

public class NewActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = b.v();
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    localRelativeLayout.setGravity(17);
    localRelativeLayout.setBackgroundColor(0);
    paramBundle = new AlertDialog.Builder(this).setTitle(17039380).setMessage(paramBundle).setPositiveButton(17039370, new MyListen().a(this)).setView(localRelativeLayout).create();
    paramBundle.getWindow().setGravity(17);
    paramBundle.setCanceledOnTouchOutside(false);
    paramBundle.show();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\stub\NewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */