package testannotation.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2016/8/31.
 */
@Target(ElementType.FIELD)
public @interface ClassOnlyField
{
	public String value() default ""; //使用的时候 @ClassOnlyField(value="xxx")
}
