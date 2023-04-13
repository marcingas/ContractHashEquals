package rankpage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReaderRunner {
    public static void main(String[] args) {
        File file = new File("src\\rankpage\\text.txt");
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }catch (FileNotFoundException e){
            System.out.println("Nie znalazłem pliku");
        }
    }
}
