package com.seek.jccm.project.candidates.domain.ports.in;
import com.seek.jccm.project.candidates.domain.model.Candidate;
import java.util.Optional;

public interface UpdateCandidateUseCase {
    Optional<Candidate> updateCandidate(Long id, Candidate updatedCandidate);
}
