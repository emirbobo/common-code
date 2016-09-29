package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@GwtIncompatible("Only used by other GWT-incompatible code.")
class Predicates$ContainsPatternPredicate
  implements Predicate<CharSequence>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Pattern pattern;
  
  static
  {
    JniLib.a(ContainsPatternPredicate.class, 302);
  }
  
  Predicates$ContainsPatternPredicate(String paramString)
  {
    this(Pattern.compile(paramString));
  }
  
  Predicates$ContainsPatternPredicate(Pattern paramPattern)
  {
    this.pattern = ((Pattern)Preconditions.checkNotNull(paramPattern));
  }
  
  public native boolean apply(CharSequence paramCharSequence);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Predicates$ContainsPatternPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */