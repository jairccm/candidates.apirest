package com.seek.jccm.project.candidates.domain.ports.in;

import com.seek.jccm.project.candidates.domain.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface RetrieveCandidateUseCase {
    Optional<Candidate> getCandidateById(Long id);
    List<Candidate> getAllCandidates();
}
