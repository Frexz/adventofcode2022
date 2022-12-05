import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class luke2 {
    public static void main(String[] args) throws IOException {
        String filename = "input_2.1.txt";
        File file = new File(filename);
        BufferedReader in = new BufferedReader(new FileReader(file));
        HashMap<String, Integer> scores = getScoreMap();
        HashMap<String, Integer> scores2 = getScoreMap2();
        int poeng = 0;
        int poeng2 = 0;

        for (String line = in.readLine(); line != null; line = in.readLine()) {
            String[] data = line.split(" ");
            String outcome = data[0] + data[1];
            poeng += scores.get(data[1]) + scores.get(outcome);
            poeng2 += scores2.get(data[1]) + scores2.get(outcome);
        }
        in.close();

        System.out.println("Total Score: " + poeng);
        System.out.println("Total Score 2: " + poeng2);
    }

    public static HashMap<String, Integer> getScoreMap() {
        HashMap<String, Integer> r = new HashMap<>();
        r.put("A", 1);
        r.put("B", 2);
        r.put("C", 3);
        r.put("X", 1);
        r.put("Y", 2);
        r.put("Z", 3);
        r.put("AZ", 0);
        r.put("BX", 0);
        r.put("CY", 0);
        r.put("AX", 3);
        r.put("BY", 3);
        r.put("CZ", 3);
        r.put("AY", 6);
        r.put("BZ", 6);
        r.put("CX", 6);
        return r;
    }

    public static HashMap<String, Integer> getScoreMap2() {
        HashMap<String, Integer> r = new HashMap<>();
        r.put("A", 1);
        r.put("B", 2);
        r.put("C", 3);
        r.put("X", 0);
        r.put("Y", 3);
        r.put("Z", 6);
        r.put("AZ", 2);
        r.put("BX", 1);
        r.put("CY",3);
        r.put("AX", 3);
        r.put("BY", 2);
        r.put("CZ", 1);
        r.put("AY", 1);
        r.put("BZ", 3);
        r.put("CX", 2);
        return r;
    }
}


