package com.worklight.androidgap.jsonstore.database;

public enum DatabaseSchemaType
{
  BOOLEAN("boolean", "INTEGER"),  INTEGER("integer", "INTEGER"),  NUMBER("number", "REAL"),  STRING("string", "TEXT");
  
  private String mappedType;
  private String name;
  
  private DatabaseSchemaType(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.mappedType = paramString2;
  }
  
  protected static DatabaseSchemaType fromString(String paramString)
  {
    if (paramString.equals(BOOLEAN.name)) {
      paramString = BOOLEAN;
    }
    for (;;)
    {
      return paramString;
      if (paramString.equals(INTEGER.name)) {
        paramString = INTEGER;
      } else if (paramString.equals(NUMBER.name)) {
        paramString = NUMBER;
      } else if (paramString.equals(STRING.name)) {
        paramString = STRING;
      } else {
        paramString = null;
      }
    }
  }
  
  public String getMappedType()
  {
    return this.mappedType;
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\database\DatabaseSchemaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */