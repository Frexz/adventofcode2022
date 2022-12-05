import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class luke1 {
    public static void main(String[] args) throws IOException {
        String filename = "input_1.1.txt";
        File file = new File(filename);
        BufferedReader in = new BufferedReader(new FileReader(file));
        ArrayList<Integer> largest = new ArrayList<>();
        int sum = 0;
        
        for (String line = in.readLine(); line != null; line = in.readLine()) {
            if (line.equals("")) {
                largest.add(sum);
                sum = 0;
                continue;
            }

            sum += Integer.parseInt(line);
        }

        in.close();
        Collections.sort(largest, Collections.reverseOrder());
        int sumTopThree = largest.get(0) + largest.get(1) + largest.get(2);

        System.out.println("The elf carrying the most calories carries " + largest.get(0) + " calories.");
        System.out.println("The three elves carrying the most carries " + sumTopThree + " calories." );
    }
}
