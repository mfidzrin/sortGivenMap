import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortSalary {

    private enum Order {
        ASC, DESC
    }

    public static void main(String[] args) {
        Map<Integer, Integer> unsortedSalary = new HashMap<>();
        unsortedSalary.put(1, 1000);
        unsortedSalary.put(8, 2000);
        unsortedSalary.put(5, 13000);
        unsortedSalary.put(4, 2000);
        unsortedSalary.put(2, 6000);
        LinkedHashMap<Object, Object> sort = sortByValue(unsortedSalary, Order.DESC);
        System.out.println(sort);
    }

    private static LinkedHashMap<Object, Object> sortByValue(Map<Integer, Integer> map, Order order) {
        return map.entrySet().stream()
                .sorted(getComparator(order))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
    }

    private static Comparator<Map.Entry<Integer, Integer>> getComparator(Order order) {
        if (order.equals(Order.DESC)) {
            return (o1, o2) -> o2.getValue().compareTo(o1.getValue());
        }
        return Map.Entry.comparingByValue();
    }
}
