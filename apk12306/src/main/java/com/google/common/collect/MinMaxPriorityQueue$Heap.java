package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class MinMaxPriorityQueue$Heap
{
  final Ordering<E> ordering;
  MinMaxPriorityQueue<E>.Heap otherHeap;
  
  static
  {
    JniLib.a(Heap.class, 644);
  }
  
  MinMaxPriorityQueue$Heap(Ordering<E> paramOrdering)
  {
    Ordering localOrdering;
    this.ordering = localOrdering;
  }
  
  private native int getGrandparentIndex(int paramInt);
  
  private native int getLeftChildIndex(int paramInt);
  
  private native int getParentIndex(int paramInt);
  
  private native int getRightChildIndex(int paramInt);
  
  private native boolean verifyIndex(int paramInt);
  
  native void bubbleUp(int paramInt, E paramE);
  
  native int bubbleUpAlternatingLevels(int paramInt, E paramE);
  
  native int compareElements(int paramInt1, int paramInt2);
  
  native int crossOver(int paramInt, E paramE);
  
  native int crossOverUp(int paramInt, E paramE);
  
  native int fillHoleAt(int paramInt);
  
  native int findMin(int paramInt1, int paramInt2);
  
  native int findMinChild(int paramInt);
  
  native int findMinGrandChild(int paramInt);
  
  native int getCorrectLastElement(E paramE);
  
  native MinMaxPriorityQueue.MoveDesc<E> tryCrossOverAndBubbleUp(int paramInt1, int paramInt2, E paramE);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MinMaxPriorityQueue$Heap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */