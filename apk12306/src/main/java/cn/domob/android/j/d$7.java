package cn.domob.android.j;

import android.text.SpannableStringBuilder;
import android.widget.TextView;

class d$7
  implements Runnable
{
  d$7(d paramd, SpannableStringBuilder paramSpannableStringBuilder) {}
  
  public void run()
  {
    d.b(this.b).setText(this.a);
    if (d.b(this.b).getVisibility() != 0) {
      d.b(this.b).setVisibility(0);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\d$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */