package com.academy.week3group3final.repository;

import com.academy.week3group3final.model.Employee;
import com.academy.week3group3final.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends PagingAndSortingRepository<Skill, Long> {

    Page<Skill> findByEmployee(Employee employee, Pageable pageable);

}
