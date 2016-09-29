//package passport;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import org.apache.commons.lang.ArrayUtils;
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.type.TypeReference;
//
///**
// * json工具类,具体用法见测试用例
// *
// * @author kanglong@youku.com
// * @since 2013-5-2 11:47
// */
//public class JSONUtil {
//
//    public static void main(String[] args){
//        String a= "{\n" +
//                "    \"content\": \"和买姐，买红妹\",\n" +
//                "    \"al\": 8,\n" +
//                "    \"role\": 133,\n" +
//                "    \"pics\": [\n" +
//                "        {\n" +
//                "            \"id\": 389703,\n" +
//                "            \"images\": [\n" +
//                "                {\n" +
//                "                    \"type\": 2,\n" +
//                "                    \"width\": 360,\n" +
//                "                    \"height\": 263,\n" +
//                "                    \"url\": \"http://m1.ykimg.com/0A020000151AF894AB4AC846FC8BDA3A\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"type\": 1,\n" +
//                "                    \"width\": 500,\n" +
//                "                    \"height\": 366,\n" +
//                "                    \"url\": \"http://m1.ykimg.com/0A020000151AF894A46AB71656C0867D\"\n" +
//                "                }\n" +
//                "            ],\n" +
//                "            \"descr\": \"\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
//        JSONObject json = JSONUtil.json2Object(a,JSONObject.class);
//        JSONArray j2 = (JSONArray)json.get("pics");
//        JSONObject j3 = (JSONObject)j2.get(0);
//        JSONArray j4 = (JSONArray)j3.get("images");
//        JSONObject pic= (JSONObject)j4.get(0);
//        System.out.println(pic);
//    }
//
//    private final static Log logger = LogFactory.getLog(JSONUtil.class);
//
//    private JSONUtil() {
//    }
//
//    /**
//     * 从对象转换为JSON
//     *
//     * @param o
//     * @return
//     */
//    public static String oject2Json(Object o) {
//        try {
//            return ObjectMapperFactory.getInstance().getObjectMapper().writeValueAsString(o);
//        } catch (Exception e) {
//            logger.error("对象序列化失败：" + e.getMessage(), e);
//            return "";
//        }
//    }
//
//    /**
//     * json反解成对象
//     *
//     * @param json
//     * @param clazz
//     * @return
//     */
//    public static <T> T json2Object(String json, Class<T> clazz) {
//        if (StringUtils.isBlank(json)) {
//            return null;
//        }
//
//        try {
//            ObjectMapper mapper = ObjectMapperFactory.getInstance().getObjectMapper();
//            return mapper.readValue(json, clazz);
//        } catch (Exception e) {
//            logger.error("对象反序列化失败：" + e.getMessage(), e);
//            return null;
//        }
//    }
//
//    /**
//     * json反解成java泛型对象，可以是各种类型。比较强大。
//     *
//     * <pre>
//     * 示例 new TypeReference(List<Chat>)
//     * </pre>
//     *
//     * @param json
//     * @param tr
//     * @return
//     */
//    public static <T> T json2GenericObject(String json, TypeReference<T> tr) {
//        if (StringUtils.isBlank(json)) {
//            return null;
//        }
//
//        try {
//            return ObjectMapperFactory.getInstance().getObjectMapper().readValue(json, tr);
//        } catch (Exception e) {
//            logger.error("对象反序列化失败：" + e.getMessage(), e);
//            return null;
//        }
//    }
//
//    /**
//     * 序列化成json，包含所有key
//     *
//     * @param o
//     * @return
//     */
//    public static JSONObject buildAllFields(Object o) {
//        return buildExcludeFields(o, ArrayUtils.EMPTY_STRING_ARRAY);
//    }
//
//    /**
//     * 转换成jsonobject，包含其中某些key
//     *
//     * @param o
//     * @param fields
//     * @return
//     */
//    public static JSONObject buildIncludeFields(Object o, String... fields) {
//        if (o == null || ArrayUtils.isEmpty(fields)) {
//            return new JSONObject();
//        }
//
//        JSONObject json = JSONObject.fromObject(oject2Json(o));
//        JSONObject result = new JSONObject();
//        for (String field : fields) {
//            if (json.containsKey(field)) {
//                result.put(field, json.get(field));
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 转换成jsonobject，排除某些字段
//     *
//     * @param o
//     * @param fields
//     * @return
//     */
//    public static JSONObject buildExcludeFields(Object o, String... fields) {
//        if (o == null) {
//            return new JSONObject();
//        }
//
//        JSONObject json = JSONObject.fromObject(oject2Json(o));
//        if (ArrayUtils.isNotEmpty(fields)) {
//            for (String field : fields) {
//                if (json.containsKey(field)) {
//                    json.remove(field);
//                }
//            }
//        }
//        return json;
//    }
//
//    /**
//     * 创建空的objectNode
//     *
//     * @return
//     */
//    public static org.codehaus.jackson.node.ObjectNode createObjectNode() {
//        return ObjectMapperFactory.getInstance().getObjectMapper().createObjectNode();
//    }
//
//    /**
//     * 创建空的ArrayNode
//     *
//     * @return
//     */
//    public static org.codehaus.jackson.node.ArrayNode createArrayNode() {
//        return ObjectMapperFactory.getInstance().getObjectMapper().createArrayNode();
//    }
//}
