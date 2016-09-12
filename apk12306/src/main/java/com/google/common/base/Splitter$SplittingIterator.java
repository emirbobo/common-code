package com.google.common.base;

abstract class Splitter$SplittingIterator
  extends Splitter.AbstractIterator<String>
{
  int limit;
  int offset = 0;
  final boolean omitEmptyStrings;
  final CharSequence toSplit;
  final CharMatcher trimmer;
  
  protected Splitter$SplittingIterator(Splitter paramSplitter, CharSequence paramCharSequence)
  {
    super(null);
    this.trimmer = Splitter.access$200(paramSplitter);
    this.omitEmptyStrings = Splitter.access$300(paramSplitter);
    this.limit = Splitter.access$400(paramSplitter);
    this.toSplit = paramCharSequence;
  }
  
  protected String computeNext()
  {
    int k;
    int j;
    while (this.offset != -1)
    {
      k = this.offset;
      j = separatorStart(this.offset);
      int i;
      if (j == -1)
      {
        i = this.toSplit.length();
        this.offset = -1;
      }
      for (;;)
      {
        j = i;
        if (k >= i) {
          break;
        }
        j = i;
        if (!this.trimmer.matches(this.toSplit.charAt(k))) {
          break;
        }
        k++;
        continue;
        i = j;
        this.offset = separatorEnd(j);
      }
      while ((j > k) && (this.trimmer.matches(this.toSplit.charAt(j - 1)))) {
        j--;
      }
      if ((!this.omitEmptyStrings) || (k != j))
      {
        if (this.limit == 1)
        {
          i = this.toSplit.length();
          this.offset = -1;
          for (;;)
          {
            j = i;
            if (i <= k) {
              break;
            }
            j = i;
            if (!this.trimmer.matches(this.toSplit.charAt(i - 1))) {
              break;
            }
            i--;
          }
        }
        this.limit -= 1;
      }
    }
    for (String str = this.toSplit.subSequence(k, j).toString();; str = (String)endOfData()) {
      return str;
    }
  }
  
  abstract int separatorEnd(int paramInt);
  
  abstract int separatorStart(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Splitter$SplittingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */