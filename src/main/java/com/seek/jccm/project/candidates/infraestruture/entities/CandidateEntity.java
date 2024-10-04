package com.seek.jccm.project.candidates.infraestruture.entities;

import com.seek.jccm.project.candidates.domain.model.Candidate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidates")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_id", nullable = false,length = 8)
    private String cardId;
    @Column(name = "name", nullable = false,length = 70)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone_number", nullable = false,length = 20)
    private String phoneNumber;
    @Column(name = "gender", nullable = false, length = 1)
    @Pattern(regexp = "[MFO]", message = "Gender must be 'M' (Male), 'F' (Female), or 'O' (Other)")
    private String gender;
    @Column(name = "availability_date")
    @Temporal(TemporalType.DATE)
    private Date availabilityDate;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "expected_salary")
    private double expectedSalary;
    @Column(name = "note", length = 500)
    private String note;
    @Column(name = "pre_selected", nullable = false)
    private boolean preSelected;

    public static CandidateEntity fromDomainModel(Candidate candidate) {
        return new CandidateEntity(
                candidate.getId(),
                candidate.getCardId(),
                candidate.getName(),
                candidate.getLastName(),
                candidate.getEmail(),
                candidate.getPhoneNumber(),
                candidate.getGender(),
                candidate.getAvailabilityDate(),
                candidate.getDateOfBirth(),
                candidate.getExpectedSalary(),
                candidate.getNote(),
                candidate.isPreSelected()
        );
    }
}
