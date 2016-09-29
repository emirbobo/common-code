package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.concurrent.Future;

@Beta
public abstract class ForwardingFuture$SimpleForwardingFuture<V>
  extends ForwardingFuture<V>
{
  private final Future<V> delegate;
  
  protected ForwardingFuture$SimpleForwardingFuture(Future<V> paramFuture)
  {
    this.delegate = ((Future)Preconditions.checkNotNull(paramFuture));
  }
  
  protected final Future<V> delegate()
  {
    return this.delegate;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\ForwardingFuture$SimpleForwardingFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */