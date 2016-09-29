package com.lidroid.xutils.view.annotation.event;

import android.view.View.OnLongClickListener;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@EventBase(listenerSetter="setOnLongClickListener", listenerType=View.OnLongClickListener.class, methodName="onLongClick")
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnLongClick
{
  int[] parentId() default {0};
  
  int[] value();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\view\annotation\event\OnLongClick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */