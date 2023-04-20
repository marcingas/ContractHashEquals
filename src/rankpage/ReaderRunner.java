package rankpage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReaderRunner {


    public static void main(String[] args) {
        File file = new File("src\\rankpage\\text.txt");
        List<Phrase> list = new ArrayList<>();

        list = buildListFromFile(file, list);

        Map<Phrase, Integer> wordsCount = new HashMap<>();
        String searchWord = "pies";

       wordsCount = buildMapWithSearchWord(list, wordsCount, searchWord);
        int factor = 0;
//        printMapWithExpectedValues(wordsCount, biggerThen);

        List<Map.Entry<Phrase, Integer>> temporaryList = new LinkedList<>(wordsCount.entrySet());
        Map<Phrase,Integer> finalMap = new HashMap<>();
       finalMap = sortMap(temporaryList);

        System.out.println(finalMap);

    }

    private static Map<Phrase,Integer> sortMap(List<Map.Entry<Phrase, Integer>> temporaryList) {
        Collections.sort(temporaryList, new Comparator<Map.Entry<Phrase, Integer>>() {

            @Override
            public int compare(Map.Entry<Phrase, Integer> o1, Map.Entry<Phrase, Integer> o2) {
                return ((o2.getValue()).compareTo(o1.getValue()));
            }
        });

        Map<Phrase, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Phrase, Integer> entry : temporaryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
//        System.out.println(sortedMap);
        return sortedMap;
    }

    private static void printMapWithExpectedValues(Map<Phrase, Integer> wordsCount, int biggerThen) {
        for (Map.Entry<Phrase, Integer> entry : wordsCount.entrySet()) {
            Phrase key = entry.getKey();
            int value = entry.getValue();
            if (value > biggerThen)
                System.out.println(key.toString() + " : " + value);
        }
    }

    private static Map<Phrase,Integer> buildMapWithSearchWord(List<Phrase> list, Map<Phrase, Integer> wordsCount, String search) {
        for (Phrase phrase : list) {
            Phrase key = phrase;
            Integer value = 0;

            for (String element : phrase.getFraze()) {
                if (element.equals(search)) {
                    value++;
                }
            }
            wordsCount.put(key, value);
        }
        return wordsCount;
    }

    private static List<Phrase> buildListFromFile(File file, List<Phrase> list) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replaceAll("\\d+\\.", "").replaceAll("ż", "z")
                        .replaceAll("ą", "a").replaceAll("ę", "e")
                        .replaceAll(("ś"), "s").replaceAll("ć", "c")
                        .replaceAll("ź", "z").replaceAll("ż", "z").toLowerCase();
                String[] sentence = line.split(" ");
                Phrase phrase = new Phrase(sentence);
                list.add(phrase);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znalazłem pliku");
        }
        return list;
    }
}
