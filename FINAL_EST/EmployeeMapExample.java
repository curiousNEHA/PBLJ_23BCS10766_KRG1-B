import java.util.HashMap;
import java.util.Map;

public class EmployeeMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> empMap = new HashMap<>();
        empMap.put(101, "Neha");
        empMap.put(102, "Amit");
        empMap.put(103, "Rahul");

        System.out.println("---- Traversing using entrySet() ----");
        for (Map.Entry<Integer, String> entry : empMap.entrySet()) {
            System.out.println("Employee ID: " + entry.getKey() +
                               ", Name: " + entry.getValue());
        }

        System.out.println("\n---- Traversing using keySet() ----");
        for (Integer key : empMap.keySet()) {
            System.out.println("Employee ID: " + key +
                               ", Name: " + empMap.get(key));
        }
    }
}
