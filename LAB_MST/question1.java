/**Question 2: HashMap 
Create a Java program that uses a HashMap to store employee IDs (Integer) as keys and their 
names (String) as values. Write methods to: 
1. Add an employee to the map. 
2. Retrieve an employee's name by ID. 
3. Throw a custom exception if the ID is not found. 
4. Display all employees in the format "ID: Name". 
Expected Output Example: 
Adding employees... 
Employee Map: {101=John, 102=Jane, 103=Mike} 
Name for ID 102: Jane 
Name for ID 999: Error: Employee ID not found! **/

import java.util.HashMap;
import java.util.Map;

class EmpNotFoundException extends Exception {
    public EmpNotFoundException(String message) {
        super(message);
    }
}

public class EmployeeMap {
    private Map<Integer, String> employeeMap = new HashMap<>();

    public void addEmployee(int id, String name) {
        employeeMap.put(id, name);
    }

    public String getEmployeeName(int id) throws EmployeeNotFoundException {
        if (!employeeMap.containsKey(id)) {
            throw new EmpNotFoundException("Error: Employee ID not found!");
        }
        return employeeMap.get(id);
    }

    public void displayEmployees() {
        System.out.println("Employee Map: " + employeeMap);
    }

    public static void main(String[] args) {
        EmployeeMap empProgram = new EmployeeMap();

        System.out.println("Adding employees...");
        empProgram.addEmployee(101, "John");
        empProgram.addEmployee(102, "Jane");
        empProgram.addEmployee(103, "Mike");

        empProgram.displayEmployees();

        try {
            System.out.println("Name for ID 102: " + empProgram.getEmployeeName(102));
            System.out.println("Name for ID 999: " + empProgram.getEmployeeName(999)); // will throw exception
        } catch (EmployeeNotFoundException e) {
            System.out.println("Name for ID 999: " + e.getMessage());
        }
    }
}
