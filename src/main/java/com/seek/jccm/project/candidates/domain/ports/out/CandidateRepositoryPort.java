package com.seek.jccm.project.candidates.domain.ports.out;

import com.seek.jccm.project.candidates.domain.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateRepositoryPort {
    Candidate save(Candidate candidate);
    Optional<Candidate> findById(Long id);
    List<Candidate> findAll();
    Optional<Candidate> update(Candidate candidate);
    boolean deleteById(Long id);
}
