package com.example.skillsandemployees.service;

import com.example.skillsandemployees.dto.SkillDTO;
import com.example.skillsandemployees.exception.RecordNotFoundException;
import com.example.skillsandemployees.mapper.SkillMapper;
import com.example.skillsandemployees.model.Employee;
import com.example.skillsandemployees.model.Skill;
import com.example.skillsandemployees.repository.EmployeeRepository;
import com.example.skillsandemployees.repository.SkillRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillMapper skillMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public SkillDTO saveSkill(Long employeeId, SkillDTO skillDTO) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Skill skill = skillRepository.save(skillMapper.dtoToModel(skillDTO));
        skill.setEmployee(employeeOptional.get());
        return skillMapper.modelToDto(skill);
    }

    @Override
    public Page<SkillDTO> findAllSkills(Long employeeId, Pageable pageable) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        return skillRepository.findByEmployee(employeeOptional.get(), pageable).map(skillMapper::modelToDto);
    }

    @Override
    public SkillDTO findSkillById(Long employeeId, Long skillId) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Optional<Skill> skillOptional = skillRepository.findByEmployeeAndId(employeeOptional.get(), skillId);
        if (skillOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        return skillMapper.modelToDto(skillOptional.get());
    }

    @Override
    public SkillDTO updateSkill(Long employeeId, Long skillId, SkillDTO skillDTO) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Optional<Skill> skillOptional = skillRepository.findByEmployeeAndId(employeeOptional.get(), skillId);
        if (skillOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Skill skill = skillOptional.get();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(skillDTO, skill);
        skillRepository.save(skill);
        return skillMapper.modelToDto(skill);
    }

    @Override
    public String deleteSkill(Long employeeId, Long skillId) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Optional<Skill> skillOptional = skillRepository.findByEmployeeAndId(employeeOptional.get(), skillId);
        if (skillOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        skillRepository.delete(skillOptional.get());
        return "Skill with id " + skillId + " has been deleted";
    }

}
