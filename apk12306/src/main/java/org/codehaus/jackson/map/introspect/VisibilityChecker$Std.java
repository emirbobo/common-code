package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;

@JsonAutoDetect(creatorVisibility=JsonAutoDetect.Visibility.ANY, fieldVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, getterVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, isGetterVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, setterVisibility=JsonAutoDetect.Visibility.ANY)
public class VisibilityChecker$Std
  implements VisibilityChecker<Std>
{
  protected static final Std DEFAULT = new Std((JsonAutoDetect)Std.class.getAnnotation(JsonAutoDetect.class));
  protected final JsonAutoDetect.Visibility _creatorMinLevel;
  protected final JsonAutoDetect.Visibility _fieldMinLevel;
  protected final JsonAutoDetect.Visibility _getterMinLevel;
  protected final JsonAutoDetect.Visibility _isGetterMinLevel;
  protected final JsonAutoDetect.Visibility _setterMinLevel;
  
  public VisibilityChecker$Std(JsonAutoDetect.Visibility paramVisibility1, JsonAutoDetect.Visibility paramVisibility2, JsonAutoDetect.Visibility paramVisibility3, JsonAutoDetect.Visibility paramVisibility4, JsonAutoDetect.Visibility paramVisibility5)
  {
    this._getterMinLevel = paramVisibility1;
    this._isGetterMinLevel = paramVisibility2;
    this._setterMinLevel = paramVisibility3;
    this._creatorMinLevel = paramVisibility4;
    this._fieldMinLevel = paramVisibility5;
  }
  
  public VisibilityChecker$Std(JsonAutoDetect paramJsonAutoDetect)
  {
    JsonMethod[] arrayOfJsonMethod = paramJsonAutoDetect.value();
    JsonAutoDetect.Visibility localVisibility;
    if (hasMethod(arrayOfJsonMethod, JsonMethod.GETTER))
    {
      localVisibility = paramJsonAutoDetect.getterVisibility();
      this._getterMinLevel = localVisibility;
      if (!hasMethod(arrayOfJsonMethod, JsonMethod.IS_GETTER)) {
        break label129;
      }
      localVisibility = paramJsonAutoDetect.isGetterVisibility();
      label50:
      this._isGetterMinLevel = localVisibility;
      if (!hasMethod(arrayOfJsonMethod, JsonMethod.SETTER)) {
        break label136;
      }
      localVisibility = paramJsonAutoDetect.setterVisibility();
      label72:
      this._setterMinLevel = localVisibility;
      if (!hasMethod(arrayOfJsonMethod, JsonMethod.CREATOR)) {
        break label143;
      }
      localVisibility = paramJsonAutoDetect.creatorVisibility();
      label94:
      this._creatorMinLevel = localVisibility;
      if (!hasMethod(arrayOfJsonMethod, JsonMethod.FIELD)) {
        break label150;
      }
    }
    label129:
    label136:
    label143:
    label150:
    for (paramJsonAutoDetect = paramJsonAutoDetect.fieldVisibility();; paramJsonAutoDetect = JsonAutoDetect.Visibility.NONE)
    {
      this._fieldMinLevel = paramJsonAutoDetect;
      return;
      localVisibility = JsonAutoDetect.Visibility.NONE;
      break;
      localVisibility = JsonAutoDetect.Visibility.NONE;
      break label50;
      localVisibility = JsonAutoDetect.Visibility.NONE;
      break label72;
      localVisibility = JsonAutoDetect.Visibility.NONE;
      break label94;
    }
  }
  
  public static Std defaultInstance()
  {
    return DEFAULT;
  }
  
  private static boolean hasMethod(JsonMethod[] paramArrayOfJsonMethod, JsonMethod paramJsonMethod)
  {
    int j = paramArrayOfJsonMethod.length;
    int i = 0;
    if (i < j)
    {
      JsonMethod localJsonMethod = paramArrayOfJsonMethod[i];
      if ((localJsonMethod != paramJsonMethod) && (localJsonMethod != JsonMethod.ALL)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i++;
      break;
    }
  }
  
  public boolean isCreatorVisible(Member paramMember)
  {
    return this._creatorMinLevel.isVisible(paramMember);
  }
  
  public boolean isCreatorVisible(AnnotatedMember paramAnnotatedMember)
  {
    return isCreatorVisible(paramAnnotatedMember.getMember());
  }
  
  public boolean isFieldVisible(Field paramField)
  {
    return this._fieldMinLevel.isVisible(paramField);
  }
  
  public boolean isFieldVisible(AnnotatedField paramAnnotatedField)
  {
    return isFieldVisible(paramAnnotatedField.getAnnotated());
  }
  
  public boolean isGetterVisible(Method paramMethod)
  {
    return this._getterMinLevel.isVisible(paramMethod);
  }
  
  public boolean isGetterVisible(AnnotatedMethod paramAnnotatedMethod)
  {
    return isGetterVisible(paramAnnotatedMethod.getAnnotated());
  }
  
  public boolean isIsGetterVisible(Method paramMethod)
  {
    return this._isGetterMinLevel.isVisible(paramMethod);
  }
  
  public boolean isIsGetterVisible(AnnotatedMethod paramAnnotatedMethod)
  {
    return isIsGetterVisible(paramAnnotatedMethod.getAnnotated());
  }
  
  public boolean isSetterVisible(Method paramMethod)
  {
    return this._setterMinLevel.isVisible(paramMethod);
  }
  
  public boolean isSetterVisible(AnnotatedMethod paramAnnotatedMethod)
  {
    return isSetterVisible(paramAnnotatedMethod.getAnnotated());
  }
  
  public String toString()
  {
    return "[Visibility:" + " getter: " + this._getterMinLevel + ", isGetter: " + this._isGetterMinLevel + ", setter: " + this._setterMinLevel + ", creator: " + this._creatorMinLevel + ", field: " + this._fieldMinLevel + "]";
  }
  
  public Std with(JsonAutoDetect paramJsonAutoDetect)
  {
    if (paramJsonAutoDetect == null)
    {
      paramJsonAutoDetect = this;
      return paramJsonAutoDetect;
    }
    JsonMethod[] arrayOfJsonMethod = paramJsonAutoDetect.value();
    Object localObject;
    if (hasMethod(arrayOfJsonMethod, JsonMethod.GETTER))
    {
      localObject = paramJsonAutoDetect.getterVisibility();
      label32:
      Std localStd = withGetterVisibility((JsonAutoDetect.Visibility)localObject);
      if (!hasMethod(arrayOfJsonMethod, JsonMethod.IS_GETTER)) {
        break label146;
      }
      localObject = paramJsonAutoDetect.isGetterVisibility();
      label56:
      localStd = localStd.withIsGetterVisibility((JsonAutoDetect.Visibility)localObject);
      if (!hasMethod(arrayOfJsonMethod, JsonMethod.SETTER)) {
        break label153;
      }
      localObject = paramJsonAutoDetect.setterVisibility();
      label81:
      localStd = localStd.withSetterVisibility((JsonAutoDetect.Visibility)localObject);
      if (!hasMethod(arrayOfJsonMethod, JsonMethod.CREATOR)) {
        break label160;
      }
      localObject = paramJsonAutoDetect.creatorVisibility();
      label106:
      localObject = localStd.withCreatorVisibility((JsonAutoDetect.Visibility)localObject);
      if (!hasMethod(arrayOfJsonMethod, JsonMethod.FIELD)) {
        break label167;
      }
    }
    label146:
    label153:
    label160:
    label167:
    for (paramJsonAutoDetect = paramJsonAutoDetect.fieldVisibility();; paramJsonAutoDetect = JsonAutoDetect.Visibility.NONE)
    {
      paramJsonAutoDetect = ((Std)localObject).withFieldVisibility(paramJsonAutoDetect);
      break;
      localObject = JsonAutoDetect.Visibility.NONE;
      break label32;
      localObject = JsonAutoDetect.Visibility.NONE;
      break label56;
      localObject = JsonAutoDetect.Visibility.NONE;
      break label81;
      localObject = JsonAutoDetect.Visibility.NONE;
      break label106;
    }
  }
  
  public Std withCreatorVisibility(JsonAutoDetect.Visibility paramVisibility)
  {
    JsonAutoDetect.Visibility localVisibility = paramVisibility;
    if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
      localVisibility = DEFAULT._creatorMinLevel;
    }
    if (this._creatorMinLevel == localVisibility) {}
    for (paramVisibility = this;; paramVisibility = new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, localVisibility, this._fieldMinLevel)) {
      return paramVisibility;
    }
  }
  
  public Std withFieldVisibility(JsonAutoDetect.Visibility paramVisibility)
  {
    JsonAutoDetect.Visibility localVisibility = paramVisibility;
    if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
      localVisibility = DEFAULT._fieldMinLevel;
    }
    if (this._fieldMinLevel == localVisibility) {}
    for (paramVisibility = this;; paramVisibility = new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, localVisibility)) {
      return paramVisibility;
    }
  }
  
  public Std withGetterVisibility(JsonAutoDetect.Visibility paramVisibility)
  {
    JsonAutoDetect.Visibility localVisibility = paramVisibility;
    if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
      localVisibility = DEFAULT._getterMinLevel;
    }
    if (this._getterMinLevel == localVisibility) {}
    for (paramVisibility = this;; paramVisibility = new Std(localVisibility, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel)) {
      return paramVisibility;
    }
  }
  
  public Std withIsGetterVisibility(JsonAutoDetect.Visibility paramVisibility)
  {
    JsonAutoDetect.Visibility localVisibility = paramVisibility;
    if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
      localVisibility = DEFAULT._isGetterMinLevel;
    }
    if (this._isGetterMinLevel == localVisibility) {}
    for (paramVisibility = this;; paramVisibility = new Std(this._getterMinLevel, localVisibility, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel)) {
      return paramVisibility;
    }
  }
  
  public Std withSetterVisibility(JsonAutoDetect.Visibility paramVisibility)
  {
    JsonAutoDetect.Visibility localVisibility = paramVisibility;
    if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
      localVisibility = DEFAULT._setterMinLevel;
    }
    if (this._setterMinLevel == localVisibility) {}
    for (paramVisibility = this;; paramVisibility = new Std(this._getterMinLevel, this._isGetterMinLevel, localVisibility, this._creatorMinLevel, this._fieldMinLevel)) {
      return paramVisibility;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\VisibilityChecker$Std.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */