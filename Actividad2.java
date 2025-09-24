import java.util.*;

public class Actividad2 {

    /* ------------------------------
       Algorithm_1: Generador de cadenas
       ------------------------------ */
    static class Algorithm1 {
        public List<String> generateTestStrings() {
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

        public void printTestStrings(List<String> testStrings) {
            for (String s : testStrings) {
                System.out.println("String: '" + s + "'");
            }
        }
    }

    /* ------------------------------
       Algorithm_2: PDA
       ------------------------------ */
    static class PDA {
        private final Deque<Character> stack = new ArrayDeque<>();

        private void reset() { stack.clear(); }

        public boolean run(String input) {
            reset();
            for (char c : input.toCharArray()) {
                if (c == 'a') {
                    stack.push('A');
                } else if (c == 'b') {
                    if (stack.isEmpty()) return false;
                    stack.pop();
                } else {
                    return false; // símbolo inválido
                }
            }
            return stack.isEmpty();
        }
    }

    /* ------------------------------
       Algorithm_3: Leftmost Derivation
       ------------------------------ */
    static class Algorithm3 {
        public void derive(String w) {
            System.out.println("Leftmost derivation for string '" + w + "':");

            if (w.isEmpty()) {
                System.out.println("S");
                System.out.println("e");
                return;
            }

            // validar forma a^n b^n
            int n = w.length();
            int i = 0;
            while (i < n && w.charAt(i) == 'a') i++;
            int countA = i;
            int countB = 0;
            while (i < n && w.charAt(i) == 'b') { countB++; i++; }
            if (i != n || countA != countB) {
                System.out.println("The string is not in the language, no derivation.");
                return;
            }

            // Construcción leftmost
            System.out.println("S");
            String current = "S";
            for (int k = 0; k < countA; k++) {
                current = current.replaceFirst("S", "a S b");
                System.out.println(current);
            }
            current = current.replaceFirst("S", "e");
            System.out.println(current);

            // forma final
            String finalStr = current.replace("e", "").replaceAll("\\s+", "");
            System.out.println(finalStr);
        }
    }

    /* ------------------------------
       Main
       ------------------------------ */
    public static void main(String[] args) {
        Algorithm1 alg1 = new Algorithm1();
        List<String> testStrings = alg1.generateTestStrings();

        // --- Output Algorithm_1 ---
        System.out.println("Output_Algorithm_1:");
        alg1.printTestStrings(testStrings);
        System.out.println();

        // --- Output Algorithm_2 ---
        System.out.println("Output_Algorithm_2:");
        PDA pda = new PDA();
        List<String> acceptedStrings = new ArrayList<>();

        for (String s : testStrings) {
            boolean isAccepted = pda.run(s);
            if (isAccepted) {
                System.out.println("The string '" + s + "' is accepted by the PDA.");
                acceptedStrings.add(s);
            } else {
                System.out.println("The string '" + s + "' is rejected by the PDA.");
            }
        }
        System.out.println();

        // --- Output Algorithm_3 ---
        System.out.println("Output_Algorithm_3:");
        Algorithm3 alg3 = new Algorithm3();
        for (String s : acceptedStrings) {
            alg3.derive(s);
            System.out.println();
        }
    }
}
