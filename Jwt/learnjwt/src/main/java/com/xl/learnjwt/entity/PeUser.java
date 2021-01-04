package com.xl.learnjwt.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.util.List;

@Data
@Accessors(chain = true)
@Table(name = "pe_user")
public class PeUser {
    private String id;
    private String username;
    private String password;

    private List<PeRole> roles;
    private List<PePermission> permissionList;

}
