package com.seek.jccm.project.candidates.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    private Long id;
    private String cardId;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String gender;
    private Date availabilityDate;
    private Date dateOfBirth;
    private double expectedSalary;
    private String note;
    private boolean preSelected;
}
