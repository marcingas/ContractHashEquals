package rankpage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReaderRunner {


    public static void main(String[] args) {
        File file = new File("src\\rankpage\\text.txt");
        List<Fraze> list = new ArrayList<>();

        buildListFromFile(file, list);

        Map<Fraze, Integer> wordsCount = new HashMap<>();
        String searchWord = "pies";

        buildMapWithSearchWord(list, wordsCount, searchWord);
        int biggerThen = 0;
//        printMapWithExpectedValues(wordsCount, biggerThen);

        List<Map.Entry<Fraze, Integer>> temporaryList = new LinkedList<>(wordsCount.entrySet());
        sortMap(temporaryList);
    }

    private static void sortMap(List<Map.Entry<Fraze, Integer>> temporaryList) {
        Collections.sort(temporaryList, new Comparator<Map.Entry<Fraze, Integer>>() {

            @Override
            public int compare(Map.Entry<Fraze, Integer> o1, Map.Entry<Fraze, Integer> o2) {
                return ((o2.getValue()).compareTo(o1.getValue()));
            }
        });

        Map<Fraze, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Fraze, Integer> entry : temporaryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(sortedMap);
    }

    private static void printMapWithExpectedValues(Map<Fraze, Integer> wordsCount, int biggerThen) {
        for (Map.Entry<Fraze, Integer> entry : wordsCount.entrySet()) {
            Fraze key = entry.getKey();
            int value = entry.getValue();
            if (value > biggerThen)
                System.out.println(key.toString() + " : " + value);
        }
    }

    private static void buildMapWithSearchWord(List<Fraze> list, Map<Fraze, Integer> wordsCount, String search) {
        for (Fraze fraze : list) {
            Fraze key = fraze;
            Integer value = 0;

            for (String element : fraze.getFraze()) {
                if (element.equals(search)) {
                    value++;
                }
            }
            wordsCount.put(key, value);
        }
    }

    private static void buildListFromFile(File file, List<Fraze> list) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replaceAll("\\d+\\.", "").replaceAll("ż", "z")
                        .replaceAll("ą", "a").replaceAll("ę", "e")
                        .replaceAll(("ś"), "s").replaceAll("ć", "c")
                        .replaceAll("ź", "z").replaceAll("ż", "z").toLowerCase();
                String[] sentence = line.split(" ");
                Fraze fraze = new Fraze(sentence);
                list.add(fraze);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znalazłem pliku");
        }
    }
}
