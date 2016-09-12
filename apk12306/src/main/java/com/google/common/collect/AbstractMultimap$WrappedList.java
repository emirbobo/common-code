package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class AbstractMultimap$WrappedList
  extends AbstractMultimap<K, V>.WrappedCollection
  implements List<V>
{
  static
  {
    JniLib.a(WrappedList.class, 356);
  }
  
  AbstractMultimap$WrappedList(@Nullable K paramK, List<V> paramList, @Nullable AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
  {
    super(paramK, paramList, paramAbstractMultimap, localWrappedCollection);
  }
  
  public native void add(int paramInt, V paramV);
  
  public native boolean addAll(int paramInt, Collection<? extends V> paramCollection);
  
  public native V get(int paramInt);
  
  native List<V> getListDelegate();
  
  public native int indexOf(Object paramObject);
  
  public native int lastIndexOf(Object paramObject);
  
  public native ListIterator<V> listIterator();
  
  public native ListIterator<V> listIterator(int paramInt);
  
  public native V remove(int paramInt);
  
  public native V set(int paramInt, V paramV);
  
  public native List<V> subList(int paramInt1, int paramInt2);
  
  private class WrappedListIterator
    extends AbstractMultimap<K, V>.WrappedCollection.WrappedIterator
    implements ListIterator<V>
  {
    static
    {
      JniLib.a(WrappedListIterator.class, 362);
    }
    
    WrappedListIterator()
    {
      super();
    }
    
    public WrappedListIterator(int paramInt)
    {
      super(AbstractMultimap.WrappedList.this.getListDelegate().listIterator(paramInt));
    }
    
    private native ListIterator<V> getDelegateListIterator();
    
    public native void add(V paramV);
    
    public native boolean hasPrevious();
    
    public native int nextIndex();
    
    public native V previous();
    
    public native int previousIndex();
    
    public native void set(V paramV);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$WrappedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */