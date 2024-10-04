package com.seek.jccm.project.candidates.domain.ports.in;

import com.seek.jccm.project.candidates.domain.model.Candidate;

public interface CreateCandidateUseCase {
    Candidate createCandidate(Candidate candidate);
}
