package fanxing;

/**
 * Created by Mtime on 2017/1/18.
 */
public class GiftSub implements GiftParent {

    @Override
    public String customProcess() {
        System.out.println("customProcess........");
        return "customProcess";
    }
}
