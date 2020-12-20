package com.xl.learnjwt.service;

import com.xl.learnjwt.entity.TestUser;
import org.springframework.stereotype.Service;


public interface TestUserService {
    TestUser loginSvc (TestUser user);
}
