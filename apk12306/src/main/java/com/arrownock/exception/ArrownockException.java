package com.arrownock.exception;

import com.bangcle.andjni.JniLib;

public class ArrownockException
  extends Exception
{
  public static final int IM_CONNECTION_BROKEN = 3106;
  public static final int IM_FAILED_ADD_CLIENTS = 2105;
  public static final int IM_FAILED_BIND_SERVICE = 2107;
  public static final int IM_FAILED_CONNECT = 3102;
  public static final int IM_FAILED_CREATE_SESSION = 2112;
  public static final int IM_FAILED_CREATE_TOPIC = 2104;
  public static final int IM_FAILED_DISCONNECT = 3103;
  public static final int IM_FAILED_GET_CHAT_HISTORY = 2116;
  public static final int IM_FAILED_GET_CLIENTS_STATUS = 2111;
  public static final int IM_FAILED_GET_CLIENT_ID = 2103;
  public static final int IM_FAILED_GET_CLIENT_ID_LOCALLY = 2102;
  public static final int IM_FAILED_GET_SESSION_INFO = 2113;
  public static final int IM_FAILED_GET_TOPIC_HISTORY = 2110;
  public static final int IM_FAILED_GET_TOPIC_INFO = 2109;
  public static final int IM_FAILED_GET_TOPIC_LIST = 2114;
  public static final int IM_FAILED_INITIALIZE = 2101;
  public static final int IM_FAILED_PUBLISH = 3104;
  public static final int IM_FAILED_REMOVE_CLIENTS = 2106;
  public static final int IM_FAILED_REMOVE_TOPIC = 2117;
  public static final int IM_FAILED_SEND_NOTICE = 2108;
  public static final int IM_FAILED_UPDATE_TOPIC = 2115;
  public static final int IM_FORCE_CLOSED = 3105;
  public static final int IM_INVALID_ANID = 1110;
  public static final int IM_INVALID_ANPUSH_KEY = 1111;
  public static final int IM_INVALID_APP_CONTEXT = 1102;
  public static final int IM_INVALID_APP_KEY = 1101;
  public static final int IM_INVALID_CLIENTS = 1109;
  public static final int IM_INVALID_CLIENT_ID = 1113;
  public static final int IM_INVALID_MESSAGE_FORMAT = 1106;
  public static final int IM_INVALID_MESSAGE_ID = 1104;
  public static final int IM_INVALID_MESSAGE_SIZE = 1105;
  public static final int IM_INVALID_SESSIONID = 1112;
  public static final int IM_INVALID_TOPIC = 1108;
  public static final int IM_INVALID_TOPIC_NAME = 1107;
  public static final int IM_INVALID_USER_ID = 1103;
  public static final int IM_SERVICE_UNAVAILABLE = 3101;
  public static final int LIVE_ALREADY_IN_CALL = 2305;
  public static final int LIVE_FAILED_CREATE_SESSION = 2301;
  public static final int LIVE_FAILED_ESTABLISH_CONN = 2308;
  public static final int LIVE_FAILED_INIT_CAMERA = 2304;
  public static final int LIVE_FAILED_INIT_MEDIA = 2306;
  public static final int LIVE_FAILED_PREPARE_LOCAL_MEDIA = 2307;
  public static final int LIVE_FAILED_TERMINATE_SESSION = 2303;
  public static final int LIVE_FAILED_VALIDATE_SESSION = 2302;
  public static final int LIVE_INVALID_CLIENT_ID = 1303;
  public static final int LIVE_INVALID_IM_INSTANCE = 1301;
  public static final int LIVE_INVALID_LISTENER = 1302;
  public static final int PUSH_DEVICE_NOT_REGISTERED = 2002;
  public static final int PUSH_FAILED_CONNECT = 3002;
  public static final int PUSH_FAILED_DISCONNECT = 3003;
  public static final int PUSH_FAILED_GET_COMMAND = 2010;
  public static final int PUSH_FAILED_GET_NOTIFICATION = 2010;
  public static final int PUSH_FAILED_INITIALIZE = 2001;
  public static final int PUSH_FAILED_NO_GOOGLE_PLAY_SERVICES = 2008;
  public static final int PUSH_FAILED_REGISTER = 2003;
  public static final int PUSH_FAILED_SET_BADGE = 2009;
  public static final int PUSH_FAILED_SET_MUTE = 2006;
  public static final int PUSH_FAILED_SET_SILENT = 2007;
  public static final int PUSH_FAILED_UNREGISTER = 2004;
  public static final int PUSH_FAILED_UPDATE_REGISTRATION = 2005;
  public static final int PUSH_INVALID_APP_CONTEXT = 1002;
  public static final int PUSH_INVALID_APP_KEY = 1001;
  public static final int PUSH_INVALID_BADGE = 1009;
  public static final int PUSH_INVALID_CERTIFICATE = 1008;
  public static final int PUSH_INVALID_CHANNELS = 1006;
  public static final int PUSH_INVALID_DEVICE_ID = 1005;
  public static final int PUSH_INVALID_GCM_SENDER_ID = 1004;
  public static final int PUSH_INVALID_SERVICE_TYPE = 1003;
  public static final int PUSH_INVALID_TIME_RANGE = 1007;
  public static final int PUSH_SERVICE_UNAVAILABLE = 3001;
  public static final int SOCIAL_ERROR_CODE = -1;
  public static final int SOCIAL_FAILED_INITIALIZE = -200009;
  public static final int SOCIAL_INVALID_APP_KEY = -200000;
  public static final int SOCIAL_INVALID_CALLBACK = -200001;
  public static final int SOCIAL_INVALID_FILE = -200008;
  public static final int SOCIAL_INVALID_FILENAME = -200004;
  public static final int SOCIAL_INVALID_HOST = -200003;
  public static final int SOCIAL_INVALID_JSON = -200010;
  public static final int SOCIAL_INVALID_METHOD_TYPE = -200006;
  public static final int SOCIAL_INVALID_PARAMS = -200005;
  public static final int SOCIAL_INVALID_PATH = -200002;
  public static final int SOCIAL_INVALID_PHOTO = -200007;
  private int jdField_a_of_type_Int = -1;
  private Exception jdField_a_of_type_JavaLangException;
  
  static
  {
    JniLib.a(ArrownockException.class, 150);
  }
  
  public ArrownockException(Exception paramException, int paramInt)
  {
    super(paramException);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public ArrownockException(String paramString, int paramInt)
  {
    super(paramString);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public ArrownockException(String paramString, Exception paramException, int paramInt)
  {
    super(paramString);
    this.jdField_a_of_type_JavaLangException = paramException;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public native int getErrorCode();
  
  public native Exception getInnerException();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\exception\ArrownockException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */