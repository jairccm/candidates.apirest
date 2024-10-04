package com.seek.jccm.project.candidates.application.usecases;

import com.seek.jccm.project.candidates.domain.model.Candidate;
import com.seek.jccm.project.candidates.domain.ports.in.RetrieveCandidateUseCase;
import com.seek.jccm.project.candidates.domain.ports.out.CandidateRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveCandidateUseCaseImpl implements RetrieveCandidateUseCase {
    private final CandidateRepositoryPort candidateRepositoryPort;

    public RetrieveCandidateUseCaseImpl(CandidateRepositoryPort candidateRepositoryPort) {
        this.candidateRepositoryPort = candidateRepositoryPort;
    }
    @Override
    public Optional<Candidate> getCandidateById(Long id) {
        return candidateRepositoryPort.findById(id);
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepositoryPort.findAll();
    }
}
