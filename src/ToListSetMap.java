import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListSetMap {
    public static void run(){
        List<String> teams = new ArrayList<>();

        teams.add("Poland");
        teams.add("Slovakia");
        teams.add("Spain");
        teams.add("Sweden");
        teams.add("Sweden");
        System.out.println("Operations from list to filtered list(1) and from list to filtered set(2): ");
        System.out.println("All teams in our list: "+teams);

        List<String> teamsStartWithS = teams.stream()
                .filter(name -> name.startsWith("S"))
                .collect(Collectors.toList());

        System.out.println("1. List with teams which start with S: "+ teamsStartWithS);

        Set<String> setOfTeamsStartWithS = teams.stream()
                .filter(name -> name.startsWith("S"))
                .collect(Collectors.toUnmodifiableSet());
        System.out.println("2. Set with teams which start with S: "+setOfTeamsStartWithS+"\n");

        System.out.println("List with country name and capital: ");


        Country country1 = new Country("Poland", "Warsaw");
        Country country2 = new Country("Germany", "Berlin");
        Country country3 = new Country("Poland", "Cracow");
        Country country4 = new Country("Sweden", "Stockholm");

        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);
        System.out.println("All countries in list: \n"+countries.toString());

        System.out.println("After changing from list to map: ");
        Map<String, String> countriesMap = countries.stream()
                .collect(Collectors.toMap(Country::getName, Country::getCapital,
                        (oldValue,newValue)->newValue));
        System.out.println(countriesMap);

        System.out.println("After filtered map: (we show only country which start with \"S\" )");
        Map<String, String> countriesMapStartWithS = countries.stream()
                .filter(countryMap -> countryMap.getName().startsWith("S"))
                .collect(Collectors.toMap(Country::getName, Country::getCapital,
                        (oldValue,newValue)->newValue));
        System.out.println(countriesMapStartWithS);
    }
}
