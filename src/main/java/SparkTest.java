import java.io.Serializable;

public class SparkTest {
    public static void main(String[] args) {
        int a =20;
        int b =30;
        int c = 30;
        boolean flag = a > 30;
        flag = flag || b < 20;
        flag = flag && c < 40;
        System.out.println(flag);
    }



}
