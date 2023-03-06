package com.example.skillsandemployees.model;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class Audit {

    @CreatedBy
    @Getter(AccessLevel.NONE)
    private String createdBy;

    @CreatedDate
    private Date createdAt;

    @LastModifiedBy
    @Getter(AccessLevel.NONE)
    private String modifiedBy;

    @LastModifiedDate
    private Date modifiedAt;

}
