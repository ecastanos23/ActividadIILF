import java.util.*;

public class ALGORITHM_1_LFCO_2025_EC_JC {

    public static List<String> generateTestStrings() {
        List<String> testStrings = new ArrayList<>();
        testStrings.add("aaaaabbbbb"); // aceptada
        testStrings.add("ab");         // aceptada
        testStrings.add("");           // epsilon aceptada
        testStrings.add("aabb");       // aceptada
        testStrings.add("aaaabbbb");   // aceptada
        testStrings.add("aab");        // rechazada
        testStrings.add("aabbbb");     // rechazada
        testStrings.add("bbbaaaa");    // rechazada
        return testStrings;
    }

    public static void printTestStrings(List<String> testStrings) {
        System.out.println("Example Output_Algorithm_1:");
        for (String s : testStrings) {
            System.out.println("String: '" + s + "'");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> testStrings = generateTestStrings();
        printTestStrings(testStrings);
    }
}
