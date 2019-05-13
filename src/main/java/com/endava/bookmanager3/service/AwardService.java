package com.endava.bookmanager3.service;

import com.endava.bookmanager3.exception.AppException;
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

        return awardRepository.findById(id).orElse(null);
    }

    public void addAward(Award awardToAdd) {

        awardRepository.save(awardToAdd);
    }

    public void updateAward(Award modifiedAward) {

        Award awardToUpdate = awardRepository.findById(modifiedAward.getId()).orElse(null);

        if (awardToUpdate == null) {
            throw new AppException("Award to update not found!");
        }

        awardToUpdate.setName(modifiedAward.getName());
        awardToUpdate.setDescription(modifiedAward.getDescription());
        awardRepository.save(awardToUpdate);
    }

    public void deleteAwardById(Long id) {

        Award awardToDelete = awardRepository.findById(id).orElse(null);

        if (awardToDelete == null)
            throw new AppException("Award to delete not found!");

        awardRepository.delete(awardToDelete);
    }
}
