package com.example.skillsandemployees.dto;

import com.example.skillsandemployees.model.Audit;

import java.util.Date;

public class SkillDTO extends Audit {

    private Long id;
    private String description;
    private int duration;
    private Date lastUsed;

}
