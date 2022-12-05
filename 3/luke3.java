import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class luke3 {
    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> priorityMap = getPriorityMap();
        String filename = "input_3.1.txt";
        File file = new File(filename);
        BufferedReader in = new BufferedReader(new FileReader(file));
        int sumPriorities = 0;

        // Part 1
        /* for (String line = in.readLine(); line != null; line = in.readLine()) {
            HashSet<Character> container2 = new HashSet<>();
            int half = line.length() / 2;
            String c1 = line.substring(0, half);
            String c2 = line.substring(half, line.length());

            for (int i = 0; i < c2.length(); i++) {
                container2.add(c2.charAt(i));
            }

            for (int i = 0; i < c1.length(); i++) {
                if (container2.contains(c1.charAt(i))) {
                    sumPriorities += priorityMap.get(c1.charAt(i));
                    break;
                }
            }
        }
        in.close(); */

        for (String line = in.readLine(); line != null; line = in.readLine()) {
            HashSet<Character> container2 = new HashSet<>();
            HashSet<Character> container3 = new HashSet<>();
            String c1 = line;
            String c2 = in.readLine();
            String c3 = in.readLine();

            for (int i = 0; i < c2.length(); i++) {
                container2.add(c2.charAt(i));
            }

            for (int i = 0; i < c3.length(); i++) {
                container3.add(c3.charAt(i));
            }

            for (int i = 0; i < c1.length(); i++) {
                if (container2.contains(c1.charAt(i)) && container3.contains(c1.charAt(i))) {
                    sumPriorities += priorityMap.get(c1.charAt(i));
                    break;
                }
            }
        }
        in.close();

        System.out.println("Sum of priorities: " + sumPriorities);
    }

    public static HashMap<Character, Integer> getPriorityMap() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, Integer> p = new HashMap<>();

        for (int i = 0; i < alphabet.length(); i++) {
            char c = alphabet.charAt(i);
            p.put(c, i + 1);            
        }

        alphabet = alphabet.toUpperCase();

        for (int i = 0; i < alphabet.length(); i++) {
            char c = alphabet.charAt(i);
            p.put(c, i + 27);
        }

        return p;
    }
}
