package com.bangcle.everisk.shell;

public class Conf
{
  public static String a = "http://9.5.2.9";
  public static String b = "http://9.5.2.7";
  public static String c = "http://9.5.2.8";
  public static String d = "http://mobile.12306.cn/otsmobile/pjsqj";
  public static String e = "http://mobile.12306.cn/otsmobile/pjsqj";
  public static int f = 5;
  public static int g = 34087;
  public static int h = 60000;
  public static int i = 120000;
  public static String j = "javascript:if(typeof(get_risk_info)!=\"function\"){get_auto_info=function(){try{var autologin=window.ticketStorage.getItem(\"autologin\");if(autologin===\"true\"||autologin==true){var uname=window.ticketStorage.getItem(\"username\");if(uname)return uname;}}catch(e){}return\"\";};con_send=\"\";get_risk_info=function(idx){try{var content=get_auto_info();if(!content)content=jq(\"#usernameInput\").val();if(content&&content!=con_send){var jsons='{\"type\":\"user_data\",\"data\":\"'+content+'\"}';Risk_JSObj.setRiskUserInfo(jsons);con_send=content;}}catch(e){}};risk_begin=function(){get_risk_info({data:3});if(jq(\"#usernameInput\").length>0){jq(\"#usernameInput\").unbind(\"change\",get_risk_info).bind(\"change\",1,get_risk_info);}else{}if(jq(\"#loginBtn\").length>0){jq(\"#loginBtn\").unbind(\"click\",get_risk_info).bind(\"click\",2,get_risk_info);}else{}};}try{risk_begin();}catch(e){}";
  
  public static void a()
  {
    f = 115;
    d = "http://120.197.235.40:6280";
    e = "http://120.197.235.40:7878";
    h = 1;
    i = 3;
  }
  
  public static boolean b()
  {
    return e.equals("unconnected");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\shell\Conf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */