package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import java.util.List;

@Beta
@GwtCompatible
public abstract class CharMatcher
  implements Predicate<Character>
{
  public static final CharMatcher ANY = new CharMatcher()
  {
    static
    {
      JniLib.a(6.class, 268);
    }
    
    public native CharMatcher and(CharMatcher paramAnonymousCharMatcher);
    
    public native String collapseFrom(CharSequence paramAnonymousCharSequence, char paramAnonymousChar);
    
    public native int countIn(CharSequence paramAnonymousCharSequence);
    
    public native int indexIn(CharSequence paramAnonymousCharSequence);
    
    public native int indexIn(CharSequence paramAnonymousCharSequence, int paramAnonymousInt);
    
    public native int lastIndexIn(CharSequence paramAnonymousCharSequence);
    
    public native boolean matches(char paramAnonymousChar);
    
    public native boolean matchesAllOf(CharSequence paramAnonymousCharSequence);
    
    public native boolean matchesNoneOf(CharSequence paramAnonymousCharSequence);
    
    public native CharMatcher negate();
    
    public native CharMatcher or(CharMatcher paramAnonymousCharMatcher);
    
    public native CharMatcher precomputed();
    
    public native String removeFrom(CharSequence paramAnonymousCharSequence);
    
    public native String replaceFrom(CharSequence paramAnonymousCharSequence, char paramAnonymousChar);
    
    public native String replaceFrom(CharSequence paramAnonymousCharSequence1, CharSequence paramAnonymousCharSequence2);
    
    public native String trimFrom(CharSequence paramAnonymousCharSequence);
  };
  public static final CharMatcher ASCII;
  public static final CharMatcher BREAKING_WHITESPACE;
  private static final String BREAKING_WHITESPACE_CHARS = "\t\n\013\f\r     　";
  public static final CharMatcher DIGIT;
  public static final CharMatcher INVISIBLE;
  public static final CharMatcher JAVA_DIGIT;
  public static final CharMatcher JAVA_ISO_CONTROL;
  public static final CharMatcher JAVA_LETTER;
  public static final CharMatcher JAVA_LETTER_OR_DIGIT;
  public static final CharMatcher JAVA_LOWER_CASE;
  public static final CharMatcher JAVA_UPPER_CASE;
  public static final CharMatcher JAVA_WHITESPACE;
  public static final CharMatcher NONE = new CharMatcher()
  {
    static
    {
      JniLib.a(7.class, 269);
    }
    
    public native CharMatcher and(CharMatcher paramAnonymousCharMatcher);
    
    public native String collapseFrom(CharSequence paramAnonymousCharSequence, char paramAnonymousChar);
    
    public native int countIn(CharSequence paramAnonymousCharSequence);
    
    public native int indexIn(CharSequence paramAnonymousCharSequence);
    
    public native int indexIn(CharSequence paramAnonymousCharSequence, int paramAnonymousInt);
    
    public native int lastIndexIn(CharSequence paramAnonymousCharSequence);
    
    public native boolean matches(char paramAnonymousChar);
    
    public native boolean matchesAllOf(CharSequence paramAnonymousCharSequence);
    
    public native boolean matchesNoneOf(CharSequence paramAnonymousCharSequence);
    
    public native CharMatcher negate();
    
    public native CharMatcher or(CharMatcher paramAnonymousCharMatcher);
    
    public native CharMatcher precomputed();
    
    public native String removeFrom(CharSequence paramAnonymousCharSequence);
    
    public native String replaceFrom(CharSequence paramAnonymousCharSequence, char paramAnonymousChar);
    
    public native String replaceFrom(CharSequence paramAnonymousCharSequence1, CharSequence paramAnonymousCharSequence2);
    
    native void setBits(CharMatcher.LookupTable paramAnonymousLookupTable);
    
    public native String trimFrom(CharSequence paramAnonymousCharSequence);
  };
  private static final String NON_BREAKING_WHITESPACE_CHARS = " ᠎ ";
  public static final CharMatcher SINGLE_WIDTH;
  public static final CharMatcher WHITESPACE = anyOf("\t\n\013\f\r     　 ᠎ ").or(inRange(' ', ' ')).precomputed();
  
  static
  {
    BREAKING_WHITESPACE = anyOf("\t\n\013\f\r     　").or(inRange(' ', ' ')).or(inRange(' ', ' ')).precomputed();
    ASCII = inRange('\000', '');
    CharMatcher localCharMatcher = inRange('0', '9');
    for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
      localCharMatcher = localCharMatcher.or(inRange(c, (char)(c + '\t')));
    }
    DIGIT = localCharMatcher.precomputed();
    JAVA_WHITESPACE = inRange('\t', '\r').or(inRange('\034', ' ')).or(is(' ')).or(is('᠎')).or(inRange(' ', ' ')).or(inRange(' ', '​')).or(inRange(' ', ' ')).or(is(' ')).or(is('　')).precomputed();
    JAVA_DIGIT = new CharMatcher()
    {
      static
      {
        JniLib.a(1.class, 263);
      }
      
      public native boolean matches(char paramAnonymousChar);
    };
    JAVA_LETTER = new CharMatcher()
    {
      static
      {
        JniLib.a(2.class, 264);
      }
      
      public native boolean matches(char paramAnonymousChar);
    };
    JAVA_LETTER_OR_DIGIT = new CharMatcher()
    {
      static
      {
        JniLib.a(3.class, 265);
      }
      
      public native boolean matches(char paramAnonymousChar);
    };
    JAVA_UPPER_CASE = new CharMatcher()
    {
      static
      {
        JniLib.a(4.class, 266);
      }
      
      public native boolean matches(char paramAnonymousChar);
    };
    JAVA_LOWER_CASE = new CharMatcher()
    {
      static
      {
        JniLib.a(5.class, 267);
      }
      
      public native boolean matches(char paramAnonymousChar);
    };
    JAVA_ISO_CONTROL = inRange('\000', '\037').or(inRange('', ''));
    INVISIBLE = inRange('\000', ' ').or(inRange('', ' ')).or(is('­')).or(inRange('؀', '؃')).or(anyOf("۝܏ ឴឵᠎")).or(inRange(' ', '‏')).or(inRange(' ', ' ')).or(inRange(' ', '⁤')).or(inRange('⁪', '⁯')).or(is('　')).or(inRange(55296, 63743)).or(anyOf("﻿￹￺￻")).precomputed();
    SINGLE_WIDTH = inRange('\000', 'ӹ').or(is('־')).or(inRange('א', 'ת')).or(is('׳')).or(is('״')).or(inRange('؀', 'ۿ')).or(inRange('ݐ', 'ݿ')).or(inRange('฀', '๿')).or(inRange('Ḁ', '₯')).or(inRange('℀', '℺')).or(inRange(64336, 65023)).or(inRange(65136, 65279)).or(inRange(65377, 65500)).precomputed();
  }
  
  public static CharMatcher anyOf(CharSequence paramCharSequence)
  {
    switch (paramCharSequence.length())
    {
    default: 
      paramCharSequence = paramCharSequence.toString().toCharArray();
      Arrays.sort(paramCharSequence);
      paramCharSequence = new CharMatcher()
      {
        static
        {
          JniLib.a(11.class, 258);
        }
        
        public native boolean matches(char paramAnonymousChar);
        
        native void setBits(CharMatcher.LookupTable paramAnonymousLookupTable);
      };
    }
    for (;;)
    {
      return paramCharSequence;
      paramCharSequence = NONE;
      continue;
      paramCharSequence = is(paramCharSequence.charAt(0));
      continue;
      paramCharSequence = new CharMatcher()
      {
        static
        {
          JniLib.a(10.class, 257);
        }
        
        public native boolean matches(char paramAnonymousChar);
        
        public native CharMatcher precomputed();
        
        native void setBits(CharMatcher.LookupTable paramAnonymousLookupTable);
      };
    }
  }
  
  public static CharMatcher forPredicate(Predicate<? super Character> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    if ((paramPredicate instanceof CharMatcher)) {}
    for (paramPredicate = (CharMatcher)paramPredicate;; paramPredicate = new CharMatcher()
        {
          static
          {
            JniLib.a(13.class, 260);
          }
          
          public native boolean apply(Character paramAnonymousCharacter);
          
          public native boolean matches(char paramAnonymousChar);
        }) {
      return paramPredicate;
    }
  }
  
  public static CharMatcher inRange(char paramChar1, char paramChar2)
  {
    if (paramChar2 >= paramChar1) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      new CharMatcher()
      {
        static
        {
          JniLib.a(12.class, 259);
        }
        
        public native boolean matches(char paramAnonymousChar);
        
        public native CharMatcher precomputed();
        
        native void setBits(CharMatcher.LookupTable paramAnonymousLookupTable);
      };
    }
  }
  
  public static CharMatcher is(char paramChar)
  {
    new CharMatcher()
    {
      static
      {
        JniLib.a(8.class, 270);
      }
      
      public native CharMatcher and(CharMatcher paramAnonymousCharMatcher);
      
      public native boolean matches(char paramAnonymousChar);
      
      public native CharMatcher negate();
      
      public native CharMatcher or(CharMatcher paramAnonymousCharMatcher);
      
      public native CharMatcher precomputed();
      
      public native String replaceFrom(CharSequence paramAnonymousCharSequence, char paramAnonymousChar);
      
      native void setBits(CharMatcher.LookupTable paramAnonymousLookupTable);
    };
  }
  
  public static CharMatcher isNot(char paramChar)
  {
    new CharMatcher()
    {
      static
      {
        JniLib.a(9.class, 271);
      }
      
      public native CharMatcher and(CharMatcher paramAnonymousCharMatcher);
      
      public native boolean matches(char paramAnonymousChar);
      
      public native CharMatcher negate();
      
      public native CharMatcher or(CharMatcher paramAnonymousCharMatcher);
    };
  }
  
  public static CharMatcher noneOf(CharSequence paramCharSequence)
  {
    return anyOf(paramCharSequence).negate();
  }
  
  public CharMatcher and(CharMatcher paramCharMatcher)
  {
    return new And(Arrays.asList(new CharMatcher[] { this, (CharMatcher)Preconditions.checkNotNull(paramCharMatcher) }));
  }
  
  public boolean apply(Character paramCharacter)
  {
    return matches(paramCharacter.charValue());
  }
  
  public String collapseFrom(CharSequence paramCharSequence, char paramChar)
  {
    int i = indexIn(paramCharSequence);
    if (i == -1) {}
    StringBuilder localStringBuilder;
    for (paramCharSequence = paramCharSequence.toString();; paramCharSequence = localStringBuilder.toString())
    {
      return paramCharSequence;
      localStringBuilder = new StringBuilder(paramCharSequence.length()).append(paramCharSequence.subSequence(0, i)).append(paramChar);
      int k = 1;
      int j = i + 1;
      if (j < paramCharSequence.length())
      {
        char c = paramCharSequence.charAt(j);
        if (apply(Character.valueOf(c)))
        {
          i = k;
          if (k == 0) {
            localStringBuilder.append(paramChar);
          }
        }
        for (i = 1;; i = 0)
        {
          j++;
          k = i;
          break;
          localStringBuilder.append(c);
        }
      }
    }
  }
  
  public int countIn(CharSequence paramCharSequence)
  {
    int k = 0;
    int i = 0;
    while (i < paramCharSequence.length())
    {
      int j = k;
      if (matches(paramCharSequence.charAt(i))) {
        j = k + 1;
      }
      i++;
      k = j;
    }
    return k;
  }
  
  public int indexIn(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    int i = 0;
    if (i < j) {
      if (!matches(paramCharSequence.charAt(i))) {}
    }
    for (;;)
    {
      return i;
      i++;
      break;
      i = -1;
    }
  }
  
  public int indexIn(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    Preconditions.checkPositionIndex(paramInt, i);
    if (paramInt < i) {
      if (!matches(paramCharSequence.charAt(paramInt))) {}
    }
    for (;;)
    {
      return paramInt;
      paramInt++;
      break;
      paramInt = -1;
    }
  }
  
  public int lastIndexIn(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length() - 1;
    if (i >= 0) {
      if (!matches(paramCharSequence.charAt(i))) {}
    }
    for (;;)
    {
      return i;
      i--;
      break;
      i = -1;
    }
  }
  
  public abstract boolean matches(char paramChar);
  
  public boolean matchesAllOf(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length() - 1;
    if (i >= 0) {
      if (matches(paramCharSequence.charAt(i))) {}
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      i--;
      break;
    }
  }
  
  public boolean matchesAnyOf(CharSequence paramCharSequence)
  {
    if (!matchesNoneOf(paramCharSequence)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean matchesNoneOf(CharSequence paramCharSequence)
  {
    if (indexIn(paramCharSequence) == -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public CharMatcher negate()
  {
    new CharMatcher()
    {
      static
      {
        JniLib.a(14.class, 261);
      }
      
      public native int countIn(CharSequence paramAnonymousCharSequence);
      
      public native boolean matches(char paramAnonymousChar);
      
      public native boolean matchesAllOf(CharSequence paramAnonymousCharSequence);
      
      public native boolean matchesNoneOf(CharSequence paramAnonymousCharSequence);
      
      public native CharMatcher negate();
    };
  }
  
  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    return new Or(Arrays.asList(new CharMatcher[] { this, (CharMatcher)Preconditions.checkNotNull(paramCharMatcher) }));
  }
  
  public CharMatcher precomputed()
  {
    return Platform.precomputeCharMatcher(this);
  }
  
  CharMatcher precomputedInternal()
  {
    final LookupTable localLookupTable = new LookupTable(null);
    setBits(localLookupTable);
    new CharMatcher()
    {
      static
      {
        JniLib.a(15.class, 262);
      }
      
      public native boolean matches(char paramAnonymousChar);
      
      public native CharMatcher precomputed();
    };
  }
  
  public String removeFrom(CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString();
    int i = indexIn(paramCharSequence);
    if (i == -1) {
      return paramCharSequence;
    }
    paramCharSequence = paramCharSequence.toCharArray();
    int j = 1;
    label25:
    i++;
    for (;;)
    {
      if (i == paramCharSequence.length)
      {
        paramCharSequence = new String(paramCharSequence, 0, i - j);
        break;
      }
      if (matches(paramCharSequence[i]))
      {
        j++;
        break label25;
      }
      paramCharSequence[(i - j)] = paramCharSequence[i];
      i++;
    }
  }
  
  public String replaceFrom(CharSequence paramCharSequence, char paramChar)
  {
    paramCharSequence = paramCharSequence.toString();
    int i = indexIn(paramCharSequence);
    if (i == -1) {}
    for (;;)
    {
      return paramCharSequence;
      paramCharSequence = paramCharSequence.toCharArray();
      paramCharSequence[i] = ((char)paramChar);
      i++;
      while (i < paramCharSequence.length)
      {
        if (matches(paramCharSequence[i])) {
          paramCharSequence[i] = ((char)paramChar);
        }
        i++;
      }
      paramCharSequence = new String(paramCharSequence);
    }
  }
  
  public String replaceFrom(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i = paramCharSequence2.length();
    if (i == 0) {
      paramCharSequence1 = removeFrom(paramCharSequence1);
    }
    for (;;)
    {
      return paramCharSequence1;
      if (i == 1)
      {
        paramCharSequence1 = replaceFrom(paramCharSequence1, paramCharSequence2.charAt(0));
      }
      else
      {
        String str = paramCharSequence1.toString();
        i = indexIn(str);
        paramCharSequence1 = str;
        if (i != -1)
        {
          int n = str.length();
          paramCharSequence1 = new StringBuilder(n * 3 / 2 + 16);
          int j = 0;
          int k;
          int m;
          do
          {
            paramCharSequence1.append(str, j, i);
            paramCharSequence1.append(paramCharSequence2);
            k = i + 1;
            m = indexIn(str, k);
            j = k;
            i = m;
          } while (m != -1);
          paramCharSequence1.append(str, k, n);
          paramCharSequence1 = paramCharSequence1.toString();
        }
      }
    }
  }
  
  public String retainFrom(CharSequence paramCharSequence)
  {
    return negate().removeFrom(paramCharSequence);
  }
  
  void setBits(LookupTable paramLookupTable)
  {
    int j = 0;
    for (int i = j;; i = j)
    {
      if (matches(i)) {
        paramLookupTable.set(i);
      }
      j = (char)(i + 1);
      if (i == 65535) {
        return;
      }
    }
  }
  
  public String trimAndCollapseFrom(CharSequence paramCharSequence, char paramChar)
  {
    int k = negate().indexIn(paramCharSequence);
    if (k == -1) {}
    StringBuilder localStringBuilder;
    for (paramCharSequence = "";; paramCharSequence = localStringBuilder.toString())
    {
      return paramCharSequence;
      localStringBuilder = new StringBuilder(paramCharSequence.length());
      int i = 0;
      if (k < paramCharSequence.length())
      {
        char c = paramCharSequence.charAt(k);
        if (apply(Character.valueOf(c))) {}
        int j;
        for (i = 1;; i = j)
        {
          k++;
          break;
          j = i;
          if (i != 0)
          {
            localStringBuilder.append(paramChar);
            j = 0;
          }
          localStringBuilder.append(c);
        }
      }
    }
  }
  
  public String trimFrom(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    int i = 0;
    if ((i >= j) || (!matches(paramCharSequence.charAt(i)))) {
      j--;
    }
    for (;;)
    {
      if ((j <= i) || (!matches(paramCharSequence.charAt(j))))
      {
        return paramCharSequence.subSequence(i, j + 1).toString();
        i++;
        break;
      }
      j--;
    }
  }
  
  public String trimLeadingFrom(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    for (int i = 0;; i++) {
      if ((i >= j) || (!matches(paramCharSequence.charAt(i)))) {
        return paramCharSequence.subSequence(i, j).toString();
      }
    }
  }
  
  public String trimTrailingFrom(CharSequence paramCharSequence)
  {
    for (int i = paramCharSequence.length() - 1;; i--) {
      if ((i < 0) || (!matches(paramCharSequence.charAt(i)))) {
        return paramCharSequence.subSequence(0, i + 1).toString();
      }
    }
  }
  
  private static class And
    extends CharMatcher
  {
    List<CharMatcher> components;
    
    static
    {
      JniLib.a(And.class, 272);
    }
    
    And(List<CharMatcher> paramList)
    {
      this.components = paramList;
    }
    
    public native CharMatcher and(CharMatcher paramCharMatcher);
    
    public native boolean matches(char paramChar);
  }
  
  private static final class LookupTable
  {
    int[] data = new int['ࠀ'];
    
    static
    {
      JniLib.a(LookupTable.class, 273);
    }
    
    native boolean get(char paramChar);
    
    native void set(char paramChar);
  }
  
  private static class Or
    extends CharMatcher
  {
    List<CharMatcher> components;
    
    static
    {
      JniLib.a(Or.class, 274);
    }
    
    Or(List<CharMatcher> paramList)
    {
      this.components = paramList;
    }
    
    public native boolean matches(char paramChar);
    
    public native CharMatcher or(CharMatcher paramCharMatcher);
    
    native void setBits(CharMatcher.LookupTable paramLookupTable);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */