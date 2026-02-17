import java.util.*;

public class ABC {
    static int x = 123;
    static Set<String> s = new HashSet<>();

    public static void main(String[] args) {
        s.add("hello");
        s.add("byebye");

        OuterABC.formattedPrint(s);

        InnerABC.formattedPrint();
        InnerABC.InnerInnerABC.formattedPrint();
    }

    class InnerABC {
        // format converts to uppercase and print
        static void formattedPrint() {
            // TODO print the content of s set
            for (String _s : s) {
                System.out.println("InnerABC:" + _s.toUpperCase());
            }
        }

        class InnerInnerABC {
            // format converts to uppercase and print
            static void formattedPrint() {
                // TODO print the content of s set
                for (String _s : s) {
                    System.out.println("InnerInnerABC:" + _s.toLowerCase());
                }
            }
        }

    }

}

class OuterABC {
    String s;

    static void formattedPrint(Set<String> s) {
        Iterator<String> iter = s.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            System.out.println("OuterABC: " + str.toUpperCase());
        }
    }
}
