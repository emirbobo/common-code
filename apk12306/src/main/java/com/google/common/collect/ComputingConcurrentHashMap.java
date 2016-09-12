package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class ComputingConcurrentHashMap<K, V>
  extends CustomConcurrentHashMap<K, V>
  implements MapMaker.Cache<K, V>
{
  private static final long serialVersionUID = 2L;
  final Function<? super K, ? extends V> computingFunction;
  
  static
  {
    JniLib.a(ComputingConcurrentHashMap.class, 384);
  }
  
  ComputingConcurrentHashMap(MapMaker paramMapMaker, Function<? super K, ? extends V> paramFunction)
  {
    super(paramMapMaker);
    this.computingFunction = ((Function)Preconditions.checkNotNull(paramFunction));
  }
  
  public native V apply(K paramK);
  
  public native ConcurrentMap<K, V> asMap();
  
  native CustomConcurrentHashMap<K, V>.Segment createSegment(int paramInt1, int paramInt2);
  
  native ComputingConcurrentHashMap<K, V>.ComputingSegment segmentFor(int paramInt);
  
  native Object writeReplace();
  
  private static class ComputationExceptionReference<K, V>
    implements CustomConcurrentHashMap.ValueReference<K, V>
  {
    final Throwable t;
    
    static
    {
      JniLib.a(ComputationExceptionReference.class, 376);
    }
    
    ComputationExceptionReference(Throwable paramThrowable)
    {
      this.t = paramThrowable;
    }
    
    public native void clear();
    
    public native CustomConcurrentHashMap.ValueReference<K, V> copyFor(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
    
    public native V get();
    
    public native boolean isComputingReference();
    
    public native void notifyValueReclaimed();
    
    public native V waitForValue();
  }
  
  private static class ComputedReference<K, V>
    implements CustomConcurrentHashMap.ValueReference<K, V>
  {
    final V value;
    
    static
    {
      JniLib.a(ComputedReference.class, 377);
    }
    
    ComputedReference(@Nullable V paramV)
    {
      this.value = paramV;
    }
    
    public native void clear();
    
    public native CustomConcurrentHashMap.ValueReference<K, V> copyFor(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
    
    public native V get();
    
    public native boolean isComputingReference();
    
    public native void notifyValueReclaimed();
    
    public native V waitForValue();
  }
  
  class ComputingSegment
    extends CustomConcurrentHashMap.Segment
  {
    static
    {
      JniLib.a(ComputingSegment.class, 379);
    }
    
    ComputingSegment(int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    native V compute(K paramK, int paramInt);
  }
  
  static class ComputingSerializationProxy<K, V>
    extends CustomConcurrentHashMap.AbstractSerializationProxy<K, V>
  {
    private static final long serialVersionUID = 2L;
    transient MapMaker.Cache<K, V> cache;
    final Function<? super K, ? extends V> computingFunction;
    
    static
    {
      JniLib.a(ComputingSerializationProxy.class, 380);
    }
    
    ComputingSerializationProxy(CustomConcurrentHashMap.Strength paramStrength1, CustomConcurrentHashMap.Strength paramStrength2, Equivalence<Object> paramEquivalence1, Equivalence<Object> paramEquivalence2, long paramLong1, long paramLong2, int paramInt1, int paramInt2, MapEvictionListener<? super K, ? super V> paramMapEvictionListener, ConcurrentMap<K, V> paramConcurrentMap, Function<? super K, ? extends V> paramFunction)
    {
      super(paramStrength2, paramEquivalence1, paramEquivalence2, paramLong1, paramLong2, paramInt1, paramInt2, paramMapEvictionListener, paramConcurrentMap);
      this.computingFunction = paramFunction;
    }
    
    private native void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException;
    
    private native void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException;
    
    public native V apply(@Nullable K paramK);
    
    public native ConcurrentMap<K, V> asMap();
    
    native Object readResolve();
  }
  
  private class ComputingValueReference
    implements CustomConcurrentHashMap.ValueReference<K, V>
  {
    @GuardedBy("ComputingValueReference.this")
    CustomConcurrentHashMap.ValueReference<K, V> computedReference = CustomConcurrentHashMap.unset();
    
    static
    {
      JniLib.a(ComputingValueReference.class, 381);
    }
    
    private ComputingValueReference() {}
    
    public native void clear();
    
    native V compute(K paramK, int paramInt);
    
    public native CustomConcurrentHashMap.ValueReference<K, V> copyFor(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
    
    public native V get();
    
    public native boolean isComputingReference();
    
    public native void notifyValueReclaimed();
    
    native void setValueReference(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference);
    
    public native V waitForValue()
      throws InterruptedException;
  }
  
  private static class NullPointerExceptionReference<K, V>
    implements CustomConcurrentHashMap.ValueReference<K, V>
  {
    final String message;
    
    static
    {
      JniLib.a(NullPointerExceptionReference.class, 382);
    }
    
    NullPointerExceptionReference(String paramString)
    {
      this.message = paramString;
    }
    
    public native void clear();
    
    public native CustomConcurrentHashMap.ValueReference<K, V> copyFor(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
    
    public native V get();
    
    public native boolean isComputingReference();
    
    public native void notifyValueReclaimed();
    
    public native V waitForValue();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ComputingConcurrentHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */