package com.seek.jccm.project.candidates.application.usecases;

import com.seek.jccm.project.candidates.domain.model.Candidate;
import com.seek.jccm.project.candidates.domain.ports.in.UpdateCandidateUseCase;
import com.seek.jccm.project.candidates.domain.ports.out.CandidateRepositoryPort;

import java.util.Optional;

public class UpdateCandidateUseCaseImpl implements UpdateCandidateUseCase {
    private final CandidateRepositoryPort candidateRepositoryPort;

    public UpdateCandidateUseCaseImpl(CandidateRepositoryPort candidateRepositoryPort) {
        this.candidateRepositoryPort = candidateRepositoryPort;
    }
    @Override
    public Optional<Candidate> updateCandidate(Long id, Candidate updatedCandidate) {
        updatedCandidate.setId(id);
        return candidateRepositoryPort.update(updatedCandidate);
    }
}
