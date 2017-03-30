package org.itstep.myWebApp.service.mock;

import org.itstep.myWebApp.service.UserServiceTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:spring-mock.xml")
public class MockUserServiceTest extends UserServiceTest {

}
