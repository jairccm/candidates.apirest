package com.seek.jccm.project.candidates.application.services;

import com.seek.jccm.project.candidates.domain.model.Candidate;
import com.seek.jccm.project.candidates.domain.ports.in.CreateCandidateUseCase;
import com.seek.jccm.project.candidates.domain.ports.in.DeleteCandidateUseCase;
import com.seek.jccm.project.candidates.domain.ports.in.RetrieveCandidateUseCase;
import com.seek.jccm.project.candidates.domain.ports.in.UpdateCandidateUseCase;

import java.util.List;
import java.util.Optional;

public class CandidateService implements CreateCandidateUseCase, RetrieveCandidateUseCase,
        UpdateCandidateUseCase, DeleteCandidateUseCase{
    private final CreateCandidateUseCase createCandidateUseCase;
    private final RetrieveCandidateUseCase retrieveCandidateUseCase;
    private final UpdateCandidateUseCase updateCandidateUseCase;
    private final DeleteCandidateUseCase deleteCandidateUseCase;

    public CandidateService(CreateCandidateUseCase createCandidateUseCase, RetrieveCandidateUseCase retrieveCandidateUseCase,
                       UpdateCandidateUseCase updateCandidateUseCase, DeleteCandidateUseCase deleteCandidateUseCase) {
        this.createCandidateUseCase = createCandidateUseCase;
        this.retrieveCandidateUseCase = retrieveCandidateUseCase;
        this.updateCandidateUseCase = updateCandidateUseCase;
        this.deleteCandidateUseCase = deleteCandidateUseCase;
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {
        return createCandidateUseCase.createCandidate(candidate);
    }

    @Override
    public boolean deleteCandidate(Long id) {
        return deleteCandidateUseCase.deleteCandidate(id);
    }

    @Override
    public Optional<Candidate> getCandidateById(Long id) {
        return retrieveCandidateUseCase.getCandidateById(id);
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return retrieveCandidateUseCase.getAllCandidates();
    }

    @Override
    public Optional<Candidate> updateCandidate(Long id, Candidate updatedCandidate) {
        return updateCandidateUseCase.updateCandidate(id,updatedCandidate);
    }
}
