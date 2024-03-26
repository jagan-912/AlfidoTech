import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class FileWordCount {
    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> hm = new HashMap<>();

        String line;
        int count = 0;
        FileReader file = new FileReader("c:/Users/DELL/Desktop/FileWordCount.txt");
        BufferedReader br = new BufferedReader(file);

        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s");
            count = count + words.length;

            for (int i = 0; i < words.length; i++) {
                if (hm.containsKey(words[i])) {
                    hm.put(words[i], hm.get(words[i]) + 1);
                } else {
                    hm.put(words[i], 1);
                }
            }
        }

        System.out.println("Number of words present in the given file: " + count);
        System.out.println(hm);
        br.close();
    }
}