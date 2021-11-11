import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {
    public static void run(){
        List<String> names = new ArrayList<>();

        names.add("Andy");
        names.add("Crist");
        names.add("Wanda");
        names.add("Mark");
        names.add("Jeny");

        System.out.println("All names in list with separator: ");
        String joined = names.stream()
                .collect(Collectors.joining(" "," Names: ",". And thats all!"));
        System.out.println(joined);
    }
}
