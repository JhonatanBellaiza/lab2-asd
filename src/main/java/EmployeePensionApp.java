import model.Employee;
import model.PensionPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeePensionApp {
    private List<Employee> employees;

    public EmployeePensionApp() {
        employees = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        employees.add(new Employee(1, "Daniel", "Agar", LocalDate.parse("2018-01-17"), 105945.50,
                new PensionPlan("EX1089", LocalDate.parse("2023-01-17"), 100.00)));
        employees.add(new Employee(2, "Benard", "Shaw", LocalDate.parse("2019-04-03"), 197750.00, null));
        employees.add(new Employee(3, "Carly", "Agar", LocalDate.parse("2014-05-16"), 842000.75,
                new PensionPlan("SM2307", LocalDate.parse("2019-11-04"), 1555.50)));
        employees.add(new Employee(4, "Wesley", "Schneider", LocalDate.parse("2019-10-02"), 74500.00, null));
    }

    public void printAllEmployees() {
        employees.sort(Comparator.comparing(Employee::getLastName)
                .thenComparing(Comparator.comparingDouble(Employee::getYearlySalary).reversed()));

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void printUpcomingEnrollees() {
        LocalDate nextMonthStart = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        LocalDate nextMonthEnd = nextMonthStart.plusMonths(1).minusDays(1);

        List<Employee> upcomingEnrollees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.isQualifiedForPension(nextMonthEnd)) {
                upcomingEnrollees.add(employee);
            }
        }

        upcomingEnrollees.sort(Comparator.comparing(Employee::getEmploymentDate));

        for (Employee employee : upcomingEnrollees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        EmployeePensionApp system = new EmployeePensionApp();

        System.out.println("All Employees:");
        system.printAllEmployees();

        System.out.println("\nMonthly Upcoming Enrollees:");
        system.printUpcomingEnrollees();
    }
}
