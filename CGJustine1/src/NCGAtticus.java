import java.util.*;

public class NCGAtticus {
    static List<List<Integer>> myList = new ArrayList<>();

    public static void main(String[] args) {
        // create history

        int[] valuesA = { 1, 2, 3 };
        int[] valuesB = { 4, 5, 6 };
        int[] valuesC = { 7, 8, 9 };
        int[] valuesD = { 10, 11, 12 };
        // List<Integer> subList = createSubList("anoni", values);
        myList.add(createSubList("A", valuesA));
        myList.add(createSubList("B", valuesB));
        myList.add(createSubList("C", valuesC));
        myList.add(createSubList("D", valuesD));

        printResults();

    }

    private static void printResults() {
        System.out.println("size=" + myList.size());
        System.out.println("myList#" + myList.hashCode());
        for (List<Integer> subList : myList) {
            System.out.println("subList#=" + subList.hashCode());
            System.out.println("--->" + subList);
        }
    }

    static List<Integer> createSubList(String name, int[] values) {
        // String name = name; // currently not used
        List<Integer> subList = new ArrayList<>();
        for (Integer value : values) {
            subList.add(value);
        }

        return subList;
    }

}