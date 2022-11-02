package com.academy.week3group3final.controller;

import com.academy.week3group3final.exception.RecordNotFoundException;
import com.academy.week3group3final.model.Skill;
import com.academy.week3group3final.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/employees")
public class SkillsController {

    @Autowired
    private SkillService skillService;


    @PostMapping("/{employeeId}/skills")
    public Skill saveSkills(@PathVariable Long employeeId, @RequestBody Skill skill) throws RecordNotFoundException {
        return skillService.saveSkill(employeeId, skill);
    }

    // Getting all skills by employee id
    @GetMapping("/{employeeId}/skills")
    public ResponseEntity<Page<Skill>> getSkillsByEmployeeId(
            @PathVariable Long employeeId,
            Pageable pageable
    ) throws RecordNotFoundException {
        Page<Skill> skill = skillService.findAllSkills(employeeId, pageable);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    // Getting skill by skill id
    @GetMapping("/{employeeId}/skills/{skillId}")
    public Skill getSkillBySkillId(
            @PathVariable Long employeeId,
            @PathVariable Long skillId
    ) throws RecordNotFoundException {
        return skillService.findSkillById(employeeId, skillId);
    }

    @PutMapping("/{employeeId}/skills/{skillId}")
    public Skill updateSkills(
            @PathVariable Long employeeId,
            @PathVariable Long skillId,
            @RequestBody Skill skill
    ) throws RecordNotFoundException, ParseException {
        return skillService.updateSkill(employeeId, skillId, skill);
    }

    @DeleteMapping("/{employeeId}/skills/{skillId}")
    public void deleteSkills(
            @PathVariable Long employeeId,
            @PathVariable Long skillId
    ) throws RecordNotFoundException {
        skillService.deleteSkill(employeeId, skillId);
    }

}
