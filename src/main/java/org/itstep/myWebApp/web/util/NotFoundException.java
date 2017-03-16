package org.itstep.myWebApp.web.util;

/**
 * Created by student on 16.03.2017.
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
