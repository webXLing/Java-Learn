package com.xl.learnjwt.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Table;

@Data
@Accessors(chain = true)
@Table(name = "pe_permission")
public class PePermission {
    private static final long serialVersionUID = -4990810027542971546L;
    /**
     * 主键
     */
    private String id;
    private String name;
    private String code;
    private String description;
}
