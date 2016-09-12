package org.codehaus.jackson;

public abstract interface SerializableString
{
  public abstract char[] asQuotedChars();
  
  public abstract byte[] asQuotedUTF8();
  
  public abstract byte[] asUnquotedUTF8();
  
  public abstract int charLength();
  
  public abstract String getValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\SerializableString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */