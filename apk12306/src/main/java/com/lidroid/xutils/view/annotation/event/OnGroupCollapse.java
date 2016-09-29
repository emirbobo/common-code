package com.lidroid.xutils.view.annotation.event;

import android.widget.ExpandableListView.OnGroupCollapseListener;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@EventBase(listenerSetter="setOnGroupCollapseListener", listenerType=ExpandableListView.OnGroupCollapseListener.class, methodName="onGroupCollapse")
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnGroupCollapse
{
  int[] parentId() default {0};
  
  int[] value();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\view\annotation\event\OnGroupCollapse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */