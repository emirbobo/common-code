package json;

import com.alibaba.fastjson.JSONObject;
import util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
*CreatedbyMtimeon2017/2/4.
*/
public class JsonTest{

    private static final String callback="{\"taskid\":\"92e3745751aee5662f9f06ff3f03076920160914\",\"status\":3,\"type\":\"avop\",\"itmes\":[{\"cmd\":\"tag=avop|tag=saveas&bucket=wangshuai9&object=bTN1OC90ZXN0LzEubXA\",\"desc\":\"success\",\"keys\":[\"m3u8/test/shouyin1.mp4\"],\"code\":3}],\"details\":{\"errnum\":0,\"bucket\":\"wangshuai9\",\"items\":[{\"dstpath\":\"m3u8/test/shouyin1.mp4\"}]}}";

    public static void main(String[]args){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
        System.out.println(DateUtil.parseDateTime("2017-02-09 13:30:00").getTime());
        System.out.println(DateUtil.parseDateTime("2017-02-09 13:30:00").toLocaleString());

//        Root jsonBean=JSONObject.parseObject(callback,Root.class);
//        System.out.println(jsonBean.toString());
//        String stream = "https://ks3-cn-beijing.ksyun.com/mtime-test/record/live/854b8dfb91c8441d9f4402ee677c1a8ab/hls/854b8dfb91c8441d9f4402ee677c1a8ab_424-mtime.m3u8";
//        System.out.println(stream.substring(stream.indexOf("record")));
    }
}
