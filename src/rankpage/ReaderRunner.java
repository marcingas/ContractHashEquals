package rankpage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReaderRunner {
    public static void main(String[] args) {
        File file = new File("src\\rankpage\\text.txt");
        String line;
        List<String[]>list = new ArrayList<>();

        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                line = scanner.nextLine();
                line= line.replaceAll("\\d+\\.","").replaceAll("ż","z")
                        .replaceAll("ą","a").replaceAll("ę","e")
                        .replaceAll(("ś"),"s").replaceAll("ć","c")
                        .replaceAll("ź","z").replaceAll("ż","z").toLowerCase();
                String[]sentence = line.split(" ");
                list.add(sentence);
                System.out.println(line);
                System.out.println(Arrays.toString(sentence));

            }
        }catch (FileNotFoundException e){
            System.out.println("Nie znalazłem pliku");
        }

    }
}
