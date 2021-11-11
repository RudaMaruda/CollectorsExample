import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Summarizing {
    public static void run(){
        List<Person> people = new ArrayList<>();

        people.add(new Person("Andy",25,1.88));
        people.add(new Person("Lara",14,1.56));
        people.add(new Person("Mark",16,1.97));
        people.add(new Person("Jon",38,1.69));
        System.out.println("Again our list with people: "+people.toString());

        IntSummaryStatistics summarizingList = people.stream()
                .collect(Collectors.summarizingInt(Person::getAge));
        System.out.println("We use method summarizingInt, so we create object class IntSummaryStatistics and we have below method:");
        System.out.println("getMax: "+summarizingList.getMax());
        System.out.println("getMin: "+summarizingList.getMin());
        System.out.println("getAverage: "+summarizingList.getAverage());
        System.out.println("getCount: "+summarizingList.getCount());
        System.out.println("getSum: "+summarizingList.getSum());
    }
}
