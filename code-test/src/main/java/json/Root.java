package json;

import java.util.List;

/**
 * Created by Mtime on 2017/2/4.
 */
public class Root {

    private String taskid;

    private int status;

    private String type;

    private List<Itme> itmes ;

    private Details details;

    public void setTaskid(String taskid){
        this.taskid = taskid;
    }
    public String getTaskid(){
        return this.taskid;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setItmes(List<Itme> itmes){
        this.itmes = itmes;
    }
    public List<Itme> getItmes(){
        return this.itmes;
    }
    public void setDetails(Details details){
        this.details = details;
    }
    public Details getDetails(){
        return this.details;
    }

    public class Itme {
        private String cmd;

        private String desc;

        private String[] keys ;

        private int code;

        public void setCmd(String cmd){
            this.cmd = cmd;
        }
        public String getCmd(){
            return this.cmd;
        }
        public void setDesc(String desc){
            this.desc = desc;
        }
        public String getDesc(){
            return this.desc;
        }

        public String[] getKeys() {
            return keys;
        }

        public void setKeys(String[] keys) {
            this.keys = keys;
        }

        public void setCode(int code){
            this.code = code;
        }
        public int getCode(){
            return this.code;
        }
    }

    public class Details {
        private int errnum;

        private String bucket;

        private List<PathItem> items ;

        public void setErrnum(int errnum){
            this.errnum = errnum;
        }
        public int getErrnum(){
            return this.errnum;
        }
        public void setBucket(String bucket){
            this.bucket = bucket;
        }
        public String getBucket(){
            return this.bucket;
        }
        public void setItems(List<PathItem> items){
            this.items = items;
        }
        public List<PathItem> getItems(){
            return this.items;
        }

        public class PathItem {
            private String dstpath;

            public void setDstpath(String dstpath){
                this.dstpath = dstpath;
            }
            public String getDstpath(){
                return this.dstpath;
            }

        }
    }

}
