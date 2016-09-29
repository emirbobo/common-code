package com.ta.utdid2.device;

import com.bangcle.andjni.JniLib;

public class UTUtdidHelper2
{
  private String mAESKey = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
  
  static
  {
    JniLib.a(UTUtdidHelper2.class, 1077);
  }
  
  public native String dePack(String paramString);
  
  public native String dePackWithBase64(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\device\UTUtdidHelper2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */