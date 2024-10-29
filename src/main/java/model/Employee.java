package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;

    public boolean isQualifiedForPension(LocalDate date) {
        return employmentDate.plusYears(5).isBefore(date) && pensionPlan == null;
    }

    @Override
    public String toString() {
        String pensionInfo = (pensionPlan != null) ? pensionPlan.toString() : "null";
        return String.format(
                "{\"employeeId\":%d,\"firstName\":\"%s\",\"lastName\":\"%s\",\"employmentDate\":\"%s\",\"yearlySalary\":%.2f,\"pensionPlan\":%s}",
                employeeId, firstName, lastName, employmentDate, yearlySalary, pensionInfo);
    }

}
