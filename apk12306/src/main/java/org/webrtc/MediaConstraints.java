package org.webrtc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MediaConstraints
{
  public final List<MediaConstraints.KeyValuePair> mandatory = new LinkedList();
  public final List<MediaConstraints.KeyValuePair> optional = new LinkedList();
  
  private static String stringifyKeyValuePairList(List<MediaConstraints.KeyValuePair> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (MediaConstraints.KeyValuePair)localIterator.next();
      if (localStringBuilder.length() > 1) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(paramList.toString());
    }
    return "]";
  }
  
  public String toString()
  {
    return "mandatory: " + stringifyKeyValuePairList(this.mandatory) + ", optional: " + stringifyKeyValuePairList(this.optional);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\MediaConstraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */