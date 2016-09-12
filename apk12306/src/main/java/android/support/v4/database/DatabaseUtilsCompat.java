package android.support.v4.database;

import android.text.TextUtils;

public class DatabaseUtilsCompat
{
  public static String[] appendSelectionArgs(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length == 0)) {}
    String[] arrayOfString;
    for (paramArrayOfString1 = paramArrayOfString2;; paramArrayOfString1 = arrayOfString)
    {
      return paramArrayOfString1;
      arrayOfString = new String[paramArrayOfString1.length + paramArrayOfString2.length];
      System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, paramArrayOfString1.length);
      System.arraycopy(paramArrayOfString2, 0, arrayOfString, paramArrayOfString1.length, paramArrayOfString2.length);
    }
  }
  
  public static String concatenateWhere(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = paramString1;
      } else {
        paramString2 = "(" + paramString1 + ") AND (" + paramString2 + ")";
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\database\DatabaseUtilsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */