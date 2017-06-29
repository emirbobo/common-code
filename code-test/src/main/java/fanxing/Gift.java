package fanxing;

/**
 * Created by Mtime on 2017/1/18.
 */
public enum Gift {

    Praise(1002,"点赞") {
        @Override
        protected Object send(Object cmdCode) {
            return null;
        }
    },
    FreeGift(1003,"免费礼物") {
        @Override
        protected Object send(Object cmdCode) {
            return null;
        }
    };


    protected  abstract Object send(Object o);

    public static Gift getProcessor(int cmdCode){
        for(Gift gf : values()){
            if(cmdCode == gf.getCmdCode()){
                return gf;
            }
        }
        return null;
    }

    Gift(int cmdCode, String desc){
        this.cmdCode = cmdCode;
        this.desc = desc;
    }
    private int cmdCode;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCmdCode() {

        return cmdCode;
    }

    public void setCmdCode(int cmdCode) {
        this.cmdCode = cmdCode;
    }
}
