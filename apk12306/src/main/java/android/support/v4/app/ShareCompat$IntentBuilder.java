package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Html;
import java.util.ArrayList;

public class ShareCompat$IntentBuilder
{
  private Activity mActivity;
  private ArrayList<String> mBccAddresses;
  private ArrayList<String> mCcAddresses;
  private CharSequence mChooserTitle;
  private Intent mIntent;
  private ArrayList<Uri> mStreams;
  private ArrayList<String> mToAddresses;
  
  private ShareCompat$IntentBuilder(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mIntent = new Intent().setAction("android.intent.action.SEND");
    this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", paramActivity.getPackageName());
    this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", paramActivity.getComponentName());
    this.mIntent.addFlags(524288);
  }
  
  private void combineArrayExtra(String paramString, ArrayList<String> paramArrayList)
  {
    String[] arrayOfString2 = this.mIntent.getStringArrayExtra(paramString);
    if (arrayOfString2 != null) {}
    for (int i = arrayOfString2.length;; i = 0)
    {
      String[] arrayOfString1 = new String[paramArrayList.size() + i];
      paramArrayList.toArray(arrayOfString1);
      if (arrayOfString2 != null) {
        System.arraycopy(arrayOfString2, 0, arrayOfString1, paramArrayList.size(), i);
      }
      this.mIntent.putExtra(paramString, arrayOfString1);
      return;
    }
  }
  
  private void combineArrayExtra(String paramString, String[] paramArrayOfString)
  {
    Intent localIntent = getIntent();
    String[] arrayOfString2 = localIntent.getStringArrayExtra(paramString);
    if (arrayOfString2 != null) {}
    for (int i = arrayOfString2.length;; i = 0)
    {
      String[] arrayOfString1 = new String[paramArrayOfString.length + i];
      if (arrayOfString2 != null) {
        System.arraycopy(arrayOfString2, 0, arrayOfString1, 0, i);
      }
      System.arraycopy(paramArrayOfString, 0, arrayOfString1, i, paramArrayOfString.length);
      localIntent.putExtra(paramString, arrayOfString1);
      return;
    }
  }
  
  public static IntentBuilder from(Activity paramActivity)
  {
    return new IntentBuilder(paramActivity);
  }
  
  public IntentBuilder addEmailBcc(String paramString)
  {
    if (this.mBccAddresses == null) {
      this.mBccAddresses = new ArrayList();
    }
    this.mBccAddresses.add(paramString);
    return this;
  }
  
  public IntentBuilder addEmailBcc(String[] paramArrayOfString)
  {
    combineArrayExtra("android.intent.extra.BCC", paramArrayOfString);
    return this;
  }
  
  public IntentBuilder addEmailCc(String paramString)
  {
    if (this.mCcAddresses == null) {
      this.mCcAddresses = new ArrayList();
    }
    this.mCcAddresses.add(paramString);
    return this;
  }
  
  public IntentBuilder addEmailCc(String[] paramArrayOfString)
  {
    combineArrayExtra("android.intent.extra.CC", paramArrayOfString);
    return this;
  }
  
  public IntentBuilder addEmailTo(String paramString)
  {
    if (this.mToAddresses == null) {
      this.mToAddresses = new ArrayList();
    }
    this.mToAddresses.add(paramString);
    return this;
  }
  
  public IntentBuilder addEmailTo(String[] paramArrayOfString)
  {
    combineArrayExtra("android.intent.extra.EMAIL", paramArrayOfString);
    return this;
  }
  
  public IntentBuilder addStream(Uri paramUri)
  {
    Uri localUri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    if (localUri == null) {}
    for (paramUri = setStream(paramUri);; paramUri = this)
    {
      return paramUri;
      if (this.mStreams == null) {
        this.mStreams = new ArrayList();
      }
      if (localUri != null)
      {
        this.mIntent.removeExtra("android.intent.extra.STREAM");
        this.mStreams.add(localUri);
      }
      this.mStreams.add(paramUri);
    }
  }
  
  public Intent createChooserIntent()
  {
    return Intent.createChooser(getIntent(), this.mChooserTitle);
  }
  
  Activity getActivity()
  {
    return this.mActivity;
  }
  
  public Intent getIntent()
  {
    int i = 1;
    if (this.mToAddresses != null)
    {
      combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
      this.mToAddresses = null;
    }
    if (this.mCcAddresses != null)
    {
      combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
      this.mCcAddresses = null;
    }
    if (this.mBccAddresses != null)
    {
      combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
      this.mBccAddresses = null;
    }
    if ((this.mStreams != null) && (this.mStreams.size() > 1))
    {
      boolean bool = this.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
      if ((i == 0) && (bool))
      {
        this.mIntent.setAction("android.intent.action.SEND");
        if ((this.mStreams == null) || (this.mStreams.isEmpty())) {
          break label219;
        }
        this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.mStreams.get(0));
        label155:
        this.mStreams = null;
      }
      if ((i != 0) && (!bool))
      {
        this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
        if ((this.mStreams == null) || (this.mStreams.isEmpty())) {
          break label231;
        }
        this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
      }
    }
    for (;;)
    {
      return this.mIntent;
      i = 0;
      break;
      label219:
      this.mIntent.removeExtra("android.intent.extra.STREAM");
      break label155;
      label231:
      this.mIntent.removeExtra("android.intent.extra.STREAM");
    }
  }
  
  public IntentBuilder setChooserTitle(int paramInt)
  {
    return setChooserTitle(this.mActivity.getText(paramInt));
  }
  
  public IntentBuilder setChooserTitle(CharSequence paramCharSequence)
  {
    this.mChooserTitle = paramCharSequence;
    return this;
  }
  
  public IntentBuilder setEmailBcc(String[] paramArrayOfString)
  {
    this.mIntent.putExtra("android.intent.extra.BCC", paramArrayOfString);
    return this;
  }
  
  public IntentBuilder setEmailCc(String[] paramArrayOfString)
  {
    this.mIntent.putExtra("android.intent.extra.CC", paramArrayOfString);
    return this;
  }
  
  public IntentBuilder setEmailTo(String[] paramArrayOfString)
  {
    if (this.mToAddresses != null) {
      this.mToAddresses = null;
    }
    this.mIntent.putExtra("android.intent.extra.EMAIL", paramArrayOfString);
    return this;
  }
  
  public IntentBuilder setHtmlText(String paramString)
  {
    this.mIntent.putExtra("android.intent.extra.HTML_TEXT", paramString);
    if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
      setText(Html.fromHtml(paramString));
    }
    return this;
  }
  
  public IntentBuilder setStream(Uri paramUri)
  {
    if (!this.mIntent.getAction().equals("android.intent.action.SEND")) {
      this.mIntent.setAction("android.intent.action.SEND");
    }
    this.mStreams = null;
    this.mIntent.putExtra("android.intent.extra.STREAM", paramUri);
    return this;
  }
  
  public IntentBuilder setSubject(String paramString)
  {
    this.mIntent.putExtra("android.intent.extra.SUBJECT", paramString);
    return this;
  }
  
  public IntentBuilder setText(CharSequence paramCharSequence)
  {
    this.mIntent.putExtra("android.intent.extra.TEXT", paramCharSequence);
    return this;
  }
  
  public IntentBuilder setType(String paramString)
  {
    this.mIntent.setType(paramString);
    return this;
  }
  
  public void startChooser()
  {
    this.mActivity.startActivity(createChooserIntent());
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\app\ShareCompat$IntentBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */