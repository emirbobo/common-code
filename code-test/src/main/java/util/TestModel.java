package util;

import lombok.Data;

import java.util.List;

/**
 * Created by Mtime on 2017/2/23.
 */
@Data
public class TestModel {

    private String roomNum;

    private List<Signals> signals ;

    @Data
    public class Signals {

        private int cmdCode;

        private String messageId;

    }
}
