package com.seek.jccm.project.candidates.infraestruture.config;

import com.seek.jccm.project.candidates.application.services.CandidateService;
import com.seek.jccm.project.candidates.application.usecases.CreateCandidateUseCaseImpl;
import com.seek.jccm.project.candidates.application.usecases.DeleteCandidateUseCaseImpl;
import com.seek.jccm.project.candidates.application.usecases.RetrieveCandidateUseCaseImpl;
import com.seek.jccm.project.candidates.application.usecases.UpdateCandidateUseCaseImpl;
import com.seek.jccm.project.candidates.domain.ports.out.CandidateRepositoryPort;
import com.seek.jccm.project.candidates.infraestruture.repositories.JpaCandidateRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public CandidateService candidateService(CandidateRepositoryPort candidateRepositoryPort) {
        return new CandidateService(
                new CreateCandidateUseCaseImpl(candidateRepositoryPort),
                new RetrieveCandidateUseCaseImpl(candidateRepositoryPort),
                new UpdateCandidateUseCaseImpl(candidateRepositoryPort),
                new DeleteCandidateUseCaseImpl(candidateRepositoryPort)
        );
    }

    @Bean
    public CandidateRepositoryPort candidateRepositoryPort(JpaCandidateRepositoryAdapter jpaCandidateRepositoryAdapter) {
        return jpaCandidateRepositoryAdapter;
    }

}
