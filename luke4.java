import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class luke4 {
    public static void main(String[] args) throws IOException {
        String filename = "input_4.1.txt";
        File file = new File(filename);
        BufferedReader in = new BufferedReader(new FileReader(file));
        int pairsWithFullOverlap = 0;
        int pairsWithOverlap = 0;

        for (String line = in.readLine(); line != null; line = in.readLine()) {
            String[] data = line.split("[-,]+");
            int low1 = Integer.parseInt(data[0]);
            int high1 = Integer.parseInt(data[1]);
            int low2 = Integer.parseInt(data[2]);
            int high2 = Integer.parseInt(data[3]);

            if (fullOverlap(low1, high1, low2, high2)) {
                pairsWithFullOverlap++;
            } else if (fullOverlap(low2, high2, low1, high1)) {
                pairsWithFullOverlap++;
            }

            if (overlaps(low1, high1, low2, high2)) {
                pairsWithOverlap++;
            } else if (overlaps(low2, high2, low1, high1)) {
                pairsWithOverlap++;
            }
        }
        
        in.close();
        System.out.println("There are " + pairsWithFullOverlap + " pairs that fully overlap.");
        System.out.println("There are " + pairsWithOverlap + " pairs that overlap partially.");
    }

    public static boolean fullOverlap(int low, int high, int a, int b) {
        if (a >= low && b <= high) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean overlaps(int low, int high, int a, int b) {
        if ((a >= low && a <= high) || (b >= low && b <= high)) {
            return true;
        } else {
            return false;
        }
    }
}
