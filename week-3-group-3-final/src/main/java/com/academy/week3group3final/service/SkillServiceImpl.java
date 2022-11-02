package com.academy.week3group3final.service;

import com.academy.week3group3final.exception.RecordNotFoundException;
import com.academy.week3group3final.model.Employee;
import com.academy.week3group3final.model.Skill;
import com.academy.week3group3final.repository.EmployeeRepository;
import com.academy.week3group3final.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private SkillRepository skillRepo;


    @Override
    public Skill saveSkill(Long employeeId, Skill skill) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            skill.setEmployee(employee);
            return skillRepo.save(skill);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Page<Skill> findAllSkills(Long employeeId, Pageable pageable) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isPresent()) {
            return skillRepo.findByEmployee(employeeOptional.get(), pageable);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Skill findSkillById(Long employeeId, Long skillId) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            throw new RecordNotFoundException();
        }
        Optional<Skill> skillOptional = skillRepo.findById(skillId);
        if (skillOptional.isEmpty()) {
            throw new RecordNotFoundException();
        }
        return skillOptional.get();
    }

    @Override
    public Skill updateSkill(
            Long employeeId,
            Long skillId,
            Skill newSkill
    ) throws RecordNotFoundException, ParseException {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            throw new RecordNotFoundException();
        }
        Optional<Skill> skillOptional = skillRepo.findById(skillId);
        if (skillOptional.isEmpty()) {
            throw new RecordNotFoundException();
        }
        Skill skill = skillOptional.get();
        skill.setDescription(newSkill.getDescription());
        skill.setDuration(newSkill.getDuration());
        skill.setLastUsed(newSkill.getLastUsed());
        return skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(Long skillId, Long employeeId) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            throw new RecordNotFoundException();
        }
        Optional<Skill> skillOptional = skillRepo.findById(skillId);
        if (skillOptional.isEmpty()) {
            throw new RecordNotFoundException();
        }
        Skill skill = skillOptional.get();
        skillRepo.delete(skill);
    }

}
