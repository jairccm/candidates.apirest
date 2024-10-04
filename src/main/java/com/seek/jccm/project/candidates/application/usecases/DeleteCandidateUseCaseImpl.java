package com.seek.jccm.project.candidates.application.usecases;

import com.seek.jccm.project.candidates.domain.ports.in.DeleteCandidateUseCase;
import com.seek.jccm.project.candidates.domain.ports.out.CandidateRepositoryPort;

public class DeleteCandidateUseCaseImpl implements DeleteCandidateUseCase {
    private final CandidateRepositoryPort candidateRepositoryPort;

    public DeleteCandidateUseCaseImpl(CandidateRepositoryPort candidateRepositoryPort) {
        this.candidateRepositoryPort = candidateRepositoryPort;
    }
    @Override
    public boolean deleteCandidate(Long id) {
        return candidateRepositoryPort.deleteById(id);
    }
}
