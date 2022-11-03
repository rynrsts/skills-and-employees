package com.academy.week3group3final.controller;

import com.academy.week3group3final.exception.RecordNotFoundException;
import com.academy.week3group3final.model.Skill;
import com.academy.week3group3final.model.SkillDTO;
import com.academy.week3group3final.service.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class SkillsController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/{employeeId}/skills")
    public SkillDTO saveSkills(@PathVariable Long employeeId, @RequestBody Skill skill) throws RecordNotFoundException {
        Skill savedSkill = skillService.saveSkill(employeeId, skill);
        return convertToDto(savedSkill);
    }

    // Getting all skills by employee id
    @GetMapping("/{employeeId}/skills")
    public ResponseEntity<Page<SkillDTO>> getSkillsByEmployeeId(
            @PathVariable Long employeeId,
            Pageable pageable
    ) throws RecordNotFoundException {
        Page<Skill> skillPage = skillService.findAllSkills(employeeId, pageable);
        List<SkillDTO> skillDTO = skillPage.stream().map(this::convertToDto).toList();
        Page<SkillDTO> skillDTOPage = new PageImpl<>(skillDTO, pageable, skillDTO.size());
        return new ResponseEntity<>(skillDTOPage, HttpStatus.OK);
    }

    // Getting skill by skill id
    @GetMapping("/{employeeId}/skills/{skillId}")
    public SkillDTO getSkillBySkillId(
            @PathVariable Long employeeId,
            @PathVariable Long skillId
    ) throws RecordNotFoundException {
        Skill skill = skillService.findSkillById(employeeId, skillId);
        return convertToDto(skill);
    }

    @PutMapping("/{employeeId}/skills/{skillId}")
    public SkillDTO updateSkills(
            @PathVariable Long employeeId,
            @PathVariable Long skillId,
            @RequestBody Skill skill
    ) throws RecordNotFoundException, ParseException {
        Skill updateSkill = skillService.updateSkill(employeeId, skillId, skill);
        return convertToDto(updateSkill);
    }

    @DeleteMapping("/{employeeId}/skills/{skillId}")
    public void deleteSkills(
            @PathVariable Long employeeId,
            @PathVariable Long skillId
    ) throws RecordNotFoundException {
        skillService.deleteSkill(employeeId, skillId);
    }

    private SkillDTO convertToDto(Skill skill) {
        SkillDTO skillDTO = modelMapper.map(skill, SkillDTO.class);
        skillDTO.setEmployee_id(skill.getEmployee().getId());
        return skillDTO;
    }

}
