package com.academy.week3group3final.service;

import com.academy.week3group3final.exception.RecordNotFoundException;
import com.academy.week3group3final.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;

public interface SkillService {

    Skill saveSkill(Long employeeId, Skill skill) throws RecordNotFoundException;

    Page<Skill> findAllSkills(Long employeeId, Pageable pageable) throws RecordNotFoundException;

    Skill findSkillById(Long employeeId, Long skillId) throws RecordNotFoundException;

    Skill updateSkill(Long skillId, Long employeeId, Skill newSkill) throws RecordNotFoundException, ParseException;

    void deleteSkill(Long skillId, Long employeeId) throws RecordNotFoundException;

}
