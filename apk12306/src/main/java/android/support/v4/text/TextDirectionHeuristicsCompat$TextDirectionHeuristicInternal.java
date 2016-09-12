package android.support.v4.text;

class TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal
  extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
{
  private final boolean mDefaultIsRtl;
  
  private TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm, boolean paramBoolean)
  {
    super(paramTextDirectionAlgorithm);
    this.mDefaultIsRtl = paramBoolean;
  }
  
  protected boolean defaultIsRtl()
  {
    return this.mDefaultIsRtl;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\text\TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */