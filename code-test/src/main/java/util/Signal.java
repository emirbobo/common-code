package util;

import lombok.Data;

import java.util.Map;

/**
 * Created by Mtime on 2017/3/2.
 */
@Data
public class Signal {
    int cmdCode;
    String messageId;
    String roomNum;
    Map<String, String> cmdParams;
}
