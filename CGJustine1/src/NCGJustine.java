import java.util.*;

public class NCGJustine {
    static List<List<Integer>> myLst = new ArrayList<>();

    public static void main(String[] args) {
        // create history

        int[] values = { 1, 2, 3 };
        List<Integer> subLst = createSubLst("anoni", values);

        printResults();
    }

    private static void printResults() {
        System.out.println("size=" + myLst.size());
        System.out.println("my list: " + myLst.hashCode());
        for (List<Integer> subLst : myLst) {
            System.out.println("subLst=" + subLst.hashCode());
            System.out.println("--->" + subLst);
        }
    }

    // method vs constructor: constructors have no return type, they just construct
    // something
    static List<Integer> createSubLst(String name, int[] values) {
        // String name = name; // currently not used
        List<Integer> subLst = new ArrayList<>();
        for (Integer value : values) {
            subLst.add(value);
        }
        return null;

    }
}
