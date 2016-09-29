package org.codehaus.jackson.map.deser.impl;

import org.codehaus.jackson.map.deser.SettableBeanProperty;

final class BeanPropertyMap$Bucket
{
  public final String key;
  public final Bucket next;
  public final SettableBeanProperty value;
  
  public BeanPropertyMap$Bucket(Bucket paramBucket, String paramString, SettableBeanProperty paramSettableBeanProperty)
  {
    this.next = paramBucket;
    this.key = paramString;
    this.value = paramSettableBeanProperty;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\impl\BeanPropertyMap$Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */