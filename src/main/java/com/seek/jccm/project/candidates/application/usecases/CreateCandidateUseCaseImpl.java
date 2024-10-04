package com.seek.jccm.project.candidates.application.usecases;

import com.seek.jccm.project.candidates.domain.model.Candidate;
import com.seek.jccm.project.candidates.domain.ports.in.CreateCandidateUseCase;
import com.seek.jccm.project.candidates.domain.ports.out.CandidateRepositoryPort;

public class CreateCandidateUseCaseImpl implements CreateCandidateUseCase {
    private final CandidateRepositoryPort candidateRepositoryPort;

    public CreateCandidateUseCaseImpl(CandidateRepositoryPort candidateRepositoryPort) {
        this.candidateRepositoryPort = candidateRepositoryPort;
    }
    @Override
    public Candidate createCandidate(Candidate candidate) {
        return candidateRepositoryPort.save(candidate);
    }
}
