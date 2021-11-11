import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountingSummingAveraging {
    public static void run(){

        List<Person> people = new ArrayList<>();

        people.add(new Person("Andy",25,1.88));
        people.add(new Person("Lara",14,1.56));
        people.add(new Person("Mark",16,1.97));
        people.add(new Person("Jon",38,1.69));

        System.out.println("All people in our list: ");
        System.out.println(people.toString()+"\n");

        System.out.println("Some details about our list: ");
        Long countOfPeople = people.stream()
                .collect(Collectors.counting());
        System.out.println("(1) Counting : How much people are in our list? Answer: "+countOfPeople);

        Integer summingAge = people.stream()
                .collect(Collectors.summingInt(Person::getAge));
        System.out.println("(2) Summing : Summing age: "+summingAge);

        Double averageHeight = people.stream()
                .collect(Collectors.averagingDouble(Person::getHeight));
        System.out.println("(3) Average : Average height: "+averageHeight);

        Optional<Integer> maxValueOfAge = people.stream()
                .map(person -> person.getAge())
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println("(4) Map from Person to Int : Get Max value of age: "+maxValueOfAge.get());

        Optional<Integer> minValueOfAge = people.stream()
                .map(person -> person.getAge())
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println("(5) Map from Person to Int : Get Min value of age: "+minValueOfAge.get());

    }
}
