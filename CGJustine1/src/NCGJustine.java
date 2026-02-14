import java.util.*;

public class NCGJustine {
    static List<List<Integer>> myLst = new ArrayList<>();

    public static void main(String[] args) {
        // create history
        // old method
        int[] valuesA = { 1, 2, 3 };
        int[] valuesB = { 4, 5, 6 };
        int[] valuesC = { 7, 8, 9 };
        int[] valuesD = { 10, 11, 12 };

        myLst.add(createSubLst("A", valuesA));
        myLst.add(createSubLst("B", valuesB));
        myLst.add(createSubLst("C", valuesC));
        myLst.add(createSubLst("D", valuesD));

        // new method
        String[] names = {"A","B","C","D"};
        int[][] values={
            { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 },{ 100, 110, 120 } 
        }
        
        // int[] valuesA = { 1, 2, 3 };
        // int[] valuesB = { 4, 5, 6 };
        // int[] valuesC = { 7, 8, 9 };
        // int[] valuesD = { 10, 11, 12 };

        Map<String, List<Integer>> myMap = new HashMap<>();

        // function
        for (int i=0; i<values.length;i++){
            List<Integer> row =new ArrayList<>();
            for (int j=0;j<values[i].length;j++){
                valuesLst.add(values[i][j]);
            }
        }


        // String name = "A";
        // List<Integer> valuesLst = new ArrayList<>();
        // for (int i = 0; i < valuesA.length; i++) {
        //     valuesLst.add(valuesA[i]);
        // }
        // myMap.put(name, valuesLst);

        // name = "B";
        // valuesLst = new ArrayList<>();
        // for (int i = 0; i < valuesB.length; i++) {
        //     valuesLst.add(valuesB[i]);
        // }
        // myMap.put(name, valuesLst);

        // name = "C";
        // valuesLst = new ArrayList<>();
        // for (int i = 0; i < valuesC.length; i++) {
        //     valuesLst.add(valuesC[i]);
        }
    // myMap.put(name, valuesLst);
    System.out.println(myMap);

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
        return subLst;

    }
}
