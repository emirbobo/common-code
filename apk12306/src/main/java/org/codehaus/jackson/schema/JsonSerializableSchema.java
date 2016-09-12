package org.codehaus.jackson.schema;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.codehaus.jackson.annotate.JacksonAnnotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
@JacksonAnnotation
public @interface JsonSerializableSchema
{
  String schemaItemDefinition() default "##irrelevant";
  
  String schemaObjectPropertiesDefinition() default "##irrelevant";
  
  String schemaType() default "any";
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\schema\JsonSerializableSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */