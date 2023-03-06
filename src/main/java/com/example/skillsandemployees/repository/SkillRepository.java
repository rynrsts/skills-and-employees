package com.example.skillsandemployees.repository;

import com.example.skillsandemployees.model.Employee;
import com.example.skillsandemployees.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Page<Skill> findByEmployee(Employee employee, Pageable pageable);
    Optional<Skill> findByEmployeeAndId(Employee employee, Long skillId);

}
