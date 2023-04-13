package macaaron;

import macaaron.Ingredients;
import macaaron.Macaron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MacaronRunner {
    public static void main(String[] args) {
        Macaron yellow1 = new Macaron("Yellow", new Ingredients(true, "Yellow"));
        Macaron yellow2 = new Macaron("Yellow", new Ingredients(true, "Yellow"));
        Macaron yellow3 = new Macaron("Yellow", new Ingredients(true, "Yellow"));
        Macaron pink1 = new Macaron("Pink", new Ingredients(true, "Pink"));
        Macaron pink2 = new Macaron("Pink", new Ingredients(true, "Pink"));
        Macaron pink3 = new Macaron("Pink", new Ingredients(true, "Pink"));
        Macaron green1 = new Macaron("Green", new Ingredients(false, "Green"));
        Macaron green2 = new Macaron("Green", new Ingredients(false, "Green"));
        Macaron white1 = new Macaron("White", new Ingredients(true, "White"));
        Macaron white2 = new Macaron("White", new Ingredients(true, "White"));

        List<Macaron> macarons = new ArrayList<>();
        macarons.add(yellow1);
        macarons.add(yellow2);
        macarons.add(yellow3);
        macarons.add(pink1);
        macarons.add(pink2);
        macarons.add(pink3);
        macarons.add(green1);
        macarons.add(green2);
        macarons.add(white1);
        macarons.add(white2);

        System.out.println("Czy makaroniki są ==?");
        System.out.println(yellow1 == yellow2);
        System.out.println(yellow1 == yellow3);
        System.out.println(yellow1 == yellow1);
        System.out.println("Czy makaroniki equals?");
        System.out.println(yellow1.equals(yellow2));
        System.out.println(yellow1.equals(yellow3));
        System.out.println(yellow2.equals(yellow2));
        System.out.println(yellow3.equals(yellow1));
        System.out.println(pink1.equals(yellow2));
// Jeśli nie nadpiszemy equals and hashCode w macaaron.Ingredients to będzie false.

        System.out.println("Macrons counter with List: ");
        macaronsCounter(macarons);

        Map<Integer,Macaron>macaronsMap = new HashMap<>();
        macaronsMap.put(1,yellow1);
        macaronsMap.put(2,yellow2);
        macaronsMap.put(3,yellow3);
        macaronsMap.put(4,green1);
        macaronsMap.put(5,green2);
        macaronsMap.put(6,pink1);
        macaronsMap.put(7,pink2);
        macaronsMap.put(8,pink3);
        macaronsMap.put(9,white1);
        macaronsMap.put(10,white2);
        System.out.println("Map Size: " + macaronsMap.size());

        System.out.println("\nMacrons counter with Map: ");
        macronMapCounter(macaronsMap);


    }

    private static void macronMapCounter(Map<Integer, Macaron> macaronsMap) {
        int countMapYellow = 0;
        int countMapGreen = 0;
        int countMapPink = 0;
        int countMapWhite = 0;

        for(Map.Entry<Integer,Macaron> macMap : macaronsMap.entrySet()){
            Integer key = macMap.getKey();
            Macaron macaron = macMap.getValue();
            if(macaron.getColor().equals("Yellow")){
                countMapYellow++;
            }
            if(macaron.getColor().equals("Green")){
                countMapGreen++;
            }
            if(macaron.getColor().equals("Pink")){
                countMapPink++;
            }
            if(macaron.getColor().equals("White")){
                countMapWhite++;
            }
        }
        System.out.println("Yellow -" + countMapYellow);
        System.out.println("Green-" + countMapGreen);
        System.out.println("White -" + countMapWhite);
        System.out.println("Pink -" + countMapPink);
    }

    private static void macaronsCounter(List<Macaron> macarons) {
        int countYellow = 0;
        int countGreen = 0;
        int countPink = 0;
        int countWhite = 0;
        for(Macaron mac : macarons){
            if(mac.getColor() == "Yellow"){
                countYellow++;
            }
            if(mac.getColor() == "Pink"){
                countPink++;
            }
            if(mac.getColor() == "White"){
                countWhite++;
            }
            if(mac.getColor() == "Green"){
                countGreen++;
            }
        }
        System.out.println("Yellow -" + countYellow);
        System.out.println("Green-" + countGreen);
        System.out.println("White -" + countWhite);
        System.out.println("Pink -" + countPink);
    }
}
