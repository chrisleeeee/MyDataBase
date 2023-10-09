import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class test {
    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream("src/main/resources/Tables/student.zdb")) {
            byte[] buffer = new byte[1 + 20 + 4 + 8];
            while (inputStream.read(buffer) != -1) {

                byte flag = ByteBuffer.wrap(buffer, 0, 1).get();

                String stringData = new String(buffer, 1, 20, StandardCharsets.UTF_8).replace("@", "");
                int intValue = ByteBuffer.wrap(buffer, 21, 4).getInt();
                double doubleValue = ByteBuffer.wrap(buffer, 25, 8).getDouble();

                System.out.println(flag);
                System.out.println(stringData);
                System.out.println("Integer: " + intValue);
                System.out.println("Double: " + doubleValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
