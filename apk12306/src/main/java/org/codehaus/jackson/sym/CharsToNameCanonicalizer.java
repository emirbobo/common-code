package org.codehaus.jackson.sym;

import java.util.Arrays;
import org.codehaus.jackson.util.InternCache;

public final class CharsToNameCanonicalizer
{
  protected static final int DEFAULT_TABLE_SIZE = 64;
  static final int MAX_ENTRIES_FOR_REUSE = 12000;
  protected static final int MAX_TABLE_SIZE = 65536;
  static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
  protected Bucket[] _buckets;
  protected final boolean _canonicalize;
  protected boolean _dirty;
  protected int _indexMask;
  protected final boolean _intern;
  protected CharsToNameCanonicalizer _parent;
  protected int _size;
  protected int _sizeThreshold;
  protected String[] _symbols;
  
  private CharsToNameCanonicalizer()
  {
    this._canonicalize = true;
    this._intern = true;
    this._dirty = true;
    initTables(64);
  }
  
  private CharsToNameCanonicalizer(CharsToNameCanonicalizer paramCharsToNameCanonicalizer, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, Bucket[] paramArrayOfBucket, int paramInt)
  {
    this._parent = paramCharsToNameCanonicalizer;
    this._canonicalize = paramBoolean1;
    this._intern = paramBoolean2;
    this._symbols = paramArrayOfString;
    this._buckets = paramArrayOfBucket;
    this._size = paramInt;
    paramInt = paramArrayOfString.length;
    this._sizeThreshold = (paramInt - (paramInt >> 2));
    this._indexMask = (paramInt - 1);
    this._dirty = false;
  }
  
  public static int calcHash(String paramString)
  {
    int j = paramString.charAt(0);
    int i = 1;
    int k = paramString.length();
    while (i < k)
    {
      j = j * 31 + paramString.charAt(i);
      i++;
    }
    return j;
  }
  
