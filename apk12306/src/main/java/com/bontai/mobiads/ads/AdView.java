package com.bontai.mobiads.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class AdView
  extends RelativeLayout
{
  protected String keyWord;
  protected String userBirthday;
  protected String userGender;
  protected String userPostcode;
  
  public AdView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setKeyword(String paramString)
  {
    this.keyWord = paramString;
  }
  
  public void setUserBirthdayStr(String paramString)
  {
    this.userBirthday = paramString;
  }
  
  public void setUserGender(String paramString)
  {
    this.userGender = paramString;
  }
  
  public void setUserPostcode(String paramString)
  {
    this.userPostcode = paramString;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\AdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */