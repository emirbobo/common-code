package android.support.v4.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

class PagerTitleStripIcs$SingleLineAllCapsTransform
  extends SingleLineTransformationMethod
{
  private static final String TAG = "SingleLineAllCapsTransform";
  private Locale mLocale;
  
  public PagerTitleStripIcs$SingleLineAllCapsTransform(Context paramContext)
  {
    this.mLocale = paramContext.getResources().getConfiguration().locale;
  }
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    paramCharSequence = super.getTransformation(paramCharSequence, paramView);
    if (paramCharSequence != null) {}
    for (paramCharSequence = paramCharSequence.toString().toUpperCase(this.mLocale);; paramCharSequence = null) {
      return paramCharSequence;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\view\PagerTitleStripIcs$SingleLineAllCapsTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */