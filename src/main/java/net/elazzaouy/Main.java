package net.elazzaouy;

import net.elazzaouy.model.Gender;
import net.elazzaouy.model.Person;
import net.elazzaouy.utils.DataTransformationUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeole();
        people.stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);

    }

    private static List<Person> getPeole(){
        return List.of(
                new Person("MED ", 24, Gender.MALE),
                new Person("Ayoub", 20, Gender.MALE),
                new Person("Khadija", 18, Gender.FEMALE),
                new Person("Hind", 21, Gender.FEMALE),
                new Person("Ali", 65, Gender.MALE),
                new Person("Abdo", 100, Gender.MALE),
                new Person("Ilyass", 7, Gender.MALE ),
                new Person("Fatima", 85, Gender.FEMALE)
        );
    }
}