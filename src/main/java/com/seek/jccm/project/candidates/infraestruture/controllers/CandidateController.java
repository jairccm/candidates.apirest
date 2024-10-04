package com.seek.jccm.project.candidates.infraestruture.controllers;

import com.seek.jccm.project.candidates.application.services.CandidateService;
import com.seek.jccm.project.candidates.domain.model.Candidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    private final CandidateService candidateService;
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public ResponseEntity<?> createCandidate(@RequestBody Candidate candidate) {
        try {
            Candidate createdcandidate = candidateService.createCandidate(candidate);
            return new ResponseEntity<>(createdcandidate, HttpStatus.CREATED);
        }catch (Exception e){
            log.error("An error ocurred: ", e);
            return new ResponseEntity<>("A ocurrido un error al crear el candidato!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{candidateId}")
    public ResponseEntity<?> getCandidateById(@PathVariable Long candidateId) {
        try {
            return candidateService.getCandidateById(candidateId)
                    .map(candidate -> new ResponseEntity<>(candidate, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }catch (Exception e){
            log.error("An error ocurred: ", e);
            return new ResponseEntity<>("A ocurrido un error al obtener candidato!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping
    public ResponseEntity<?> getAllCandidates() {
        try {
            List<Candidate> candidates = candidateService.getAllCandidates();
            return new ResponseEntity<>(candidates, HttpStatus.OK);
        }catch (Exception e){
            log.error("An error ocurred: ", e);
            return new ResponseEntity<>("A ocurrido un error al obtener listado de candidatos!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{candidateId}")
    public ResponseEntity<?> updateCandidate(@PathVariable Long candidateId, @RequestBody Candidate updatedCandidate) {
        try {
            return candidateService.updateCandidate(candidateId, updatedCandidate)
                    .map(candidate -> new ResponseEntity<>(candidate, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }catch (Exception e){
            log.error("An error ocurred: ", e);
            return new ResponseEntity<>("A ocurrido un error al actualizar candidato", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{candidateId}")
    public ResponseEntity<?> deleteCandidateById(@PathVariable Long candidateId) {

        try {
            if (candidateService.deleteCandidate(candidateId)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            log.error("An error ocurred: ", e);
            return new ResponseEntity<>("A ocurrido un error al eliminar candidato", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
