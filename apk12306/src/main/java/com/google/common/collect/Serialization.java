package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Map;

final class Serialization
{
  static
  {
    JniLib.a(Serialization.class, 716);
  }
  
  static native <T> FieldSetter<T> getFieldSetter(Class<T> paramClass, String paramString);
  
  static native <K, V> void populateMap(Map<K, V> paramMap, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  static native <K, V> void populateMap(Map<K, V> paramMap, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException;
  
  static native <K, V> void populateMultimap(Multimap<K, V> paramMultimap, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  static native <K, V> void populateMultimap(Multimap<K, V> paramMultimap, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException;
  
  static native <E> void populateMultiset(Multiset<E> paramMultiset, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  static native <E> void populateMultiset(Multiset<E> paramMultiset, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException;
  
  static native int readCount(ObjectInputStream paramObjectInputStream)
    throws IOException;
  
  static native <K, V> void writeMap(Map<K, V> paramMap, ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  static native <K, V> void writeMultimap(Multimap<K, V> paramMultimap, ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  static native <E> void writeMultiset(Multiset<E> paramMultiset, ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  static final class FieldSetter<T>
  {
    private final Field field;
    
    static
    {
      JniLib.a(FieldSetter.class, 715);
    }
    
    private FieldSetter(Field paramField)
    {
      this.field = paramField;
      paramField.setAccessible(true);
    }
    
    native void set(T paramT, int paramInt);
    
    native void set(T paramT, Object paramObject);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Serialization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */