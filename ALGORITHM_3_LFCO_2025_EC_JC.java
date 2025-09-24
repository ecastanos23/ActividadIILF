import java.util.*;

public class ALGORITHM_3_LFCO_2025_EC_JC {

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
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

    static class LeftmostDerivation {
        public void derive(String w) {
            System.out.println("Leftmost derivation for string '" + w + "':");

            if (w.isEmpty()) {
                System.out.println("S");
                System.out.println("e");
                return;
            }

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

            System.out.println("S");
            String current = "S";
            for (int k = 0; k < countA; k++) {
                current = current.replaceFirst("S", "a S b");
                System.out.println(current);
            }
            current = current.replaceFirst("S", "e");
            System.out.println(current);

            String finalStr = current.replace("e", "").replaceAll("\s+", "");
            System.out.println(finalStr);
        }
    }

    public static void main(String[] args) {
        List<String> testStrings = ALGORITHM_1_LFCO_2025_EC_JC.generateTestStrings();
        PDA pda = new PDA();
        LeftmostDerivation deriv = new LeftmostDerivation();

        System.out.println("Output_Algorithm_3:");
        for (String s : testStrings) {
            if (pda.run(s)) {
                deriv.derive(s);
                System.out.println();
            }
        }
    }
}