  public static int calcHash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfChar[0];
    for (paramInt1 = 1; paramInt1 < paramInt2; paramInt1++) {
      i = i * 31 + paramArrayOfChar[paramInt1];
    }
    return i;
  }
  
  private void copyArrays()
  {
    Object localObject = this._symbols;
    int i = localObject.length;
    this._symbols = new String[i];
    System.arraycopy(localObject, 0, this._symbols, 0, i);
    localObject = this._buckets;
    i = localObject.length;
    this._buckets = new Bucket[i];
    System.arraycopy(localObject, 0, this._buckets, 0, i);
  }
  
  public static CharsToNameCanonicalizer createRoot()
  {
    return sBootstrapSymbolTable.makeOrphan();
  }
  
  private void initTables(int paramInt)
  {
    this._symbols = new String[paramInt];
    this._buckets = new Bucket[paramInt >> 1];
    this._indexMask = (paramInt - 1);
    this._size = 0;
    this._sizeThreshold = (paramInt - (paramInt >> 2));
  }
  
  private CharsToNameCanonicalizer makeOrphan()
  {
    return new CharsToNameCanonicalizer(null, true, true, this._symbols, this._buckets, this._size);
  }
  
  /* Error */
  private void mergeChild(CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 92	org/codehaus/jackson/sym/CharsToNameCanonicalizer:size	()I
    //   6: sipush 12000
    //   9: if_icmple +17 -> 26
    //   12: aload_0
    //   13: bipush 64
    //   15: invokespecial 47	org/codehaus/jackson/sym/CharsToNameCanonicalizer:initTables	(I)V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 43	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_dirty	Z
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_1
    //   27: invokevirtual 92	org/codehaus/jackson/sym/CharsToNameCanonicalizer:size	()I
    //   30: aload_0
    //   31: invokevirtual 92	org/codehaus/jackson/sym/CharsToNameCanonicalizer:size	()I
    //   34: if_icmple -11 -> 23
    //   37: aload_0
    //   38: aload_1
    //   39: getfield 52	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_symbols	[Ljava/lang/String;
    //   42: putfield 52	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_symbols	[Ljava/lang/String;
    //   45: aload_0
    //   46: aload_1
    //   47: getfield 54	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_buckets	[Lorg/codehaus/jackson/sym/CharsToNameCanonicalizer$Bucket;
    //   50: putfield 54	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_buckets	[Lorg/codehaus/jackson/sym/CharsToNameCanonicalizer$Bucket;
    //   53: aload_0
    //   54: aload_1
    //   55: getfield 56	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_size	I
    //   58: putfield 56	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_size	I
    //   61: aload_0
    //   62: aload_1
    //   63: getfield 58	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_sizeThreshold	I
    //   66: putfield 58	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_sizeThreshold	I
    //   69: aload_0
    //   70: aload_1
    //   71: getfield 60	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_indexMask	I
    //   74: putfield 60	org/codehaus/jackson/sym/CharsToNameCanonicalizer:_indexMask	I
    //   77: goto -59 -> 18
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	CharsToNameCanonicalizer
    //   0	85	1	paramCharsToNameCanonicalizer	CharsToNameCanonicalizer
    // Exception table:
    //   from	to	target	type
    //   2	18	80	finally
    //   18	23	80	finally
    //   26	77	80	finally
  }
  
  private void rehash()
  {
    int m = this._symbols.length;
    int i = m + m;
    if (i > 65536)
    {
      this._size = 0;
      Arrays.fill(this._symbols, null);
      Arrays.fill(this._buckets, null);
      this._dirty = true;
    }
    label159:
    do
    {
      return;
      Object localObject2 = this._symbols;
      Bucket[] arrayOfBucket = this._buckets;
      this._symbols = new String[i];
      this._buckets = new Bucket[i >> 1];
      this._indexMask = (i - 1);
      this._sizeThreshold += this._sizeThreshold;
      i = 0;
      int j = 0;
      Object localObject1;
      int k;
      if (j < m)
      {
        localObject1 = localObject2[j];
        k = i;
        if (localObject1 != null)
        {
          k = i + 1;
          i = calcHash((String)localObject1) & this._indexMask;
          if (this._symbols[i] != null) {
            break label159;
          }
          this._symbols[i] = localObject1;
        }
        for (;;)
        {
          j++;
          i = k;
          break;
          i >>= 1;
          this._buckets[i] = new Bucket((String)localObject1, this._buckets[i]);
        }
      }
      for (j = 0; j < m >> 1; j++)
      {
        localObject1 = arrayOfBucket[j];
        if (localObject1 != null)
        {
          i++;
          localObject2 = ((Bucket)localObject1).getSymbol();
          k = calcHash((String)localObject2) & this._indexMask;
          if (this._symbols[k] == null) {
            this._symbols[k] = localObject2;
          }
          for (;;)
          {
            localObject1 = ((Bucket)localObject1).getNext();
            break;
            k >>= 1;
            this._buckets[k] = new Bucket((String)localObject2, this._buckets[k]);
          }
        }
      }
    } while (i == this._size);
    throw new Error("Internal error on SymbolTable.rehash(): had " + this._size + " entries; now have " + i + ".");
  }
  
  public String findSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramInt2 < 1) {
      localObject = "";
    }
    int j;
    label69:
    label85:
    String str;
    do
    {
      for (;;)
      {
        return (String)localObject;
        if (this._canonicalize) {
          break;
        }
        localObject = new String(paramArrayOfChar, paramInt1, paramInt2);
      }
      j = paramInt3 & this._indexMask;
      localObject = this._symbols[j];
      if (localObject == null) {
        break;
      }
      if (((String)localObject).length() == paramInt2)
      {
        paramInt3 = 0;
        if (((String)localObject).charAt(paramInt3) == paramArrayOfChar[(paramInt1 + paramInt3)]) {
          break label211;
        }
        if (paramInt3 == paramInt2) {
          break label232;
        }
      }
      localObject = this._buckets[(j >> 1)];
      if (localObject == null) {
        break;
      }
      str = ((Bucket)localObject).find(paramArrayOfChar, paramInt1, paramInt2);
      localObject = str;
    } while (str != null);
    if (!this._dirty)
    {
      copyArrays();
      this._dirty = true;
      paramInt3 = j;
      label146:
      this._size += 1;
      localObject = new String(paramArrayOfChar, paramInt1, paramInt2);
      paramArrayOfChar = (char[])localObject;
      if (this._intern) {
        paramArrayOfChar = InternCache.instance.intern((String)localObject);
      }
      if (this._symbols[paramInt3] != null) {
        break label269;
      }
      this._symbols[paramInt3] = paramArrayOfChar;
    }
    for (;;)
    {
      localObject = paramArrayOfChar;
      break;
      label211:
      int i = paramInt3 + 1;
      paramInt3 = i;
      if (i < paramInt2) {
        break label69;
      }
      paramInt3 = i;
      break label85;
      label232:
      break;
      paramInt3 = j;
      if (this._size < this._sizeThreshold) {
        break label146;
      }
      rehash();
      paramInt3 = calcHash(paramArrayOfChar, paramInt1, paramInt2) & this._indexMask;
      break label146;
      label269:
      paramInt1 = paramInt3 >> 1;
      this._buckets[paramInt1] = new Bucket(paramArrayOfChar, this._buckets[paramInt1]);
    }
  }
  
  public CharsToNameCanonicalizer makeChild(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      CharsToNameCanonicalizer localCharsToNameCanonicalizer = new CharsToNameCanonicalizer(this, paramBoolean1, paramBoolean2, this._symbols, this._buckets, this._size);
      return localCharsToNameCanonicalizer;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean maybeDirty()
  {
    return this._dirty;
  }
  
  public void release()
  {
    if (!maybeDirty()) {}
    for (;;)
    {
      return;
      if (this._parent != null)
      {
        this._parent.mergeChild(this);
        this._dirty = false;
      }
    }
  }
  
  public int size()
  {
    return this._size;
  }
  
  static final class Bucket
  {
    private final String _symbol;
    private final Bucket mNext;
    
    public Bucket(String paramString, Bucket paramBucket)
    {
      this._symbol = paramString;
      this.mNext = paramBucket;
    }
    
    public String find(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      String str = this._symbol;
      for (Bucket localBucket = this.mNext;; localBucket = localBucket.getNext())
      {
        int i;
        if (str.length() == paramInt2)
        {
          i = 0;
          if (str.charAt(i) != paramArrayOfChar[(paramInt1 + i)]) {
            label40:
            if (i != paramInt2) {
              break label72;
            }
          }
        }
        for (;;)
        {
          return str;
          int j = i + 1;
          i = j;
          if (j < paramInt2) {
            break;
          }
          i = j;
          break label40;
          label72:
          if (localBucket != null) {
            break label83;
          }
          str = null;
        }
        label83:
        str = localBucket.getSymbol();
      }
    }
    
    public Bucket getNext()
    {
      return this.mNext;
    }
    
    public String getSymbol()
    {
      return this._symbol;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\sym\CharsToNameCanonicalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */