package cn.domob.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import cn.domob.ui.utility.DDrawable;

public class ClearEditText
  extends EditText
  implements TextWatcher, View.OnFocusChangeListener
{
  private Drawable mClearDrawable;
  private SearchView.EditextChangeZeroListener mEditextChangeZeroListener;
  
  public ClearEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }
  
  public ClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mClearDrawable = getCompoundDrawables()[2];
    if (this.mClearDrawable == null) {
      this.mClearDrawable = getResources().getDrawable(DDrawable.getDrawableInt(getContext(), "u_progress_cancelbtn"));
    }
    this.mClearDrawable.setBounds(10, 0, this.mClearDrawable.getIntrinsicWidth() + 10, this.mClearDrawable.getIntrinsicHeight());
    setClearIconVisible(false);
    setOnFocusChangeListener(this);
    addTextChangedListener(this);
  }
  
  public static Animation shakeAnimation(int paramInt)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 10.0F, 0.0F, 0.0F);
    localTranslateAnimation.setInterpolator(new CycleInterpolator(paramInt));
    localTranslateAnimation.setDuration(1000L);
    return localTranslateAnimation;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean)
    {
      paramBoolean = bool;
      if (getText().length() > 0) {
        paramBoolean = true;
      }
      setClearIconVisible(paramBoolean);
    }
    for (;;)
    {
      return;
      setClearIconVisible(false);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      setClearIconVisible(bool);
      if ((this.mEditextChangeZeroListener != null) && (paramCharSequence.length() == 0)) {
        this.mEditextChangeZeroListener.textChange();
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    if ((getCompoundDrawables()[2] != null) && (paramMotionEvent.getAction() == 1)) {
      if ((paramMotionEvent.getX() <= getWidth() - getPaddingRight() - this.mClearDrawable.getIntrinsicWidth()) || (paramMotionEvent.getX() >= getWidth() - getPaddingRight())) {
        break label79;
      }
    }
    for (;;)
    {
      if (i != 0) {
        setText("");
      }
      return super.onTouchEvent(paramMotionEvent);
      label79:
      i = 0;
    }
  }
  
  protected void setClearIconVisible(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Drawable localDrawable = this.mClearDrawable;; localDrawable = null)
    {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
      return;
    }
  }
  
  public void setOnEditextChangeZeroListener(SearchView.EditextChangeZeroListener paramEditextChangeZeroListener)
  {
    this.mEditextChangeZeroListener = paramEditextChangeZeroListener;
  }
  
  public void setShakeAnimation()
  {
    setAnimation(shakeAnimation(5));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\ClearEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */