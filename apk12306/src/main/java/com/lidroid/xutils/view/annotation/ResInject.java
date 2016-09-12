package com.lidroid.xutils.view.annotation;

import com.lidroid.xutils.view.ResType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ResInject
{
  int id();
  
  ResType type();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\view\annotation\ResInject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */