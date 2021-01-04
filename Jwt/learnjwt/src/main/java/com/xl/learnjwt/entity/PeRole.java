package com.xl.learnjwt.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Table;

@Data
@Accessors(chain = true)
@Table(name = "pe_role")
public class PeRole {
    private static final long serialVersionUID = 594829320797158219L;
    private String id;
    private String name;
    private String description;
}
