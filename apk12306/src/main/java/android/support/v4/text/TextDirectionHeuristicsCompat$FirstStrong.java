package android.support.v4.text;

class TextDirectionHeuristicsCompat$FirstStrong
  implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
{
  public static final FirstStrong INSTANCE = new FirstStrong();
  
  public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int j = 2;
    for (int i = paramInt1; (i < paramInt1 + paramInt2) && (j == 2); i++) {
      j = TextDirectionHeuristicsCompat.access$100(Character.getDirectionality(paramCharSequence.charAt(i)));
    }
    return j;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\text\TextDirectionHeuristicsCompat$FirstStrong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */