package com.arrownock.social;

import com.bangcle.andjni.JniLib;
import java.io.InputStream;

public class AnSocialFile
{
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  static
  {
    JniLib.a(AnSocialFile.class, 179);
  }
  
  public AnSocialFile(String paramString, InputStream paramInputStream)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoInputStream = paramInputStream;
  }
  
  public AnSocialFile(String paramString, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public native byte[] getData();
  
  public native String getFileName();
  
  public native InputStream getInputStream();
  
  public native void setData(byte[] paramArrayOfByte);
  
  public native void setFileName(String paramString);
  
  public native void setInputStream(InputStream paramInputStream);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\social\AnSocialFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */