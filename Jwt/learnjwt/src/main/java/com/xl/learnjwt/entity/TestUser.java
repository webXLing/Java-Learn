package com.xl.learnjwt.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TestUser {
    private int id;
    private String username;
    private String password;
}
