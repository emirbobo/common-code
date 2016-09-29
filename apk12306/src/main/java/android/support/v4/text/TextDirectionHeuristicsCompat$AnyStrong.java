package android.support.v4.text;

class TextDirectionHeuristicsCompat$AnyStrong
  implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
{
  public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
  public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
  private final boolean mLookForRtl;
  
  private TextDirectionHeuristicsCompat$AnyStrong(boolean paramBoolean)
  {
    this.mLookForRtl = paramBoolean;
  }
  
  public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int k = 1;
    int i = 0;
    int j = paramInt1;
    for (;;)
    {
      if (j < paramInt1 + paramInt2) {
        switch (TextDirectionHeuristicsCompat.access$200(Character.getDirectionality(paramCharSequence.charAt(j))))
        {
        default: 
          j++;
          break;
        case 0: 
          if (this.mLookForRtl) {
            i = 0;
          }
          break;
        }
      }
    }
    for (;;)
    {
      return i;
      i = 1;
      break;
      i = k;
      if (this.mLookForRtl)
      {
        i = 1;
        break;
        if (i != 0)
        {
          i = k;
          if (!this.mLookForRtl) {
            i = 0;
          }
        }
        else
        {
          i = 2;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\text\TextDirectionHeuristicsCompat$AnyStrong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */