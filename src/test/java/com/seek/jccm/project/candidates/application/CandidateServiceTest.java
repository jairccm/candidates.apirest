package com.seek.jccm.project.candidates.application;

import com.seek.jccm.project.candidates.application.services.CandidateService;
import com.seek.jccm.project.candidates.domain.model.Candidate;
import com.seek.jccm.project.candidates.domain.ports.in.CreateCandidateUseCase;
import com.seek.jccm.project.candidates.domain.ports.in.DeleteCandidateUseCase;
import com.seek.jccm.project.candidates.domain.ports.in.RetrieveCandidateUseCase;
import com.seek.jccm.project.candidates.domain.ports.in.UpdateCandidateUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CandidateServiceTest {
    private CreateCandidateUseCase createCandidateUseCase;
    private RetrieveCandidateUseCase retrieveCandidateUseCase;
    private UpdateCandidateUseCase updateCandidateUseCase;
    private DeleteCandidateUseCase deleteCandidateUseCase;

    private CandidateService candidateService;

    @BeforeEach
    void setUp() {
        createCandidateUseCase = Mockito.mock(CreateCandidateUseCase.class);
        retrieveCandidateUseCase = Mockito.mock(RetrieveCandidateUseCase.class);
        updateCandidateUseCase = Mockito.mock(UpdateCandidateUseCase.class);
        deleteCandidateUseCase = Mockito.mock(DeleteCandidateUseCase.class);

        candidateService = new CandidateService(createCandidateUseCase, retrieveCandidateUseCase, updateCandidateUseCase, deleteCandidateUseCase);
    }

    @Test
    void createCandidate_success() {
        Candidate candidate = new Candidate();
        candidate.setId(1L);
        candidate.setName("John Doe");

        when(createCandidateUseCase.createCandidate(any(Candidate.class))).thenReturn(candidate);

        Candidate createdCandidate = candidateService.createCandidate(candidate);

        assertNotNull(createdCandidate);
        assertEquals("John Doe", createdCandidate.getName());
        verify(createCandidateUseCase, times(1)).createCandidate(any(Candidate.class));
    }

    @Test
    void deleteCandidate_success() {
        Long candidateId = 1L;

        when(deleteCandidateUseCase.deleteCandidate(candidateId)).thenReturn(true);

        boolean result = candidateService.deleteCandidate(candidateId);

        assertTrue(result);
        verify(deleteCandidateUseCase, times(1)).deleteCandidate(candidateId);
    }

    @Test
    void deleteCandidate_notFound() {
        Long candidateId = 1L;

        when(deleteCandidateUseCase.deleteCandidate(candidateId)).thenReturn(false);

        boolean result = candidateService.deleteCandidate(candidateId);

        assertFalse(result);
        verify(deleteCandidateUseCase, times(1)).deleteCandidate(candidateId);
    }

    @Test
    void getCandidateById_success() {
        Long candidateId = 1L;
        Candidate candidate = new Candidate();
        candidate.setId(candidateId);
        candidate.setName("John Doe");

        when(retrieveCandidateUseCase.getCandidateById(candidateId)).thenReturn(Optional.of(candidate));

        Optional<Candidate> result = candidateService.getCandidateById(candidateId);

        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getName());
        verify(retrieveCandidateUseCase, times(1)).getCandidateById(candidateId);
    }

    @Test
    void getCandidateById_notFound() {
        Long candidateId = 1L;

        when(retrieveCandidateUseCase.getCandidateById(candidateId)).thenReturn(Optional.empty());

        Optional<Candidate> result = candidateService.getCandidateById(candidateId);

        assertFalse(result.isPresent());
        verify(retrieveCandidateUseCase, times(1)).getCandidateById(candidateId);
    }

    @Test
    void getAllCandidates_success() {
        Candidate candidate1 = new Candidate();
        candidate1.setId(1L);
        candidate1.setName("John Doe");

        Candidate candidate2 = new Candidate();
        candidate2.setId(2L);
        candidate2.setName("Jane Doe");

        List<Candidate> candidates = Arrays.asList(candidate1, candidate2);
        when(retrieveCandidateUseCase.getAllCandidates()).thenReturn(candidates);

        List<Candidate> result = candidateService.getAllCandidates();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Doe", result.get(1).getName());
        verify(retrieveCandidateUseCase, times(1)).getAllCandidates();
    }

    @Test
    void updateCandidate_success() {
        Long candidateId = 1L;
        Candidate updatedCandidate = new Candidate();
        updatedCandidate.setId(candidateId);
        updatedCandidate.setName("Updated Name");

        when(updateCandidateUseCase.updateCandidate(eq(candidateId), any(Candidate.class))).thenReturn(Optional.of(updatedCandidate));

        Optional<Candidate> result = candidateService.updateCandidate(candidateId, updatedCandidate);

        assertTrue(result.isPresent());
        assertEquals("Updated Name", result.get().getName());
        verify(updateCandidateUseCase, times(1)).updateCandidate(eq(candidateId), any(Candidate.class));
    }

    @Test
    void updateCandidate_notFound() {
        Long candidateId = 1L;
        Candidate updatedCandidate = new Candidate();

        when(updateCandidateUseCase.updateCandidate(eq(candidateId), any(Candidate.class))).thenReturn(Optional.empty());

        Optional<Candidate> result = candidateService.updateCandidate(candidateId, updatedCandidate);

        assertFalse(result.isPresent());
        verify(updateCandidateUseCase, times(1)).updateCandidate(eq(candidateId), any(Candidate.class));
    }
}
