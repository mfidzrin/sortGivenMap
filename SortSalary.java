import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortSalary {

    public static void main(String[] args) {
        Map<Integer, Integer> unsortedSalary = new HashMap<>();
        unsortedSalary.put(1, 1000);
        unsortedSalary.put(8, 2000);
        unsortedSalary.put(5, 13000);
        unsortedSalary.put(4, 2000);
        unsortedSalary.put(2, 6000);
        LinkedHashMap<Object, Object> sort = sortByValueInDescending(unsortedSalary);
        System.out.println(sort);
    }

    private static LinkedHashMap<Object, Object> sortByValueInDescending(Map<Integer, Integer> map) {
        return map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
    }
}
