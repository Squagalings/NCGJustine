
import java.io.FileWriter;

public class App {

    public static void main(String[] args) throws Exception {
        // File file = new File("users.txt");
        FileWriter out = new FileWriter("users.txt");
        out.write("hello");
        out.close();
    }
}
