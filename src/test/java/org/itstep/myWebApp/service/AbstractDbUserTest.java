package org.itstep.myWebApp.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml"})
@Sql(scripts = "classpath:db/initDB.sql")
public abstract class AbstractDbUserTest extends UserServiceTest {

}
