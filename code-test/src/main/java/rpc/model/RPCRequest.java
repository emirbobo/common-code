package rpc.model;

import java.io.Serializable;

/**
 * Created by xijingbo on 2016-09-29.
 */
public class RPCRequest implements Serializable {


    String className;

    String methodName;

    Object [] params;

    String requestId;

    public RPCRequest(){

    }

    public RPCRequest(String className, String methodName, Object[] params, String requestId) {
        this.className = className;
        this.methodName = methodName;
        this.params = params;
        this.requestId = requestId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
