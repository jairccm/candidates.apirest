package com.seek.jccm.project.candidates.infraestruture.repositories;

import com.seek.jccm.project.candidates.infraestruture.entities.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCandidateRepository extends JpaRepository<CandidateEntity,Long> {
}
