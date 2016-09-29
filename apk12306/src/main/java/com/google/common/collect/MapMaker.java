package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated=true)
public final class MapMaker
  extends GenericMapMaker<Object, Object>
{
  static final Executor DEFAULT_CLEANUP_EXECUTOR = new Executor()
  {
    static
    {
      JniLib.a(1.class, 609);
    }
    
    public native void execute(Runnable paramAnonymousRunnable);
  };
  private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
  private static final int DEFAULT_EXPIRATION_NANOS = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  static final Ticker DEFAULT_TICKER = new Ticker()
  {
    static
    {
      JniLib.a(2.class, 610);
    }
    
    public native long read();
  };
  static final int UNSET_INT = -1;
  Executor cleanupExecutor;
  int concurrencyLevel = -1;
  long expireAfterAccessNanos = -1L;
  long expireAfterWriteNanos = -1L;
  int initialCapacity = -1;
  Equivalence<Object> keyEquivalence;
  CustomConcurrentHashMap.Strength keyStrength;
  int maximumSize = -1;
  Ticker ticker;
  boolean useCustomMap;
  boolean useNullMap;
  Equivalence<Object> valueEquivalence;
  CustomConcurrentHashMap.Strength valueStrength;
  
  static
  {
    JniLib.a(MapMaker.class, 614);
  }
  
  private native void checkExpiration(long paramLong, TimeUnit paramTimeUnit);
  
  @GwtIncompatible("java.util.concurrent.ConcurrentHashMap concurrencyLevel")
  public native MapMaker concurrencyLevel(int paramInt);
  
  @Beta
  @GwtIncompatible("To be supported")
  public native <K, V> GenericMapMaker<K, V> evictionListener(MapEvictionListener<K, V> paramMapEvictionListener);
  
  @Deprecated
  public native MapMaker expiration(long paramLong, TimeUnit paramTimeUnit);
  
  @Beta
  @GwtIncompatible("To be supported")
  public native MapMaker expireAfterAccess(long paramLong, TimeUnit paramTimeUnit);
  
  @Beta
  public native MapMaker expireAfterWrite(long paramLong, TimeUnit paramTimeUnit);
  
  native Executor getCleanupExecutor();
  
  native int getConcurrencyLevel();
  
  native <K, V> MapEvictionListener<K, V> getEvictionListener();
  
  native long getExpireAfterAccessNanos();
  
  native long getExpireAfterWriteNanos();
  
  native int getInitialCapacity();
  
  native Equivalence<Object> getKeyEquivalence();
  
  native CustomConcurrentHashMap.Strength getKeyStrength();
  
  native Ticker getTicker();
  
  native Equivalence<Object> getValueEquivalence();
  
  native CustomConcurrentHashMap.Strength getValueStrength();
  
  public native MapMaker initialCapacity(int paramInt);
  
  native <K, V> Cache<K, V> makeCache(Function<? super K, ? extends V> paramFunction);
  
  public native <K, V> ConcurrentMap<K, V> makeComputingMap(Function<? super K, ? extends V> paramFunction);
  
  public native <K, V> ConcurrentMap<K, V> makeMap();
  
  @Beta
  public native MapMaker maximumSize(int paramInt);
  
  native MapMaker privateKeyEquivalence(Equivalence<Object> paramEquivalence);
  
  native MapMaker privateValueEquivalence(Equivalence<Object> paramEquivalence);
  
  native MapMaker setKeyStrength(CustomConcurrentHashMap.Strength paramStrength);
  
  native MapMaker setValueStrength(CustomConcurrentHashMap.Strength paramStrength);
  
  @GwtIncompatible("java.lang.ref.SoftReference")
  public native MapMaker softKeys();
  
  @GwtIncompatible("java.lang.ref.SoftReference")
  public native MapMaker softValues();
  
  public native String toString();
  
  @GwtIncompatible("java.lang.ref.WeakReference")
  public native MapMaker weakKeys();
  
  @GwtIncompatible("java.lang.ref.WeakReference")
  public native MapMaker weakValues();
  
  static abstract interface Cache<K, V>
    extends Function<K, V>
  {
    public abstract ConcurrentMap<K, V> asMap();
  }
  
  static class ComputingMapAdapter<K, V>
    extends ForwardingConcurrentMap<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final MapMaker.Cache<K, V> cache;
    
    static
    {
      JniLib.a(ComputingMapAdapter.class, 611);
    }
    
    ComputingMapAdapter(MapMaker.Cache<K, V> paramCache)
    {
      this.cache = paramCache;
    }
    
    protected native ConcurrentMap<K, V> delegate();
    
    public native V get(Object paramObject);
  }
  
  static final class NullComputingConcurrentMap<K, V>
    extends MapMaker.NullConcurrentMap<K, V>
    implements MapMaker.Cache<K, V>
  {
    private static final long serialVersionUID = 0L;
    final Function<? super K, ? extends V> computingFunction;
    
    static
    {
      JniLib.a(NullComputingConcurrentMap.class, 613);
    }
    
    NullComputingConcurrentMap(MapMaker paramMapMaker, Function<? super K, ? extends V> paramFunction)
    {
      super();
      this.computingFunction = ((Function)Preconditions.checkNotNull(paramFunction));
    }
    
    private native V compute(K paramK);
    
    public native V apply(K paramK);
    
    public native ConcurrentMap<K, V> asMap();
  }
  
  static class NullConcurrentMap<K, V>
    extends AbstractMap<K, V>
    implements ConcurrentMap<K, V>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final MapEvictionListener<K, V> evictionListener;
    
    static
    {
      JniLib.a(NullConcurrentMap.class, 612);
    }
    
    NullConcurrentMap(MapMaker paramMapMaker)
    {
      this.evictionListener = paramMapMaker.getEvictionListener();
    }
    
    public native boolean containsKey(Object paramObject);
    
    public native boolean containsValue(Object paramObject);
    
    public native Set<Map.Entry<K, V>> entrySet();
    
    public native V get(Object paramObject);
    
    public native V put(K paramK, V paramV);
    
    public native V putIfAbsent(K paramK, V paramV);
    
    public native V remove(Object paramObject);
    
    public native boolean remove(Object paramObject1, Object paramObject2);
    
    public native V replace(K paramK, V paramV);
    
    public native boolean replace(K paramK, V paramV1, V paramV2);
  }
  
  static enum NullListener
    implements MapEvictionListener
  {
    INSTANCE;
    
    private NullListener() {}
    
    public void onEviction(Object paramObject1, Object paramObject2) {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */