package com.example.skillsandemployees.mapper;

import com.example.skillsandemployees.dto.SkillDTO;
import com.example.skillsandemployees.model.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    Skill dtoToModel(SkillDTO skillDTO);

    SkillDTO modelToDto(Skill skill);

}
