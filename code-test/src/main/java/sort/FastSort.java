package sort;

/**
 * Created by Mtime on 2017/5/12.
 */
public class FastSort {

    public static void main(String [] args){
//        int [] a = {4,2,3,5,7,2,1,2,3,6,7,2,3};
//        int low = 0, high = a.length,seg=a[0];
//        while(high > low){
//            if(seg > a[high]){
//                int hl = a[high];
//                a[low] = a[high];
//            }
//            high--;
//            while(low < )
//        }

        int total = 200000;
        int totalreturn = 0;
        for(int i =0 ;i< 36 ; i ++){

            total -= 200000 / 36 ;
            totalreturn += 1000;
            System.out.println("还款第"+ (i+1) +"个月，剩余->" + total + ", 全部还款需要 ->" + (total+ total * 0.05) + ", 总利息:"+(totalreturn + total * 0.05 ) + "，利率："+ (Float.parseFloat((((totalreturn + total * 0.05 ) / 200000) + "" ).substring(0,5)) * 100)+"%");

        }
    }
}
