package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

@Beta
@GwtCompatible
public final class Constraints
{
  static
  {
    JniLib.a(Constraints.class, 395);
  }
  
  private static native <E> Collection<E> checkElements(Collection<E> paramCollection, Constraint<? super E> paramConstraint);
  
  public static native <E> Collection<E> constrainedCollection(Collection<E> paramCollection, Constraint<? super E> paramConstraint);
  
  public static native <E> List<E> constrainedList(List<E> paramList, Constraint<? super E> paramConstraint);
  
  private static native <E> ListIterator<E> constrainedListIterator(ListIterator<E> paramListIterator, Constraint<? super E> paramConstraint);
  
  public static native <E> Multiset<E> constrainedMultiset(Multiset<E> paramMultiset, Constraint<? super E> paramConstraint);
  
  public static native <E> Set<E> constrainedSet(Set<E> paramSet, Constraint<? super E> paramConstraint);
  
  public static native <E> SortedSet<E> constrainedSortedSet(SortedSet<E> paramSortedSet, Constraint<? super E> paramConstraint);
  
  static native <E> Collection<E> constrainedTypePreservingCollection(Collection<E> paramCollection, Constraint<E> paramConstraint);
  
  public static native <E> Constraint<E> notNull();
  
  static class ConstrainedCollection<E>
    extends ForwardingCollection<E>
  {
    private final Constraint<? super E> constraint;
    private final Collection<E> delegate;
    
    static
    {
      JniLib.a(ConstrainedCollection.class, 389);
    }
    
    public ConstrainedCollection(Collection<E> paramCollection, Constraint<? super E> paramConstraint)
    {
      this.delegate = ((Collection)Preconditions.checkNotNull(paramCollection));
      this.constraint = ((Constraint)Preconditions.checkNotNull(paramConstraint));
    }
    
    public native boolean add(E paramE);
    
    public native boolean addAll(Collection<? extends E> paramCollection);
    
    protected native Collection<E> delegate();
  }
  
  @GwtCompatible
  private static class ConstrainedList<E>
    extends ForwardingList<E>
  {
    final Constraint<? super E> constraint;
    final List<E> delegate;
    
    static
    {
      JniLib.a(ConstrainedList.class, 390);
    }
    
    ConstrainedList(List<E> paramList, Constraint<? super E> paramConstraint)
    {
      this.delegate = ((List)Preconditions.checkNotNull(paramList));
      this.constraint = ((Constraint)Preconditions.checkNotNull(paramConstraint));
    }
    
    public native void add(int paramInt, E paramE);
    
    public native boolean add(E paramE);
    
    public native boolean addAll(int paramInt, Collection<? extends E> paramCollection);
    
    public native boolean addAll(Collection<? extends E> paramCollection);
    
    protected native List<E> delegate();
    
    public native ListIterator<E> listIterator();
    
    public native ListIterator<E> listIterator(int paramInt);
    
    public native E set(int paramInt, E paramE);
    
    public native List<E> subList(int paramInt1, int paramInt2);
  }
  
  static class ConstrainedListIterator<E>
    extends ForwardingListIterator<E>
  {
    private final Constraint<? super E> constraint;
    private final ListIterator<E> delegate;
    
    static
    {
      JniLib.a(ConstrainedListIterator.class, 391);
    }
    
    public ConstrainedListIterator(ListIterator<E> paramListIterator, Constraint<? super E> paramConstraint)
    {
      this.delegate = paramListIterator;
      this.constraint = paramConstraint;
    }
    
    public native void add(E paramE);
    
    protected native ListIterator<E> delegate();
    
    public native void set(E paramE);
  }
  
  static class ConstrainedMultiset<E>
    extends ForwardingMultiset<E>
  {
    private final Constraint<? super E> constraint;
    private Multiset<E> delegate;
    
    static
    {
      JniLib.a(ConstrainedMultiset.class, 392);
    }
    
    public ConstrainedMultiset(Multiset<E> paramMultiset, Constraint<? super E> paramConstraint)
    {
      this.delegate = ((Multiset)Preconditions.checkNotNull(paramMultiset));
      this.constraint = ((Constraint)Preconditions.checkNotNull(paramConstraint));
    }
    
    public native int add(E paramE, int paramInt);
    
    public native boolean add(E paramE);
    
    public native boolean addAll(Collection<? extends E> paramCollection);
    
    protected native Multiset<E> delegate();
    
    public native int setCount(E paramE, int paramInt);
    
    public native boolean setCount(E paramE, int paramInt1, int paramInt2);
  }
  
  static class ConstrainedRandomAccessList<E>
    extends Constraints.ConstrainedList<E>
    implements RandomAccess
  {
    ConstrainedRandomAccessList(List<E> paramList, Constraint<? super E> paramConstraint)
    {
      super(paramConstraint);
    }
  }
  
  static class ConstrainedSet<E>
    extends ForwardingSet<E>
  {
    private final Constraint<? super E> constraint;
    private final Set<E> delegate;
    
    static
    {
      JniLib.a(ConstrainedSet.class, 393);
    }
    
    public ConstrainedSet(Set<E> paramSet, Constraint<? super E> paramConstraint)
    {
      this.delegate = ((Set)Preconditions.checkNotNull(paramSet));
      this.constraint = ((Constraint)Preconditions.checkNotNull(paramConstraint));
    }
    
    public native boolean add(E paramE);
    
    public native boolean addAll(Collection<? extends E> paramCollection);
    
    protected native Set<E> delegate();
  }
  
  private static class ConstrainedSortedSet<E>
    extends ForwardingSortedSet<E>
  {
    final Constraint<? super E> constraint;
    final SortedSet<E> delegate;
    
    static
    {
      JniLib.a(ConstrainedSortedSet.class, 394);
    }
    
    ConstrainedSortedSet(SortedSet<E> paramSortedSet, Constraint<? super E> paramConstraint)
    {
      this.delegate = ((SortedSet)Preconditions.checkNotNull(paramSortedSet));
      this.constraint = ((Constraint)Preconditions.checkNotNull(paramConstraint));
    }
    
    public native boolean add(E paramE);
    
    public native boolean addAll(Collection<? extends E> paramCollection);
    
    protected native SortedSet<E> delegate();
    
    public native SortedSet<E> headSet(E paramE);
    
    public native SortedSet<E> subSet(E paramE1, E paramE2);
    
    public native SortedSet<E> tailSet(E paramE);
  }
  
  private static enum NotNullConstraint
    implements Constraint<Object>
  {
    INSTANCE;
    
    private NotNullConstraint() {}
    
    public Object checkElement(Object paramObject)
    {
      return Preconditions.checkNotNull(paramObject);
    }
    
    public String toString()
    {
      return "Not null";
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Constraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */