package com.google.common.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
@Beta
@GwtCompatible
public @interface Beta {}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\annotations\Beta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */