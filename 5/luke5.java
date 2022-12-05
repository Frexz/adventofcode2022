import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class luke5 {
    public static void main(String[] args) throws IOException {
        String filename = "input_5.1.txt";
        File file = new File(filename);
        BufferedReader in = new BufferedReader(new FileReader(file));
        ArrayDeque<String>[] stacks;
        String result = "";

        String line = in.readLine();
        stacks = new ArrayDeque[(line.length() + 1) / 4];

        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new ArrayDeque<>();
        }

        while (!(line.startsWith(" 1"))) {
            for (int i = 0; i < line.length(); i += 4) {
                if (line.charAt(i) != ' ') {
                    stacks[i / 4].add(Character.toString(line.charAt(i + 1)));
                }
            }
            line = in.readLine();
        }

        // Read and throw away blank line between stacks and instructions
        in.readLine();

        for (line = in.readLine(); line != null; line = in.readLine()) {
            String[] data = line.substring(5).split("[ from | to ]+");
            int move = Integer.parseInt(data[0]);
            int from = Integer.parseInt(data[1]);
            int to = Integer.parseInt(data[2]);
            ArrayDeque<String> crane = new ArrayDeque<>();
            
            // Part 1
            /* for (int i = 0; i < move; i++) {
                crane.add(stacks[from - 1].poll());
                stacks[to - 1].addFirst(crane.poll());
            } */

            // Part 2
            for (int i = 0; i < move; i++) {
                crane.addFirst(stacks[from - 1].poll());
            }

            for (int i = 0; i < move; i++) {
                stacks[to - 1].addFirst(crane.poll());
            }
        }

        in.close();
        
        for (int i = 0; i < stacks.length; i++) {
            result += stacks[i].peek();
        }

        System.out.println(result);
    }
}
