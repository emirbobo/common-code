//package passport;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by xijingbo on 2016-09-07.
// */
//public class Register {
//
//    public static void main(String [] args){
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("mobile", "18612181726");
//        params.put("mobileCode", "2a6fz");
//        //只手机号密码注册
//
//        params.put("regType", "mobile_pwd");
//        params.put("pwdEncryptType", "md5");
//        params.put("password", "");
//
//        String body = HttpRequestUnitPost("http://10.25.35.145:8080/api/verifyCaptcha.htm", params, "10.155.0.222", "54B4B460-CCE9-4D10-A764-53FF87B7C7C5");
//    }
//
//    protected static String  HttpRequestUnitPost(String url, Map<String, String> params, String userIp, String userAgent) {
//        try{
//            HttpRequestUnit hrunit = HttpRequestUnit.post(url);
//            Map<String, String> map = addBaseParam(params, userIp, userAgent);
//            logger.info("call passport url={} params={}", url, map);
//
//            Map<String, String> postParams = new HashMap<String, String>();
//            postParams.put("sign", map.get("sign"));
//            postParams.put("msg", map.get("msg"));
//            hrunit.form(postParams);
//            String body = hrunit.body();
//            return body;
//        } catch (Exception e) {
//            logger.error(
//                    "调用passport接口异常,url={} e={}" , url, e);
//        }
//        return null;
//    }
//
//    /**
//     * 为请求参数增加基础参数
//     * @param params
//     * @param userIp
//     * @param userAgent
//     * @return
//     */
//    protected  Map<String, String> addBaseParam(Map<String, String> params, String userIp, String userAgent) {
//
//        try {
//
//            if(userIp != null && !userIp.equals("")){
//                params.put("userIp", userIp);
//            }
//
//            if(userAgent != null && !userAgent.equals("")){
//                params.put("userAgent", userAgent);
//            }
//
//            params.put("referer", "laifeng");
//            params.put("pid", "20160727PLF000806");
//            params.put("version", "1.0.0");
//            String msg = URLEncoder.encode(Base64Util.encode(JSONUtil.oject2Json(params).getBytes()), "UTF-8");
//            params.put("msg", msg);
//            String sign = CmnUtils.md5(msg + getPassportv3_secret());
//            params.put("sign", sign);
//        } catch (UnsupportedEncodingException e) {
//            logger.error("addParamSign error {}", e);
//        }
//        return params;
//    }
//
//
//}