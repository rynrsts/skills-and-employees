package com.example.skillsandemployees.controller;

import com.example.skillsandemployees.dto.SkillDTO;
import com.example.skillsandemployees.exception.RecordNotFoundException;
import com.example.skillsandemployees.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;


    @PostMapping("/{employeeId}")
    public ResponseEntity<SkillDTO> saveSkill(@PathVariable Long employeeId, @RequestBody SkillDTO skillDTO)
            throws RecordNotFoundException {
        return new ResponseEntity<>(skillService.saveSkill(employeeId, skillDTO), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Page<SkillDTO>> getAllSkills(@PathVariable Long employeeId, Pageable pageable)
            throws RecordNotFoundException {
        return new ResponseEntity<>(skillService.findAllSkills(employeeId, pageable), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}/{skillId}")
    public ResponseEntity<SkillDTO> getSkillById(@PathVariable Long employeeId, @PathVariable Long skillId)
            throws RecordNotFoundException {
        return new ResponseEntity<>(skillService.findSkillById(employeeId, skillId), HttpStatus.OK);
    }

    @PatchMapping("/{employeeId}/{skillId}")
    public ResponseEntity<SkillDTO> updateSkill(
            @PathVariable Long employeeId,
            @PathVariable Long skillId,
            @RequestBody SkillDTO skillDTO
    ) throws RecordNotFoundException, ParseException {
        return new ResponseEntity<>(skillService.updateSkill(employeeId, skillId, skillDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}/{skillId}")
    public ResponseEntity<String> deleteSkill(@PathVariable Long employeeId, @PathVariable Long skillId)
            throws RecordNotFoundException {
        return new ResponseEntity<>(skillService.deleteSkill(employeeId, skillId), HttpStatus.OK);
    }

}
