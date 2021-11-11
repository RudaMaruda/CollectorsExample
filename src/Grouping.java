import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static void run(){

        List<Person> people = new ArrayList<>();

        people.add(new Person("Andy",25,1.88));
        people.add(new Person("Lara",14,1.56));
        people.add(new Person("Mark",16,1.97));
        people.add(new Person("Jon",38,1.69));
        people.add(new Person("Didi",38,1.88));
        System.out.println("Again our list with people: "+people.toString());

        Map<Integer, List<Person>> mapWithAgeAndPersonDetail = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Map with grouping age: "+mapWithAgeAndPersonDetail);

        Map<Boolean, List<Person>> mapPeopleAndAge = people.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() > 18));
        System.out.println("All people which have age above 18: "+mapPeopleAndAge.get(true));
        System.out.println("All people which have age below 18: "+mapPeopleAndAge.get(false));
    }
}
