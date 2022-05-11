import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;


public class Main {

    public static void main(String[] args) throws IOException {


        String content = new String(Files.readAllBytes(Paths.get("src/harry.txt")));

        content = content.toLowerCase(Locale.ROOT).replaceAll("[^A-Za-z]", " ");
        String[] words = content.split(" +");
        StringBuilder uniqueAsString = new StringBuilder();

        for (String word : words) {
            if (!uniqueAsString.toString().contains(word)) {
                uniqueAsString.append(word).append(" ");
            }
        }
        String[] uniqueAsArray = uniqueAsString.toString().split(" ");

        Arrays.sort(uniqueAsArray);



        String lw = "";
        for (String s : uniqueAsArray) {
            if (s.length() >= lw.length()) {
                lw = s;
            }
        }
        System.out.println("The longest word is " + lw);

        int harryCounter = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase("Harry")) {
                harryCounter++;
            }
            if (!uniqueAsString.toString().contains(word)) {
                uniqueAsString.append(word).append(" ");
            }
        }
        System.out.println("Harry counter = " + harryCounter);


        int distFromC = 0;
        for (String st : uniqueAsArray){
            if (st.startsWith("c")){
                distFromC++;
            }
        }
        System.out.println(distFromC + " word/words begins on the letter 'C'");

        String [] hashesTest = {"a", "b", "b", "a", "a", "c"};
        int intersectionsHashes = 0;

        for (int i = 0; i < hashesTest.length; i++) {
            for (int j = i+1; j < hashesTest.length; j++) {
                if (hashesTest[i].hashCode() == hashesTest[j].hashCode()){
                    intersectionsHashes++;
                    break;
                }
            }
        }
        System.out.printf("There are %d UNIQUE intersections of hashes", intersectionsHashes);


    }
}