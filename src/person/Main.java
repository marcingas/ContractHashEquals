package person;

import person.Person;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("John","Dark",45);
        Person person5 = new Person("John","Dark",45);
        Person person2 = new Person("John","White",47);
        Person person3 = new Person("Poul","White",65);
        Person person4 = new Person("Anna","Dark",66);
        Map<Integer,Person>persons = new HashMap<>();
        persons.put(person1.hashCode(),person1);
        persons.put(person2.hashCode(),person2);
        persons.put(person3.hashCode(),person3);
        persons.put(person4.hashCode(),person4);
        persons.put(person5.hashCode(),person5);
        System.out.println(persons.containsKey(person1.hashCode()));
        System.out.println(persons.containsValue(person2));
        System.out.println(persons.get(person1.hashCode()));
        System.out.println(person1.equals(person2));
        System.out.println(person1.equals(person5));


    }
}