package com.endava.bookmanager3.service;

import com.endava.bookmanager3.exception.ResourceNotFoundException;
import com.endava.bookmanager3.model.Award;
import com.endava.bookmanager3.repository.IAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardService {

    private final IAwardRepository awardRepository;

    @Autowired
    public AwardService(IAwardRepository awardRepository) {

        this.awardRepository = awardRepository;
    }

    public List<Award> getAwards() {

        return awardRepository.findAll();
    }

    public Award getAwardById(Long id) {

        return awardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Award", "id", id));
    }

    public Award addAward(Award awardToAdd) {

        return awardRepository.save(awardToAdd);
    }

    public Award updateAward(Long id, Award modifiedAward) {

        Award awardToUpdate = awardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Award", "id", id));
        awardToUpdate.setName(modifiedAward.getName());
        awardToUpdate.setDescription(modifiedAward.getDescription());
        return awardRepository.save(awardToUpdate);
    }

    public void deleteAwardById(Long id) {

        Award awardToDelete = awardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Award", "id", id));
        awardRepository.delete(awardToDelete);
    }
}
