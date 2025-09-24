import java.util.*;

public class ALGORITHM_2_LFCO_2025_EC_JC {

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

    public static void main(String[] args) {
        List<String> testStrings = ALGORITHM_1_LFCO_2025_ECASTANOS.generateTestStrings();
        PDA pda = new PDA();

        System.out.println("Example Output_Algorithm_2:");
        for (String s : testStrings) {
            boolean isAccepted = pda.run(s);
            if (isAccepted) {
                System.out.println("The string '" + s + "' is accepted by the PDA.");
            } else {
                System.out.println("The string '" + s + "' is rejected by the PDA.");
            }
        }
        System.out.println();
    }
}
