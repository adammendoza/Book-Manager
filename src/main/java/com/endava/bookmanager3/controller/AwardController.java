package com.endava.bookmanager3.controller;

import com.endava.bookmanager3.model.Award;
import com.endava.bookmanager3.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/awards")
public class AwardController {

    private final AwardService awardService;

    @Autowired
    public AwardController(AwardService awardService) {

        this.awardService = awardService;
    }


    @GetMapping
    public List<Award> getAwards() {

        return awardService.getAwards();
    }


    @GetMapping("/{awardId}")
    public Award getAward(@PathVariable Long awardId) {

        return awardService.getAwardById(awardId);
    }


    @PostMapping
    public Award createAward(@Valid @RequestBody Award award) {

        return awardService.addAward(award);
    }

    @PutMapping("/{awardId}")
    public Award updateAward(@PathVariable Long awardId, @Valid @RequestBody Award awardDetails) {

        return awardService.updateAward(awardId, awardDetails);
    }


    @DeleteMapping("/{awardId}")
    public ResponseEntity<?> deleteAward(@PathVariable Long awardId) {
        awardService.deleteAwardById(awardId);
        return ResponseEntity.ok().build();
    }
}
