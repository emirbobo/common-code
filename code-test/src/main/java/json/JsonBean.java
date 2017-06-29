package json;

import java.util.List;

/**
 * Created by Mtime on 2017/2/4.
 */
public class JsonBean {
    public class Ks3StreamConvertCallBackMsg {

        String taskid;
        int status;     //成功:3 失败: 4 type:int
        String type;    //avop
        List<Item> items;
        TransferDetails details;

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public TransferDetails getDetails() {
            return details;
        }

        public void setDetails(TransferDetails details) {
            this.details = details;
        }

        public class Item{
            String cmd;
            String desc;
           List<String> keys;
            int code;

            public List<String> getKeys() {
                return keys;
            }

            public void setKeys(List<String> keys) {
                this.keys = keys;
            }

            public String getCmd() {
                return cmd;
            }

            public void setCmd(String cmd) {
                this.cmd = cmd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }


            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }
        }

        public class TransferDetails{
            int errnum;//成功：0 失败：其他 type:int
            String bucket;
            List<ResultPath> items;

            public int getErrnum() {
                return errnum;
            }

            public void setErrnum(int errnum) {
                this.errnum = errnum;
            }

            public String getBucket() {
                return bucket;
            }

            public void setBucket(String bucket) {
                this.bucket = bucket;
            }

            public List<ResultPath> getItems() {
                return items;
            }

            public void setItems(List<ResultPath> items) {
                this.items = items;
            }

            public class ResultPath{
                String dstpath;

                public String getDstpath() {
                    return dstpath;
                }

                public void setDstpath(String dstpath) {
                    this.dstpath = dstpath;
                }
            }
        }

    }
}
