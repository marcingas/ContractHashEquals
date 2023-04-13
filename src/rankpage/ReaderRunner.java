package rankpage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReaderRunner {
    public static void main(String[] args) {
        File file = new File("src\\rankpage\\text.txt");
        String search = "pies";
        List<String[]>list = new ArrayList<>();
        Map<String,Integer>wordsCount = new HashMap<>();

        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
               String line = scanner.nextLine();
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
    for(String[] arr : list){
        String key = Arrays.toString(arr);
        Integer value=0;
        for(String element : arr){
            if(element.equals(search)){
                value++;
            }

        }
        wordsCount.put(key,value);
    }
    for(Map.Entry<String,Integer>entry : wordsCount.entrySet()){
        String key = entry.getKey();
        int value = entry.getValue();
        if(value>0)
        System.out.println(key + " : " + value);
    }

    }
}
