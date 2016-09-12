package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;

@Beta
public abstract class ForwardingListenableFuture$SimpleForwardingListenableFuture<V>
  extends ForwardingListenableFuture<V>
{
  private final ListenableFuture<V> delegate;
  
  protected ForwardingListenableFuture$SimpleForwardingListenableFuture(ListenableFuture<V> paramListenableFuture)
  {
    this.delegate = ((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture));
  }
  
  protected final ListenableFuture<V> delegate()
  {
    return this.delegate;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\ForwardingListenableFuture$SimpleForwardingListenableFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */