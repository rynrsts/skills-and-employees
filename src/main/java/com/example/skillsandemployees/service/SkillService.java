package com.example.skillsandemployees.service;

import com.example.skillsandemployees.dto.SkillDTO;
import com.example.skillsandemployees.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkillService {

    SkillDTO saveSkill(Long employeeId, SkillDTO skillDTO) throws RecordNotFoundException;

    Page<SkillDTO> findAllSkills(Long employeeId, Pageable pageable) throws RecordNotFoundException;

    SkillDTO findSkillById(Long employeeId, Long skillId) throws RecordNotFoundException;

    SkillDTO updateSkill(Long employeeId, Long skillId, SkillDTO skillDTO) throws RecordNotFoundException;

    String deleteSkill(Long employeeId, Long skillId) throws RecordNotFoundException;

}
