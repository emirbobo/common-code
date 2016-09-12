package com.lidroid.xutils.view.annotation.event;

import android.preference.Preference.OnPreferenceChangeListener;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@EventBase(listenerSetter="setOnPreferenceChangeListener", listenerType=Preference.OnPreferenceChangeListener.class, methodName="onPreferenceChange")
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnPreferenceChange
{
  String[] value();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\view\annotation\event\OnPreferenceChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */