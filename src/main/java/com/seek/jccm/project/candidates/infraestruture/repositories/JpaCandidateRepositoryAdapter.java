package com.seek.jccm.project.candidates.infraestruture.repositories;

import com.seek.jccm.project.candidates.domain.model.Candidate;
import com.seek.jccm.project.candidates.domain.ports.out.CandidateRepositoryPort;
import com.seek.jccm.project.candidates.infraestruture.entities.CandidateEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class JpaCandidateRepositoryAdapter implements CandidateRepositoryPort {
    private final JpaCandidateRepository jpaCandidateRepository;
    public JpaCandidateRepositoryAdapter(JpaCandidateRepository jpaCandidateRepository) {
        this.jpaCandidateRepository = jpaCandidateRepository;

    }

    @Override
    public Candidate save(Candidate candidate) {
        var candidateEntity = CandidateEntity.fromDomainModel(candidate);
        var savedCandidateEntity = jpaCandidateRepository.save(candidateEntity);
        return getCandidateModelFromEntity(savedCandidateEntity);
    }

    @Override
    public Optional<Candidate> findById(Long id) {
        return jpaCandidateRepository.findById(id)
                .map(candidateEntity -> getCandidateModelFromEntity(candidateEntity));
    }

    @Override
    public List<Candidate> findAll() {
        return jpaCandidateRepository.findAll().stream()
                .map(candidateEntity -> getCandidateModelFromEntity(candidateEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Candidate> update(Candidate candidate) {
        if (jpaCandidateRepository.existsById(candidate.getId())) {
            var taskEntity = CandidateEntity.fromDomainModel(candidate);
            var updatedTaskEntity = jpaCandidateRepository.save(taskEntity);
            return Optional.of(getCandidateModelFromEntity(updatedTaskEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaCandidateRepository.existsById(id)) {
            jpaCandidateRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private static Candidate getCandidateModelFromEntity(CandidateEntity entity) {
        return Candidate.builder()
                .id(entity.getId())
                .cardId(entity.getCardId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .gender(entity.getGender())
                .availabilityDate(entity.getAvailabilityDate())
                .dateOfBirth(entity.getDateOfBirth())
                .expectedSalary(entity.getExpectedSalary())
                .note(entity.getNote())
                .preSelected(entity.isPreSelected())
                .build();
    }
}
