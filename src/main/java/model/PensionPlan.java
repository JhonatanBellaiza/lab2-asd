package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private double monthlyContribution;

    @Override
    public String toString() {
        return String.format("{\"planReferenceNumber\":\"%s\",\"enrollmentDate\":\"%s\",\"monthlyContribution\":%.2f}",
                planReferenceNumber, enrollmentDate != null ? enrollmentDate : "null", monthlyContribution);
    }
}
