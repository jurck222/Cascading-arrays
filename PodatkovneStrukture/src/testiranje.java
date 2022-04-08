import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testiranje {


    public static void main(String[] args) {
        ArrArray tbl = new ArrArray();


        //+1+2+3+4+5+6+7-7-6-5p
        /*tbl.insert(1); tbl.insert(2); tbl.insert(3); tbl.insert(4); tbl.insert(5); tbl.insert(6);
        tbl.insert(7); tbl.delete(7);  tbl.delete(6); tbl.delete(5);
        tbl.printOut();*/
        //+1+2+3+4-1-2-3-4p
        //+10+11+12+13+10+1-1+10p
        //+2+5+3+6+1+11 -2-11-6p+10+0+4p-0+20+2p
        tbl.insert(2); tbl.insert(5); tbl.insert(3); tbl.insert(6); tbl.insert(1); tbl.insert(11);
         tbl.delete(2); tbl.delete(11);tbl.delete(6);
        tbl.printOut();
        tbl.insert(10); tbl.insert(0); tbl.insert(4);
        tbl.printOut();
        tbl.delete(0);tbl.insert(20); tbl.insert(2);
        tbl.printOut();
        //+1+2+3+1+1+3+2+6+1+7+6?8?2-8-4-2-6-7-7-2p?2?1?7
        //+1+2+3+4+5+6+7-1-2-3-4p


    }
}
