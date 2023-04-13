import java.util.Objects;

public class Person {
    private String name;
    private String hairColor;
    private int age;

    public Person(String name, String hairColor, int age) {
        this.name = name;
        this.hairColor = hairColor;
        this.age = age;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Person person)){
            return false;
        }

        return this.age == person.age && this.name.equals(person.name) && this.hairColor.equals(person.hairColor);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, hairColor, age) + 22;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", age=" + age +
                '}';
    }
}
