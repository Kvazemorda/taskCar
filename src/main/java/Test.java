import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        Date date2 = new Date(date.getTime()+10000);
        double dif = date2.getTime() - date.getTime();

        int wholeCeil = (int) Math.ceil(dif/(1000*60*60));
        int wholeFloor = (int) Math.floor(dif/(1000*60*60));
        double wholeDouble = Math.floor(dif/(1000*60*60));
        System.out.println("ms long " + dif);
        System.out.println("int hour ceil " + wholeCeil);
        System.out.println("int hour floor " + wholeFloor);
        System.out.println("double hour " + wholeDouble);
    }
}
