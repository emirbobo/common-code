package com.lidroid.xutils.view.annotation.event;

import android.widget.CompoundButton.OnCheckedChangeListener;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@EventBase(listenerSetter="setOnCheckedChangeListener", listenerType=CompoundButton.OnCheckedChangeListener.class, methodName="onCheckedChanged")
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnCompoundButtonCheckedChange
{
  int[] parentId() default {0};
  
  int[] value();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\view\annotation\event\OnCompoundButtonCheckedChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */