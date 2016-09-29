package rpc.model;

import java.io.Serializable;

/**
 * Created by xijingbo on 2016-09-29.
 */
public class RPCResponse  implements Serializable {

    int resultCode;

    String result;

    public RPCResponse(int resultCode, String result) {
        this.resultCode = resultCode;
        this.result = result;
    }

    public int getResultCode() {

        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
