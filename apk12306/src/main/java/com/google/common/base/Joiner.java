package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public class Joiner
{
  private final String separator;
  
  static
  {
    JniLib.a(Joiner.class, 289);
  }
  
  private Joiner(Joiner paramJoiner)
  {
    this.separator = paramJoiner.separator;
  }
  
  private Joiner(String paramString)
  {
    this.separator = ((String)Preconditions.checkNotNull(paramString));
  }
  
  private static native Iterable<Object> iterable(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject);
  
  public static native Joiner on(char paramChar);
  
  public static native Joiner on(String paramString);
  
  public native <A extends Appendable> A appendTo(A paramA, Iterable<?> paramIterable)
    throws IOException;
  
  public final <A extends Appendable> A appendTo(A paramA, @Nullable Object paramObject1, @Nullable Object paramObject2, Object... paramVarArgs)
    throws IOException
  {
    return appendTo(paramA, iterable(paramObject1, paramObject2, paramVarArgs));
  }
  
  public final native <A extends Appendable> A appendTo(A paramA, Object[] paramArrayOfObject)
    throws IOException;
  
  public final native StringBuilder appendTo(StringBuilder paramStringBuilder, Iterable<?> paramIterable);
  
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, @Nullable Object paramObject1, @Nullable Object paramObject2, Object... paramVarArgs)
  {
    return appendTo(paramStringBuilder, iterable(paramObject1, paramObject2, paramVarArgs));
  }
  
  public final native StringBuilder appendTo(StringBuilder paramStringBuilder, Object[] paramArrayOfObject);
  
  public final native String join(Iterable<?> paramIterable);
  
  public final String join(@Nullable Object paramObject1, @Nullable Object paramObject2, Object... paramVarArgs)
  {
    return join(iterable(paramObject1, paramObject2, paramVarArgs));
  }
  
  public final native String join(Object[] paramArrayOfObject);
  
  public native Joiner skipNulls();
  
  native CharSequence toString(Object paramObject);
  
  public native Joiner useForNull(String paramString);
  
  public native MapJoiner withKeyValueSeparator(String paramString);
  
  public static final class MapJoiner
  {
    private final Joiner joiner;
    private final String keyValueSeparator;
    
    static
    {
      JniLib.a(MapJoiner.class, 293);
    }
    
    private MapJoiner(Joiner paramJoiner, String paramString)
    {
      this.joiner = paramJoiner;
      this.keyValueSeparator = ((String)Preconditions.checkNotNull(paramString));
    }
    
    public native <A extends Appendable> A appendTo(A paramA, Map<?, ?> paramMap)
      throws IOException;
    
    public native StringBuilder appendTo(StringBuilder paramStringBuilder, Map<?, ?> paramMap);
    
    public native String join(Map<?, ?> paramMap);
    
    public native MapJoiner useForNull(String paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Joiner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */