package com.tl.uic.util;

import com.bangcle.andjni.JniLib;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class JsonUtil
{
  private static String _messageTypes;
  private static Hashtable<Integer, Integer> _messageTypesSet = new Hashtable();
  private static volatile JsonUtil _myInstance;
  private static String _pattern = "type(\"|'):[\\d]+";
  private static final Pattern pattern = Pattern.compile(_pattern);
  
  static
  {
    JniLib.a(JsonUtil.class, 1120);
  }
  
  private static native Boolean getAddMessageTypeHeader();
  
  private static native Boolean getFilterMessageTypes();
  
  public static native JSONObject getHashValues(Map<String, String> paramMap);
  
  public static native JsonUtil getInstance();
  
  public static native Boolean testMessageType(Object paramObject, Boolean paramBoolean);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\JsonUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */