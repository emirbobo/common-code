package fanxing;

/**
 * Created by Mtime on 2017/1/18.
 */
public class GiftBase<K extends GiftParent>{

    public String sendGift(K k){
        System.out.println("GiftBase");
        k.customProcess();
        return "doProcess";
    }
}
