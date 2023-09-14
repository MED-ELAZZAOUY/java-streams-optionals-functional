package net.elazzaouy;

import net.elazzaouy.exception.MaxNotFoundException;
import net.elazzaouy.model.Gender;
import net.elazzaouy.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws MaxNotFoundException {
        List<Person> people = getPeople();
        /*people.stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);
         */

        // Imperative Approach

        /*List<Person> females = new ArrayList<>();
        for (Person female : people ){
            if (female.getGender().equals(Gender.FEMALE))
                females.add(female);
        }
        for (Person female : females){
            System.out.println(DataTransformationUtils.toJson(female));
        }*/

        // Declarative Approach

        // --> Filter :
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .toList();
        //females.forEach(System.out::println);
        List<Person> ages = people.stream()
                .filter(person -> person.getAge() > 24)
                .collect(Collectors.toList());
        //ages.forEach(System.out::println);

        // --> Sorted :
        List<Person> sortedList = people.stream()
                .sorted(Comparator.comparing(Person::getAge))  // Comparator.comparing(Person::getAge).reversed(), Comparator.comparing(Person::getAge).thenComparing()
                .toList();
        //sortedList.forEach(System.out::println);

        // --> All Match :
        boolean allmatch = people.stream()
                .allMatch(person -> person.getAge() > 100); //cette méthode peut être utilisée pour vérifier si tous les éléments d'un flux répondent à une condition particulière.Elle retourne "true"/"false".
        //System.out.println(allmatch);

        // --> Any Match :
        boolean anymatch = people.stream()
                .anyMatch(person -> person.getAge() > 90);
        //System.out.println(anymatch);

        // --> Max :
        /*people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
         */
        Optional<Person> maxAge = people.stream()
                .max(Comparator.comparing(Person::getAge));
        //System.out.println(maxAge);
        /*Person maxAge1 = people.stream()
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(()-> new MaxNotFoundException("Max not Found Exception"));
         */

        //--> Min :
        /*people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        */

        // --> Group :
        /*Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender, peopleGroup) -> {
                System.out.println("Gender: "+gender);
                peopleGroup.forEach(System.out::println);
        });
        */


        // --> Map :
        List<Integer> ageList = people.stream()
                .map(Person::getAge)
                .toList();
        
    }

    private static List<Person> getPeople(){
        return List.of(
                new Person("MED", 24, Gender.MALE),
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