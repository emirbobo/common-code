package com.google.common.net;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated=true)
public class InternetDomainName
{
  private static final CharMatcher DASH_MATCHER = CharMatcher.anyOf("-_");
  private static final CharMatcher DOTS_MATCHER;
  private static final Joiner DOT_JOINER;
  private static final String DOT_REGEX = "\\.";
  private static final Splitter DOT_SPLITTER;
  private static final int MAX_DOMAIN_PART_LENGTH = 63;
  private static final int MAX_LENGTH = 253;
  private static final int MAX_PARTS = 127;
  private static final int NO_PUBLIC_SUFFIX_FOUND = -1;
  private static final CharMatcher PART_CHAR_MATCHER = CharMatcher.JAVA_LETTER_OR_DIGIT.or(DASH_MATCHER);
  private final String name;
  private final ImmutableList<String> parts;
  private final int publicSuffixIndex;
  
  static
  {
    JniLib.a(InternetDomainName.class, 855);
    DOTS_MATCHER = CharMatcher.anyOf(".。．｡");
    DOT_SPLITTER = Splitter.on('.');
    DOT_JOINER = Joiner.on('.');
  }
  
  private InternetDomainName(String paramString)
  {
    String str = Ascii.toLowerCase(DOTS_MATCHER.replaceFrom(paramString, '.'));
    paramString = str;
    if (str.endsWith(".")) {
      paramString = str.substring(0, str.length() - 1);
    }
    if (paramString.length() <= 253)
    {
      bool = true;
      Preconditions.checkArgument(bool, "Domain name too long: '%s':", new Object[] { paramString });
      this.name = paramString;
      this.parts = ImmutableList.copyOf(DOT_SPLITTER.split(paramString));
      if (this.parts.size() > 127) {
        break label147;
      }
    }
    label147:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Domain has too many parts: '%s'", new Object[] { paramString });
      Preconditions.checkArgument(validateSyntax(this.parts), "Not a valid domain name: '%s'", new Object[] { paramString });
      this.publicSuffixIndex = findPublicSuffix();
      return;
      bool = false;
      break;
    }
  }
  
  private native InternetDomainName ancestor(int paramInt);
  
  private native int findPublicSuffix();
  
  public static native InternetDomainName fromLenient(String paramString);
  
  public static native boolean isValidLenient(String paramString);
  
  private static native boolean matchesWildcardPublicSuffix(String paramString);
  
  private static native boolean validatePart(String paramString, boolean paramBoolean);
  
  private static native boolean validateSyntax(List<String> paramList);
  
  public native InternetDomainName child(String paramString);
  
  public native boolean equals(@Nullable Object paramObject);
  
  native InternetDomainName fromInternal(String paramString);
  
  public native boolean hasParent();
  
  public native boolean hasPublicSuffix();
  
  public native int hashCode();
  
  public native boolean isPublicSuffix();
  
  public native boolean isTopPrivateDomain();
  
  public native boolean isUnderPublicSuffix();
  
  public native String name();
  
  public native InternetDomainName parent();
  
  public native ImmutableList<String> parts();
  
  public native InternetDomainName publicSuffix();
  
  public native String toString();
  
  public native InternetDomainName topPrivateDomain();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\net\InternetDomainName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */