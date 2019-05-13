package com.endava.bookmanager3.controller;

import com.endava.bookmanager3.exception.ResourceNotFoundException;
import com.endava.bookmanager3.model.Award;
import com.endava.bookmanager3.service.AwardService;
import com.endava.bookmanager3.util.AttributeNames;
import com.endava.bookmanager3.util.MappingNames;
import com.endava.bookmanager3.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AwardController {

    private final AwardService awardService;

    @Autowired
    public AwardController(AwardService awardService) {

        this.awardService = awardService;
    }


    @GetMapping(MappingNames.AWARDS)
    public String getAwards(Model model) {

        List<Award> awards = awardService.getAwards();
        model.addAttribute(AttributeNames.AWARDS, awards);
        return ViewNames.AWARDS;
    }


    @GetMapping(MappingNames.VIEW_AWARD)
    public String getAward(@RequestParam Long id, Model model) {

        Award award = awardService.getAwardById(id);

        if (award == null) {
            throw new ResourceNotFoundException("Award", "id", id);
        }

        model.addAttribute(AttributeNames.AWARD, award);
        return ViewNames.VIEW_AWARD;
    }


    @GetMapping(MappingNames.ADD_AWARD)
    public String addEditAward(@RequestParam(required = false, defaultValue = "-1") Long id, Model model) {

        Award award = awardService.getAwardById(id);

        if (award == null) {
            award = new Award();
        }

        model.addAttribute(AttributeNames.AWARD, award);
        return ViewNames.ADD_AWARD;
    }


    @PostMapping(MappingNames.ADD_AWARD)
    public String processAward(@Valid @ModelAttribute(AttributeNames.AWARD) Award award) {

        if (award.getId() == null) {
            awardService.addAward(award);
        } else {
            awardService.updateAward(award);
        }

        return "redirect:/" + MappingNames.AWARDS;
    }


    @GetMapping(MappingNames.DELETE_AWARD)
    public String deleteAward(@RequestParam Long id) {
        awardService.deleteAwardById(id);
        return "redirect:/" + MappingNames.AWARDS;
    }
}
