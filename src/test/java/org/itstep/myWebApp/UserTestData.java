package org.itstep.myWebApp;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.model.User;

import java.time.LocalDateTime;

public class UserTestData {

    public static final User USER_1 = new User(1, "nick", "dalas", "dnipro", "user@gmail.com");
    public static final User USER_2 = new User(2, "angela", "hike", "kyiv", "ang@yahoo.com");
    public static final User USER_3 = new User(3, "asd", "ads", "asd", "asd@asd.com");
    public static final User USER_4 = new User("111", "111", "111", "111@asd.com");

    public static final Mail MAIL_1 = new Mail(5, "m", "t", "to", LocalDateTime.now(), 16);

}
